(ns pl.tomaszgigiel.quizzes.packs.joc.joc-07-04-test
  (:require [clojure.test :as tst])
  (:require [uncomplicate.fluokitten.core :as fluokitten])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is A* pathfinding?")
  (a "pronounced A-star")
  (a "a best-first pathfinding algorithm")
  (a"maintains a set of candidate paths through a world with the purpose of finding the least-difficult path to some goal")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4. Putting it all together: A* pathfinding")
  (m "https://en.wikipedia.org/wiki/A*_search_algorithm"))

(qam
  (q "How to represent a world in A* pathfinding?")
  (a (def world [[  1   1   1   1    1]
                 [999 999 999 999    1]
                 [  1   1   1   1    1]
                 [  1 999 999 999  999]
                 [  1   1   1   1    1]]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.1. The world"))

(qam
  (q "How to find the neighbors of a spot on a 2D matrix?")
  (a (defn neighbors
       ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]] size yx))
       ([deltas size yx] (filter
                           (fn [new-yx] (every? #(< -1 % size) new-yx))
                           (map #(vec (map + yx %)) deltas)))))
  (a (= (neighbors 5 [0 0]) [[1 0] [0 1]]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.2. Neighbors"))

(qam
  (q "How to estimate the straight-line remaining path cost?")
  (a "typically called h")
  (a (defn estimate-cost [step-cost-est size y x] (* step-cost-est (- (+ size size) y x 2))))
  (a (= (estimate-cost 100 5 0 0) 800))
  (a (= (estimate-cost 100 5 4 4) 0))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.2. Neighbors"))

(qam
  (q "How to calculate the cost of the path traversed so far?")
  (a "typically called g")
  (a (defn path-cost [node-cost cheapest-nbr] (+ node-cost (or (:cost cheapest-nbr) 0))))
  (a (= (path-cost 100 {:cost 1}) 101))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.2. Neighbors"))

(defn estimate-cost [step-cost-est size y x] (* step-cost-est (- (+ size size) y x 2)))
(defn path-cost [node-cost cheapest-nbr] (+ node-cost (or (:cost cheapest-nbr) 0)))

(qam
  (q "How to calculate the estimated total cost of the path?")
  (a "typically called f  and implemented as (+ (g ...) (h ...))")
  (a (defn total-cost [newcost step-cost-est size y x]
       (+ newcost (estimate-cost step-cost-est size y x))))
  (a (= (total-cost 0 100 5 0 0) 800))
  (a (= (total-cost 1000 200 5 3 4) 1200))
  (a (= (total-cost (path-cost 100 {:cost 1}) 100 5 3 4) 201))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.2. Neighbors"))

(qam
  (q "How to retrieve the minimum value based on a criteria function?")
  (a (defn min-by [f coll]
       (when (seq coll) (reduce (fn [min other] (if (> (f min) (f other)) other min)) coll))))
  (a (= (min-by :cost [{:cost 100} {:cost 36} {:cost 9}]) {:cost 9}))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.3. The A* implementation"))

(qam
  (q "How to implement A* algorithm?")
  (a (defn astar [start-yx step-est cell-costs]
       (let [size (count cell-costs)]
         (loop [steps 0
                routes (vec (replicate size (vec (replicate size nil))))
                work-todo (sorted-set [0 start-yx])]
           (if (empty? work-todo)
             [(peek (peek routes)) :steps steps] 
             (let [[_ yx :as work-item] (first work-todo)
                   rest-work-todo (disj work-todo work-item) 
                   nbr-yxs (neighbors size yx)
                   cheapest-nbr (min-by :cost (keep #(get-in routes %) nbr-yxs))
                   newcost (path-cost (get-in cell-costs yx) cheapest-nbr)
                   oldcost (:cost (get-in routes yx))]
               (if (and oldcost (>= newcost oldcost))
                 (recur (inc steps) routes rest-work-todo)
                 (recur (inc steps)
                        (assoc-in routes yx {:cost newcost :yxs (conj (:yxs cheapest-nbr []) yx)})
                        (into rest-work-todo (map (fn [w] (let [[y x] w] [(total-cost newcost step-est size y x) w])) nbr-yxs))))))))))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.3. The A* implementation"))

(def world [[  1   1   1   1    1]
                 [999 999 999 999    1]
                 [  1   1   1   1    1]
                 [  1 999 999 999  999]
                 [  1   1   1   1    1]])

(defn neighbors
       ([size yx] (neighbors [[-1 0] [1 0] [0 -1] [0 1]] size yx))
       ([deltas size yx] (filter
                           (fn [new-yx] (every? #(< -1 % size) new-yx))
                           (map #(vec (map + yx %)) deltas))))

(defn total-cost [newcost step-cost-est size y x]
       (+ newcost (estimate-cost step-cost-est size y x)))

(defn min-by [f coll]
       (when (seq coll) (reduce (fn [min other] (if (> (f min) (f other)) other min)) coll)))

(defn astar [start-yx step-est cell-costs]
       (let [size (count cell-costs)]
         (loop [steps 0
                routes (vec (replicate size (vec (replicate size nil))))
                work-todo (sorted-set [0 start-yx])]
           (if (empty? work-todo)
             [(peek (peek routes)) :steps steps] 
             (let [[_ yx :as work-item] (first work-todo)
                   rest-work-todo (disj work-todo work-item) 
                   nbr-yxs (neighbors size yx)
                   cheapest-nbr (min-by :cost (keep #(get-in routes %) nbr-yxs))
                   newcost (path-cost (get-in cell-costs yx) cheapest-nbr)
                   oldcost (:cost (get-in routes yx))]
               (if (and oldcost (>= newcost oldcost))
                 (recur (inc steps) routes rest-work-todo)
                 (recur (inc steps)
                        (assoc-in routes yx {:cost newcost :yxs (conj (:yxs cheapest-nbr []) yx)})
                        (into rest-work-todo (map (fn [w] (let [[y x] w] [(total-cost newcost step-est size y x) w])) nbr-yxs)))))))))

(qam
  (q "Show an example of the result of function astar.")
  (a (= (astar [0 0] 100 world)
        [{:cost 17
          :yxs [[0 0] [0 1] [0 2] [0 3] [0 4] [1 4] [2 4] [2 3] [2 2] [2 1] [2 0] [3 0] [4 0] [4 1] [4 2] [4 3] [4 4]]}
         :steps 81]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.3. The A* implementation"))

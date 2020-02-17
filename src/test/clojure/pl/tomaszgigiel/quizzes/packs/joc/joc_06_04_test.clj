(ns pl.tomaszgigiel.quizzes.packs.joc.joc-06-04-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Implement rand-ints 10): (0 1 5 7 3 5 6 4 9 0)")
  (a (defn rand-ints [n] (take n (repeatedly #(rand-int n)))))
  (a (= (-> 10 rand-ints count) 10))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.4. Putting it all together: a lazy quicksort"))

(qam
  (q "Explain list*")
  (a (= (list* 1 2 [3 4]) [1 2 3 4]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.4. Putting it all together: a lazy quicksort"))

(qam
  (q "Implement quicksort.")
  (a (defn sort-parts [work]
       (lazy-seq
         (loop [[part & parts] work]
           (if-let [[pivot & xs] (seq part)]
             (let [smaller? #(< % pivot)] (recur (list* (filter smaller? xs) pivot (remove smaller? xs) parts)))
             (when-let [[x & parts] parts] (cons x (sort-parts parts))))))))
  (a (defn qsort [xs] (sort-parts (list xs))))
  (a (= (qsort [2 1 4 3]) [1 2 3 4]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.4. Putting it all together: a lazy quicksort"))

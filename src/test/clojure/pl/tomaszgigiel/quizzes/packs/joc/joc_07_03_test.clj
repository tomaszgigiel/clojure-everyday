(ns pl.tomaszgigiel.quizzes.packs.joc.joc-07-03-test
  (:require [clojure.test :as tst])
  (:require [uncomplicate.fluokitten.core :as fluokitten])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is a mundane recursion?")
  (a "also linear recursion")
  (a "because it is named explicitly")
  (a "rather than through mutual recursion")
  (a "or implicitly with the recur special form")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Discuss a linear recursion.")
  (a "the space requirement is proportional to the magnitude of the input")
  (a "java.lang.StackOverflowError")
  (a "use tail recursion")
  (a "use linear with lazy-seq")
  (a "use functional programming (e.g. reduce)")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Implement Math.pow using mundane resursion.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (== (pow-mundane 2 3) (Math/pow 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Example of converting mundane recursion to tail recursion.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (defn pow-tail-recursion [x n]
       (letfn [(pow-tail-recursion [x n acc] (if (zero? n) acc (recur x (dec n) (* x acc))))]
         (pow-tail-recursion x n 1))))
  (a (== (Math/pow 2 3) (pow-mundane 2 3) (pow-tail-recursion 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Example of converting mundane recursion to mundane recursion with lazy-seq.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (defn pow-lazy-seq [x n]
       (letfn [(multiply [a factor] (lazy-seq (cons a (multiply (* a factor) factor))))]
         (nth (multiply x x) (dec n)))))
  (a (== (Math/pow 2 3) (pow-mundane 2 3) (pow-lazy-seq 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 156"))

(qam
  (q "Implement convert.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (defn pow-lazy-seq [x n]
       (letfn [(multiply [a factor] (lazy-seq (cons a (multiply (* a factor) factor))))]
         (nth (multiply x x) (dec n)))))
  (a (== (Math/pow 2 3) (pow-mundane 2 3) (pow-lazy-seq 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 156"))

(defn convert [context descriptor]
  (reduce (fn [result [mag unit]] (+ result (let [val (get context unit)]
                                              (if (vector? val)
                                                (* mag (convert context val))
                                                (* mag val)))))
          0
          calculation
  (partition 2 descriptor)))

(float (convert simple-metric [3 :km 10 :meter 80 :cm 10 :mm]))
(convert {:bit 1, :byte 8, :nibble [1/2 :byte]} [32 :nibble])

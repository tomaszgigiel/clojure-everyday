(ns pl.tomaszgigiel.quizzes.packs.clojure-exponentiation-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:require [clojure.math.numeric-tower :as math]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "List the ways to implement exponentiation.")
  (a "1. mundane recursion")
  (a "2. tail recursion")
  (a "3. mundane recursion with lazy-seq")
  (a "4. functional programming (reduce)")
  (a "5. exponentiation by squaring")
  (a "6. clojure.math.numeric-tower")
  (m "https://stackoverflow.com/questions/2795587/lazy-sequence-or-recur-for-mathematical-power-function")
  (m "https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure")
  (m "https://stackoverflow.com/questions/101439/the-most-efficient-way-to-implement-an-integer-based-power-function-powint-int")
  (m "https://en.wikipedia.org/wiki/Exponentiation_by_squaring")
  (m "https://github.com/clojure/math.numeric-tower"))

(defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n)))))
(defn pow-tail-recursion [x n] (letfn [(inner [x n acc] (if (zero? n) acc (recur x (dec n) (* x acc))))] (inner x n 1)))
(defn pow-lazy-seq [x n] (letfn [(multiply [a factor] (lazy-seq (cons a (multiply (* a factor) factor))))] (nth (multiply x x) (dec n))))
(defn pow-reduce [x n] (reduce * (repeat n x)))
(defn pow-by-squaring [x n] (let [inner (fn [a b n]
                                               (cond
                                                 (zero? 0) a
                                                 (even? n) (recur a (* b b) (/ n 2))
                                                 :else (recur (* a b) b (- n 1))))]
                                   (inner 1 x n)))

(qam
  (q "Implement exponentiation using mundane resursion.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (== (pow-mundane 2 3) (Math/pow 2 3))))

(qam
  (q "Implement exponentiation using tail resursion.")
  (a (defn pow-tail-recursion [x n] (letfn [(pow-tail-recursion [x n acc] (if (zero? n) acc (recur x (dec n) (* x acc))))] (pow-tail-recursion x n 1))))
  (a (== (pow-tail-recursion 2 3) (Math/pow 2 3))))

(qam
  (q "Implement exponentiation using mundane recursion with lazy-seq.")
  (a (defn pow-lazy-seq [x n] (letfn [(multiply [a factor] (lazy-seq (cons a (multiply (* a factor) factor))))] (nth (multiply x x) (dec n)))))
  (a (== (pow-lazy-seq 2 3) (Math/pow 2 3))))

(qam
  (q "Implement exponentiation using functional programming (reduce).")
  (a (defn pow-reduce [x n] (reduce * (repeat n x))))
  (a (== (pow-reduce 2 3) (Math/pow 2 3))))

(qam
  (q "Implement exponentiation using exponentiation by squaring.")
  (a (defn pow-by-squaring [x n] (let [inner (fn [a b n]
                                               (cond
                                                 (= n 0) a
                                                 (even? n) (recur a (* b b) (/ n 2))
                                                 :else (recur (* a b) b (- n 1))))]
                                   (inner 1N x n))))
  (a (== (pow-by-squaring 2 3) (Math/pow 2 3))))

(qam
  (q "Implement exponentiation using clojure.math.numeric-tower.")
  (a "[org.clojure/math.numeric-tower \"0.0.4\"]")
  (a "(:require [clojure.math.numeric-tower :as math])")
  (a (== (math/expt 2 3) (Math/pow 2 3))))

(qam
  (q "Discuss the performance of different ways to implement exponentiation.")
  (at (pow-mundane 2N 10000) StackOverflowError)
  (a (< (misc/time-msecs (dotimes [_ 100] (pow-by-squaring 2N 10000))) (misc/time-msecs (dotimes [_ 100] (pow-reduce 2N 10000)))))
  (a "exponentiation by squaring (also math/expt) is the fastest")
  (a "other similar but much slower"))

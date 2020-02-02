(ns pl.tomaszgigiel.quizzes.packs.clojure-exponentiation-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Discuss exponentiation.")
  (a false)
  (m ""))

; https://stackoverflow.com/questions/2795587/lazy-sequence-or-recur-for-mathematical-power-function
; https://stackoverflow.com/questions/5057047/how-to-do-exponentiation-in-clojure

(defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n)))))
(pow-mundane 2N 10000)

(defn pow-reduce [x n] (reduce * (repeat n x)))
(time (dotimes [_ 100] (pow-reduce 2N 10000)))

(defn pow-tail-recursion [x n] (letfn [(pow-tail-recursion [x n acc] (if (zero? n) acc (recur x (dec n) (* x acc))))] (pow-tail-recursion x n 1)))
(time (dotimes [_ 100] (pow-tail-recursion 2N 10000)))

(defn pow-lazy-seq [x n]
  (letfn [(multiply [a factor] (lazy-seq (cons a (multiply (* a factor) factor))))]
    (nth (multiply x x) (dec n))))
(time (dotimes [_ 100] (pow-lazy-seq 2N 10000)))

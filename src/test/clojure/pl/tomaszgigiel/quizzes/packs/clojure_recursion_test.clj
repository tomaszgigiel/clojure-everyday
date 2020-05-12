(ns pl.tomaszgigiel.quizzes.packs.clojure-recursion-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:require [clojure.math.numeric-tower :as math]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

; https://clojuredocs.org/clojure.core/trampoline
; https://clojuredocs.org/clojure.core/recur

(defn pow-tail-recur [x n] (letfn [(inner [x n acc] (if (zero? n) acc (recur x (dec n) (* x acc))))] (inner x n 1)))
(defn pow-tail [x n] (letfn [(inner [x n acc] (if (zero? n) acc (inner x (dec n) (* x acc))))] (inner x n 1)))
(defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n)))))

(pow-tail-recur 12 2)
(pow-tail 12 2)
(pow-mundane 12 2)

(ns pl.tomaszgigiel.quizzes.quiz-man-or-boy-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is man or boy test?")
  (a "proposed by Donald Knuth")
  (a "to distinguish compilers that correctly implemented recursion and non-local references from those that did not")
  (m "https://rosettacode.org/wiki/Man_or_boy_test")
  (m "https://rosettacode.org/wiki/Man_or_boy_test#Clojure"))

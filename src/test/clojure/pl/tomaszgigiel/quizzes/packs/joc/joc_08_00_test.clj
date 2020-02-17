(ns pl.tomaszgigiel.quizzes.packs.joc.joc-08-00-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "List times of Clojure.")
  (a "read time")
  (a "macro-expansion time")
  (a "compile time")
  (a "runtime")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8. Macros"))

(qam
  (q "What kinds of problems do macros solve?")
  (a "to transform an expression into something else, before runtime")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8. Macros"))

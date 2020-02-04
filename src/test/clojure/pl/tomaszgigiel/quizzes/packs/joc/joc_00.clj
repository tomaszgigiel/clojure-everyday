(ns pl.tomaszgigiel.quizzes.packs.joc.joc-00-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "what is the best book to learn clojure?")
  (a "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd")
  (a "https://livebook.manning.com/book/the-joy-of-clojure-second-edition/"))

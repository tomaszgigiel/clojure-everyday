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
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Implement Math pow using mundane resursion.")
  (a (defn pow [base exp] (if (zero? exp) 1(* base (pow base (dec exp))))))
  (a (== (pow 2 3) (Math/pow 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

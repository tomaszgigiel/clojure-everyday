(ns pl.tomaszgigiel.quizzes.quiz-joc-07-02-test
  (:require [clojure.test :as tst])
  (:require [uncomplicate.fluokitten.core :as fluokitten])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Example of a closure.")
  (a (def times-two (let [x 2] (fn [y] (* y x)))))
  (a (= (times-two 5) 10))
  (a "it uses the local x that was defined outside the body of the function")
  (a "the local and its value become a property of the function itself")
  (a "the function closes over the local x")  
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 148"))

(qam
  (q "What is a free variable?")
  (a "also non-local")
  (a "a variable used in a function that is neither a local variable nor parameter of that function")
  (a "a global variable is a free variable")
  (a "but not necessarily the other way around (e.g. nested functions)")
  (m "https://en.wikipedia.org/wiki/Free_variables_and_bound_variables")
  (m "https://en.wikipedia.org/wiki/Non-local_variable"))

(qam
  (q "Example of a function that closes over something mutable.")
  (q "Example of a closure over something mutable.")
  (a "impure function")
  (a (def add-and-get (let [ai (java.util.concurrent.atomic.AtomicInteger.)] (fn [y] (.addAndGet ai y)))))
  (a (= (add-and-get 1) 1))
  (a (= (add-and-get 2) 3))
  (a (= (add-and-get 3) 6))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 149"))

(qam
  (q "Example of a function returning closure.")
  (a (defn times-n [n] (let [x n] (fn [y] (* y x)))))
  (a (def times-four (times-n 4)))
  (a (= (times-four 10) 40))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 149"))

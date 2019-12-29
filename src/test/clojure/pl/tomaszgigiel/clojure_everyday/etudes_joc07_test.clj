(ns pl.tomaszgigiel.clojure-everyday.etudes-joc07-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.clojure-everyday.etudes :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is at the core of functional programming?")
  (a true "At the core of functional programming is a formal system of computation known as the lambda calculus."))

(qam
  (q "What is the lambda calculus?")
  (a false "https://en.wikipedia.org/wiki/Lambda_calculus"))

(qam
  (q "Show that complex types are functions of their elements.")
  (a (= ([:a :b] 0) :a) "vector is a function, index 0 is an argument")
  (a (= (map [:a :b :c :d :e] [0 2 4]) [:a :c :e]) "passing a vector as a function argument")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 136"))

(qam
  (q "What is a first-class citizen?")
  (a true "A first-class citizen is an entity which supports all the operations generally available to other entities.")
  (m "https://en.wikipedia.org/wiki/First-class_citizen"))

(qam
  (q "What can be a first-class citizen?")
  (a true "1. type")
  (a true "2. object")
  (a true "3. entity")
  (a true "4. value")
  (a true "5. function")
  (m "https://en.wikipedia.org/wiki/First-class_citizen"))

(qam
  (q "What properties does a first-class citizen have?")
  (q "What operations are available for a first-class citizen?")
  (a true "1. can be passed as an argument")
  (a true "2. can be returned as a result")
  (a true "3. can be assigned to a variable and stored in a data structure")
  (a true "4. can be created and modified at run time")
  (a true "5. can be tested for equality and identity (has an identity)")
  (a true "6. can be not bound to an identifier (i.e. an anonymous function)")
  (m "https://en.wikipedia.org/wiki/First-class_citizen")
  (m "https://pl.wikipedia.org/wiki/Typ_pierwszoklasowy")
  (m "https://en.wikipedia.org/wiki/Anonymous_function"))

(qam
  (q "What is an anonymous function?")
  (a true "other: function literal, lambda abstraction, or lambda expression")
  (a true "a function definition that is not bound to an identifier")
  (m "https://en.wikipedia.org/wiki/Anonymous_function"))

(qam
  (q "What is a higher-order function?")
  (a true "a function that does at least one of the following:")
  (a true "takes one or more functions as arguments (i.e. procedural parameters)")
  (a true "returns a function as its result")
  (m "https://en.wikipedia.org/wiki/Higher-order_function"))

(qam
  (q "What is a first-order function?")
  (a true "a function that is not a higher-order function")
  (m "https://en.wikipedia.org/wiki/Higher-order_function"))

(qam
  (q "What are the characteristics of a functional programming language?")
  (a true "pure functions")
  (a true "first-class functions")
  (a true "higher-order functions")
  (a true "function composition")
  (a true "typeclasses")
  (a true "lambdas")
  (a true "closures")
  (a true "immutability")
  (a true "recursion")
  (a true "manipulation of lists")
  (a true "lazy evaluation")
  (a false "verify, organize")
  (m "https://en.wikipedia.org/wiki/Functional_programming"))

(qam
  (q "What is a first-class function?")
  (a false "")
  (m "https://en.wikipedia.org/wiki/First-class_function"))

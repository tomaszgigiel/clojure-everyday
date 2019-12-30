(ns pl.tomaszgigiel.clojure-everyday.etudes-joc07-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.clojure-everyday.etudes :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is at the core of functional programming?")
  (a "At the core of functional programming is a formal system of computation known as the lambda calculus."))

(qam
  (q "What is the lambda calculus?")
  (a false "todo")
  (m "https://en.wikipedia.org/wiki/Lambda_calculus"))

(qam
  (q "Show that complex types are functions of their elements.")
  (a (= ([:a :b] 0) :a) "vector is a function, index 0 is an argument")
  (a (= (map [:a :b :c :d :e] [0 2 4]) [:a :c :e]) "passing a vector as a function argument")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 136"))

(qam
  (q "What is a first-class citizen?")
  (a "A first-class citizen is an entity which supports all the operations generally available to other entities.")
  (m "https://en.wikipedia.org/wiki/First-class_citizen"))

(qam
  (q "What can be a first-class citizen?")
  (a "1. type")
  (a "2. object")
  (a "3. entity")
  (a "4. value")
  (a "5. function")
  (m "https://en.wikipedia.org/wiki/First-class_citizen"))

(qam
  (q "What properties does a first-class citizen have?")
  (q "What operations are available for a first-class citizen?")
  (a "1. can be passed as an argument")
  (a "2. can be returned as a result")
  (a "3. can be assigned to a variable and stored in a data structure")
  (a "4. can be created and modified at run time")
  (a "5. can be tested for equality and identity (has an identity)")
  (a "6. can be not bound to an identifier (i.e. an anonymous function)")
  (m "https://en.wikipedia.org/wiki/First-class_citizen")
  (m "https://pl.wikipedia.org/wiki/Typ_pierwszoklasowy")
  (m "https://en.wikipedia.org/wiki/Anonymous_function"))

(qam
  (q "What is an anonymous function?")
  (a "other: function literal, lambda abstraction, or lambda expression")
  (a "a function definition that is not bound to an identifier")
  (m "https://en.wikipedia.org/wiki/Anonymous_function"))

(qam
  (q "What is a higher-order function?")
  (a "a function that does at least one of the following:")
  (a "takes one or more functions as arguments (i.e. procedural parameters)")
  (a "returns a function as its result")
  (m "https://en.wikipedia.org/wiki/Higher-order_function"))

(qam
  (q "What is a first-order function?")
  (a "a function that is not a higher-order function")
  (m "https://en.wikipedia.org/wiki/Higher-order_function"))

(qam
  (q "What are the characteristics of a functional programming language?")
  (a "pure functions")
  (a "first-class functions")
  (a "higher-order functions")
  (a "function composition")
  (a "typeclasses")
  (a "lambdas")
  (a "closures")
  (a "immutability")
  (a "recursion")
  (a "manipulation of lists")
  (a "lazy evaluation")
  (a false "verify, organize")
  (m "https://en.wikipedia.org/wiki/Functional_programming"))

(qam
  (q "What is a first-class function?")
  (a "The first-class function is a feature of the programming language.")
  (a "A programming language is said to have first-class functions if it treats functions as first-class citizens.")
  (a "The first-class function is a first-class citizen.")
  (m "https://en.wikipedia.org/wiki/First-class_function"))

(qam
  (q "Create function on demand using composition.")
  (a (= ((def third (comp first rest rest)) [1 2 3]) 3) "built from existing parts using the comp (compose) function")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 137"))

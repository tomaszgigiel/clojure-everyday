(ns pl.tomaszgigiel.quizzes.packs.joc.joc-06-01-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What are the basic maxims supporting functional programming?")
  (a "immutability")
  (a "laziness")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6. Being lazy and set in your ways"))

(qam
  (q "What is the first principle of immutability?")
  (a "all the possible properties of immutable objects are defined at the time of their construction")
  (a "and can't be changed thereafter")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.1. What is immutability?"))

(qam
  (q "How to create immutable class in Java?")
  (a "do not provide methods that modify the state")
  (a "prevent subclasses from compromising the immutable behavior")
  (a "ensure exclusive access to any mutable components")
  (a "final class or private constructor")
  (a "private fields, final fields, no setters, defensive copying")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.1. What is immutability?")
  (m "https://stackoverflow.com/questions/20768943/how-to-create-immutable-class-in-java/"))

(qam
  (q "What is immutability for?")
  (a "Invariants")
  (a "Reasoning")
  (a "Equality has meaning")
  (a "Sharing is cheap")
  (a "Flattening the levels of indirection")
  (a "Immutability fosters concurrent programming")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

(qam
  (q "How does immutability support invariant-based programming?")
  (a "invariants are defined solely within the construction mechanism")
  (a "it can never be violated because the object is immutable")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

(qam
  (q "How does immutability support reasoning?")
  (a "the set of possible states and transitions is constrained")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

(qam
  (q "How does immutability support equality?")
  (a "objects are equal always or never")
  (a "no matter time, concurrency")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

(qam
  (q "How does immutability support sharing?")
  (a "sharing is cheap")
  (a "based on a reference")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

(qam
  (q "How does immutability support flattening the levels of indirection?")
  (a "Java: mutable reference point to mutable data")
  (a "Clojure: mutable reference point to immutable data")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

(qam
  (q "How does immutability foster concurrent programming?")
  (a "immutable objects are always thread safe")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.1.2. What is immutability for?"))

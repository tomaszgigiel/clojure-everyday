(ns pl.tomaszgigiel.quizzes.packs.functional-programming-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is a programming paradigm?")
  (a "a way to classify programming languages based on their features")
  (a "an approach to computer programming")
  (a "a style of building the computer programs")
  (m "https://en.wikipedia.org/wiki/Programming_paradigm"))

(qam
  (q "What is a functional programming?")
  (a "a programming paradigm")
  (a "constructing programs using only pure functions")
  (m " Paul Chiusano, Runar Bjarnason: Functional Programming in Scala, 1nd, page 1"))

(qam
  (q "What is at the core of functional programming?")
  (a "the lambda calculus")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 136"))

(qam
  (q "What is the lambda calculus?")
  (a "1. also written as λ-calculus")
  (a "2. a formal system in mathematical logic")
  (a "3. for expressing computation")
  (a "4. based on function abstraction and application")
  (a "5. using variable binding and substitution")
  (a "6. is Turing complete")
  (m "https://en.wikipedia.org/wiki/Lambda_calculus"))

(qam
  (q "What is a first-class citizen?")
  (a "an entity which supports all the operations generally available to other entities")
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
  (a "6. need not be associated with an identifier (e.g. an anonymous function)")
  (m "https://en.wikipedia.org/wiki/First-class_citizen")
  (m "https://pl.wikipedia.org/wiki/Typ_pierwszoklasowy")
  (m "https://en.wikipedia.org/wiki/Anonymous_function"))

(qam
  (q "What is an anonymous function?")
  (a "also: function literal, lambda abstraction, lambda expression")
  (a "a function definition that is not bound to an identifier")
  (m "https://en.wikipedia.org/wiki/Anonymous_function"))

(qam
  (q "What is a higher-order function?")
  (a "a function that does at least one of the following:")
  (a "1. takes one or more functions as arguments")
  (a "2. returns a function as a result")
  (m "https://en.wikipedia.org/wiki/Higher-order_function")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 140"))

(qam
  (q "What is a first-order function?")
  (a "a function that is not a higher-order function")
  (m "https://en.wikipedia.org/wiki/Higher-order_function"))

(qam
  (q "What is specific to the functional programming language?")
  (a " 1. pure functions")
  (a " 2. first-class functions")
  (a " 3. higher-order functions")
  (a " 4. referential transparency")
  (a " 5. immutability")
  (a " 6. function composition")
  (a " 7. typeclasses")
  (a " 8. lambdas")
  (a " 9. closures")
  (a "20. recursion")
  (a "21. manipulation of lists")
  (a "22. lazy evaluation")
  (m "https://en.wikipedia.org/wiki/Functional_programming"))

(qam
  (q "What is a typeclass?")
  (a "1. a type system construct that supports parametric polymorphism")
  (a "2. a kind of  Java interfaces, only better")
  (a "3. in Scala typeclasses are defined as traits with a type parameter and functions for the type")
  (a "4. Clojure is dynamic, so there is no typeclass")
  (a "5. Clojure supports polymorphism in several ways")
  (m "https://en.wikipedia.org/wiki/Type_class")
  (m "https://stackoverflow.com/questions/22040115/what-are-the-reasons-that-protocols-and-multimethods-in-clojure-are-less-powerfu"))

(qam
  (q "What type of polymorphism does Clojure support?")
  (a "1. ad-hoc polymorphism: multimethods, protocols, function overloading, function overriding")
  (a "2. parametric polymorphism: HOF")
  (a "3. inclusive/subtype polymorphism: type coercion, protocols")
  (a "4. prototype-based polymorphism: custom dynamic OO system, functions inside maps or records, merge")
  (a "5. inheritance polymorphism: proxy")
  (a "6. type-based polymorphism: protocols")
  (m "https://en.wikipedia.org/wiki/Polymorphism_(computer_science)")
  (m "https://randomseed.pl/pub/poczytaj-mi-clojure/21-polimorfizm/")
  (m "https://clojure.org/about/runtime_polymorphism")
  (m "http://clojure-doc.org/articles/language/polymorphism.html")
  (m "https://stackoverflow.com/questions/13553100/what-is-polymorphism-a-la-carte-and-how-can-i-benefit-from-it")
  (m "https://stackoverflow.com/questions/5024211/clojure-adding-functions-to-defrecord-without-defining-a-new-protocol"))

(qam
  (q "What is a lambda?")
  (a "also anonymous function")
  (a "a function definition that is not bound to an identifier")
  (m "https://en.wikipedia.org/wiki/Closure_(computer_programming)"))

(qam
  (q "What is a closure?")
  (a "also lexical closure, function closure")
  (a "a technique for implementing lexically scoped name binding in a language with first-class functions")
  (a "a record storing a function together with an environment")
  (a "a function containing one or more free variables")
  (a "a function that has access to some variable outside its own scope")
  (a "a function that has access to locals from the context where it was created")
  (m "https://en.wikipedia.org/wiki/Closure_(computer_programming)")
  (m "https://stackoverflow.com/questions/36636/what-is-a-closure")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 148"))

(qam
  (q "What is a first-class function?")
  (a "The first-class function is a feature of the programming language.")
  (a "A programming language is said to have first-class functions if it treats functions as first-class citizens.")
  (a "The first-class function is a first-class citizen.")
  (m "https://en.wikipedia.org/wiki/First-class_function"))

(qam
  (q "What is a currying?")
  (a "the technique of translating the evaluation of a function that takes multiple arguments into evaluating a sequence of functions, each with a single argument")
  (a "the process of taking a function that accepts n arguments and turning it into n functions that each accepts a single argument")
  (m "https://en.wikipedia.org/wiki/Currying"))

(qam
  (q "Why use currying?")
  (q "1. to study functions with multiple arguments in simpler theoretical models which provide only one argument")
  (q "2. to automatically manage how arguments are passed to functions and exceptions")
  (q "3. to work with functions that take multiple arguments, and using them in frameworks where functions might take only one argument")
  (q "4. some programming languages almost always use curried functions to achieve multiple arguments, e.g. all functions in ML and Haskell have exactly one argument")
  (a "5. allows to effectively get multi-argument functions without actually defining semantics for them or defining semantics for products")
  (a "6. leads to a simpler language with as much expressiveness as another, more complicated language, and so is desirable")
  (m "https://softwareengineering.stackexchange.com/questions/185585/what-is-the-advantage-of-currying")
  (m "https://en.wikipedia.org/wiki/Currying"))

(qam
  (q "What are the benefits of not having automatic currying?")
  (a "optional arguments with default values")
  (a "variadic arguments: you can have a single function foo, rather than foo, foo2, foo3")
  (a "the compiler can catch the fact that was passed too few arguments to a function")
  (a "manual currying can be more fully featured compared to automatic")
  (m "https://news.ycombinator.com/item?id=13322402"))

(qam
  (q "Why no automatic currying in clojure?")
  (a "Clojure does not support automatic currying.")
  (a "Clojure allows functions with a variable number of arguments, so currying makes little sense.")
  (a "e.g. how to know whether (+ 3) should return 3, or wait for more arguments?")
  (a "e.g. in Haskell function + expects exactly two arguments. If called with 0 or 1, it will produce a function that waits for the rest.")
  (a "The closest thing to currying in Clojure is the partial function.")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 139")
  (m "https://stackoverflow.com/questions/31373507/rich-hickeys-reason-for-not-auto-currying-clojure-functions")
  (m "https://dragan.rocks/articles/18/Fluokitten-080-Fast-function-currying-in-Clojure"))

(qam
  (q "What is the difference between partial application and currying?")
  (a "1. a partial function attempts to evaluate whenever it is given another argument")
  (a "2. a curried function returns another curried function until it receives a predetermined number of arguments - only then does it evaluate")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 139"))

(qam
  (q "How to imitate higher-order functions in Java?")
  (a "1. by subscriber pattern")
  (a "2. by callback pattern")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 140"))

(qam
  (q "What is a pure function?")
  (a "1. idempotent: always returns the same result, given the same arguments")
  (a "2. doesn't cause any observable side effects")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 144")
  (m "https://en.wikipedia.org/wiki/Pure_function"))

(qam
  (q "Enumerate the reasons for using pure functions.")
  (a "1. referential transparency")
  (a "2. optimization")
  (a "3. testability")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 144"))

(qam
  (q "What is a referential transparency?")
  (a "also purity")
  (a "a property of part of computer program")
  (a "an expression is called referentially transparent if it can be replaced with its corresponding value without changing the program's behavior")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 144")
  (m "https://en.wikipedia.org/wiki/Referential_transparency")
  (m "https://stackoverflow.com/questions/4865616/purity-vs-referential-transparency"))

(qam
  (q "What is a side effect?")
  (a "changing something somewhere")
  (a "an effect beside returning value")
  (m "https://en.wikipedia.org/wiki/Side_effect_(computer_science)")
  (m "https://pl.wikipedia.org/wiki/Skutek_uboczny_(informatyka)"))

(qam
  (q "What is a referential opacity?")
  (a "An expression that is not referentially transparent is called referentially opaque.")
  (m "https://en.wikipedia.org/wiki/Referential_transparency"))

(qam
  (q "What is the difference between purity and referential transparency?")
  (a "purity: idempotent, no side effects")
  (a "referential transparency: an ability to be replaced"))

(qam
  (q "Can a pure function be not referentially transparent?")
  (a "no, by definition (idempotent, no side effects)")
  (a "If all functions involved in the expression are pure functions, then the expression is referentially transparent.")
  (m "https://en.wikipedia.org/wiki/Referential_transparency"))

(qam
  (q "Can a referentially transparent function be not pure?")
  (a "to think about")
  (a "int f() {logToDB(); return 3;}")
  (a "int f() {logToFile(); return 3;}")
  (a "not pure")
  (a "can be replaced")
  (m "https://en.wikipedia.org/wiki/Referential_transparency"))

(qam
  (q "What is a referential transparency?")
  (a "no agreement on the definition")
  (a "the referential transparency is not useful")
  (a "don't use it")
  (m "https://stackoverflow.com/questions/4865616/purity-vs-referential-transparency"))

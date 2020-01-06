(ns pl.tomaszgigiel.clojure-everyday.etudes-joc07-test
  (:require [clojure.test :as tst])
  (:require [uncomplicate.fluokitten.core :as fluokitten])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.clojure-everyday.etudes :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

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
  (q "Show that complex types are functions of their elements.")
  (a (= ([:a :b] 0) :a) "vector is a function, index 0 is an argument")
  (a (= (map [:a :b :c :d :e] [0 2 4]) [:a :c :e]) "passing a vector as a function argument")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 136"))

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
  (a "6. need not be associated with an identifier (i.e. an anonymous function)")
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
  (a "1. takes one or more functions as arguments (i.e. procedural parameters)")
  (a "2. returns a function as its result")
  (m "https://en.wikipedia.org/wiki/Higher-order_function"))

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
  (q "Create custom dynamic OO system")
  (a "define a prototype instance to serve as your class")
  (a "use this to define your methods, plus any default values")
  (a (def person-class {:get-full-name (fn [this] (str (:first-name this) " " (:last-name this)))}))
  (a "define an instance by merging member variables into the class")
  (a (def john (merge person-class  {:first-name "John" :last-name "Smith"})))
  (a (= ((:get-full-name john) john) "John Smith"))
  (a "added bonus - inheritance for free!")
  (a (def mary (merge john {:first-name "Mary"})))
  (a (= ((:get-full-name mary) mary) "Mary Smith"))
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
  (m "https://en.wikipedia.org/wiki/Closure_(computer_programming)")
  (m "https://stackoverflow.com/questions/36636/what-is-a-closure"))

(qam
  (q "Create a closure (function)")
  (a (defn messenger-builder [greeting] (fn [who] (println greeting who))) "closes over greeting")
  (a (def hello-er (messenger-builder "Hello")) "greeting provided here, then goes out of scope")
  (a (= (hello-er "world!") "Hello world!") "greeting value still available because hello-er is a closure")
  (m "https://clojure.org/guides/learn/functions#_locals_and_closures"))

(qam
  (q "Create a closure (atom)")
  (a (def foo (let [counter (atom 0)] (fn [] (do (swap! counter inc) @counter)))) "closes over counter, counter goes out of scope")
  (a (= (foo) 1) "counter value still available because foo is a closure")
  (a (= (foo) 2) "foo holds a reference to counter")
  (a (= (foo) 3) "counter will not be garbage-collected as long as foo is needed")
  (m "https://stackoverflow.com/questions/14874970/clojure-closure"))

(qam
  (q "What is a first-class function?")
  (a "The first-class function is a feature of the programming language.")
  (a "A programming language is said to have first-class functions if it treats functions as first-class citizens.")
  (a "The first-class function is a first-class citizen.")
  (m "https://en.wikipedia.org/wiki/First-class_function"))

(qam
  (q "Create function using composition.")
  (a (= ((comp first rest rest) [1 2 3]) 3) "built from existing parts using the comp (compose) function")
  (a (= ((def third (comp first rest rest)) [1 2 3]) 3))
  (a (= (((defn fnth [n] (apply comp (cons first (take (dec n) (repeat rest))))) 3) [1 2 3]) 3) "the function fnth builds new functions on the fly based on its arguments")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 137"))

(qam
  (q "When are more than one open parenthesis in a row?")
  (a (= ((comp first rest rest) [1 2 3]) 3) "it is almost always because a function is creating and returning a function that is called immediately")
  (a (= ((partial + 5) 100 200) 305))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 138"))

(qam
  (q "When to use the comp (compose) function?")
  (a (= (map (comp keyword #(.toLowerCase %) name) '(a B C)) '(:a :b :c)) "if you need a function that applies a number of functions serially to the return of the former")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 138"))

(qam
  (q "Create function using partial function.")
  (a (= ((partial + 5) 100 200) 305) "built from the partial application of another function")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 138"))

(qam
  (q "Write equivalent to ((partial + 5) 100 200) with apply.")
  (a (= ((partial + 5) 100 200) (#(apply + 5 %&) 100 200) 305))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 139"))

(qam
  (q "What is a currying?")
  (a "Currying is the technique of translating the evaluation of a function that takes multiple arguments into evaluating a sequence of functions, each with a single argument.")
  (a "Currying is the process of taking a function that accepts n arguments and turning it into n functions that each accepts a single argument.")
  (m "https://en.wikipedia.org/wiki/Currying"))

(qam
  (q "Why use currying?")
  (a false "todo")
  (m ""))

(qam
  (q "How to implement currying in clojure?")
  (a (= ((defn add [a b c] (+ a b c)) 1 2 3) 6) "the function")
  (a (= ((((defn add-curried [a] (fn [b] (fn [c] (+ a b c)))) 1) 2) 3) 6) "the curried version")
  (a false "verify")
  (m "https://stackoverflow.com/questions/36314/what-is-currying")
  (m "https://dragan.rocks/articles/18/Fluokitten-080-Fast-function-currying-in-Clojure"))

(qam
  (q "How to implement automatic currying in clojure?")
  (a "use Fluokitten")
  (a "i.e. [uncomplicate/fluokitten \"0.9.1\"]")
  (a "(:require [uncomplicate.fluokitten.core :as fluokitten])")
  (a "(curry f)")
  (a "(curry f arity)")
  (a (= ((((fluokitten/curry + 3) 1) 2) 3) 6))
  (a (= ((fluokitten/curry +) 1 2 3) 6))
  (m "https://dragan.rocks/articles/18/Fluokitten-080-Fast-function-currying-in-Clojure")
  (m "https://fluokitten.uncomplicate.org/codox/uncomplicate.fluokitten.core.html#var-curry"))

(qam
  (q "Why no automatic currying in clojure?")
  (a "Clojure does not support automatic currying.")
  (a "Clojure allows functions with a variable number of arguments, so currying makes little sense.")
  (a "i.e. how to know whether (+ 3) should return 3, or wait for more arguments?")
  (a "i.e. in Haskell function + expects exactly two arguments. If called with 0 or 1, it will produce a function that waits for the rest.")
  (a "The closest thing to currying in Clojure is the partial function.")
  (a false "verify")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 139")
  (m "https://stackoverflow.com/questions/31373507/rich-hickeys-reason-for-not-auto-currying-clojure-functions")
  (m "https://dragan.rocks/articles/18/Fluokitten-080-Fast-function-currying-in-Clojure"))

(qam
  (q "What is the difference between partial application and currying?")
  (a "A partial function attempts to evaluate whenever it is given another argument.")
  (a "A curried function returns another curried function until it receives a predetermined number of arguments - only then does it evaluate.")
  (a false "verify")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 139"))

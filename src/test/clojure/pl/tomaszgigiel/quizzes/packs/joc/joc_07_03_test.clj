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
  (a "use tail recursion")
  (a "use linear with lazy-seq")
  (a "use functional programming (e.g. reduce)")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Implement Math.pow using mundane resursion.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (== (pow-mundane 2 3) (Math/pow 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "List two common techniques for converting mundane recursion to tail recursion.")
  (a "a helper inner function that does the majority of the work")
  (a "an accumulator that holds the result of some operation")
  (m ""))

(qam
  (q "Example of converting mundane recursion to tail recursion.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (defn pow-tail-recursion [x n]
       (letfn [(inner [x n acc] (if (zero? n) acc (recur x (dec n) (* x acc))))] (inner x n 1))))
  (a (== (Math/pow 2 3) (pow-mundane 2 3) (pow-tail-recursion 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 155"))

(qam
  (q "Why to use lazy-seq in the context of mundane recursion?")
  (a "to avoid stack-overflow exceptions")
  (a "to stay with the mundane (regular) recursion, often the most natural")
  (m ""))

(qam
  (q "Example of converting mundane recursion to mundane recursion with lazy-seq.")
  (a (defn pow-mundane [x n] (if (zero? n) 1 (* x (pow-mundane x (dec n))))))
  (a (defn pow-lazy-seq [x n]
       (letfn [(multiply [a factor] (lazy-seq (cons a (multiply (* a factor) factor))))]
         (nth (multiply x x) (dec n)))))
  (a (== (Math/pow 2 3) (pow-mundane 2 3) (pow-lazy-seq 2 3)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3 On closures, page 156"))

(qam
  (q "Implement function to recursively convert units of measure")
  (a (defn convert [context descriptor]
       (reduce (fn [result [mag unit]]
                   (+ result
                     (let [val (get context unit)]
                       (if (vector? val)
                           (* mag (convert context val))
                           (* mag val)))))
               0
               (partition 2 descriptor))))
  (a (= (convert {:meter 1, :km 1000, :cm 1/100, :mm [1/10 :cm]} [3 :km 10 :meter 80 :cm 10 :mm]) 301081/100))
  (a (= (convert {:bit 1, :byte 8, :nibble [1/2 :byte]} [32 :nibble]) 128N))
  (m ""))

(qam
  (q "Discuss a generalized tail-call optimization.")
  (a "if you know that function A calls B in the tail position")
  (a "then you also know that A's resources are no longer needed")
  (a "allowing Scheme to deallocate them and defer to B for the return call instead")
  (a "but JVM can only provide a subset of generalized TCO (tail-call optimizations)")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.2. Tail calls and recur"))

(qam
  (q "Implement gcd using mundane recursion and tail recursion.")
  (a (defn gcd-mundane [x y] (if (zero? y) x (gcd-mundane y (mod x y)))) "Clojure does not detect and optimize recursive tail calls, Scala does")
  (a (defn gcd-tail [x y] (if (zero? y) x (recur y (mod x y)))))
  (a (= (gcd-mundane 1023 858) (gcd-tail 1023 858) (.gcd (biginteger 1023) (biginteger 858))))
  (a (= (convert {:bit 1, :byte 8, :nibble [1/2 :byte]} [32 :nibble]) 128N))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.2. Tail calls and recur"))

(qam
  (q "Why Clojure provides recur?")
  (a "1. to explicit perform TCO (tail-call optimizations)")
  (a "JVM can only provide a subset of generalized TCO")
  (a "Clojure doesn't give the pretense of providing full TCO")
  (a "2. for the compiler to check if we're dealing with tail recursion")
  (a "3. it allows the forms fn and loop to act as anonymous recursion points")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.2. Tail calls and recur"))

(qam
  (q "What is the difference between defining function in let and letfn?")
  (a "a function defined in a let can't refer to a function defined later in the bindings vector")
  (a "because let doesn't set up forward declarations")
  (a "whereas letfn does")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.3. Don't forget your trampoline"))

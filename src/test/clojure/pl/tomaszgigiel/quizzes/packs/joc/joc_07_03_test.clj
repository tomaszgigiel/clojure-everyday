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
  (q "Implement convert.")
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

(qam
  (q "What is a mutual recursion?")
  (a "is a form of recursion where two mathematical or computational objects, such as functions or data types, are defined in terms of each other")
  (m "https://en.wikipedia.org/wiki/Mutual_recursion"))

(qam
  (q "Show problem with a mutual recursion in Clojure.")
  (a (declare my-odd?))
  (a (defn my-even? [n] (if (zero? n) true (my-odd? (dec (Math/abs n))))))
  (a (defn my-odd? [n] (if (zero? n) false (my-even? (dec (Math/abs n))))))
  (at (my-even? 1000000) StackOverflowError)
  (m "https://jakemccrary.com/blog/2010/12/06/trampolining-through-mutual-recursion/"))

(qam
  (q "How to solve problem with a mutual recursion in Clojure?")
  (a "use trampoline like recur")
  (a (declare my-odd?))
  (a (defn my-even? [n] (if (zero? n) true #(my-odd? (dec (Math/abs n))))))
  (a (defn my-odd? [n] (if (zero? n) false #(my-even? (dec (Math/abs n))))))
  (a (trampoline my-even? 1000000))
  (m "https://jakemccrary.com/blog/2010/12/06/trampolining-through-mutual-recursion/"))

(qam
  (q "How to use trampoline inside the function?")
  (a (defn my-even? [n]
       (letfn [(e? [n] (if (zero? n) true #(o? (dec (Math/abs n)))))
               (o? [n] (if (zero? n) false #(e? (dec (Math/abs n)))))]
         (trampoline e? n))))
  (a (defn my-odd? [n] (not (my-even? n))))
  (a (trampoline my-even? 1000000))
  (a (= (trampoline my-odd? 1000000) false))
  (m "https://jakemccrary.com/blog/2010/12/06/trampolining-through-mutual-recursion/"))

(qam
  (q "How to implement finite state machine or automaton (FSM or FSA)?")
  (a "use trampoline")
  (a (defn my-fsa [commands] (letfn [(a-> [[_ & rs]] #(case _ :a-b (b-> rs) :a-c (c-> rs) false))
                                     (b-> [[_ & rs]] #(case _ :b-a (a-> rs) :b-c (c-> rs) false))
                                     (c-> [[_ & rs]] #(case _ :c-a (a-> rs) :c-b (c-> rs) :final true false))]
                               (trampoline a-> commands))))
  (a (my-fsa [:a-b :b-c :c-a :a-c :final]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.3. Don't forget your trampoline")
  (m "https://clojuredocs.org/clojure.core/trampoline"))

(qam
  (q "What are the rules for mutual recursion?")
  (a "1. Make all functions return a function instead of their normal result")
  (a "tack a # onto the front of the outer level of the function body")
  (a "2. Invoke the first function in the mutual chain via the trampoline function")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.3. Don't forget your trampoline"))

(qam
  (q "What is CPS?")
  (a "continuation-passing style (CPS) is a hybrid between recursion and mutual recursion")
  (a "it is a way of generalizing a computation by viewing it in terms of up to three functions:")
  (a "Accept - Decides when a computation should terminate")
  (a "Return - Wraps the return values")
  (a "Continuation - Provides the next step in the computation")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.4. Continuation-passing style")
  (m "https://en.wikipedia.org/wiki/Continuation-passing_style"))

(qam
  (q "Implement the factorial function using CPS.")
  (a (defn factorial-cps [n k] (letfn [(cont [v] (k (* v n)))] (if (zero? n) (k 1) (recur (dec n) cont)))))
  (a (defn factorial [n] (factorial-cps n identity)))
  (a (= (factorial 10) 3628800))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.4. Continuation-passing style"))

(qam
  (q "Implement the generic function builder using CPS.")
  (a (defn builder-cps [accept? kend kont] (fn [n] ((fn [n k] (let [cont (fn [v] (k ((partial kont v) n)))]
                                                                (if (accept? n) (k 1) (recur (dec n) cont)))) n kend))))
  (a (def factorial (builder-cps zero? identity #(* %1 %2))))
  (a (= (factorial 10) 3628800))
  (a (def triangular-number (builder-cps #(== 1 %) identity #(+ %1 %2))))
  (a (= (triangular-number 10) 55))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.4. Continuation-passing style"))

(qam
  (q "What are the disadventages CPS in Clojure?")
  (a "no generalized tail-call optimization in JVM, so StackOverflowError possibility")
  (a "the exception difficult to track down")
  (a "- if continuation function is supposed to throw the error, but an outer layer function is doing so instead")
  (a "- on deferred computations (delay, future, promise)")
  (a "CPS isn't conducive to parallelization, which is antithetical to Clojure's nature")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.3.4. Continuation-passing style"))

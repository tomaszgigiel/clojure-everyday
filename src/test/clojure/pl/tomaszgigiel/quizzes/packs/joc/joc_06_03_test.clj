(ns pl.tomaszgigiel.quizzes.packs.joc.joc-06-03-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Is Clojure a lazy language?")
  (a "Clojure is partially a lazy language.")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3. Laziness"))

(qam
  (q "What is lazy evaluation?")
  (a "or call-by-need")
  (a "an evaluation strategy which delays the evaluation of an expression until its value is needed")
  (m "https://en.wikipedia.org/wiki/Lazy_evaluation"))

(qam
  (q "What is eager evaluation?")
  (a "or strict evaluation")
  (a "or greedy evaluation")
  (a "an evaluation strategy which an expression is evaluated as soon as it is bound to a variable")
  (m "https://en.wikipedia.org/wiki/Eager_evaluation"))

(def txt "ok")

(qam
  (q "Laziness example in eager programming languages.")
  (a "short-circuit evaluation")
  (a "if (txt != null && !txt.isEmpty()) { System.out.println(txt); return true; }")
  (a (and txt (complement (.isEmpty txt)) (do (println txt) true)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.1. Familiar laziness with logical-and"))

(qam
  (q "Implement: (steps-recur [1 2 3 4]): [1 [2 [3 [4 []]]]]")
  (a (defn steps-recur [[x & xs]] (if x [x (steps-recur xs)] [])))
  (a (= (steps-recur [1 2 3 4]) [1 [2 [3 [4 []]]]]))
  (at (steps-recur (range 2123123)) java.lang.StackOverflowError)
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.2. Understanding the lazy-seq recipe"))

(qam
  (q "Recipe for applying laziness to functions.")
  (a "1. Use the lazy-seq macro at the outermost level of your lazy sequence–producing expression(s).")
  (a "2. If you happen to be consuming another sequence during your operations, then use rest instead of next.")
  (a "3. Prefer higher-order functions when processing sequences.")
  (a "4. Don’t hold on to your head.")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.2. Understanding the lazy-seq recipe"))

(qam
  (q "Difference rest vs. next")
  (a "next: check whether there's at least one thing in collection, thus potentially causing one extra realization")
  (a (= (next []) nil) "a seq of the items after the first, if there are no more items, returns nil.")
  (a (= (rest []) ()) "a possibly empty seq of the items after the first")
  (a (= (rest nil) ()))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.2. Understanding the lazy-seq recipe"))

(qam
  (q "Implement: (steps-lazy [1 2 3 4]): [1 [2 [3 [4 []]]]]")
  (a (defn steps-lazy [x] (lazy-seq (if (seq x) [(first x) (steps-lazy (rest x))] []))))
  (a (= (steps-lazy [1 2 3 4]) [1 [2 [3 [4 []]]]]))
  (a (= (count (flatten (steps-lazy (range 2123123)))) 2123123))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.2. Understanding the lazy-seq recipe"))

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
  (a false "TODO: avoid print ok during test")
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

(qam
  (q "Implement: (range-lazy 0 9): (0 1 2 3 4 5 6 7 8)")
  (a (defn range-lazy [i limit] (lazy-seq (when (< i limit) (cons i (range-lazy (inc i) limit))))))
  (a (= (range-lazy 0 9) (list 0 1 2 3 4 5 6 7 8)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.2. Understanding the lazy-seq recipe"))

(qam
  (q "Explein: (let [r (range 1e9)] (first r) (last r))")
  (a "OK")
  (a "Clojure's compiler can deduce")
  (a "the retention of r is no longer needed")
  (a "Clojure clears it")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.3. Losing your head"))

(qam
  (q "Explain: (let [r (range 1e9)] (last r) (first r))")
  (a "OutOfMemoryError")
  (a "the head is needed later in the overall computation")
  (a "can no be safely cleared")
  (a "OK: a purely functional lazy language such as Haskell")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.3. Losing your head"))

(qam
  (q "What could you possibly use infinite sequences for?")
  (a "to perform more interesting queries (map, reduce, filter)")
  (a (defn triangle [n] (/ (* n (+ n 1)) 2)))
  (a (def tri-nums (map triangle (iterate inc 1))))
  (a (= (take 2 (drop-while #(< % 10000) tri-nums)) (list 10011 10153)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.4. Employing infinite sequences"))

(qam
  (q "What to keep in mind when using an infinite sequence?")
  (a (defn triangle [n] (/ (* n (+ n 1)) 2)))
  (a (def tri-nums (map triangle (iterate inc 1))))
  (a (= (triangle 99) (nth tri-nums 98)) "but 1 vs 99 calls")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.4. Employing infinite sequences"))

(qam
  (q "How does Clojure implement call-by-need semantics?")
  (a "macro")
  (a "explicit laziness: delay, force")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.5. The delay and force macros"))

(qam
  (q "Explain delay, force.")
  (a (defn defer-expensive [cheap expensive] (if-let [good-enough (force cheap)] good-enough (force expensive))))
  (a (= (defer-expensive (delay :cheap) (delay (do (Thread/sleep 999) :expensive))) :cheap))
  (a (= (defer-expensive (delay false) (delay (do (Thread/sleep 999) :expensive))) :expensive))
  (a "delay caches its calculation")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.5. The delay and force macros"))

(qam
  (q "How to simulate behavior of delay, force?")
  (a "macro")
  (a "delay: (fn [] expr), force: (delayed-fn)")
  (a "memoize (delay caches its calculation)")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.5. The delay and force macros"))

(qam
  (q "Explain if-let")
  (a (= (if :truthy-thing (let [res :truthy-thing] res)) :truthy-thing))
  (a (= (if-let [res :truthy-thing] res) :truthy-thing))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.5. The delay and force macros"))

(qam
  (q "Implement a lazy sequence of triangular numbers using delay and force.")
  (a (defn triangle [n] (/ (* n (+ n 1)) 2)))
  (a (defn inf-triangles [n] {:head (triangle n) :tail (delay (inf-triangles (inc n)))}))
  (a (defn head [x] (:head x)))
  (a (defn tail [x] (force (:tail x))))
  (a (def tri-nums (inf-triangles 1)))
  (a (= (head (tail (tail tri-nums))) 6))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.3.5. The delay and force macros"))

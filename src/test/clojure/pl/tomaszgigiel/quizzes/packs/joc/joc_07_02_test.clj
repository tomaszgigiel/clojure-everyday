(ns pl.tomaszgigiel.quizzes.packs.joc.joc-07-02-test
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
  (a (defn times-n [n] (let [nn n] (fn [x] (* nn x)))) "closing over the local nn")
  (a (def times-four (times-n 4)))
  (a (= (times-four 10) 40))
  (a (= ((times-n 4) 10) 40))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 149"))

(qam
  (q "Example of a function returning closure over parameter.")
  (a (defn times-n [n] (fn [x] (* n x))) "closing over the parameter n")
  (a (def times-four (times-n 4)))
  (a (= (times-four 10) 40))
  (a (= ((times-n 4) 10) 40))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 150"))

(qam
  (q "Example of a passing closure as function.")
  (a (defn divisible [denom](fn [num] (zero? (rem num denom)))) "returns clousure")
  (a (= (filter (divisible 4) (range 10)) [0 4 8]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 150"))

(qam
  (q "Example of a closure on-the-spot.")
  (a (defn filter-divisible [denom s] (filter #(zero? (rem % denom)) s)) "closure defined on the spot where used")
  (a (= (filter-divisible 4 (range 10)) [0 4 8]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 151"))

(qam
  (q "Example of multiple closures sharing the same environment.")
  (a (def bearings [{:x 0 :y 1} {:x 1 :y 0} {:x 0 :y -1} {:x -1 :y 0}]))
  (a
(defn bot [x y bearing-num]
  {:coords     [x y]
   :bearing    ([:north :east :south :west] bearing-num)
   :forward    (fn [] (bot (+ x (:x (bearings bearing-num)))
                           (+ y (:y (bearings bearing-num)))
                           bearing-num))
   :turn-right (fn [] (bot x y (mod (+ 1 bearing-num) 4)))
   :turn-left  (fn [] (bot x y (mod (- 1 bearing-num) 4)))})
)
  (a (= (:coords ((:forward ((:forward ((:turn-right (bot 5 5 0)))))))) [7 5]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 151"))

(qam
  (q "Example of a polymorphism with multiple closures sharing the same environment.")
  (a (defn normal-bot [x] {:coords [x] :forward (fn [] (normal-bot (+ x 1))) :backward (fn [] (normal-bot (- x 1)))}))
  (a (defn mirror-bot [x] {:coords [x] :forward (fn [] (mirror-bot (- x 1))) :backward (fn [] (mirror-bot (+ x 1)))}))
  (a (= (:coords ((:forward ((:forward (normal-bot 0)))))) [ 2]))
  (a (= (:coords ((:forward ((:forward (mirror-bot 0)))))) [-2]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 153"))

(qam
  (q "How to avoid an ad hoc implementation of a polymorphism using closures?")
  (a false "TODO: use reify macro, section 9.3.2")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 154"))

(qam
  (q "How is the work distributed between compile-time and runtime in case of closure?")
  (a "bytecode for the bodies of functions (regular, closure) is generated during compilation")
  (a "each function definition gets its own class")
  (a "the creation of an instance of class is lightweight and fast")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.2 On closures, page 154"))

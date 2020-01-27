(ns pl.tomaszgigiel.quizzes.joc.quiz-joc-07-01-test
  (:require [clojure.test :as tst])
  (:require [uncomplicate.fluokitten.core :as fluokitten])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Show that complex types are functions of their elements.")
  (a (= ([:a :b] 0) :a) "vector is a function, index 0 is an argument")
  (a (= (map [:a :b :c :d :e] [0 2 4]) [:a :c :e]) "passing a vector as a function argument")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 136"))

(qam
  (q "Create custom dynamic OO system")
  (a "define a prototype instance to serve as your class")
  (a "use this to define your methods, plus any default values")
  (a (def person-class {:get-full-name (fn [this] (str (:first-name this) " " (:last-name this)))}))
  (a "define an instance by merging member variables into the class")
  (a (def john (merge person-class  {:first-name "John" :last-name "Smith"})))
  (a (= ((:get-full-name john) john) "John Smith"))
  (a "added bonus - prototype-based inheritance for free!")
  (a (def mary (merge john {:first-name "Mary"})))
  (a (= ((:get-full-name mary) mary) "Mary Smith"))
  (m "https://stackoverflow.com/questions/5024211/clojure-adding-functions-to-defrecord-without-defining-a-new-protocol"))

(qam
  (q "Create a closure (function)")
  (a (defn messenger-builder [greeting] (fn [who] (str greeting who))) "closes over greeting")
  (a (def hello-er (messenger-builder "Hello ")) "greeting provided here, then goes out of scope")
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
  (q "Create function using composition.")
  (a (= ((comp first rest rest) [1 2 3]) 3) "built from existing parts using the comp (compose) function")
  (a (= (def third (comp first rest rest))))
  (a (= (third [1 2 3]) 3))
  (a (defn fnth [n] (apply comp (cons first (take (dec n) (repeat rest))))) "the function fnth builds new functions on the fly based on its arguments")
  (a (= ((fnth 3 )[1 2 3]) 3))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 137"))

(qam
  (q "When are more than one open parenthesis in a row?")
  (a (= ((comp first rest rest) [1 2 3]) 3) "it is almost always because a function is creating and returning a function that is called immediately")
  (a (= ((partial + 5) 100 200) 305))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 138"))

(qam
  (q "When to use the comp (compose) function?")
  (a (= (map (comp keyword #(.toLowerCase %) name) '(a B C)) '(:a :b :c)) "if you need a function that applies a number of functions serially to the return of the former")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 138"))

(qam
  (q "Create function using partial function.")
  (a (= ((partial + 5) 100 200) 305) "built from the partial application of another function")
  (a (def sort-by-some-ratio (partial sort-by #(/ (:x %) (:y %)))))
  (a (= (sort-by-some-ratio [{:x 1 :y 1} {:x 1 :y 2} {:x 1 :y 3}]) [{:x 1 :y 3} {:x 1 :y 2} {:x 1 :y 1}]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 138"))

(qam
  (q "Write equivalent to ((partial + 5) 100 200) with apply.")
  (a (= ((partial + 5) 100 200) (#(apply + 5 %&) 100 200) 305))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 139"))

(qam
  (q "How to implement currying in clojure?")
  (a (= ((defn add [a b c] (+ a b c)) 1 2 3) 6) "the function")
  (a (= ((((defn add-curried [a] (fn [b] (fn [c] (+ a b c)))) 1) 2) 3) 6) "the curried version")
  (m "https://stackoverflow.com/questions/36314/what-is-currying")
  (m "https://dragan.rocks/articles/18/Fluokitten-080-Fast-function-currying-in-Clojure"))

(qam
  (q "How to implement automatic currying in clojure?")
  (a "use Fluokitten")
  (a "e.g. [uncomplicate/fluokitten \"0.9.1\"]")
  (a "(:require [uncomplicate.fluokitten.core :as fluokitten])")
  (a "(curry f)")
  (a "(curry f arity)")
  (a (= ((((fluokitten/curry + 3) 1) 2) 3) 6))
  (a (= ((fluokitten/curry +) 1 2 3) 6))
  (m "https://dragan.rocks/articles/18/Fluokitten-080-Fast-function-currying-in-Clojure")
  (m "https://fluokitten.uncomplicate.org/codox/uncomplicate.fluokitten.core.html#var-curry"))

(qam
  (q "Create function using complement.")
  (a ((complement even?) 1) "takes a function that returns a truthy value and returns the opposite truthy value")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 139"))

(qam
  (q "Write equivalent to (complement even?) 2) with comp.")
  (a (= ((complement even?) 1) ((comp not even?) 1) (#(not (even? %)) 1)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 139"))

(qam
  (q "Example that a function is data.")
  (a "clojure.test stores and validates unit tests in the metadata of a var holding a function")
  (a (defn foo {:test (fn [] (assert (= (foo) "foo")))} [] "foo"))
  (a (test #'foo))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 139"))

(qam
  (q "How to assign metadata to a function using the defn macro?")
  (a (defn foo {:something true :something-else true} [] "foo"))
  (a (defn ^:something ^:something-else foo [] "foo"))
  (a (defn ^{:something true, :something-else true} foo [] "foo"))
  (a (defn foo ([] "foo") {:something true :something-else true}))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 139"))

(qam
  (q "Example use of functions as argument")
  (a (= (map second [[:a 3] [:b 2] [:c 1]]) [3 2 1]))
  (a (= (reduce #(conj %1 (second %2)) [] [[:a 3] [:b 2] [:c 1]]) [3 2 1]))
  (a (= (filter #(-> % second odd?) [[:a 3] [:b 2] [:c 1]]) [[:a 3] [:c 1]]))
  (a (= (sort-by second [[:a 3] [:b 2] [:c 1]]) [[:c 1] [:b 2] [:a 3]]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 141"))

(qam
  (q "Sort rows based on selected columns.")
  (a (defn columns [column-names] (fn [row] (vec (map row column-names)))))
  (a (= ((columns [:x :z]) {:x 1 :y 2 :z 3}) [1 3]))
  (a (= (compare [1 3] [2 3]) -1) "vector is a closure function, so it implements the java.util.Comparator interface")
  (a "sort-by uses compare")
  (a (= (sort-by (columns [:x :z]) [{:x 2 :y 3 :z 2}{:x 2 :y 2 :z 1}{:x 1 :y 1 :z 3}]) [{:x 1 :y 1 :z 3}{:x 2 :y 2 :z 1}{:x 2 :y 3 :z 2}]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 143"))

(qam
  (q "Example of a function with named arguments.")
  (a (defn slope [& {:keys [p1 p2] :or {p1 [0 0] p2 [1 1]}}] (float (/ (- (p2 1) (p1 1)) (- (p2 0) (p1 0))))))
  (a (= (slope :p1 [4 15] :p2 [3 21]) -6.0))
  (a (= (slope :p2 [2 1]) 0.5))
  (a (= (slope) 1.0))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 146"))

(qam
  (q "Which mechanism forms the basis for named parameters?")
  (a "the destructuring mechanism")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 146"))

(qam
  (q "How to constrain function with pre- or postconditions?")
  (a (defn foo [a b] {:pre [(int? a) (int? b) (not= b 0)] :post [(even? %)]} (/ a b)))
  (at (foo 2 0) java.lang.AssertionError)
  (a (= (foo 2 1) 2))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 146"))

(qam
  (q "How to turn off :pre and :post checks for a specific file?")
  (a "- add the line (set! *assert* false) to a source file")
  (a "- somewhere near the top")
  (a "- but after the namespace declaration")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 147"))

(qam
  (q "How to use assert instead pre- or postconditions?")
  (a (defn foo [a b] (assert (and (int? a) (int? b) (not= b 0))) (let [r (/ a b)] (assert (even? r)) r)))
  (at (foo 2 0) java.lang.AssertionError)
  (a (= (foo 2 1) 2))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 147"))

(qam
  (q "Example of decoupling assertions from functions.")
  (a (defn put-things [m] (into m {:meat "beef" :veggie "broccoli"})))
  (a (defn vegan-constraints [f m] {:pre [(:veggie m)] :post [(:veggie %) (nil? (:meat %))]} (f m)))
  (at (vegan-constraints put-things {:fruit "apple"}) java.lang.AssertionError)
  (a (defn balanced-diet [f m] {:post [(:meat %) (:veggie %)]} (f m)))
  (a (= {:fruit "apple" :meat "beef" :veggie "broccoli"} (balanced-diet put-things {:fruit "apple"})))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 147"))

(qam
  (q "What is main adventage of pulling out the assertions into a wrapper function?")
  (a "you detach some domain-specific requirements from a potentially globally useful function and isolate them in aspects")
  (a "you can mix in any implementation you please, knowing that as long as it fulfills the contract its interposition is transparent")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.1 Functions in all their forms, page 148"))

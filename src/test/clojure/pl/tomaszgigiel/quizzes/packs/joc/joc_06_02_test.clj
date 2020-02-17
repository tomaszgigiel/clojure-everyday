(ns pl.tomaszgigiel.quizzes.packs.joc.joc-06-02-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is the simplest type of shared-structure?")
  (a "list")
  (a (def base (list :b :a)))
  (a (def lst1 (cons :c1 base)))
  (a (def lst2 (cons :c2 base)))
  (a (= (next lst1) (next lst2)))
  (a (identical? (next lst1) (next lst2)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.2. Structural sharing: a persistent toy"))

(qam
  (q "Explain the keyword-as-function approach.")
  (a (= (:a-key {:a-key 42}) (get {:a-key 42} :a-key)))
  (a "the keyword")
  (a "when placed in a function call position")
  (a "work as functions taking a map")
  (a "that then look up themselves (as keywords) in said map")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.2. Structural sharing: a persistent toy"))

(qam
  (q "Implement a persistent toy showcasing the structural sharing.")
  (a (defn xconj [t v]
       (cond (nil? t) {:val v, :L nil, :R nil}
             (< v (:val t)) {:val (:val t), :L (xconj (:L t) v), :R (:R t)}
             :else {:val (:val t), :L (:L t), :R (xconj (:R t) v)})))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.2. Structural sharing: a persistent toy"))

(qam
  (q "Traverse the tree {:val 5, :L {:val 3, :L {:val 2, :L nil, :R nil}, :R nil}, :R nil} in sorted order.")
  (a (def tree {:val 5, :L {:val 3, :L {:val 2, :L nil, :R nil}, :R nil}, :R nil}))
  (a (defn xseq [t] (when t (concat (xseq (:L t)) [(:val t)] (xseq (:R t))))))
  (a (= (xseq tree) [2 3 5]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.2. Structural sharing: a persistent toy"))

(qam
  (q "Characterize Clojure's persistent collections.")
  (a "values and unchanged branches are never copied")
  (a "references could be copied")
  (a "implementation is thread-safe")
  (a "Clojure uses red-black trees")
  (a "Clojure uses nodes with up to 32 branches")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 6.2. Structural sharing: a persistent toy"))

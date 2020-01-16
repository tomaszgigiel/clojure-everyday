(ns pl.tomaszgigiel.quizzes.quiz-others-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is the difference between a quote and a syntax quote?")
  (q "What is the difference between \"'\" and \"`\"?")
  (a "the single-quote operator:")
  (a (= '(+ 1 2) (read-string "(+ 1 2)")) "1. yields the unevaluated form")
  (a (= (let [x 1] '(+ ~x 2)) (read-string "(+ (clojure.core/unquote x) 2)")) "2. is not canceled out by the syntax-unquote operator")
  (a (= (read-string "'(+ 1 2)") (read-string "(quote (+ 1 2))")) "3. syntax sugar")
  (a "the syntax-quote operator:")
  (a (= `(+ 1 2) (read-string "(clojure.core/+ 1 2)")) "1. yields the unevaluated form (with namespaces added)")
  (a (= (let [x 1] `(+ ~x 2)) (read-string "(clojure.core/+ 1 2)")) "2. is canceled out by the syntax-unquote operator")
  (a "3. no syntax sugar")
  (m "https://cljs.github.io/api/syntax/quote")
  (m "https://cljs.github.io/api/syntax/syntax-quote")
  (m "https://clojuredocs.org/clojure.core/quote")
  (m "https://8thlight.com/blog/colin-jones/2012/05/22/quoting-without-confusion.html")
  (m "https://stackoverflow.com/questions/26485514/clojure-difference-between-quote-and-syntax-quote"))

(qam
  (q "Discuss unquote.")
  (a false "todo")
  (m "https://clojuredocs.org/clojure.core/unquote"))

(qam
  (q "Discuss unquote-splicing.")
  (a false "todo")
  (m "https://clojuredocs.org/clojure.core/unquote-splicing"))

(qam
  (q "Discuss the weird characters.")
  (a false "todo")
  (m "https://clojure.org/guides/weird_characters"))

(qam
  (q "What is the difference between use and require?")
  (a false "todo")
  (m "https://stackoverflow.com/questions/871997/difference-between-use-and-require"))

(qam
  (q "How to load libs in REPL?")
  (a "(require '(clojure.string))")
  (a "(clojure.string/upper-case \"aa\")")
  (a "(require '[clojure.string :as s])")
  (a "(s/upper-case \"aa\")")
  (m "https://clojuredocs.org/clojure.core/require"))

(qam
  (q "Discuss the macro hidden arguments.")
  (a false "todo")
  (m "https://dzone.com/articles/clojure-env-and-form")
  (m "https://stackoverflow.com/questions/25566146/multiple-arity-in-defmacro-of-clojure/25569059"))

(qam
  (q "Discuss the multi-arity macro.")
  (a false "todo")
  (m "https://stackoverflow.com/questions/25566146/multiple-arity-in-defmacro-of-clojure/25569059"))

(qam
  (q "Why did the exception occur?")
  (a (def person-class {:get-full-name (fn [this] (str (:first-name this) " " (:last-name this)))}))
  (a (def john (merge person-class  {:first-name "John" :last-name "Smith"})))
  (a (defmacro call [this method & xs] `(let [this# ~this] ((~method this#) this# ~@xs))))
  ;(a (= (call john :get-full-name) "John Smith"))
  (a false "todo")
  (m "https://stackoverflow.com/questions/5024211/clojure-adding-functions-to-defrecord-without-defining-a-new-protocol"))

(qam
  (q "Why did the syntaxt error occur?")
  (a (require '(uncomplicate.fluokitten.core)))
  ;(a ((((uncomplicate.fluokitten.core/curry + 3) 1) 2) 3))
  (a false "todo")
  (m ""))

(qam
  (q "Evaluate {:a 1 :a 2 :b 3}")
  (at (read-string "{:a 1 :a 2 :b 3}") IllegalArgumentException)
  (a "unable to compile source file")
  (m ""))

(qam
  (q "Evaluate (into {:a 3} {:a 1 :b 2})")
  (a (= {:a 1 :b 2} (into {:a 3} {:a 1 :b 2})))
  (a false "why?")
  (m ""))

(qam
  (q "Evaluate (into {:c 3} {:a 1 :b 2})")
  (a (= {:c 3 :a 1 :b 2} (into {:c 3} {:a 1 :b 2})))
  (a false "why?")
  (m ""))

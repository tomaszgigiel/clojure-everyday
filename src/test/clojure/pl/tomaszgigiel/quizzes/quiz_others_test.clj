(ns pl.tomaszgigiel.quizzes.quiz-others-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is the difference between a quote and a syntax quote?")
  (q "What is the difference between \"'\" and \"`\"?")
  (a false "todo")
  (m "https://cljs.github.io/api/syntax/quote")
  (m "https://cljs.github.io/api/syntax/syntax-quote")
  (m "https://clojuredocs.org/clojure.core/quote")
  (m "https://8thlight.com/blog/colin-jones/2012/05/22/quoting-without-confusion.html"))

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
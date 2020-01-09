(ns pl.tomaszgigiel.clojure-everyday.faq-macro01-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.clojure-everyday.faq :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

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

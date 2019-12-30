(ns pl.tomaszgigiel.clojure-everyday.etudes-basis01-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.clojure-everyday.etudes :refer [qam q a m]])
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

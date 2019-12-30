(ns pl.tomaszgigiel.clojure-everyday.etudes-macro01-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.clojure-everyday.etudes :refer [qam q a m]])
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

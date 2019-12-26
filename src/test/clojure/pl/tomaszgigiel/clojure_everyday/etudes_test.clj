(ns pl.tomaszgigiel.clojure-everyday.etudes-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(tst/deftest first-test
  (tst/is (= 1 1) "ok"))

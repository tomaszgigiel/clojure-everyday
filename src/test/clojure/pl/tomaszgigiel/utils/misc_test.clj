(ns pl.tomaszgigiel.utils.misc-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:require [pl.tomaszgigiel.utils.test-config :as test-config]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(tst/deftest first-test
  (tst/is (= 1 1) "ok"))

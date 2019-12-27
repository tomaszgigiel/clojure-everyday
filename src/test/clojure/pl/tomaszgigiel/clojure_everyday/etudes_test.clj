(ns pl.tomaszgigiel.clojure-everyday.etudes-test
  (:require [clojure.test :refer [deftest is use-fixtures testing]])
  (:require [pl.tomaszgigiel.clojure-everyday.test-config :as test-config])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(use-fixtures :once test-config/once-fixture)
(use-fixtures :each test-config/each-fixture)

(deftest etudes

(testing "Show that complex types are functions of their elements."
  (is (= ([:a :b] 0) :a)))

)

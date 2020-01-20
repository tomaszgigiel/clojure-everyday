(ns pl.tomaszgigiel.utils.resources-test
  (:require [clojure.string :as string])
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.utils.resources :as resources])
  (:require [pl.tomaszgigiel.utils.test-config :as test-config]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(tst/deftest replace-variable-environment-test
  (tst/is (string/ends-with? (-> "log4j.properties" resources/from-resources-uri .toString) "log4j.properties")))

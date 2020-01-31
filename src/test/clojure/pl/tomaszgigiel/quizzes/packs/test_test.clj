(ns pl.tomaszgigiel.quizzes.packs.test-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(tst/deftest x
  (tst/testing "x"
    (tst/is (= 4 (+ 2 2)))
    (tst/is (= 7 (+ 3 4)))))

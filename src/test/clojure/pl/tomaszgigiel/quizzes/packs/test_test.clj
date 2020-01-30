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

(defmacro my-show-env [] (mapv (fn [x] [(keyword x) x]) (keys &env)))
; [[:values__9678__auto__ ([[:foo 1] [:boo 2]] [[foo 1] [boo 2]])] [:result__9679__auto__ false] [:foo 1] [:boo 2]]

(tst/deftest x2
  ;(tst/is (= (let [foo 1 boo 2] (my-show-env)) [["foo" 1] ["boo" 2]]))
  (tst/is (= (let [foo 1 boo 2] (my-show-env)) [["foo" 1] ["boo" 2]]) (let [foo 1 boo 2] (my-show-env)))
  )

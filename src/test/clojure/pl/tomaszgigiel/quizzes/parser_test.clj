(ns pl.tomaszgigiel.quizzes.parser-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.parser :as parser])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:require [pl.tomaszgigiel.utils.resources :as resources]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(tst/deftest parser-test
  (tst/is (= (parser/parsed
               (-> "test-grammar.bnf" resources/from-resources-uri .toString)
               (-> "test-input.txt" resources/from-resources-uri .toString slurp)
               {:A (fn [x] [:A (str x)]) :B (fn [x] [:B (str x)])})
             (-> "test-output.txt" resources/from-resources-uri .toString slurp read-string))))

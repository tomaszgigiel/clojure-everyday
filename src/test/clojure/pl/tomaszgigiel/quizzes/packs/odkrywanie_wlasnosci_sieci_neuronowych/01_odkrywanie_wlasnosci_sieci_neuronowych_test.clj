(ns pl.tomaszgigiel.quizzes.packs.odkrywanie-wlasnosci-sieci-neuronowych.01-odkrywanie-wlasnosci-sieci-neuronowych-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is the best book for learning artificial neural networks?")
  (a "Ryszard Tadeusiewicz: Odkrywanie właściwości sieci neuronowych")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

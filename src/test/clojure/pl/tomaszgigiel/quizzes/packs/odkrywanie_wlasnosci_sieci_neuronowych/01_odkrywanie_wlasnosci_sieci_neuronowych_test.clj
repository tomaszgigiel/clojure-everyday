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

(qam
  (q "Compare ann vs. brain")
  (a "simplified structure: homogeneous, each with each vs. different ways of connecting in different places")
  (a "simplified neuron: very simple, inputs, weights, activation function, output vs. very complicated, different kinds")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych, ch.1.4"))

(qam
  (q "Characterise heterogeneous neural networks")
  (a "they learn faster then homogeneous")
  (a "but how to design them?")
  (a "each with each and zero weights")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych, ch.1.4"))

(qam
  (q "List the uses of artificial neural networks, but not in the field of artificial intelligence")
  (a "massive parallel processing")
  (a "the artificial neurons that make up the network perform calculations in parallel")
  (a "usually as specialized devices")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych, ch.1.9"))

(qam
  (q "")
  (a "")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

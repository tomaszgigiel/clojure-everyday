(ns pl.tomaszgigiel.quizzes.packs.ann.01-ann-test
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
  (q "What are artificial neural networks?")
  (a "artificial neural networks or connectionist systems")
  (a "computing systems inspired by the biological neural networks that constitute animal brains")
  (m "https://en.wikipedia.org/wiki/Artificial_neural_network"))

(qam
  (q "What does ANN stand for?")
  (a "Artificial neural networks")
  (m "https://en.wikipedia.org/wiki/Artificial_neural_network"))

(qam
  (q "What are the advantages of artificial neural network?")
  (a "ability to learn to perform tasks by considering examples, generally without being programmed with task-specific rules")
  (m "https://en.wikipedia.org/wiki/Artificial_neural_network"))

(qam
  (q "How are artificial neural networks built?")
  (a "a collection of connected units")
  (a "constructed from 3 type of layers: input layer, hidden layers, output layer")
  (a "elementary unit is an artificial neuron")
  (m "https://en.wikipedia.org/wiki/Artificial_neural_network"))

(qam
  (q "What is learning in ANN?")
  (a "the adaptation of the network to better handle a task by considering sample observations")
  (m "https://en.wikipedia.org/wiki/Artificial_neural_network"))

(qam
  (q "What does learning in ANN involve?")
  (a "Learning ANN involves adjusting the weights (and optional thresholds) of the network to improve the accuracy of the result.")
  (m "https://en.wikipedia.org/wiki/Artificial_neural_network"))

(qam
  (q "What is an artificial neuron?")
  (a "a mathematical function conceived as a model of a biological neuron")
  (m "https://en.wikipedia.org/wiki/Artificial_neuron"))

(qam
  (q "How are artificial (a real biological) neurons built?")
  (a "a body in which computations are performed (soma)")
  (a "a number of input channels (dendrites)")
  (a "one output channel (a single axon)")
  (m "https://en.wikipedia.org/wiki/Artificial_neuron"))

(qam
  (q "How to model an artificial neuron?")
  (a "(activation-function (reduce + (map * (conj inputs bias) (conj weights 1))))")
  (m "https://en.wikipedia.org/wiki/Artificial_neuron"))



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




; Every input has a weight associated with it; the larger the weight, the more impact the corresponding input channel has on the output.
; A neuron also has a bias, which, for convenience, can be considered as an additional input to the neuron, x0, that is equal to 1 and has the weight identical to the value of the bias, w0 = b.

; what is perceptron
; https://www.quora.com/What-does-weight-mean-in-terms-of-neural-networks

; Weights near zero means changing this input will not change the output. Negative weights mean increasing this input will decrease the output. A weight decides how much influence the input will have on the output.
; https://hackernoon.com/everything-you-need-to-know-about-neural-networks-8988c3ee4491

; https://towardsdatascience.com/the-differences-between-artificial-and-biological-neural-networks-a8b46db828b7
; https://towardsdatascience.com/deep-learning-versus-biological-neurons-floating-point-numbers-spikes-and-neurotransmitters-6eebfa3390e9
; https://miro.medium.com/max/1400/1*T4ARzySpEQvEnr_9pc78pg.jpeg
; https://en.wikipedia.org/wiki/Artificial_neuron

; An artificial neuron has a body in which computations are performed, and a number of input channels and one output channel, similar to a real biological neuron.
; https://www.sciencedirect.com/topics/earth-and-planetary-sciences/artificial-neural-network

; https://en.wikipedia.org/wiki/Biological_neuron_model
; https://en.wikipedia.org/wiki/Artificial_neuron
; https://en.wikipedia.org/wiki/Neuron
; https://en.wikipedia.org/wiki/Artificial_neural_network
; How do Artificial Neural Networks learn?

; bias
; positive weight
; negative weight

; https://en.wikipedia.org/wiki/Mathematics_of_artificial_neural_networks
; https://en.wikipedia.org/wiki/Connectionism

(qam
  (q "")
  (a "")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

(qam
  (q "")
  (a "")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

(qam
  (q "")
  (a "")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

(qam
  (q "")
  (a "")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

(qam
  (q "")
  (a "")
  (m "Ryszard Tadeusiewicz, Tomasz Gąciarz, Barbara Borowik, Bartosz Leper: Odkrywanie właściwości sieci neuronowych"))

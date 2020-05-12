(ns pl.tomaszgigiel.quizzes.packs.others-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Why did the syntaxt error occur?")
  (a (require '(uncomplicate.fluokitten.core)))
  ;(a ((((uncomplicate.fluokitten.core/curry + 3) 1) 2) 3))
  (a false "TODO:")
  (m ""))

(qam
  (q "Evaluate {:a 1 :a 2 :b 3}")
  (at (read-string "{:a 1 :a 2 :b 3}") IllegalArgumentException)
  (a "unable to compile source file")
  (m ""))

(qam
  (q "Evaluate (into {:a 3} {:a 1 :b 2})")
  (a (= {:a 1 :b 2} (into {:a 3} {:a 1 :b 2})))
  (a false "TODO: why?")
  (m ""))

(qam
  (q "Evaluate (into {:c 3} {:a 1 :b 2})")
  (a (= {:c 3 :a 1 :b 2} (into {:c 3} {:a 1 :b 2})))
  (a false "TODO: why?")
  (m ""))

(qam
  (q "Discuss dorun vs. doall.")
  (a false "TODO:")
  (m ""))

(qam
  (q "What is a duck typing?")
  (a "an application of the duck test, to determine if an object can be used for a particular purpose")
  (a "if it walks like a duck and it quacks like a duck, then it must be a duck")
  (a "an object's suitability is determined by the presence of certain methods and properties, rather than the type of the object itself")
  (m "https://en.wikipedia.org/wiki/Duck_typing"))

(qam
  (q "Example of a duck typing.")
  (a (defn duck   [] {:quack (fn [] (str "i can quack, so i am a duck"))}))
  (a (defn parrot [] {:quack (fn [] (str "i can quack, so i am a duck"))}))
  (a (= (((duck) :quack)) (((parrot) :quack))))
  (m "https://en.wikipedia.org/wiki/Duck_typing"))

(qam
  (q "Discuss = vs. ==.")
  (a false "TODO:")
  (m ""))

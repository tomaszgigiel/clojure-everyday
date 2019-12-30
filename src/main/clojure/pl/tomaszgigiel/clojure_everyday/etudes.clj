(ns pl.tomaszgigiel.clojure-everyday.etudes
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:gen-class))

(defmacro q "question" [s] s)
(defmacro a "answer"
  ([test message] `(tst/is ~test ~message))
  ([message] `(a true ~message)))
(defmacro m "metadata" [s] s)

(defmacro qam
  "question answer metadata"
  [q & body]
  (list 'tst/deftest (symbol (str q)) (cons 'tst/testing (cons q body))))

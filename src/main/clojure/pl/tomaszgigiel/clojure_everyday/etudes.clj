(ns pl.tomaszgigiel.clojure-everyday.etudes
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:gen-class))

(defmacro q "question" [s] s)

(defmulti answer
  "answer"
  (fn
    ([x] (type x))
    ([test message] :multi)))

(defmethod answer java.lang.String [message] (tst/is true message))
(defmethod answer java.lang.Boolean [test] (tst/is test))
(defmethod answer :multi [test message] (tst/is test message))

(defmacro a "answer"
  ([x] `(answer ~x))
  ([test message] `(answer ~test ~message)))

(defmacro m "metadata" [s] s)

(defmacro qam
  "question answer metadata"
  [q & body]
  (list 'tst/deftest (symbol (str q)) (cons 'tst/testing (cons q body))))

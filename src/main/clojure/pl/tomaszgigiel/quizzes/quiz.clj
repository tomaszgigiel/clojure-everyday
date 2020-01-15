(ns pl.tomaszgigiel.quizzes.quiz
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:gen-class))

(defmacro q "question" [s] s)

(defmacro a
  "answer"
  ([form] `(tst/is ~form nil))
  ([form msg] `(tst/is ~form ~msg)))

(defmacro at
  "answer thrown?"
  ([form c] (list 'tst/is (list 'thrown? c (list 'throw form)))))

(defmacro m "metadata" [s] s)

(defmacro qam
  "question answer metadata"
  [q & body]
  (list 'tst/deftest (symbol (str q)) (cons 'tst/testing (cons q body))))

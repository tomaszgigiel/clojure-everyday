(ns pl.tomaszgigiel.quizzes.parser
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:require [instaparse.core :as insta])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:gen-class))

; https://github.com/Engelberg/instaparse

(def INPUT
"
(qam
  (q \"Show that complex types are functions of their elements.\")
  (a (= ([:a :b] 0) :a) \"vector is a function, index 0 is an argument\")
  (a (= (map [:a :b :c :d :e] [0 2 4]) [:a :c :e]) \"passing a vector as a function argument\")
  (m \"Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, page 136\"))
"
)

(def GRAMMAR
"
S = <whitespaces> (NS <whitespaces>)* (FIXTURE <whitespaces>)* (QAM <whitespaces>) <whitespaces>*
NS = '(ns' anything ')'
FIXTURE = '(tst/use-fixtures' anything ')'
QAM = <'('> <'qam'> <whitespaces> (Q <whitespaces>)* (A <whitespaces>)* (M <whitespaces>)* <')'>
Q = <'('> <'q'> <whitespaces> anything <whitespaces> <')'>
A = <'('> <'a'> <whitespaces> anything <whitespaces> <')'>
M = <'('> <'m'> <whitespaces> anything <whitespaces> <')'>
<whitespaces> = #'\\s*'
<anything> = (#'.')*
"
)

(def qam-parser (insta/parser GRAMMAR))

(qam-parser INPUT)

(insta/transform {:Q str :A str :M str} (qam-parser INPUT))

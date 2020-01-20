(ns pl.tomaszgigiel.quizzes.parser
  (:require [clojure.tools.logging :as log])
  (:require [instaparse.core :as insta])
  (:gen-class))

(defn parsed [grammar input t]
  (insta/transform t ((insta/parser grammar) input)))

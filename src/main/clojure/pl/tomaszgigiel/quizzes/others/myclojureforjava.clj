(ns pl.tomaszgigiel.quizzes.others.myclojureforjava
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:gen-class
    :name pl.tomaszgigiel.quizzes.others.myclojureforjava
    :methods [#^{:static true} [foo [int int] int]]))

(defn foo [a b]
  (+ a b))

(defn -foo
  "A Java-callable wrapper around the 'binomial' function."
  [a b]
  (foo a b))

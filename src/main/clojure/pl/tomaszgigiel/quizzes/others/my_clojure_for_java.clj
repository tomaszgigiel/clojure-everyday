(ns pl.tomaszgigiel.quizzes.others.my-clojure-for-java
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:gen-class
    :name pl.tomaszgigiel.myclojureforjava
    :methods [#^{:static true} [myfunction [int int] int]]))

(defn foo [a b]
  (+ a b))

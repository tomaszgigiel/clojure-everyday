(ns pl.tomaszgigiel.quizzes.core
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:require [pl.tomaszgigiel.quizzes.cmd :as cmd])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:gen-class))

(defn foo [a])

(defn -main [& args]
  "quizzes: ask for everything, ultimately data for flashcards"
  (let [{:keys [uri options exit-message ok?]} (cmd/validate-args args)]
    (if exit-message
      (cmd/exit (if ok? 0 1) exit-message)
      (foo (first args))))
  (log/info "ok")
  (shutdown-agents))

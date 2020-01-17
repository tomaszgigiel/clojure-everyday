(ns pl.tomaszgigiel.quizzes.core
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:require [pl.tomaszgigiel.quizzes.cmd :as cmd])
  (:require [pl.tomaszgigiel.quizzes.parser :as parser])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:require [pl.tomaszgigiel.utils.resources :as resources])
  (:gen-class))


(defn simple-save [q]
  (spit "target/test.txt" q))

(defn simple-print [q]
  (doall (map println q)))

(defn quizzes [f]
  (let [q (parser/parsed
            (-> "quiz-grammar.bnf" resources/from-resources-uri .toString)
            (-> "quiz_joc_07_01_test.clj" resources/from-resources-uri .toString slurp)
            {:anything str})]
    (f q)))

(defn -main [& args]
  "quizzes: ask for everything, ultimately data for flashcards"
  (let [{:keys [uri options exit-message ok?]} (cmd/validate-args args)]
    (if exit-message
      (cmd/exit (if ok? 0 1) exit-message)
      (quizzes simple-print)))
  (log/info "ok")
  (shutdown-agents))

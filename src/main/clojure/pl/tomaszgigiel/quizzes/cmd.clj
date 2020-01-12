(ns pl.tomaszgigiel.quizzes.cmd
  (:require [clojure.string :as string])
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:require [clojure.tools.logging :as log])
  (:gen-class))

(def cli-options
  [["-h" "--help"]])

(defn usage [options-summary]
  (->> ["quizzes: ask for everything, ultimately data for flashcards"
        ""
        "Usage: java -jar /path/to/quizzes-uberjar.jar"
        ""
        "Options:"
        options-summary
        ""
        "Please refer to the manual page for more information."]
       (string/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn validate-args
  "Validate command line arguments. Either return a map indicating the program
  should exit (with a error message, and optional ok status), or a map
  indicating the action the program should take and the options provided."
  [args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    (cond
      (:help options) ; help => exit OK with usage summary
      {:exit-message (usage summary) :ok? true}
      errors ; errors => exit with description of errors
      {:exit-message (error-msg errors)}
      ;; custom validation on arguments
      (= 0 (count arguments))
      {:options options}
      :else ; failed custom validation => exit with usage summary
      {:exit-message (usage summary)})))

(defn exit [status msg]
  (log/info msg)
  (System/exit status))

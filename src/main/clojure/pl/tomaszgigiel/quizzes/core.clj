(ns pl.tomaszgigiel.quizzes.core
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:require [pl.tomaszgigiel.quizzes.cmd :as cmd])
  (:require [pl.tomaszgigiel.quizzes.parser :as parser])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:require [pl.tomaszgigiel.utils.resources :as resources])
  (:import freemarker.template.Configuration)
  (:import freemarker.template.Template)
  (:import freemarker.template.TemplateExceptionHandler)
  (:import freemarker.template.Version)
  (:gen-class))

(defn freemarker-cfg []
  (doto (Configuration. Configuration/VERSION_2_3_29)
    ;(.setClassForTemplateLoading (class pl.tomaszgigiel.quizzes.core) "/templates") ; Win: OK, Ubuntu: TemplateNotFoundException
    (.setClassLoaderForTemplateLoading (.getContextClassLoader (Thread/currentThread)) "/templates") ; Win: OK, Ubuntu: OK
    (.setDefaultEncoding "UTF-8")
    (.setTemplateExceptionHandler TemplateExceptionHandler/RETHROW_HANDLER)
    (.setLogTemplateExceptions false)
    (.setWrapUncheckedExceptions true)
    (.setFallbackOnNullLoopVariable false)))

(defn fishcard [q template]
  (let [model (misc/group-by-better #(-> % first name) second (rest q))]
    (.process template model *out*)))

(defn quizzes []
  (let [q (parser/parsed
            (-> "quiz-grammar.bnf" resources/from-resources-uri .toString)
            (-> "packs/joc/joc_07_01_test.clj" resources/from-resources-uri .toString slurp)
            {:anything str})
        cfg (freemarker-cfg)
        template (.getTemplate cfg "fishcard-anki.ftl")]
    (doall (map #(fishcard % template) q))))

(defn -main [& args]
  "quizzes: ask for everything, ultimately data for flashcards"
  (let [{:keys [uri options exit-message ok?]} (cmd/validate-args args)]
    (if exit-message
      (cmd/exit (if ok? 0 1) exit-message)
      (quizzes)))
  (log/info "ok")
  (shutdown-agents))

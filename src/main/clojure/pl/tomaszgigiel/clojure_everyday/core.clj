(ns pl.tomaszgigiel.clojure-everyday.core
  (:require [clojure.string :as string])
  (:require [clojure.tools.logging :as log])
  (:require [pl.tomaszgigiel.clojure-everyday.cmd :as cmd])
  (:require [pl.tomaszgigiel.utils.misc :as misc])
  (:gen-class))

(defn clojure-everyday [a] (log/info a))

(defn -main [& args]
  "clojure-everyday: Clojure everyday learning"
  (let [{:keys [uri options exit-message ok?]} (cmd/validate-args args)]
    (if exit-message
      (cmd/exit (if ok? 0 1) exit-message)
      (clojure-everyday (first args))))
  (log/info "ok")
  (shutdown-agents))

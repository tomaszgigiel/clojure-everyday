(ns pl.tomaszgigiel.utils.resources
  (:import java.io.File)
  (:import java.net.URI)
  (:require [clojure.java.io :as io])
  (:require [clojure.string :as string])
  (:gen-class))

(defn from-resources-uri [first & nexts]
  (let [f (io/resource first)
        separator (System/getProperty "file.separator")
        parts (conj nexts f)
        path (string/join separator parts)]
    (URI. path)))

(defn from-resources-url [first & nexts]
  (let [uri (apply from-resources-uri first nexts)]
    (.toURL uri)))

(defn from-resources-file [first & nexts]
  (let [uri (apply from-resources-uri first nexts)]
    (File. uri)))

(defn from-resources-path [first & nexts]
  (let [file (apply from-resources-file first nexts)]
    (.getAbsolutePath file)))

(defn from-resources-bytes [first & nexts]
  (let [file (apply from-resources-file first nexts)
        is (java.io.FileInputStream. file)
        result (byte-array (.length file))]
    (.read is result)
    (.close is)
    result))

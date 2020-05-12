(ns pl.tomaszgigiel.quizzes.packs.clojure-libs-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is the difference between require and use?")
  (a "require")
  (a "loads libs, skipping any that are already loaded")
  (a "use")
  (a "like require, but also refers to each lib's namespace using clojure.core/refer")
  (m "https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html")
  (m "https://stackoverflow.com/questions/871997/difference-between-use-and-require")
  (m "https://clojuredocs.org/clojure.core/require")
  (m "https://clojuredocs.org/clojure.core/use"))

(qam
  (q "What should be used: require or use?")
  (a "use e.g. (require '[clojure.string :as string])")
  (a "or (require '[clojure.string :refer :all])")
  (a "instead of (use 'clojure.string)")
  (m "https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html")
  (m "https://stackoverflow.com/questions/871997/difference-between-use-and-require")
  (m "https://clojuredocs.org/clojure.core/require")
  (m "https://clojuredocs.org/clojure.core/use"))

(qam
  (q "How to load libs in REPL?")
  (a "(require '(clojure.string))")
  (a "(clojure.string/upper-case \"aa\")")
  (a "(require '[clojure.string :as s])")
  (a "(s/upper-case \"aa\")")
  (m "https://clojuredocs.org/clojure.core/require"))

(qam
  (q "How to load libs in non-REPL code?")
  (a "use ns")
  (a (nil? (ns my-project.core
             "This namespace is mine."
             (:require [clojure.string :as string])
             (:import (java.util Date GregorianCalendar)))))
  (m "https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html"))

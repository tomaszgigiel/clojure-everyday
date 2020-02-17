(defproject quizzes "1.0.0.0-SNAPSHOT"
  :description "quizzes: ask for everything, ultimately data for flashcards"
  :url "http://tomaszgigiel.pl"
  :license {:name "Apache License"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.cli "0.4.2"]
                 [org.clojure/tools.logging "0.5.0"]
                 [uncomplicate/fluokitten "0.9.1"]
                 [instaparse/instaparse "1.4.10"]
                 [org.freemarker/freemarker "2.3.29"]
                 [org.clojure/math.numeric-tower "0.0.4"]]

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources" "src/test/clojure/pl/tomaszgigiel/quizzes"]
  :target-path "target/%s"
  :jar-name "quizzes.jar"
  :uberjar-name "quizzes-uberjar.jar"
  :main pl.tomaszgigiel.quizzes.core
  :aot [pl.tomaszgigiel.quizzes.core]
  :profiles {:test {:resource-paths ["src/test/resources"]}
             :interop {:main pl.tomaszgigiel.quizzes.others.myclojureforjava :aot :all}}
)

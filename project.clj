(defproject clojure-everyday "1.0.0.0-SNAPSHOT"
  :description "clojure-everyday: Clojure everyday learning"
  :url "http://tomaszgigiel.pl"
  :license {:name "Apache License"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/tools.cli "0.4.2"]
                 [org.clojure/tools.logging "0.5.0"]
                 [uncomplicate/fluokitten "0.9.1"]]

  :source-paths ["src/main/clojure"]
  :test-paths ["src/test/clojure"]
  :resource-paths ["src/main/resources"]
  :target-path "target/%s"
  :jar-name "clojure-everyday.jar"
  :uberjar-name "clojure-everyday-uberjar.jar"
  :profiles {:test {:resource-paths ["src/test/resources"]}
             :dev {:resource-paths ["src/test/resources"]}}
)

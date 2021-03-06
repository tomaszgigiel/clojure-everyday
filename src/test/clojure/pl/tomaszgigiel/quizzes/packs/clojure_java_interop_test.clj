(ns pl.tomaszgigiel.quizzes.packs.clojure-java-interop-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "How to lookup and call a Clojure function in Java? (simple)")
  (a "package pl.tomaszgigiel.quizzes;")
  (a "import clojure.java.api.Clojure;")
  (a "import clojure.lang.IFn;")
  (a "//<dependency>")
  (a "//  <groupId>org.clojure</groupId>")
  (a "//  <artifactId>clojure</artifactId>")
  (a "//  <version>1.10.1</version>")
  (a "//</dependency>")
  (a "class JavaWithClojureSimplestApp {")
  (a "	public static void main(String[] args) {")
  (a "    IFn plus = Clojure.var(\"clojure.core\", \"+\");")
  (a "    long result = (Long) plus.invoke(1, 2, 3);")
  (a "    System.out.println(result);")
  (a "	}")
  (a "}")
  (m "https://clojure.org/reference/java_interop#_calling_clojure_from_java"))

(qam
  (q "How to lookup and call a Clojure function in Java? (strong, clojure code)")
  (a "(ns pl.tomaszgigiel.quizzes.others.myclojureforjava")
  (a "  (:gen-class")
  (a "    :name pl.tomaszgigiel.quizzes.others.myclojureforjava")
  (a "    :methods [#^{:static true} [foo [int int] int]]))")
  (a "(defn foo [a b]")
  (a "  (+ a b))")
  (a "(defn -foo")
  (a "  \"A Java-callable wrapper around the 'binomial' function.\"")
  (a "  [a b]")
  (a "  (foo a b))")
  (m "https://stackoverflow.com/questions/2181774/calling-clojure-from-java"))

(qam
  (q "How to lookup and call a Clojure function in Java? (strong, java code)")
  (a "package pl.tomaszgigiel.quizzes;")
  (a "import pl.tomaszgigiel.quizzes.others.myclojureforjava;")
  (a "class JavaWithClojureStrongApp {")
  (a "	public static void main(String[] args) {")
  (a "		int result = myclojureforjava.foo(1, 2);")
  (a "		System.out.println(result);")
  (a "	}")
  (a "}")
  (m "https://stackoverflow.com/questions/2181774/calling-clojure-from-java"))

(qam
  (q "How to lookup and call a Clojure function in Java? (strong, msdos)")
  (a "pushd %~dp0\\..\\..")
  (a "REM rmdir /s /q target")
  (a "call lein with-profile interop do clean, uberjar")
  (a "\"%JAVA_HOME%\"\\bin\\javac -cp target\\uberjar\\quizzes-uberjar.jar .\\src\\main\\java\\pl\\tomaszgigiel\\quizzes\\JavaWithClojureStrongApp.java -d .\\target")
  (a "\"%JAVA_HOME%\"\\bin\\java -cp target;target\\uberjar\\quizzes-uberjar.jar pl.tomaszgigiel.quizzes.JavaWithClojureStrongApp")
  (a "pause")
  (a "popd")
  (m "https://stackoverflow.com/questions/2181774/calling-clojure-from-java"))

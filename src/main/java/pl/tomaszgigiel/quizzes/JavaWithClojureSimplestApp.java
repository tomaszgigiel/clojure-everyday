package pl.tomaszgigiel.quizzes;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

//<dependency>
//  <groupId>org.clojure</groupId>
//  <artifactId>clojure</artifactId>
//  <version>1.10.1</version>
//</dependency>

class JavaWithClojureSimplestApp {
	public static void main(String[] args) {
		IFn plus = Clojure.var("clojure.core", "+");
		long result = (Long) plus.invoke(1, 2, 3);
		System.out.println(result);
	}
}

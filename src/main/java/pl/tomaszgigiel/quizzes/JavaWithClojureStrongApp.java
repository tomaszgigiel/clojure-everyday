// <classpathentry excluding="pl/tomaszgigiel/quizzes/JavaWithClojureStrongApp.java" kind="src" path="src/main/java"/>
// because "pl.tomaszgigiel.quizzes.others.myclojureforjava" in this jar
// see run-java-interop.bat
package pl.tomaszgigiel.quizzes;

import pl.tomaszgigiel.quizzes.others.myclojureforjava;

class JavaWithClojureStrongApp {
	public static void main(String[] args) {
		int result = myclojureforjava.foo(1, 2);
		System.out.println(result);
	}
}

(ns pl.tomaszgigiel.quizzes.packs.poor-man-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "Closures are poor man's objects and vice versa - What does this mean?")
  (a "closures and objects are ideas that are expressible in terms of each other, and none is more fundamental than the other")
  (m "https://stackoverflow.com/questions/2497801/closures-are-poor-mans-objects-and-vice-versa-what-does-this-mean"))

(qam
  (q "Closures are poor man's objects - What does this mean?")
  (a "consider Haskell")
  (a "Haskell is a functional language")
  (a "Haskell has no language level support for real objects")
  (a "Haskell can model objects using closures")
  (m "https://stackoverflow.com/questions/2497801/closures-are-poor-mans-objects-and-vice-versa-what-does-this-mean"))

(qam
  (q "Objects are poor man's closures - What does this mean?")
  (a "consider Java")
  (a "Java is an object-oriented programming language")
  (a "Java has no language level support for real lexical closures")
  (a "Java can model closures using anonymous inner classes")
  (a "that can close over the variables available in lexical scope (provided they're final)")
  (m "https://stackoverflow.com/questions/2497801/closures-are-poor-mans-objects-and-vice-versa-what-does-this-mean"))

(qam
  (q "How to model objects using closures?")
  (a "consider Haskell")
  (a "Haskell is a functional language")
  (a "Haskell has no language level support for real objects")
  (a "Haskell can model objects using closures")
  (m "https://stackoverflow.com/questions/2497801/closures-are-poor-mans-objects-and-vice-versa-what-does-this-mean"))

(qam
  (q "How to model objects using closures (Clojure)?")
  (a (defn bot [x] {:coords [x] :forward (fn [] (bot (+ x 1))) :backward (fn [] (bot (- x 1)))}))
  (a (= (:coords ((:forward ((:forward (bot 0)))))) [2])))

(qam
  (q "How to model closures using objects (Java)?")
  (a "class MyThread")
  (a "{")
  (a "    public static void main(String[] args)")
  (a "    {")
  (a "        //Anonymous Inner class implements or extends")
  (a "        Thread t = new Thread(new Runnable()")
  (a "        {")
  (a "            public void run()")
  (a "            {")
  (a "                System.out.println(1);")
  (a "            }")
  (a "        });")
  (a "        t.start();")
  (a "        System.out.println(0);")
  (a "    }")
  (a "}"))

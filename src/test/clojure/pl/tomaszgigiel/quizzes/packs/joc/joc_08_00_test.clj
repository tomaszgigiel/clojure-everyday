(ns pl.tomaszgigiel.quizzes.packs.joc.joc-08-00-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "List times of Clojure.")
  (a "read time")
  (a "macro-expansion time")
  (a "compile time")
  (a "runtime")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8. Macros"))

(qam
  (q "What kinds of problems do macros solve?")
  (a "to transform an expression into something else, before runtime")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8. Macros"))

(qam
  (q "What can you do with macro?")
  (a "transform forms")
  (a "combine forms")
  (a "change forms")
  (a "control evaluation of arguments")
  (a "control resolution of arguments")
  (a "manage resources")
  (a "build functions")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8. Macros"))

(qam
  (q "What is ->?")
  (a "thread macro")
  (a (= (-> 25 Math/sqrt int (list 10)) (list (int (Math/sqrt 25)) 10)))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8. Macros"))

(qam
  (q "List differences textual form of program vs. actual form of program")
  (a "there is no distinction")
  (a "a program is the data that composes the program")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1 Data is code is data"))

(qam
  (q "Execute (eval '(list 1 2))")
  (a (list 1 2))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1 Data is code is data"))

(qam
  (q "Execute (eval (list 1 2))")
  (at (eval (list 1 2)) ClassCastException "Integer cannot be cast to clojure.lang.IFn")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1 Data is code is data"))

(qam
  (q "Execute (eval (list (symbol \"+\") 1 2))")
  (a (= (eval (list (symbol "+") 1 2)) 3))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1 Data is code is data"))

(qam
  (q "What is the main reason that eval is problematic?")
  (a "the binding used for evaluation are global")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "How to make eval less evil?")
  (a "restrict the use of specific bindings to eval")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "What is `?")
  (a "syntax-quote")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "What is ~?")
  (a "~unqote")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "What is ~@?")
  (a "unquote-splice")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "How to garner the value of the built bindings at runtime?")
  (a "`'~x")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "Example of build let bindings at compile time")
  (a (defn contextual-eval [ctx expr] (eval `(let [~@(mapcat (fn [[k v]] [k `'~v]) ctx)] ~expr))))
  (a (= (contextual-eval '{a 1 b 2} '(+ a b)) 3))
  (a (= (contextual-eval '{a 1 b 2} '(let [a 1000] (+ a b))) 1002))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "Execute (let [x 9 y '(- x)] [`y ``y ``~y ``~~y (contextual-eval {'x 36} ``~~y)])")
  (a (defn contextual-eval [ctx expr] (eval `(let [~@(mapcat (fn [[k v]] [k `'~v]) ctx)] ~expr))))
  (a (= (let [x 9 y '(- x)] (str `y)) "pl.tomaszgigiel.quizzes.packs.joc.joc-08-00-test/y"))
  (a (= (let [x 9 y '(- x)] (str ``y)) "(quote pl.tomaszgigiel.quizzes.packs.joc.joc-08-00-test/y)"))
  (a (= (let [x 9 y '(- x)] (str ``~y)) "pl.tomaszgigiel.quizzes.packs.joc.joc-08-00-test/y"))
  (a (= (let [x 9 y '(- x)] (str ``~~y)) "(- x)"))
  (a (= (let [x 9 y '(- x)] (str (contextual-eval {'x 36} ``~~y))) "-36"))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.1 Syntax-quote, unquote, and splicing"))

(qam
  (q "List macro rules of thumb")
  (a "dont write a macro if a function will do")
  (a "write an example usage")
  (a "expand an example by hand")
  (a "use macroexpand, macroexpand-1, clojure.walk/macroexpand-all to undersand")
  (a "remember macroexpand-all doesnt use the same logic as compiler")
  (a "experiment at the REPL")
  (a "break complicated into smaller")
  (a "")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.1.2 Macro rules of thumb"))

(qam
  (q "Indicate the macro's advantage over HOF.")
  (a "code in way natural to your problem domain")
  (a "and maintain runtime efficiency")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.2 Defining control structures"))

(qam
  (q "What is implemented via macros in Clojure?")
  (a "most control structures")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.2 Defining control structures"))

(qam
  (q "")
  (a "")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.2 Defining control structures"))

(qam
  (q "")
  (a "")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.2 Defining control structures"))

(qam
  (q "")
  (a "")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, Chapter 8.2 Defining control structures"))

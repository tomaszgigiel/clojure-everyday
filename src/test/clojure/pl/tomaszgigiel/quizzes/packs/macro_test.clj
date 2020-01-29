(ns pl.tomaszgigiel.quizzes.packs.macro-test
  (:require [clojure.test :as tst])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is the difference between a quote and a syntax quote?")
  (q "What is the difference between \"'\" and \"`\"?")
  (a "the single-quote operator:")
  (a (= '(+ 1 2) (read-string "(+ 1 2)")) "1. yields the unevaluated form")
  (a (= (let [x 1] '(+ ~x 2)) (read-string "(+ (clojure.core/unquote x) 2)")) "2. is not canceled out by the syntax-unquote operator")
  (a (= (read-string "'(+ 1 2)") (read-string "(quote (+ 1 2))")) "3. syntax sugar")
  (a "the syntax-quote operator:")
  (a (= `(+ 1 2) (read-string "(clojure.core/+ 1 2)")) "1. yields the unevaluated form (with namespaces added)")
  (a (= (let [x 1] `(+ ~x 2)) (read-string "(clojure.core/+ 1 2)")) "2. is canceled out by the syntax-unquote operator")
  (a "3. no syntax sugar")
  (m "https://cljs.github.io/api/syntax/quote")
  (m "https://cljs.github.io/api/syntax/syntax-quote")
  (m "https://clojuredocs.org/clojure.core/quote")
  (m "https://8thlight.com/blog/colin-jones/2012/05/22/quoting-without-confusion.html")
  (m "https://stackoverflow.com/questions/26485514/clojure-difference-between-quote-and-syntax-quote"))

(qam
  (q "Discuss unquote.")
  (q "Discuss \"~\".")
  (a (= (let [x 1] `(+ ~x ~(dec 2))) (read-string "(clojure.core/+ 1 1)")) "is canceled out only by the syntax-unquote operator")
  (m "https://clojuredocs.org/clojure.core/unquote"))

(qam
  (q "Discuss unquote-splicing.")
  (q "Discuss \"@\" (vector).")
  (a (= (let [x `(2 3)] `(1 ~x)) (read-string "(1 (2 3))")))
  (a (= (let [x `(2 3)] `(1 ~@x)) (read-string "(1 2 3)")))
  (a (= `(1 ~@{2 3 4 5} 6) (read-string "(1 [2 3] [4 5] 6)")))
  (m "https://clojuredocs.org/clojure.core/unquote-splicing"))

(qam
  (q "Discuss unquote-splicing (map, e.g. `{1 2 ~@[3 4]}).")
  (q "Discuss \"@\" (map).")
  (a (= (try (eval (read-string "`{1 2 ~@[3 4]}")) (catch java.lang.RuntimeException e "error in clojure")) "error in clojure"))
  (a (= `(hash-map 1 2 ~@[3 4]) (read-string "(clojure.core/hash-map 1 2 3 4)")) "workaround")
  (a (= `{1 ~@[2 3] 4 ~@[5 6]} {1 2 3 4 5 6}) "ok, an even number of forms")
  (m "https://clojuredocs.org/clojure.core/unquote-splicing"))

(qam
  (q "List the macro hidden arguments.")
  (a "&env")
  (a "&form")
  (a "inside the body of defmacro you can call it to get an information")
  (m "https://dzone.com/articles/clojure-env-and-form"))

(qam
  (q "Discuss the macro hidden argument &env.")
  (a (defmacro show-env [] (mapv (fn [x] [(keyword x) x]) (keys &env))))
  (a (= (eval "(let [foo 1 boo 2] (show-env))") [[:foo 1] [:boo 1]]))
  (a (defmacro show-env [] (mapv (fn [x] [(.name x) (.sym x)]) (vals &env))))
  (a (= (eval "(let [foo 1 boo 2] (show-env))") [["foo" 1] ["boo" 2]]))
  (a false "why exception without eval?")
  (m "https://dzone.com/articles/clojure-env-and-form")
  (m "https://www.javadoc.io/doc/org.clojure/clojure/latest/clojure/lang/Compiler.LocalBinding.html"))

(qam
  (q "Discuss the macro hidden argument &env (how to return symbol?).")
  (a (defmacro show-env [] (mapv (fn [x] [(class x) (name x) (str x) x]) (keys &env))))
  (a (= (eval "(let [foo 1 boo 2] (show-env))") [[clojure.lang.Symbol "foo" "foo" 1] [clojure.lang.Symbol "boo" "boo" 2]]))
  (a false "not a symbol")
  (a false "why exception without eval?")
  (m "https://dzone.com/articles/clojure-env-and-form"))

(qam
  (q "Discuss the macro hidden argument &form.")
  (a false "todo")
  (m "https://dzone.com/articles/clojure-env-and-form"))

(qam
  (q "Discuss the multi-arity macro.")
  (a false "todo")
  (m "https://stackoverflow.com/questions/25566146/multiple-arity-in-defmacro-of-clojure/25569059"))

(qam
  (q "Why did the exception occur?")
  (a (def person-class {:get-full-name (fn [this] (str (:first-name this) " " (:last-name this)))}))
  (a (def john (merge person-class  {:first-name "John" :last-name "Smith"})))
  (a (defmacro call [this method & xs] `(let [this# ~this] ((~method this#) this# ~@xs))))
  ;(a (= (call john :get-full-name) "John Smith"))
  (a false "todo")
  (m "https://stackoverflow.com/questions/5024211/clojure-adding-functions-to-defrecord-without-defining-a-new-protocol"))

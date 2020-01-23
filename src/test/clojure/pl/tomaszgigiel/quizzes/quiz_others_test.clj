(ns pl.tomaszgigiel.quizzes.quiz-others-test
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
  (q "Discuss the weird characters.")
  (a "() - list")
  (a "[] - vector")
  (a "{} - map")
  (a "# - dispatch character")
  (a "#{} - set")
  (a "#_ - discard")
  (a "#\".\" - regular expression")
  (a "#() - anonymous function")
  (a "#' - var quote")
  (a "## - symbolic values")
  (a "#inst, #uuid, and #js etc. - tagged literals")
  (a "%, %n, %& - anonymous function arguments")
  (a "@ - deref")
  (a "^ (and #^) - metadata")
  (a "' - quote")
  (a "; - comment")
  (a ": - keyword")
  (a ":: - auto-resolved keyword")
  (a "#: and #:: - namespace map syntax")
  (a "/ - namespace separator")
  (a "\\ - character literal")
  (a "$ - inner class reference")
  (a "->, ->>, some->, cond->, as-> etc. - threading macros")
  (a "` - syntax quote")
  (a "~ - unquote")
  (a "~@ - unquote splicing")
  (a "<symbol># - gensym")
  (a "#? - reader conditional")
  (a "#?@ - splicing reader conditional")
  (a "*var-name* - \"earmuffs\"")
  (a ">!!, <!!, >!, and <! - core.async channel macros")
  (a "<symbol>? - predicate suffix")
  (a "<symbol>! - unsafe operations")
  (a "_ - unused argument")
  (a ", - whitespace character")
  (a "#= reader eval")
  (m "https://clojure.org/guides/weird_characters"))

(qam
  (q "What is the difference between require and use?")
  (a "require")
  (a "loads libs, skipping any that are already loaded")
  (a "use")
  (a "like require, but also refers to each lib's namespace using clojure.core/refer")
  (a "but instead of (use 'clojure.string)")
  (a "use e.g. (require '[clojure.string :as string])")
  (a "or (require '[clojure.string :refer :all])")
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
  (a (ns my-project.core
       "This namespace is mine."
       (:require [clojure.string :as string])
       (:import (java.util Date GregorianCalendar))))
  (m "https://8thlight.com/blog/colin-jones/2010/12/05/clojure-libs-and-namespaces-require-use-import-and-ns.html"))

(qam
  (q "Discuss the macro hidden arguments.")
  (a "inside the body of defmacro you can call &env and &form to get an information")
  (a (defmacro show-env [] [&env]))
  ;(a (= (show-env) [nil]) "nil, but...")
  ;(a (not (blank? (re-matches #"\{foo .+LocalBinding.+ boo .+LocalBinding.+\}" (let [foo "a" boo "b"] (show-env))))) "not nil")
  
  (m "https://dzone.com/articles/clojure-env-and-form")
  (m "https://stackoverflow.com/questions/25566146/multiple-arity-in-defmacro-of-clojure/25569059"))

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

(qam
  (q "Why did the syntaxt error occur?")
  (a (require '(uncomplicate.fluokitten.core)))
  ;(a ((((uncomplicate.fluokitten.core/curry + 3) 1) 2) 3))
  (a false "todo")
  (m ""))

(qam
  (q "Evaluate {:a 1 :a 2 :b 3}")
  (at (read-string "{:a 1 :a 2 :b 3}") IllegalArgumentException)
  (a "unable to compile source file")
  (m ""))

(qam
  (q "Evaluate (into {:a 3} {:a 1 :b 2})")
  (a (= {:a 1 :b 2} (into {:a 3} {:a 1 :b 2})))
  (a false "why?")
  (m ""))

(qam
  (q "Evaluate (into {:c 3} {:a 1 :b 2})")
  (a (= {:c 3 :a 1 :b 2} (into {:c 3} {:a 1 :b 2})))
  (a false "why?")
  (m ""))

(qam
  (q "Discuss dorun vs. doall.")
  (a false "todo")
  (m ""))

(qam
  (q "What is a duck typing?")
  (a "an application of the duck test, to determine if an object can be used for a particular purpose")
  (a "if it walks like a duck and it quacks like a duck, then it must be a duck")
  (a "an object's suitability is determined by the presence of certain methods and properties, rather than the type of the object itself")
  (m "https://en.wikipedia.org/wiki/Duck_typing"))

(qam
  (q "Example of a duck typing.")
  (a (defn duck   [] {:quack (fn [] (str "i can quack, so i am a duck"))}))
  (a (defn parrot [] {:quack (fn [] (str "i can quack, so i am a duck"))}))
  (a (= (((duck) :quack)) (((parrot) :quack))))
  (m "https://en.wikipedia.org/wiki/Duck_typing"))

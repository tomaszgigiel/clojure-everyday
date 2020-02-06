(ns pl.tomaszgigiel.quizzes.packs.joc.joc-07-04-test
  (:require [clojure.test :as tst])
  (:require [uncomplicate.fluokitten.core :as fluokitten])
  (:require [pl.tomaszgigiel.quizzes.test-config :as test-config])
  (:require [pl.tomaszgigiel.quizzes.quiz :refer [qam q a at m]])
  (:require [pl.tomaszgigiel.utils.misc :as misc]))

(tst/use-fixtures :once test-config/once-fixture)
(tst/use-fixtures :each test-config/each-fixture)

(qam
  (q "What is A* pathfinding?")
  (a "pronounced A-star")
  (a "a best-first pathfinding algorithm")
  (a"maintains a set of candidate paths through a world with the purpose of finding the least-difficult path to some goal")
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4. Putting it all together: A* pathfinding")
  (m "https://en.wikipedia.org/wiki/A*_search_algorithm"))

(qam
  (q "How to represent a world in A* pathfinding?")
  (a (def world [[  1   1   1   1    1]
                 [999 999 999 999    1]
                 [  1   1   1   1    1]
                 [  1 999 999 999  999]
                 [  1   1   1   1    1]]))
  (m "Michael Fogus, Chris Houser: The Joy of Clojure, 2nd, 7.4.1. The world"))

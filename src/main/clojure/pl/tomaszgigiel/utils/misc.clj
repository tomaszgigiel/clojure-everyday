(ns pl.tomaszgigiel.utils.misc
  (:gen-class))

; http://benashford.github.io/blog/2014/12/27/group-by-and-transducers/
(defn group-by-better [key-f val-f data]
  (reduce
    (fn [m d]
      (let [k (key-f d)
            v (get m k [])]
        (assoc m k (conj v (val-f d)))))
    {}
    data))

; https://github.com/clojure/clojure/blob/clojure-1.10.1/src/clj/clojure/core.clj#L3884
(defmacro time-msecs
  [expr]
  `(let [start# (. System (nanoTime))
         ret# ~expr]
     (/ (double (- (. System (nanoTime)) start#)) 1000000.0)))

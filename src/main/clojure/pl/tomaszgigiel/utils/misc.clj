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

(ns real-clojure.iterate.core)


(comment

  (range 1 6))


(for [x (range 1 6)]
  (* x x))

(for [x (range 1 6)]
  (* x x))

(defn is-not-dividable-by-2 [y]
  (not  (= 0  (mod y 2))))

(for [x (range 1 6)
      :let [y (* x x)]
      :when (is-not-dividable-by-2  y)]
  y)



;Exercise

;; Exercise
;; Exercise loop return sequence of table 16 => 1 to 20

;Output should be
; (16 32 48 64 80 96 112 128 144 160 176 192 208 224 240 256 272 288 304 320)
(defn product-of-16 [value]
  (* value 16)
  )



;DoSeq
(doseq [x (range 1 21)]
  (println (str x " x 16 =" (* 16 x) ))
  (* 16 x)
  )









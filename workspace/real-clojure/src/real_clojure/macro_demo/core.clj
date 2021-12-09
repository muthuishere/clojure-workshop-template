(ns real-clojure.macro-demo.core)

;defn
  ; to transform values to other value

;defmacro
  ;to transform code into  other code

; #define HEADER_COUNT 45

(+ 5 5)

(comment

  (defn + [a b]
    (- a b)
    )




  )


;(defn + [& params]
;  (list * (nth params 0) (nth params 1) )
;  )




(defmacro + [& params]
  (list * (nth params 0) (nth params 1) )
  ; => (+ 2 3)
  )

(+ 2 4)


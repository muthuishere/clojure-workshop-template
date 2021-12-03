(ns real-clojure.destructure.core)


;Exercise
(def super-hero-data ["Peter Parker" "Spider Man" "MJ"])

;Create a method which accepts a variable , The Method should Print
;
; "Real Name : Peter Parker"
; "Alias : Spider Man"
;
;(defn print-data [input]
;
;  (let [
;
;
;        name (nth input 0)
;        alias (nth input 1)
;        ]
;
;    (println (str "Real Name : " name  ) )
;    (println (str "Alias : "  alias) )
;
;    )
;
;
;  )

;(defn print-data [input]
;
;  (let [
;
;        [name alias pair ] input
;
;
;        ]
;
;    (println (str "de Real Name : " name  ) )
;    (println (str "Alias : "  alias) )
;    (println (str "pair : "  pair) )
;
;
;    )
;
;
;  )


(defn print-data [ [name alias pair ]  ]



    (println (str "Real Name : " name  ) )
    (println (str "Alias : "  alias) )
    (println (str "pair : "  pair) )




  )

(print-data super-hero-data)

(ns real-clojure.multimethod.core)

(comment

  (conj [1 2] 3)
  (conj '(1 2) 3)


  )

;(defmulti welcome (fn [input]
;
;                    (type input)
;                    )
;          )
(defmulti welcome type )

(defmethod welcome java.lang.String [input]

  (str "Welcome , Your name is" input )
  )

(defmethod welcome java.lang.Long [input]

  (str "Welcome , Your id is" input )
  )


(defmethod welcome java.lang.Double [input]

  (str "Welcome , Your temparature is" input )
  )

;
;(defn welcome [input]
;
;  (cond
;
;    ( = java.lang.String (type input)) (str "Welcome , Your name is" input )
;    ( = java.lang.Long (type input)) (str "Welcome , Your id is" input )
;
;    )
;  ; Welcome Your name is xx
;
;  ; Welcome Your Id is 3443
;  )

(comment
  (welcome "Mrx")
  (welcome 25)
  (welcome 98.9)

  )
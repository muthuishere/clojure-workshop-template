(ns real-clojure.dates)





(defn number-to-three-character-month [number]


  (get  {1 "Jan" 2 "Feb" 3 "Mar" 4 "Apr" 5 "May" 6 "Jun" 7 "Jul" 8 "Aug" 9 "Sep" 10 "Oct" 11 "Nov" 12 "Dec"} number)
  
  )


;(number-to-three-character-month 2)


(defn add [ a b]

  (+ a b)
  
  )

;(add 2 3)
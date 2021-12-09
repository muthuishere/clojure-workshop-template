(ns real-clojure.atoms.core)


(def x  (atom 0) )


(println  @x)

;Swap for updating value based on previous value
(swap! x (fn [val]
           (+ 2 val)
           )
       )

(swap! x #(+ 2 %))




(swap! x inc)

;Reset for resetting a value to constant
(reset!  x 98)





(def heroes (atom  {:name "Spider Man" :movies 8} ) )



; How to do it?
;{:name "Spider Man" :movies 9}

(swap! heroes (fn [v]

                (assoc v :movies (inc  (get v :movies)))
                ))


(println @heroes)










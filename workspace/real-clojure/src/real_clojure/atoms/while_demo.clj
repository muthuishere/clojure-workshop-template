(ns real-clojure.atoms.while-demo)
;sum =0
;(for i=1 ; i< =n ;i++){
;  sum = sum + i
; }
;sum

(defn sum-of-numbers-recursion
  ([n] (sum-of-numbers-recursion 1 0 n))
  ([i sum n]
   (if (<= i n)
     (sum-of-numbers-recursion (inc i) (+ i sum) n)
     sum
     )

   ))
(comment

  )


(defn sum-of-numbers-loop [n]
  (loop [i 1 sum 0]
    (if (> i n)
      sum
      (recur (inc i) (+ sum i))
      )
    )

  )

(comment

  )

(defn sum-of-n-numbers [n]

  (let
    [
     i (atom 1)
     sum (atom 0)
     ]

    (while (<= @i n)

      (reset! sum (+ @sum @i))
      (swap! i inc)

      )
    @sum

    )
  )
(comment

  (time (sum-of-n-numbers 1000))

  (time (sum-of-numbers-recursion 1000))


  (time (sum-of-numbers-loop 1000))



  )






(ns real-clojure.channel-demo.sum-of-numbers-demo
  (:require [clojure.core.async :refer

             [chan  <! <!! >!  >!! thread go close! go-loop]
             ])
  )



(defn sum-of-numbers-loop [n]
  (println "Executed in" (.getName (Thread/currentThread)))
  (loop [i 1 sum 0]
    (if (> i n)
      sum
      (recur (inc i) (+ sum i))
      )
    )

  )


(def sum-of-numbers-channel (chan))
(def sum-of-numbers-result-channel (chan))


(go-loop [value (<! sum-of-numbers-channel)]

    (when   value
      ;(println "Sum of Numbers is" (sum-of-numbers-loop value))
      (>!! sum-of-numbers-result-channel {:input value :result  (sum-of-numbers-loop value) :processed (.getName (Thread/currentThread)) })

      (recur (<! sum-of-numbers-channel))
      )
    )



(comment

  (println "Called from" (.getName (Thread/currentThread)))

  (>!! sum-of-numbers-channel 10)
  (>!! sum-of-numbers-channel 100)
  ; recive the value
  (<!! sum-of-numbers-result-channel)

  (>!! sum-of-numbers-channel 100)
  (<!! sum-of-numbers-result-channel)

  )

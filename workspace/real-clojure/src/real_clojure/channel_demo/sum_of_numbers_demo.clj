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
;(def sum-of-numbers-result-channel (chan))


(go-loop [value (<! sum-of-numbers-channel)]

    (when   value
      (let [
             {:keys [callback-channel number] } value

            ]
        (>!! callback-channel
             {:input number :result  (sum-of-numbers-loop number) :processed (.getName (Thread/currentThread)) })

        )



      (recur (<! sum-of-numbers-channel))
      )
    )


(defn sum-of-numbers-with-concurrency [num]

  (let [
        input {:number num :callback-channel (chan)}
        ]
    (>!! sum-of-numbers-channel input)
    (get   (<!! (get input :callback-channel)) :result)
    )

  )

(comment

  (println "Called from" (.getName (Thread/currentThread)))

  ;(def input {:number 10 :callback-channel (chan)})
  ;(>!! sum-of-numbers-channel input)
  ;
  ;(<!! (get input :callback-channel))
  (sum-of-numbers-with-concurrency 10)

  )

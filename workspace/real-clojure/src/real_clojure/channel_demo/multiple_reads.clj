(ns real-clojure.channel-demo.multiple-reads
  (:require [clojure.core.async :refer

        [chan  <! <!! >!  >!! thread go close!]
                                                        ])
  )



(def echo-channel (chan))

; Get value from channel
;if it has value
; print it
;recur

; loop initial-value

;do some procesing

; recur

(go



  (loop [value (<! echo-channel)]

    (println "Changed" value)
    (recur (<! echo-channel))
    )



  )

(comment

  (>!! echo-channel "Hello Message 1")

  (>!! echo-channel "Hello Message 2")

  (close! echo-channel)

  ;Exercise , Try to exit the loop , when channel is closed

  )

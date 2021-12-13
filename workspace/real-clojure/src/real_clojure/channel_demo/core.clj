(ns real-clojure.channel-demo.core
  (:require [clojure.core.async :refer

             [chan  <! <!! >!  >!! thread go put! take!]
             ])
  )

;Concurrency is hard time

;Erlang

; Concurrency
  ;Conveyor Belt

; Actor Model Pattern


; CHannel

    ;listener

    ;sender channel



;Any Method , should not communicate with other method directly

; Go Blocks

  ; Only threads
















; we need channel
; put those

; chan



(def echo-channel (chan))

(go
  (let [value (<! echo-channel)]


    (println "Changed" value)
    )

  )


;Put Value in Channel

; Inside Go Block
;   >!
;
;  >!!

(comment

  ;(>!! echo-channel "Hello Concurrency")
  ;
  ;(go
  ;  (>! echo-channel "Hello Concurrency go block")
  ;  )

  (>!! echo-channel "Hello Message 1")




  ; Exercise , What will happen???
  (>!! echo-channel "Hello Message 2")



  )

; reader , which reads message from channel

; write messages




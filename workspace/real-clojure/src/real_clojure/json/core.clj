(ns real-clojure.json.core
  (:require [clojure.data.json :as json])
  )



(def spider-man
  {:name "Peter  Parker"
   :alias "Spider Man"
   :mentor {

            :name "Tony Stark"
            :alias "Iron Man"
            }
   } )

;Writing Map as JSON string
(json/write-str spider-man)

;Writing JSON into FIle
(spit "spiderman.json" (json/write-str spider-man))



(slurp "spiderman.json")

(json/read-str (slurp "spiderman.json"))

{:name "Peter  Parker" }

{"name"  "Peter  Parker" }

; To Convert String to Keyword

(keyword "alias")


; To Convert Keyword to String

(name :alias)





(json/read-str (slurp "spiderman.json")
               :key-fn (fn [key]
                         (print key)
                        ;; (keyword key)
                         )
               )





{:name "Peter  Parker"
 :alias "Spider Man"
 :mentor {

          :name "Tony Stark"
          :alias "Iron Man"
          }
 }



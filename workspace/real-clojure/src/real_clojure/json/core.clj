(ns real-clojure.json.core
  (:require [clojure.data.json :as json])

  (:import (java.time LocalDate)
           (java.time.format DateTimeFormatter)
           )
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
                         (str "super-hero-" key)
                         )
               )





;Exercise Modify the function so that, it will return like below
;{:name "Peter  Parker"
; :alias "Spider Man"
; :mentor {
;
;          :name "Tony Stark"
;          :alias "Iron Man"
;          }
; }



(json/read-str (slurp "spiderman.json")
               :key-fn (fn [key]
                         (keyword  key)
                         )
               )

(json/read-str (slurp "spiderman.json")
               :key-fn #(keyword  %))

(json/read-str (slurp "spiderman.json")
               :key-fn keyword)

;Exercise REad Users.json



















(defn string-to-date [input]
  (let [ pattern (DateTimeFormatter/ofPattern "yyyy-MM-dd")]
    (LocalDate/parse input pattern)
    )
  )


(comment

  (def input "1994-06-28" )

  (string-to-date input)


  )


(defn convert-dob-from-string-to-localdate [k v ]

  (if (= :date_of_birth k)
    (string-to-date v)
    v
    )
  )

;users.json
(json/read-str (slurp "users.json")
               :key-fn keyword
               :value-fn convert-dob-from-string-to-localdate
               )





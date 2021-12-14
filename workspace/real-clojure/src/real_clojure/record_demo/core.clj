(ns real-clojure.record-demo.core)

(defrecord SuperHero [name portrayed-by alias weapons])


;Create a record
(map->SuperHero {:name "Peter Parker" :portrayed-by "Toby Macguire" :alias "Spider Man"
                 :weapons ["web shooters"]
                 })

(->SuperHero "Peter Parker" "Toby Macguire" "Spider Man" ["web shooters"])

(def spider-man (SuperHero. "Peter Parker" "Toby Macguire" "Spider Man" ["web shooters"]))



(comment
  (get spider-man :name)

  (:name spider-man)


  ;this will throw error in record
  ( spider-man :name)



  ; Record special retrievals



  (.name spider-man)


  (= spider-man (SuperHero. "Peter Parker" "Toby Macguire" "Spider Man" ["web shooters"]))

  (assoc spider-man :portrayed-by "Tom Holland")

  (dissoc spider-man :portrayed-by )



  ; Exercise

  ; I need a variable ,
  ;
  ;Use Atom,  which can update portrayed by Tom Holland

  (def spider-man (atom (SuperHero. "Peter Parker" "Toby Macguire" "Spider Man" ["web shooters"])) )

  ;update spider-man portrayed-by to Tom Holland

  (swap! spider-man (fn [v]
                  (assoc v :portrayed-by "Tom Holland"))
         )


  (swap! spider-man   #(assoc % :portrayed-by "Tom Holland 4") )


  ; Without Anonymous , pass the function as it is
  ; the first parameter will be the one the value is set automatically
  (swap! spider-man  assoc :portrayed-by "Tom Holland 4" )






  )


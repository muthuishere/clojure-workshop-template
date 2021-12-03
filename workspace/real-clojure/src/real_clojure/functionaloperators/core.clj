(ns real-clojure.functionaloperators.core
  (:require [clojure.data.json :as json])
  )
;
(def products  (json/read-str (slurp "products.json") :key-fn keyword))

; Map is a function

(defn find-all-image-urls []

  ;(map (fn [input]
  ;       ;(get input :imageUrl )
  ;       ;(input :imageUrl)
  ;       (:imageUrl input)
  ;       )
  ;     products
  ;     )
  ;

  ;Using AnonyMous Function

  (map  #(:imageUrl %) products)

  )



(comment

  ; a simple function to flatten out merged arrays
  (flatten [[ 1 2 3] [7 8] ] )

  )
(defn find-all-reviews []
  ;Get all the reviews


  ;(flatten (map #(:reviews %) products))
  ;->> is a threaded macro which will place the result as the last argum,ent for a consequent function

  (->> products
       (map #(:reviews %) )
       (flatten)
       )


  )


(defn find-products-of-clothing-category []

  ;(filter (fn [input]
  ;           (= "Clothing"  (get input :category))
  ;          )
  ;        products
  ;        )
  (filter #(= "Clothing"  (% :category)) products )


  )
 (find-products-of-clothing-category)
;(count (find-products-of-clothing-category))

; Exercise

(defn find-categories-of [category]
  ;return products only of that category
  )




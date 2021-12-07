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

  ;Thread Last It will place all the arguments at end
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




(defn find-all-category [category]

  (->> products
       (filter #(= category (% :category)))
       )


  )


(comment

  ;
  ;(reduce (fn [a,c]
  ;          (+ a c)
  ;          ) [2 5 6] )
  ;
  ;(defn add [a b]
  ;  (+ a b)
  ;  )
  (reduce + [2 5 6] )

  ;With Initial Value 10
  (reduce + 10 [2 5 6] )





  )
;(find-all-category "Footwear")

(defn find-total-cost-of-footwear []


  (->> (find-all-category "Footwear")
       (reduce  #(+ %1 (get %2 :price))  0  )
       )




  )
;(find-total-cost-of-footwear)

; Concatenate All Manufacturer Names
;Exercise
(defn all-manufacturer-names-as-string []

  ;
  (->> products
       (reduce  #(str %1 (get %2 :manufacturer))  ""  )
       )
  )

;(all-manufacturer-names-as-string)

;TODO
(comment

  (distinct [ 2 3 4 2])

  )
 (defn find-all-categories []

   (->> products
        (map #(get % :category) )
        (distinct )
        )

   )

(defn find-all-user-emails []

  ;(let
  ;
  ;  [ reviews (flatten  (map #(get % :reviews) products))]
  ;
  ;
  ; (distinct  (map #(get-in % [:user :email]) reviews))
  ;
  ;  )

  (->> products
       (map #(get % :reviews))
       (flatten)
       (map #(get-in % [:user :email]))
       (distinct)
       )


  )
(count (find-all-user-emails))

;Exercise
;Count Number of Male Users Who Left reviews for Footwear Product
(defn count-of-male-users-who-left-reviews-for-Footwear []


  )



;
;
;find-all-city-and-users
;find-product-with-highest-number-of-reviews
;product-with-most-valuable-deal
;country-with-users-count
;manufacturer-and-product-count



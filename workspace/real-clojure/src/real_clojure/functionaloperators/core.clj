(ns real-clojure.functionaloperators.core
  (:require
    [clojure.data.json :as json]
    [clojure.core.async :refer

     [chan  <! <!! >!  >!! thread go close! go-loop]
     ]

    )
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

(->> products
     (filter #( = "Footwear" (get % :category)))
     (map #(get % :reviews))
     (flatten)
     (map  :user)
     (filter #( = "male" (get % :gender)))
     (count)
     )
  ;products
  ;filter for footwear
  ;reviews
  ;flatten
  ;user
  ;filter for male user


  )

(count-of-male-users-who-left-reviews-for-Footwear)
(comment



  (group-by #(get % :category) [
              {:category "a" :count 5}
              {:category "a" :count 8}
              {:category "b" :count 3}

              ])
  (group-by #(keyword (get % :category))  [
              {:category "a" :count 5}
              {:category "a" :count 8}
              {:category "b" :count 3}

              ])

  ;Another way
  (group-by  :category [
              {:category "a" :count 5}
              {:category "a" :count 8}
              {:category "b" :count 3}

              ])


  ;reduce   ;iterate a collection

  ;reduce-kv - Iterating & aggregation over a hash map

  (reduce-kv (fn [acc key value]

               (+ acc value )

               ) 0  {:a 1 :b 2 :c 3})




  (merge {:a 1} {:b 2 :a 5})

  (conj {:a 1} {:b 2 :a 5})


  (assoc {:a 1 } :b 2 )






  )
(defn find-all-city-and-users []

  ;city [User1 User2]

  (->> products
       (map  :reviews )
       (flatten)
       (map  :user)
       (group-by :city)
       (reduce-kv (fn [a city users]
                    (assoc a  (keyword city) (count users))
                  )
                  {} )
       )



  )
(defn find-all-overallrating-count []
  (->> products
       (group-by :overAllRating)
       (reduce-kv (fn [a k v]
                    (assoc a k  (count v) )
                    )
                  {})
       )
  )
(find-all-overallrating-count)


(defn find-manufacturer-and-product-count []
  (->> products
       (group-by  :manufacturer)
       (reduce-kv (fn [a k v]
                    (assoc a (keyword k) (count v) )
                    )
                  {}
                  ))
  )

(defn find-country-with-users-count []
  (->> products
       (map :reviews)
       (flatten)
       (map :user)
       (group-by :country)
       (reduce-kv (fn [a country user]
                    (assoc a (keyword country) (count user))
                    )
                  {}
                  )
       )
  )

(defn compare-products-based-on-review-count [product-x product-y]
  (let  [
         accumulator-review-count (count  (get product-x :reviews))
         current-review-count (count  (get product-y :reviews))
         ]

    (if ( > accumulator-review-count current-review-count)
      product-x
      product-y
      )
    )

  )
(defn find-product-with-highest-number-of-reviews []

  (->> products
       (reduce compare-products-based-on-review-count )
       )
  )

(find-product-with-highest-number-of-reviews)



;;country-with-users-count



;{:Muzzafarabad 2 :Raymond 3}
;(find-all-city-and-users)

; Home Assignments

;
;product-with-most-valuable-deal

(defn product-names-with-rating-greater-than [num]

  (->> products
       (filter #(>= num (get % :overAllRating)))
       (map :name)

       )

  )
(def product-names-with-rating-greater-than-channel (chan))

(go-loop [value (<! product-names-with-rating-greater-than-channel)]

  (when   value
    (let [
          {:keys [callback-channel number] } value

          ]
      (>!! callback-channel
           {:input number :result  (product-names-with-rating-greater-than number) :processed (.getName (Thread/currentThread)) })

      )



    (recur (<! product-names-with-rating-greater-than-channel))
    )
  )
(defn product-names-with-rating-greater-than-through-channel [num]

  (let [
        input {:number num :callback-channel (chan)}
        ]
    (>!! product-names-with-rating-greater-than-channel input)
    (get   (<!! (get input :callback-channel)) :result)
    )
  )
(comment

  (product-names-with-rating-greater-than-through-channel 3)

  )

;product-names-with-overallrating-greater-than-number
;Convert that into channel
  ;it will accept a number
  ;
  ;

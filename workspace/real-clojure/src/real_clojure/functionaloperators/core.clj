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
(find-all-image-urls)
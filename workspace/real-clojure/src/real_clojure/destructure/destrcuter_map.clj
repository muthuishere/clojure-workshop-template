(ns real-clojure.destructure.destrcuter-map)


(def product {:name "Macbook" :manufacturer "Apple" :price 90000 :quantity 2})

;Create a method to PrintInvoice which accepts product as an argument and print
;
;  Name : Macbook  Brand Apple
;  Total  : 90000 x 2 = 180000


(defn print-invoice [{:keys [name price manufacturer quantity] }]



    (println (str " Name : "  name " Brand " manufacturer))
    (println (str "Total  : " price " x " quantity "="  (* price quantity)))



  )

(print-invoice product)

;Home Assignment

(def spider-man {:name "Peter Parker" :alias "Spider Man" :mentor { :name "Tony Stark" :alias "Iron Man"}})
;create a method to print Mentor name



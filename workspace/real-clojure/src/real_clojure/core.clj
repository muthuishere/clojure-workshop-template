(ns real-clojure.core
(:gen-class)
  )

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


(defn -main [name age]
  
  ;Home Assignment
  ;COnvert String to Integer



  ; Accept a parameter called month and print its abbrevation

  ;lein run 2  => Feb
  ;lein run 4  => Apr
  (println "Type of name" (type name))
  (println "Type of age" (type age))

  (println "Hello " name age)
  )
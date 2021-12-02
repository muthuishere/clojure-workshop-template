(ns real-clojure.interop.core
  (:import
   (real_clojure.interop Location)
   (java.time LocalDateTime LocalDate)
   (java.time.format DateTimeFormatter)))





;Creating New Instance
(Location.)

;Creating New Instance WIth Parameters
(Location. 8.8017 78.1551)

(def my-location (Location. 8.8017 78.1551))

;(.latitude my-location)

(.longitude my-location)
(.-longitude my-location)

(.getLatitude my-location)

(print "Hello World")





;LocalDate.now()

(LocalDate/now)

(. LocalDate now)

(LocalDateTime/now)

(LocalDate/of 2021 11 21)

(. LocalDate of 2021 11 21)


(def today (LocalDate/now))

;LocalDateInstance.minusDays(54)

(.minusDays today 54)
(.plusMonths today 54)

(def today-as-string "2021-12-01")

(def pattern (DateTimeFormatter/ofPattern "yyyy-MM-dd"))

(def today  (LocalDate/parse today-as-string pattern))




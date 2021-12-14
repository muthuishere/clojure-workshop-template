(ns real-clojure.protocol-demo.register)



(defmulti register (fn [{:keys [provider]}]
                  (keyword  provider)
                  ))





(defmethod register :google [_]
  (do
    (println "Setting up Google API")
    (println "Redirect to Google Register Page")
    (println "Register in Google")
    (println "Complete Registration via Google")
    )
  )
(defmethod register :github [_]
  (do
    (println "Setting up Github API")
    (println "Redirect to Github Register Page")
    (println "Register in Github")
    (println "Complete Registration via Github")
    )
  )
(defmethod register :user-password [{:keys [data]}]
  (do
    (println "Get Registration info from user")
    (println "Registering with" data )
    (println "Complete Registration via User password" )
    )
  )

(comment


  ;Implement Multi method for
  (register {:provider "google" })
  (register {:provider "github" })
  (register {
          :provider "user-password"
          :data { :user "tmpuser" :password "tmppassword" :date_of_birth "2011-01-01"}
          }

         )



  )

(ns real-clojure.multimethod.login-app-with-multi)


(defmulti login (fn [{:keys [provider]}]
                  (keyword  provider)
                  ))





(defmethod login :google [_]
  (do
    (println "Setting up Google API")
    (println "Redirect to Google Login Page")
    (println "Choose the Google User")
    (println "Login via Google")
    )
  )
(defmethod login :github [_]
  (do
    (println "Setting up Github API")
    (println "Redirect to Github Login Page")
    (println "Login via Github")
    )
  )
(defmethod login :user-password [{:keys [data]}]
  (do
    (println "Get Credentials from user")
    (println "Logging in with" data )
    )
  )

(comment


  ;Implement Multi method for
  (login {:provider "google" })
  (login {:provider "github" })
  (login {
          :provider "user-password"
          :data { :user "tmpuser" :password "tmppassword"}
          }

         )



  )

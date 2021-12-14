(ns real-clojure.multimethod.login-app-with-multi)


(defmulti login (fn [_ provider]
                  provider))


(defmethod login :google [_ _]
  (do
    (println "Setting up Google API")
    (println "Redirect to Google Login Page")
    (println "Choose the Google User")
    (println "Login via Google")
    )
  )
(defmethod login :github [_ _]
  (do
    (println "Setting up Github API")
    (println "Redirect to Github Login Page")
    (println "Login via Github")
    )
  )
(defmethod login :user-password [data _]
  (do
    (println "Get Credentials from user")
    (println "Logging in with" data )
    )
  )

(comment

  ;(login {} :google)
  ;(login {} :github)
  ;

  ;Implement Multi method for 
  (login {:provider "google" })
  (login {:provider "github" })
  (login {:provider "user-password":data { :user "tmpuser" :password "tmppassword"} })



  )

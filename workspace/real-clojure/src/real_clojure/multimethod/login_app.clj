(ns real-clojure.multimethod.login-app)

;google
;github
;user-password



(defn login [data provider]

  (cond
    (=  provider :google) (do

                            (println "Setting up Google API")
                            (println "Redirect to Google Login Page")
                            (println "Choose the Google User")
                            (println "Login via Google")

                            )

    (=  provider :github) (do

                            (println "Setting up Github API")
                            (println "Redirect to Github Login Page")
                            (println "Login via Github")

                            )
    (=  provider :user-password) (do

                            (println "Get Credentials from user")
                            (println "Logging in with" data )

                            )



    )
  )

(comment
  (login {} :google)
  (login {} :github)
  (login {:user "user" :password "pass"} :user-password)


  ; Home Assignment
  ; Create Multi method for below

  ; Hint
  ;
  ;(defmethod login :google [_ _]
  ;
  ;
  ;  )



  )

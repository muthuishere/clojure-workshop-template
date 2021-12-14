(ns real-clojure.protocol-demo.authentication-with-protocol)


(defprotocol UserAuth

  (register [this])
  (login [this])

  )

(defrecord GoogleUserAuth [configuration]
  UserAuth
  (register [this]
    (println this)
    (println "Setting up Google API")
    (println "Redirect to Google Register Page")
    (println "Register in Google")
    (println "Complete Registration via Google")

    )
  (login [this]
    (println "Setting up Google API")
    (println "Redirect to Google Login Page")
    (println "Choose the Google User")
    (println "Login via Google")

    )


  )




(def google-auth-config (GoogleUserAuth. {:apiKey "XXX78738927932"}))


(comment

(register google-auth-config)
(login google-auth-config)

; Exercise for Github & User Password

  )

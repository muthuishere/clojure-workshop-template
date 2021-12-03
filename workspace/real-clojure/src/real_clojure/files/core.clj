(ns real-clojure.files.core)


(defn read-file [filename]
  (try
    (slurp filename)

    (catch Exception e

      (println (.toString e))
      ;(throw (Exception. "File Not exist"))
      (str "")
      )
    (finally
      (println "in Finally Block")
      )

    )
  )

(comment

  ;Writing to a file
  ; First Argument is File name
  ; Second is String
  (spit "readme.txt" "Hello Clojure")

  ;Reading a file
  (slurp "readme.txt")





  (read-file  "not-existant-file.txt")
  (read-file  "readme.txt")





  )
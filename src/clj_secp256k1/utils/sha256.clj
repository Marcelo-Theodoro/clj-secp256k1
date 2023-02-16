(ns clj-secp256k1.utils.sha256
  (:import java.security.MessageDigest))

(def hash-function (MessageDigest/getInstance "SHA-256"))

(defn generate
  "Create a sha256 hash from the input."
  [input]
  (let [formatter   (partial format "%02x")
        input-bytes (.getBytes input "UTF-8")]
    (->> input-bytes
         (.digest hash-function)
         (map formatter)
         (apply str))))

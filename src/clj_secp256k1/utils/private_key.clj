(ns clj-secp256k1.utils.private-key
  (:import (java.security SecureRandom)))

(defn generate
  "Generate a private-key."
  []
  (let [buffer        (byte-array 32)
        secure-random (SecureRandom.)]
    (.nextBytes secure-random buffer)
    buffer))

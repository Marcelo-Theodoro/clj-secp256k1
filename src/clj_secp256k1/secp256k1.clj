(ns clj-secp256k1.secp256k1
  (:import (fr.acinq.secp256k1 Secp256k1)))

(def secp256k1 (Secp256k1/get))

(defn verify-schnorr
  "Verify a Schnorr signature."
  ^Boolean
  [^bytes signature ^bytes message ^bytes public-key]
  (try
    (.verifySchnorr secp256k1 signature message public-key)
    (catch fr.acinq.secp256k1.Secp256k1Exception _
      false)))

(defn sign-schnorr
  "Create a Schnorr signature."
  ^bytes
  [^bytes message ^bytes secret-key ^bytes aux-rand32]
  (.signSchnorr secp256k1 message secret-key aux-rand32))

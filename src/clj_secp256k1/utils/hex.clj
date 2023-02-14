(ns clj-secp256k1.utils.hex
  (:import (fr.acinq.secp256k1 Hex)))

(defn encode
  "Encode a byte-array into a string."
  [data]
  (Hex/encode data))

(defn decode
  "Decode a string to byte-array."
  [data]
  (Hex/decode data))

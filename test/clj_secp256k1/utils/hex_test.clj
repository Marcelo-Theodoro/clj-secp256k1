(ns clj-secp256k1.utils.hex-test
  (:require [clj-secp256k1.utils.hex :as utils.hex]
            [clojure.test :refer [deftest is testing]]))

(deftest encode-test
  (testing "Given some byte-array, hex-encode should return the correct conversion"
    (let [byte-array-input (byte-array [53 68 56 95 21 50 50 -31 78 -27 82 -100 -38 -77 -25
                                        -80 70 29 21 16 28 99 -119 75 -10 -49 79 45 86 18 -107
                                        75])
          string-expected  "3544385f153232e14ee5529cdab3e7b0461d15101c63894bf6cf4f2d5612954b"]
      (is (= string-expected
             (utils.hex/encode byte-array-input))))))

(deftest decode-test
  (testing "Given some hex string, hex-decode should return the correct conversion"
    (let [hex-input           "3544385f153232e14ee5529cdab3e7b0461d15101c63894bf6cf4f2d5612954b"
          byte-array-expected (byte-array [53 68 56 95 21 50 50 -31 78 -27 82 -100 -38 -77 -25
                                           -80 70 29 21 16 28 99 -119 75 -10 -49 79 45 86 18 -107
                                           75])]
      (is (= (seq byte-array-expected)
             (seq (utils.hex/decode hex-input)))))))

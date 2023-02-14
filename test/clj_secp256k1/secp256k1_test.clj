(ns clj-secp256k1.secp256k1-test
  (:require [clj-secp256k1.aux.test-vectors :as aux.test-vectors]
            [clj-secp256k1.secp256k1 :as secp256k1]
            [clj-secp256k1.utils.hex :as utils.hex]
            [clojure.test :refer [are deftest is]]))

(deftest verify-schnorr-test
  (are [assertion]
       (let [signature            (utils.hex/decode (:signature assertion))
             message              (utils.hex/decode (:message assertion))
             public-key           (utils.hex/decode (:public-key assertion))
             predicate-succeeded? (:predicate assertion)]
         (is (predicate-succeeded? (secp256k1/verify-schnorr signature message public-key))))

    aux.test-vectors/assertion-1
    aux.test-vectors/assertion-2
    aux.test-vectors/assertion-3
    aux.test-vectors/assertion-4
    aux.test-vectors/assertion-5
    aux.test-vectors/assertion-6
    aux.test-vectors/assertion-7
    aux.test-vectors/assertion-8
    aux.test-vectors/assertion-9
    aux.test-vectors/assertion-10
    aux.test-vectors/assertion-11
    aux.test-vectors/assertion-12
    aux.test-vectors/assertion-13
    aux.test-vectors/assertion-14
    aux.test-vectors/assertion-15))

(deftest sign-schnorr-test
  (are [assertion]
       (let [message    (utils.hex/decode (:message assertion))
             secret-key (utils.hex/decode (:secret-key assertion))
             aux-rand32 (utils.hex/decode (:aux-rand32 assertion))
             signature  (:signature assertion)]
         (is (= signature
                (utils.hex/encode (secp256k1/sign-schnorr message secret-key aux-rand32)))))

    aux.test-vectors/assertion-1
    aux.test-vectors/assertion-2
    aux.test-vectors/assertion-3
    aux.test-vectors/assertion-4))

(deftest create-public-key-test
  (let [private-key         (utils.hex/decode "67e56582298859ddae725f972992a07c6c4fb9f62a8fff58ce3ca926a1063530")
        expected-public-key (utils.hex/decode "04c591a8ff19ac9c4e4e5793673b83123437e975285e7b442f4ee2654dffca5e2d2103ed494718c697ac9aebcfd19612e224db46661011863ed2fc54e71861e2a6")]
    (is (= (seq expected-public-key)
           (seq (secp256k1/create-public-key private-key))))))

(deftest compress-public-key-test
  (let [uncompressed-public-key        (utils.hex/decode "04c591a8ff19ac9c4e4e5793673b83123437e975285e7b442f4ee2654dffca5e2d2103ed494718c697ac9aebcfd19612e224db46661011863ed2fc54e71861e2a6")
        expected-compressed-public-key (utils.hex/decode "02c591a8ff19ac9c4e4e5793673b83123437e975285e7b442f4ee2654dffca5e2d")]
    (is (= (seq expected-compressed-public-key)
           (seq (secp256k1/compress-public-key uncompressed-public-key))))))

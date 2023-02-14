(ns clj-secp256k1.secp256k1-test
  (:require [clj-secp256k1.aux.test-vectors :as aux.test-vectors]
            [clj-secp256k1.secp256k1 :as secp256k1]
            [clj-secp256k1.utils.hex :as utils.hex]
            [clojure.test :refer [are deftest is]]
            [clojure.string :as string]))

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
             signature  (-> assertion :signature string/lower-case)]
         (is (= signature
                (utils.hex/encode (secp256k1/sign-schnorr message secret-key aux-rand32)))))

    aux.test-vectors/assertion-1
    aux.test-vectors/assertion-2
    aux.test-vectors/assertion-3
    aux.test-vectors/assertion-4))

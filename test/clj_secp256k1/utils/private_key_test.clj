(ns clj-secp256k1.utils.private-key-test
  (:require [clj-secp256k1.utils.private-key :as utils.private-key]
            [clojure.test :refer [deftest is testing]]
            [clj-secp256k1.secp256k1 :as secp256k1]))

(deftest generate-test
  (let [private-key (utils.private-key/generate)]

    (testing "should be bytes"
      (is (bytes? private-key)))

    (testing "should have lenght of 32"
      (is (= 32
             (count private-key))))

    (testing "it can be used to generate a valid public-key"
      (let [public-key (secp256k1/create-public-key private-key)]

        (testing "public-key should be in bytes"
          (is (bytes? public-key)))

        (testing "public-key should have 65 bytes"
          (is (= 65
                 (count public-key))))
        (testing "public-key should start with 4"
          (is (= 4
                 (first public-key))))))))

(ns clj-secp256k1.utils.sha256-test
  (:require [clj-secp256k1.utils.sha256 :as utils.sha256]
            [clojure.test :refer [are deftest is]]))

(deftest generate-test
  (are [input expected]
       (is (= expected
              (utils.sha256/generate input)))
      ;; input     ;; expected                                                   
    "testing"    "cf80cd8aed482d5d1527d7dc72fceff84e6326592848447d2dc0b0e87dfc9a90"
    "1234567890" "c775e7b757ede630cd0aa1113bd102661ab38829ca52a6422ab782862f268646"
    "[0,some,1]" "21d8f84e69a874da1d22b6d4ca5cdea513943f56a7b548e7dc8ca22a40f1e4a0"
    "💣"         "1cbdfc8afbfc04c307852f44edb4723474a85d7b3cd67fe41582a2b014e79ad7"))

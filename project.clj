(defproject com.github.Marcelo-Theodoro/clj-secp256k1 "0.1.0"
  :description "Wrapper around ACINQ/secp256k1-kmp bindings."
  :url "https://github.com/Marcelo-Theodoro/clj-secp256k1"
  :license {:name "MIT License"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [fr.acinq.secp256k1/secp256k1-kmp-jni-jvm-mingw "0.7.1"]
                 [fr.acinq.secp256k1/secp256k1-kmp-jni-jvm-linux "0.7.1"]
                 [fr.acinq.secp256k1/secp256k1-kmp-jni-jvm-darwin "0.7.1"]]
  :plugins [[lein-cljfmt "0.9.2"]
            [lein-kibit "0.1.8"]]
  :aliases {"lint"     ["do" ["cljfmt" "check"] ["kibit"]]
            "lint-fix" ["do" ["cljfmt" "fix"]]})

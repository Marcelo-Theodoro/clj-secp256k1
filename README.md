[![Clojars Project](https://img.shields.io/clojars/v/com.github.Marcelo-Theodoro/clj-secp256k1.svg)](https://clojars.org/com.github.Marcelo-Theodoro/clj-secp256k1)

# clj-secp256k1

A Clojure library that defines a wrapper around [secp256k1-kmp](https://github.com/ACINQ/secp256k1-kmp).
As [secp256k1-kmp](https://github.com/ACINQ/secp256k1-kmp), we try to follow as much of the original [secp256k1](https://github.com/bitcoin-core/secp256k1) lib as possible.

Extra functions that can be helpful on the day-to-day can the added to the `clj-secp256k1.utils` namespace.

Contributions for new functions and documentation are welcome.


## Usage
```clojure
(ns example.core
  (:require [clj-secp256k1.secp256k1 :as secp256k1]
            [clj-secp256k1.utils.hex :as utils.hex]
            [clj-secp256k1.utils.sha256 :as utils.sha256]))

(def some-secret-key "c90fdaa22168c234c4c6628b80dc1cd129024e088a67cc74020bbea63b14e5c9")
(def some-public-key "dd308afec5777e13121fa72b9cc1b7cc0139715309b086c960e18fd969774eb8")
(def some-aux-rand32 "c87aa53824b4d7ae2eb035a2b5bbbccc080e76cdc6d1692c4b0b62d798e6d906")

(defn -main
  []
  (let [message      (-> (utils.sha256/generate "message that will be signed")
                         utils.hex/decode)
        secret-key   (utils.hex/decode some-secret-key)
        public-key   (utils.hex/decode some-public-key)
        aux-rand32   (utils.hex/decode some-aux-rand32)
        sig          (secp256k1/sign-schnorr message secret-key aux-rand32)]
    (assert (secp256k1/verify-schnorr sig message public-key))))
```

## Installation

### Linux and Apple(Intel)

* Leiningen
```clojure
[com.github.Marcelo-Theodoro/clj-secp256k1 "0.3.0"]
```

* deps.edn
```clojure
com.github.Marcelo-Theodoro/clj-secp256k1 {:mvn/version "0.3.0"}
```

### Note for Apple Silicon Users
* You must execute the project with a x86_64 version of Java. Adding `:java-cmd` in your `project.clj` with a custom path for a compatible Java should work.
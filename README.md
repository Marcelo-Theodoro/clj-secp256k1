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
            [clj-secp256k1.utils.hex :as hex]))

(defn -main []
  (secp256k1/verify-schnorr 
  (hex/decode "E907831F80848D1069A5371B402410364BDF1C5F8307B0084C55F1CE2DCA821525F66A4A85EA8B71E482A74F382D2CE5EBEEE8FDB2172F477DF4900D310536C0")
  (hex/decode "0000000000000000000000000000000000000000000000000000000000000000")
  (hex/decode "F9308A019258C31049344F85F89D5229B531C845836F99B08601F113BCE036F9")))
  ;; true
```

TODO: More examples


## Installation

### Linux and Apple(Intel)

* Leiningen
```clojure
[com.github.Marcelo-Theodoro/clj-secp256k1 "0.1.0"]
```

* deps.edn
```clojure
com.github.Marcelo-Theodoro/clj-secp256k1 {:mvn/version "0.1.0"}
```

### Note for Apple Silicon Users
* You must execute the project with a x86_64 version of Java. Adding `:java-cmd` in your `project.clj` with a custom path for a compatible Java should work.
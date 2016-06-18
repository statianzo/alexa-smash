(ns workit.app
  (:require [cljs.nodejs :as nodejs]))

(def alexa (nodejs/require "alexa-app"))

(def app
  (let [App (.-app alexa)]
    (App. "Smash")))

(defn intent [title handler]
  (.intent app (name title) handler))

(defn request [payload]
  (.request app payload))

(intent :top (fn [req res]
  (.say res "Smash rules")))

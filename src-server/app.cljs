(ns workit.app
  (:require [cljs.nodejs :as nodejs]))

(def alexa (nodejs/require "alexa-app"))

(def ^:export app (.app. alexa "Smash"))

(defn intent [title handler]
  (.intent app (name title) handler))

(intent :top (fn [req res]
  (.say res "Smash rules")))


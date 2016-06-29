(ns smash.eventhubs
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [smash.http :as http]
            [smash.html :as html]
            [cljs.core.async :refer [<!]]))

(def fields
  [:rank :name :score :daily :weekly :monthly :votes :fa :me :un :sd :vote])

(def url "http://www.eventhubs.com/tiers/ssb4/")

(defn- tierrow [cells]
  (zipmap fields cells))

(defn- tierstable [body]
  (as-> (html/load body) x
      (x ".tierstable")
      (.find x "tbody")
      (.find x "tr")
      (.find x "td")
      (map html/wrap x)
      (map #(.text %) x)
      (partition 12 x)
      (map tierrow x)))

(defn tierlist []
  (go (tierstable (<! (http/fetch url)))))

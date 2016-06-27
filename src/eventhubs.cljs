(ns smash.eventhubs
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [smash.http :as http]
            [smash.html :as html]
            [cljs.core.async :refer [<!]]))

(def url "http://www.eventhubs.com/tiers/ssb4/")

(defn- tierrow [_ tr]
  (-> (html/load tr)
      (apply ["td"])))

(defn- tierstable [body]
  (-> (html/load body)
      (apply [".tierstable"])
      (.find "tbody")
      (.find "tr")
      (.find "td")
      (partition 12)))

(defn tierlist []
  (go (tierstable (<! (http/fetch url)))))

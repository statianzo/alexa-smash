(ns smash.eventhubs
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [smash.http :as http]
            [smash.html :as html]
            [cljs.core.async :refer [<!]]))

(def url "http://www.eventhubs.com/tiers/ssb4/")

(defn- tierstable [body]
  (-> (html/load body)
      (apply [".tierstable"])
      (.find "tbody")
      (.find "tr")))

(defn tierlist []
  (go (tierstable (<! (http/fetch url)))))

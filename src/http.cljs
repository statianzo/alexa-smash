(ns smash.http
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.nodejs :as nodejs]
            [cljs.core.async :as async :refer [>! promise-chan]]))

(def request (nodejs/require "request"))

(defn fetch [opts]
  (let [c (promise-chan)
        jsopts (clj->js opts)]
    (request jsopts
             (fn [err res body]
               (go (>! c body))))
    c))

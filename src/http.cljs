(ns smash.http
  (:require [cljs.nodejs :as nodejs]
            [cljs.core.async :as a]))

(def request (nodejs/require "request"))

(defn fetch [opts]
  (let [c (a/promise-chan)
        jsopts (clj->js opts)]
    (request jsopts
             (fn [err res body]
               (if err (println err) nil)
               (a/put! c body)))
    c))

(ns workit.server
  (:require [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)

(def port 3001)
(def express (nodejs/require "express"))

(defn render-page []
  "<h1>HTML Rules</h1>")

(defn handle-request [req res]
  (.send res (render-page)))

(defn -main []
  (let [app (express)]
    (.get app "/" handle-request)
    (.listen app port (fn []
                        (println (str "Server started on port " port))))))

(set! *main-cli-fn* -main)

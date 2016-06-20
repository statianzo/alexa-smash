(ns smash.core
  (:require [cljs.nodejs :as nodejs]
            [smash.app :as alexa]))

(nodejs/enable-util-print!)

(defn -main []
  (println "Running" ))

(set! *main-cli-fn* -main)

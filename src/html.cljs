(ns smash.html
  (:require [cljs.nodejs :as nodejs]))

(def cheerio (nodejs/require "cheerio"))

(extend-type cheerio
  ISeqable
  (-seq [nodes] (array-seq nodes 0)))

(defn load [src]
  (.load cheerio src))

(defn wrap [node]
  (cheerio node))

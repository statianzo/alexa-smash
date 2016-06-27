(ns smash.html
  (:require [cljs.nodejs :as nodejs]))

(def cheerio (nodejs/require "cheerio"))

(defn load [src]
  (.load cheerio src))

(ns workit.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests async]]
            [workit.app :as alexa]))

(def top
  (clj->js
    {
     "version" "1.0"
     "session"
     {
      "new" false
      "sessionId" "amzn1.echo-api.session.abeee1a7-aee0-41e6-8192-e6faaed9f5ef"
      "attributes" {}
      "application" {"applicationId" "amzn1.echo-sdk-ams.app.000000-d0ed-0000-ad00-000000d00ebe"}
      "user" {"userId" "amzn1.account.AM3B227HF3FAM1B261HK7FFM3A2" }
      }
     "request"
     {
      "type" "IntentRequest"
      "requestId" "amzn1.echo-api.request.6919844a-733e-4e89-893a-fdcb77e2ef0d"
      "intent"
      {
       "name" "top"
       }
      }}))

(deftest test-top
  (async done
    (let [p (alexa/request top)]
      (.then p (fn [res] 
                 (is (clojure.string/includes? (.. res -response -outputSpeech -ssml) "Smash rules"))
                 (done))))))

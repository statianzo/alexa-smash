(defproject workit "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.36"]]
  :plugins [[lein-cljsbuild "1.1.3"]]

  :cljsbuild {
              :builds [{
                        :id "server"
                        :source-paths ["src-server"]
                        :compiler {
                                   :main workit.server
                                   :output-to "resources/public/js/server/server.js"
                                   :output-dir "resources/public/js/server"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]}
  )

(defproject workit "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.36"]]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.4-3"]]

  :cljsbuild {
              :builds [{
                        :id "dev"
                        :figwheel {
                                   :autoload true}
                        :source-paths ["src-server"]
                        :compiler {
                                   :main workit.core
                                   :output-to "resources/public/js/server/dev.js"
                                   :output-dir "resources/public/js/server"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]}
  )

(defproject smash "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.36"]
                 [org.clojure/core.async "0.2.385"]]
  :plugins [[lein-cljsbuild "1.1.3"]
            [lein-figwheel "0.5.4-3"]
            [lein-doo "0.1.6"]]

  :cljsbuild {
              :builds [{
                        :id "dev"
                        :figwheel {
                                   :autoload true}
                        :source-paths ["src"]
                        :compiler {
                                   :main smash.core
                                   :output-to "lib/dev.js"
                                   :output-dir "lib"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}
                       {
                        :id "test"
                        :source-paths ["src" "test"]
                        :compiler {
                                   :main smash.runner
                                   :output-to "lib/test.js"
                                   :output-dir "lib"
                                   :target :nodejs
                                   :optimizations :none
                                   :source-map true}}]}
  )

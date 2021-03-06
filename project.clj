(defproject readr "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
		 [enlive "1.1.5"]
                 [ring/ring-jetty-adapter "1.2.1"]
                 [hiccup "1.0.5"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler readr.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}
   :uberjar {:aot :all}}
  :uberjar-name "readr.jar"
  :main ^:skip-aot readr.handler
  :min-lein-version "2.0.0")

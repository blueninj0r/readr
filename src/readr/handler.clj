(ns readr.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [readr.web :as web]
            [readr.parser :as parser])
  (:gen-class))

(defn get-urls []
  (let [months (range 1 10)]
    (flatten (map
              #(parser/get-urls-from-page (str "http://www.tofugu.com/2007/" %1))
              months))))

(defroutes app-routes
  (GET "/" [] (web/index (get-urls)))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& [port]]
  (let [port (Integer. (or port (System/getenv "PORT") 8080))]
    (jetty/run-jetty app {:port port :join? false})))

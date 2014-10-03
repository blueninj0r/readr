(ns readr.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [readr.web :as web]
            [readr.parser :as parser])
  (:gen-class))

(defn get-urls [base-url]
  (let [months (range 1 13)]
    (flatten (map
              #(parser/get-urls-from-page (str base-url  %1))
              months))))

(defroutes app-routes
  (GET "/" {{base-url :site year :year} :params} (web/index (get-urls (str "http://" base-url "/" year "/"))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))

(defn -main [& [port]]
  (let [port (Integer. (or port (System/getenv "PORT") 8080))]
    (jetty/run-jetty app {:port port :join? false})))

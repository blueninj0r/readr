(ns readr.parser
  (:require [net.cgrand.enlive-html :as html]))

(def base-url "http://www.tofugu.com")

(defn get-page-contents [url]
  (let [page (html/html-resource url)]
    (str page)))

(defn get-urls [url]
  (let [years (range 2000 2015)
        months (range 1 13)]
    (map #(get-page-contents (str url "/" %1)))))

(defn get-article-details [year]
  (let [year-url (str base-url "/" year)]
    (map #(get-page-contents (java.net.URL. (str year-url "/" %1))) (range 1 10))))

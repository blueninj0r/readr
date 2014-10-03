(ns readr.parser
  (:require [net.cgrand.enlive-html :as html]))

(def base-url "http://www.tofugu.com")

(defn get-page
  [url]
  (let [req-url (java.net.URL. url)]
    (try
      (html/html-resource req-url)
      (catch Exception e nil))))

(defn get-urls-from-page
  [url]
  (let [page (get-page url)
        urls (html/select page [:h1.entry-title :a])]
    (->> urls reverse vec)))

(ns readr.web
  (:require [readr.parser :as parser]
            [hiccup.core :as hic]
            [hiccup.page :as page]))

(defn article-element
  [article-url]
  [:li
   [:a {:href (:href article-url) :title (:title article-url)}
    (:title article-url)]])

(defn index
  [article-urls]
  (page/html5
   [:head
    [:title "readr"]
    ]
   [:body
    [:ol {:class "articles"}
     (map article-element article-urls)]]))

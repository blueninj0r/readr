(ns readr.web
  (:require [readr.parser :as parser]
            [hiccup.core :as hic]
            [hiccup.page :as page]))

(defn get-href
  [article-url]
  (get-in article-url [:attrs :href]))

(defn get-title
  [article-url]
  (let [title (get-in article-url [:attrs :title])]
    (if (nil? title)
      (str (first ( :content article-url)))
      title)))

(defn article-element
  [article-url]
  [:li
   [:a {:href (get-href article-url) :title (get-title article-url)}
    (get-title article-url)]])

(defn index
  [article-urls]
  (page/html5
   [:head
    [:title "readr"]
    ]
   [:body
    [:ol {:class "articles"}
     (map article-element article-urls)]]))

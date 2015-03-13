(ns compojure-example.core
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.json :as middleware]
            [ring.adapter.jetty :as jetty]
            [compojure.handler :as handler]))

(defn- get-article [id]
	{:body {:body "<p>body text</p>"
	        :id id
	        :url (str "http://www.newscorp.com/articles/" id)}
	 :headers {"Cache-Control" "no-transform,public,max-age=10"}})

(defroutes app-routes
  (GET "/api/v1/article/:id" [id] (get-article id)) 
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-params)
      (middleware/wrap-json-response)))

(defn -main [& args]
  (jetty/run-jetty app))

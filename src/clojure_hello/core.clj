(ns clojure-hello.core
  (:use compojure.core 
	compojure.route
	hiccup.core 
	hiccup.page-helpers
	ring.adapter.jetty))

(defn layout [content]
  (html [:html
	 [:head
	  [:title "Hello world application"]]
	 [:body
	  content
	  [:br]
	  [:br]
	  [:div
	   "View the source code for this application on "
	   (link-to "http://github.com/ericlavigne/clojure-hello"
		    "Github.")]]]))

(defn index []
  (layout [:p "Hello world!"]))

(defroutes app
  (GET "/" [] (index)))

(defn main [& args]
  (run-jetty app {:port 8080}))

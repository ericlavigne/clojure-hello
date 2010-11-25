(ns clojure-hello.test.core
  (:use [clojure-hello.core] :reload)
  (:use [clojure.test]))

(deftest says-hello
  (let [request {:uri "/" :request-method :get}
	response (app request)]
    (is (= 200 (:status response))
	"Expect status 200 (success) for GET /")
    (is (.contains (:body response) "Hello")
	"Response page should contain the greeting 'Hello'.")))


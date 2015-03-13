# Clojure Ring example

Minimal JSON REST API example with Clojure, Ring and Compojure

## Running

	$ lein deps
	$ lein ring server-headless

## Deploying

	$ lein ring uberjar
	$ lein -jar target/uberjar/compojure-example-0.1.0-SNAPSHOT-standalone.jar
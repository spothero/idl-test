run-server: ## Runs the server
	./gradlew server:run
.PHONY: run-server

run-client: ## Runs the client
	./gradlew client:run
.PHONY: run-client

help: ## Prints this help command
	@grep -E '^[a-zA-Z0-9_-]+:.*?## .*$$' $(MAKEFILE_LIST) |\
		sort | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'
.DEFAULT_GOAL := help

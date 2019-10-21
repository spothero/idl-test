BINS = venv/bin/grpc-test venv/bin/thrift-test

.PHONY: all
all: ${BINS}

${BINS}: setup

.PHONY: setup
setup: venv ## Sets up the project
	venv/bin/python setup.py develop

venv: ## Sets up virtualenv
	virtualenv venv

.PHONY: run-grpc
run-grpc: ${BINS} ## Runs grpc example
	venv/bin/grpc-test

.PHONY: run-thrift
run-thrift: ${BINS} ## Runs thrift example
	venv/bin/thrift-test client

.PHONY: help
help: ## Prints this help command
	@grep -E '^[a-zA-Z0-9_-]+:.*?## .*$$' $(MAKEFILE_LIST) |\
		sort | \
		awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}'

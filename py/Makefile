BINS = venv/bin/grpc-test venv/bin/thrift-test

.PHONY: all
all: ${BINS}

${BINS}: setup

.PHONY: setup
setup: venv
	venv/bin/python setup.py develop

venv:
	virtualenv venv

.PHONY: run-grpc
run-grpc: ${BINS}
	venv/bin/grpc-test

.PHONY: run-thrift
run-thrift: ${BINS}
	venv/bin/thrift-test


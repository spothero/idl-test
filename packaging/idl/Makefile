pwd = $(shell pwd)
uid_gid = $(shell stat -c "%u:%g" ${pwd})

grpc_dir = grpcv1

java_out_dir = java-out
py_out_dir = gen-py-grpc
go_out_dir = gen-go-grpc
out_dirs = ${java_out_dir} ${py_out_dir} ${go_out_dir}

proto_file = fortune_teller_api.proto

ARTIFACT_VERSION ?= 0.0.0
PYTHON_ROOT_PACKAGE_NAME ?= spothero_services

.PHONY: all
all: codegen

.PHONY: codegen
codegen: grpc-codegen

.PHONY: grpc-codegen
grpc-codegen:
	#docker run --tty -v "${pwd}:/work" -u ${uid_gid} uber/prototool:latest prototool generate
	docker run  -v "${pwd}:/work" uber/prototool:latest prototool generate
	sudo chown -R wilsoniya:wilsoniya ${py_out_dir}

py-dist: grpc-codegen
	# recursively create __init__.py for all packages
	find \
		${py_out_dir}/${PYTHON_ROOT_PACKAGE_NAME} \
		-type d \
		-execdir touch {}/__init__.py \;

	# expand setup.py template file
	sed \
		-e 's/{{VERSION}}/${ARTIFACT_VERSION}/g' \
		-e 's/{{ROOT_PACKAGE_NAME}}/${PYTHON_ROOT_PACKAGE_NAME}/g' \
		-e '/^##/d' \
		setup.py.tpl > ${py_out_dir}/setup.py

	cd ${py_out_dir} && python setup.py sdist




.PHONY: clean
clean:
	rm -rf ${out_dirs}

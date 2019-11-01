pwd = $(shell pwd)
uid_gid = $(shell stat -c "%u:%g" ${pwd})
repo_name = $(shell git remote -v | grep origin | head -1 | awk '{print $$2}' | sed -e 's|.*/\(.*\)\.git.*$$|\1|')
repo_url = $(shell git remote -v | grep origin | head -1 | awk '{print $$2}'  | sed  -e 's|:|/|' -e 's|git@|https://|')

java_out_dir = java-out
py_out_dir = gen-py-grpc
go_out_dir = gen-go-grpc
out_dirs = ${java_out_dir} ${py_out_dir} ${go_out_dir}

ARTIFACT_VERSION ?= 0.0.0
PYTHON_ROOT_PACKAGE_NAME ?= spothero_services
python_package_name = ${repo_name}-grpc-bindings

.PHONY: all
all: codegen

.PHONY: codegen
codegen: grpc-codegen

.PHONY: grpc-codegen
grpc-codegen:
	#docker run --tty -v "${pwd}:/work" -u ${uid_gid} uber/prototool:latest prototool generate
	docker run  -v "${pwd}:/work" uber/prototool:latest prototool generate
	sudo chown -R wilsoniya:wilsoniya ${py_out_dir}

.PHONY: py-dist
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
		-e 's/{{PACKAGE_NAME}}/${python_package_name}/g' \
		-e 's|{{PACKAGE_URL}}|${repo_url}|g' \
		-e '/^##/d' \
		setup.py.tpl > ${py_out_dir}/setup.py

	# generate Python artifact
	cd ${py_out_dir} && python setup.py sdist

.PHONY: clean
clean:
	rm -rf ${out_dirs}

java_out_dir = java-out gen-java
grpc_dir = grpcv1
thrift_dir = thrift
go_out_dir = ../go/pkg
py_out_dir = gen-py
out_dirs = ${java_out_dir} ${go_out_dir} ${py_out_dir}
pwd = $(shell pwd)
uid_gid = $(shell stat -c "%u:%g" ${pwd})

.PHONY: all
all: codegen

.PHONY: codegen
codegen: grpc-codegen thrift-codegen

.PHONY: thrift-codegen
thrift-codegen:
	thrift --gen py ${thrift_dir}/*
	thrift --gen java ${thrift_dir}/*
	thrift --gen go:package_prefix=github.com/spothero/idl-test/pkg/ --out ${go_out_dir} ${thrift_dir}/*

.PHONY: grpc-codegen
grpc-codegen:
	docker run -v "${pwd}:/work" -u ${uid_gid} uber/prototool:latest prototool generate

.PHONY: clean
clean:
	rm -rf ${out_dirs}

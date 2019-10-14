java_out_dir = java-out gen-java
grpc_dir = grpc
thrift_dir = thrift
go_out_dir = go-out gen-go
py_out_dir = gen-py
out_dirs = ${java_out_dir} ${go_out_dir} ${py_out_dir}

.PHONY: all
all: codegen

.PHONY: check
check:
	@which prototool > /dev/null
	@which protoc-gen-go > /dev/null
	@echo 'All deps OK.'

.PHONY: codegen
codegen: check grpc-codegen thrift-codegen

.PHONY: thrift-codegen
thrift-codegen:
	thrift --gen py ${thrift_dir}/*
	thrift --gen java ${thrift_dir}/*
	thrift --gen go ${thrift_dir}/*

.PHONY: grpc-codegen
grpc-codegen:
	prototool generate ${grpc_dir}

.PHONY: clean
clean:
	rm -rf ${out_dirs}

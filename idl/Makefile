java_out_dir = java-out
grpc_dir = grpc
go_out_dir = go-out
out_dirs = ${java_out_dir} ${go_out_dir}

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
	@echo 'TODO: thrift-codegen'

.PHONY: grpc-codegen
grpc-codegen:
	prototool generate ${grpc_dir}

.PHONY: clean
clean:
	rm -rf ${out_dirs}

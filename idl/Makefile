grpc_dir = grpc
grpc_src = ${grpc_dir}/grpc.proto
go_out_dir = go-out
go_grpc_artifact = ${go_out_dir}/grpc.pb.go
out_dirs = ${go_out_dir}

.PHONY: all
all: ${go_grpc_artifact}

check:
	@which protoc > /dev/null
	@which protoc-gen-go > /dev/null
	@echo 'All deps OK.'

${go_grpc_artifact}: ${grpc_src}
	mkdir -p ${go_out_dir}
	protoc -I ${grpc_dir} $< --go_out=plugins=grpc:./${go_out_dir}

.PHONY: clean
clean:
	rm -rf ${out_dirs}

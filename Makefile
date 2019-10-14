.PHONY: all
all: idl-codegen go

.PHONY: idl-codegen
idl-codegen:
	$(MAKE) -C idl

.PHONY: go
go:
	go build ./...

.PHONY: clean
clean:
	$(MAKE) -C idl clean

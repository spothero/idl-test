.PHONY: all
all: idl-codegen go

.PHONY: idl-codegen
idl-codegen:
	$(MAKE) -C idl

.PHONY: go
go:
	$(MAKE) -C go

.PHONY: clean
clean:
	$(MAKE) -C idl clean

.PHONY: all
all: idl-codegen go py

.PHONY: idl-codegen
idl-codegen:
	$(MAKE) -C idl

.PHONY: go
go: idl-codegen
	$(MAKE) -C go

.PHONY: py
py: idl-codegen
	$(MAKE) -C py

.PHONY: clean
clean:
	$(MAKE) -C idl clean

.PHONY: all
all: idl-codegen go py

.PHONY: idl-codegen
idl-codegen:
	$(MAKE) -C idl

.PHONY: go
go:
	$(MAKE) -C go

.PHONY: py
py:
	$(MAKE) -C py

.PHONY: clean
clean:
	$(MAKE) -C idl clean

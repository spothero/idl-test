.PHONY: all
all: idl-codegen

.PHONY: idl-codegen
idl-codegen:
	$(MAKE) -C idl

.PHONY: clean
clean:
	$(MAKE) -C idl clean

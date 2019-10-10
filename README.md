# IDL Test

https://spothero.atlassian.net/browse/PMP-256

This repository contains the result of an experiment to evaluate several
different IDLs, their tooling, and their integration with SpotHero's core
languages, Go and Kotlin.

We're going to evaluate several IDLs across Go and Kotlin to determine their
relative merit. We will develop an interface definition for a simple service
in:

* GRPC
* Thrift
* ~Avro~
* ~Cap'n Proto (stretch goal)~

The service definition should be roughly the same in all of the targeted IDLs.
Specifically it should support:

* Optional values in the request/response
* List types in the request/response
* Mapping types in the request/response
* Union types in the request/response
* Enums
* Nested structures
* Auth information (ideally not provided in-band with request structure)
* Tracing information (ideally not provided in-band with request structure)
* Returning errors

Once the interfaces have been defined in the IDLs, the next task is to rig up
code generation for both Go and Kotlin. Let's make codegen be invokable from a
Makefile.

The service implementation should consider:

    * Middlewares
    * Schema evolution
    * Streaming request/response

Finally, we will implement both client and servers for the resulting interfaces
in both Go and Kotlin. For convenience, let's make all clients and servers
communicate on TCP:9876.

We'll compose the result of our experimentation in this repo:
https://github.com/spothero/idl-test

## Tooling setup

* `protoc` - https://github.com/protocolbuffers/protobuf
* `protoc-gen-go` - `go get github.com/golang/protobuf/protoc-gen-go` -
  https://developers.google.com/protocol-buffers/docs/reference/go-generated

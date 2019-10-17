### Thrift Kotlin Example

This project is an example implementation of `thrift` RPC tool with Kotlin.

[Here](../../idl/thrift/fortune_teller_api.thrift) is where you can find the idl file we used.

#### Getting Started

The project leverages a [Makefile](./Makefile). `make run-server` will fire up the server with gradle, and the the `make run-client` will run the client.

#### Layout

The app is composed of three subprojects:
* model
* server
* client

`model` component contains the thrift-generated Java files.
`server` implements the service interface the idl defines. The (service) logic is decoupled from thrift, the thrift server code invokes service and acts as an RPC delivery mechanism.

`client` is a single Kotlin file, it assembles a request and logs the result.

#### Implementation Challenges

* Had to fix the generated Java file - only two places in the generated `FortuneResponse` class file
* Lack of documentation of information - I've found very few examples in Kotlin

## Go IDL Tests

To build the Go IDL CLI simply invoke `make` from this directory or the parent directory. The
output will be an executable named `idl-cli`. The `idl-cli` contains both client and server for
both GRPC and Thrift.


### Running a Server

To run the either server, simply run a command as such:

`./idl-cli thrift-server`

or

`./idl-cli grpc-server`

Use `ctrl+c` to exit.

### Running a Client

To run a client, simply run a command as such:

`./idl-cli thrift-client`

or

`./idl-cli thrift-server`

The client will start, connect to the running server, and perform a request.

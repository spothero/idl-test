package main

import (
	"context"
	"fmt"

	"github.com/apache/thrift/lib/go/thrift"
	"github.com/spothero/idl-test/pkg/fortune"
	"golang.org/x/xerrors"
)

func main() {
	if err := runServer(); err != nil {
		panic(err)
	}
}

func runServer() error {
	fmt.Printf("starting thrift server at localhost:9090")
	transport, err := thrift.NewTServerSocket("localhost:9090")
	if err != nil {
		return xerrors.Errorf("failed to open server socket: %w", err)
	}

	processor := fortune.NewFortuneTellerProcessor(FortuneTellerHandler{})
	transportFactory := thrift.NewTTransportFactory()
	protocolFactory := thrift.NewTCompactProtocolFactory()
	server := thrift.NewTSimpleServer4(processor, transport, transportFactory, protocolFactory)
	if err = server.Serve(); err != nil {
		return xerrors.Errorf("failed to start server")
	}
	return nil
}

// Implementation of the FortuneTellerHandler
type FortuneTellerHandler struct{}

func (fth FortuneTellerHandler) GetFortune(
	ctx context.Context,
	fortune_request *fortune.FortuneRequest,
) (r *fortune.FortuneResponse, err error) {
	return &fortune.FortuneResponse{
		Fortune:      "ricky, julian, and bubbles will not keep their riches",
		LuckyNumbers: []int32{666},
		LuckyAnimal:  fortune.Animal_CAT,
	}, nil
}

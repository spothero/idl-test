package thrift

import (
	"context"
	"fmt"

	"github.com/apache/thrift/lib/go/thrift"
	"github.com/spf13/cobra"
	"github.com/spothero/idl-test/pkg/fortune"
	"golang.org/x/xerrors"
)

func NewCLICmd() *cobra.Command {
	cmd := &cobra.Command{
		Use:   "thrift-server",
		Short: "Starts a Thrift Server",
		Long:  "Starts a Thrift Server",
		Run: func(cmd *cobra.Command, args []string) {
			Run()
		},
	}
	// Server Config
	flags := cmd.Flags()
	serverURL := ""
	flags.StringVar(&serverURL, "thrift-server-url", "localhost:9090", "Thrift Server URL")
	return cmd
}

func Run() {
	if err := runServer(); err != nil {
		panic(err)
	}
}

func runServer() error {
	fmt.Printf("starting thrift server at localhost:9090\n")
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

package server

import (
	"context"
	"fmt"
	"net"

	"github.com/spf13/cobra"
	"github.com/spothero/idl-test/pkg/grpcv1"
	"google.golang.org/grpc"
)

func NewCLICmd() *cobra.Command {
	serverURL := ""
	cmd := &cobra.Command{
		Use:   "grpc-server",
		Short: "Starts a GRPC Server",
		Run: func(cmd *cobra.Command, args []string) {
			Run(&serverURL)
		},
	}
	flags := cmd.Flags()
	flags.StringVar(&serverURL, "grpc-server-url", "localhost:9111", "GRPC Server URL")
	return cmd
}

type fortuneTellerAPIImpl struct{}

func (f fortuneTellerAPIImpl) GetFortune(
	context context.Context,
	request *grpcv1.GetFortuneRequest,
) (*grpcv1.GetFortuneResponse, error) {

	fmt.Printf("Received request: %v\n", *request)

	response := grpcv1.GetFortuneResponse{
		Fortune:      "A flute with no holes is not a flute and a donut with no holes is a Danish",
		LuckyNumbers: []int32{420, 666},
		LuckyAnimal:  grpcv1.GetFortuneResponse_ANIMAL_LIZARD,
	}

	return &response, nil
}

func Run(listenAddress *string) {
	server := grpc.NewServer()

	listener, err := net.Listen("tcp", *listenAddress)
	if err != nil {
		panic(err)
	}

	grpcv1.RegisterFortuneTellerAPIServer(server, &fortuneTellerAPIImpl{})

	fmt.Printf("Listening on %v ...\n", *listenAddress)
	err = server.Serve(listener)
	if err != nil {
		panic(err)
	}
}

package client

import (
	"context"
	"fmt"

	"github.com/spf13/cobra"
	"google.golang.org/grpc"
	"google.golang.org/grpc/status"

	"github.com/spothero/idl-test/pkg/grpcv1"
)

func NewCLICmd() *cobra.Command {
	serverURL := ""
	cmd := &cobra.Command{
		Use:   "grpc-client",
		Short: "Starts a GRPC Client",
		Run: func(cmd *cobra.Command, args []string) {
			Run(serverURL)
		},
	}
	flags := cmd.Flags()
	flags.StringVar(&serverURL, "grpc-server-url", "localhost:9111", "GRPC Server URL")
	return cmd
}

func Run(serverURL string) {
	fmt.Printf("Sending request to %v\n", serverURL)
	conn, err := grpc.Dial(serverURL, grpc.WithInsecure())
	if err != nil {
		panic(err)
	}
	defer conn.Close()

	client := grpcv1.NewFortuneTellerAPIClient(conn)

	request := grpcv1.GetFortuneRequest{
		Name: "Leeroy Jenkins",
		OptionalCar: &grpcv1.GetFortuneRequest_Car{
			Make:  "Geo",
			Model: "Metro",
			Year:  1992,
		},
		VehicleDescription: &grpcv1.GetFortuneRequest_BikeFrameSizeCm{BikeFrameSizeCm: 55},
		FingerLengths:      []int32{32, 35, 900, 33, 29},
		SiblingAges: map[string]int32{
			"Greg":   17,
			"Peter":  15,
			"Bobby":  10,
			"Cindy":  10,
			"Marcia": 17,
		},
	}

	response, err := client.GetFortune(context.Background(), &request)
	if err != nil {
		_status, isServiceErr := status.FromError(err)
		if isServiceErr {
			fmt.Printf("Service error: code=%v details=%v\n", _status.Code(), _status.Message())
		} else {
			panic(err)
		}
	}

	fmt.Printf("Received response: %v\n", response)
}

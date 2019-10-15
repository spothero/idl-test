package client

import (
	"context"
	"fmt"

	"github.com/apache/thrift/lib/go/thrift"
	"github.com/spf13/cobra"
	"github.com/spothero/idl-test/pkg/fortune"
)

func NewCLICmd() *cobra.Command {
	serverURL := ""
	cmd := &cobra.Command{
		Use:   "thrift-client",
		Short: "Starts a Thrift Client",
		Long:  "Starts a Thrift Client",
		Run: func(cmd *cobra.Command, args []string) {
			Run(serverURL)
		},
	}
	flags := cmd.Flags()
	flags.StringVar(&serverURL, "thrift-server-url", "localhost:9090", "Thrift Server URL")
	return cmd
}

func Run(serverURL string) {
	transport, err := thrift.NewTSocket(serverURL)
	if err != nil {
		panic(err)
	}
	transportInst, err := thrift.NewTTransportFactory().GetTransport(transport)
	if err != nil {
		panic(err)
	}
	defer transportInst.Close()
	if err = transport.Open(); err != nil {
		panic(err)
	}
	protocolFactory := thrift.NewTCompactProtocolFactory()
	inProtocol := protocolFactory.GetProtocol(transportInst)
	outProtocol := protocolFactory.GetProtocol(transportInst)
	client := fortune.NewFortuneTellerClient(thrift.NewTStandardClient(inProtocol, outProtocol))

	// Make request
	nickname := "trailer park supervisor car"
	resp, err := client.GetFortune(
		context.Background(),
		&fortune.FortuneRequest{
			Name: "lahey",
			OptionalCar: &fortune.Car{
				Make:  "Chrysler",
				Model: "New Yorker",
				Year:  1976,
			},
			VehicleDescription: &fortune.VehicleDescription{
				CarNickname: &nickname,
			},
			FingerLengths: []int32{10, 20, 30},
			SiblingAges: map[string]int32{
				"barb":  63,
				"randy": 37,
			},
		})
	if err != nil {
		panic(err)
	}
	fmt.Println("successfully queried server")
	fmt.Println("---------------------------")
	fmt.Printf("Fortune      : %+v\n", resp.GetFortune())
	fmt.Printf("Lucky Numbers: %+v\n", resp.GetLuckyNumbers())
	fmt.Printf("Lucky Animal : %+v\n", resp.GetLuckyAnimal())
}

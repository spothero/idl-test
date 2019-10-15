package client

import (
	"fmt"

	"github.com/spf13/cobra"
	"github.com/spothero/idl-test/pkg/grpcv1"
)

func NewCLICmd() *cobra.Command {
	cmd := &cobra.Command{
		Use:   "grpc-client",
		Short: "Starts a GRPC Client",
		Long:  "Starts a GRPC Client",
		Run: func(cmd *cobra.Command, args []string) {
			Run()
		},
	}
	// Server Config
	flags := cmd.Flags()
	serverURL := ""
	flags.StringVar(&serverURL, "grpc-server-url", "localhost:9111", "GRPC Server URL")
	return cmd
}

func Run() {
	var test grpcv1.GetFortuneResponse_Animal
	test = 1
	fmt.Printf("The GRPC Client is not yet implemented, but here's an %v to tide you over\n", test)
}

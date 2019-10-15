package server

import (
	"fmt"

	"github.com/spf13/cobra"
	"github.com/spothero/idl-test/pkg/grpcv1"
)

func NewCLICmd() *cobra.Command {
	cmd := &cobra.Command{
		Use:   "grpc-server",
		Short: "Starts a GRPC Server",
		Long:  "Starts a GRPC Server",
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
	fmt.Println("hello, grpc")
	var test grpcv1.GetFortuneResponse_Animal
	test = 1
	fmt.Printf("%v\n", test)
}

package main

import (
	"os"

	"github.com/spf13/cobra"
	grpcClient "github.com/spothero/idl-test/cmd/grpc/client"
	grpcServer "github.com/spothero/idl-test/cmd/grpc/server"
	thriftClient "github.com/spothero/idl-test/cmd/thrift/client"
	thriftServer "github.com/spothero/idl-test/cmd/thrift/server"
	"github.com/spothero/tools/cli"
)

func newRootCmd(args []string) *cobra.Command {
	cmd := &cobra.Command{
		Use:   "idl",
		Short: "SpotHero IDL Test",
		Long:  "Provides CLI for IDL Test",
		PersistentPreRun: func(cmd *cobra.Command, args []string) {
			cli.CobraBindEnvironmentVariables("idl")(cmd, args)
		},
	}
	cmd.AddCommand(grpcServer.NewCLICmd())
	cmd.AddCommand(grpcClient.NewCLICmd())
	cmd.AddCommand(thriftServer.NewCLICmd())
	cmd.AddCommand(thriftClient.NewCLICmd())
	return cmd
}

func main() {
	cmd := newRootCmd(os.Args[1:])
	if err := cmd.Execute(); err != nil {
		os.Exit(1)
	}
}

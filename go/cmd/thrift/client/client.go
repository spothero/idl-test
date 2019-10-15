package client

import (
	"fmt"

	"github.com/spf13/cobra"
)

func NewCLICmd() *cobra.Command {
	cmd := &cobra.Command{
		Use:   "thrift-client",
		Short: "Starts a Thrift Client",
		Long:  "Starts a Thrift Client",
		Run: func(cmd *cobra.Command, args []string) {
			Run()
		},
	}
	flags := cmd.Flags()
	serverURL := ""
	flags.StringVar(&serverURL, "thrift-server-url", "localhost:9090", "Thrift Server URL")
	return cmd
}

func Run() {
	fmt.Println("thrift client is unimplemented")
}

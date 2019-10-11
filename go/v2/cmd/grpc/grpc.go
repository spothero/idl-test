package main

import (
	"fmt"
	"github.com/spothero/idl-test/go/v2/pkg/grpcv1"
)

func main() {
	fmt.Println("hello, grpc")
	var test grpcv1.GetFortuneResponse_Animal
	test = 1
	fmt.Printf("%v\n", test)
}

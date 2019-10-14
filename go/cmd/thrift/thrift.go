package main

import (
	"fmt"

	"github.com/spothero/idl-test/pkg/fortune"
)

func main() {
	fmt.Println("hello, thrift")
	fmt.Println(fortune.Animal_MONKEY)
}

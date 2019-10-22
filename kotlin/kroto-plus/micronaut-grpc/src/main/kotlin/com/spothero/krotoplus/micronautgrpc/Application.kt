package com.spothero.krotoplus.micronautgrpc

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.spothero.krotoplus.micronautgrpc")
                .mainClass(Application.javaClass)
                .start()
    }
}
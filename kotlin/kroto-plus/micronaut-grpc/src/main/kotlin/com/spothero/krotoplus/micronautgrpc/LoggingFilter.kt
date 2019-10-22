package com.spothero.krotoplus.micronautgrpc

import io.grpc.*
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.Filter
import io.micronaut.http.filter.FilterChain
import io.micronaut.http.filter.HttpFilter
import io.micronaut.http.filter.HttpServerFilter
import io.micronaut.http.filter.ServerFilterChain
import org.reactivestreams.Publisher
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Filter("/**")
class LoggingFilter : HttpServerFilter {

  private val logger = LoggerFactory.getLogger(javaClass)

  override fun doFilter(
    request: HttpRequest<*>?,
    chain: ServerFilterChain
  ): Publisher<MutableHttpResponse<*>> {
    logger.info("Starting request ${request?.path}")
    return chain.proceed(request).also {
      logger.info("Ending request ${request?.path}")
    }
  }
}

@Singleton
class GrpcLoggingFilter : ServerInterceptor {

  private val logger = LoggerFactory.getLogger(javaClass)

  override fun <ReqT : Any?, RespT : Any?> interceptCall(
    call: ServerCall<ReqT, RespT>?,
    headers: Metadata?,
    next: ServerCallHandler<ReqT, RespT>
  ): ServerCall.Listener<ReqT> {
    logger.info("Starting GRPC request ${call?.methodDescriptor}")
    return next.startCall(call, headers).also {
      logger.info("Ending GRPC request ${call?.methodDescriptor}")
    }
  }
}
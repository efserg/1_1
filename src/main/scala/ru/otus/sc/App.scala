package ru.otus.sc

import ru.otus.sc.counter.CounterAspect
import ru.otus.sc.counter.service.CounterService
import ru.otus.sc.counter.service.impl.CounterServiceImpl
import ru.otus.sc.echo.service.{EchoService, EchoServiceImpl}
import ru.otus.sc.greet.dao.impl._
import ru.otus.sc.greet.service._
import ru.otus.sc.greet.service.impl._
import ru.otus.sc.keyvalue.dao.EmployeeDaoStubImpl
import ru.otus.sc.keyvalue.service.{KeyValueService, EmployeeServiceImpl}
import ru.otus.sc.laziest.service.{LazyValService, LazyValServiceImpl}
import ru.otus.sc.model._

/**
  * The main application routers
  */
trait App {

  /**
    * Greeting person
    *
    * @param request greeting request
    * @return greeting
    */
  def greet(request: GreetRequest): GreetResponse

  /**
    * Find person in local store by unique person's key
    *
    * @param request request for search person
    * @return response with person's data
    */
  def getPerson(request: KeyRequest): EmployeeResponse

  /**
    * Return requests counter
    *
    * @param request empty request
    * @return response with counter
    */
  def getRequestCount(request: CounterRequest): CounterResponse

  /**
  * Echo server - return the same message as the request
  */
  def echo(request: EchoRequest): EchoResponse

  def lazyVal(request: LazyRequest): LazyResponse
}

object App {
  private class AppImpl(greeting: GreetingService,
                        store: KeyValueService,
                        counter: CounterService,
                        echo: EchoService,
                        lazyVal: LazyValService)
      extends App {
    def greet(request: GreetRequest): GreetResponse = greeting.handleRequest(request)
    def getPerson(request: KeyRequest): EmployeeResponse = store.handleRequest(request)
    def getRequestCount(request: CounterRequest): CounterResponse = counter.handleRequest(request)
    def echo(request: EchoRequest): EchoResponse = echo.handleRequest(request)
    def lazyVal(request: LazyRequest): LazyResponse = lazyVal.handleRequest(request)
  }

  def apply(): App = {
    val greetingService = new GreetingServiceImpl(new GreetingDaoImpl) with CounterAspect[GreetRequest, GreetResponse]
    val store = new EmployeeServiceImpl(new EmployeeDaoStubImpl) with CounterAspect[KeyRequest, EmployeeResponse]
    val counter = new CounterServiceImpl with CounterAspect[CounterRequest, CounterResponse]
    val echo = new EchoServiceImpl with CounterAspect[EchoRequest, EchoResponse]
    val lazyService = new LazyValServiceImpl("LAZY VALUE") with CounterAspect[LazyRequest, LazyResponse]

    new AppImpl(greetingService, store, counter, echo, lazyService)
  }
}

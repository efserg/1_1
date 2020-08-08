package ru.otus.sc

import ru.otus.sc.greet.dao.impl._
import ru.otus.sc.greet.model._
import ru.otus.sc.greet.service._
import ru.otus.sc.greet.service.impl._

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
  def getPerson(request: KeyRequest): PersonResponse

  /**
    * Return requests counter
    *
    * @param request empty request
    * @return response with counter
    */
  def getRequestCount(request: CounterRequest): CounterResponse
}

object App {
  private class AppImpl(greeting: GreetingService,
                        store: KeyValueService,
                        counter: CounterService)
      extends App {
    def greet(request: GreetRequest): GreetResponse = greeting.handleRequest(request)
    def getPerson(request: KeyRequest): PersonResponse = store.handleRequest(request)
    def getRequestCount(request: CounterRequest): CounterResponse = counter.handleRequest(request)
  }

  def apply(): App = {
    val greetingDao = new GreetingDaoImpl
    val greetingService = new GreetingServiceImpl(greetingDao) with CounterAspect[GreetRequest, GreetResponse]
    val store = new KeyValueServiceImpl(new PersonDaoStubImpl()) with CounterAspect[KeyRequest, PersonResponse]
    val counter = new CounterServiceImpl with CounterAspect[CounterRequest, CounterResponse]
    new AppImpl(greetingService, store, counter)
  }
}

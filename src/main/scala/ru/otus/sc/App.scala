package ru.otus.sc

import ru.otus.sc.greet.dao.impl.{GreetingDaoImpl, PersonDaoStubImpl}
import ru.otus.sc.greet.model.{
  GreetRequest,
  GreetResponse,
  KeyRequest,
  PersonResponse
}
import ru.otus.sc.greet.service.{GreetingService, KeyValueService}
import ru.otus.sc.greet.service.impl.{GreetingServiceImpl, KeyValueServiceImpl}

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
}

object App {
  private class AppImpl(greeting: GreetingService, store: KeyValueService)
      extends App {
    def greet(request: GreetRequest): GreetResponse = greeting.greet(request)
    def getPerson(request: KeyRequest): PersonResponse = store.get(request)
  }

  def apply(): App = {
    val greetingDao = new GreetingDaoImpl
    val greetingService = new GreetingServiceImpl(greetingDao)
    val store = new KeyValueServiceImpl(new PersonDaoStubImpl())
    new AppImpl(greetingService, store)
  }
}

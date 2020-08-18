package ru.otus.sc.counter

import ru.otus.sc.RequestHandler
import ru.otus.sc.counter.dao.CounterDao


/**
  * Requests counter aspect
  *
  * @tparam REQUEST: request type
  * @tparam RESPONSE: response type
  */
trait CounterAspect[REQUEST, RESPONSE] extends RequestHandler[REQUEST, RESPONSE] {
  private val dao = CounterDao
  abstract override def handleRequest(request: REQUEST): RESPONSE = {
    dao.increase()
    super.handleRequest(request)
  }
}

package ru.otus.sc.greet.service
import ru.otus.sc.greet.dao.CounterDao

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

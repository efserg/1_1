package ru.otus.sc.greet.service
import ru.otus.sc.greet.model.{CounterRequest, CounterResponse}

trait CounterService extends RequestHandler[CounterRequest, CounterResponse] {
  def handleRequest(request: CounterRequest): CounterResponse
}

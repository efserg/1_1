package ru.otus.sc.counter.service

import ru.otus.sc.RequestHandler
import ru.otus.sc.model.{CounterRequest, CounterResponse}

trait CounterService extends RequestHandler[CounterRequest, CounterResponse] {
  def handleRequest(request: CounterRequest): CounterResponse
}

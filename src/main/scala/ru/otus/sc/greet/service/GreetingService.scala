package ru.otus.sc.greet.service

import ru.otus.sc.greet.model.{GreetRequest, GreetResponse}

trait GreetingService extends RequestHandler[GreetRequest, GreetResponse] {
  def handleRequest(request: GreetRequest): GreetResponse
}

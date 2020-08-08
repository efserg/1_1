package ru.otus.sc.greet.service
import ru.otus.sc.greet.model.{EchoRequest, EchoResponse}

trait EchoService extends RequestHandler[EchoRequest, EchoResponse]{
  def handleRequest(request: EchoRequest): EchoResponse
}

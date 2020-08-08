package ru.otus.sc.greet.service.impl
import ru.otus.sc.greet.model.{EchoRequest, EchoResponse}
import ru.otus.sc.greet.service.EchoService

class EchoServiceImpl extends EchoService {
  override def handleRequest(request: EchoRequest): EchoResponse = EchoResponse(request)
}

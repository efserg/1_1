package ru.otus.sc.echo.service

import ru.otus.sc.model.{EchoRequest, EchoResponse}

class EchoServiceImpl extends EchoService {
  override def handleRequest(request: EchoRequest): EchoResponse = EchoResponse(request)
}

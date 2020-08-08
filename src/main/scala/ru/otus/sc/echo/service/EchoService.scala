package ru.otus.sc.echo.service

import ru.otus.sc.RequestHandler
import ru.otus.sc.model.{EchoRequest, EchoResponse}

trait EchoService extends RequestHandler[EchoRequest, EchoResponse]{
  def handleRequest(request: EchoRequest): EchoResponse
}

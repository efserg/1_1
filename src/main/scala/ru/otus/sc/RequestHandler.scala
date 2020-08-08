package ru.otus.sc

trait RequestHandler[REQUEST, RESPONSE] {
  def handleRequest(request: REQUEST): RESPONSE
}

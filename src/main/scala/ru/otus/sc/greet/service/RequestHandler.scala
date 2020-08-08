package ru.otus.sc.greet.service

trait RequestHandler[REQUEST, RESPONSE] {
  def handleRequest(request: REQUEST): RESPONSE
}

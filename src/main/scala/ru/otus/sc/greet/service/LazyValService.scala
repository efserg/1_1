package ru.otus.sc.greet.service
import ru.otus.sc.greet.model.{LazyRequest, LazyResponse}

trait LazyValService extends RequestHandler[LazyRequest, LazyResponse] {
  def handleRequest(request: LazyRequest): LazyResponse
}

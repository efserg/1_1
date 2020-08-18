package ru.otus.sc.laziest.service

import ru.otus.sc.RequestHandler
import ru.otus.sc.model.{LazyRequest, LazyResponse}

trait LazyValService extends RequestHandler[LazyRequest, LazyResponse] {
  def handleRequest(request: LazyRequest): LazyResponse
}

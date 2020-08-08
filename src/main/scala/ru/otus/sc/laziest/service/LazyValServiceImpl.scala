package ru.otus.sc.laziest.service

import ru.otus.sc.model.{LazyRequest, LazyResponse}

class LazyValServiceImpl(value: String) extends LazyValService {
  lazy val lazyValue: String = {
    println(s"Initialize lazy value $value")
    value
  }

  override def handleRequest(request: LazyRequest): LazyResponse = LazyResponse(lazyValue)
}

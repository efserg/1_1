package ru.otus.sc.greet.service.impl
import ru.otus.sc.greet.model.{LazyRequest, LazyResponse}
import ru.otus.sc.greet.service.LazyValService

class LazyValServiceImpl(value: String) extends LazyValService {
  lazy val lazyValue: String = {
    println(s"Initialize lazy value $value")
    value
  }

  override def handleRequest(request: LazyRequest): LazyResponse = LazyResponse(lazyValue)
}

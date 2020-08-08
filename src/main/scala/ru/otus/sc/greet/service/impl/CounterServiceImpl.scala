package ru.otus.sc.greet.service.impl
import ru.otus.sc.greet.dao.CounterDao
import ru.otus.sc.greet.model.{CounterRequest, CounterResponse}
import ru.otus.sc.greet.service.CounterService

class CounterServiceImpl extends CounterService {
  override def handleRequest(request: CounterRequest): CounterResponse = CounterResponse(CounterDao.get())
}

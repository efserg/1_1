package ru.otus.sc.counter.service.impl

import ru.otus.sc.counter.dao.CounterDao
import ru.otus.sc.counter.service.CounterService
import ru.otus.sc.model.{CounterRequest, CounterResponse}

class CounterServiceImpl extends CounterService {
  override def handleRequest(request: CounterRequest): CounterResponse = CounterResponse(CounterDao.get())
}

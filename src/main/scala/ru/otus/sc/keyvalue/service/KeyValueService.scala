package ru.otus.sc.keyvalue.service

import ru.otus.sc.RequestHandler
import ru.otus.sc.model.{KeyRequest, EmployeeResponse}

/**
  * Service for search the person in the key-value store
  */
trait KeyValueService extends RequestHandler[KeyRequest, EmployeeResponse] {
  def handleRequest(request: KeyRequest): EmployeeResponse
}

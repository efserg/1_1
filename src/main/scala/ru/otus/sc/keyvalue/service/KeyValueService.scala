package ru.otus.sc.keyvalue.service

import ru.otus.sc.RequestHandler
import ru.otus.sc.model.{KeyRequest, PersonResponse}

/**
  * Service for search the person in the key-value store
  */
trait KeyValueService extends RequestHandler[KeyRequest, PersonResponse] {
  def handleRequest(request: KeyRequest): PersonResponse
}

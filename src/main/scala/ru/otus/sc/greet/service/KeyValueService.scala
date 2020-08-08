package ru.otus.sc.greet.service
import ru.otus.sc.greet.model.{KeyRequest, PersonResponse}

/**
  * Service for search the person in the key-value store
  */
trait KeyValueService extends RequestHandler[KeyRequest, PersonResponse] {
  def handleRequest(request: KeyRequest): PersonResponse
}

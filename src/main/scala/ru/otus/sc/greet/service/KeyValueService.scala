package ru.otus.sc.greet.service

import ru.otus.sc.greet.model.{KeyRequest, PersonResponse}

/**
  * Service for search in the key-value store
  */
trait KeyValueService {

  /**
    * Return person by key
    *
    * @param key
    * @return
    */
  def get(key: KeyRequest): PersonResponse
}

package ru.otus.sc.model

/**
  * Request for search person in local key-value store
  *
  * @param key key for person
  */
case class KeyRequest(key: String)

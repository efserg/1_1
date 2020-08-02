package ru.otus.sc.greet.dao.model

/**
  * Represent sex
  */
object Sex extends Enumeration {
  type Sex = Value
  val MAN, WOMAN, UNKNOWN = Value
}

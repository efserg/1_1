package ru.otus.sc.keyvalue.domain

/**
  * Represent sex
  */
object Sex extends Enumeration {
  type Sex = Value
  val MAN, WOMAN, UNKNOWN = Value
}

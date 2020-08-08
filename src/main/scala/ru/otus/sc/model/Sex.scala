package ru.otus.sc.model

/**
  * Represent sex
  */
object Sex extends Enumeration {
  type Sex = Value
  val MAN, WOMAN, UNKNOWN = Value
}

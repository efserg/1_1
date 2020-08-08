package ru.otus.sc.model

import ru.otus.sc.model.Sex.Sex

/**
  * Person representation
  *
  * @param name Person's name
  * @param age Person's age
  * @param sex Person's sex
  */
case class Person(name: String, age: Int, sex: Sex)

object Person {
  def apply(): Person = Person("", 0, Sex.UNKNOWN)
}

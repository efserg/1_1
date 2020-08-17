package ru.otus.sc.keyvalue.domain

object Position extends Enumeration {
  type Position = Value
  val LEAD, SENIOR, MIDDLE, JUNIOR = Value

  private val salary =
    Map(LEAD -> 1000, SENIOR -> 900, MIDDLE -> 600, JUNIOR -> 200)

  def salaryByPosition(position: Position) = salary(position)
}

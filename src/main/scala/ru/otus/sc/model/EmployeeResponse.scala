package ru.otus.sc.model
import ru.otus.sc.keyvalue.domain.Employee

/**
  * Response for employee in local store
  */
sealed trait EmployeeResponse

object EmployeeResponse {
  case class Found(person: Employee) extends EmployeeResponse
  case class NotFound(message: String) extends EmployeeResponse
}

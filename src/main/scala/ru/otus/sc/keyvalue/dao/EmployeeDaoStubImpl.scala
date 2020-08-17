package ru.otus.sc.keyvalue.dao

import ru.otus.sc.keyvalue.domain.{Employee, Position, Sex}

class EmployeeDaoStubImpl extends EmployeeDao {

  val store = Map(
    "1.1" -> Employee("John", 17, Sex.MAN, DepartmentStubs.deps("IT"), Position.JUNIOR),
    "1.2" -> Employee("John Doe", 56, Sex.MAN, DepartmentStubs.deps("ACC"), Position.MIDDLE),
    "1" -> Employee("Smith", 88, Sex.MAN, DepartmentStubs.deps("ACC"), Position.SENIOR),
    "2" -> Employee("Silvia", 67, Sex.WOMAN, DepartmentStubs.deps("HR"), Position.LEAD),
    "3" -> Employee("Ivan", 50, Sex.WOMAN, DepartmentStubs.deps("DEV"), Position.SENIOR)
  )

  override def get(key: String): Option[Employee] = store.get(key)

  override def all: Seq[Employee] = store.values.toVector
}

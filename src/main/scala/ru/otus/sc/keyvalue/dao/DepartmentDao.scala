package ru.otus.sc.keyvalue.dao
import ru.otus.sc.keyvalue.domain.Department

trait DepartmentDao {
  def get(key: String): Option[Department]
}

package ru.otus.sc.keyvalue.dao
import ru.otus.sc.keyvalue.domain.Employee

/**
  * Trait for Employee DAO
  */
trait EmployeeDao {

  /**
    * Search person in the local store
    *
    * @param key Unique key
    * @return Some[Employee] if person was found, None if wasn't
    */
  def get(key: String): Option[Employee]

  /**
    * Method return all person from store
    * @return Employee's sequence
    */
  def all: Seq[Employee]

}

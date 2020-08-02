package ru.otus.sc.greet.dao
import ru.otus.sc.greet.dao.model.Person

/**
  * Trait for Person DAO
  */
trait PersonDao {

  /**
    * Search person in the local store
    *
    * @param key Unique key
    * @return Some[Person] if person was found, None if wasn't
    */
  def get(key: String): Option[Person]
}

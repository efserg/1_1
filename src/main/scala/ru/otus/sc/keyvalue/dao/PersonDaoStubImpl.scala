package ru.otus.sc.keyvalue.dao

import ru.otus.sc.model.{Person, Sex}

class PersonDaoStubImpl extends PersonDao {

  val store = Map(
    "1.1" -> Person("John", 7, Sex.MAN),
    "1" -> Person("Smith", 88, Sex.MAN),
    "2" -> Person("Silvia", 76, Sex.WOMAN)
  )

  override def get(key: String): Option[Person] = store.get(key)

}

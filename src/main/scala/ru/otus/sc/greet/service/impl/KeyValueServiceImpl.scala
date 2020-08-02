package ru.otus.sc.greet.service.impl
import ru.otus.sc.greet.dao.PersonDao
import ru.otus.sc.greet.model.{KeyRequest, PersonResponse}
import ru.otus.sc.greet.service.KeyValueService

class KeyValueServiceImpl(dao: PersonDao) extends KeyValueService {
  override def get(request: KeyRequest): PersonResponse =
    dao
      .get(request.key)
      .map(db => PersonResponse(db))
      .getOrElse(PersonResponse(request.key))
}

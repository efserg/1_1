package ru.otus.sc.keyvalue.service

import ru.otus.sc.keyvalue.dao.PersonDao
import ru.otus.sc.model.{KeyRequest, PersonResponse}

class KeyValueServiceImpl(dao: PersonDao) extends KeyValueService {
  override def handleRequest(request: KeyRequest): PersonResponse =
    dao
      .get(request.key)
      .map(db => PersonResponse(db))
      .getOrElse(PersonResponse(request.key))
}

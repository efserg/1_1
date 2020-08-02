package ru.otus.sc.greet.model
import ru.otus.sc.greet.dao.model.{Person, Sex}

/**
  * Response for person in local store
  *
  * @param person [[ru.otus.sc.greet.dao.model.Person Person]]'s representation
  * @param message [[ru.otus.sc.greet.model.Message Message]] with response details
  */
case class PersonResponse(person: Person, message: Message)

object PersonResponse {
  def apply(db: Person): PersonResponse = PersonResponse(db, Message())
  def apply(key: String): PersonResponse =
    PersonResponse(Person(), Message(key))
}

/**
  * Response details
  * @param error `true` if response was finished with error
  * @param message additional info
  * @param errorCode return code
  */
case class Message(error: Boolean, message: String, errorCode: Int)

object Message {
  def apply(): Message = Message(error = false, "Success", 200)
  def apply(key: String): Message =
    Message(error = true, s"Person with key $key not found", 404)
}

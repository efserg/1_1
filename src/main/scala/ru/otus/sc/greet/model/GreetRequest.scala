package ru.otus.sc.greet.model

/**
  * Greeting request
  * @param name Greeting person name
  * @param isHuman `true` if the greeting person is a homo sapience
  */
case class GreetRequest(name: String, isHuman: Boolean = true)

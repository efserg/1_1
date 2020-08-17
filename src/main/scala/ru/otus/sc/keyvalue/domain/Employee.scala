package ru.otus.sc.keyvalue.domain
import ru.otus.sc.keyvalue.domain.Position.Position
import ru.otus.sc.keyvalue.domain.Sex.Sex

case class Employee(name: String,
                    age: Int,
                    sex: Sex,
                    department: Department,
                    position: Position)

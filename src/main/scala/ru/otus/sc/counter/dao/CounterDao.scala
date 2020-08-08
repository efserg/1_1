package ru.otus.sc.counter.dao

object CounterDao {
  var counter = 0L
  def increase(): Unit = counter += 1
  def get(): Long = counter
}

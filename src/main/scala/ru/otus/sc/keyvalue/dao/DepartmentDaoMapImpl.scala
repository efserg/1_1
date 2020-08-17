package ru.otus.sc.keyvalue.dao
import ru.otus.sc.keyvalue.domain.Department

class DepartmentDaoMapImpl extends DepartmentDao {
  override def get(key: String): Option[Department] = DepartmentStubs.deps.get(key)
}

object DepartmentStubs {
  val deps = List(
    Department("ACC", "Accounting", 0.89d),
    Department("HR", "Human resources", 1.1d),
    Department("IT", "IT", 1.3d),
    Department("DEV", "Development", 1.3d)
  ).map(d => d.key -> d).toMap

}

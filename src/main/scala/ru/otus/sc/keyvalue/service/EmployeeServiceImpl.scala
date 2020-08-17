package ru.otus.sc.keyvalue.service

import ru.otus.sc.keyvalue.dao.{DepartmentStubs, EmployeeDao}
import ru.otus.sc.keyvalue.domain.{Department, Employee, Position}
import ru.otus.sc.model.{KeyRequest, EmployeeResponse}

class EmployeeServiceImpl(dao: EmployeeDao) extends KeyValueService {

  override def handleRequest(request: KeyRequest): EmployeeResponse =
    dao
      .get(request.key)
      .map(db => EmployeeResponse.Found(db))
      .getOrElse(EmployeeResponse.NotFound(request.key))

  def calculateSalarySum(cond: Employee => Boolean): Double =
    dao.all
      .filter(cond)
      .map(e => Position.salaryByPosition(e.position) * e.department.salaryRatio)
      .sum

  def calculateAvgSalaryByDepartment: Map[Department, Double] =
    DepartmentStubs.deps.values.map(d => d -> (calculateSalarySum(emp => emp.department == d) /
      calculateEmployeeCount(emp => emp.department == d))).toMap

  def calculateAvgSalaryByPosition: Map[Position.Value, Double] =
    Position.values.toSeq
      .map(p => p -> (calculateSalarySum(emp => emp.position == p) /
        calculateEmployeeCount(emp => emp.position == p))).toMap

  def calculateEmployeeCount(cond: Employee => Boolean): Int = dao.all.count(cond)

}

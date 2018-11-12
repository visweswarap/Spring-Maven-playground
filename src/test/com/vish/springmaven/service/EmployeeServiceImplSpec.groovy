package com.vish.springmaven.service

import com.vish.springmaven.modal.Address
import com.vish.springmaven.modal.Department
import com.vish.springmaven.modal.Employee
import com.vish.springmaven.repository.DataRepository
import com.vish.springmaven.repository.EmployeeRepository
import spock.lang.Specification
import spock.lang.Unroll

class EmployeeServiceImplSpec extends Specification {

    def repository = new EmployeeRepository()

    void setup(){

    }

    def "GetById"() {
        given:
        int id = 1
        repository.init()
        def service = new EmployeeServiceImpl(repository: repository)

        when:
        def result = service.getById(id)

        then:
        println result.name
    }

    def "GetById_mock"() {
        given:
        int id = 1
        repository = Mock(DataRepository)
        def service = new EmployeeServiceImpl(repository: repository)

        when:
        repository.retrieve(_) >> new Employee(id: 1, name:"test name")
        def result = service.getById(id)

        then:
        assert result.name == "test name"
    }

    @Unroll
    def "getAll_By_Dep #scenario"(){
        given:
        repository = Mock(DataRepository)
        def service = new EmployeeServiceImpl(repository: repository)
        def employeeList = []

        and:
        def emp1 = new Employee(1, "Vish", Department.DEVELOPMENT, new Address())
        def emp2 = new Employee(2, "Pepala", Department.DEVELOPMENT, new Address())
        def emp3 = new Employee(3, "Naidu", Department.TESTING, new Address())

        def emp4 = new Employee(id: 4, name:"test name dev", department: Department.DEVELOPMENT)
        def emp5 = new Employee(id: 5, name:"test name qa", department: Department.TESTING)
        employeeList.addAll([emp1,emp2, emp3, emp4, emp5])

        when:
        1 * repository.getAll() >> employeeList
        def result = service.getByDepartment(departmentInput)

        then:
        result.size() == resultSize

        where:
        departmentInput         | resultSize | scenario
        Department.DEVELOPMENT  | 3          | "Developers"
        Department.TESTING      | 2          | "Testers"
    }
}

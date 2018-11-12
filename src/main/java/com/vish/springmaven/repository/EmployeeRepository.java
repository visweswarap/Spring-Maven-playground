package com.vish.springmaven.repository;

import com.vish.springmaven.modal.Address;
import com.vish.springmaven.modal.Department;
import com.vish.springmaven.modal.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class EmployeeRepository implements DataRepository<Employee> {

    private static Map<Integer, Employee> repository = new HashMap<>();

    public EmployeeRepository() {

    }

    @PostConstruct
    public void init(){
        if(repository.isEmpty()){
            repository.put(1, new Employee(1, "Vish", Department.DEVELOPMENT, new Address()));
            repository.put(2, new Employee(2, "Pepala", Department.DEVELOPMENT, new Address()));
            repository.put(3, new Employee(3, "Naidu", Department.TESTING, new Address()));
        }
    }

    @Override
    public void store(Employee emp) {
        repository.put(emp.getId(), emp);
    }

    @Override
    public Employee retrieve(int id) {
        return repository.get(id);
    }

    @Override
    public Employee search(String name) {
        Collection<Employee> emps = repository.values();

        emps.stream()
                .filter(emp -> emp.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);

        /*for (Employee emp : emps) {
            if (emp.getName().equalsIgnoreCase(name))
                return emp;
        }*/
        return null;
    }

    @Override
    public Employee delete(int id) {
        Employee e = repository.get(id);
        repository.remove(id);
        return e;
    }

    @Override
    public List<Employee> getAll(){
        return new ArrayList<>(repository.values());
    }

    @Override
    public void update(Employee employee) {
        Employee persistedEmployee = repository.get(employee.getId());
        persistedEmployee.setName(employee.getName());
        persistedEmployee.setDepartment(employee.getDepartment());
        persistedEmployee.setAddress(employee.getAddress());
        repository.put(employee.getId(), employee);
    }
}

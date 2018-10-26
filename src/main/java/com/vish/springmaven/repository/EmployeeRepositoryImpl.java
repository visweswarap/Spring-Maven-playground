package com.vish.springmaven.repository;

import com.vish.springmaven.modal.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepositoryImpl implements Repository<Employee> {

    private Map<Integer, Employee> repository;

    public EmployeeRepositoryImpl() {
        this.repository = new HashMap<>();
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

        emps.stream().filter(emp -> emp.getName().equalsIgnoreCase(name)).findAny().orElse(null);

        /*for (Employee emp : emps) {
            if (emp.getName().equalsIgnoreCase(name))
                return emp;
        }*/
        return null;
    }

    @Override
    public Employee delete(int id) {
        Employee e = repository.get(id);
        this.repository.remove(id);
        return e;
    }

}

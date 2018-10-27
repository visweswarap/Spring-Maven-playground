package com.vish.springmaven.repository;

import com.vish.springmaven.modal.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepositoryImpl implements DataRepository<Employee> {

    private static Map<Integer, Employee> repository = new HashMap();

    public EmployeeRepositoryImpl() {

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

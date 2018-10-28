package com.vish.springmaven.repository;

import com.vish.springmaven.modal.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class EmployeeRepositoryImpl implements DataRepository<Employee> {

    private static Map<Integer, Employee> repository = new HashMap<>();

    public EmployeeRepositoryImpl() {

    }

    @PostConstruct
    public void init(){
        if(repository.isEmpty()){
            repository.put(1, new Employee(1, "Vish", "developer"));
            repository.put(2, new Employee(2, "Pepala", "developer"));
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
        repository.remove(id);
        return e;
    }

    @Override
    public List<Employee> getAll(){
        return new ArrayList<>(repository.values());
    }

}

package com.vish.springmaven.service;

import com.vish.springmaven.modal.Department;
import com.vish.springmaven.modal.Employee;
import com.vish.springmaven.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DataRepository<Employee> repository;

    @Override
    public List<Employee> getAll() {
        return repository.getAll();
    }

    @Override
    public Employee getById(int id) {
        return repository.retrieve(id);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return null;
    }

    @Override
    public void add(Employee employee) {
        repository.store(employee);
    }

    @Override
    public void update(Employee employee) {
        repository.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public List<Employee> getByDepartment(Department department) {
        return repository.getAll()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getByCity(final String city) {
        return repository.getAll()
                .stream()
                .filter(emp -> emp.getAddress().getCity().equals(city))
                .collect(Collectors.toList());
    }
}

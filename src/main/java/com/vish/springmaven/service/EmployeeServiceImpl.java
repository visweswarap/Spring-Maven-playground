package com.vish.springmaven.service;

import com.vish.springmaven.modal.Department;
import com.vish.springmaven.modal.Employee;
import com.vish.springmaven.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DataRepository<Employee> repository;

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee getById(int id) {
        return null;
    }

    @Override
    public List<Employee> searchByName(String name) {
        return null;
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public boolean delete(Employee employee) {
        return false;
    }

    @Override
    public List<Employee> getByDepartment(Department department) {
        return null;
    }
}

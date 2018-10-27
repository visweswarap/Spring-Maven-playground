package com.vish.springmaven.service;

import com.vish.springmaven.modal.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    List<Employee> searchByName(String name);

    void add(Employee employee);

    void update(Employee employee);

    boolean delete(Employee employee);
}

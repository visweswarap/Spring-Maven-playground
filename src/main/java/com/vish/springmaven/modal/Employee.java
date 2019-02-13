package com.vish.springmaven.modal;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Employee {

    private int id;

    private String name;

    private Department department;

    private Address address;

    public Employee(int id, String name, Department department, Address address) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public Employee(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public List<Address> addresess(){
        return Arrays.asList(address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

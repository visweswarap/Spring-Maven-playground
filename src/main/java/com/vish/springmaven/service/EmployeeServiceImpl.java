package com.vish.springmaven.service;

import com.vish.springmaven.modal.Address;
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

        List<Employee> employees = repository.getAll();
        List<Employee> employees1 = repository.getAll();

        employees = repository.getAll().stream().collect(Collectors.toList());

        //employees.stream().filter(e -> employees1.stream().filter(e2 -> e2.getId() == e.getId())).collect(Collectors.toSet());




        return repository.getAll()
                .stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> getByCity(final String city) {

    /*  List<Employee> all = repository.getAll();
        List<Employee> empList = new ArrayList<>();
        for (Employee emp : all) {
            if(emp.getAddress().getCity().equals(city)){
                empList.add(emp);
            }
        }

        return empList;*/

        //repository.getAll().stream().filter(emp -> emp.getAddress().getCity().equals(city)).map(Employee::addresess).collect(Collectors.toList()).stream().filter();

        repository.getAll()
                .stream()
                .filter(emp -> emp.getAddress() != null)
                .map(Employee::getAddress)
                .map(address -> {
                    if (address.getCity() == "Hyd") {
                        //return address.getCity();
                        return "Hyderabad";
                    } else if (address.getCity() == "Gintur") {
                        return "Guntur";
                    } else {
                        return null;
                    }
                })
                .findFirst()
                .orElse(null);

        //Streaming list of lists
        String s = repository.getAll()
                .stream()
                .filter(emp -> emp.getAddress().getCity().equals(city))
                .map(Employee::addresess)
                .map(addresses -> addresses
                        .stream()
                        .filter(address -> address != null && address.getCity() != null)
                        .findAny())
                .findAny()
                .get()
                .map(Address::getCity)
                .orElse(null);


        // This is equivalent to the above code
        return repository.getAll()
                .stream()
                .filter(emp -> emp.getAddress().getCity().equals(city))
                .collect(Collectors.toList());
    }
}

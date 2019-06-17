package com.vish.springmaven.rough;

import com.vish.springmaven.modal.Address;
import com.vish.springmaven.modal.Employee;
import com.vish.springmaven.repository.EmployeeRepository;
import com.vish.springmaven.utils.OptionalUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Test1 {
    public static void main(String[] args) {

        EmployeeRepository repo = new EmployeeRepository();

        repo.init();

        List<Employee> all = repo.getAll();

        Boolean hyd = OptionalUtils.resolveNestedNulls(() -> all.get(0).getAddress().getSalary().doubleValue()).orElse(Double.valueOf(0)) > 0;

        /* String s = "Abc";

        all.stream().filter(emp -> Objects.nonNull(emp.getAddress())).findFirst().ifPresent(emp -> emp.setName(Objects.nonNull(s) ? s : null));

        List<Address> empNames = new ArrayList<>();
        for(Employee emp: all){
            Address addr = new Address();
            addr.setCity(emp.getAddress().getCity());
            addr.setState(emp.getAddress().getState());
            empNames.add(addr);
        }*/

        System.out.println("asdasd");
    }




}

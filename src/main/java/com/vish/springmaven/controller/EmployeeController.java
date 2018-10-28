package com.vish.springmaven.controller;

import com.vish.springmaven.modal.Employee;
import com.vish.springmaven.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    DataRepository<Employee> repository;

    @RequestMapping("getAll")
    public String getAll(ModelMap modelMap) {
        modelMap.addAttribute("employees" ,repository.getAll());
        return "employees";
    }
}

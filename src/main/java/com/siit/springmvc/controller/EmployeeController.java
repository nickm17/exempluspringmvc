package com.siit.springmvc.controller;

import com.siit.springmvc.model.EmployeeEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @RequestMapping(method = RequestMethod.GET, path = "/showEmployees")
    public String showEmployeesPage(Model model){
        EmployeeEntity attributeValue = new EmployeeEntity();
        attributeValue.setId(1);
        attributeValue.setJob("job");
        attributeValue.setName("job");
        attributeValue.setSalary(122222);
        model.addAttribute("employeeList", List.of(attributeValue, attributeValue, attributeValue));

        return "employees";
    }

}

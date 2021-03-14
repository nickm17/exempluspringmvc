package com.siit.springmvc.exception;

import com.siit.springmvc.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueEmployeeName, String> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String name,
                           ConstraintValidatorContext cxt) {

        if(employeeRepository.existsByName(name)) {
            return false; // invalid
        }
        return true; // valid
    }
}

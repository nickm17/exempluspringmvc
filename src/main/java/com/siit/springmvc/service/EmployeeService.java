package com.siit.springmvc.service;

import com.siit.springmvc.exception.EmployeeNotFoundException;
import com.siit.springmvc.model.dto.EmployeeCreationRequest;
import com.siit.springmvc.model.dto.EmployeeUpdateRequest;
import com.siit.springmvc.model.entity.EmployeeEntity;
import com.siit.springmvc.repository.DepartmentRepository;
import com.siit.springmvc.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public EmployeeEntity getEmployeeById(Integer id){
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("No empl found for given id"));
    }

    public EmployeeEntity updateEmployee(EmployeeUpdateRequest request){
        EmployeeEntity employeeEntity = employeeRepository.findById(request.getId()).orElseThrow(() -> new EmployeeNotFoundException("No empl found for given id"));

        employeeEntity.setName(request.getName());
        employeeEntity.setJob(request.getJob());
        employeeEntity.setManager(request.getManager());

        return employeeRepository.save(employeeEntity);
    }


    public EmployeeEntity createEmployee(EmployeeCreationRequest request) {
        var employeeEntityBuilder = EmployeeEntity.builder()
                                                  .hiredate(request.getHiredate())
                                                  .job(request.getJob())
                                                  .manager(request.getManager())
                                                  .salary(request.getSalary())
                                                  .department(departmentRepository.findById(request.getDepartment())
                                                                                  .orElseThrow());
        if (request.getDepartment() == 7566) {
            employeeEntityBuilder.comision(518);
        } else {
            employeeEntityBuilder.comision(200);
        }

        return employeeRepository.save(employeeEntityBuilder.build());
    }

    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }

}

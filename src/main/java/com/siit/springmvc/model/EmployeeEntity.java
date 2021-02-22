package com.siit.springmvc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
//@Builder
//@AllArgsConstructor
//@Entity
//@Table(name = "employee")
public class EmployeeEntity {

//    @Id //pkey
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // pentru generate auto
    private int id;

    private String job;

    private String name;

    @Column(name = "mgr")
    private Integer manager;

    private Integer salary;

    @Column(name = "comm")
    private Integer comision;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "department_Id", referencedColumnName = "id")
    private DepartmentEntity department;

    private LocalDate hiredate;

}

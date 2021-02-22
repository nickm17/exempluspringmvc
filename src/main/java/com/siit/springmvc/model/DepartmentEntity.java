package com.siit.springmvc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
//@Builder
//@AllArgsConstructor
//@Entity
//@Table(name = "department")
public class DepartmentEntity {

    @Id //pkey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pentru generate auto
    private int id;

    private String name;

    private String city;


    @ToString.Exclude
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
//    @JoinColumn
    private List<EmployeeEntity> employeeEntityList;

}

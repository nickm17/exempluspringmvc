//package com.siit.springmvc.repository;
//
//import com.siit.jpa.model.EmployeeEntity;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Repository
//public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
//
//    List<EmployeeEntity> findAllByHiredateAfterAndHiredateBefore(LocalDate after, LocalDate before);
//    List<EmployeeEntity> findAllByHiredateBetween(LocalDate after, LocalDate before);
//
//    @Query("SELECT e FROM EmployeeEntity e LEFT JOIN e.department WHERE e.name = :name ") // query jpql
//    List<EmployeeEntity> findAllByNameCustomQuery(@Param("name") String name);
//
//    List<EmployeeEntity> findAllByName(String name);
//
//    @Query(value = "SELECT * FROM employee where id = :1", nativeQuery = true) // query sql
//    EmployeeEntity findNative(int id);
//}

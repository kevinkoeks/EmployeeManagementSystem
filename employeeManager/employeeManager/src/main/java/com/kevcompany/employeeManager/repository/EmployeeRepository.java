package com.kevcompany.employeeManager.repository;

import com.kevcompany.employeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//Don't have to write all the functions to manipulate the data, cause the Jpa does it
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

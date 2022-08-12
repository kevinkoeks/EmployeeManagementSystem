package com.kevcompany.employeeManager.service;

import com.kevcompany.employeeManager.model.Employee;
import com.kevcompany.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) { //Injecting the repo in this class. To do all CRUD operations
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        employee.setCodeForEmployee(UUID.randomUUID().toString()); //Generates Random ID
        return employeeRepository.save(employee);
    }
}

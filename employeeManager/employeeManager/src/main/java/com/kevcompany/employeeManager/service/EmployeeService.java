package com.kevcompany.employeeManager.service;

import com.kevcompany.employeeManager.exception.UserNotFoundException;
import com.kevcompany.employeeManager.model.Employee;
import com.kevcompany.employeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Employee> findAllTheEmployee() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findTheEmployeeById(Long id) {
        return employeeRepository.findTheEmployeeById(id).orElseThrow( () -> new UserNotFoundException("User by the id: " + id + " was not found"));
    }

    public void deleteTheEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }


}

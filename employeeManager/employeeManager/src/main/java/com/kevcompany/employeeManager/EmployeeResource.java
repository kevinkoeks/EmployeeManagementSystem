package com.kevcompany.employeeManager;

import com.kevcompany.employeeManager.model.Employee;
import com.kevcompany.employeeManager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") //Setting a base URL
public class EmployeeResource {
    private final EmployeeService employeeService; //Pulling the service class into this class

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all") //Retrieve info from backend (all employee)
    public ResponseEntity<List<Employee>> getAllEmployees (){
        List<Employee> employees = employeeService.findAllTheEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}") //Follows the RequestMapping path above
    public ResponseEntity<Employee> getTheEmployeeById (@PathVariable("id") Long id){ //Gets the "id" that was in the URL
        Employee employee = employeeService.findTheEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add") // Post/creat info to the backend server
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) { //Receives the body of Employee info in Json format
        Employee newEmployee = this.employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update") // Puts/update current employee in the backend server
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) { //See from id that employee already exists
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id) { // "<?>" place holder, when doesn't return anything
        employeeService.deleteTheEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

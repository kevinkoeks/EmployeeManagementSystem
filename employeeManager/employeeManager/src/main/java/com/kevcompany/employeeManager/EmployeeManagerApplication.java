package com.kevcompany.employeeManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		// Remember to: Used Jasypt for encryption  https://www.youtube.com/watch?v=axGfLehcwdw&ab_channel=SanjayY
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}

}

package com.shree.controllers;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shree.model.CalculateSalaryRequest;
import com.shree.model.Employee;
import com.shree.model.EmployeeLeave;
import com.shree.model.Leave;
import com.shree.msinterfaces.EmployeServiceProxy;
import com.shree.msinterfaces.EmployeeLeaveServiceProxy;



@RestController
public class CalculateSalaryApiController {

    private static final Logger log = LoggerFactory.getLogger(CalculateSalaryApiController.class);
    @Autowired
    EmployeServiceProxy employeServiceProxy;
    @Autowired
    EmployeeLeaveServiceProxy employeeLeaveServiceProxy;
    
    @PostMapping("/calculateSalary")
    public ResponseEntity<Employee> calculateSalary(@RequestBody CalculateSalaryRequest calculateSalaryRequest) {
        String emp_id = calculateSalaryRequest.getEmployeeId();
        int employee_id = Integer.parseInt(emp_id);
        String year_month = calculateSalaryRequest.getYearmonth();
        //call getEmployee service with empid as i/p
        Map<String, Integer> getEmployeeByIdServiceInput = new HashMap<>();
       
        getEmployeeByIdServiceInput.put("employee_id",employee_id);
        //Call Other microservice using Feign
        Optional<Employee> emp1 = employeServiceProxy.getEmployeeById(employee_id);
        Employee emp = 	emp1.get();
        // ResponseEntity<Employee> getEmployeeByIdServiceResponse =  new RestTemplate().getForEntity("http://localhost:8000/getEmployeeById/{employee_id}", Employee.class, getEmployeeByIdServiceInput);
        //Employee emp =getEmployeeByIdServiceResponse.getBody();
        System.out.println("Employee details fetched :  "+" empName :"+emp.getName()+" empId :"+emp.getEmployeeId()+" baseSalary :" +emp.getBaseSalary());
        
        
        
        
        
        Map<String, String> employeeLeaveServiceInput = new HashMap<>();
        employeeLeaveServiceInput.put("employee_id",emp_id);
        employeeLeaveServiceInput.put("year_month",year_month);
        EmployeeLeave employeeLeave = (employeeLeaveServiceProxy.getEmployeeLeaveById(emp_id, year_month)).get();
		/*
		 * ResponseEntity<EmployeeLeave> employeeLeaveServiceResponse = new
		 * RestTemplate().getForEntity(
		 * "http://localhost:8001/employeeLeave/{employee_id}/{year_month}",
		 * EmployeeLeave.class, employeeLeaveServiceInput); EmployeeLeave employeeLeave
		 * = employeeLeaveServiceResponse.getBody();
		 */
        int leaveCount =0;
        		for(Leave leave:employeeLeave.getLeaveDetails()) {
        			leaveCount =leaveCount+leave.getCount();
        		}
        		
        		emp.setBaseSalary(emp.getBaseSalary()-(leaveCount*17));
        System.out.println("Employee Leave details fetched :"+ employeeLeave.getLeaveDetails());
        return new ResponseEntity<Employee>(emp, HttpStatus.OK);
    }

}

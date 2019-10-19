package com.shree.msinterfaces;

import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shree.model.Employee;

@FeignClient(name="EmployeeService")//url="localhost:8000")
@RibbonClient(name="EmployeeService")
public interface EmployeServiceProxy {
	@GetMapping("/getEmployeeById/{employee_id}")
    public Optional<Employee> getEmployeeById(@PathVariable("employee_id") int employee_id);
}

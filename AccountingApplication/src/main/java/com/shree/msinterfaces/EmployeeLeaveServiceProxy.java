package com.shree.msinterfaces;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.shree.model.EmployeeLeave;

@FeignClient(name="WorkHour-service", url="localhost:8001")
public interface EmployeeLeaveServiceProxy {
	@GetMapping("/employeeLeave/{employee_id}/{year_month}")
    public Optional<EmployeeLeave> getEmployeeLeaveById(@PathVariable("employee_id") String employee_id,@PathVariable("year_month") String year_month);
}

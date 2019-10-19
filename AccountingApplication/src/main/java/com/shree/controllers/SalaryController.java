package com.shree.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shree.constant.MyConstants;
import com.shree.model.EmpSalaryModel;


@RestController
@ComponentScan
public class SalaryController {
	
	
	/*
	 * @Autowired KafkaTemplate<String,String> kafkaTemplate;
	 */
	
	@Autowired
	KafkaTemplate<String,EmpSalaryModel> kafkaTemplateJson;
	
	
	@GetMapping("/publishsalary/{message}")
	public String produceStringSalary(@PathVariable String message) {
		//kafkaTemplateJson.send(MyConstants.TOPIC, message);
		return "salary published successfully";
	}
	
	@GetMapping("/publishJsonSalary")
	public String produceJsonSalary() {
		EmpSalaryModel emp = new EmpSalaryModel("600", "200", "10000");
		kafkaTemplateJson.send(MyConstants.TOPIC, emp);
		return "salary published successfully";
	}
}

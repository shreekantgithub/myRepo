package com.shree.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.constant.MyConstants;
import com.shree.model.EmpSalaryModel;

@RestController
@ComponentScan
public class SalaryConsumerService {
	
	List<String> kafkaMessages = new ArrayList<>();
	EmpSalaryModel EmpSalaryModel = null;
	/*
	@GetMapping("/consumesalary")
	public List<String> consumeStringMessage(){
		return kafkaMessages;	
	}
	
	
	@KafkaListener(groupId ="stringConsumer",topics=MyConstants.TOPIC,containerFactory="kafkaListenerContainerFactory")//ForString
	public List<String> getStringSalaryFromTopic(String msg) {
		kafkaMessages.add(msg);
		return kafkaMessages;
	}*/
	
	@GetMapping("/consumesalaryJson")
	public EmpSalaryModel consumeJsonMessage(){
		return EmpSalaryModel;	
	}
	@KafkaListener(groupId ="jsonConsumer",topics=MyConstants.TOPIC,containerFactory="kafkaListenerContainerFactory")
	public EmpSalaryModel getJsonSalaryFromTopic(EmpSalaryModel empSalaryModel) {	
		this.EmpSalaryModel =empSalaryModel;
		return empSalaryModel;
	}
}

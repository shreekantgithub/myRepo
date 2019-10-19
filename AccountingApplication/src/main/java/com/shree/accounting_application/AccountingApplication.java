package com.shree.accounting_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.shree","com.shree.kafka.config"})
@EnableFeignClients("com.shree.msinterfaces")
@EnableDiscoveryClient
public class AccountingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountingApplication.class, args);
		System.out.println("------------------------------Welcome to Accounting Service------------------------------------------");
	}

}

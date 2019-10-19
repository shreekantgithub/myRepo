package com.shree.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.shree.model.EmpSalaryModel;

@Configuration
@EnableKafka
@ComponentScan
public class KafkaConsumerConfig {

	private static final String BOOTSTRAP_SERVER_CONFIG ="localhost:9092";
	
	/*
	@Bean
	public ConsumerFactory<String, String> stringConsumerFactory(){
		
		Map<String,Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER_CONFIG);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "stringConsumer");
		return new DefaultKafkaConsumerFactory<>(config);
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(){//ForString
		
		ConcurrentKafkaListenerContainerFactory<String, String> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(stringConsumerFactory());
		return concurrentKafkaListenerContainerFactory;
		
	}*/

	@Bean
	public ConsumerFactory<String, EmpSalaryModel> consumerFactoryForJson(){
		
		Map<String,Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER_CONFIG);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "jsonConsumer");
		return new DefaultKafkaConsumerFactory<>(config,new StringDeserializer(),new JsonDeserializer<>(EmpSalaryModel.class));
		
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, EmpSalaryModel> kafkaListenerContainerFactory(){
		
		ConcurrentKafkaListenerContainerFactory<String, EmpSalaryModel> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactoryForJson());
		return concurrentKafkaListenerContainerFactory;
		
	}
}

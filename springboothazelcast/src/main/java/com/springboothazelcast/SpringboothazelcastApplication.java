package com.springboothazelcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.springboothazelcast")
@EntityScan("com.springboothazelcast.*")
public class SpringboothazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboothazelcastApplication.class, args);
	}

}

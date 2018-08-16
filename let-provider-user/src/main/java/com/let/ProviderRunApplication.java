package com.let;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient	//注册
public class ProviderRunApplication {
	public static void main(String[] args) {
	    SpringApplication.run(ProviderRunApplication.class, args);
	  }
}

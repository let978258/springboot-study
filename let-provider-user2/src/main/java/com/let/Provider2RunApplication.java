package com.let;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient	//注册
public class Provider2RunApplication {
	public static void main(String[] args) {
	    SpringApplication.run(Provider2RunApplication.class, args);
	  }
}

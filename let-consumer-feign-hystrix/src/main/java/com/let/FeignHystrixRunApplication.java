package com.let;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients			//开启feign
@EnableCircuitBreaker 		//开启feign
public class FeignHystrixRunApplication {
	public static void main(String[] args) {
        SpringApplication.run(FeignHystrixRunApplication.class, args);
    }
}

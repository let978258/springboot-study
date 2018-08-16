package com.let.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.let.service.HystrixClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HelloController {
	//调用接口方法
	@Autowired
	private HystrixClient hystrixClient;
	
	@RequestMapping("/hello/{name}")
	@HystrixCommand(fallbackMethod="fallback")
	public String hello(@PathVariable String name) {
		//成功调用提供者的微服务
		return hystrixClient.hello(name);
	}
	
	/**匹配@HystrixCommand的参数,
	 * 返回值必须与正常业务返回值类型一致,
	 * 参数必须调用方法一致
	 */
	public String fallback(String name) {
		return "tony:"+name;
	}
	
}

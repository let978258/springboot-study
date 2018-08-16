package com.let.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.let.service.EurekaServiceFeign;

@RestController
public class HelloController {
	//调用接口方法
	@Autowired
	private EurekaServiceFeign eurekaServiceFeign;
	
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		return eurekaServiceFeign.hello(name);
	}
}

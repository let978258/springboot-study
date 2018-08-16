package com.let.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 1.此处可以替换成@GetMapping()(因为后面feign必须使用@RequestMapping(),
	 * 	   所以我就统一用@RequstMapping)
	 * 2.@ResponseBody为什么不需要使用?
	 *   因为@RestController此注解的源码层已经将@ResponseBody进行了封装,
	 *   所以可以不写.
	 * 3.url的替换,实现负载均衡中的轮询方式,在url中直接添加注册中心的同服务多实例的
	 *   提供者,但是需要在RunApplication中添加一个@LoadBalanced(Ribbon
	 *   的负载均衡)
	 */
	//@ResponseBody
	@RequestMapping("/hello/{name}")
	public String hello(@PathVariable String name) {
		//String url="http://localhost:7900/hello"+name;
		String url="http://let-provider-user/hello/"+name;
		return this.restTemplate.getForObject(url, String.class);
	}
}

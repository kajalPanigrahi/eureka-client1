package com.stackroute.zuulservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/hello")
public class HelloController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public static final Logger LOG = LoggerFactory.getLogger(HelloController.class);
	@GetMapping("/hi")
	public String sayHi() {
		LOG.info("Inside Hello Controller.. Before saying hi");
		String msgReceived = restTemplate.getForObject("http://eureka-client2/api/v1/greeting/hello", String.class);
		LOG.info("Inside Hello Controller.. After Getting the Respsone from Greeting Service.." + msgReceived);
		return "hi";
	}

}

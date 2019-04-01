package com.springboot.adv.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.adv.configuration.BasicConfiguration;

@RestController
public class WelcomeController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	// dependency injected in Spring here...
	@Autowired
	private BasicConfiguration basicConfig;

	@RequestMapping("/welcome")
	public String welcome() {
		return welcomeMessage;
	}

	@RequestMapping("/dynamic-configuration")
	public Map dynamicConfiguration() {

		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("message", basicConfig.getMessage());
		map.put("number", basicConfig.getNumber());
		map.put("value", basicConfig.isValue());

		return map;
	}
}

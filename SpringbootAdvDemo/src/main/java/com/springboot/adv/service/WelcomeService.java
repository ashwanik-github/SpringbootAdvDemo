package com.springboot.adv.service;

import org.springframework.stereotype.Component;
//Spring can use @Component or @Service for the 
@Component
public class WelcomeService {
	public String retrieveWelcomeMessage() {
		return("Good AfterNoon Ashwani K!!");
	}
}
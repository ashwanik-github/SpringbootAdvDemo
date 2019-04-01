package com.springboot.adv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.adv")
public class SpringbootApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringbootApplication.class, args);
	}

}

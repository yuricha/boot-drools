package com.rules.bootdrools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BootDroolsApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BootDroolsApplication.class, args);
	}
}

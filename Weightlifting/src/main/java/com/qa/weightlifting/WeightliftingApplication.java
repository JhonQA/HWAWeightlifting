package com.qa.weightlifting;

import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeightliftingApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(WeightliftingApplication.class, args);
//		
//		Object byName = context.getBean("time");
//		LocalTime byType = context.getBean(LocalTime.class);
//		LocalTime byBoth = context.getBean("time",LocalTime.class);
//		
//		System.out.println(byName);
//		System.out.println(byBoth);
//		System.out.println(byType);
	}
	
	
//	@Bean
//	public LocalTime time() {
//		
//		return LocalTime.now();
//	}

}

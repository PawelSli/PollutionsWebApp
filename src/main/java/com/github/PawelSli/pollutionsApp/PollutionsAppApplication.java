package com.github.PawelSli.pollutionsApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PollutionsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollutionsAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext applicationContext){
		return args -> {
			System.out.println("Let's inspect beans provided by Spring Boot");
			String[] beansNames=applicationContext.getBeanDefinitionNames();
			for(String beanName:beansNames)
				System.out.println(beanName);
		};
	}

}

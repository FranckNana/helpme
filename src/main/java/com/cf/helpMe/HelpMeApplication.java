package com.cf.helpMe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({LiquibaseProperties.class})
public class HelpMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpMeApplication.class, args);
	}

}

package com.cf.helpMe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableConfigurationProperties({LiquibaseProperties.class})
@PropertySource(value = {"classpath:application.prod.properties"},ignoreResourceNotFound = true)
public class HelpMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpMeApplication.class, args);
	}

}

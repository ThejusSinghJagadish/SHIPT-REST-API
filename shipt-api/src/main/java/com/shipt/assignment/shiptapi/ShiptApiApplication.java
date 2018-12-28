package com.shipt.assignment.shiptapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ShiptApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiptApiApplication.class, args);
	}
}

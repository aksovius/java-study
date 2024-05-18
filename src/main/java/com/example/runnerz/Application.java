package com.example.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.foo.WelcomeMessage;
import com.example.runnerz.run.Location;
import com.example.runnerz.run.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
		var welcomeMessage = new WelcomeMessage();
		System.out.println(welcomeMessage.getWelcomeMessage());
	}

	@Bean

	CommandLineRunner runner() {
		return args -> {
			Run run = new Run ( 1, "First run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}
}

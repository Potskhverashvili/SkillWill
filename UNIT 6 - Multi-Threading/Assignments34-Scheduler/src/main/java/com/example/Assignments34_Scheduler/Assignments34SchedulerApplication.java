package com.example.Assignments34_Scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Assignments34SchedulerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignments34SchedulerApplication.class, args);
	}

}

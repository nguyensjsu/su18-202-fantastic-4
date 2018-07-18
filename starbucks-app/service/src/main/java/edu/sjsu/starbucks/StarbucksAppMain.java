package edu.sjsu.starbucks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
//@Import(API.class)
public class StarbucksAppMain {

	public static void main(String[] args) {
		SpringApplication.run(StarbucksAppMain.class, args);
	}
}

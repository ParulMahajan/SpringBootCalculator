package com.central.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.central"})
public class SpringBootCalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCalcApplication.class, args);
	}

}

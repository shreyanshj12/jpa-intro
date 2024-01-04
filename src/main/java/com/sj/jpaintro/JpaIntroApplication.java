package com.sj.jpaintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaIntroApplication {

	public static void main(String[] args) {
		System.out.println("change after commit");
		SpringApplication.run(JpaIntroApplication.class, args);
	}

}

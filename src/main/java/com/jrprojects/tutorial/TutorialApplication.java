package com.jrprojects.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

		print(1, 2);
	}

	public static void print(int num, int num2) {
		System.out.println("Hola");
	}

}

package com.jrprojects.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	private static Logger logger = LoggerFactory.getLogger(TutorialApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

		logger.debug("Mi mensaje debug");
		logger.trace("Mi mensaje trace");
		logger.info("Mi mensaje info");
	}
}

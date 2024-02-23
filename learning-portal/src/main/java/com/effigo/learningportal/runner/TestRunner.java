package com.effigo.learningportal.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		log.info("This is for testing purposes");
	}

}

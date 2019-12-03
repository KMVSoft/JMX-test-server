package com.mikhail.jmxclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JMXClientApplication {

	@Autowired
	private JMXClient client;

	public static void main(String[] args) {
		SpringApplication.run(JMXClientApplication.class, args);
	}

	@PostConstruct
	void init() {
		AirplaneMBean airplane = client.test();
		System.out.println("Airplane speed: " + airplane.getSpeed());

	}

}

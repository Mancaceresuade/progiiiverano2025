package com.ejemplo.ejemplo;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.GraphDatabase;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemploApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EjemploApplication.class, args);
	}
}

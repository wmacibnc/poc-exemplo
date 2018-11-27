package com.stefanini.pocexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PocExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocExemploApplication.class, args);
	}
}

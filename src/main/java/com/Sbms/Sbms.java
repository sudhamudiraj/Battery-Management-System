package com.Sbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Sbms {

	public static void main(String[] args) {
		SpringApplication.run(Sbms.class, args);
	}

}

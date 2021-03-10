package br.com.clientclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientClientApplication.class, args);
	}
	
}

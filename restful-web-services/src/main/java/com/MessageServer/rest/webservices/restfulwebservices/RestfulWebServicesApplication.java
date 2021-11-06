package com.MessageServer.rest.webservices.restfulwebservices;

import com.MessageServer.rest.webservices.restfulwebservices.exception.BadRequestException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) throws BadRequestException, IOException, InterruptedException {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}

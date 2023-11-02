package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class EasybankBackendApplication {

	public static void main(String[] args) {
//		HttpServletRequest
		SpringApplication.run(EasybankBackendApplication.class, args);
	}

}

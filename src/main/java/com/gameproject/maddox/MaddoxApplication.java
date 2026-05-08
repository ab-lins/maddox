package com.gameproject.maddox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.gameproject.maddox.service.AuthService;

@SpringBootApplication
public class MaddoxApplication {

	public static void main(String[] args) {
		// Start the application
		SpringApplication.run(MaddoxApplication.class, args);
	}

}

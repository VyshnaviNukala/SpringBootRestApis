package com.example.sb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration.class})

public class Sb1Application {

	public static void main(String[] args) {
		SpringApplication.run(Sb1Application.class, args);
	}

}


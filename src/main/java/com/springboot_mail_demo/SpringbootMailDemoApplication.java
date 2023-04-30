package com.springboot_mail_demo;

import com.springboot_mail_demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootMailDemoApplication
{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMailDemoApplication.class, args);
	}

}

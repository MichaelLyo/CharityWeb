package com.tongji.charityweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Controller;

//Enable JPA Auditing
@EnableJpaAuditing
@SpringBootApplication
public class WebApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(WebApplication.class, args);
	}
}

package com.tongji.gongyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.tongji.gongyi")
public class GongyiApplication {
public static void main(String[] args) {
		SpringApplication.run(GongyiApplication.class, args);
	}
}

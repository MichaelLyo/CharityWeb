package com.tongji.gongyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.tongji.gongyi.controller")
public class GongyiApplication {
public static void main(String[] args) {
		SpringApplication.run(GongyiApplication.class, args);
	}
}

package com.example.demo_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoGradleApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	@RequestMapping("/home2")
	public String home2() {
		return "Hello Docker Please work World";
	}

	@RequestMapping("/home3")
	public String home3() {
		return "Home 3";
	}

	@RequestMapping("/home4")
	public String home4() {
		return "Carlitos";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoGradleApplication.class, args);
	}

}

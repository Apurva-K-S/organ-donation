package com.example.iiitb.OrganDonation;

import com.example.iiitb.OrganDonation.Controller.RegisterController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ComponentScan(basePackageClasses = RegisterController.class)
@EnableAutoConfiguration
@EnableJpaRepositories("com.example.iiitb.OrganDonation.DAO")

public class OrganDonationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OrganDonationApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/*").allowedOrigins("http://localhost:4200").allowedHeaders("*");
			}
		};
	}
}

package com.example.iiitb.OrganDonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.iiitb"})

@EnableAutoConfiguration
@EnableJpaRepositories("com.example.iiitb")


public class OrganDonationApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OrganDonationApplication.class, args);
    }

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        String url = System.getenv("DATABASE_HOST");
        if (url != null) {
            dataSourceBuilder.url("jdbc:mysql://organ-mysql:3306/OrganDonation?useSSL=false&allowPublicKeyRetrieval=true&autoReconnect=true&failOverReadOnly=false&maxReconnects=10");

        } else {
            dataSourceBuilder.url("jdbc:mysql://localhost:3306/OrganDonation");
        }
        dataSourceBuilder.username("chandanteja");
        dataSourceBuilder.password("@2B2c2d2");

        return dataSourceBuilder.build();
    }

//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/api/*").allowedOrigins("*").allowedHeaders("*");
//            }
//        };
//    }
}

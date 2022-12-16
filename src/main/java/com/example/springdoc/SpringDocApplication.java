package com.example.springdoc;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Element management system",
        version = "1.0.0",
        description = "System for elements management"))
public class SpringDocApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDocApplication.class, args);
    }

}

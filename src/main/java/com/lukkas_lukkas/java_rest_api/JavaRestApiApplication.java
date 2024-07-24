package com.lukkas_lukkas.java_rest_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "Java rest api",
                description = "Project to practice java development and RESTFul API concepts"
        )
)
@SpringBootApplication
public class JavaRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaRestApiApplication.class, args);
	}

}

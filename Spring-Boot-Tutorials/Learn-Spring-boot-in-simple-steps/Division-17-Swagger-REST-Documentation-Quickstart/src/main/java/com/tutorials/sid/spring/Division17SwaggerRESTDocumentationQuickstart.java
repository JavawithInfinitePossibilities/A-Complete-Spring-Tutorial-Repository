package com.tutorials.sid.spring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * SWAGGER DOC URL: http://localhost:8080/Studentseminar/v3/api-docs
 * SWAGGER UI URL: http://localhost:8080/Studentseminar/swagger-ui.html
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Student API", version = "1.0", description = "Student API"))
public class Division17SwaggerRESTDocumentationQuickstart {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        SpringApplication.run(Division17SwaggerRESTDocumentationQuickstart.class, args);
    }
}

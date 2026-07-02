package com.tutorials.sid.spring;

import com.tutorials.sid.spring.data.DummyDataTable;
import com.tutorials.sid.spring.entity.Course;
import com.tutorials.sid.spring.services.CourseServices;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @author kunmu On 02-07-2026
 */
@SpringBootTest(classes = App.class)
class AppTest {

    @Autowired
    private CourseServices courseServices;

    @Disabled
    @Test
    void contextLoads() {
        System.out.println("Hello World!");
    }

    @Test
    @Disabled
    public void displayData() {
        DummyDataTable.getEmployees().forEach(System.out::println);
    }

    @Disabled
    @Test
    public void insertDataInCourse() {
        List<Course> courses = Arrays
                .asList(new Course("Spring Boot", "Spring Boot is a framework that simplifies the development of Spring applications."),
                new Course("Spring Data JPA", "Spring Data JPA is a part of the Spring Data project that makes it easier to implement JPA-based repositories."),
                new Course("Spring Security", "Spring Security is a powerful and highly customizable authentication and access-control framework for Java applications."),
                new Course("Spring Cloud", "Spring Cloud provides tools for developers to quickly build some of the common patterns " +
                        "in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus)."));
        courseServices.saveCourse(courses);
    }

    @Disabled
    @Test
    public void displayDataFromCourse() {
        courseServices.getCourse().forEach(System.out::println);
    }

    @Disabled
    @Test
    public void deleteDataFromCourse() {
        System.out.println("Deleting data from Course");
        Course course = courseServices.getCourseById(2L);
        if (course != null) {
            courseServices.deleteCourse(course);
        }
    }
}

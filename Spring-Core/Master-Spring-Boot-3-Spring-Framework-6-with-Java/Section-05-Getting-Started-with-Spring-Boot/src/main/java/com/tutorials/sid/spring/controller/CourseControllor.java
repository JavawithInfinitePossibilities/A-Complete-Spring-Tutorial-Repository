package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.bean.Course;
import com.tutorials.sid.spring.bean.CurrencyProfileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author kunmu On 02-07-2026
 */
@RestController
public class CourseControllor {

    @Autowired
    private CurrencyProfileDetails currencyProfileDetails;

    /*
    * URL: http://localhost:8080/courses
    * */
    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        // Implementation here
        List<Course> courses = Arrays.asList(
                new Course(1, "Course 1", "Description 1"),
                new Course(2, "Course 2", "Description 2")
        );
        return courses;
    }

    /*
     * URL: http://localhost:8080/currency-services
     * */
    @GetMapping("/currency-services")
    public CurrencyProfileDetails getCurrencyServices() {
        return currencyProfileDetails;
    }
}

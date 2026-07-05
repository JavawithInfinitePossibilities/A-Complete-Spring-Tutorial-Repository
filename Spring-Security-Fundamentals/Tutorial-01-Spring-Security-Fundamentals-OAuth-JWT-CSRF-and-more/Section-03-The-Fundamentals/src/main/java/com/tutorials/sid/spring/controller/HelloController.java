/**
 *
 */
package com.tutorials.sid.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kunmu
 * This URL are secured by Spring basic authentication.
 * URL: http://localhost:8080/Section-03-The-Fundamentals/hello
 *      http://localhost:8080/Section-03-The-Fundamentals/welcome
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Welcome to Spring security!!!";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring security with spring boot!!!";
    }
}

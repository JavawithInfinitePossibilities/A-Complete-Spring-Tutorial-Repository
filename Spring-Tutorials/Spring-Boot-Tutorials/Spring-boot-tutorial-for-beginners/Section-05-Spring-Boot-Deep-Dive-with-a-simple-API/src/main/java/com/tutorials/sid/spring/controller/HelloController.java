/**
 * 
 */
package com.tutorials.sid.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo<br/>
 *         URL: http://localhost:8080/hello
 *
 */
@RestController
public class HelloController {

	@Value("${welcome.message}")
	private String welcomeValue;

	@RequestMapping("/hello")
	public String helloSpringBoot() {
		return welcomeValue;
	}
}

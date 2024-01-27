/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
public class Section05SpringBootDeepDivewithasimpleAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section05SpringBootDeepDivewithasimpleAPI.class, args);
	}

	@Profile("dev")
	@Bean
	public String dummy() {
		return "something";
	}
}

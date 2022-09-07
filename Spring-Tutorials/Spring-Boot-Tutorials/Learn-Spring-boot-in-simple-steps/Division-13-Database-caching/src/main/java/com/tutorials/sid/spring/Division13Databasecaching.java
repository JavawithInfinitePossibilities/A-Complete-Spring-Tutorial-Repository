/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableCaching
public class Division13Databasecaching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Division13Databasecaching.class, args);
	}

}

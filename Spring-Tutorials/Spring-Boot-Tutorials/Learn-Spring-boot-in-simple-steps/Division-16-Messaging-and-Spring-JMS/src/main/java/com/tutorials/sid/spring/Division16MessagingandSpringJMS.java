/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableJms
public class Division16MessagingandSpringJMS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Division16MessagingandSpringJMS.class, args);
	}

}

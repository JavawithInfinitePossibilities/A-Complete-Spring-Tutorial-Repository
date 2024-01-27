/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableBatchProcessing
public class Division14SpringBatchDBOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Division14SpringBatchDBOperation.class, args);
	}

}

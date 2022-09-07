/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class Section02SpringCloudProductServices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section02SpringCloudProductServices.class, args);
	}

}

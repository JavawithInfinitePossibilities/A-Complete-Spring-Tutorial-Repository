/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Section01SpringCloudCouponServices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section01SpringCloudCouponServices.class, args);
	}

}

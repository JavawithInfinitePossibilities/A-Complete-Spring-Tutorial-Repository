/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Lenovo
 *import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 * @EnableEurekaClient: This has been removed from the Spring cloud discovery services.
 * the version from which it is disabled from 2022.0.
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Section01SpringCloudCouponServices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section01SpringCloudCouponServices.class, args);
	}

}

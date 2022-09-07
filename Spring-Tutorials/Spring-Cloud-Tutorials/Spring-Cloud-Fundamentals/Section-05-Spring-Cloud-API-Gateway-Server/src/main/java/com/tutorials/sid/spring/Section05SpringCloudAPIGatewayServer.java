/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lenovo<br/>
 *         URL : http://localhost:9091/productcart/productdetails/productSave/ {
 *         "name": "Iphone 2022-8", "description": "Iphone Apple 2022-8",
 *         "price": 1600.0, "couponCode": "SUPERSEAL2021" }
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class Section05SpringCloudAPIGatewayServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section05SpringCloudAPIGatewayServer.class, args);
	}

}

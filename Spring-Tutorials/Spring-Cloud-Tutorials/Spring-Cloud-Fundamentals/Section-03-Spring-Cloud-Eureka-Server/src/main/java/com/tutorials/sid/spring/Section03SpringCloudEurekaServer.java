/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Lenovo <br/>
 *         Eureka server URL: http://localhost:8761/
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class Section03SpringCloudEurekaServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section03SpringCloudEurekaServer.class, args);
	}

}

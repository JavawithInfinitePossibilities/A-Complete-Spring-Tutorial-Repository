/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
@EnableConfigServer
public class Section06SpringCloudConfigserver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Section06SpringCloudConfigserver.class, args);
	}

}

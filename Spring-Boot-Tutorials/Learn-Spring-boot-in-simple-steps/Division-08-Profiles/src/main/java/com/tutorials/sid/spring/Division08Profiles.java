/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lenovo
 * How Profile-Based Property Override Works?
 * 1. application.properties is always loaded first (the base)
 * 2. Profile-specific properties files (e.g., application-dev.properties) override the base properties
 * 3. Command-line arguments override all
 * 3. The final resolved values at runtime
 * Property						Base value				Dev profile value			Final value used
 * server.servlet.context-path  /productcart			/productmart				/productmart
 * productrestapi.services.url …/productcart/… 			…/productmart/…				…/productmart/…
 * spring.datasource.url		jdbc:mysql://…/mydb		(not set)					jdbc:mysql://…/mydb
 * logging.file.name			(not set)				log/dev/application.log		log/dev/application.log
 * error.info.status			(not set)				false						false
 *
 */
@SpringBootApplication
public class Division08Profiles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Division08Profiles.class, args);
	}

}


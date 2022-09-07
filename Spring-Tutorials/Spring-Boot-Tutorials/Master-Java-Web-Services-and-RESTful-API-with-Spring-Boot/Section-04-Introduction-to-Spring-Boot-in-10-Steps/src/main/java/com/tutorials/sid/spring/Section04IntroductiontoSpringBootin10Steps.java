/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class Section04IntroductiontoSpringBootin10Steps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Section04IntroductiontoSpringBootin10Steps.class,
				args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}

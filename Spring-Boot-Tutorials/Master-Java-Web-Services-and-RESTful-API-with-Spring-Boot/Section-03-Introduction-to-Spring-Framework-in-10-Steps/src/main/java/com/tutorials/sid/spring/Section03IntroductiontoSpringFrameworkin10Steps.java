/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.tutorials.sid.spring.services.BinarySearchImpl;

/**
 * @author Lenovo
 *
 */
@SpringBootApplication
public class Section03IntroductiontoSpringFrameworkin10Steps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Section03IntroductiontoSpringFrameworkin10Steps.class, args);
		BinarySearchImpl bean = context.getBean(BinarySearchImpl.class);
		System.out.println(bean.binarySearch(new int[] { 1, 2, 3 }, 3));
	}

}

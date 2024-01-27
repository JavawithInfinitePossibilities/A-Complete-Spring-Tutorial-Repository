/**
 * 
 */
package com.tutorials.sid.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tutorials.sid.spring.bean.SpringCoreBean;

/**
 * @author Lenovo
 *
 */
public class Chapter03SpringCoreConcepts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Config.xml");
		SpringCoreBean bean = (SpringCoreBean) context.getBean("springCoreBean");
		System.out.println("Bean description: " + bean);
		SpringCoreBean bean1 = (SpringCoreBean) context.getBean("employee");
		System.out.println("Bean description: " + bean1);
		SpringCoreBean bean2 = (SpringCoreBean) context.getBean("emp");
		System.out.println("Bean description: " + bean2);
	}

}

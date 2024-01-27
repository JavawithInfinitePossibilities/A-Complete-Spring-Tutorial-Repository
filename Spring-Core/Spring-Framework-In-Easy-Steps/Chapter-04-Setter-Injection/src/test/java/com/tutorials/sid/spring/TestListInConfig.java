/**
 * 
 */
package com.tutorials.sid.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.sid.spring.bean.collection.List.Hospital;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestListInConfig {
	@Autowired
	ApplicationContext context;

	@Test
	public void testListInConfig() {
		Hospital hospital = (Hospital) context.getBean("hospital");
		System.out.println("Hospital : " + hospital);
		Hospital hospitalUtilList = (Hospital) context.getBean("hospitalUtilList");
		System.out.println("Hospital : " + hospitalUtilList);
	}
}

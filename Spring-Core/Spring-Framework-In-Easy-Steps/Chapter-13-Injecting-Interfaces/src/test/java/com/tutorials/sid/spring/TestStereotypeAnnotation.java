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

import com.tutorials.sid.spring.bean.intf.IOrderBAO;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestStereotypeAnnotation {

	@Autowired
	ApplicationContext context;

	@Test
	public void testStereotypeAnnotation() {
		IOrderBAO orderBAO = (IOrderBAO) context.getBean("orderBAOImpl");
		orderBAO.order();
	}
}

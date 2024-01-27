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

import com.tutorials.sid.spring.bean.reftype.ShoppingCart;
import com.tutorials.sid.spring.bean.reftype.Student;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestReftype {
	@Autowired
	ApplicationContext context;

	@Test
	public void testReftype() {
		Student student = (Student) context.getBean("student");
		System.out.println("Student detial : " + student);

		ShoppingCart shoppingCart = (ShoppingCart) context.getBean("flipcart");
		System.out.println("Shopping cart :" + shoppingCart);
	}
}

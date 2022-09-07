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

import com.tutorials.sid.spring.bean.SpringCoreBean;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Config.xml" })
public class TestPnamespace {
	@Autowired
	ApplicationContext context;

	@Test
	public void testCore() {
		SpringCoreBean bean = (SpringCoreBean) context.getBean("springCoreBeanPName");
		System.out.println("Bean description: " + bean);

		/*SpringCoreBean bean1 = (SpringCoreBean) context.getBean("employee");
		System.out.println("Bean description: " + bean1);
		SpringCoreBean bean2 = (SpringCoreBean) context.getBean("emp");
		System.out.println("Bean description: " + bean2);
		*/

	}
}

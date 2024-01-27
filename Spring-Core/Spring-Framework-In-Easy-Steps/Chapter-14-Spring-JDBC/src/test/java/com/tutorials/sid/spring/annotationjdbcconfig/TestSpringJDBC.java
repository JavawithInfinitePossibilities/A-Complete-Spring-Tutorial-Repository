/**
 * 
 */
package com.tutorials.sid.spring.annotationjdbcconfig;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tutorials.sid.spring.bean.Employee;

/**
 * @author Lenovo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/annotationjdbcconfig/Spring-Config.xml" })
public class TestSpringJDBC {

	@Autowired
	ApplicationContext context;

	@Test
	public void testSpringJDBCAnnotationConfigSave() {
		Employee employee = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee);
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		employeeDAO.employeeSave(employee);
		Employee employee2 = (Employee) context.getBean("employee");
		employeeDAO.employeeUsingPlaceholderSave(employee2);
	}

	@Ignore
	@Test
	public void testSpringJDBCAnnotationConfigUpdate() {
		Employee employee = (Employee) context.getBean("employee");
		employee.setId(7);
		employee.setFirstName("Sidhanth");
		System.out.println("Employee detial : " + employee);
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		employeeDAO.employeeUpdate(employee);
	}

	@Ignore
	@Test
	public void testSpringJDBCAnnotationConfigDelete() {
		Employee employee = (Employee) context.getBean("employee");
		employee.setId(5);
		employee.setFirstName("Sidhanth");
		System.out.println("Employee detial : " + employee);
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		employeeDAO.employeeDelete(employee);
	}

	@Ignore
	@Test
	public void testSpringJDBCAnnotationConfigSelect() {
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Employee employee = employeeDAO.employeeSelect(2);
		System.out.println("Employee detial : " + employee);
	}

	@Ignore
	@Test
	public void testSpringJDBCAnnotationConfigSelectList() {
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		List<Employee> employee = employeeDAO.employeeSelectList();
		System.out.println("Employee detial : " + employee);
	}
}

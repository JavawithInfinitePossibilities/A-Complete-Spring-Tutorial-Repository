/**
 * 
 */
package com.tutorials.sid.spring.xmljdbcconfig;

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
@ContextConfiguration(locations = { "classpath*:/xmljdbcconfig/Spring-Config.xml" })
public class TestSpringJDBC {

	@Autowired
	ApplicationContext context;

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigSave() {
		Employee employee = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee);
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		employeeDAO.employeeSave(employee);
		Employee employee2 = (Employee) context.getBean("employee");
		System.out.println("Employee detial : " + employee2);
		employeeDAO.employeeUsingPlaceholderSave(employee2);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigUpdate() {
		Employee employee = (Employee) context.getBean("employee");
		employee.setId(3);
		employee.setFirstName("Sidhanth");
		employee.setLastName("sahu");
		System.out.println("Employee detial : " + employee);
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		employeeDAO.employeeUpdate(employee);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigDelete() {
		Employee employee = (Employee) context.getBean("employee");
		employee.setId(8);
		System.out.println("Employee detial : " + employee);
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		employeeDAO.employeeDelete(employee);
	}

	@Ignore
	@Test
	public void testSpringJDBCXmlConfigSelect() {
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		Employee employee = employeeDAO.employeeSelect(3);
		System.out.println("Employee detial : " + employee);
	}

	@Test
	public void testSpringJDBCXmlConfigSelectList() {
		EmployeeDAO employeeDAO = (EmployeeDAO) context.getBean("employeeDAO");
		List<Employee> employee = employeeDAO.employeeSelectList();
		employee.stream().forEach(employeedetails -> System.out.println("Employee detial : " + employeedetails));
	}
}

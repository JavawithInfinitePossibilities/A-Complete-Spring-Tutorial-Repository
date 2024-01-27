/**
 * 
 */
package com.tutorials.sid.spring.controller.cntltoUI;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.sid.spring.module.dto.Employee;

/**
 * @author Lenovo
 *
 */
@Controller
public class ListController implements ApplicationContextAware {

	private List<Employee> employees;

	@RequestMapping("/ListController")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayList");
		System.out.println("Employees Details :" + employees);
		modelAndView.addObject("employees", employees);
		return modelAndView;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("this is application context override method");
		employees = Arrays.asList((Employee) applicationContext.getBean("employee"),
				(Employee) applicationContext.getBean("employee"), (Employee) applicationContext.getBean("employee"));
	}

}

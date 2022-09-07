/**
 * 
 */
package com.tutorials.sid.spring.controller.cntltoUI;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.sid.spring.module.dto.Employee;

/**
 * @author Lenovo
 *
 */
@Controller
public class ObjectController {

	@Autowired
	private Employee employee;

	@Autowired
	private ApplicationContext context;

	private BigInteger count = new BigInteger("0");

	@RequestMapping("/ObjectController")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayObject");
		if (count.intValue() == 1) {
			employee = (Employee) context.getBean("employee");
		} else {
			count = count.add(new BigInteger("1"));
		}
		System.out.println("Employee Details :" + employee);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

}

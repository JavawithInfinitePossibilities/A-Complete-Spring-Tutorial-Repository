/**
 * 
 */
package com.tutorials.sid.spring.controller.cntltoUI;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/ObjectController")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("displayObject");
		System.out.println("Employee Details :" + employee);
		modelAndView.addObject("employee", employee);
		return modelAndView;
	}

}

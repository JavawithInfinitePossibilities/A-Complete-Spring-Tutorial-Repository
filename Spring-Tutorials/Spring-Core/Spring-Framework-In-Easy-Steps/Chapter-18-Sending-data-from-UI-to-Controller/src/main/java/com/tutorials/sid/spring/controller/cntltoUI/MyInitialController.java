/**
 * 
 */
package com.tutorials.sid.spring.controller.cntltoUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lenovo
 *
 */
@Controller
public class MyInitialController {

	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello");

		modelAndView.addObject("id", 123);
		modelAndView.addObject("firstName", "Siddhant");
		modelAndView.addObject("lastName", "Sahu");
		return modelAndView;
	}
}

/**
 * 
 */
package com.tutorials.sid.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lenovo
 *
 */
@Controller("error")
public class ExceptionController {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex.getStackTrace());
		mav.addObject("url", req.getRequestURL());
		mav.setViewName("error");
		return mav;
	}
}

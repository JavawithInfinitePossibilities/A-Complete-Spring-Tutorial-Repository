/**
 * 
 */
package com.tutorials.sid.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tutorials.sid.spring.services.LoginServices;

/**
 * @author Lenovo
 *
 */
@Controller
@SessionAttributes({ "password", "name" })
public class LoginController {

	@Autowired
	LoginServices loginServices;

	/**
	 * http://localhost:8080/helloworld
	 * 
	 * @return
	 */
	@RequestMapping("/helloworld")
	public @ResponseBody String helloWorld() {
		return "Hello world";
	}

	/**
	 * http://localhost:8080/login
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	/**
	 * http://localhost:8080/index?name=Siddhant
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("/index")
	public String index(@RequestParam String name) {
		System.out.println("Name is : " + name);
		return "login";
	}

	/**
	 * http://localhost:8080/landingPage?name=Siddhant
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping("/landingPage")
	public String landingPage(@RequestParam String name, ModelMap model) {
		System.out.println("Name is : " + name);
		model.put("name", name);
		return "login";
	}

	/**
	 * http://localhost:8080/loginForm
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginFormGet(ModelMap model) {
		return "Loginform";
	}

	@RequestMapping(value = "/loginForm", method = RequestMethod.POST)
	public String loginFormPost(ModelMap model, @RequestParam String name, @RequestParam String password) {
		boolean validation = loginServices.getValidation(name, password);
		if (!validation) {
			model.put("errormessage", "invalid credential");
			return "Loginform";
		}
		model.put("name", name);
		model.put("password", password);
		return "login";
	}
}

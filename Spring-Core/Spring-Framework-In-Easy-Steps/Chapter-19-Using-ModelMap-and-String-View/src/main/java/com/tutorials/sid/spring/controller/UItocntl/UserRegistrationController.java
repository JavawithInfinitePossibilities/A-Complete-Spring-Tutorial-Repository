/**
 * 
 */
package com.tutorials.sid.spring.controller.UItocntl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.sid.spring.module.dto.User;

/**
 * @author Lenovo
 *
 */
@Controller
public class UserRegistrationController {

	@RequestMapping("/welcome")
	public String showRegistrationPage() {
		return "UserRegistration";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String userRegistrationPage(@ModelAttribute("user") User user, ModelMap map) {
		System.out.println(user);
		map.addAttribute("user", user);
		return "welcomeUser";
	}

	@RequestMapping(value = "/userEditRegistration")
	public String userEditRegistrationPage(@RequestParam(value = "userid", required = false) int id,
			@RequestParam(value = "username", required = false) String name,
			@RequestParam(value = "useremail", required = false) String email, ModelMap modelMap) {
		System.out.println("id=" + id + ", name=" + name + ", email=" + email);
		modelMap.addAttribute("username", name);
		return "welcomeConfirmUser";
	}
}

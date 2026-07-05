/**
 *
 */
package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.model.User;
import com.tutorials.sid.spring.repositories.UserRepositories;
import com.tutorials.sid.spring.websecurityconfig.ISecurityServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kunmu
 */
@Controller
public class UserController {

    @Autowired
    private ISecurityServices securityServices;

    @Autowired
    private UserRepositories userRepositories;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    /*
     * Root cause: Spring 6 (shipped with Spring Boot 3.x) dropped implicit method parameter name resolution
     * via reflection. Without the -parameters javac flag, Spring can't figure out that the first String
     * argument should be bound to the email form field.
     * */
    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        boolean loginResponse = securityServices.loginServices(email, password, httpServletRequest, httpServletResponse);
        if (loginResponse) {
            System.out.println("Login successfull!!!!");
            return "index";
        }
        System.out.println("Login Unsuccessfull!!!!");
        return "login";
    }

    @GetMapping("/showReg")
    public String showReg() {
        return "registerUser";
    }


    /*
    * When the form POSTs to /registerUser, Spring sees the User user parameter in the controller method
    * and uses its setters (setFirstName, setLastName, etc.) to populate the object automatically —
    * this is called @ModelAttribute binding, and it happens implicitly even without the annotation.
    * You can optionally make it explicit with @ModelAttribute:
    * public String registerUser(@ModelAttribute User user) { ... }
     * */
    @PostMapping("/registerUser")
    public String registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User saveUser = userRepositories.save(user);
        return "login";
    }
}

/**
 * 
 */
package com.tutorials.sid.spring.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorials.sid.spring.bean.User;
import com.tutorials.sid.spring.exception.UserNotFoundException;
import com.tutorials.sid.spring.services.UserDaoService;

/**
 * @author Lenovo <br/>
 *         URL : http://localhost:8080/users<br/>
 *         http://localhost:8080/users/1<br/>
 *         http://localhost:8080/users/ <br/>
 *         { "name": "Adam", "birthDate": "2022-07-23T09:18:27.265+00:00" }
 *
 */
@RestController
public class UsersController {

	@Autowired
	private UserDaoService service;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return service.findAll();
	}

	/**
	 * Refer the below link to understand the HATEOAS details.
	 * https://howtodoinjava.com/spring-boot2/rest/rest-with-spring-hateoas-example/
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/users/{usernameid}")
	public ResponseEntity<User> getAllUsersUsingPathVariable(@PathVariable("usernameid") int id) {
		User user = service.findOne(id);
		if (Objects.isNull(user)) {
			throw new UserNotFoundException("ID-" + id);
		}
		Link link = linkTo(UsersController.class).slash("users").slash(user.getId()).withRel("user-detail");
		user.add(link);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping("/users")
	public ResponseEntity<Object> saveUsers(@Valid @RequestBody User user) {
		User saveUser = service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(saveUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/users/{usernameid}")
	public ResponseEntity<Object> deleteUserUsingPathVariable(@PathVariable("usernameid") int id) {
		User deleteByIdUser = service.deleteById(id);
		if (Objects.isNull(deleteByIdUser)) {
			throw new UserNotFoundException("ID-" + id);
		}
		return ResponseEntity.noContent().build();
	}
}

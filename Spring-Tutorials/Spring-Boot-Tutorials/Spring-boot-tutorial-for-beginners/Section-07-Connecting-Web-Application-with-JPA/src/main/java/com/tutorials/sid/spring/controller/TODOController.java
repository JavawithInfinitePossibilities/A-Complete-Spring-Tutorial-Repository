/**
 * 
 */
package com.tutorials.sid.spring.controller;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tutorials.sid.spring.model.Todo;
import com.tutorials.sid.spring.services.TodoService;

/**
 * @author Lenovo
 *
 */
@Controller
@SessionAttributes({ "password", "name" })
public class TODOController {

	@Autowired
	TodoService todoService;

	@RequestMapping(value = "/list-todos", method = RequestMethod.GET)
	public String listTODOS(@RequestParam("name") String user, ModelMap model) {
		if (Objects.isNull(user)) {
			user = (String) model.get("name");
		}
		List<Todo> retrieveTodos = todoService.retrieveTodos(user);
		model.put("TODOList", retrieveTodos);
		return "List-TODOS";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTODOS(ModelMap model) {
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTODOS(@RequestParam("desc") String desc, ModelMap model) {
		System.out.println("description : " + desc + " user details : " + model.get("name"));
		todoService.addTodo((String) model.get("name"), desc, new Date(), false);
		return "redirect:/list-todos?name=" + (String) model.get("name");
	}

	@RequestMapping(value = "/delete-todo")
	public String deleteTODOS(@RequestParam("id") int id, ModelMap model) {
		if (id == 1) {
			throw new RuntimeException("This is a custom error !!!!");
		}
		todoService.deleteTodo(id);
		return "redirect:/list-todos?name=" + (String) model.get("name");
	}

	@RequestMapping(value = "/display-todo")
	public String displayTODOS(@RequestParam("id") int id, ModelMap model) {
		Todo todo = todoService.getTODOByID(id);
		model.addAttribute(todo);
		return "/Display-TODO";
	}

	@RequestMapping(value = "/update-list-todos")
	public String updateTODOS(@Valid Todo todo, ModelMap model, BindingResult result) {
		if (result.hasErrors()) {
			return "/update-list-todos";
		}
		todoService.addTodoObject(todo, (String) model.get("name"));
		return "redirect:/list-todos?name=" + (String) model.get("name");
	}
}

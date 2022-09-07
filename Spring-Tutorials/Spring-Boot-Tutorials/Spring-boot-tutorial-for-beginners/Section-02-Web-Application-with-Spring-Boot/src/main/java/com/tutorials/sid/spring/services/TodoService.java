/**
 * 
 */
package com.tutorials.sid.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tutorials.sid.spring.model.Todo;

/**
 * @author Lenovo
 *
 */
@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "Siddhant", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "Siddhant", "Learn Struts", new Date(), false));
		todos.add(new Todo(3, "Siddhant", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = todos.stream().filter(todo -> todo.getUser().equalsIgnoreCase(user))
				.collect(Collectors.toList());
		return filteredTodos;
	}

	public List<Todo> addTodoObject(Todo todoUpdate, String user) {
		/**
		 * I want to guarantee, however, that there is one and only one match to the
		 * filter criteria. Only one value should return. We can use the below code too
		 * to return the one value but it will return any.<br/>
		 * todos.stream().filter(todo -> todo.getId() ==
		 * todoUpdate.getId()).findAny().get();
		 */
		Todo todoRetrive = todos.stream().filter(todo -> todo.getId() == todoUpdate.getId())
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					if (list.size() != 1) {
						throw new IllegalStateException();
					}
					return list.get(0);
				}));
		List<Todo> filteredTodos = todos.stream().map(todo -> {
			if (todo.getId() == todoRetrive.getId()) {
				todo.setDesc(todoUpdate.getDesc());
			}
			return todo;
		}).collect(Collectors.toList());
		return filteredTodos;
	}

	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		Todo userValue = todos.stream().filter(todo -> todo.getId() == id)
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					if (list.size() != 1) {
						throw new IllegalStateException("More then one record found in the DB!!!");
					}
					return list.get(0);
				}));
		todos.remove(userValue);
	}

	public Todo getTODOByID(int id) {
		return todos.get(--id);
	}
}

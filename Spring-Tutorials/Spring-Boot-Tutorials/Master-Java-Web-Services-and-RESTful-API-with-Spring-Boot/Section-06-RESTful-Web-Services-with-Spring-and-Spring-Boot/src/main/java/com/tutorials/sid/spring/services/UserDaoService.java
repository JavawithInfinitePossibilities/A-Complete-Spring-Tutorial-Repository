package com.tutorials.sid.spring.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tutorials.sid.spring.bean.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usersCount = 3;

	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Jack", new Date()));
	}

	public List<User> findAll() {
		return users;
	}

	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}

	public User findOne(int id) {
		User userValue = users.stream().filter(user -> user.getId() == id)
				.collect(Collectors.collectingAndThen(Collectors.toList(), extractedZerothElement()));
		return !Objects.isNull(userValue) ? userValue : null;
	}

	public User deleteById(int id) {
		User userValue = users.stream().filter(user -> user.getId() == id)
				.collect(Collectors.collectingAndThen(Collectors.toList(), extractedZerothElement()));
		users.remove(userValue);
		return !Objects.isNull(userValue) ? userValue : null;
	}

	private Function<List<User>, User> extractedZerothElement() {
		return list -> {
			if (list.size() > 1) {
				throw new IllegalStateException("More then one record found in the DB!!!");
			}
			return list.size() == 0 ? null : list.get(0);
		};
	}
}
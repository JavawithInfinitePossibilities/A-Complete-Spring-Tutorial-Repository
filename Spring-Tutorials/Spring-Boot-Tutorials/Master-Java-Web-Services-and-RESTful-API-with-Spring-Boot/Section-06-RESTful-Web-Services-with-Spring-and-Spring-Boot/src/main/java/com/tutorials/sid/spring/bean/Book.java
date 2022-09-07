/**
 * 
 */
package com.tutorials.sid.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class Book {
	long id;
	String name;
	String author;

	public Book(@Value("${book.id}") long id, @Value("${book.name}") String name,
			@Value("${book.author}") String author) {
		super();
		System.out.println("The value for Book : " + id + " : " + name + " : " + author);
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, name=%s, author=%s]", id, name, author);
	}
}

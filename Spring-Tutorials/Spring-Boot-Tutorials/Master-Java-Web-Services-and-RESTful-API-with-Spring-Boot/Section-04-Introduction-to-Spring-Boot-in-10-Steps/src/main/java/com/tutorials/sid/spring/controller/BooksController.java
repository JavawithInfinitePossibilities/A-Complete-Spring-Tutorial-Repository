/**
 * 
 */
package com.tutorials.sid.spring.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.sid.spring.bean.Book;

/**
 * @author Lenovo <br/>
 *         URL : http://localhost:8080/books
 *
 */
@RestController
public class BooksController {
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1l, "Mastering Spring 5.0", "Ranga Karanam"));
	}
}

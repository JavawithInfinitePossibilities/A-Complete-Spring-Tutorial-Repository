/**
 * 
 */
package com.tutorials.sid.spring.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.tutorials.sid.spring.bean.Book;

/**
 * @author Lenovo <br/>
 *         URL : http://localhost:8080/books<br/>
 *         http://localhost:8080/books/Siddhant<br/>
 *         http://localhost:8080/helloworld<br/>
 *         http://localhost:8080/actuator/
 *
 */
@RestController
public class BooksController {

	@Autowired
	MessageSource source;

	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return Arrays.asList(new Book(1l, "Mastering Spring 5.0", "Ranga Karanam"));
	}

	@GetMapping("/books/{name}")
	public List<Book> getAllBooksUsingPathVariable(@PathVariable String name) {
		return Arrays.asList(new Book(1l, "Mastering Spring 5.0", name));
	}

	@GetMapping("/helloworld")
	public String getHelloWorldInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return source.getMessage("good.morning.message", null, locale);
	}

	@GetMapping("/helloworld-internationalization")
	public String getHelloWorldinternationalization() {
		return source.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}

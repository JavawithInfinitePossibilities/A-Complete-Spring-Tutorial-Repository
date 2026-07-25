package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.model.Book;
import com.tutorials.sid.spring.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author kunmu On 25-07-2026
 */
@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/")
    public String listBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/book/new")
    public String showCreateForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    @PostMapping("/books")
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }
}

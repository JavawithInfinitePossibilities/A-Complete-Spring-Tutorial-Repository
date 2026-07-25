package com.tutorials.sid.spring.controller;

import com.tutorials.sid.spring.repos.BookRepository;
import com.tutorials.sid.spring.repos.BorrowingRepository;
import com.tutorials.sid.spring.repos.MemberRepository;
import com.tutorials.sid.spring.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kunmu On 25-07-2026
 */
@Controller
public class BorrowingController {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BorrowingRepository borrowingRepository;

    @Autowired
    BorrowingService borrowingService;

    @GetMapping("/borrow")
    public String showBorrowForm(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("members", memberRepository.findAll());
        return "borrow_book";
    }

    @PostMapping("/borrow")
    public String borrowBook(@RequestParam("memberId") Long memberId, @RequestParam("bookId") Long bookId, Model model) {
        borrowingService.borrowBook(bookId, memberId);
        model.addAttribute("message", "Book Borrowed Successfully!");
        return "borrow_success";
    }

    @GetMapping("/return")
    public String showReturnForm(Model model) {
        model.addAttribute("borrowers",borrowingRepository.findByReturnDate(null));
        return "return_book";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("borrowingId") Long borrowingId, Model model) {
        borrowingService.returnBook(borrowingId);
        model.addAttribute("message", "Book Returned Successfully!");
        return "return_success";
    }
}

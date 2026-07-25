package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.model.Borrowing;
import com.tutorials.sid.spring.repos.BookRepository;
import com.tutorials.sid.spring.repos.BorrowingRepository;
import com.tutorials.sid.spring.repos.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author kunmu On 25-07-2026
 */
@Service
public class BorrowingServiceImpl implements BorrowingService{
    @Autowired
    BookRepository bookRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BorrowingRepository borrowingRepository;

    @Override
    public Borrowing borrowBook(Long bookId, Long memberId) {
        Borrowing borrowing = new Borrowing();
        borrowing.setBook(bookRepository.findById(bookId).get());
        borrowing.setMember(memberRepository.findById(memberId).get());
        borrowing.setBorrowedDate(new Date());
        return borrowingRepository.save(borrowing);
    }

    @Override
    public Borrowing returnBook(Long borrowingId) {
        Borrowing borrowing = borrowingRepository.findById(borrowingId).get();
        borrowing.setReturnDate(new Date());
        return borrowingRepository.save(borrowing);
    }
}

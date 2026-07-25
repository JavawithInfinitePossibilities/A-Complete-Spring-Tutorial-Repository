package com.tutorials.sid.spring.services;

import com.tutorials.sid.spring.model.Borrowing;

/**
 * @author kunmu On 25-07-2026
 */
public interface BorrowingService {
    Borrowing borrowBook(Long bookId, Long memberId);
    Borrowing returnBook(Long borrowingId);
}

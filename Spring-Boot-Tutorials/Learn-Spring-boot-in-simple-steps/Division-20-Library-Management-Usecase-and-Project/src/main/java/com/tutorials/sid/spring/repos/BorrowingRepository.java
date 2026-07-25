package com.tutorials.sid.spring.repos;

import com.tutorials.sid.spring.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author kunmu On 25-07-2026
 */
@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
    List<Borrowing> findByReturnDate(Date date);
}

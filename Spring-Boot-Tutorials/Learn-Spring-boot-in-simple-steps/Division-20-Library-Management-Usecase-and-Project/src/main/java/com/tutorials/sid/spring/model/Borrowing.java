package com.tutorials.sid.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * @author kunmu On 25-07-2026
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="book_id",referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name="member_id",referencedColumnName = "id")
    private Member member;
    private Date borrowedDate;
    private Date returnDate;
}

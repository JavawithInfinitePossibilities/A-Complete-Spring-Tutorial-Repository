package com.tutorials.sid.spring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import lombok.*;
import org.springframework.stereotype.Component;


/**
 * @author kunmu On 02-07-2026
 */
@Component
@NoArgsConstructor
@Data
@Entity
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_seq")
    @SequenceGenerator(name = "course_seq", sequenceName = "course_seq", allocationSize = 1)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;

    public Course(String name, String author) {
        this.name = name;
        this.author = author;
    }
}

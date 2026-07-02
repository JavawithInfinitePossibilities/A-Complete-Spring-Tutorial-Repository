package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kunmu On 02-07-2026
 * 1.   difference between session and session factory in hibernate
 *      In Hibernate, the primary difference is that SessionFactory is a heavyweight,
 *      thread-safe global factory used to generate session instances,
 *      while a Session is a lightweight, non-thread-safe object that represents a short-lived database conversation
 *
 * 2.   difference between hibernate and jpa
 *      Hibernate is a specific ORM framework that implements the JPA specification,
 *      providing additional features and capabilities beyond the standard JPA API.
 *      JPA is a specification that defines a set of APIs and interfaces for accessing and manipulating data in a relational database.
 *
 * 3.   difference between hibernate and spring data jpa
 *      Spring Data JPA is a module of the Spring Data project that provides a simplified way to access and manipulate data
 *      in a relational database using JPA.Hibernate is a specific implementation of JPA that provides additional features
 *      and capabilities beyond the standard JPA API.
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

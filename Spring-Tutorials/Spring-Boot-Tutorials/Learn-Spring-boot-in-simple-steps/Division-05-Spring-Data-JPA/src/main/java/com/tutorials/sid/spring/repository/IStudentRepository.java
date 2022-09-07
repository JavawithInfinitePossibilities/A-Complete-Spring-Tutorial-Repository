/**
 * 
 */
package com.tutorials.sid.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorials.sid.spring.entities.StudentDB;

/**
 * @author Lenovo
 *
 */
public interface IStudentRepository extends JpaRepository<StudentDB, Long> {

}

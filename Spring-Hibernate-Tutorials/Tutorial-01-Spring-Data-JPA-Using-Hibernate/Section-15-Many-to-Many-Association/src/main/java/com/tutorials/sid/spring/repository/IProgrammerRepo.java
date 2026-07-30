/**
 * 
 */
package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.Programmer;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IProgrammerRepo extends CrudRepository<Programmer, Integer> {

}

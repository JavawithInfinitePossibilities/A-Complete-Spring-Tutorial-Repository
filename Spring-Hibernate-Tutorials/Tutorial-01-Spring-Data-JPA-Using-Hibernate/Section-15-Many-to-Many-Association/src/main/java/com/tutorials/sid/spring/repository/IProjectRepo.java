/**
 * 
 */
package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.Project;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IProjectRepo extends CrudRepository<Project, Integer> {

}

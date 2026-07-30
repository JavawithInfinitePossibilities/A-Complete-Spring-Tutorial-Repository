/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IEmployeeRepo extends CrudRepository<Employee, Integer> {

}

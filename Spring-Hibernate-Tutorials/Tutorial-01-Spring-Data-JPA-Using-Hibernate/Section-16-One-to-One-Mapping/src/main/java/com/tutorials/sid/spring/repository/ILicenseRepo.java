/**
 * 
 */
package com.tutorials.sid.spring.repository;

import com.tutorials.sid.spring.entity.License;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface ILicenseRepo extends CrudRepository<License, Integer> {

}

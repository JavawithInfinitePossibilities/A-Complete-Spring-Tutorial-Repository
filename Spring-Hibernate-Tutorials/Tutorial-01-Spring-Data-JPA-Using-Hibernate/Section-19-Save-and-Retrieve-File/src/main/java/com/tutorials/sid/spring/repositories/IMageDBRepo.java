/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.entity.Image;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Lenovo
 *
 */
public interface IMageDBRepo extends CrudRepository<Image, Integer> {

}

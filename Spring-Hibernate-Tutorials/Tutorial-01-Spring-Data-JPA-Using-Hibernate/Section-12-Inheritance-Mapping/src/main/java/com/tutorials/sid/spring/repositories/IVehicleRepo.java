/**
 * 
 */
package com.tutorials.sid.spring.repositories;

import com.tutorials.sid.spring.model.db.Vehicle;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kunmu
 *
 */
public interface IVehicleRepo extends CrudRepository<Vehicle, Integer> {

}

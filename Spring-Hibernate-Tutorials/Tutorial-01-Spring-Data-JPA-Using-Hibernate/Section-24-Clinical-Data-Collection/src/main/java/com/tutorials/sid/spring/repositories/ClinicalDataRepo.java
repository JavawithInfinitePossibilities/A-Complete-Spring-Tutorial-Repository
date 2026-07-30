/**
 * 
 */
package com.tutorials.sid.spring.repositories;


import com.tutorials.sid.spring.model.db.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lenovo
 *
 */
public interface ClinicalDataRepo extends JpaRepository<ClinicalData, Integer> {

}

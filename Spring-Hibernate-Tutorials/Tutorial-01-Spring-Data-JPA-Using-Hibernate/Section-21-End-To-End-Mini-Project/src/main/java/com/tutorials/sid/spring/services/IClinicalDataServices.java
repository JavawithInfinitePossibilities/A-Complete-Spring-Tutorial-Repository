/**
 * 
 */
package com.tutorials.sid.spring.services;


import com.tutorials.sid.spring.model.db.ClinicalData;

/**
 * @author Lenovo
 *
 */
public interface IClinicalDataServices {
	public ClinicalData save(ClinicalData clinicalData);

	public ClinicalData get(int ClinicalDataId);

	public ClinicalData update(ClinicalData clinicalData);
}

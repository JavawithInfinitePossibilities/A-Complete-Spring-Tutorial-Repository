/**
 * 
 */
package com.tutorials.sid.spring.services.impl;


import com.tutorials.sid.spring.model.db.ClinicalData;
import com.tutorials.sid.spring.repositories.ClinicalDataRepo;
import com.tutorials.sid.spring.services.IClinicalDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 *
 */
@Service
public class ClinicalDataServiceImpl implements IClinicalDataServices {

	@Autowired
	private ClinicalDataRepo clinicalDataRepo;

	@Override
	public ClinicalData save(ClinicalData clinicalData) {
		return null;
	}

	@Override
	public ClinicalData get(int ClinicalDataId) {
		return null;
	}

	@Override
	public ClinicalData update(ClinicalData clinicalData) {
		return null;
	}

}

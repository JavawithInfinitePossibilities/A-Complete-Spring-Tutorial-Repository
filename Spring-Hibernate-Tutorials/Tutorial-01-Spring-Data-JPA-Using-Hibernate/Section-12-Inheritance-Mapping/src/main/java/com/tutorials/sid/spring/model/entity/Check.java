/**
 * 
 */
package com.tutorials.sid.spring.model.entity;


import com.tutorials.sid.spring.model.db.Payment;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue(value = "CH")
public class Check extends Payment {

	private String checkNumber;

	/**
	 * @param id
	 * @param amount
	 * @param checkNumber
	 */
	@Builder
	public Check(double amount, String checkNumber) {
		super(amount);
		this.checkNumber = checkNumber;
	}
}

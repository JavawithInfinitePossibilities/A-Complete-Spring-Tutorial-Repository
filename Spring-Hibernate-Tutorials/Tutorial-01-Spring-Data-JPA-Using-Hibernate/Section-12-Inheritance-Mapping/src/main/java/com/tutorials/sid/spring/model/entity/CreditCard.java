/**
 * 
 */
package com.tutorials.sid.spring.model.entity;

import com.tutorials.sid.spring.model.db.Payment;
import jakarta.persistence.Column;
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
@DiscriminatorValue(value = "CC")
public class CreditCard extends Payment {

	@Column(name = "credit_card_number")
	private String creditCardNumber;

	/**
	 * @param id
	 * @param amount
	 * @param creditCardNumber
	 */
	@Builder
	public CreditCard(double amount, String creditCardNumber) {
		super(amount);
		this.creditCardNumber = creditCardNumber;
	}

}

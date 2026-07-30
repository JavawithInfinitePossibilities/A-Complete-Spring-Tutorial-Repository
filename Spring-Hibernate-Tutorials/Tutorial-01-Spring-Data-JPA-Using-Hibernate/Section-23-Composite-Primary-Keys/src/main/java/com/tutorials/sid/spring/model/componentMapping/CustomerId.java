/**
 * 
 */
package com.tutorials.sid.spring.model.componentMapping;

import jakarta.persistence.Embeddable;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author kunmu
 *
 */
@Data
@NoArgsConstructor
@Embeddable
public class CustomerId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;

	/**
	 * @param id
	 * @param email
	 */
	@Builder
	public CustomerId(int id, String email) {
		super();
		this.id = id;
		this.email = email;
	}
}

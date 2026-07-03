/**
 * 
 */
package com.tutorials.sid.spring.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Coupon implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private String code;
	private BigDecimal discount;
	private String exp_date;
}

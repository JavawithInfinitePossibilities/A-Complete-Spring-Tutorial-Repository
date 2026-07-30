/**
 * 
 */
package com.tutorials.sid.spring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lenovo
 *
 */
@Getter
@Setter
@ToString(exclude = "driver")
@NoArgsConstructor
@Entity
public class License implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	@Temporal(TemporalType.DATE)
	private Date validFrom;
	@Temporal(TemporalType.DATE)
	private Date validTo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driverId")
	private Driver driver;

	/**
	 * @param type
	 * @param validFrom
	 * @param validTo
	 * @param driver
	 */
	@Builder
	public License(String type, Date validFrom, Date validTo) {
		super();
		this.type = type;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

}

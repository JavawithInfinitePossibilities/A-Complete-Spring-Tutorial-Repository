package com.tutorials.sid.spring.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Coupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "coupon_code")
	private String code;
	@Column(name = "coupon_discount")
	private BigDecimal discount;
	@Column(name = "coupon_expiry_date")
	private String expDate;
}

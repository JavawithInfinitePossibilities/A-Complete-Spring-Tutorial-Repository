package com.tutorials.sid.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/*
* 1. GenerationType.AUTO (default)
* Hibernate picks the strategy automatically based on the database dialect.
* On MySQL → uses TABLE or SEQUENCE depending on version
* On PostgreSQL → uses SEQUENCE
* On H2 → uses SEQUENCE
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
Problem: Behavior is unpredictable across databases.
* It often creates a shared sequence table (hibernate_sequence)
* which can cause the StaleObjectStateException you saw earlier —
* because IDs from your mock data clash with Hibernate's sequence
* counter.
* */

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Car")
public class CarEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "make_description")
	private String make;
	private String model;
	private String color;
	private Integer year;
	private Double price;
}

/*
* 2. GenerationType.IDENTITY
* Delegates ID generation to the database column (e.g., AUTO_INCREMENT in MySQL, SERIAL in PostgreSQL).
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
* Database generates the ID on INSERT
* Hibernate reads it back after insert
* Downside: Hibernate cannot batch inserts efficiently because it needs the ID immediately after each insert
* Best for: MySQL, SQL Server, most relational DBs with auto-increment support.
* */

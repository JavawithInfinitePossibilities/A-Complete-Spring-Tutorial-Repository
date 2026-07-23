/**
 * 
 */
package com.tutorials.sid.spring.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Lenovo
 *
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086093312799147636L;
	private long id;
	private String name;
	private int score;
}


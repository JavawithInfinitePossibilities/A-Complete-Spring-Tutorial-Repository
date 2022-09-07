/**
 * 
 */
package com.tutorials.sid.spring.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lenovo
 *
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9086093312799147636L;
	private long id;
	private String name;
	private int score;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}

}

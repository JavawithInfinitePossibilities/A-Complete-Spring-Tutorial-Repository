/**
 * 
 */
package com.tutorials.sid.spring.model;

import java.util.Date;

import org.springframework.stereotype.Component;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lenovo
 *
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Todo {
	private int id;
	private String user;
	@Size(min = 10, message = "Enter at least 10 Characters...")
	private String desc;
	private Date targetDate;
	private boolean isDone;

	@Override
	public String toString() {
		return String.format("Todo [id=%s, user=%s, desc=%s, targetDate=%s, isDone=%s]", id, user, desc, targetDate,
				isDone);
	}

}
/**
 * 
 */
package com.tutorials.sid.spring.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Lenovo
 *
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "programmers")
@EqualsAndHashCode(exclude = "programmers")
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pjid;
	private String name;

	@ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
	private List<Programmer> programmers;

	/**
	 * @param name
	 * @param programmers
	 */
	@Builder
	public Project(String name) {
		super();
		this.name = name;
	}

	public void addProgrammer(Programmer programmer) {
		if (programmer != null) {
			if (programmers == null) {
				programmers = new ArrayList<Programmer>();
			}
			programmers.add(programmer);
		}
	}

}

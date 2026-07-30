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
@ToString(exclude = "projects")
@EqualsAndHashCode(exclude = "projects")
@Entity
public class Programmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pgrmid;
    private String name;
    private int salary;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "programmer_project", joinColumns = @JoinColumn(referencedColumnName = "pgrmid"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "pjid"))
    private List<Project> projects;

    /**
     * @param name
     * @param salary
     * @param projects
     */
    @Builder
    public Programmer(String name, int salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public void addProject(Project project) {
        if (project != null) {
            if (projects == null) {
                projects = new ArrayList<Project>();
            }
            projects.add(project);
        }
    }

}

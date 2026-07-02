package com.tutorials.sid.spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author kunmu On 02-07-2026
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class Course {
    private int id;
    private String name;
    private String description;
}

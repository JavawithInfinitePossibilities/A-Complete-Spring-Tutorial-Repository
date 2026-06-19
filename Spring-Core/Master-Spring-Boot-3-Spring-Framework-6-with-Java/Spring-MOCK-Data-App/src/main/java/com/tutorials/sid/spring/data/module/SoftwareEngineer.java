package com.tutorials.sid.spring.data.module;

import lombok.Builder;
import lombok.Data;

/**
 * @author kunmu On 22-04-2026
 */
@Data
@Builder
public class SoftwareEngineer {
    private String name;
    private int age;
    private boolean isHavingGf;

    /**
     * @param name
     * @param age
     * @param isHavingGf
     */
    public SoftwareEngineer(String name, int age, boolean isHavingGf) {
        super();
        this.name = name;
        this.age = age;
        this.isHavingGf = isHavingGf;
    }
}

package com.tutorials.sid.spring;


import com.tutorials.sid.spring.entity.Programmer;
import com.tutorials.sid.spring.entity.Project;
import com.tutorials.sid.spring.repository.IProgrammerRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple Section15ManytoManyAssociation.
 */
@SpringBootTest(classes = Section15ManytoManyAssociation.class)
public class Section15ManytoManyAssociationTest {

    @Autowired
    private IProgrammerRepo iProgrammer;

    @Test
    public void testApp() {
    }

    @Test
    public void testMtoMProgrammerProjectNumber() {
        Programmer programmer = Programmer.builder().name("sid sahu").salary(1000).build();
        Project project = Project.builder().name("IMOS-1").build();
        Project project2 = Project.builder().name("ETD-1").build();
        programmer.addProject(project);
        programmer.addProject(project2);
        iProgrammer.save(programmer);
    }

    @Disabled
    @Test
    @Transactional
    public void testMtoMSelectProgrammerProjectNumber() throws InterruptedException {
        Programmer programmerSelect = iProgrammer.findById(2).get();
        assertEquals(programmerSelect.getName(), "sid sahu");
        System.out.println("----------------------------------");
        Thread.sleep(1000);
        System.out.println(programmerSelect.getProjects());
    }

}

package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unit test for simple Section02SoftwareSetup.
 * URL: https://spring.io/projects/spring-data-jpa
 * https://docs.spring.io/spring-boot/how-to/properties-and-configuration.html
 * https://docs.spring.io/spring-boot/appendix/application-properties/index.html
 */
@SpringBootTest(classes = Section02SoftwareSetup.class)
public class Section02SoftwareSetupTest {

    @Test
    public void testApp() {
        System.out.println("Hello World!");
    }
}

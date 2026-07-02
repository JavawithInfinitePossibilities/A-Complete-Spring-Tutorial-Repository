package com.tutorials.sid.spring;

import com.tutorials.sid.spring.data.DummyDataTable;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kunmu On 02-07-2026
 */
@SpringBootTest(classes = App.class)
class AppTest {

    @Test
    void contextLoads() {
        System.out.println("Hello World!");
    }

    @Test
    public void displayData() {
        DummyDataTable.getEmployees().forEach(System.out::println);
    }
}
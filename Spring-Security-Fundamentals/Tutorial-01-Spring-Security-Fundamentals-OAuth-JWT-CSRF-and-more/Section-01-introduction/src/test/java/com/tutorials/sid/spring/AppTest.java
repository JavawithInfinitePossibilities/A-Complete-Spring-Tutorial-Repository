package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kunmu On 04-07-2026
 */
@SpringBootTest( classes = App.class)
class AppTest {

    @Test
    void test() {
        System.out.println("Hello World");
    }

}
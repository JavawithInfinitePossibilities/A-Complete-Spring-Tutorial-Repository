package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest( classes = Section07CSRF.class)
class Section07CSRFTest {

    @Test
    void test() {
        System.out.println("Hello World");
    }

}

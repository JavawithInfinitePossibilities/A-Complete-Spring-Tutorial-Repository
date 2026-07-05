package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest( classes = App.class)
class AppTest {

    @Test
    void test() {
        System.out.println("Hello World");
    }

}


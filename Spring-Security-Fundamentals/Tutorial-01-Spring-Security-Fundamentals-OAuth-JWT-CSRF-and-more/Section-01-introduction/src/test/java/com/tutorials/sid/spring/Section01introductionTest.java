package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author kunmu On 04-07-2026
 */
@SpringBootTest( classes = Section01introduction.class)
class Section01introductionTest {

    @Test
    void test() {
        System.out.println("Hello World");
    }

}
package com.tutorials.sid.spring;

import com.tutorials.sid.spring.data.DummyDataTable;
import com.tutorials.sid.spring.game.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App using JUnit 5.
 */
@DisplayName("App Tests")
@SpringBootTest(classes = App.class)
public class AppTest {

    @Autowired
    private ApplicationContext context;

    @Test
    @DisplayName("Should pass a simple test")
    public void testAppHasAGreeting() {
        GameingConsole marioGame = (GameingConsole) context.getBean("marioGame", MarioGame.class);
        System.out.println(marioGame);
        GameingConsole marioGame1 = (GameingConsole) context.getBean("marioGame", MarioGame.class);
        System.out.println(marioGame1);
        marioGame.up();
        marioGame.down();
        marioGame.left();
        marioGame.right();

        GameingConsole pacManGame = context.getBean("pacManGame", PacManGame.class);
        System.out.println(pacManGame);
        GameingConsole pacManGame1 = context.getBean("pacManGame", PacManGame.class);
        System.out.println(pacManGame1);
        pacManGame.up();
        pacManGame.down();
        pacManGame.left();
        pacManGame.right();

        GameingConsole superContraGame = context.getBean("superContraGame", SuperContraGame.class);
        System.out.println(superContraGame);
        GameingConsole superContraGame1 = context.getBean("superContraGame", SuperContraGame.class);
        System.out.println(superContraGame1);
        superContraGame.up();
        superContraGame.down();
        superContraGame.left();
        superContraGame.right();


        /*Autowired by name*/
        GameRunner gameRunner = context.getBean("marioGameRunner", GameRunner.class);
        gameRunner.run();

        /*Autowired by type*/
        GameRunner superContraGameRunner = context.getBean("superContraGameRunner", GameRunner.class);
        superContraGameRunner.run();

        /*Autowired by Primary*/
        GameRunner pacManGameRunner = context.getBean("pacManGameRunner", GameRunner.class);
        pacManGameRunner.run();
    }

    @Test
    public void displayData() {
        DummyDataTable.getEmployees().forEach(System.out::println);
    }
}

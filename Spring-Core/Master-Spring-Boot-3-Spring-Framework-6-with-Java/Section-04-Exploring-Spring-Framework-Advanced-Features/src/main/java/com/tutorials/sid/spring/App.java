package com.tutorials.sid.spring;

import com.tutorials.sid.spring.config.SpringContainerConfig;
import com.tutorials.sid.spring.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringContainerConfig.class);) {
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
    }
}

package com.tutorials.sid.spring;

import com.tutorials.sid.spring.config.SpringContainerConfig;
import com.tutorials.sid.spring.game.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kunmu On 01-07-2026
 */
public class AppSpringFrameworkDependencyExmpl {
    /*
     * 1.    Start a Spring container
     * 2.    define the bean which is managed by Spring container
     * 3.    inject the bean into the class
     * */
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringContainerConfig.class);) {
            GameingConsole marioGame = context.getBean("marioGame", MarioGame.class);
            System.out.println(marioGame);
            marioGame.up();
            marioGame.down();
            marioGame.left();
            marioGame.right();

            GameingConsole pacManGame = context.getBean("pacManGame", PacManGame.class);
            System.out.println(pacManGame);
            pacManGame.up();
            pacManGame.down();
            pacManGame.left();
            pacManGame.right();

            GameingConsole superContraGame = context.getBean("superContraGame", SuperContraGame.class);
            System.out.println(superContraGame);
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

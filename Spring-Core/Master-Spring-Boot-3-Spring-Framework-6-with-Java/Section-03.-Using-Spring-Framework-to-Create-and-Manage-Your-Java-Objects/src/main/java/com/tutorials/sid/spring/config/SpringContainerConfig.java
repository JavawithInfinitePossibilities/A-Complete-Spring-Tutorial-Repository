package com.tutorials.sid.spring.config;

import com.tutorials.sid.spring.game.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kunmu On 01-07-2026
 */
@Configuration
@ComponentScan("com.tutorials.sid.spring")
public class SpringContainerConfig {

    /*This is called field injection*/
    /*@Autowired
    @Qualifier("marioGame")*/
    private GameingConsole marioGame;

    /*This is called field injection*/
    /*@Autowired*/
    private SuperContraGame superContraGame;

    /*This is called field injection*/
    /*@Autowired*/
    private GameingConsole pacManGame;

    /*This is called setter injection*/
    /*@Autowired
    @Qualifier("marioGame")
    public void setMarioGame(GameingConsole marioGame) {
        System.out.println("MarioGame is injected");
        this.marioGame = marioGame;
    }

    @Autowired
    public void setSuperContraGame(SuperContraGame superContraGame) {
        System.out.println("SuperContraGame is injected");
        this.superContraGame = superContraGame;
    }

    @Autowired
    public void setPacManGame(GameingConsole pacManGame) {
        System.out.println("PacManGame is injected");
        this.pacManGame = pacManGame;
    }*/

    /*This is called constructor injection*/
    @Autowired
    public SpringContainerConfig(@Qualifier("marioGame")GameingConsole marioGame, SuperContraGame superContraGame, GameingConsole pacManGame) {
        System.out.println("Constructor is called for SpringContainerConfig");
        this.marioGame = marioGame;
        this.superContraGame = superContraGame;
        this.pacManGame = pacManGame;
    }

    /*This is the way to inject the bean by name*/
    @Bean
    public GameRunner marioGameRunner() {
        return new GameRunner(marioGame);
    }

    /*This is the way to inject the bean by type*/
    @Bean
    public GameRunner superContraGameRunner() {
        return new GameRunner(superContraGame);
    }

    /*This is the way to inject the bean by Primary*/
    @Bean
    public GameRunner pacManGameRunner() {
        return new GameRunner(pacManGame);
    }
}

package com.tutorials.sid.spring.config;

import com.tutorials.sid.spring.game.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author kunmu On 01-07-2026
 */
@Configuration
public class SpringContainerConfig {

    @Bean
    public GameingConsole marioGame() {
        return new MarioGame();
    }

    @Bean
    @Primary
    public GameingConsole pacManGame() {
        return new PacManGame();
    }

    @Bean
    public GameingConsole superContraGame() {
        return new SuperContraGame();
    }

    /*This is the way to inject the bean by name*/
    @Bean
    public GameRunner marioGameRunner(@Qualifier("marioGame") GameingConsole gameingConsole) {
        return new GameRunner(gameingConsole);
    }

    /*This is the way to inject the bean by type*/
    @Bean
    public GameRunner superContraGameRunner(SuperContraGame superContraGame) {
        return new GameRunner(superContraGame);
    }

    /*This is the way to inject the bean by Primary*/
    @Bean
    public GameRunner pacManGameRunner(GameingConsole pacManGame) {
        return new GameRunner(pacManGame);
    }
}

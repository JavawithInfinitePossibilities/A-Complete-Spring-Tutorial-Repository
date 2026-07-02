package com.tutorials.sid.spring.config;

import com.tutorials.sid.spring.game.GameRunner;
import com.tutorials.sid.spring.game.GameingConsole;
import com.tutorials.sid.spring.game.SuperContraGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author kunmu On 01-07-2026
 */
@Configuration
public class SpringContainerConfig {

    /*This is called field injection*/
    @Autowired
    @Qualifier("marioGame")
    private GameingConsole marioGame;

    /*This is called field injection*/
    @Autowired
    private SuperContraGame superContraGame;

    /*This is called field injection*/
    @Autowired
    private GameingConsole pacManGame;

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

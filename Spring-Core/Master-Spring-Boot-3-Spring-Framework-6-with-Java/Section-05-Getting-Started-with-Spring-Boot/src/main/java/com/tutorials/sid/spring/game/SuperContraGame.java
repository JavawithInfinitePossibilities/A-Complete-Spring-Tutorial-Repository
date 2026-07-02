package com.tutorials.sid.spring.game;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author kunmu On 01-07-2026
 * SCOPE_PROTOTYPE: It means that a new instance of the bean is created for each request.
 * SCOPE_SINGLETON: It means that only one instance of the bean is created and it is shared across all the requests.
 * It is the default scope.
 */
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SuperContraGame implements GameingConsole {

    public void up() {
        System.out.println("Super Contra is jumping");
    }

    public void down() {
        System.out.println("Super Contra is going down");
    }

    public void left() {
        System.out.println("Super Contra is going left");
    }

    public void right() {
        System.out.println("Super Contra is going right");
    }
}

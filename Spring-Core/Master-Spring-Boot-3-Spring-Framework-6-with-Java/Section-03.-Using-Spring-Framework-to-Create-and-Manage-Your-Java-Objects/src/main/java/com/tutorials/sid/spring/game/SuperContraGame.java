package com.tutorials.sid.spring.game;

import org.springframework.stereotype.Component;

/**
 * @author kunmu On 01-07-2026
 */
@Component
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

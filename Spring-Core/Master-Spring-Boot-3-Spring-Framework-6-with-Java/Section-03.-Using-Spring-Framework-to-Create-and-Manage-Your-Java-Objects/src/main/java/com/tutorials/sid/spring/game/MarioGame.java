package com.tutorials.sid.spring.game;

import org.springframework.stereotype.Component;

/**
 * @author kunmu On 01-07-2026
 */
@Component("marioGame")
public class MarioGame implements GameingConsole {
    public void up() {
        System.out.println("Mario is jumping");
    }

    public void down() {
        System.out.println("Mario is going down");
    }

    public void left() {
        System.out.println("Mario is going left");
    }

    public void right() {
        System.out.println("Mario is going right");
    }
}

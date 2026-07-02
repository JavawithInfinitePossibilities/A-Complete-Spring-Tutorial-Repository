package com.tutorials.sid.spring.game;

/**
 * @author kunmu On 01-07-2026
 */
public class PacManGame implements GameingConsole {
    @Override
    public void up() {
        System.out.println("PacMan is jumping");
    }

    @Override
    public void down() {
        System.out.println("PacMan is going down");
    }

    @Override
    public void left() {
        System.out.println("PacMan is going left");
    }

    @Override
    public void right() {
        System.out.println("PacMan is going right");
    }
}

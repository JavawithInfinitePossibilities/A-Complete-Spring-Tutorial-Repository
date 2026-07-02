package com.tutorials.sid.spring.game;

/**
 * @author kunmu On 01-07-2026
 */
public class GameRunner {

    private GameingConsole gameingConsole;

    public GameRunner(GameingConsole gameingConsole) {
        this.gameingConsole = gameingConsole;
    }

    public void run() {
        System.out.println("Game is running");
        gameingConsole.up();
        gameingConsole.down();
        gameingConsole.left();
        gameingConsole.right();
    }
}

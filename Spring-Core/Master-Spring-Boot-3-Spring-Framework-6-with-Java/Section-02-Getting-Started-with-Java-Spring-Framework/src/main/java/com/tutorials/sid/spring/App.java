package com.tutorials.sid.spring;

import com.tutorials.sid.spring.game.*;

/**
 *  Hello world!
 *  This is the main class of the application having tightly coupling.
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*private MarioGame game = new MarioGame();
        private SuperContraGame game = new SuperContraGame();*/

        GameingConsole marioGame=new MarioGame();
        GameingConsole superContraGame=new SuperContraGame();
        GameingConsole pacManGame=new PacManGame();

        /*GameRunner gameRunner=new GameRunner(game);
        GameRunner gameRunner=new GameRunner(marioGame);
        GameRunner gameRunner=new GameRunner(superContraGame);*/
        GameRunner gameRunner=new GameRunner(pacManGame);
        gameRunner.run();
    }
}

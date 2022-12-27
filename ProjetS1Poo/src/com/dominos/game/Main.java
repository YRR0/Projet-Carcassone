package com.dominos.game;

import com.dominos.game.controller.GameController;

public class Main {
    public static void main(String[] args) {
        new GameController(2).start();
    }
}
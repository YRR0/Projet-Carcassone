package com.dominos.game;

import com.dominos.game.controller.GameController;
import com.dominos.game.controller.TerminalController;
import com.dominos.game.view.JTuile;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        new GameController(2).start();
        //new MyFrame();
    }
}
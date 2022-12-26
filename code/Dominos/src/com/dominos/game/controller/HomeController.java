package com.dominos.game.controller;

import com.dominos.game.view.GameView;
import com.dominos.game.view.HomeView;

public class HomeController {
    private HomeView homeView;

    public HomeController() {
        homeView = new HomeView();
        homeView.setVisible(true);
        homeView.play.addActionListener(e -> {
            String nbJoueurs = homeView.input.getText();
            try {
                int nombresJoueurs = Integer.parseInt(nbJoueurs);
                GameController gameController = new GameController(nombresJoueurs,0);
                homeView.dispose();
                gameController.start();
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                System.out.println("Nombre de joueurs: " + nbJoueurs);
            }
        });
    }
}

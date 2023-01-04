package poo.menu;

import poo.dominos.game.controller.GameController;

import javax.swing.*;

public class HomeController extends JFrame {

    private HomeView homeView;
    private poo.carcassone.game.controller.GameController gc;

    public HomeController() {
        homeView = new HomeView();
        
        homeView.dominosBtn.addActionListener(e -> {
            GameController gameController = new GameController(homeView.getNbJoueursDominos(),homeView.getNbJoueursADominos());
            this.dispose();
            gameController.start();
        });
        homeView.carcassoneBtn.addActionListener(e -> {
            poo.carcassone.game.controller.GameController gameController = new poo.carcassone.game.controller.GameController(homeView.getNbJoueursCarcassone(), homeView.getNbJoueursACarcassone());
            this.dispose();
            System.out.println(gameController);
            gc = gameController;
            gameController.start();
        });
        homeView.loadDominos.addActionListener(e -> {
            poo.dominos.game.controller.GameController gameController = poo.dominos.game.controller.GameController.load();
            this.dispose();
            gameController.setVisible(true);
            gameController.start();
        });
        homeView.loadCarcassone.addActionListener(e -> {
            poo.carcassone.game.controller.GameController gameController = poo.carcassone.game.controller.GameController.load();
            this.dispose();
            gameController.setVisible(true);
            gameController.start();
        });
        add(homeView);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(HomeView.WIDTH, HomeView.HEIGHT);
        setVisible(true);
    }
}

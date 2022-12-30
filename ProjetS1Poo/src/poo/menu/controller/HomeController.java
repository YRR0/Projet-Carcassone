package poo.menu.controller;

import poo.dominos.game.controller.GameController;
import poo.menu.view.HomeView;

import javax.swing.*;

public class HomeController extends JFrame {

    private HomeView homeView;

    public HomeController() {
        homeView = new HomeView();
        homeView.getDominosBtn().addActionListener(e -> {
            GameController gameController = new GameController(homeView.getNbJoueursDominos(),homeView.getNbJoueursADominos());
            this.dispose();
            gameController.start();
        });
        homeView.getCarcassoneBtn().addActionListener(e -> {
            poo.carcassone.game.controller.GameController gameController = new poo.carcassone.game.controller.GameController(homeView.getNbJoueursCarcassone());
            this.dispose();
            gameController.start();
        });
        add(homeView);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(HomeView.WIDTH, HomeView.HEIGHT);
        setVisible(true);
    }
}

package poo.carcassone.game.controller;

import poo.carcassone.game.components.Partisan;
import poo.carcassone.game.components.Plateau;
import poo.carcassone.game.components.Sac;
import poo.carcassone.game.components.tuiles.Tuile;
import poo.carcassone.game.player.Joueur;
import poo.carcassone.game.view.GameView;
import poo.carcassone.game.view.JPartisan;
import poo.carcassone.game.view.JPlateau;
import poo.carcassone.game.view.JTuile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameController extends JFrame implements MouseMotionListener, MouseListener, Serializable {
    private final GameView gameView;
    private Plateau plateau;
    private Sac sac;
    private ArrayList<Joueur> joueurs;
    private Joueur courant;
    private boolean tuileMouvable, partisanMouvable;
    public GameController(int nbJoueurs) {
        gameView = new GameView(nbJoueurs);
        initGame();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(gameView);
        setSize(GameView.WIDTH, GameView.HEIGHT);
        setLocationRelativeTo(null);
        addMouseMotionListener(this);
        addMouseListener(this);
        setVisible(true);
    }
    private void initGame() {
        sac = new Sac();
        plateau = new Plateau(GameView.NB_LIGNE, GameView.NB_COLS);
        joueurs = new ArrayList<>(List.of(gameView.getJoueurs()));
        courant = joueurs.get(0);
        Tuile initiale = sac.retirer();
        plateau.ajouter(initiale, plateau.nbLin() / 2 - 1, plateau.nbCol() / 2 - 1);
        gameView.setPlateau(plateau);
        gameView.setCurrentPlayer(courant.nom, courant.getNbPoints());
        gameView.setPartisan(new Partisan(courant.getCouleur()));
    }

    public void start() {
        gameView.enable_piocher(true);
        gameView.piocher_addActionListener(e -> {
            gameView.enable_piocher(false);
            tuileMouvable = true;
            gameView.setTuile(courant.piocher(sac));
            enableControll();
            if(sac.estVide()) {
                gameView.sacVide();
            }
            repaint();
        });
        gameView.turnLeft_addListener(e -> {
            Tuile t = gameView.getJTuile().getTuile();
            courant.tourner(t, 3);
            gameView.setTuile(t);
            repaint();
        });
        gameView.turnRight_addListener(e -> {
            Tuile t = gameView.getJTuile().getTuile();
            courant.tourner(t, 1);
            gameView.setTuile(t);
            repaint();
        });
        gameView.abandonner_addActionListener(e -> {
            int indexCourant = nextPlayer();
            joueurs.remove(indexCourant);
            clearTuile();
            resetTuilePosition();
            repaint();
            if(joueurs.size() == 1) {
                winner();
            }
        });
        gameView.passerTour_addActionListener(e -> {
            nextPlayer();
            clearTuile();
            resetTuilePosition();
            repaint();
        });
        addSaveListener();
    }

    private void addSaveListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                save();
            }
        });

    }

    private boolean isInTuile(MouseEvent mouseEvent) {
        JTuile jTuile = gameView.getJTuile();
        boolean isInWidthBounds = (mouseEvent.getX() - getInsets().left >= jTuile.getX())
                && (mouseEvent.getX() - getInsets().left <= jTuile.getX() + jTuile.getWidth());
        boolean isInHeightBounds= (mouseEvent.getY() - getInsets().top >= jTuile.getY())
                && (mouseEvent.getY() - getInsets().top <= jTuile.getY() + jTuile.getHeight());

        return isInHeightBounds && isInWidthBounds;
    }

    private boolean isInPartisan(MouseEvent mouseEvent) {
        JPartisan jPartisan = gameView.getjPartisan();
        boolean isInWidthBounds = (mouseEvent.getX() - getInsets().left >= jPartisan.getX())
                && (mouseEvent.getX() - getInsets().left <= jPartisan.getX() + jPartisan.getWidth());
        boolean isInHeightBounds= (mouseEvent.getY() - getInsets().top >= jPartisan.getY())
                && (mouseEvent.getY() - getInsets().top <= jPartisan.getY() + jPartisan.getHeight());

        return isInHeightBounds && isInWidthBounds;
    }

    private boolean isInPlateau(MouseEvent mouseEvent) {
        JPlateau jPlateau = gameView.getPlateau();

        boolean isInWidthBounds = (mouseEvent.getX() - getInsets().left >= jPlateau.getX())
                && (mouseEvent.getX() - getInsets().left <= jPlateau.getX() + jPlateau.getWidth());
        boolean isInHeightBounds= (mouseEvent.getY() - getInsets().top >= jPlateau.getY())
                && (mouseEvent.getY() - getInsets().top <= jPlateau.getY() + jPlateau.getHeight());

        return isInWidthBounds && isInHeightBounds;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        /*Point current_point = mouseEvent.getPoint();
        int newX = (int) (current_point.getX() - getInsets().left);
        int newY = (int) (current_point.getY() - getInsets().top);
        if(tuileMouvable) {
            gameView.getJTuile().setLocation(newX, newY);
        } else if(partisanMouvable) {
            gameView.getjPartisan().setLocation(newX, newY);
            System.out.println(gameView.getjPartisan().getX() + " " + gameView.getjPartisan().getY());
        }*/
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    private Point getCoordinate(MouseEvent event) {
        int plateauX = gameView.getPlateau().getX(), plateauY = gameView.getPlateau().getY();
        int tuileWidth = gameView.getJTuile().getWidth() + 5, tuileHeight = gameView.getJTuile().getHeight() + 5; // 5 c'est l'espace entre les tuiles
        int y = (event.getX() - plateauX - getInsets().left) / tuileWidth;
        int x = (event.getY() - plateauY - getInsets().top) / tuileHeight;
        return new Point(x, y);
    }

    private int getCote(MouseEvent event) {
        int plateauX = gameView.getPlateau().getX(), plateauY = gameView.getPlateau().getY();
        int tuileWidth = gameView.getJTuile().getWidth() + 5, tuileHeight = gameView.getJTuile().getHeight() + 5; // 5 c'est l'espace entre les tuiles
        int y = (event.getX() - plateauX - getInsets().left) % tuileWidth;
        int x = (event.getY() - plateauY - getInsets().top) % tuileHeight;
        if(y > 50) return 2;
        if(x > 50) return 3;
        if(x < 25) return 1;
        if(y < 25) return 0;
        return 4; // Poser le partisan au milieu
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(isInPlateau(mouseEvent)) {
            if(tuileMouvable) {
                Point coordinates = getCoordinate(mouseEvent);
                Tuile t = gameView.getJTuile().getTuile();
                int lin = (int) coordinates.getX(), col = (int) coordinates.getY();
                System.out.println(lin + " " + col);
                if(t.corresponds(plateau, lin, col)) {
                    courant.poser(plateau, t, lin, col);
                    gameView.setPlateau(plateau);
                    boolean c0 = plateau.getTuile(lin, col-1) == null, c1 = plateau.getTuile(lin-1, col) == null,
                            c2 = plateau.getTuile(lin, col+1) == null, c3 = plateau.getTuile(lin+1, col) == null;
                    int nbPoints = 10;
                    courant.gangerPoints(nbPoints);
                    gameView.setCurrentPlayer(courant.nom, courant.getNbPoints());
                    gameView.updatePlayerInfo(joueurs.indexOf(courant), courant.getNbPoints());
                    partisanMouvable = true;
                    tuileMouvable = false;
                    clearTuile();
                    disableControll();
                    gameView.enable_piocher(false);
                    if(sac.estVide()) {
                        winner();
                    }
                }
            } else if(partisanMouvable) {
                Point coordinates = getCoordinate(mouseEvent);
                int lin = (int) coordinates.getX(), col = (int) coordinates.getY();
                if(courant.poserPartisans(plateau, lin, col, getCote(mouseEvent))) {
                    gameView.setPlateau(plateau);
                    nextPlayer();
                } else {
                    resetPartisanPosition();
                }
            }

        } else {
            resetTuilePosition();
            resetPartisanPosition();
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    /**
     *
     * @return the index of the current player
     */
    private int nextPlayer() {
        int indexCourant = joueurs.indexOf(courant);
        courant = joueurs.get((indexCourant+1) % joueurs.size());
        clearTuile();
        resetTuilePosition();
        gameView.setCurrentPlayer(courant.nom, courant.getNbPoints());
        gameView.setPartisan(new Partisan(courant.getCouleur()));
        return indexCourant;
    }

    private void clearTuile() {
        gameView.setTuile(null);
        disableControll();
        gameView.enable_piocher(true);
    }

    private void resetTuilePosition() {
        gameView.getJTuile().setLocation((int) (0.5 * getWidth() + getInsets().left), (int) (0.8 * getHeight() + getInsets().top));
    }

    private void resetPartisanPosition() {
        gameView.getjPartisan().setLocation((int) (0.7 * getWidth() + getInsets().left), (int) (0.8 * getHeight() + getInsets().top));
    }

    private void enableControll() {
        gameView.enableControll(true);
    }
    private void disableControll() {
        gameView.enableControll(false);
    }

    private void winner() {
        JPanel winnerPanel = new JPanel();
        winnerPanel.setLayout(new FlowLayout());
        Joueur winner = getWinner();
        JLabel winnerText = new JLabel(winner + " a gagné");
        winnerText.setFont(new Font("Serif", Font.BOLD, 75));
        JButton quitter = new JButton("Quitter");
        quitter.addActionListener(e -> System.exit(0));
        winnerPanel.add(winnerText);
        winnerPanel.add(quitter);
        this.remove(gameView);
        this.add(winnerPanel);
    }

    private Joueur getWinner() {
        Joueur res = joueurs.get(0);
        for(Joueur joueur : joueurs) {
            if(joueur.getNbPoints() > res.getNbPoints()) res = joueur;
        }
        return res;
    }

    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("saveCarcassone.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Object info saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameController load() {
        GameController res = null;
        try {
            FileInputStream fileIn = new FileInputStream("saveCarcassone.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            res = (GameController) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

}

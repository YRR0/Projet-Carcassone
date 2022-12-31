package poo.dominos.game.controller;

import poo.dominos.game.components.Plateau;
import poo.dominos.game.components.Sac;
import poo.dominos.game.components.Tuile;
import poo.dominos.game.player.Joueur;
import poo.dominos.game.player.JoueurArtificiel;
import poo.dominos.game.view.GameView;
import poo.dominos.game.view.JPlateau;
import poo.dominos.game.view.JTuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController extends JFrame implements MouseMotionListener, MouseListener, Serializable {

    private final GameView gameView;
    private Plateau plateau;
    private Sac sac;
    private ArrayList<Joueur> joueurs;
    private Joueur courant;
    private boolean tuileMouvable;
    public GameController(int nbJoueurs, int nbJoueursA) {
        gameView = new GameView(nbJoueurs, nbJoueursA);
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
        sac = new Sac(20);
        while (!sac.estPlein()) {
            Tuile t = new Tuile();
            sac.ajouterTuile(t);
        }
        plateau = new Plateau(GameView.NB_LIGNES, GameView.NB_COLS);
        joueurs = new ArrayList<>(List.of(gameView.getJoueurs()));
        courant = joueurs.get(0);
    }

    public void start() {
        Tuile initiale = sac.retirer();
        plateau.ajouter(initiale, plateau.nbLin() / 2 - 1, plateau.nbCol() / 2 - 1);
        gameView.setPlateau(plateau);
        gameView.setCurrentPlayer(courant.nom, courant.getNbPoints());
        gameView.enable_piocher(true);
        if(courant instanceof JoueurArtificiel) {
            aiPlayer();
        }
        gameView.piocher_addActionListener(e -> {
            gameView.enable_piocher(false);
            gameView.setjTuile(courant.piocher(sac));
            enableControll();
            if(sac.estVide()) {
                gameView.sacVide();
            }
            repaint();
        });
        gameView.turnLeft_addListener(e -> {
            Tuile t = gameView.getJTuile().getTuile();
            courant.tourner(t, 3);
            gameView.setjTuile(t);
            repaint();
        });
        gameView.turnRight_addListener(e -> {
            Tuile t = gameView.getJTuile().getTuile();
            courant.tourner(t, 1);
            gameView.setjTuile(t);
            repaint();
        });
        gameView.abandonner_addActionListener(e -> {
            courant.abandonner();
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
    }

    private boolean isInTuile(MouseEvent mouseEvent) {
        JTuile jTuile = gameView.getJTuile();
        boolean isInWidthBounds = (mouseEvent.getX() - getInsets().left >= jTuile.getX())
                                    && (mouseEvent.getX() - getInsets().left <= jTuile.getX() + jTuile.getWidth());
        boolean isInHeightBounds= (mouseEvent.getY() - getInsets().top >= jTuile.getY())
                                    && (mouseEvent.getY() - getInsets().top <= jTuile.getY() + jTuile.getHeight());

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
        if(tuileMouvable) {
            Point current_point = mouseEvent.getPoint();
            int newX = (int) (current_point.getX() - getInsets().left);
            int newY = (int) (current_point.getY() - getInsets().top);
            gameView.getJTuile().setLocation(newX, newY);
            repaint();
        }
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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (isInTuile(mouseEvent)) {
            tuileMouvable = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(isInPlateau(mouseEvent)) {
            Point coordinates = getCoordinate(mouseEvent);
            Tuile t = gameView.getJTuile().getTuile();
            int lin = (int) coordinates.getX(), col = (int) coordinates.getY();
            if(t != null && t.corresponds(plateau, lin, col)) {
                plateau.ajouter(t, lin, col);
                gameView.setPlateau(plateau);
                boolean c0 = plateau.getTuile(lin, col-1) == null, c1 = plateau.getTuile(lin-1, col) == null,
                        c2 = plateau.getTuile(lin, col+1) == null, c3 = plateau.getTuile(lin+1, col) == null;
                int nbPoints = t.nbPoints(c0, c1, c2, c3);
                courant.gangerPoints(nbPoints);
                gameView.setCurrentPlayer(courant.nom, courant.getNbPoints());
                gameView.updatePlayerInfo(joueurs.indexOf(courant), courant.getNbPoints());
                nextPlayer();
                if(sac.estVide()) {
                    winner();
                }
            }
        } else {
            resetTuilePosition();
        }
        repaint();
        tuileMouvable = false;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    private void aiPlayer() {
        Tuile t = courant.piocher(sac);
        gameView.setjTuile(t);
        JoueurArtificiel j = (JoueurArtificiel) courant;
        if(j.coupPossible(plateau, t)) {
            courant.tourner(t, j.getNbTours());
            gameView.setjTuile(t);
            int lin = j.getLigne(), col = j.getCol();
            courant.poser(plateau, t, lin, col);
            boolean c0 = plateau.getTuile(lin, col-1) == null, c1 = plateau.getTuile(lin-1, col) == null,
                    c2 = plateau.getTuile(lin, col+1) == null, c3 = plateau.getTuile(lin+1, col) == null;
            int nbPoints = t.nbPoints(c0, c1, c2, c3);
            courant.gangerPoints(nbPoints);
            gameView.setCurrentPlayer(courant.nom, courant.getNbPoints());
            gameView.updatePlayerInfo(joueurs.indexOf(courant), courant.getNbPoints());
            gameView.setPlateau(plateau);
        } else {
            System.out.println("impossible");
        }
        repaint();
        if(sac.estVide()) {
            winner();
        }
        nextPlayer();
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
        if(courant instanceof JoueurArtificiel) aiPlayer();
        return indexCourant;
    }

    private void clearTuile() {
        gameView.setjTuile(null);
        disableControll();
        gameView.enable_piocher(true);
    }

    private void resetTuilePosition() {
        gameView.getJTuile().setLocation((int) (0.5 * getWidth() + getInsets().left), (int) (0.8 * getHeight() + getInsets().top));
    }

    private void enableControll() {
        gameView.enableControll(true);
    }
    private void disableControll() {
        gameView.enableControll(false);
    }

    private void winner() {
        JPanel winnerPanel = new JPanel();
        winnerPanel.setBackground(Color.gray);
        winnerPanel.setLayout(new FlowLayout());
        Joueur winner = getWinner();
        JLabel winnerText = new JLabel(winner + " a gagné");
        winnerText.setFont(new Font("Serif", Font.BOLD, 75));

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(getClass().getResource("/images/quitter.png").toURI()));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        JButton quitter = new JButton("Quitter");
        quitter = new JButton(new ImageIcon(image));
        quitter.setBackground(new Color(0, 0, 0));
        quitter.setOpaque(false);
        quitter.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        quitter.addActionListener(e -> System.exit(0));
        winnerPanel.add(winnerText);
        winnerPanel.add(quitter);
        this.remove(gameView);
        this.add(winnerPanel);

        this.setVisible(true);

    }

    private Joueur getWinner() {
        Joueur res = joueurs.get(0);
        for(Joueur joueur : joueurs) {
            if(joueur.getNbPoints() > res.getNbPoints()) res = joueur;
        }
        return res;
    }
}

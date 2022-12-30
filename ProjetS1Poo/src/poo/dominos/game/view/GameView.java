package poo.dominos.game.view;

import poo.dominos.game.components.Plateau;
import poo.dominos.game.components.Tuile;
import poo.dominos.game.player.Joueur;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class GameView extends JPanel {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH  = (int) screenSize.getWidth();
    public static final int HEIGHT = (int) screenSize.getHeight();
    public static final int NB_LIGNES = (int) ((0.8 * HEIGHT) / (5 * (JTuile.RECT_HEIGHT + 1)));

    public static final int NB_COLS = (int) ((0.8 * WIDTH) / (5 * (JTuile.RECT_WIDTH + 1)));
    private JPlateau plateau;
    private JGameInfo gameInfo;
    private JTuile jTuile;
    private JButton abandonner, passerTour, turnLeft, turnRight, piocher;


    public GameView(int nbJoueurs) {
        initComponents(nbJoueurs);

        setSize(WIDTH, HEIGHT);
        setLayout(null);
        add(plateau);
        add(gameInfo);
        add(jTuile);
        add(abandonner);
        add(passerTour);
        add(turnLeft);
        add(turnRight);
        add(piocher);
        reposition();
        setBackground(Color.DARK_GRAY);
    }

    private void initComponents(int nbJoueurs) {
        plateau = new JPlateau(NB_LIGNES, NB_COLS);
        gameInfo = new JGameInfo(nbJoueurs);
        jTuile = new JTuile();
        jTuile.setTuile(null);
        BufferedImage imagePioche = null, imageG = null , imageD = null , imageAbandonner = null,imagePasser=null;
        try {
            imagePioche = ImageIO.read(new File(getClass().getResource("/images/dominos.jpg").toURI()));
            imageG = ImageIO.read(new File(getClass().getResource("/images/g.png").toURI()));
            imageD = ImageIO.read(new File(getClass().getResource("/images/d.png").toURI()));
            imageAbandonner = ImageIO.read(new File(getClass().getResource("/images/abandonner.png").toURI()));
            imagePasser = ImageIO.read(new File(getClass().getResource("/images/passer.png").toURI()));
        } catch (IOException e) {
            System.out.println("Erreur dans le chargement initComponents de GameView ");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        piocher = new JButton(new ImageIcon(imagePioche));
        abandonner = new JButton(new ImageIcon(imageAbandonner));
        passerTour = new JButton(new ImageIcon(imagePasser));
        turnLeft = new JButton(new ImageIcon(imageG));
        turnRight = new JButton(new ImageIcon(imageD));
        personnaliseButton();
        enableControll(false);
    }

    public void personnaliseButton() {
        abandonner.setBackground(new Color(255, 255, 255)); abandonner.setOpaque(false); abandonner.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        passerTour.setBackground(new Color(255, 255, 255)); passerTour.setOpaque(false); passerTour.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        turnLeft.setBackground(new Color(255, 255, 255)); turnLeft.setOpaque(false); turnLeft.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        turnRight.setBackground(new Color(255, 255, 255)); turnRight.setOpaque(false); turnRight.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
    }


    private void reposition() {
        gameInfo.setLocation(0,0);
        gameInfo.setSize(new Dimension((int) (0.2 * getWidth()), (int) (0.8 * getHeight())));
        plateau.setLocation((int) (0.2 * getWidth()), 0);
        plateau.setSize((int) (0.8 * getWidth()), (int) (0.8 * getHeight()));
        jTuile.setLocation((int) (0.5 * getWidth()), (int) (0.8 * getHeight()));
        piocher.setSize(JTuile.TUILE_WIDTH, JTuile.TUILE_HEIGHT);
        piocher.setLocation(getWidth() - JTuile.TUILE_WIDTH - 10, (int) (0.8 * getHeight()));
        turnLeft.setSize(getWidth() / 10, getHeight()/12);
        turnLeft.setLocation((getWidth() / 2) - JTuile.TUILE_WIDTH - (getWidth() / 10), (int) (0.8 * getHeight()));
        turnRight.setSize(getWidth() / 10, getHeight()/12);
        turnRight.setLocation(getWidth() / 2 + 2 * JTuile.TUILE_WIDTH, (int) (0.8 * getHeight()));
        abandonner.setSize(getWidth() / 10, getHeight() / 19);
        abandonner.setLocation(60, (int) (0.8 * getHeight()));
        passerTour.setSize(getWidth() / 10, getHeight() / 19);
        passerTour.setLocation(58 , (int) (0.8 * getHeight()) + getHeight() / 24 + 10);
    }

    public Joueur[] getJoueurs() {
        return gameInfo.getJoueurs();
    }

    public JPlateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau.setPlateau(plateau);
    }

    public void setCurrentPlayer(String name, int score) {
        gameInfo.setPlayerInfo(name, score);
    }

    public void updatePlayerInfo(int i, int score) {
        gameInfo.setGameInfo(i, score);
    }

    public void setjTuile(Tuile t) {
        jTuile.setTuile(t);
    }
    public void turnLeft_addListener(ActionListener actionListener) {
        turnLeft.addActionListener(actionListener);
    }

    public void enableControll(boolean enabled) {
        turnRight.setEnabled(enabled);
        turnLeft.setEnabled(enabled);
        abandonner.setEnabled(enabled);
        passerTour.setEnabled(enabled);
    }

    public void enable_piocher(boolean enabled) {
        piocher.setEnabled(enabled);
    }

    public void turnRight_addListener(ActionListener actionListener) {
        turnRight.addActionListener(actionListener);
    }

    public void abandonner_addActionListener(ActionListener actionListener) {
        abandonner.addActionListener(actionListener);
    }

    public void passerTour_addActionListener(ActionListener actionListener) {
        passerTour.addActionListener(actionListener);
    }

    public void piocher_addActionListener(ActionListener actionListener) {
        piocher.addActionListener(actionListener);
    }

    public JTuile getJTuile() {
        return jTuile;
    }

    public void sacVide() {
        piocher.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/Dominos/empty.png"))));
    }

}

package poo.carcassone.game.view;

import poo.carcassone.game.components.Partisan;
import poo.carcassone.game.components.Plateau;
import poo.carcassone.game.components.tuiles.Tuile;
import poo.carcassone.game.player.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class GameView extends JPanel {
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) screenSize.getWidth();
    public static final int HEIGHT = (int) screenSize.getHeight();
    public static final int NB_LIGNE = (int) ((0.8 * HEIGHT) / (JTuile.TUILE_WIDTH + 5));

    public static final int NB_COLS = (int) ((0.8 * WIDTH) / (JTuile.TUILE_HEIGHT + 5));
    private JPlateau plateau;
    private JGameInfo gameInfo;
    private JTuile jTuile;
    private JPartisan jPartisan;
    private JButton abandonner;
    private JButton passerTour;
    private JButton turnLeft;
    private JButton turnRight;
    private JButton piocher;

    public GameView(int nbJoueurs, int nbJoueursA) {
        initComponents(nbJoueurs, nbJoueursA);

        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setBackground(new Color(165, 85, 236));
        add(plateau);
        add(gameInfo);
        add(jTuile);
        add(jPartisan);
        add(abandonner);
        add(passerTour);
        add(turnLeft);
        add(turnRight);
        add(piocher);
        reposition();
    }

    private void initComponents(int nbJoueurs, int nbJoueursA) {
        plateau = new JPlateau(NB_LIGNE, NB_COLS);
        gameInfo = new JGameInfo(nbJoueurs, nbJoueursA);
        jTuile = new JTuile();
        jPartisan = new JPartisan();
        abandonner = new JButton("Abandonner");
        passerTour = new JButton("Passer mon tour");
        turnLeft = new JButton("<-");
        turnRight = new JButton("->");
        piocher = new JButton(new ImageIcon("ProjetS1Poo/src/Resources/images/Dominos/dominos.jpg"));
        enableControll(false);
    }

    private void reposition() {
        gameInfo.setLocation(0, 0);
        gameInfo.setSize(new Dimension((int) (0.2 * getWidth()), (int) (0.8 * getHeight())));
        plateau.setLocation((int) (0.2 * getWidth()), 0);
        plateau.setSize((int) (0.8 * getWidth()), (int) (0.8 * getHeight()));
        jTuile.setLocation((int) (0.5 * getWidth()), (int) (0.8 * getHeight()));
        jPartisan.setLocation((int) (0.7 * getWidth()), (int) (0.8 * getHeight()));
        piocher.setSize(poo.dominos.game.view.JTuile.TUILE_WIDTH, poo.dominos.game.view.JTuile.TUILE_HEIGHT);
        piocher.setLocation(getWidth() - poo.dominos.game.view.JTuile.TUILE_WIDTH - 10, (int) (0.8 * getHeight()));
        turnLeft.setSize(getWidth() / 10, getHeight() / 12);
        turnLeft.setLocation((getWidth() / 2) - poo.dominos.game.view.JTuile.TUILE_WIDTH - (getWidth() / 10),
                (int) (0.8 * getHeight()));
        turnRight.setSize(getWidth() / 10, getHeight() / 12);
        turnRight.setLocation(getWidth() / 2 + 2 * poo.dominos.game.view.JTuile.TUILE_WIDTH, (int) (0.8 * getHeight()));
        abandonner.setSize(getWidth() / 10, getHeight() / 24);
        abandonner.setLocation(0, (int) (0.8 * getHeight()));
        passerTour.setSize(getWidth() / 10, getHeight() / 24);
        passerTour.setLocation(0, (int) (0.8 * getHeight()) + getHeight() / 24 + 10);
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

    public void setTuile(Tuile t) {
        jTuile.setTuile(t);
    }

    public void setPartisan(Partisan p) {
        jPartisan.setPartisan(p);
    }

    public void turnLeft_addListener(ActionListener actionListener) {
        turnLeft.addActionListener(actionListener);
    }

    public void enableControll(boolean enabled) {
        turnRight.setEnabled(enabled);
        turnLeft.setEnabled(enabled);
        abandonner.setEnabled(enabled);
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

    public JPartisan getjPartisan() {
        return jPartisan;
    }

    public void sacVide() {
        piocher.setIcon(new ImageIcon("ProjetS1Poo/src/Resources/images/Dominos/empty.png"));
    }
}

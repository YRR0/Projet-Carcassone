package poo.carcassone.game.view;

import poo.carcassone.game.components.Partisan;
import poo.carcassone.game.components.tuiles.Tuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class JTuile extends JPanel {

    private Tuile tuile;
    public static final int TUILE_HEIGHT = 75;
    public static final int TUILE_WIDTH = 75;

    public JTuile() {
        initTuile();
        repaint();
    }

    private void initTuile() {
        setSize(TUILE_WIDTH, TUILE_HEIGHT);
        tuile = null;
    }

    public Tuile getTuile() {
        return tuile;
    }

    public void setTuile(Tuile t) {
        tuile = t;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = null, partisanImg = null;
        String tuileDescription = "";
        try {
            if(tuile == null) {
                image =ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/Carcassone/back.jpg")));
                g.drawImage(image, 0, 0, TUILE_WIDTH, TUILE_HEIGHT, null);
            } else  {
                tuileDescription = tuile.toString();
                image =ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/Carcassone/Tuiles/" + tuileDescription + ".png")));
                g.drawImage(image, 0, 0, TUILE_WIDTH, TUILE_HEIGHT, null);
                if(tuile.getPartisan() != null) {
                    partisanImg = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/Carcassone/Partisans/" + tuile.getPartisan().getCouleur() + ".png")));
                    Point partisanPos = getPartisanPosition();
                    g.drawImage(partisanImg, (int) partisanPos.getX(), (int) partisanPos.getY(), JPartisan.PARTISAN_WIDTH, JPartisan.PARTISAN_HEIGHT, this);
                }
            }
        } catch (Exception e) {
            System.err.println("Error while loading image of tuile");
            System.out.println(tuileDescription);
        }
    }

    private Point getPartisanPosition() {
        System.out.println(tuile.getCotePartisan());
        return switch (tuile.getCotePartisan()) {
            case 0 -> new Point(0, 35);
            case 1 -> new Point(35, 0);
            case 2 -> new Point(60, 35);
            case 3 -> new Point(35, 60);
            default -> new Point(37, 37);
        };
    }

    @Override
    public int getWidth() {
        return TUILE_WIDTH;
    }

    @Override
    public int getHeight() {
        return TUILE_HEIGHT;
    }
}

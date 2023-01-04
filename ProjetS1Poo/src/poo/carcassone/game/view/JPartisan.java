package poo.carcassone.game.view;

import poo.carcassone.game.components.Partisan;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class JPartisan extends JPanel {

    private Partisan partisan;
    public static final int PARTISAN_WIDTH  = 10;
    public static final int PARTISAN_HEIGHT = 10;

    public JPartisan() {
        setSize(PARTISAN_WIDTH, PARTISAN_HEIGHT);
        partisan = null;
        repaint();
    }

    public Partisan getPartisan() {
        return new Partisan(partisan.getCouleur());
    }

    public void setPartisan(Partisan p) {
        partisan = p;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = null;
        try {
            if(partisan != null) {
                image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/Carcassone/Partisans/" + partisan.getCouleur() + ".png")));
                g.drawImage(image, 0, 0, PARTISAN_WIDTH, PARTISAN_HEIGHT, null);
            }
        } catch (Exception e) {
            System.err.println("Error while loading image of partisan");
            System.err.println("/images/Carcassone/Partisans/" + partisan.getCouleur() + ".png");
        }
    }

    @Override
    public int getWidth() {
        return PARTISAN_WIDTH;
    }

    @Override
    public int getHeight() {
        return PARTISAN_HEIGHT;
    }
}

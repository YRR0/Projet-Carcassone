package com.carcassone.game.view;

import com.carcassone.game.components.tuiles.Tuile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
        Graphics2D graphics2D = (Graphics2D) g;
        Image image = null;
        String tuileDescription = "";
        try {
            if(tuile == null) {
                image =ImageIO.read(getClass().getResource("/images/Carcassone/back.jpg"));
            } else  {
                tuileDescription = tuile.toString();
                image =ImageIO.read(getClass().getResource("/images/Carcassone/Tuiles/" + tuileDescription + ".png"));
            }
        } catch (Exception e) {
            System.err.println("Error while loading back image of tuile");
            System.out.println(tuileDescription);
            //throw new RuntimeException(e);
        }
        g.drawImage(image, 0, 0, TUILE_WIDTH, TUILE_HEIGHT, null);
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

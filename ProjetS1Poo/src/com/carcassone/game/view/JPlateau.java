package com.carcassone.game.view;


import com.carcassone.game.components.Plateau;

import javax.swing.*;
import java.awt.*;

public class JPlateau extends JPanel {
    private JPanel plateauContainer;
    private JTuile[][] tuiles;
    private Plateau plateau;
    private static final int GAP = 5;
    private int x, y; // indices de la tuile suivante sur le plateau la toute premiéres étant 0 0

    public JPlateau(int nbLins, int nbCols) {
        plateauContainer = new JPanel(new GridLayout(nbLins, nbCols));
        initTuiles(nbLins, nbCols);
        setLayout(new BorderLayout());
        add(plateauContainer, BorderLayout.CENTER);
    }

    private void initTuiles(int lins, int cols) {
        tuiles = new JTuile[lins][cols];
        for(int i = 0; i < lins; i++) {
            for(int j = 0; j < cols; j++) {
                tuiles[i][j] = new JTuile();
                plateauContainer.add(tuiles[i][j]);
            }
        }
    }

    public void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, (JTuile.TUILE_WIDTH + GAP) * tuiles[0].length, (JTuile.TUILE_HEIGHT + GAP) * tuiles.length);
        for(int i = 0; i < tuiles.length; i++) {
            for(int j = 0; j < tuiles[0].length; j++) {
                x = (JTuile.TUILE_WIDTH + GAP) * j;
                y = (JTuile.TUILE_HEIGHT + GAP) * i;
                if(plateau != null) {
                    tuiles[i][j].setTuile(plateau.getTuile(i, j));
                }
                tuiles[i][j].paint(g);
                g.setColor(getBackground());
                g.fillRect(0, 0, JTuile.TUILE_WIDTH, JTuile.TUILE_HEIGHT);
                tuiles[i][j].setLocation(x, y);
            }
        }
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
        repaint();
    }

    @Override
    public int getWidth() {
        return (JTuile.TUILE_WIDTH + GAP) * tuiles[0].length;
    }

    @Override
    public int getHeight() {
        return (JTuile.TUILE_HEIGHT + GAP) * tuiles.length;
    }
}

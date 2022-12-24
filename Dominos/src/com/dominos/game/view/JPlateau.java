package com.dominos.game.view;

import com.dominos.game.components.Plateau;
import com.dominos.game.components.Tuile;

import javax.swing.*;
import java.awt.*;

public class JPlateau extends JPanel {

    private JPanel plateauContainer;
    private JTuile[][] tuiles;

    private Plateau plateau;
    private int x, y;

    public JPlateau(int nbLins, int nbCols) {
        plateauContainer = new JPanel(new GridLayout(nbLins, nbCols));
        initTuiles(nbLins, nbCols);
        setLayout(new BorderLayout());
        add(plateauContainer, BorderLayout.CENTER);
        x = 10;
        y = 10;
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

    public void paint(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, 5 * (JTuile.RECT_WIDTH + 1) * tuiles[0].length, 5 * (JTuile.RECT_HEIGHT+1) * tuiles.length);
        for(int i = 0; i < tuiles.length; i++) {
            for(int j = 0; j < tuiles[0].length; j++) {
                x = 5 * (JTuile.RECT_WIDTH+1) * j;
                y = 5 * (JTuile.RECT_HEIGHT+1) * i;
                if(plateau != null) {
                    Tuile tuile = plateau.getTuile(i, j);
                    tuiles[i][j].setTuile(tuile);
                }
                tuiles[i][j].paint(g);
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
        return 5 * (JTuile.RECT_WIDTH + 1) * tuiles[0].length;
    }

    @Override
    public int getHeight() {
        return 5 * (JTuile.RECT_HEIGHT+1) * tuiles.length;
    }

}

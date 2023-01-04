package poo.dominos.game.view;

import poo.dominos.game.components.Plateau;

import javax.swing.*;
import java.awt.*;

public class JPlateau extends JPanel {
    private JTuile[][] tuiles;
    private Plateau plateau;

    public JPlateau(int nbLins, int nbCols) {
        setLayout(null);
        initTuiles(nbLins, nbCols);
        setSize(getWidth(), getHeight());
        repaint();
    }

    private void initTuiles(int lins, int cols) {
        tuiles = new JTuile[lins][cols];
        for(int i = 0; i < lins; i++) {
            for(int j = 0; j < cols; j++) {
                int x = (JTuile.TUILE_WIDTH + 5) * j; // indices de la tuile sur le plateau la toute premiéres étant 0 0
                int y = (JTuile.TUILE_HEIGHT + 5) * i;
                tuiles[i][j] = new JTuile();
                add(tuiles[i][j]);
                tuiles[i][j].setLocation(x, y);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        for(int i = 0; i < tuiles.length; i++) {
            for(int j = 0; j < tuiles[0].length; j++) {
                if(plateau != null) {
                    tuiles[i][j].setTuile(plateau.getTuile(i, j));
                }
                tuiles[i][j].paintComponent(g);
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

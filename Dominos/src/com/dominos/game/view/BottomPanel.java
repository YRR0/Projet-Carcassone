package com.dominos.game.view;

import com.dominos.game.components.Tuile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class BottomPanel extends JComponent {

    private JTuile tuile;
    private JPanel container;
    private JButton turnLeft;
    private JButton turnRight;

    public BottomPanel() {
        initButtons();

        tuile = new JTuile();

        container = new JPanel(new GridLayout(1, 3, 30, 0));
        container.add(turnLeft);
        container.add(tuile);
        container.add(turnRight);

        setLayout(new BorderLayout());
        add(container, BorderLayout.CENTER);
    }


    private void initButtons() {
        turnLeft = new JButton("<-");
        turnRight = new JButton("->");
    }

    public void setTuile(Tuile t) {
        tuile.setTuile(t);
    }



    public JTuile getTuile() {
        return tuile;
    }
}

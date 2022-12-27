package com.dominos.game.view;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JFrame {

    public JButton play;
    public JLabel label;
    public JTextArea input;

    public HomeView() {
        init();
        initComponents();
    }

    private void init() {
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Quatrominos Main Menu");
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        play = new JButton("Play");
        label = new JLabel("Le nombre de joueurs", SwingConstants.CENTER);
        input = new JTextArea();
        JPanel inputPanel = new JPanel(new GridLayout(1, 2));
        inputPanel.add(label);
        inputPanel.add(input);
        panel.add(inputPanel);
        inputPanel.setVisible(true);
        panel.add(play);
        panel.setVisible(true);
        getContentPane().add(panel);
    }
}

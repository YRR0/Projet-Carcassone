package poo.carcassone.game.view;

import poo.carcassone.game.player.Joueur;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showInputDialog;

public class JGameInfo extends JPanel {
    // Les informations du joueur courant
    private JPanel playerInfo;
    private JLabel playerName;
    private JLabel playerScore;
    // Les informations de tous les joueurs de la partie courante
    private JPanel gameInfo;
    private JLabel[] playersNames;
    private JLabel[] playersScores;
    private Joueur[] joueurs;



    public JGameInfo(int nbJoueurs) {
        initPlayerInfo();
        initGameInfo(nbJoueurs);

        setLayout(new BorderLayout());

        gameInfo.setBackground(Color.WHITE);
        add(gameInfo, BorderLayout.CENTER);
        add(playerInfo, BorderLayout.SOUTH);
    }

    private void initPlayerInfo() {
        playerInfo = new JPanel(new FlowLayout());
        playerName = new JLabel();
        playerName.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
        playerScore = new JLabel();
        playerScore.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));
        playerInfo.add(playerName);
        playerInfo.add(playerScore);
    }

    private void initGameInfo(int nbJoueurs) {
        joueurs = new Joueur[nbJoueurs];

        gameInfo  = new JPanel();
        gameInfo.setLayout(new GridLayout(nbJoueurs+1, 2));
        playersNames = new JLabel[nbJoueurs+1];
        playersScores = new JLabel[nbJoueurs+1];
        playersNames[0] = new JLabel("Player name", SwingConstants.CENTER);
        playersScores[0] = new JLabel("Player score", SwingConstants.CENTER);
        styleGameInfo();
        gameInfo.add(playersNames[0]);
        gameInfo.add(playersScores[0]);
        for(int i = 1; i < nbJoueurs+1; i++) {
            String name = showInputDialog(this, "Donner le nom du joueur " + i);
            joueurs[i-1] = new Joueur(name);
            playersNames[i] = new JLabel(name+":", SwingConstants.CENTER);
            playersScores[i] = new JLabel("0", SwingConstants.CENTER);
            playersNames[i].setFont(new Font("Helvetica", Font.BOLD, 20));
            playersScores[i].setFont(new Font("Helvetica", Font.BOLD, 20));
            gameInfo.add(playersNames[i]);
            gameInfo.add(playersScores[i]);
        }
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }

    public void setPlayerInfo(String name, int nbPoints) {
        playerName.setText(name);
        playerScore.setText(String.valueOf(nbPoints));
    }

    // On change juste le score les noms ne changeront pas en cours de la partie
    public void setGameInfo(int i, int score) { // i : l'indice de la case du joueurs dans playersNames qui est le meme dans playersScores
        playersScores[i+1].setText(String.valueOf(score));
    }

    private void styleGameInfo() {
        //InputStream fontInput = getClass().getResourceAsStream("/fonts/ChivoMono-VariableFont_wght.ttf");
        Font myFont = new Font("Times New Roman", Font.BOLD, 25);
       /* try {
            myFont = Font.createFont(Font.TRUETYPE_FONT, fontInput);
            myFont.deriveFont(Font.BOLD);
            myFont.deriveFont(10000000000000000000000000000000f);
        } catch (FontFormatException | IOException e) {
            System.out.println("erreure");
        }*/
        playerName.setFont(myFont);
        playerScore.setFont(myFont);
        playerName.setForeground(new Color(31, 29, 54));
        playerScore.setForeground(new Color(41, 52, 98));
        playersNames[0].setFont(myFont);
        playersScores[0].setFont(myFont);
        playersNames[0].setForeground(Color.BLACK);
        playersScores[0].setForeground(Color.BLACK);
    }
}

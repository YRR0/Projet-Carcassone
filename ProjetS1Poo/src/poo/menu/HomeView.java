package poo.menu;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeView extends JPanel {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) screenSize.getWidth(), HEIGHT = (int) screenSize.getHeight();
    JButton dominosBtn, carcassoneBtn, loadDominos, loadCarcassone;
    private JPanel dominosPnl, carcassonePnl;
    private JSlider nbJoueursDominos, nbJoueursCarcassone, nbJoueursADominos, nbJoueursACarcassone;
    private JLabel dominosPlayersLbl, carcassonePlayersLbl, IADominosLbl, IACarcassoneLbl;


    private static class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(String path) {
            setLayout(null);
            try {
                image = ImageIO.read(new File(path));
                setSize(image.getWidth(), image.getHeight());
            } catch (IOException e) {
                System.err.println("Erreure dans le chargement de l'image ImagePanel");
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if(image != null) g.drawImage(image, 0, 0, this);
        }
    }

    public HomeView() {
        initPanels();
        initButtons();
        initNbPlayers();
        reposition();

        dominosPnl.add(dominosBtn);
        carcassonePnl.add(carcassoneBtn);
        dominosPnl.add(nbJoueursDominos);
        carcassonePnl.add(nbJoueursCarcassone);
        dominosPnl.add(dominosPlayersLbl);
        carcassonePnl.add(carcassonePlayersLbl);
        dominosPnl.add(nbJoueursADominos);
        carcassonePnl.add(nbJoueursACarcassone);
        dominosPnl.add(loadDominos);
        carcassonePnl.add(loadCarcassone);
        dominosPnl.add(IADominosLbl);
        carcassonePnl.add(IACarcassoneLbl);

        add(dominosPnl);
        add(carcassonePnl);
    }

    private void initPanels() {
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(1, 2));

        dominosPnl = new ImagePanel("ProjetS1Poo/src/Resources/images/R.jpg");
        carcassonePnl = new ImagePanel("ProjetS1Poo/src/Resources/images/c2.jpg");

        dominosPnl.setBackground(new Color(0,0,0));
        carcassonePnl.setBackground(new Color(255, 255, 255));
    }

    private void initButtons() {
        dominosBtn = new JButton(new ImageIcon("ProjetS1Poo/src/Resources/images/button1.png"));
        carcassoneBtn = new JButton(new ImageIcon("ProjetS1Poo/src/Resources/images/button3.png"));
        loadDominos = new JButton("Load");
        loadCarcassone = new JButton("Load");

        dominosBtn.setBackground(Color.BLACK);
        carcassoneBtn.setBackground(Color.WHITE);
        loadDominos.setBackground(Color.WHITE);
        loadCarcassone.setBackground(Color.BLACK);
        loadCarcassone.setForeground(Color.WHITE);
    }

    private void initNbPlayers() {
        nbJoueursDominos = new JSlider(2, 4, 2);
        nbJoueursDominos.setMajorTickSpacing(1);
        nbJoueursDominos.setMinorTickSpacing(1);
        nbJoueursDominos.setPaintLabels(true);
        nbJoueursDominos.setPaintTicks(true);

        nbJoueursADominos = new JSlider(0, 2, 0);
        nbJoueursADominos.setMajorTickSpacing(1);
        nbJoueursADominos.setMinorTickSpacing(1);
        nbJoueursADominos.setPaintLabels(true);
        nbJoueursADominos.setPaintTicks(true);

        nbJoueursCarcassone = new JSlider(2, 4, 2);
        nbJoueursCarcassone.setMajorTickSpacing(1);
        nbJoueursCarcassone.setMinorTickSpacing(1);
        nbJoueursCarcassone.setPaintTicks(true);
        nbJoueursCarcassone.setPaintLabels(true);

        nbJoueursACarcassone = new JSlider(0, 2, 0);
        nbJoueursACarcassone.setMajorTickSpacing(1);
        nbJoueursACarcassone.setMinorTickSpacing(1);
        nbJoueursACarcassone.setPaintTicks(true);
        nbJoueursACarcassone.setPaintLabels(true);

        dominosPlayersLbl = new JLabel("Selectionnez le nombre de joueurs");
        carcassonePlayersLbl = new JLabel("Selectionnez le nombre de joueurs");
        IADominosLbl = new JLabel("Selectionnez le nombre de IA");
        IACarcassoneLbl = new JLabel("Selectionnez le nombre de IA");
        Font labelsFont = new Font("ariel", Font.BOLD, 25);
        dominosPlayersLbl.setFont(labelsFont);
        carcassonePlayersLbl.setFont(labelsFont);
        IADominosLbl.setFont(labelsFont);
        IACarcassoneLbl.setFont(labelsFont);
        dominosPlayersLbl.setForeground(Color.WHITE);
        IADominosLbl.setForeground(Color.WHITE);
    }

    private void reposition() {
        dominosBtn.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.5 * HEIGHT) - 29, 210, 58);
        carcassoneBtn.setBounds((int) (0.25 * WIDTH) - 125, (int) (0.5 * HEIGHT) - 29, 250, 58);
        loadDominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.6 * HEIGHT) - 29, 210, 58);
        loadCarcassone.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.6 * HEIGHT) - 29, 210, 58);

        nbJoueursDominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.7 * HEIGHT), 210, 58);
        nbJoueursDominos.setForeground(Color.WHITE);
        nbJoueursDominos.setBackground(Color.BLACK);
        nbJoueursADominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.85 * HEIGHT), 210, 58);
        nbJoueursADominos.setForeground(Color.WHITE);
        nbJoueursADominos.setBackground(Color.BLACK);
        nbJoueursCarcassone.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.7 * HEIGHT), 210, 58);
        nbJoueursCarcassone.setBackground(Color.WHITE);
        nbJoueursACarcassone.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.85 * HEIGHT), 210, 58);
        nbJoueursACarcassone.setBackground(Color.WHITE);

        dominosPlayersLbl.setBounds((int) (0.25 * WIDTH) - 220, (int) (0.65 * HEIGHT) - 29, 440, 58);
        carcassonePlayersLbl.setBounds((int) (0.25 * WIDTH) - 220, (int) (0.65 * HEIGHT) - 29, 440, 58);
        IADominosLbl.setBounds((int) (0.25 * WIDTH) - 180, (int) (0.8 * HEIGHT) - 29, 360, 58);
        IACarcassoneLbl.setBounds((int) (0.25 * WIDTH) - 180, (int) (0.8 * HEIGHT) - 29, 360, 58);
    }

    public int getNbJoueursDominos() {
        return nbJoueursDominos.getValue();
    }

    public int getNbJoueursADominos() {
        return nbJoueursADominos.getValue();
    }

    public int getNbJoueursCarcassone() {
        return nbJoueursCarcassone.getValue();
    }

    public int getNbJoueursACarcassone() {
        return nbJoueursACarcassone.getValue();
    }
}

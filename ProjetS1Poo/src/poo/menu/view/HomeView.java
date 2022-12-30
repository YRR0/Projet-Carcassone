package poo.menu.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

public class HomeView extends JPanel {

    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) screenSize.getWidth(), HEIGHT = (int) screenSize.getHeight();
    private JButton dominosBtn, carcassoneBtn;
    private JPanel dominosPnl, carcassonePnl;
    private JSlider nbJoueursDominos, nbJoueursCarcassone, nbJoueursADominos;
    private JLabel dominosPlayersLbl, carcassonePlayersLbl;


    private static class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(URL path) {
            setLayout(null);
            try {
                image = ImageIO.read(new File(path.toURI()));
                setSize(image.getWidth(), image.getHeight());
            } catch (IOException | URISyntaxException e) {
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

        add(dominosPnl);
        add(carcassonePnl);
    }

    public JButton getDominosBtn() {
        return dominosBtn;
    }

    public JButton getCarcassoneBtn() {
        return carcassoneBtn;
    }

    private void initPanels() {
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout(1, 2));

        dominosPnl = new ImagePanel(Objects.requireNonNull(getClass().getResource("/images/R.jpg")));
        carcassonePnl = new ImagePanel(Objects.requireNonNull(getClass().getResource("/images/c2.jpg")));

        dominosPnl.setBackground(new Color(0,0,0));
        carcassonePnl.setBackground(new Color(255, 255, 255));
    }

    private void initButtons() {
        dominosBtn = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button1.png"))));
        carcassoneBtn = new JButton(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/button3.png"))));

        dominosBtn.setBackground(Color.BLACK);
        carcassoneBtn.setBackground(Color.WHITE);
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

        dominosPlayersLbl = new JLabel("Selectionnez le nombre de joueurs");
        carcassonePlayersLbl = new JLabel("Selectionnez le nombre de joueurs");
        Font labelsFont = new Font("ariel", Font.BOLD, 25);
        dominosPlayersLbl.setFont(labelsFont);
        carcassonePlayersLbl.setFont(labelsFont);
        dominosPlayersLbl.setForeground(Color.WHITE);
    }

    private void reposition() {
        dominosBtn.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.5 * HEIGHT) - 29, 210, 58);
        carcassoneBtn.setBounds((int) (0.25 * WIDTH) - 125, (int) (0.5 * HEIGHT) - 29, 250, 58);

        nbJoueursDominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.7 * HEIGHT), 210, 58);
        nbJoueursDominos.setForeground(Color.WHITE);
        nbJoueursDominos.setBackground(Color.BLACK);
        nbJoueursADominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.75 * HEIGHT), 210, 58);
        nbJoueursADominos.setForeground(Color.WHITE);
        nbJoueursADominos.setBackground(Color.BLACK);
        nbJoueursCarcassone.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.7 * HEIGHT), 210, 58);
        nbJoueursCarcassone.setBackground(Color.WHITE);

        dominosPlayersLbl.setBounds((int) (0.25 * WIDTH) - 220, (int) (0.6 * HEIGHT), 440, 58);
        carcassonePlayersLbl.setBounds((int) (0.25 * WIDTH) - 220, (int) (0.6 * HEIGHT), 440, 58);
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
}

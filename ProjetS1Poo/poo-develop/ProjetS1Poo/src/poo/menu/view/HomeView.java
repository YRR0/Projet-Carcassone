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
    private JSlider nbJoueursDominos, nbJoueursCarcassone, nbJoueursADominos, nbJoueursACarcassone ;
    private JLabel dominosPlayersLbl, carcassonePlayersLbl , domPlIA, carPLIA;


    private static class ImagePanel extends JPanel {

    	 private BufferedImage image;
		  private int x,y;
		  public ImagePanel(String path, int x, int y) {
			  this.x = x; this.y = y;
		    try {
		      image = ImageIO.read(new File(path));
		    } catch (IOException ex) {
		    	System.out.println(ex.getMessage());
		      System.out.println("Erreur dans le chargement du Panel");
		    }
		  }

		  @Override
		  public Dimension getPreferredSize() {
			 return image == null ? new Dimension(100, 100) : new Dimension(image.getWidth(), image.getHeight());
		  }

		  @Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    if(image == null) {
				 System.out.println("Unresolved");
			 } 
		   g.drawImage(image, x, y, this);
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
        
        dominosPnl.add(domPlIA);
        dominosPnl.add(nbJoueursADominos);
        carcassonePnl.add(carPLIA);
        carcassonePnl.add(nbJoueursACarcassone);
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

        dominosPnl = new ImagePanel("Ress/images/dom.jpg",100,10);dominosPnl.setLayout(null);
        carcassonePnl = new ImagePanel("Ress/images/carca.jpg",200,10);carcassonePnl.setLayout(null);
        
        dominosPnl.setBackground(new Color(0,0,0));
        carcassonePnl.setBackground(new Color(255, 255, 255));
    }

    private void initButtons() {
        dominosBtn = new JButton(new ImageIcon("Ress/images/button1.png"));
    	dominosBtn.setBackground(Color.BLACK);
        dominosBtn.setOpaque(false); dominosBtn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        
        carcassoneBtn = new JButton(new ImageIcon("Ress/images/button3.png"));
        carcassoneBtn.setBackground(Color.WHITE);
        carcassoneBtn.setOpaque(false); carcassoneBtn.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
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
        
        nbJoueursACarcassone = new JSlider(0,2,0);
        nbJoueursACarcassone.setMajorTickSpacing(1);
        nbJoueursACarcassone.setMinorTickSpacing(1);
        nbJoueursACarcassone.setPaintLabels(true);
        nbJoueursACarcassone.setPaintTicks(true);


        dominosPlayersLbl = new JLabel("Selectionnez le nombre de joueurs");
        domPlIA = new JLabel("Donner le nombre de joueur artificiel");
        
        carcassonePlayersLbl = new JLabel("Selectionnez le nombre de joueurs");
        carPLIA = new JLabel("Donner le nombre de joueur Artificiel");
        
        Font labelsFont = new Font("ariel", Font.BOLD, 20);
        dominosPlayersLbl.setFont(labelsFont);
        domPlIA.setFont(labelsFont);
        carcassonePlayersLbl.setFont(labelsFont);
        carPLIA.setFont(labelsFont);
        dominosPlayersLbl.setForeground(Color.WHITE);
        domPlIA.setForeground(Color.WHITE);
    }

    private void reposition() {
    	
        dominosBtn.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.55 * HEIGHT) - 29, 200, 58);
        carcassoneBtn.setBounds((int) (0.25 * WIDTH) - 125, (int) (0.55 * HEIGHT) - 29, 250, 58);

        nbJoueursDominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.63 * HEIGHT), 210, 58);
        nbJoueursDominos.setForeground(Color.WHITE);
        nbJoueursDominos.setBackground(Color.BLACK);
        nbJoueursADominos.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.75 * HEIGHT), 210, 58);
        nbJoueursADominos.setForeground(Color.WHITE);
        nbJoueursADominos.setBackground(Color.BLACK);
        
        nbJoueursCarcassone.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.63 * HEIGHT), 210, 58);
        nbJoueursCarcassone.setBackground(Color.WHITE);
        nbJoueursACarcassone.setBounds((int) (0.25 * WIDTH) - 105, (int) (0.75 * HEIGHT), 210, 58);
        nbJoueursACarcassone.setBackground(Color.WHITE);
        
        dominosPlayersLbl.setBounds((int) (0.28 * WIDTH) - 220, (int) (0.58 * HEIGHT), 400, 58);
        domPlIA.setBounds((int) (0.28 * WIDTH) - 220, (int) (0.7 * HEIGHT), 400, 58);
        carcassonePlayersLbl.setBounds((int) (0.28 * WIDTH) - 220, (int) (0.58 * HEIGHT), 400, 58);
        carPLIA.setBounds((int) (0.28 * WIDTH) - 220, (int) (0.7 * HEIGHT), 400, 58);
        
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

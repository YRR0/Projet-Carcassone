package poo.Acceuil.AcceuilView;

import java.awt.Color;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import poo.Acceuil.AcceuilController.DominoControler;
import poo.dominos.game.controller.TerminalController;

public class DominoLauncher extends JFrame{
	private JButton terminal;
	private JButton graphique;
	private JPanel pane1;
	private JPanel pane2;
	
	public DominoLauncher() {
		this.setSize(800,500);
		this.setLayout(new GridLayout(1,2));
		
		pane1=new JPanel(); pane1.setLayout(null); pane1.setBackground(Color.black);
		pane2=new JPanel(); pane2.setLayout(null); pane2.setBackground(Color.black);
		BufferedImage image = null , image2 = null;
        try {
			image = ImageIO.read(new File("Resources/images/terminal.png"));
			image2 = ImageIO.read(new File("Resources/images/graphique.png"));
        } catch (IOException e) {
			System.out.println("Erreur dans le chargement images pour les bouttons");
		}
        terminal = new JButton(new ImageIcon(image)); terminal.setBackground(new Color(0, 0, 0)); terminal.setOpaque(false); terminal.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
        graphique = new JButton(new ImageIcon(image2)); graphique.setBackground(new Color(0, 0, 0)); graphique.setOpaque(false); graphique.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
       
        pane1.add(terminal);
        pane2.add(graphique);
        
        this.add(pane1);this.add(pane2);
		terminal.setBounds(this.getWidth()/11,this.getHeight()/4,270,100);
		graphique.setBounds(this.getWidth()/11,this.getHeight()/4, 290, 100);
	
		terminal.addActionListener(e->{
			this.dispose();
			new TerminalController().lancer();
		});
		graphique.addActionListener(e->{
			new DominoControler();
			this.dispose();
		});
		
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    Dimension frameSize = this.getSize();
	    this.setUndecorated(true);
	    this.setBackground(Color.black);
	    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	    this.show();
	}
}

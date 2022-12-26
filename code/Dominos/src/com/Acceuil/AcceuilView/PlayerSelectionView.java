package com.Acceuil.AcceuilView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.dominos.game.controller.GameController;

public class PlayerSelectionView extends JFrame {
	
	private BufferedImage image1=null,image2=null,image3=null, image4=null;
	public JButton player2,player3,player4;
	public JButton validation;
	private JPanel contenu;
	public JPanel contenu2;
	public JScrollPane scrollPane;
	public JList number;
	public boolean creation;
	public JLabel message;
	public String[] listData=new String[5];
	public int nombreJoueur=0;
	
	public PlayerSelectionView() {
		this.setUndecorated(true);
		this.setLayout(new GridLayout(2,1));
		creationImage();
		initList();
		
	    contenu = new JPanel(); contenu.setLayout(null); contenu.setBackground(Color.DARK_GRAY);
	    contenu.add(player2); contenu.add(player3); contenu.add(player4);
	    add(contenu);

	    contenu2 = new JPanel(); contenu2.setBackground(Color.gray);
	    validation.setEnabled(false);
        validation.setBounds(500,this.getHeight()/2 , 100, 30);
	    number = new JList<>(listData);
        number.setVisibleRowCount(1);
        scrollPane = new JScrollPane(number);
        message = new JLabel("Choisissez le nombre de joueur artificiel : "); message.setVisible(false);
        message.setFont(new Font("Arial", Font.BOLD, 20));
        scrollPane.setVisible(false);
        contenu2.add(message);contenu2.add(scrollPane);
        add(contenu2);
	    
		this.setSize(800,500); this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		creation = true;
		
		player2.setBounds(this.getWidth()/9,30, 230 , 105);
		player3.setBounds(this.getWidth()-(this.getWidth()/2-50),30, 230 , 105);
		player4.setBounds(this.getWidth()/2-130,130, 230 , 105);	
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}
	
	public void initList() {
		listData[0] = "O IA";
		listData[1] = "1 IA";
		listData[2] = "2 IA";
		listData[3] = " ";
		listData[4] = " ";
	}
	
	public void disableOther() {
		creation=false;
		player2.setEnabled(false);
		player3.setEnabled(false);
		player4.setEnabled(false);
	}
	
	public void creationImage() {
		 try {
			image1 = ImageIO.read(new File("Ressources/images/joueur2.png"));
			image2 = ImageIO.read(new File("Ressources/images/joueur3.png"));
			image3 = ImageIO.read(new File("Ressources/images/joueur4.png"));
			image4 = ImageIO.read(new File("Ressources/images/Ok.png"));
		 } catch (IOException e) {
			System.out.println("Erreur dans le chargement images pour les bouttons");
		}	
		player2 = new JButton(new ImageIcon(image1)); player2.setBackground(new Color(0, 0, 0)); player2.setOpaque(false); player2.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
	    player3 = new JButton(new ImageIcon(image2)); player3.setBackground(new Color(0, 0, 0)); player3.setOpaque(false); player3.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
	    player4 = new JButton(new ImageIcon(image3)); player4.setBackground(new Color(0, 0, 0)); player4.setOpaque(false); player4.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
	    validation = new JButton(new ImageIcon(image4)); validation.setBackground(new Color(0, 0, 0)); validation.setOpaque(false); validation.setBorder(BorderFactory.createLineBorder(new Color(0,0,0,0)));
	}
	
	public JList getList() {
		return number;
	}
	
	public JButton getValidation() {
		return this.validation;
	}

}

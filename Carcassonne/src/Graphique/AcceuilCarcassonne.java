package Graphique;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AcceuilCarcassonne extends JFrame{
	
	JButton partie1 = new JButton("2 Joueurs");
	JButton partie2 = new JButton("3 Joueurs");
	JButton partie3 = new JButton("4 Joueurs");
	
	//JButton continuer = new JButton("Continuer");
	JPanel fieldPrincipal = new JPanel();
	
	public AcceuilCarcassonne() {
		JLabel information = new JLabel(" Choisissez le nombre Joueur : ");
		this.setLayout(new BorderLayout()); 
		this.setSize(500, 200);
		this.add(fieldPrincipal,BorderLayout.CENTER);
		this.creationPrincipal();
		this.actionButton();
		
		information.setHorizontalAlignment(WIDTH/2);
		this.getContentPane().add(information,BorderLayout.NORTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("ACCEUIL CARCASSONNE"); this.show();	
	}
	
	public void creationPrincipal() {
		fieldPrincipal.setLayout(null);
		partie1.setSize(100, 50);
		partie1.setBackground(Color.darkGray); partie1.setForeground(Color.WHITE);
		partie1.setLocation(this.getWidth()-this.getWidth()+20,this.getHeight()/4);
		fieldPrincipal.add(partie1);
		
		partie2.setSize(100, 50);
		partie2.setBackground(Color.blue); partie2.setForeground(Color.WHITE);
		partie2.setLocation(this.getWidth()/3+20,this.getHeight()/4);
		fieldPrincipal.add(partie2);
		
		partie3.setLocation(this.getWidth()-130,this.getHeight()/4);
		partie3.setBackground(Color.red); partie3.setForeground(Color.WHITE);
		partie3.setSize(100, 50);
		fieldPrincipal.add(partie3);
	}
	
	public void actionButton() {
		partie1.addActionListener( action ->{
			GestionPartieCarcassonne gameStart = new GestionPartieCarcassonne(2);
			this.dispose();
		});
		partie2.addActionListener( action ->{
			GestionPartieCarcassonne gameStart = new GestionPartieCarcassonne(3);
			this.dispose();
		});
		partie3.addActionListener( action ->{
			GestionPartieCarcassonne gameStart = new GestionPartieCarcassonne(4);
			this.dispose();
		});
		
	}
	
}

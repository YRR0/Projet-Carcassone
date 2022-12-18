package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.BadLocationException;

import JeuCarcassonne.PlateauCarcassonne;
import JeuCarcassonne.SacCarcassonne;
import JeuCarcassonne.TuileCarcassonne;
import Player.Joueur;

public class GestionPartieCarcassonne extends JFrame{
	
	//Gestion des Joueurs
	private int index;
	private Joueur[] lesJoueurs;
	
	// Gestion des pieces
	ActivityGameCarcassonne activity;
	PlateauCarcassonne plateau;
	private SacCarcassonne sac = new SacCarcassonne();
	TuileCarcassonne tuileAPlacer;
	
	private JTextField commande = new JTextField(10);
	private JLabel textInfo = new JLabel("Nom Joueur "+(index+1)+" : ");
	private JButton next = new JButton("NEXT");
	
	// Gestion des informations que donne le joueur
	private String informationLigne,informationColonne;
	private int deb=0 , action=0;
	
	public GestionPartieCarcassonne(int n) {
		lesJoueurs = new Joueur[n];
		this.organisationPrincipal();
		
		this.addAllElements();
		this.actionNextButton();
		this.setTitle(" Information Gestion ");
		this.show();
	}
	
	public void organisationPrincipal() {
		// Creation de notre Sac avec tous les éléments
		sac.creationDesTuiles();
		SpringLayout dispo = new SpringLayout();
		this.setLayout(dispo);
		
		dispo.putConstraint(SpringLayout.WEST, textInfo, 20, SpringLayout.WEST, this.getContentPane());
		dispo.putConstraint(SpringLayout.NORTH, textInfo, 20, SpringLayout.NORTH, this.getContentPane());
		dispo.putConstraint(SpringLayout.NORTH, commande, 20, SpringLayout.NORTH, this.getContentPane());
		dispo.putConstraint(SpringLayout.WEST, commande, 20, SpringLayout.EAST, textInfo);
		dispo.putConstraint(SpringLayout.NORTH, next, 20, SpringLayout.NORTH, this.getContentPane());
		dispo.putConstraint(SpringLayout.WEST, next, 20, SpringLayout.EAST, commande);
		
		this.setSize(new Dimension(400,150));
		this.setBackground(Color.DARK_GRAY);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addAllElements() {
		this.getContentPane().add(textInfo);
		this.getContentPane().add(commande);
		this.getContentPane().add(next);
		
		plateau = new PlateauCarcassonne(20,20);
		tuileAPlacer = sac.retirer();
		activity = new ActivityGameCarcassonne(plateau);
		activity.setTuileRetirer(tuileAPlacer);
	}
	
	public void actionNextButton() {
		next.addActionListener(event ->{
			this.gestionPartie();
		});
	}
	
	public void gestionPartie() {
		if(index < lesJoueurs.length ) {
			String m = (commande.getText().equals(null)) ? ("Joueur "+index) : commande.getText();
			// Creation de nos Joueurs
			lesJoueurs[index] = new Joueur(m);
			index++; 
			System.out.println("Index -> "+index);
			
			if(index+1 <= lesJoueurs.length) {
				textInfo.setText(" Nom du joueur " + (index+1)+" : ");	
				commande.setText("");		
				this.show();
			}
			else {
				System.out.println("__ Initialisation de la ligne __");
				this.setSize(new Dimension(550,100));
				textInfo.setText(" Tour de "+lesJoueurs[deb].nom+", donner le numero de ligne ");
				commande.setText("");
				this.startVisualiz();this.show();
			}
		}
		else {
			System.out.println("ELSE DEBUT INFORMATION LIGNE");
		try {
			//this.afficherJoueur();
			
			if(action == 0) {
				System.out.println("-->Action 0");
				informationLigne = commande.getText();
				commande.setText("");
				textInfo.setText(" Donner le numero de la colonne : "); commande.setText("");
				this.repaint();this.show();
			}
			if(action == 1) {
				System.out.println("--->Action 1");		
				informationColonne = commande.getText();
				System.out.println(" Coordonnée ligne ->"+informationLigne + " colonne ->"+informationColonne );
				
				//-----> AJOUT DE LA TUILE
				this.addGameTuile();
				
				textInfo.setText("Voulez vous placer un partisan ? ");
				commande.setText("");
				this.show();
			}
			// Ajout de la demande de Partisan
			if(action == 2) {
				System.out.println("----> Action 2");
				// Gestion de la reponse sur l'ajout de Partisan
				
				// Preparation pour le prochain joueur
				deb = (deb+1>=lesJoueurs.length) ? 0 : deb+1;
				System.out.println("Indice de deb : " + deb);
				textInfo.setText(" Tour de "+lesJoueurs[deb].nom+", donner le numero de ligne ");
				commande.setText("");
				
				//CHangement de la tuile à reirer
				tuileAPlacer = sac.retirer();
				activity.setTuileRetirer(tuileAPlacer);
				action=-1;
			}
			action++;
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			System.out.println(" Il y a une erreur dans la dimension");
			
			}
		}
	}
	
	
	public void afficherJoueur() {
		System.out.println("Affichage des joueurs");
		for(Joueur m : lesJoueurs) {
			System.out.println(m.nom);
		}
	}
	
	public void addGameTuile() {
		int i = Integer.valueOf(informationLigne); System.out.println("Transformation de la ligne : " +i );
		int j = Integer.valueOf(informationColonne); System.out.println("Transformation de la colonne : " + j);
		// Sachant que mis a jour est censé verifier les cases et la position
		activity.misAjour(tuileAPlacer, i, j);
	}

	public void startVisualiz() {
		activity.montrer();
	}
	
}

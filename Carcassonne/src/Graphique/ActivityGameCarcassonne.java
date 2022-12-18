package Graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import JeuCarcassonne.PlateauCarcassonne;
import JeuCarcassonne.SacCarcassonne;
import JeuCarcassonne.TuileCarcassonne;

public class ActivityGameCarcassonne extends JFrame {
	
	PlateauCarcassonne plateauJeu;
	
	// Information util pour le joueur
	private JPanel affichageBas;
	private JLabel bas;
	JLabel tuileInfo;
	private TuileCarcassonne tuileRetirer;
	private JButton boutonRotation;
	
	private PlateauGraphique plg;
	private JButton tourner = new JButton();
	
	
	// L'affichage de notre plateau de carcassonne
	public class PlateauGraphique extends JPanel{

		public PlateauGraphique() {
			super();
			this.setLayout(new GridLayout(plateauJeu.nbLin()+1,plateauJeu.nbCol()));
			
			int i=1;
			JLabel debL = new JLabel(" ");super.add(debL);			
			for(int j=2; j<22 ;j++) {
				JLabel pos = new JLabel("    Col"+i); super.add(pos); i++;
			}
			i=1;
			for(TuileCarcassonne[] ligne : plateauJeu.getTuilesPlateauCarcassonne()) {
				//JLabel deb = new JLabel("  ");super.add(deb);			
				JLabel pos = new JLabel("Ligne"+i); super.add(pos); i++;
				for(TuileCarcassonne tuileCarca : ligne) {
						//System.out.println("non null");
						String path = "ressource/image/rect.png";
						ImageScene im = new ImageScene(path);
						JLabel image = new JLabel(new ImageIcon(im.image));
						im.setMaximumSize(new Dimension(1000/20, 800/20));
						super.add(image);
				}
			}
		}
		
		public void ajout(TuileCarcassonne tuile,int i,int j) {
			int pos = i*plateauJeu.nbCol() + j + (int) Math.pow(i, j) ; // LA FORMULE D AJOUT EST ENCORE A REGLER 
			ImageScene im = testImage(tuile);
			JLabel image = new JLabel(new ImageIcon(im.image));
			if(tuile.corresponds(plateauJeu, i, j)) {
				super.remove(pos);
				System.out.println("Add the image in the game Scene");
				super.add(image, pos);	
			}
			else {
				System.out.println(" Ajout non reussi dans Affichage de jeu");
			}
		}
		
		public ImageScene testImage(TuileCarcassonne tuile) {
		//1
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("plaine") &&
			tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("plaine") &&
			tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
				return new ImageScene("ressource/image/Abbaye.png");
		}
		//2
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("plaine") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("route") &&
				tuile.getAbbaye() && !tuile.getBouclier() && tuile.getRFerme()) {
					return new ImageScene("ressource/image/abbayeChemin.png");
		}
		//3
		if(tuile.getTuile(0).equals("route") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/plaine2Route2.png");
		}
		//4
		if(tuile.getTuile(0).equals("route") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("mur") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/route2murPlaine.png");
		}
		//5
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("route") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville2route2bouclier.png");
		}
		//6
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville3chemin1.png");
		}
		//7
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville3plaine1Bouclier.png");
		}
		//8
		if(tuile.getTuile(0).equals("route") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("mur") && tuile.getTuile(3).equals("mur") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville2route2.png");
		}
		//9
		if(tuile.getTuile(0).equals("mur") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("route") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/rooute3NFMur1.png");
		}
		//10
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/route2DPlaine2.png");
		}
		//11
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("route") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && tuile.getRFerme()) {
					return new ImageScene("ressource/image/route3plaine1.png");
		}
		//12
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("mur") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/VilleHaut.png");
		}
		//13
		/*
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("mur") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/.png");
		}
		*/
		//14
		if(tuile.getTuile(0).equals("plaine") && tuile.getTuile(1).equals("mur") &&
				tuile.getTuile(2).equals("mur") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/route2plaine2.png");
		}
		//15
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville3plaine1.png");
		}
		//16
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/plaine2ville2.png");
		}
		//17
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("plaine") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville2DroitPlaine2bouclier.png");
		}
		//18
		if(tuile.getTuile(0).equals("route") && tuile.getTuile(1).equals("mur") &&
				tuile.getTuile(2).equals("route") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/cheminDroitMurPlaine.png");
		}
		//19
		if(tuile.getTuile(0).equals("route") && tuile.getTuile(1).equals("mur") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/chemin2MurPlaine.png");
		}
		//20
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("plaine") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville2plaine2.png");
		}
		//21
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && tuile.getBouclier() && tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville3chemin1Bouclier.png");
		}
		//22
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("ville") && tuile.getTuile(3).equals("ville") &&
				!tuile.getAbbaye() && tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/villeBouclier.png");
		}
		//23
		if(tuile.getTuile(0).equals("route") && tuile.getTuile(1).equals("route") &&
				tuile.getTuile(2).equals("route") && tuile.getTuile(3).equals("route") &&
				!tuile.getAbbaye() && !tuile.getBouclier() && tuile.getRFerme()) {
					return new ImageScene("ressource/image/route4F.png");
		}
		//24
		if(tuile.getTuile(0).equals("ville") && tuile.getTuile(1).equals("ville") &&
				tuile.getTuile(2).equals("plaine") && tuile.getTuile(3).equals("plaine") &&
				!tuile.getAbbaye() && tuile.getBouclier() && !tuile.getRFerme()) {
					return new ImageScene("ressource/image/ville2pl2Bouclier.png");
		}
		//25
		if(tuile.getTuile(0).equals("mur") && tuile.getTuile(1).equals("plaine") &&
			tuile.getTuile(2).equals("mur") && tuile.getTuile(3).equals("plaine") &&
			!tuile.getAbbaye() && !tuile.getBouclier() && !tuile.getRFerme()) {
			return new ImageScene("ressource/image/mur2plaine2Separ.png");
		}
		return new ImageScene("ressource/image/danger.png");
		}
		
		public void tournerImage(ImageScene im) {
			
		}
		
		public class ImageScene extends JComponent{
			private BufferedImage image;
			public ImageScene(String chemin) {
				try {
					image = ImageIO.read(new File(chemin));
					System.out.println(" Sucessful to load the image");
				}
				catch(Exception e) {
					System.out.println(" Il y a une erreur dans le chemin pour l'image");
				}	
			}
		}
	}
	
	
	public ActivityGameCarcassonne(PlateauCarcassonne plc) {
		JLabel acceuilTitre = new JLabel(" Jeu de CARCASSONNE ");
		//Affection et liaison de notre plateau de jeu
		this.setLayout(new BorderLayout()); 
		this.plateauJeu = plc;
		plg = new PlateauGraphique();
		
		this.getContentPane().add(plg,BorderLayout.CENTER);	
		this.setSize(1400,700);
		acceuilTitre.setHorizontalAlignment(WIDTH/2);
		this.getContentPane().add(acceuilTitre,BorderLayout.NORTH);
		this.gestionBas();
		this.setTitle("ACCEUIL CARCASSONNE");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}
	
	public void montrer() {
		this.show();
	}
	
	public void misAjour(TuileCarcassonne e, int i, int j) {
		plg.ajout(e, i, j); // Ajout sur l'affichage graphique
		plateauJeu.ajouter(e, i, j); // ajout dans notre plateau
		this.show();
	}
	
	// Fonction pour faire tourner la tuile
	private class RotateLabel extends JLabel {
	      public RotateLabel(String text) {
	         super(text);
	         Font font = new Font("Verdana", Font.ITALIC, 10);
	         FontMetrics metrics = new FontMetrics(font){};
	         Rectangle2D bounds = metrics.getStringBounds(text, null);
	         setBounds(0, 0, (int) bounds.getWidth(), (int) bounds.getHeight());
	      }
	      @Override
	      public void paintComponent(Graphics g) {
	         Graphics2D gx = (Graphics2D) g;
	         gx.rotate(1, getX() + getWidth()/2, getY() + getHeight()/2);
	         super.paintComponent(g);
	      }
	}
	
	public void gestionBas() {
		affichageBas = new JPanel();
		affichageBas.setLayout(new GridLayout(1,3));
		JLabel finCarcassonne = new JLabel(" Voici la tuile que vous allez placer ");
		boutonRotation = new JButton("Tourner");
		BufferedImage image;
		try {
			image = ImageIO.read(new File("ressource/image/danger.png"));
			tuileInfo = new JLabel(new ImageIcon(image));	
			affichageBas.add(finCarcassonne);
			affichageBas.add(boutonRotation);
			affichageBas.add(tuileInfo);
			this.add(affichageBas,BorderLayout.SOUTH);
		} catch (IOException e) {
			System.out.println("Probleme gestion Bas Graphique");
			e.printStackTrace();
		}
	}
	
	public void buttonBasTourner() {
		tuileRetirer.afficher();
		tuileRetirer.rotation();
		tuileRetirer.afficher();
	}
	
	public void setTuileRetirer(TuileCarcassonne e) {
		tuileRetirer = e;
		System.out.println(" _Set Tuiles_");
		tuileRetirer.afficher();
		Graphique.ActivityGameCarcassonne.PlateauGraphique.ImageScene im = plg.testImage(tuileRetirer);
		tuileInfo.setIcon(new ImageIcon(im.image));
		this.repaint();
	}
	
	public void changementTuile(TuileCarcassonne a) {
		
	}
	
}

package Test;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Graphique.ActivityGameCarcassonne;
import Graphique.GestionPartieCarcassonne;
import JeuCarcassonne.PartieCarcassonne;
import JeuCarcassonne.SacCarcassonne;
import JeuCarcassonne.TuileCarcassonne;

public class TestFonctionDeBase {
	
	public static void main(String[] args) {
		//System.out.println("Test sac Partie");
		//PartieCarcassonne testP = new PartieCarcassonne(10,10);
		//testP.lancer();
		
		/* Test creation de l'acceuil*/
		//AcceuilCarcassonne acc = new AcceuilCarcassonne();
		
		/* Test creation de note Jeu */
		//ActivityGameCarcassonne game = new ActivityGameCarcassonne();
		//SacCarcassonne sac = new SacCarcassonne();
		//TuileCarcassonne ret = sac.retirer();
		//game.misAjour(ret, 1, 1);
		
		TuileCarcassonne e1 = new TuileCarcassonne();
		e1.afficher();
		e1.rotation();
		e1.afficher();
		e1.rotation();
		e1.afficher();
		e1.rotation();
		e1.afficher();
		e1.rotation();
		
		//TuileCarcassonne ret1 = sac.retirer();
		//game.misAjour(ret, 1, 2);
		//GestionPartieCarcassonne partie = new GestionPartieCarcassonne();
	}
	
}

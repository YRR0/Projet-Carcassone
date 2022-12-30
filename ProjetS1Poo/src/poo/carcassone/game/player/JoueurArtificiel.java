package poo.carcassone.game.player;

import poo.dominos.game.components.Plateau;
import poo.dominos.game.components.Tuile;
import poo.dominos.game.player.JoueurArtificiel.Instruction;

public class JoueurArtificiel extends Joueur{
	public Instruction choix;
	
	public JoueurArtificiel(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	// une classe interner pour garder la meilleur ligne de placement et la meilleur colonne
	public static class Instruction{
		public int i;
		public int j;
		public int tour;
		Instruction(int i , int j,int tour){
			this.i = i; this.j = j; this.tour = tour;
		}
	}
	
	//Faire une methode boolean pour coupPossible pour tester si sur le terrain on peut poser notre tuile 
	public boolean coupPossible(Plateau p,Tuile a) {
		int max = 0;
		boolean res = false;
		for(int i = 0; i < p.cases.length ; i++) {
			for(int j = 0 ; j < p.cases[i].length ; j++) {
				
				//Tester les 4 choix si on tourne la tuile
				if(a.corresponds(p, i, j)) {
					//System.out.println(" Possibilité 1 ");
					p.ajouter(a, i, j);
					
					// Verification pour les points
					boolean c0=false,c1=false,c2=false,c3=false;
					if(j-1>0) {
						c0 = p.getTuile(i, j-1) == null;
					}
					if(i-1>0) {
						 c1 = p.getTuile(i-1, j) == null;
					}
					if(j+1<p.cases[i].length) {
						c2 = p.getTuile(i, j+1) == null;
					}
					if(i+1<p.cases.length) {
						c3 = p.getTuile(i+1, j) == null;
					}
                    
					int nbPoints = a.nbPoints(c0, c1, c2, c3);
                    if(nbPoints > max) {
                    max = nbPoints;
                    choix = new Instruction(i,j,0);
                    res = true;
                    }
                    // Supprimer l'element une fois la supposition fini
                    p.cases[i][j] = null;
				}
				
				a.tourner();
				if(a.corresponds(p, i, j)) {
					//System.out.println(" Possibilité 2 ");					
					p.ajouter(a, i, j);
					// Verification pour les points
					boolean c0=false,c1=false,c2=false,c3=false;
					if(j-1>0) {
						c0 = p.getTuile(i, j-1) == null;
					}
					if(i-1>0) {
						 c1 = p.getTuile(i-1, j) == null;
					}
					if(j+1<p.cases[i].length) {
						c2 = p.getTuile(i, j+1) == null;
					}
					if(i+1<p.cases.length) {
						c3 = p.getTuile(i+1, j) == null;
					}
					int nbPoints = a.nbPoints(c0, c1, c2, c3);
                    if(nbPoints > max) {
                    max = nbPoints;
                    choix = new Instruction(i,j,1);
                    res = true;
                    }
                    // Supprimer l'element une fois la supposition fini
                    p.cases[i][j] = null;
				}
				
				a.tourner();
				if(a.corresponds(p, i, j)) {
					//System.out.println(" Possibilité 3 ");
					p.ajouter(a, i, j);
					// Verification pour les points
					boolean c0=false,c1=false,c2=false,c3=false;
					if(j-1>0) {
						c0 = p.getTuile(i, j-1) == null;
					}
					if(i-1>0) {
						 c1 = p.getTuile(i-1, j) == null;
					}
					if(j+1<p.cases[i].length) {
						c2 = p.getTuile(i, j+1) == null;
					}
					if(i+1<p.cases.length) {
						c3 = p.getTuile(i+1, j) == null;
					}int nbPoints = a.nbPoints(c0, c1, c2, c3);
                    if(nbPoints > max) {
                    max = nbPoints;
                    choix = new Instruction(i,j,2);
                    res = true;
                    }
                    // Supprimer l'element une fois la supposition fini
                    p.cases[i][j] = null;
				}
				
				a.tourner();
				if(a.corresponds(p, i, j)) {
					//System.out.println(" Posibilité 4 ");
					p.ajouter(a, i, j);
					// Verification pour les points
					boolean c0=false,c1=false,c2=false,c3=false;
					if(j-1>0) {
						c0 = p.getTuile(i, j-1) == null;
					}
					if(i-1>0) {
						 c1 = p.getTuile(i-1, j) == null;
					}
					if(j+1<p.cases[i].length) {
						c2 = p.getTuile(i, j+1) == null;
					}
					if(i+1<p.cases.length) {
						c3 = p.getTuile(i+1, j) == null;
					}
					int nbPoints = a.nbPoints(c0, c1, c2, c3);
                    if(nbPoints > max) {
                    max = nbPoints;
                    choix = new Instruction(i,j,3);
                    res = true;
                    }
                    // Supprimer l'element une fois la supposition fini
                    p.cases[i][j] = null;
				}
				// Retour de la tuile à sa position de depart
				a.tourner();
			}
			
		}
		if(choix != null) {
			System.out.println("Le meilleur coup est " + choix.tour+" ligne : "+choix.i+ " colonne: "+choix.j );	
		}
		return res;
	}


}

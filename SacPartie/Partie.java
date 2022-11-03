package Partie;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

	private Sac sacDeJeu;
	private ArrayList<Joueur> joueurs = new ArrayList<>();
	private Plateau terrain;
	
	public Partie(Sac sac, Plateau plateau){
		// Je sais si on va faire une copie la ou on garde la reference pour la creation
		sacDeJeu = sac;
		terrain = plateau;
	}
	
	public void lancer() {
		Scanner cl = new Scanner(System.in);
		
		System.out.println(" - Combien de Joueurs vous etes ? - ");
		int nbJoueur = cl.nextInt();
		creationJoueur(nbJoueur);
		
		System.out.println(" - Quelle joueur va commencer ? - ");
		String rep = cl.next();
		cl.close();
		
		Joueur currentP = debut(rep);
		int ind = joueurs.getId();
		
		while( !sacDeJeu.estVide() ) {
			Tuile t = currentP.piocher(sacDeJeu);
			System.out.println("De combiend de fois voulez vous tourner votre tuile");
			cl = new Scanner(System.in);
			currentP.tourner(t,cl.nextInt());
			cl.close();
			
			/*
			System.out.println(" - Voulez vous abandonner ? - (o/n) ");
			cl = new Scanner(System.in);
			if(cl.next().equals("o")) {
				System.out.println("Vous avez aban");
				break;
			}
			*/
			ind++;
			if(ind > joueurs.size()) {
				ind = 0;
			}
			currentP = joueurs.get(ind);
		}
		
		System.out.println("Le gagnant est : " );
	}
	
	public void creationJoueur( int n ) {
		// je sais pas combien de joeur max peut etre 4
		if( n < 2 ) {
			System.out.println("Donner le nom du premier Joueur :"); 
			Scanner key = new Scanner(System.in);
			String rep = key.next();
			joueurs.add(null);
			
			System.out.println("Donner le nom du second Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add(null);
			key.close();
		}
		
		else if( n > 2 && n < 4) {
			System.out.println("Donner le nom du premier Joueur :"); 
			Scanner key = new Scanner(System.in);
			String rep = key.next();
			joueurs.add(null);
			
			System.out.println("Donner le nom du second Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add(null);
			
			System.out.println("Donner le nom du troisieme Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add(null);
			key.close();
		}
		
		else {
			System.out.println("Donner le nom du premier Joueur :"); 
			Scanner key = new Scanner(System.in);
			String rep = key.next();
			joueurs.add(null);
			
			System.out.println("Donner le nom du second Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add(null);
			
			System.out.println("Donner le nom du troisieme Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add(null);
			
			System.out.println("Donner le nom du quatrième Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add(null);
			
			key.close();
		}
	}
	
	public Joueur debut (String a) {
		for(Joueur j : joueurs) {
			if(j.equals(a)) { // Ici c'est une comparaison de nom
				return j;
			}
		}
		return null;
	}
}

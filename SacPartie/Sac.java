package Partie;

import java.util.ArrayList;

public class Sac {
	ArrayList<Tuile> sac = new ArrayList<>();
	
	public Sac(int n){
		
		while( n > 0 ) {
			// On peut peut être créer une fonction qui crée une tuile aleatoire
			sac.add(null);
			n--;
		}
	}
	
	public boolean estVide() {
		return sac.size() == 0;
	}
	
	public void ajouterTuiles(Tuile t) {
		// je sais pas si on a fait va faire un constructeur de copie
		// sac.add( new Tuile(t));
		sac.add(t); 
	}
	
	public Tuile retirer() {
		Tuile res = sac.get(0);
		sac.remove(0);
		return res;
	}
	
}

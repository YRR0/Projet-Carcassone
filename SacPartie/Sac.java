package Partie;

import java.util.ArrayList;
import java.util.random.*;
import java.math.*;
public class Sac {
	ArrayList<Tuile> sac;
	int max;
	
	public Sac() {
		sac = new ArrayList<>();
	}
	
	public Sac(int n){
		max = n;
		sac = new ArrayList<Tuile>();
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
		if(sac.isEmpty()) {
			int tirageAlea = (int)(Math.random() * sac.size());
			Tuile res = sac.get(tirageAlea);
			sac.remove(tirageAlea);
			return res;
		}
		return null;
	}
	
}

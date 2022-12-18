package JeuCarcassonne;
import java.util.ArrayList;
import java.util.Random;

public class SacCarcassonne {
	ArrayList<TuileCarcassonne> tuiles;
    static Random rand = new Random();

    public SacCarcassonne() {
        tuiles = new ArrayList<TuileCarcassonne>();
    }

    public boolean estVide() {
        return tuiles.size() == 0;
    }
  
    // Creation De toules possiblités dans la creation des tuiles
    public void creationDesTuiles() {
    	int i=0 ;
    	while(i<72) {
    	 	TuileCarcassonne m = new TuileCarcassonne();
        	tuiles.add(m);
        	i++;
    	}
    }
    
    // Creation de toute les tuiles
    public void creationTotal() {
    	while(TuileCarcassonne.nombreTuile>0) {
    		this.creationDesTuiles();
    	}
    }
    
    public TuileCarcassonne retirer() {
        if(!estVide()) {
            int index = rand.nextInt(tuiles.size());
            return tuiles.remove(index);
        }
        System.out.println("Le sac est vide !" + tuiles.size());
        return null;
    }
    
    public void afficherTuile() {
    	for(TuileCarcassonne a : tuiles) {
    		a.afficher();
    	}
    }
  
}

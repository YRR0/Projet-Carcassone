package Player;
import JeuCarcassonne.SacCarcassonne;
import JeuCarcassonne.TuileCarcassonne;

public class Joueur {


    public final String nom;
    public final int id;
    private static int nextId = 0;
    private int nbPoints;
    private boolean enJeu;

    public Joueur(String nom) {
        this.nom = nom;
        id = nextId++;
        nbPoints = 0;
        enJeu = true;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void abandonner() {
        enJeu = false;
    }
    
    public boolean getEnJeu() {
    	return this.enJeu;
    }

    public TuileCarcassonne piocher(SacCarcassonne s) {
        return s.retirer();
    }

    public void gagnerPoints(int nbPoints) {
        if(nbPoints > 0) this.nbPoints += nbPoints;
    }

    public String toString() {
        return this.nom;
    }

}

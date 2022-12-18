package JeuCarcassonne;
import Player.Joueur;

public abstract class Partisan {
	private Joueur a ;
	private boolean retirer;
	public Partisan(Joueur player) {
		a=player;
	}
	
	public Joueur getJoueur() {return this.a;}
	public boolean getRetirer() {return this.retirer;}

}

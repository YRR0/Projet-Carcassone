package JeuCarcassonne;
import java.util.Iterator;

public class PlateauCarcassonne implements Iterable{
	
	// Taille maximal jouable sur une vraie partie de carcassonne
	private TuileCarcassonne[][] cases;
	boolean[][] partisan;
	
	// Peut être mieux de faire une classe pour gerer les partisans au cas ou il y en aurait plus
	public PlateauCarcassonne(int li, int col) {
		cases = new TuileCarcassonne[li][col];
		partisan = new boolean[li][col];
	}
	
	public int nbLin() {
        return cases.length;
    }

    public int nbCol() {
        return cases[0].length;
    }

	
	public TuileCarcassonne getTuile(int i, int j) {
		return cases[i][j];
	}
	
	// Gestion de verification en plus 
	public void ajouter(TuileCarcassonne t, int i, int j) {
		// Verification de la possibilite d'ajout
		if(t.corresponds(this, i, j)) {
			cases[i][j] = t;
			System.out.println("Ajout reussi dans le plateau ");
		}
		else {
			System.out.println(" Echec de l'ajout depuis plateau ");
		}
	}
	
    public TuileCarcassonne[][] getTuilesPlateauCarcassonne() {
    	return cases;
    }
    
	@Override
	public Iterator<TuileCarcassonne> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}

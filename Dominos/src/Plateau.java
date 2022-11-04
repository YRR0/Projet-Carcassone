import java.util.ArrayList;

public class Plateau {

    Tuile[][] cases; //Peut etre pas une bonne idée

    public Plateau() {
        cases = new Tuile[113][113];
    }

    public int nbLin() {
        return cases.length;
    }

    public int nbCol() {
        return cases[0].length;
    }

    public Tuile getTuile(int i, int j) {
        return cases[i][j];
    }

    public void ajouter(Tuile t, int i, int j) {
        cases[i][j] = t;
    }

}

import java.util.ArrayList;

public class Plateau {

    ArrayList<ArrayList<Tuile>> cases; //Peut etre pas une bonne idée

    public Plateau() {
        cases = new ArrayList<ArrayList<Tuile>>();
    }

    public int nbLin() {
        return cases.size();
    }

    public  int nbCol() {
        return cases.get(0).size();
    }

    public Tuile getTuile(int i, int j) {
        return cases.get(i).get(j);
    }

    public void ajouter(Tuile t, int i, int j) {
        cases.get(i).set(j, t);
    }

}

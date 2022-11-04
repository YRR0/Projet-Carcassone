import java.util.ArrayList;
import java.util.Random;

public class Sac {

    ArrayList<Tuile> tuiles;
    static Random rand = new Random();

    public Sac() {
        tuiles = new ArrayList<Tuile>();
    }

    public boolean estVide() {
        return tuiles.size() == 0;
    }

    public boolean ajouterTuile(Tuile t) {
        for(Tuile tuile : tuiles) {
            if(t.equals(tuiles)) {
                System.out.println("La tuile est déja présente dans le sac");
                return false;
            }
        }
        tuiles.add(t);
        return true;
    }

    public Tuile retirer() {
        if(!estVide()) {
            int index = rand.nextInt(tuiles.size());
            return tuiles.remove(index);
        }
        System.out.println("Le sac est vide !");
        return null;
    }
}
import java.util.ArrayList;
import java.util.Random;

public class Sac {

    ArrayList<Tuile> tuiles;
    static Random rand = new Random();

    public Sac() {
        tuiles = new ArrayList<Tuile>();
    }

    public boolean estVide() {
        return tuiles.size() == 0;
    }

    public boolean ajouterTuile(Tuile t) {
        for(Tuile tuile : tuiles) {
            if(t.equals(tuiles)) {
                System.out.println("La tuile est déja présente dans le sac");
                return false;
            }
        }
        tuiles.add(t);
        return true;
    }

    public Tuile retirer() {
        if(!estVide()) {
            int index = rand.nextInt(tuiles.size());
            return tuiles.remove(index);
        }
        System.out.println("Le sac est vide !");
        return null;
    }
}

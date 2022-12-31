package poo.carcassone.game.components.tuiles;

import poo.carcassone.game.components.Partisan;
import poo.carcassone.game.components.Plateau;

public class Tuile {
    private final Paysage[] cotes;
    private Partisan partisan;
    private int cotePartisan;
    private final boolean bouclier;
    private boolean abbaye;
    private boolean carrefour;


    public Tuile(Paysage c0, Paysage c1, Paysage c2, Paysage c3, boolean bouclier) {
        cotes = new Paysage[4];
        cotes[0] = c0;
        cotes[1] = c1;
        cotes[2] = c2;
        cotes[3] = c3;
        this.bouclier = bouclier;
        abbayeOuCarrefour(); // Pour initialiser les attributs abbaye et carrefour
    }

    private void abbayeOuCarrefour() {
        int nbPres = 0, nbChemins = 0;
        for(Paysage p : cotes) {
            if(p.getClass() == Pres.class) nbPres++;
            else if(p.getClass() == Chemin.class) nbChemins++;
        }
        if(nbPres > 3) abbaye = true;
        else if(nbChemins > 2) carrefour = true;
    }

    public void tourner() { // tourner de 90° dans le sens des aiguilles d'une montre
        Paysage tmp = this.cotes[0];
        this.cotes[0] = this.cotes[3];
        this.cotes[3] = this.cotes[2];
        this.cotes[2] = this.cotes[1];
        this.cotes[1] = tmp;
    }

    public boolean estAbbaye() {
        return abbaye;
    }

    public boolean estCarrefour() {
        return carrefour;
    }

    /**
     * @param cote     le côté où on va poser le partisan 0 est gauche 1 est haut 2 est droite 3 est bas et 4 est au milieu
     * @param partisan le partisan qu'on veut ajouter à la tuile
     */
    public void ajouterPartisan(Partisan partisan, int cote) {
        if(aucunPartisan()) {
            this.partisan = partisan;
            cotePartisan = cote;
        } else {
            System.out.println("La tuile a déja un partisan");
        }

    }

    /**
     *
     * @return true si la tuile a aucun partisan
     */
    private boolean aucunPartisan() {
        return partisan == null;
    }

    public Partisan getPartisan() {
        if(partisan == null) return null;
        return new Partisan(partisan.getCouleur());
    }

    public int getCotePartisan() {
        return cotePartisan;
    }
    public String toString() {
        return cotes[0].toString() + "_" + cotes[1].toString() + "_" + cotes[2].toString() + "_" + cotes[3].toString() + (bouclier?"_b":"");
    }

    public boolean corresponds(Plateau p, int i, int j) {
        if(p.getTuile(i, j) != null) return false; // la case n'est pas vide
        if((i-1 < 0 || p.getTuile(i-1, j) == null) && (i+1 >= p.nbLin() || p.getTuile(i+1, j) == null)
                && (j-1 < 0 || p.getTuile(i, j-1) == null) && (j+1 >= p.nbCol() || p.getTuile(i, j+1) == null)) return false; // il n y a aucune tuile autour
        // Il n'y a pas de correspondance avec les tuiles adjacentes
        if(i-1 > 0 && p.getTuile(i-1, j) != null
                && !p.getTuile(i-1, j).cotes[3].getClass().equals(this.cotes[1].getClass())) {
            return false;
        }
        if(i+1 < p.nbLin() && p.getTuile(i+1, j) != null
                && !p.getTuile(i+1, j).cotes[1].getClass().equals(this.cotes[3].getClass())) {
            return false;
        }
        if(j-1 > 0 && p.getTuile(i, j-1) != null
                && !p.getTuile(i, j-1).cotes[2].getClass().equals(this.cotes[0].getClass())) {
            return false;
        }
        if(j+1 < p.nbCol() && p.getTuile(i, j+1) != null
                && !p.getTuile(i, j+1).cotes[0].getClass().equals(this.cotes[2].getClass())) {
            return false;
        }
        // Tout est bon on peut poser la tuile
        return true;
    }
}

package com.carcassone.game.components;

import com.dominos.game.components.Plateau;

import java.util.Arrays;

public class Tuile {
    private Paysage[] cotes;
    private boolean bouclier;
    private boolean abbaye;
    private boolean carrefour;

    public Tuile(Paysage c0, Paysage c1, Paysage c2, Paysage c3, boolean bouclier) {
        cotes = new Paysage[4];
        cotes[0] = c0;
        cotes[1] = c1;
        cotes[2] = c2;
        cotes[3] = c3;
        this.bouclier = bouclier;
        abbayeOuCarrefour();
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

    public String toString() {
        return cotes[0].toString() + "_" + cotes[1].toString() + "_" + cotes[2].toString() + "_" + cotes[3].toString() + "_" + (bouclier?"b":"");
    }

    public boolean corresponds(Plateau p, int i, int j) {
        if(p.getTuile(i, j) != null) return false; // la case n'est pas vide
        if((i-1 < 0 || p.getTuile(i-1, j) == null) && (i+1 >= p.nbLin() || p.getTuile(i+1, j) == null)
                && (j-1 < 0 || p.getTuile(i, j-1) == null) && (j+1 >= p.nbCol() || p.getTuile(i, j+1) == null)) return false; // il n y a aucune tuile autour
        if(i-1 > 0 && p.getTuile(i-1, j) != null
                && p.getTuile(i-1, j).cotes[3].getClass().equals(this.cotes[1].getClass())) {
            return false;
        }
        if(i+1 < p.nbLin() && p.getTuile(i+1, j) != null
                && p.getTuile(i+1, j).cotes[1].getClass().equals(this.cotes[3].getClass())) {
            return false;
        }
        if(j-1 > 0 && p.getTuile(i, j-1) != null
                && p.getTuile(i, j-1).cotes[2].getClass().equals(this.cotes[0])) {
            return false;
        }
        return j + 1 >= p.nbCol() || p.getTuile(i, j + 1) == null
                || p.getTuile(i, j + 1).cotes[0].getClass().equals(this.cotes[2]);
    }
}

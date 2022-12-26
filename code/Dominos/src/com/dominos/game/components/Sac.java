package com.dominos.game.components;

import java.util.ArrayList;
import java.util.Random;

public class Sac {

    ArrayList<Tuile> tuiles;
    private int capacite;
    static Random rand = new Random();

    public Sac(int capacite) {
        tuiles = new ArrayList<Tuile>();
        this.capacite = capacite;
    }

    public boolean estVide() {
        return tuiles.size() == 0;
    }
    public boolean estPlein() {
        return capacite <= 0;
    }

    public void ajouterTuile(Tuile t) {
        if(capacite > 0) {
            for(Tuile tuile : tuiles) {
                if(t.equals(tuile)) {
                    //System.out.println("La tuile est déja présente dans le sac");
                    return;
                }
            }
            capacite--;
            tuiles.add(t);
        } else {
            System.out.println("Le sac est plein (" + this.tuiles.size() + " tuiles)");
        }

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

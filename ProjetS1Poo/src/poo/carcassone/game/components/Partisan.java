package poo.carcassone.game.components;

import java.io.Serializable;

public class Partisan implements Serializable {

    private final String couleur;
    private int cote;

    public Partisan(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}

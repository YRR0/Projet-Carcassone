package poo.carcassone.game.components;

public class Partisan {

    private final String couleur;
    private int cote;

    public Partisan(String couleur) {
        this.couleur = couleur;
    }

    public String getCouleur() {
        return couleur;
    }
}

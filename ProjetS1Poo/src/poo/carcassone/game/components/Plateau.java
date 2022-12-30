package poo.carcassone.game.components;


import poo.carcassone.game.components.tuiles.Tuile;

public class Plateau {

    Tuile[][] cases;

    public Plateau(int ligne, int col) {
        cases = new Tuile[ligne][col];
    }

    public int nbLin() {
        return cases.length;
    }

    public int nbCol() {
        return cases[0].length;
    }

    private boolean estDansLimites(int i, int j) {
        return (((i >= 0) && i < cases.length) && ((j >= 0) && j < cases[0].length));
    }
    public Tuile getTuile(int i, int j) {
        if(estDansLimites(i, j)) return cases[i][j];
        return null;
    }

    public void ajouter(Tuile t, int i, int j) {
        if(estDansLimites(i, j)) cases[i][j] = t;
    }

}




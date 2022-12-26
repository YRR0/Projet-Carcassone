package com.dominos.game.components;

public class Plateau {

    public Tuile[][] cases;

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

    public void affiche() {
        for(int i = 0; i < cases.length; i++) {
            System.out.print((i+1) + " ".repeat(3 - (int) (Math.log10(i+1) + 1)));
            afficherLigne(i);
        }
        System.out.print("   ");
        for(int i = 0; i < cases[0].length; i++) {
            System.out.print((i+1) + " ".repeat(7 - (int) (Math.log10(i+1) + 1)));
        }
        System.out.println();
    }

    private void afficherLigne(int l) {
        for(int i = 0; i < cases[l].length; i++) {
            System.out.print("_");
            if (cases[l][i] != null) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(cases[l][i].cotes[1][j] + "_");
                }
            } else System.out.print("_".repeat(6));
        }
        System.out.println();

        for(int j = 0; j < 3; j++) {
            System.out.print("   ");
            for (int i = 0; i < cases[l].length; i++) {
                if (cases[l][i] != null) {
                    System.out.print(cases[l][i].cotes[0][j] + "_____");
                    System.out.print(cases[l][i].cotes[2][j]);
                } else {
                    System.out.print("_".repeat(7));
                }
            }
            System.out.println();
        }

        System.out.print("   ");
        for(int i = 0; i < cases[l].length; i++) {
            System.out.print("_");
            if(cases[l][i] != null) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(cases[l][i].cotes[3][j] + "_");
                }
            }
            else System.out.print("_".repeat(6));
        }
        System.out.println();
    }

}




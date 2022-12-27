package com.dominos.game.components;

import java.util.Arrays;
import java.util.Random;

public class Tuile {

    public int[][] cotes = new int[4][3];;
    private static final Random rand = new Random();
    public Tuile() {
        this(genereTab(), genereTab(), genereTab(), genereTab());
    }

    private static int[] genereTab() {
        int[] res = new int[3];
        for(int i = 0; i < 3; i++) {
            res[i] = rand.nextInt(2);
        }
        return res;
    }

    public Tuile(int[] c0, int[] c1, int[] c2, int[] c3) {
        remplirCote(this, 0, c0);
        remplirCote(this, 1, c1);
        remplirCote(this, 2, c2);
        remplirCote(this, 3, c3);
    }

    private void remplirCote(Tuile t, int cote, int[] valeurs) {
        System.arraycopy(valeurs, 0, t.cotes[cote], 0, valeurs.length);
    }

    public void tourner() { // tourner de 90° dans le sens des aiguilles d'une montre
        int[] tmp = this.cotes[0];
        this.cotes[0] = this.cotes[3];
        this.cotes[3] = this.cotes[2];
        this.cotes[2] = this.cotes[1];
        this.cotes[1] = tmp;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(" ");
        for(int i = 0; i < 3; i++) s.append(cotes[1][i]).append("  ");
        s.append("\n");
        for(int i = 0; i < 3; i++) s.append(cotes[0][i]).append("       ").append(cotes[2][i]).append("\n");
        s.append(" ");
        for(int i = 0; i < 3; i++) s.append(cotes[3][i]).append("  ");
        return s.toString();
    }

    public int nbPoints(boolean c0, boolean c1, boolean c2, boolean c3) {
        int res = 0;
        if(c0) {
            for(int i : this.cotes[0]) res += i;
        }
        if(c1) {
            for(int i : this.cotes[1]) res += i;
        }
        if(c2) {
            for(int i : this.cotes[2]) res += i;
        }
        if(c3) {
            for(int i : this.cotes[3]) res += i;
        }
        return res;
    }

    public boolean corresponds(Plateau p, int i, int j) {
        if(p.getTuile(i, j) != null) return false; // la case n'est pas vide
        if((i-1 < 0 || p.getTuile(i-1, j) == null) && (i+1 >= p.nbLin() || p.getTuile(i+1, j) == null)
                && (j-1 < 0 || p.getTuile(i, j-1) == null) && (j+1 >= p.nbCol() || p.getTuile(i, j+1) == null)) return false; // il n y a aucune tuile autour
        if(i-1 > 0 && p.getTuile(i-1, j) != null
                && !Arrays.equals(p.getTuile(i-1, j).cotes[3], this.cotes[1])) {
                    return false;
                }
        if(i+1 < p.nbLin() && p.getTuile(i+1, j) != null
                && !Arrays.equals(p.getTuile(i+1, j).cotes[1], this.cotes[3])) {
                    return false;
                }
        if(j-1 > 0 && p.getTuile(i, j-1) != null
                && !Arrays.equals(p.getTuile(i, j-1).cotes[2], this.cotes[0])) {
                    return false;
                }
        return j + 1 >= p.nbCol() || p.getTuile(i, j + 1) == null
                || Arrays.equals(p.getTuile(i, j + 1).cotes[0], this.cotes[2]);
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Tuile t)) return false;
        if(t.identique(this)) return true;
        t.tourner();
        if(t.identique(this)) {
            t.tourner(); // Pour restaurer la tuile a son orientation avant le test
            t.tourner();
            t.tourner();
            return true;
        }
        t.tourner();
        if(t.identique(this)) {
            t.tourner(); // Pour restaurer la tuile a son orientation avant le test
            t.tourner();
            return true;
        }
        t.tourner();
        if(t.identique(this)) return true;
        t.tourner(); // Pour restaurer la tuile a son orientation avant le test
        return false;
    }

    private boolean identique(Tuile t) {
        return (Arrays.equals(this.cotes[0], t.cotes[0]) && Arrays.equals(this.cotes[1], t.cotes[1])
                && Arrays.equals(this.cotes[2], t.cotes[2]) && Arrays.equals(this.cotes[3], t.cotes[3]));
    }

}




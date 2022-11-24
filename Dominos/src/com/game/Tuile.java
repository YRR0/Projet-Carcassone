package com.game;

import java.util.Arrays;
import java.util.Random;

public class Tuile {

    private int[][] cotes = new int[4][3];;
    private Tuile[] tuilesAdja = new Tuile[4];
    private int id;
    private static int nextid = 0;
    private static Random rand = new Random();
    public Tuile() {
        this(genereTab(), genereTab(), genereTab(), genereTab());
    }

    private static int[] genereTab() {
        int[] res = new int[3];
        for(int i = 0; i < 3; i++) {
            res[i] = rand.nextInt(3);
        }
        return res;
    }

    public Tuile(int[] c0, int[] c1, int[] c2, int[] c3) {
        remplirCote(this, 0, c0);
        remplirCote(this, 1, c1);
        remplirCote(this, 2, c2);
        remplirCote(this, 3, c3);
        this.id = nextid++;
    }

    private void remplirCote(Tuile t, int cote, int[] valeurs) {
        for(int i = 0; i < valeurs.length; i++) {
            t.cotes[cote][i] = valeurs[i];
        }
    }

    public void tourner() { // tourner de 90° dans le sens des aiguilles de la montre
        int[] tmp = this.cotes[0];
        this.cotes[0] = this.cotes[3];
        this.cotes[3] = this.cotes[2];
        this.cotes[2] = this.cotes[1];
        this.cotes[1] = tmp;
    }

    public String toString() {
        String s = "";
        s += " ";
        for(int i = 0; i < 3; i++) s += cotes[1][i] + "  ";
        s += "\n";
        for(int i = 0; i < 3; i++) {
            if(i == 1) s += cotes[0][i] + "  (" + this.id + ")  " + cotes[2][i] + "\n";
            else s += cotes[0][i] + "       " + cotes[2][i] + "\n";
        }
        s += " ";
        for(int i = 0; i < 3; i++) s += cotes[3][i] + "  ";
        s += "\n";
        return s;
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

    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Tuile)) return false;
        Tuile t = (Tuile) o;
        if(t.identique(this)) return true;
        t.tourner();
        if(t.identique(this)) return true;
        t.tourner();
        if(t.identique(this)) return true;
        t.tourner();
        if(t.identique(this)) return true;
        t.tourner(); // Pour restaurer la tuile a son orientation avant le test
        return false;
    }

    private boolean identique(Tuile t) {
        return (Arrays.equals(this.cotes[0], t.cotes[0]) && Arrays.equals(this.cotes[1], t.cotes[1])
                && Arrays.equals(this.cotes[2], t.cotes[2]) && Arrays.equals(this.cotes[3], t.cotes[3]));
    }

    public boolean ajouterBas(Tuile t) {
        if(tuilesAdja[3] != null) {
            System.out.println("la tuile a une tuile adjacente en bas");
            return false;
        }
        if(!Arrays.equals(cotes[3], t.cotes[1])) {
            System.out.println(Arrays.toString(cotes[3]) + " diff de " + Arrays.toString(t.cotes[1]));
            return false;
        }
        tuilesAdja[3] = t;
        return true;
    }

    public boolean ajouterHaut(Tuile t) {
        if(tuilesAdja[1] != null) {
            System.out.println("la tuile a une tuile adjacente en haut");
            return false;
        }
        if(!Arrays.equals(cotes[1], t.cotes[3])) {
            System.out.println(Arrays.toString(cotes[1]) + " diff de " + Arrays.toString(t.cotes[3]));
            return false;
        }
        tuilesAdja[1] = t;
        return true;
    }

    public boolean ajouterDroite(Tuile t) {
        if(tuilesAdja[2] != null) {
            System.out.println("la tuile a une tuile adjacente a la droite");
            return false;
        }
        if(!match(cotes[2], t.cotes[0])) {
            System.out.println(Arrays.toString(cotes[2]) + " diff de " + Arrays.toString(t.cotes[0]));
            return false;
        }
        tuilesAdja[2] = t;
        return true;
    }

    public boolean ajouterGauche(Tuile t) {
        if(tuilesAdja[0] != null) {
            System.out.println("la tuile a une tuile adjacente a gauche");
            return false;
        }
        if(!match(cotes[0], t.cotes[2])) {
            System.out.println(Arrays.toString(cotes[0]) + " diff de " + Arrays.toString(t.cotes[2]));
            return false;
        }
        tuilesAdja[0] = t;
        return true;
    }


    public int getId() {
        return id;
    }

    public Tuile getBas() {
        return tuilesAdja[3];
    }

    public Tuile getHaut() {
        return tuilesAdja[1];
    }

    public Tuile getDroite() {
        return tuilesAdja[2];
    }

    public Tuile getGauche() {
        return tuilesAdja[0];
    }

    private static boolean match(int[] t1, int[] t2) {
        for(int i = 0; i < t1.length; i++) {
            if(t1[i] != t2[i]) return false;
        }
        return true;
    }
}


package poo.carcassone.game.components;

import poo.carcassone.game.components.tuiles.Chemin;
import poo.carcassone.game.components.tuiles.Pres;
import poo.carcassone.game.components.tuiles.Tuile;
import poo.carcassone.game.components.tuiles.Ville;

import java.util.ArrayList;
import java.util.Random;

public class Sac {

    private final ArrayList<Tuile> tuiles;
    private static final Random rand = new Random();

    public Sac() {
        tuiles = new ArrayList<>();
        generate9();
        generate8();
        generate5();
        generate4();
        generate3();
        generate2();
        generate1();
    }

    private void generate9() {
        for(int i = 0; i < 9; i++) {
            Tuile t = new Tuile(new Chemin(), new Pres(), new Pres(), new Chemin(), false);
            tuiles.add(t);
        }
    }

    private void generate8() {
        for(int i = 0; i < 8; i++) {
            Tuile t = new Tuile(new Pres(), new Chemin(), new Pres(), new Chemin(), false);
            tuiles.add(t);
        }
    }

    private void generate5() {
        for(int i = 0; i < 5; i++) {
            Tuile t = new Tuile(new Pres(), new Ville(true), new Pres(), new Pres(), false);
            tuiles.add(t);
        }
    }

    private void generate4() {
        for(int i = 0; i < 4; i++) {
            Tuile t0 = new Tuile(new Chemin(), new Pres(), new Chemin(), new Chemin(), false);
            Tuile t1 = new Tuile(new Pres(), new Pres(), new Pres(), new Pres(), false);
            Tuile t2 = new Tuile(new Chemin(), new Ville(true), new Chemin(), new Pres(), false);
            tuiles.add(t0);
            tuiles.add(t1);
            tuiles.add(t2);
        }
    }

    private void generate3() {
        for(int i = 0; i < 3; i++) {
            Tuile t0 = new Tuile(new Pres(), new Ville(true), new Chemin(), new Chemin(), false);
            Tuile t1 = new Tuile(new Ville(true), new Ville(true), new Chemin(), new Chemin(), false);
            Tuile t2 = new Tuile(new Chemin(), new Ville(true), new Chemin(), new Chemin(), false);
            Tuile t3 = new Tuile(new Ville(false), new Ville(true), new Ville(false), new Pres(), false);
            Tuile t4 = new Tuile(new Ville(true), new Ville(true), new Pres(), new Pres(), false);
            Tuile t5 = new Tuile(new Chemin(), new Ville(true), new Pres(), new Chemin(), false);
            Tuile t6 = new Tuile(new Ville(true), new Pres(), new Ville(true), new Pres(), false);
            tuiles.add(t0);
            tuiles.add(t1);
            tuiles.add(t2);
            tuiles.add(t3);
            tuiles.add(t4);
            tuiles.add(t5);
            tuiles.add(t6);
        }
    }

    private void generate2() {
        for(int i = 0; i < 2; i++) {
            Tuile t0 = new Tuile(new Ville(true), new Ville(true), new Chemin(), new Chemin(), true);
            Tuile t1 = new Tuile(new Pres(), new Ville(true), new Ville(true), new Pres(), false);
            Tuile t2 = new Tuile(new Pres(), new Pres(), new Pres(), new Chemin(), false);
            Tuile t3 = new Tuile(new Ville(false), new Pres(), new Ville(false), new Pres(), true);
            Tuile t4 = new Tuile(new Ville(false), new Ville(true), new Ville(false), new Chemin(), true);
            Tuile t5 = new Tuile(new Ville(true), new Ville(true), new Pres(), new Pres(), true);
            tuiles.add(t0);
            tuiles.add(t1);
            tuiles.add(t2);
            tuiles.add(t3);
            tuiles.add(t4);
            tuiles.add(t5);
        }
    }

    private void generate1() {
        Tuile t0 = new Tuile(new Ville(false), new Ville(true), new Ville(false), new Chemin(), false);
        Tuile t1 = new Tuile(new Ville(false), new Ville(true), new Ville(false), new Pres(), true);
        Tuile t2 = new Tuile(new Ville(false), new Pres(), new Ville(false), new Pres(), false);
        Tuile t3 = new Tuile(new Ville(false), new Ville(false), new Ville(false), new Ville(false), true);
        Tuile t4 = new Tuile(new Chemin(), new Chemin(), new Chemin(), new Chemin(), false);
        tuiles.add(t0);
        tuiles.add(t1);
        tuiles.add(t2);
        tuiles.add(t3);
        tuiles.add(t4);
    }

    public boolean estVide() {
        return tuiles.size() == 0;
    }

    public boolean estPlein() {
        return tuiles.size() == 72;
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

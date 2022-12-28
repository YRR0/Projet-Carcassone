package com.carcassone.game.player;

import com.carcassone.game.components.Plateau;
import com.carcassone.game.components.Sac;
import com.carcassone.game.components.tuiles.Tuile;

public class Joueur {
    public final String nom;
    public final int id;
    private static int nextId = 0;
    private int nbPoints;
    private boolean enJeu;

    public Joueur(String nom) {
        this.nom = nom;
        id = nextId++;
        nbPoints = 0;
        enJeu = true;
    }

    public int getNbPoints() {
        return nbPoints;
    }

    public void abandonner() {
        enJeu = false;
    }

    public Tuile piocher(Sac s) {
        return s.retirer();
    }

    public void tourner(Tuile t, int nbTour) { // Des tours de 90°
        // Calcule de nombre de tour
        int nb = ((nbTour%4) + 4) % 4;
        while(nb > 0) {
            t.tourner();
            nb--;
        }
    }

    public void poser(Plateau p, Tuile t, int i, int j) {
        if(t.corresponds(p, i, j)) {
            p.ajouter(t, i ,j);
        } else {
            System.out.println("Impossible de poser la tuile à (" + i + ", " + j + ")");
        }
    }

    public void gangerPoints(int nbPoints) {
        if(nbPoints > 0) this.nbPoints += nbPoints;
    }

    public String toString() {
        return this.nom;
    }

}

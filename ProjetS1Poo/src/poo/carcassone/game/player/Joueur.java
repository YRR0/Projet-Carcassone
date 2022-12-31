package poo.carcassone.game.player;

import poo.carcassone.game.components.Partisan;
import poo.carcassone.game.components.Plateau;
import poo.carcassone.game.components.Sac;
import poo.carcassone.game.components.tuiles.Tuile;

import java.util.ArrayList;

public class Joueur {
    public final String nom;
    public final int id;
    private static int nextId = 0;
    private int nbPoints;
    private boolean enJeu;
    private ArrayList<Partisan> partisans;
    private Tuile derniereTuile;
    private boolean peutPoserPartisan;

    public Joueur(String nom) {
        this.nom = nom;
        id = nextId++;
        nbPoints = 0;
        enJeu = true;
        initPartisans();
    }

    private void initPartisans() {
        partisans = new ArrayList<>();
        for(int i = 0; i < 10; i++) { // 10 partisans pour chaque joueur
            Partisan p = new Partisan(getCouleur());
            partisans.add(p);
        }
    }

    public String getCouleur() {
        return switch (id) {
            case 0 -> "Bleu";
            case 1 -> "Jaune";
            case 2 -> "Vert";
            case 3 -> "Rouge";
            default -> "Black";
        };
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
            peutPoserPartisan = true;
            derniereTuile = t;
        } else {
            System.out.println("Impossible de poser la tuile à (" + i + ", " + j + ")");
        }
    }

    public boolean poserPartisans(Plateau p, int i, int j, int cote) {
        if(derniereTuile == p.getTuile(i, j) && peutPoserPartisan && partisans.size() > 0) {
            Partisan partisan = partisans.remove(0);
            derniereTuile.ajouterPartisan(partisan, cote);
            peutPoserPartisan = false;
            return true;
        } else {
            if(derniereTuile != p.getTuile(i,j)) {
                System.out.println("Tuile differente");
            } else if(!peutPoserPartisan) {
                System.out.println("Le joueur ne peut pas poser un partisan");
            } else if(partisans.size() == 0) {
                System.out.println("Le joueur n'a pas de partisans à poser");
            }
            System.out.println("Il est possible de poser qu'un seul partisan que " +
                    "sur la derniere tuile qu'on vient de poser avec un nombre limité à 10 partisans");
        }
        return false;
    }

    public void gangerPoints(int nbPoints) {
        if(nbPoints > 0) this.nbPoints += nbPoints;
    }

    public String toString() {
        return this.nom;
    }

}

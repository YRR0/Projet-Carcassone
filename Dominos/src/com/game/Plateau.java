package com.game;

import java.util.ArrayList;

public class Plateau {

    ArrayList<Tuile> tuiles = new ArrayList<Tuile>(); // Tout les endroits ou on peut ajouter une tuile

    public Plateau() {
    }
    public Plateau(Tuile first) {
        tuiles.add(first);
    }

    public boolean ajouter(Tuile t, Tuile in, Cote.cote c) {
        System.out.println("Je suis dans ajouter(tuile, tuile, cote)");
            if (Cote.cote.BAS.equals(c)) {
                System.out.println("Je vais essayer d'ajouter en bas");
                if(in.ajouterBas(t)) {
                    tuiles.add(t);
                    return true;
                };
            } else if (Cote.cote.HAUT.equals(c)) {
                System.out.println("Je vais essayer d'ajouter en haut");
                if(in.ajouterHaut(t)) {
                    tuiles.add(t);
                    return true;
                };
            } else if (Cote.cote.DROITE.equals(c)) {
                System.out.println("Je vais essayer d'ajouter a la droite");
                if(in.ajouterDroite(t)) {
                    tuiles.add(t);
                    return true;
                };
            } else if (Cote.cote.GAUCHE.equals(c)) {
                System.out.println("Je vais essayer d'ajouter a la gauche");
                if(in.ajouterGauche(t)) {
                    tuiles.add(t);
                    return true;
                };
            }
        System.out.println("Pas possible");
        return false;
    }

    public boolean ajouter(Tuile t, int id, Cote.cote c) {
        Tuile in = null;
        for(Tuile tuile: tuiles) {
            if(tuile.getId() == id) {
                System.out.println("J'ai trouvé la tuile d'id " + id);
                in = tuile;
            }
        }
        if(in == null) {
            System.out.println("Pas de tuile d'id " + id);
            return false;
        }
        return ajouter(t, in, c);
    }

    public Tuile getTuile(int id, Cote.cote c) {
        Tuile in = null;
        for(Tuile tuile: tuiles) {
            if(tuile.getId() == id) in = tuile;
        }
        if(in == null) return  null;
        switch (c) {
            case BAS -> {
                return in.getBas();
            }
            case HAUT -> {
                return in.getHaut();
            }
            case DROITE -> {
                return in.getDroite();
            }
            case GAUCHE -> {
                return in.getGauche();
            }
        }
        return null;
    }

    public void afficher() {

    }
}

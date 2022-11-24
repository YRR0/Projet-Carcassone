package com.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Partie {

    private Sac sac;
    private ArrayList<Joueur> joueurs;
    private Plateau plateau;
    private static Scanner scan = new Scanner(System.in);

    public Partie() {
        sac = new Sac(56);
        plateau = new Plateau();
        joueurs = new ArrayList<Joueur>();
        while(!sac.estPlein()) {
            Tuile t = new Tuile();
            sac.ajouterTuile(t);
        }
    }

    public void lancer() {
        System.out.println("Bienvenue dans une partie de Dominos Carrés");
        int nbJoueurs = 0;
        do {
            System.out.print("Donner le nombre de joueurs (2 ou plus): ");
            nbJoueurs = scan.nextInt();
        } while (nbJoueurs < 2);
        scan.nextLine();
        while(nbJoueurs > 0) {
            System.out.print("Donner le nom de joueur " + nbJoueurs + ": ");
            String nom = scan.nextLine();
            Joueur j = new Joueur(nom);
            joueurs.add(j);
            nbJoueurs--;
        }
        Tuile initiale = sac.retirer();
        plateau = new Plateau(initiale);
        System.out.println("Voici le plateau initiale: ");
        System.out.println(initiale);
        while(joueurs.size() > 1 && !sac.estVide()) {
            for(Joueur j : joueurs) {
                System.out.println("C'est à vous " + j.nom + " vous avez " + j.getNbPoints() + " points");
                Tuile t = j.piocher(sac);
                System.out.println("Voici votre tuile");
                System.out.println(t);
                System.out.print("Voulez-vous abandonner?(o/n)");
                String rep = scan.nextLine();
                if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                    j.abandonner();
                    joueurs.remove(j);
                    break;
                }
                do {
                    System.out.print("Voulez-vous passer votre tour?(o/n)");
                    rep = scan.nextLine();
                    if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                        break;
                    }
                    System.out.print("Donner l'id de la tuile ou vous voulez poser votre tuile? ");
                    int id = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Donner le cote ou vous voulez poser votre tuile a cote de la tuile " + id + "? ");
                    String c = scan.nextLine();
                    Cote.cote cote = switch (c.toLowerCase()) {
                        case "gauche" -> Cote.cote.GAUCHE;
                        case "droite" -> Cote.cote.DROITE;
                        case "bas" -> Cote.cote.BAS;
                        case "haut" -> Cote.cote.HAUT;
                        default -> throw new RuntimeException();
                    };
                    scan.nextLine();
                    System.out.print("Voulez-vous tourner votre tuile?(o/n)");
                    rep = scan.nextLine();
                    if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                        System.out.print("Donner le nombre de tours de 90° dans le sens horaire: ");
                        int nbTours = scan.nextInt();
                        j.tourner(t, nbTours);
                        System.out.println(t);
                    }
                    if(plateau.ajouter(t, id, cote)) {
                        boolean c0 = plateau.getTuile(t.getId(), Cote.cote.GAUCHE) == null, c1 = plateau.getTuile(t.getId(), Cote.cote.HAUT) == null,
                                c2 = plateau.getTuile(t.getId(), Cote.cote.DROITE) == null, c3 = plateau.getTuile(t.getId(), Cote.cote.BAS) == null;
                        j.gangerPoints(t.nbPoints(c0, c1, c2, c3));
                    } else {
                        System.out.println("La position n'est pas valide");
                    }
                    scan.nextLine();
                } while(!rep.toLowerCase().equals("o") && !rep.toLowerCase().equals("oui"));

            }
        }
        if(joueurs.size() <= 1) {
            if(joueurs.size() == 0) System.out.println("Tous les joueurs ont abandonnés");
            else System.out.println("Le gangant est " + joueurs.get(0));
        }
        else {
            System.out.println("Le sac est vide");
            Joueur gagnant = joueurs.get(0);
            for(Joueur j : joueurs) {
                if(j.getNbPoints() > gagnant.getNbPoints()) gagnant = j;
            }
            System.out.println("Le gangant est le joueur " + gagnant);
        }
    }


}

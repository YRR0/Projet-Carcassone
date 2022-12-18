package JeuCarcassonne;
import java.util.ArrayList;
import java.util.Scanner;

import Player.Joueur;

public class PartieCarcassonne {
	
	private SacCarcassonne sac;
    private ArrayList<Joueur> joueurs;
    private PlateauCarcassonne plateau;
    private static Scanner scan = new Scanner(System.in);

	
	public PartieCarcassonne(int li , int co) {
		sac = new SacCarcassonne();
		sac.creationTotal();
		//sac.afficherTuile();
		plateau = new PlateauCarcassonne(li,co);
		joueurs = new ArrayList<Joueur>(); 
	}
	
	public void lancer() {
		System.out.println(" Bienvenue dans notre jeu De Carcassonne");
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
        TuileCarcassonne initiale = sac.retirer();
        plateau.ajouter(initiale, 0,0);
        while(joueurs.size() > 1 && !sac.estVide()) {
            for(Joueur j : joueurs) {
                System.out.println("C'est Ã  vous " + j.nom + " vous avez " + j.getNbPoints() + " points");
                System.out.println("Voici le plateau: ");
                //plateau.affiche();
                TuileCarcassonne t = j.piocher(sac);
                System.out.println(" - Voici votre tuile - ");
                t.afficher();
                System.out.print("Voulez-vous abandonner?(o/n)");
                String rep = scan.nextLine();
                if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                    j.abandonner();
                    joueurs.remove(j);
                    break;
                }
                System.out.print("Voulez-vous passer votre tour?(o/n)");
                rep = scan.nextLine();
                if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                    break;
                }
                do {
                    System.out.print("Voulez-vous tourner votre tuile?(o/n)");
                    rep = scan.nextLine();
                    
                    if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui") || rep.equals("o")) {
                        System.out.print("Donner le nombre de tours de 90° dans le sens horaire: ");
                        int nbTours = scan.nextInt();
                        //j.tourner(t, nbTours);
                        System.out.println(t);
                    }
                    System.out.print("Donner le numero de la ligne ou vous voulez poser votre tuile? ");
                    int lin = scan.nextInt();
                    lin -= 1;
                    System.out.print("Donner le numero de la case ou vous voulez poser votre tuile sur la ligne " + (lin+1) + "? ");
                    int col = scan.nextInt();
                    col -= 1;
                    scan.nextLine();
                    
                    if(t.corresponds(plateau, lin, col)) {
                        plateau.ajouter(t, lin, col);
                        //boolean c0 = plateau.getTuile(lin, col-1) == null, c1 = plateau.getTuile(lin-1, col) == null,
                        //        c2 = plateau.getTuile(lin, col+1) == null, c3 = plateau.getTuile(lin+1, col) == null;
                      
                        // Gestion des points
                        //int nbPoints = t.nbPoints(c0, c1, c2, c3);
                        //j.gangerPoints(nbPoints);
                        //System.out.println("Felicitation vous avez gangÃ© " + nbPoints + " milliards d'euros");
                        break;
                    } else {
                        System.out.println("La position n'est pas valide");
                    }
                } while(!rep.toLowerCase().equals("o") && !rep.toLowerCase().equals("oui"));
            }
        }
        if(joueurs.size() <= 1) {
            if(joueurs.size() == 0) System.out.println("Tous les joueurs ont abandonnÃ©s");
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

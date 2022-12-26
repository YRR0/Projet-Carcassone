package com.dominos.game.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.dominos.game.components.Plateau;
import com.dominos.game.components.Sac;
import com.dominos.game.components.Tuile;
import com.dominos.game.player.Joueur;
import com.dominos.game.player.*;


public class TerminalController {

    private Sac sac;
    private ArrayList<Joueur> joueurs;
    private Plateau plateau;
    private static Scanner scan = new Scanner(System.in);

    public TerminalController() {
        sac = new Sac(20);
        plateau = new Plateau(10, 10);
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
           
            System.out.print("Voulez vous que ce joueur soit une intelligene artificiel ? (o/n)");
            String resultat = scan.nextLine();
            if(resultat.equals("o") || resultat.equals("oui") || resultat.equals("O")) {
            System.out.println(" Un des joueurs est une IA ! ");
            JoueurArtificiel jia = new JoueurArtificiel(nom);
            joueurs.add(jia);
            nbJoueurs--;
            }
            else {
            Joueur j = new Joueur(nom);
            joueurs.add(j);
            nbJoueurs--;
            }
        }
        
        Tuile initiale = sac.retirer();
        plateau.ajouter(initiale, plateau.nbLin() / 2, plateau.nbCol() / 2);
      
        while(joueurs.size() > 1 && !sac.estVide()) {
        	
            for(Joueur j : joueurs) {
            	if((j instanceof Joueur ) && !(j instanceof JoueurArtificiel)) {
                System.out.println("C'est à vous " + j.nom + " vous avez " + j.getNbPoints() + " points");
                System.out.println("Voici le plateau: ");
                plateau.affiche();
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
                System.out.print("Voulez-vous passer votre tour?(o/n)");
                rep = scan.nextLine();
                if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                    break;
                }
                
                boolean valide = false;
                int lin=-1,col=-1;
                do {
                    System.out.print("Voulez-vous tourner votre tuile?(o/n)");
                    rep = scan.nextLine();
 
                    do {	
                    try {
                    if(rep.toLowerCase().equals("o") || rep.toLowerCase().equals("oui")) {
                        System.out.print("Donner le nombre de tours de 90° dans le sens horaire: ");
                        int nbTours = scan.nextInt();
                        j.tourner(t, nbTours);
                        System.out.println(t);
                    }
                    System.out.print("Donner le numero de la ligne ou vous voulez poser votre tuile? ");
                    lin = scan.nextInt();
                    lin -= 1;
                    System.out.print("Donner le numero de la case ou vous voulez poser votre tuile sur la ligne " + (lin+1) + "? ");
                    col = scan.nextInt();
                    col -= 1;
                    
                    if(lin>=0 && lin<plateau.nbLin() && col>=0 && col<plateau.nbCol()) valide = true;
                    scan.nextLine();
                    
                    }
                    catch(Exception e) {
                    	System.out.println("Recommencer les coordonnées ne sont pas valides");
                    	 scan.nextLine();
                    }
                    }
                    while(!valide);
                    
                    if(t.corresponds(plateau, lin, col)) {
                        plateau.ajouter(t, lin, col);
                   
                        // Verification pour les points
    					boolean c0=false,c1=false,c2=false,c3=false;
    					if(col-1>0) {
    						c0 = plateau.getTuile(lin, col-1) == null;
    					}
    					if(lin-1>0) {
    						 c1 = plateau.getTuile(lin-1, col) == null;
    					}
    					if(col+1<plateau.cases[lin].length) {
    						c2 = plateau.getTuile(lin, col+1) == null;
    					}
    					if(lin+1<plateau.cases.length) {
    						c3 = plateau.getTuile(lin+1, col) == null;
    					}
    					int nbPoints = t.nbPoints(c0, c1, c2, c3);
                        j.gangerPoints(nbPoints);
                        System.out.println("   Felicitation vous avez gangé " + nbPoints + " milliards d'euros ");
                        break;
                    } else {
                        System.out.println(" La position n'est pas valide ");
                    }
                    
                	} while(!rep.toLowerCase().equals("o") && !rep.toLowerCase().equals("oui"));
            	}
            
            	// Cas du joueur artificiel 
            	else {
            		System.out.println("=> Voici le plateau "); plateau.affiche();
            		
            		if(!sac.estVide()) {
            		Tuile t = sac.retirer();
            		
            		JoueurArtificiel ia = (JoueurArtificiel)j ;
            		boolean jouer = ia.coupPossible(plateau,t);
            		
            		System.out.println("jouer : "+ jouer);
            		System.out.println(" -> Voici la tuile du joueur artificiel " + ia);
            		System.out.println(t);
            		if(jouer) {
            			int li = ia.choix.i;
            			int co = ia.choix.j;
            			int tour = ia.choix.tour;
            			
            			ia.tourner(t, tour);
            			System.out.println("-> Voici la tuile de l'intelligence artifici el apres les tours : "+tour);
            			System.out.println("--> Voici le placement choisi par "+ia.nom +" ligne: "+li + " colonne: "+co);
            			System.out.println(t);
            			System.out.println(" Positionnement " + t.corresponds(plateau, li, co));
            			if(t.corresponds(plateau, li, co)) {
                            plateau.ajouter(t, li, co);
                     
                            // Verification pour les points
        					boolean c0=false,c1=false,c2=false,c3=false;
        					if(co-1>0) {
        						c0 = plateau.getTuile(li, co-1) == null;
        					}
        					if(li-1>0) {
        						 c1 = plateau.getTuile(li-1, co) == null;
        					}
        					if(co+1<plateau.cases[li].length) {
        						c2 = plateau.getTuile(li, co+1) == null;
        					}
        					if(li+1<plateau.cases.length) {
        						c3 = plateau.getTuile(li+1, co) == null;
        					}int nbPoints = t.nbPoints(c0, c1, c2, c3);
                            ia.gangerPoints(nbPoints);
                            System.out.println("Felicitation vous avez gagné " + nbPoints + " points, score de ia est : " + ia.getNbPoints());
                        }
            			else {
            				System.out.println(" L'IA a un problème ");
            			}
            		}
            		else {
            			// On va faire que le joueur Artificiel abandonne s'il ne peut pas placer
            			System.out.println(ia.nom +" abandonne .");
            			joueurs.remove(j);
            		}
            	}
            		
            }
         }
       }
        if(joueurs.size() <= 1) {
            if(joueurs.size() == 0) System.out.println("Tous les joueurs ont abandonnés");
            else System.out.println("Le gagnant est " + joueurs.get(0));
        }
        else {
            System.out.println("Le sac est vide");
            Joueur gagnant = joueurs.get(0);
            for(Joueur j : joueurs) {
                if(j.getNbPoints() > gagnant.getNbPoints()) gagnant = j;
            }
            System.out.println("Le gagnant est le joueur " + gagnant);
        }
    }
}

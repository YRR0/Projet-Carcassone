package poo.carcassone.game.player;

import poo.carcassone.game.components.Plateau;
import poo.carcassone.game.components.tuiles.Tuile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;


public class JoueurArtificiel extends Joueur {
    public Instruction choix;

    public JoueurArtificiel() {
        super("Flatchy " + new Random().nextInt(1000));
    }

    // une classe interner pour garder la meilleure ligne de placement et la meilleure colonne
    public static class Instruction implements Serializable {
        public int i;
        public int j;
        public int tour;
        Instruction(int i , int j,int tour){
            this.i = i; this.j = j; this.tour = tour;
        }
    }

    //Faire une methode boolean pour coupPossible pour tester si sur le terrain, on peut poser notre tuile
    public boolean coupPossible(Plateau p,Tuile a) {
        int nbChoix = 0;
        boolean res = false;
        ArrayList<Instruction> instructions = new ArrayList<>();
        for(int i = 0; i < p.nbLin() ; i++) {
            for(int j = 0 ; j < p.nbCol() ; j++) {

                //Tester les 4 choix si on tourne la tuile
                if(a.corresponds(p, i, j)) {
                    choix = new Instruction(i,j,0);
                    instructions.add(choix);
                    res = true;
                    nbChoix++;
                }

                a.tourner();
                if(a.corresponds(p, i, j)) {
                    choix = new Instruction(i,j,1);
                    instructions.add(choix);
                    res = true;
                    nbChoix++;
                }

                a.tourner();
                if(a.corresponds(p, i, j)) {
                    choix = new Instruction(i,j,2);
                    instructions.add(choix);
                    res = true;
                    nbChoix++;
                }

                a.tourner();
                if(a.corresponds(p, i, j)) {
                    choix = new Instruction(i,j,3);
                    instructions.add(choix);
                    res = true;
                    nbChoix++;
                }
                // Retour de la tuile à sa position de depart
                a.tourner();
            }

        }
        if(instructions.size() != 0) {
            int index = new Random().nextInt(nbChoix);
            choix = instructions.get(index);
            System.out.println("Le meilleur coup est " + choix.tour+" ligne : "+choix.i+ " colonne: "+choix.j );
        }
        return res;
    }

    public int getNbTours() {
        return choix.tour;
    }

    public int getLigne() {
        return choix.i;
    }

    public int getCol() {
        return choix.j;
    }

}


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Partie {

	private Sac sacDeJeu;
	private ArrayList<Joueur> joueurs = new ArrayList<>();
	private Plateau terrain;
	
	public Partie(){
		sacDeJeu = new Sac();
		rempliSac(100);
		terrain = new Plateau();
	}
	
	public void rempliSac(int n) {
		while( n > 0 ) {
			Tuile aj = new Tuile(randTab(),randTab(),randTab(),randTab());
			if(sacDeJeu.ajouterTuile(aj)) n--;
		}
	}
	
	public int[] randTab() {
		Random rand = new Random();
		int i = rand.nextInt(10), j = rand.nextInt(10), k = rand.nextInt(10);
		int[] t = {i,j,k};
		return t;
	}
	
	public void lancer() {
		Scanner cl = new Scanner(System.in);
		System.out.println(" - Combien de Joueurs vous etes ? - ");
		// Faudrait rajouter un truc au cas ou la valeur n'est pas un chiffre
		int nbJoueur = cl.nextInt();
		creationJoueur(nbJoueur);
		
		System.out.println(" - Quelle joueur va commencer ? - ");
		Joueur currentP = debut(cl);
		int ind = currentP.id;
		boolean debut=true;
		
		while( !sacDeJeu.estVide() ) {
			Tuile t = currentP.piocher(sacDeJeu);
			System.out.println("-----------------------------------------");
			System.out.println("Voici la tuile que vous avez piocher " + currentP.nom +" : ");
			System.out.println(t);
			
			System.out.println("De combien de fois voulez vous tourner votre tuile");
			
			currentP.tourner( t , cl.nextInt() );
			
			if(debut) {
				ArrayList<Tuile> inte = new ArrayList<>();
				inte.add(t);
				terrain.cases.add(inte);
				terrain.ajouter(t , 0 , 0);
				debut = false;
			}else {
				// Je suis pas trop sur pour terrain 
				System.out.println(" Ou voulez vous placer votre Tuile : ");
				//System.out.println(" Donner un nombre ");
				//int i = cl.nextInt();
				System.out.println(" Donner un placement ");
				int j = cl.nextInt();
				if(t.corresponds(terrain , 0 , j)){
					System.out.println(" Votre tuile a été posé");
					terrain.ajouter(t, 0 , j);
				}
				else {
					System.out.println(" Cette case est indisponible ");
				}
			}
			System.out.println("--- Voici le terrain ---");
			terrain.afficher();
			System.out.println(" - Voulez vous abandonner ? - (o/n) ");
			cl = new Scanner(System.in);
			if(cl.next().equals("o")) {
				System.out.println("Le joueur " + currentP.nom + " a abandonné");
				joueurs.remove(currentP.id);
			}
			if(restant()) {
				System.out.println( " Fin de partie " );
				break;
			}
			
			ind++;
			if(ind >= joueurs.size()) {
				ind = 0;
			}
			currentP = joueurs.get(ind);
		}
		
		//System.out.println("Voici les scores finaux");
	}
	
	public void creationJoueur( int n ) {
		// je sais pas combien de joeur max peut etre 4
		if( n <= 2 ) {
			System.out.println("Donner le nom du premier Joueur :"); 
			Scanner key = new Scanner(System.in);
			String rep = key.next();
			joueurs.add( new Joueur(rep) );	
			System.out.println("Donner le nom du second Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add( new Joueur(rep) );
			//key.close();
		}
		else if( n == 3) {
			System.out.println("Donner le nom du premier Joueur :"); 
			Scanner key = new Scanner(System.in);
			String rep = key.next();
			joueurs.add( new Joueur(rep) );
			
			System.out.println("Donner le nom du second Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add( new Joueur(rep) );
			
			System.out.println("Donner le nom du troisieme Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add( new Joueur(rep) );
			//key.close();
		}	
		else {
			System.out.println("Donner le nom du premier Joueur :"); 
			Scanner key = new Scanner(System.in);
			String rep = key.next();
			joueurs.add( new Joueur(rep) );
			
			System.out.println("Donner le nom du second Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add( new Joueur(rep) );
			
			System.out.println("Donner le nom du troisieme Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add( new Joueur(rep) );
			
			System.out.println("Donner le nom du quatrième Joueur :"); 
			key = new Scanner(System.in);
			rep = key.next();
			joueurs.add( new Joueur(rep) );
			//key.close();
		}
	}
	
	public Joueur debut(Scanner cl) {
		Joueur premier = null;	
		String name;
		while(premier == null) {
			System.out.println("Quel Joueur va commencer : ");
			cl = new Scanner(System.in);
			name = cl.next();
			for(Joueur j : joueurs) {
				if(j.nom.equals(name)) { // Ici c'est une comparaison de nom
					System.out.println("Le joueur qui commence est : " + j.nom);
					premier = j;
					break;
				}
			}
			if(premier == null) {
				System.out.println("Ce joueur n'est pas present");
			}
		}
		return premier;
	}
	
	public boolean  restant() {
		if(joueurs.size() == 1) {
			System.out.println(joueurs.get(0).nom + " a gagné ");
			return true;
		}
		System.out.println("Il reste ");
		for(Joueur j : joueurs) {
			System.out.print(j.nom + " , ");
		}
		System.out.println();
		return false;
	}
	
}

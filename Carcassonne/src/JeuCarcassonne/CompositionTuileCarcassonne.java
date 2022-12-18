package JeuCarcassonne;
import java.util.EnumSet;

public enum CompositionTuileCarcassonne {
	
	 CHEMINADJACENT(9,"route","route","plaine","plaine",false,false,false),
	 CHEMINADJACENT2AVECMURPLAINE(3,"route","route","mur","plaine",false,false,false),
	 CHEMIN2VILLE2AVECBOUCLIER(2,"ville","ville","route","route",true,false,false),
	 VILLEAVECCHEMIN(1,"ville","ville","ville","route",false,true,false),
	 VILLEAVECBOUCLIERPLAINE(1,"ville","ville","ville","plaine",true,false,false),
	 CHEMIN2VILLE2SANSBOUVLIER(3,"route","route","mur","mur",false,false,false),
	 CHEMIN3MUR1(3,"mur","route","route","route",false,false,false),
	 CHEMINDROITCOTEPLAINE(8,"plaine","route","plaine","route",false,false,false),
	 CHEMIN3PLAINE1AVECFERMETURE(4,"plaine","route","route","route",false,true,false),
	 MUR3PLAINE(5,"plaine","mur","plaine","plaine",false,false,false),
	 MUR2PLAINE2SEPARE(2,"plaine","mur","mur","plaine",false,false,false),
	 VILLEPLAINE(3,"ville","ville","ville","plaine",false,false,false),
	 ABBAYE(4,"plaine","plaine","plaine","plaine",false,false,true),
	 ABBAYEAVECHEMIN(2,"plaine","plaine","plaine","route",false,true,true),
	 VILLELIE2PLAINE2(3,"ville","ville","plaine","plaine",true,false,false),
     VILLEPLAINE2AVECBOUCLIER(2,"ville","plaine","ville","plaine",true,false,false),
	 CHEMINLIEMURPLAINE(4,"route","mur","route","plaine",false,false,false),
	 CHEMINADJAMURPLAINE(3,"route","mur","plaine","route",false,false,false),
	 VILLE2PLAINE2(1,"ville","plaine","ville","plaine",false,false,false),
	 VILLE3CHEMIN1AVECBOUCLIER(2,"ville","ville","ville","route",true,true,false),
	 VILLETOTALAVECBOUCLIER(1,"ville","ville","ville","ville",true,false,false),
	 CHEMINFERME4(1,"route","route","route","route",false,true,false),
	 PLAINE2VILLE(2,"ville","ville","plaine","plaine",true,false,false),
	 MURPLAINEMUR(3,"mur","plaine","mur","plaine",false,false,false);
	
	int number;
	String[] element = new String[4];
	boolean bouclier;
	boolean routeFerme;
	boolean abbaye;
	CompositionTuileCarcassonne(int n,String a ,String b,String c,String d,boolean bouclier, boolean chemin,boolean abbaye) {
		this.number = n;
		this.element[0] = a;this.element[1] = b;this.element[2] = c;this.element[3] = d;
		this.bouclier = bouclier;
		this.routeFerme = chemin;
		this.abbaye = false;
	}
	
	static int compte;
	public static void total() {
		EnumSet.allOf(CompositionTuileCarcassonne.class).forEach( e -> compte+=e.number);
	}
}

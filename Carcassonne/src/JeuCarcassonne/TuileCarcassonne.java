package JeuCarcassonne;

public class TuileCarcassonne {
	
	private String[] cote = new String[4];
	
	private  boolean abbaye; // pour les abbaye
	private  boolean bouclier;
	private  boolean ferme; // pour les routes, verifier si elle continue ou non
	
	public static int nombreTuile = 72;
	
	public TuileCarcassonne() {
		this.completer();
	}
	
	public void rotation() { 
		String tmp = this.cote[0];
		this.cote[0] = this.cote[3];
		this.cote[3] = this.cote[2];
		this.cote[2] = this.cote[1];
		this.cote[1] = tmp;
	}
	
	public void completer() {
	//1
	if(CompositionTuileCarcassonne.ABBAYE.number > 0 && TuileCarcassonne.nombreTuile>0) {
	this.cote[0] = CompositionTuileCarcassonne.ABBAYE.element[0]; this.cote[1] = CompositionTuileCarcassonne.ABBAYE.element[1];
	this.cote[2] = CompositionTuileCarcassonne.ABBAYE.element[2]; this.cote[3] = CompositionTuileCarcassonne.ABBAYE.element[3];
	this.bouclier = CompositionTuileCarcassonne.ABBAYE.bouclier;this.abbaye = CompositionTuileCarcassonne.ABBAYE.bouclier;
	this.ferme = CompositionTuileCarcassonne.ABBAYE.routeFerme;
	nombreTuile--;
	CompositionTuileCarcassonne.ABBAYE.number --; return ;
	}
	//2
	if(CompositionTuileCarcassonne.ABBAYEAVECHEMIN.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.element[0];this.cote[1] = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.element[1];
		this.cote[2] = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.element[2];this.cote[3] = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.element[3];
		this.bouclier = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.bouclier;this.abbaye = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.bouclier;
		this.ferme = CompositionTuileCarcassonne.ABBAYEAVECHEMIN.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.ABBAYEAVECHEMIN.number --; return ;
	}
	//3
	if(CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMIN2VILLE2AVECBOUCLIER.number --; return ;
	}
	//4
	if(CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.number > 0 && TuileCarcassonne.nombreTuile<=72) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMIN2VILLE2SANSBOUVLIER.number --; return ;
	}
	//5
	if(CompositionTuileCarcassonne.CHEMIN3MUR1.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMIN3MUR1.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMIN3MUR1.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMIN3MUR1.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMIN3MUR1.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMIN3MUR1.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMIN3MUR1.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMIN3MUR1.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMIN3MUR1.number --; return ;
	}
	//6
	if(CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMIN3PLAINE1AVECFERMETURE.number --; return ;
	}
	//7
	if(CompositionTuileCarcassonne.CHEMINADJACENT.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMINADJACENT.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMINADJACENT.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMINADJACENT.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMINADJACENT.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMINADJACENT.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMINADJACENT.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMINADJACENT.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMINADJACENT.number --; return ;
	}
	//8
	if(CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMINADJACENT2AVECMURPLAINE.number --; return ;
	}
	//9
	if(CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMINADJAMURPLAINE.number --; return ;
	}
	//10
	if(CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMINDROITCOTEPLAINE.number --; return ;
	}
	//11
	if(CompositionTuileCarcassonne.CHEMINFERME4.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMINFERME4.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMINFERME4.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMINFERME4.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMINFERME4.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMINFERME4.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMINFERME4.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMINFERME4.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMINFERME4.number --; return ;
	}
	//12
	if(CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.CHEMINLIEMURPLAINE.number --; return ;
	}
	//13
	if(CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.element[0];this.cote[1] = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.element[2];this.cote[3] = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.element[3];
		this.bouclier = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.bouclier;this.abbaye = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.bouclier;
		this.ferme = CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.MUR2PLAINE2SEPARE.number --; return ;
	}
	//14
	if(CompositionTuileCarcassonne.MUR3PLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.MUR3PLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.MUR3PLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.MUR3PLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.MUR3PLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.MUR3PLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.MUR3PLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.MUR3PLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.MUR3PLAINE.number --; return ;
	}
	//15
	if(CompositionTuileCarcassonne.MURPLAINEMUR.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.MURPLAINEMUR.element[0];this.cote[1] = CompositionTuileCarcassonne.MURPLAINEMUR.element[1];
		this.cote[2] = CompositionTuileCarcassonne.MURPLAINEMUR.element[2];this.cote[3] = CompositionTuileCarcassonne.MURPLAINEMUR.element[3];
		this.bouclier = CompositionTuileCarcassonne.MURPLAINEMUR.bouclier;this.abbaye = CompositionTuileCarcassonne.MURPLAINEMUR.bouclier;
		this.ferme = CompositionTuileCarcassonne.MURPLAINEMUR.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.MURPLAINEMUR.number --; return ;
	}
	//16
	if(CompositionTuileCarcassonne.PLAINE2VILLE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.PLAINE2VILLE.element[0];this.cote[1] = CompositionTuileCarcassonne.PLAINE2VILLE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.PLAINE2VILLE.element[2];this.cote[3] = CompositionTuileCarcassonne.PLAINE2VILLE.element[3];
		this.bouclier = CompositionTuileCarcassonne.PLAINE2VILLE.bouclier;this.abbaye = CompositionTuileCarcassonne.ABBAYE.bouclier;
		this.ferme = CompositionTuileCarcassonne.PLAINE2VILLE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.PLAINE2VILLE.number --; return ;
	}
	//17
	if(CompositionTuileCarcassonne.VILLE2PLAINE2.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLE2PLAINE2.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLE2PLAINE2.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLE2PLAINE2.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLE2PLAINE2.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLE2PLAINE2.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLE2PLAINE2.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLE2PLAINE2.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLE2PLAINE2.number --; return ;
	}
	//18
	if(CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLE3CHEMIN1AVECBOUCLIER.number --; return ;
	}
	//19
	if(CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLEAVECBOUCLIERPLAINE.number --; return ;
	}
	//20
	if(CompositionTuileCarcassonne.VILLEAVECCHEMIN.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLEAVECCHEMIN.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLEAVECCHEMIN.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLEAVECCHEMIN.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLEAVECCHEMIN.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLEAVECCHEMIN.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLEAVECCHEMIN.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLEAVECCHEMIN.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLEAVECCHEMIN.number --; return ;
	}
	//21
	if(CompositionTuileCarcassonne.VILLELIE2PLAINE2.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLELIE2PLAINE2.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLELIE2PLAINE2.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLELIE2PLAINE2.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLELIE2PLAINE2.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLELIE2PLAINE2.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLELIE2PLAINE2.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLELIE2PLAINE2.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLELIE2PLAINE2.number --; return ;
	}
	//22
	if(CompositionTuileCarcassonne.VILLEPLAINE.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLEPLAINE.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLEPLAINE.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLEPLAINE.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLEPLAINE.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLEPLAINE.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLEPLAINE.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLEPLAINE.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLEPLAINE.number --; return ;
	}
	//23
	if(CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLEPLAINE2AVECBOUCLIER.number --; return ;
	}
	//24
	if(CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.number > 0 && TuileCarcassonne.nombreTuile>0) {
		this.cote[0] = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.element[0];this.cote[1] = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.element[1];
		this.cote[2] = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.element[2];this.cote[3] = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.element[3];
		this.bouclier = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.bouclier;this.abbaye = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.bouclier;
		this.ferme = CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.routeFerme;nombreTuile--;
		CompositionTuileCarcassonne.VILLETOTALAVECBOUCLIER.number --; return ;
	}		
	}
	
	
	private boolean identique(TuileCarcassonne t) {
		return (this.cote[0].equals(t.cote[0])) && this.cote[0].equals(t.cote[0])
                && this.cote[0].equals(t.cote[0]) && this.cote[0].equals(t.cote[0]);
    }

	public boolean corresponds(PlateauCarcassonne p, int i, int j) {
        /*
		if(p.getTuile(i, j) != null) return false; // la case n'est pas vide
        // il n'y a aucune tuile autour
        
        if(i!=1 && j!=1) {
        if((i-1 < 0 || p.getTuile(i-1, j) == null) && (i+1 >= p.nbLin() || p.getTuile(i+1, j) == null)
        && (j-1 < 0 || p.getTuile(i, j-1) == null) && (j+1 >= p.nbCol() || p.getTuile(i, j+1) == null)) {
        	System.out.println("Condition 1");
        	return false; // il n y a aucune tuile autour
        }}
        
        if(i-1 > 0 && p.getTuile(i-1, j) != null
        && !p.getTuile(i, j).getTuile(3).equals(this.getTuile(1))) {
        	System.out.println("Condition 2");
        	return false;
        }
        if(i+1 < p.nbLin() && p.getTuile(i+1, j) != null
        && !p.getTuile(i, j).getTuile(1).equals(this.getTuile(3))) {
        	System.out.println("Condition 3");
        	return false;
        }
        if(j-1 > 0 && p.getTuile(i, j-1) != null
        && !p.getTuile(i, j).getTuile(2).equals(this.getTuile(0))) {
        	System.out.println("Condition 4");
        	return false;
        }
        if(j+1 < p.nbCol() && p.getTuile(i, j+1) != null
        && !p.getTuile(i, j).getTuile(0).equals(this.getTuile(2))) {
        	System.out.println("Condition 5");
        	return false;
        }
        */
        System.out.println(" Reussite de la verification d'ajout ");
        return true;
    }

	public void afficher() {
		System.out.println("-------------------------------");
		System.out.println( "     "+cote[1]+"  ");
		System.out.println(cote[0]+"     "+cote[2]);
		System.out.println("     "+cote[3]+"  ");
		System.out.println(" abbaye : " + this.abbaye);
		System.out.println(" bouclier : " + this.bouclier);
		System.out.println( " route Ferme : " + this.ferme);
		System.out.println("-------------------------------");
	} 
	
	@Override
	public String toString() {
		String f = cote[1]+"\n";f+=cote[0]+"     "+cote[2]+"\n";
		f+=cote[3]; return f;
	}
	
	public String getTuile(int i) {
		return cote[i];
	}
	
	public boolean getAbbaye() {return this.abbaye;}
	public boolean getBouclier() { return this.bouclier;}
	public boolean getRFerme() { return this.ferme;}
	public String[] getCote() {return this.cote;}
}

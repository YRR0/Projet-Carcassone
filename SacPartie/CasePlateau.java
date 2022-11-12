import java.util.Stack;

public class CasePlateau {
	
	private Tuile position ;
	CasePlateau coteHaut , coteGauche , coteDroit , coteBas;
	CasePlateau parc;
	
	private static int max;
	
	public CasePlateau(Tuile a) {
		position = a;
		parc = this;
	}
	
	public CasePlateau(CasePlateau a) {
		position = a.position;
		parc = this;
		if(a.coteHaut != null) coteHaut = a.coteHaut ; //new CasePlateau(a.coteHaut); 
		if(a.coteGauche != null) coteGauche = a.coteGauche; //new CasePlateau(a.coteGauche);
		if(a.coteDroit != null) coteDroit = a.coteDroit; //new CasePlateau(a.coteDroit);
		if(a.coteBas != null) coteBas = a.coteBas; //new CasePlateau(a.coteBas);
	}
	
	
	public static int valSp = 0;
	public void afficherH() {
		Stack<CasePlateau> saveH = parcHaut();
		System.out.println("aff H");
		String space = " ";
		
		//System.out.print(space.repeat(37));
		while(!saveH.isEmpty()) {
			System.out.print(space.repeat(max));
			CasePlateau r = saveH.pop(); 
			r.afficherG();
			r.position.aff();System.out.print("H |");
			r.afficherD();
			System.out.println();
		}
		this.afficherG();
		//System.out.println("Erreur");
		position.aff2();System.err.print("P |");
		this.afficherD();
		System.out.println();
	
		Stack<CasePlateau> saveB = parcBas();
		while(!saveB.isEmpty()) {
			System.out.print(space.repeat(max));
			CasePlateau r = saveB.pop(); 
			r.afficherG();
			r.position.aff();System.out.print("B |");
			r.afficherD();
			System.out.println();
		}	
	}
	
	public void afficherG() {
		Stack<CasePlateau> saveG = parcGauche();
		//System.out.println("aff G");	
		while(!saveG.isEmpty()) {
			CasePlateau r = saveG.pop();
			r.position.aff();System.out.print("G |");
			valSp += r.position.toString().length();
		}
	}
	
	public void afficherD() {
		Stack<CasePlateau> saveD = parcDroit();
		//System.out.println("aff D");
		while(!saveD.isEmpty()) {
			CasePlateau r = saveD.pop();
			r.position.aff();System.out.print("D |");
		}
	}
	
	public void afficherB() {
		Stack<CasePlateau> saveB = parcBas();
		System.out.println();
		//System.out.println("aff B");
		while(!saveB.isEmpty()) {
			CasePlateau r = saveB.pop();
			r.position.aff();System.out.print("B |");
		}
	}
	
	public Stack<CasePlateau> parcHaut(){
		//System.out.println("Stack Haut");
		Stack<CasePlateau> pl = new Stack<>();
		while( parc.coteHaut != null) {
			//System.out.println("push haut");
			pl.push(new CasePlateau(parc.coteHaut));
			parc = parc.coteHaut;
		}
		parc = this;
		return pl;
	}
	
	public Stack<CasePlateau> parcGauche(){
		//System.out.println("Stack Gauche");
		Stack<CasePlateau> pl = new Stack<>();
		
		while( parc.coteGauche != null) {
			//System.out.println("push gauche");
			pl.push(new CasePlateau(parc.coteGauche));
			parc = parc.coteGauche;
		}
		parc = this;
		return pl;
	}
	
	public Stack<CasePlateau> parcDroit(){
		//System.out.println("Stack droit");
		Stack<CasePlateau> pl = new Stack<>();
		while( parc.coteDroit != null) {
			//System.out.println("push droit");
			pl.push(coteDroit);
			parc = parc.coteDroit;
		}
		parc = this;
		return pl;
	}
	public Stack<CasePlateau> parcBas(){
		//System.out.println("Stack Bas");
		Stack<CasePlateau> pl = new Stack<>();
		while( parc.coteBas != null) {
			//System.out.println("push Bas");
			pl.push(coteBas);
			parc = parc.coteBas;
		}
		parc = this;
		return pl;
	}
	
	public void ajoutHaut(Tuile e) {
		if(coteHaut == null) {
			CasePlateau pl = new CasePlateau(e);
			this.coteHaut = pl;
			pl.coteBas = this;
			
			if(coteGauche != null && coteGauche.coteHaut != null) {
				this.coteGauche.coteHaut.coteDroit = pl;
				pl.coteGauche = this.coteGauche.coteHaut;
			}
			if(coteDroit != null && coteDroit.coteHaut != null) {
				this.coteDroit.coteHaut.coteGauche = pl;
				pl.coteDroit = this.coteDroit.coteHaut;
			}
			
		}
		else {
			System.out.println("Il y a deja un element dans cette case");
		}
	}

	public void ajoutGauche(Tuile e) {
		if(coteGauche == null) {
			CasePlateau pl = new CasePlateau(e);
			coteGauche = pl;
			pl.coteDroit = this;
			
			// Faut rajouter une comparaison pour voir que le cote gauche
			max+=40;	
			
			if(coteHaut != null && coteHaut.coteGauche != null) {
				this.coteHaut.coteGauche.coteBas = pl;
				pl.coteHaut = this.coteHaut.coteGauche;
			}
			if(coteBas != null && coteBas.coteGauche != null) {
				this.coteBas.coteGauche.coteHaut = pl;
				pl.coteBas = this.coteBas.coteGauche;
			}
		}
		else {
			System.out.println("Il y a deja un element dans cette case");
		}
	}

	public void ajoutDroit(Tuile e) {
		if(coteDroit == null) {
			CasePlateau pl = new CasePlateau(e);
			coteDroit = pl;
			pl.coteGauche = this;
			
			
			if(coteHaut != null && coteHaut.coteDroit != null) {
				this.coteHaut.coteDroit.coteBas = pl;
				pl.coteHaut = this.coteHaut.coteDroit;
			}
			if(coteBas != null && coteBas.coteDroit != null) {
				this.coteBas.coteDroit.coteHaut = pl;
				pl.coteBas = this.coteBas.coteDroit;
			}
		}
		else {
			System.out.println("Il y a deja un element dans cette case");
		}
	}

	public void ajoutBas(Tuile e) {
		if(coteBas == null) {
			CasePlateau pl = new CasePlateau(e);
			coteBas = pl;
			pl.coteHaut = this;
			
			
			if(coteGauche != null && coteGauche.coteBas != null) {
				this.coteGauche.coteBas.coteDroit = pl;
				pl.coteGauche = this.coteGauche.coteBas;
			}
			if(coteDroit != null && coteDroit.coteBas != null) {
				this.coteDroit.coteBas.coteGauche = pl;
				pl.coteDroit = this.coteDroit.coteBas;
			}
		}
		else {
			System.out.println("Il y a deja un element dans cette case");
		}
	}

	public static void main(String[] args) {
		int[] t1 = {0,0,0};
		int[] t2 = {1,1,1};
		int[] t3 = {2,2,3};
		int [] t4 = {2,2,2};
		
		Tuile tuile = new Tuile(t1,t2,t3,t4);
		Tuile tuile2 = new Tuile(t3,t4,t1,t2);
		Tuile tuile3 = new Tuile(t3,t4,t1,t2);
		Tuile tuile4 = new Tuile(t1,t2,t3,t4);
		Tuile tuile5 = new Tuile(t3,t4,t1,t2);
		Tuile tuile6 = new Tuile(t3,t4,t1,t2);
		Tuile tuile7 = new Tuile(t1,t2,t3,t4);
		Tuile tuile8 = new Tuile(t3,t4,t1,t2);
		Tuile tuile9 = new Tuile(t3,t4,t1,t2);
		Tuile tuile10 = new Tuile(t1,t2,t3,t4);
		Tuile tuile11 = new Tuile(t3,t4,t1,t2);
		Tuile tuile12 = new Tuile(t3,t4,t1,t2);
		Tuile tuile13 = new Tuile(t1,t2,t3,t4);
		Tuile tuile14 = new Tuile(t3,t4,t1,t2);
		Tuile tuile15 = new Tuile(t3,t4,t1,t2);
		Tuile tuile16 = new Tuile(t1,t2,t3,t4);
		Tuile tuile17 = new Tuile(t3,t4,t1,t2);
		Tuile tuile18 = new Tuile(t3,t4,t1,t2);
		
		
		PlateauC plateau = new PlateauC(tuile);
		//plateau.ajoutTuile("h", tuile2);
		plateau.ajoutTuile("h", tuile2);
		//plateau.ajoutTuile("hg", tuile12);
		
		plateau.ajoutTuile("g", tuile14);
		plateau.ajoutTuile("gg", tuile5);
		plateau.ajoutTuile("ggg", tuile15);
		
		plateau.ajoutTuile("d", tuile4);	
		plateau.ajoutTuile("dd", tuile4);	
		
		plateau.ajoutTuile("hd", tuile3);
		plateau.ajoutTuile("b", tuile18);
		plateau.ajoutTuile("bd", tuile11);
		
		plateau.ajoutTuile("bb", tuile16);
		
		
		plateau.ajoutTuile("hh", tuile18);
		plateau.ajoutTuile("hhh", tuile17);
		
		plateau.afficherPlateau();
	}

		
}


public class PlateauC {
	
	public CasePlateau base;
	CasePlateau deplace;
	public PlateauC(Tuile a) {
		base = new CasePlateau(a);
		deplace = base;
	}
	
	public void ajoutTuile(String n, Tuile a) {
		if(n.length()>1) {
			for(int i=0; i<n.length();i++) {
				if(i == n.length()-1 ) {
					System.out.println(n.charAt(i));
					System.out.println(" ---  Final --- ");
					
					if(n.charAt(i)=='h') {
						if(deplace.coteHaut == null) {
							System.out.println("Haut");
							deplace.ajoutHaut(a);
						}
					}
					if(n.charAt(i)=='g') {
							if(deplace.coteGauche == null) {
							System.out.println("Gauche");
							deplace.ajoutGauche(a);
						}
					}
					if(n.charAt(i)=='d') {
						if(deplace.coteDroit == null) {
							System.out.println("Droit");
							deplace.ajoutDroit(a);
						}
					}
					if(n.charAt(i)=='b') {
						if(deplace.coteBas == null) {
							System.out.println("Bas");
							deplace.ajoutBas(a);
						}
					}
					deplace = base;
					break;
				}
				if(deplace(n.charAt(i))) {
					System.out.print(n.charAt(i));
				}
				else {
					System.out.println(" ERREUR ");
					break;
				}
			}	
		}
		else {
			System.out.println(" Ajout first");
			if(n.charAt(0)=='h') {
				base.ajoutHaut(a);
			}
			if(n.charAt(0)=='g') {
				base.ajoutGauche(a);
			}
			if(n.charAt(0)=='d') {
				base.ajoutDroit(a);
			}
			if(n.charAt(0)=='b') {
				base.ajoutBas(a);
			}
		}
		
	}
	
	public boolean deplace(char a) {
		if(a == 'h') {
			if(deplace.coteHaut != null) {
				deplace = deplace.coteHaut;
				return true;
			}
			else {
				System.out.println("- Ce coté haut est vide -");
				return false;
			}
		}
		else if(a == 'g') {
			if(base.coteGauche != null) {
				deplace = deplace.coteGauche;
				return true;
			}
			else {
				System.out.println("- Ce cote gauche est vide -");
				return false;
			}
		}
		else if(a == 'd') {
			if(deplace.coteDroit != null) {
				deplace = deplace.coteDroit;
				return true;
			}
			else {
				System.out.println("Ce coté droit est vide");
				return false;
			}
		}
		else if(a == 'b') {
			if(deplace.coteBas != null) {
				deplace = deplace.coteBas;
				return true;
			}
			else {
				System.out.println("Ce coté bas est vide");
				return false;
			}
		}
		else {
			System.out.println(" * Veuillez choisir une lettre parmi h , g , d , b ! * ");
			return false;
		}
	}
	
	public void afficherPlateau() {
		base.afficherH();
	}

}

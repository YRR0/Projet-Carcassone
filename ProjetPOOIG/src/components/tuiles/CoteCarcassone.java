package components.tuiles;

public class CoteCarcassone extends Cote {
	
	private final Paysage paysage;
	
	public CoteCarcassone(Paysage paysage) {
		this.paysage = paysage;
	}

	@Override
	public boolean corresponds(Cote c) {
		if(!(c instanceof CoteCarcassone c1)) return false;
		return this.paysage.getClass().equals(c1.paysage.getClass());
	}

	public boolean estPres() {
		return paysage.getClass().equals(Pres.class);
	}

	public boolean estChemin() {
		return paysage.getClass().equals(Chemin.class);
	}
	
	@Override
	public String toString() {
		return paysage.toString();
	}

}

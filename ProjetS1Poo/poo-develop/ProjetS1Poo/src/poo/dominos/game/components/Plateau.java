package poo.dominos.game.components;

public class Plateau {

    private Tuile[][] cases;

    public Plateau(int ligne, int col) {
        setCases(new Tuile[ligne][col]);
    }

    public int nbLin() {
        return getCases().length;
    }

    public int nbCol() {
        return getCases()[0].length;
    }

    private boolean estDansLimites(int i, int j) {
        return (((i >= 0) && i < getCases().length) && ((j >= 0) && j < getCases()[0].length));
    }
    public Tuile getTuile(int i, int j) {
        if(estDansLimites(i, j)) return getCases()[i][j];
        return null;
    }

    public void ajouter(Tuile t, int i, int j) {
        if(estDansLimites(i, j)) getCases()[i][j] = t;
    }

    public void affiche() {
        for(int i = 0; i < getCases().length; i++) {
            System.out.print((i+1) + " ".repeat(3 - (int) (Math.log10(i+1) + 1)));
            afficherLigne(i);
        }
        System.out.print("   ");
        for(int i = 0; i < getCases()[0].length; i++) {
            System.out.print((i+1) + " ".repeat(7 - (int) (Math.log10(i+1) + 1)));
        }
        System.out.println();
    }

    private void afficherLigne(int l) {
        for(int i = 0; i < getCases()[l].length; i++) {
            System.out.print("_");
            if (getCases()[l][i] != null) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(getCases()[l][i].cotes[1][j] + "_");
                }
            } else System.out.print("_".repeat(6));
        }
        System.out.println();

        for(int j = 0; j < 3; j++) {
            System.out.print("   ");
            for (int i = 0; i < getCases()[l].length; i++) {
                if (getCases()[l][i] != null) {
                    System.out.print(getCases()[l][i].cotes[0][j] + "_____");
                    System.out.print(getCases()[l][i].cotes[2][j]);
                } else {
                    System.out.print("_".repeat(7));
                }
            }
            System.out.println();
        }

        System.out.print("   ");
        for(int i = 0; i < getCases()[l].length; i++) {
            System.out.print("_");
            if(getCases()[l][i] != null) {
                for(int j = 0; j < 3; j++) {
                    System.out.print(getCases()[l][i].cotes[3][j] + "_");
                }
            }
            else System.out.print("_".repeat(6));
        }
        System.out.println();
    }

	public Tuile[][] getCases() {
		return cases;
	}

	public void setCases(Tuile[][] cases) {
		this.cases = cases;
	}

}




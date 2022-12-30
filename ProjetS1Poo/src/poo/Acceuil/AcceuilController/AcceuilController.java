package poo.Acceuil.AcceuilController;

import poo.Acceuil.AcceuilView.AcceuilGameView;
import poo.Acceuil.AcceuilView.DominoLauncher;
import poo.Acceuil.AcceuilView.PlayerSelectionView;

public class AcceuilController {
	AcceuilGameView acceuil;
	
	public AcceuilController(){
		acceuil = new AcceuilGameView();
		acceuil.getButton1().addActionListener(e -> {
			System.out.println("Demarrage de Dominos");
			new DominoLauncher();
			acceuil.dispose();
		});
		acceuil.getButton2().addActionListener(e->{
			System.out.println("Demarrage de Carcassonne");
			new CarcassonneController();
			acceuil.dispose();
		});
	}
}

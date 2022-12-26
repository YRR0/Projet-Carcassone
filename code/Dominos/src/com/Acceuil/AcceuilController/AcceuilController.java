package com.Acceuil.AcceuilController;

import com.Acceuil.AcceuilView.AcceuilGameView;
import com.Acceuil.AcceuilView.DominoLauncher;

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
		});
	}
}

package poo.Acceuil.AcceuilController;

import poo.Acceuil.AcceuilView.PlayerSelectionView;
import poo.carcassone.game.controller.GameController;

public class CarcassonneController extends DominoControler{
private PlayerSelectionView carcassonneChoice;
	
	public CarcassonneController()  {
		super();
	}
	
	@Override
	public void gestionValidite(int joueurArtificiel, int nombre) {
		dominoChoice.getValidation().addActionListener( e->{
		dominoChoice.setVisible(false);
		
		// Gerer aussi le nombre de joueur artificiel
		if(joueurArtificiel == 0) {
			//Carcassonne
			new GameController(nombre).start();
		}
		else {
			new GameController(nombre).start();
		}
		dominoChoice.dispose();
		});
	}
}

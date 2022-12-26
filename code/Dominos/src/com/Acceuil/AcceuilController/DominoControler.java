package com.Acceuil.AcceuilController;
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;

import com.Acceuil.AcceuilView.PlayerSelectionView;
import com.dominos.game.controller.GameController;

public class DominoControler {
	private PlayerSelectionView dominoChoice;
	
	public DominoControler() {
		dominoChoice = new PlayerSelectionView();
		
		dominoChoice.player2.addActionListener( e -> {
			if(dominoChoice.creation) {
			dominoChoice.message.setVisible(true);
			dominoChoice.scrollPane.setVisible(true); dominoChoice.contenu2.add(dominoChoice.validation);
		    dominoChoice.show();
            dominoChoice.disableOther();
            dominoChoice.nombreJoueur=2;
			}
		});
		dominoChoice.player3.addActionListener( e -> {
			if(dominoChoice.creation) {	
			dominoChoice.listData[3] = "3 IA";
			
			dominoChoice.number.setVisibleRowCount(1);
			dominoChoice.scrollPane = new JScrollPane(dominoChoice.number);
			dominoChoice.contenu2.add(dominoChoice.scrollPane);
	        dominoChoice.message.setVisible(true);
	        dominoChoice.scrollPane.setVisible(true); dominoChoice.contenu2.add(dominoChoice.validation);
	        dominoChoice.show();
	        dominoChoice.disableOther();
	        dominoChoice.nombreJoueur=3;
			}
		});
		dominoChoice.player4.addActionListener( e -> {
			if(dominoChoice.creation) {	
			dominoChoice.listData[3] ="3 IA" ;
			dominoChoice.listData[4] ="4 IA" ;
			dominoChoice.number.setVisibleRowCount(1);
			dominoChoice.scrollPane = new JScrollPane(dominoChoice.number);
			dominoChoice.contenu2.add(dominoChoice.scrollPane);
			dominoChoice.message.setVisible(true);
			dominoChoice.scrollPane.setVisible(true);dominoChoice.contenu2.add(dominoChoice.validation);
			dominoChoice.show();
			dominoChoice.nombreJoueur=4;
			dominoChoice.disableOther();
			}
		});
		
		
		dominoChoice.number.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	if(e.getClickCount()==1) {
		    		int index = dominoChoice.getList().getSelectedIndex();
		    		String item = (String)dominoChoice.getList().getSelectedValue();
		    		
		    		if(!item.equals(" ")) {
		    			int s = 0;
		    			try {
		    			s = Integer.parseInt(item.substring(0, 1));
		    			}
		    			catch(Exception rr) {
		    			  System.out.println("------");
		    			}
		    			dominoChoice.number.setEnabled(false);	
			    		gestionValidite(s,dominoChoice.nombreJoueur);
			    		dominoChoice.getValidation().setEnabled(true);
		    		}
		    	}
		    }
		});
	}
	
	public void gestionValidite(int joueurArtificiel, int nombre) {
		dominoChoice.getValidation().addActionListener( e->{
		dominoChoice.setVisible(false);
		
		// Gerer aussi le nombre de joueur artificiel
		if(joueurArtificiel == 0) {
			new GameController(nombre,0).start();
		}
		else {
			new GameController(nombre,joueurArtificiel).start();
		}
		dominoChoice.dispose();
		});
	}
}

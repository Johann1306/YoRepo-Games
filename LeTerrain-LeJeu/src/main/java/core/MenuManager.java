package core;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import front.MainFrame;
import modele.item.personnage.PersoNom;

public class MenuManager extends JMenuBar implements Serializable {

	private static final long serialVersionUID = 1L;
	private static JMenu action;
	
	public void initialise() {
		
		JMenu menuFichier = new JMenu("Fichier");
		JMenuItem menuStart = new JMenuItem("Demarrer une nouvelle partie");
		JMenuItem menuCharger = new JMenuItem("Charger la derniere partie sauvegardee");
		JMenuItem menuSauvegarder = new JMenuItem("Sauvegarder la partie en cours");
		JMenuItem menuQuitter = new JMenuItem("Quitter");
		action = new JMenu("Action...");
		JMenu aller = new JMenu("Aller...");
		JMenu chezJohann = new JMenu("chez Johann...");
		JMenuItem piedJohann = new JMenuItem("à pied."); piedJohann.setVisible(false);
		JMenu chezNicolas = new JMenu("chez Nicolas...");
		JMenuItem piedNicolas = new JMenuItem("à pied.");
		JMenu chezPierre = new JMenu("chez Pierre...");
		JMenuItem piedPierre = new JMenuItem("à pied.");
		JMenu chezThomas = new JMenu("chez Thomas...");
		JMenuItem piedThomas = new JMenuItem("à pied.");
		JMenu chezYannick = new JMenu("chez Yannick...");
		JMenuItem piedYannick = new JMenuItem("à pied.");
		this.add(menuFichier);
			menuFichier.add(menuStart);
			menuFichier.add(menuCharger);
			menuFichier.add(menuSauvegarder);
			menuFichier.add(menuQuitter);
		this.add(action);
			action.add(aller);
			aller.add(chezJohann);
				chezJohann.add(piedJohann);
			aller.add(chezNicolas);
				chezNicolas.add(piedNicolas);
			aller.add(chezPierre);
				chezPierre.add(piedPierre);
			aller.add(chezThomas);
				chezThomas.add(piedThomas);
			aller.add(chezYannick);
				chezYannick.add(piedYannick);
				
		// TODO : 1er refresh
//		lanceRefreshMenu();

	}
	
	public static void lanceRefreshMenu() {
		JPanel panelShowing = MainFrame.getPanelCentre().getPanelShowing();
		if (panelShowing.getName().toLowerCase().contains(PersoNom.JOHANN.name().toLowerCase())) {
			action.setForeground(Color.BLUE);
			// add missions dispo pour le perso
			action.removeAll();
		} else if (panelShowing.getName().toLowerCase().contains(PersoNom.PIERRE.name().toLowerCase())) {
			action.setForeground(Color.GREEN);			
		} else if (panelShowing.getName().toLowerCase().contains(PersoNom.THOMAS.name().toLowerCase())) {
			action.setForeground(Color.RED);			
		} else if (panelShowing.getName().toLowerCase().contains(PersoNom.YANNICK.name().toLowerCase())) {
			action.setForeground(Color.MAGENTA);			
		} else if (panelShowing.getName().toLowerCase().contains(PersoNom.NICOLAS.name().toLowerCase())) {
			action.setForeground(Color.YELLOW);			
		} else if (panelShowing.getName().toLowerCase().contains(PersoNom.GROUPE.name().toLowerCase())) {
			action.setForeground(Color.WHITE);
		}
		
	}
	
}

package core;

import java.awt.Color;
import java.io.Serializable;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import front.MainFrame;
import modele.item.personnage.PersoPrenom;

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
		JMenuItem piedJohann = new JMenuItem("a pied."); piedJohann.setVisible(false);
		JMenu chezNicolas = new JMenu("chez Nicolas...");
		JMenuItem piedNicolas = new JMenuItem("a pied.");
		JMenu chezPierre = new JMenu("chez Pierre...");
		JMenuItem piedPierre = new JMenuItem("a pied.");
		JMenu chezThomas = new JMenu("chez Thomas...");
		JMenuItem piedThomas = new JMenuItem("a pied.");
		JMenu chezYannick = new JMenu("chez Yannick...");
		JMenuItem piedYannick = new JMenuItem("a pied.");
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
		if (panelShowing.getName().contains(PersoPrenom.JOHANN.name())) {
			action.setForeground(Color.BLUE);
			// add missions dispo pour le perso
//			action.removeAll();
		} else if (panelShowing.getName().contains(PersoPrenom.PIERRE.name())) {
			action.setForeground(Color.GREEN);			
		} else if (panelShowing.getName().contains(PersoPrenom.THOMAS.name())) {
			action.setForeground(Color.RED);			
		} else if (panelShowing.getName().contains(PersoPrenom.YANNICK.name())) {
			action.setForeground(Color.MAGENTA);			
		} else if (panelShowing.getName().contains(PersoPrenom.NICOLAS.name())) {
			action.setForeground(Color.YELLOW);		
		} else if (panelShowing.getName().contains(PersoPrenom.ALI.name())) {
			action.setForeground(Color.PINK);		
		} else if (panelShowing.getName().contains(PersoPrenom.GUILLAUME.name())) {
			action.setForeground(Color.ORANGE);		
		} else if (panelShowing.getName().contains(PersoPrenom.JONATHAN.name())) {
			action.setForeground(Color.CYAN);		
		} else if (panelShowing.getName().contains(PersoPrenom.GROUPE.name())) {
			action.setForeground(Color.WHITE);
		}
		
	}
	
}

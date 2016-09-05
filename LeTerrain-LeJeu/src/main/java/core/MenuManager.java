package core;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import modele.item.mission.Mission;
import modele.item.personnage.PersoPrenom;

public class MenuManager extends JMenuBar implements Serializable {

	private static final long serialVersionUID = 1L;
	private JMenu action;
	
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
		
		menuStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mainFrame = new MainFrame();
				MenuPrincipal.setMainFrame(mainFrame);
				mainFrame.startMainFrame();
			}
		});
		
		menuCharger.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame load = SauvegardeManager.load();
				MenuPrincipal.setMainFrame(load);
				load.startMainFrame();
			}
		});
		
		menuSauvegarder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SauvegardeManager.save();
			}
		});
		
		menuQuitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int reponse = JOptionPane.showOptionDialog(getParent(), "N'oublie pas de sauvegarder avant de quitter batard!", "Attention jeune puceau", 0, 0, null, new String[] { "Sauvegarder", "Quitter" }, "defaut");
				System.out.println(reponse);
				if (reponse == 0) {
					SauvegardeManager.save();
				}
				FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
				fenetrePrincipal.show();
				// Bloquer la MainFrame
				MenuPrincipal.getMainFrame().disable();
			}
		});
		
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
	
	public void lanceRefreshMenu() {
		JPanel panelShowing = MainFrame.getPanelCentre().getPanelShowing();
		if (panelShowing.getName().contains(PersoPrenom.JOHANN.name())) {
			action.setForeground(Color.BLUE);
			refreshMenuParPerso(action, PersoPrenom.JOHANN);
		} else if (panelShowing.getName().contains(PersoPrenom.PIERRE.name())) {
			action.setForeground(Color.GREEN);		
			refreshMenuParPerso(action, PersoPrenom.PIERRE);
		} else if (panelShowing.getName().contains(PersoPrenom.THOMAS.name())) {
			action.setForeground(Color.RED);			
			refreshMenuParPerso(action, PersoPrenom.THOMAS);
		} else if (panelShowing.getName().contains(PersoPrenom.YANNICK.name())) {
			action.setForeground(Color.MAGENTA);			
			refreshMenuParPerso(action, PersoPrenom.YANNICK);
		} else if (panelShowing.getName().contains(PersoPrenom.NICOLAS.name())) {
			action.setForeground(Color.YELLOW);		
			refreshMenuParPerso(action, PersoPrenom.NICOLAS);
		} else if (panelShowing.getName().contains(PersoPrenom.ALI.name())) {
			action.setForeground(Color.PINK);		
			refreshMenuParPerso(action, PersoPrenom.ALI);
		} else if (panelShowing.getName().contains(PersoPrenom.GUILLAUME.name())) {
			action.setForeground(Color.ORANGE);		
			refreshMenuParPerso(action, PersoPrenom.GUILLAUME);
		} else if (panelShowing.getName().contains(PersoPrenom.JONATHAN.name())) {
			action.setForeground(Color.CYAN);		
			refreshMenuParPerso(action, PersoPrenom.JONATHAN);
		} else if (panelShowing.getName().contains(PersoPrenom.GROUPE.name())) {
			action.setForeground(Color.WHITE);
			refreshMenuParPerso(action, PersoPrenom.GROUPE);
		}
		
	}

	private void refreshMenuParPerso(JMenu action, PersoPrenom persoPrenom) {
		JMenu menu = new JMenu("Missions");
		// TODO : eviter le removeAll()
		action.removeAll();
		MissionManager missionManager = MenuPrincipal.getMainFrame().getCoreManager().getMissionManager();
		List<Mission> missionsByPerso = missionManager.getMissionsByPerso(persoPrenom);
		if (!missionsByPerso.isEmpty()) {
			for (Mission mission : missionsByPerso) {
				JMenuItem item = new JMenuItem(mission.getNom());
				item.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						missionManager.lanceMission(mission);
					}
				});
				menu.add(item);
			}
			action.add(menu);
//			action.addActionListener(new ActionListener() {
//				
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					MenuManager.refreshMenuParPerso(action, persoPrenom);
//				}
//			});
		}
	}
}

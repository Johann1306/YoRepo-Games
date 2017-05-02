package core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import front.PanelCentre;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;

public class MenuManager extends JMenuBar implements Serializable {

	private static final long serialVersionUID = 1L;
//	private JMenu action;
	private JMenu menuFichePerso;
	private boolean premiereFois = true;
	
	public void initialise() {

		JMenu menuFichier = new JMenu("Fichier");
		JMenu menuStart = new JMenu("Demarrer une nouvelle partie");
		JMenuItem menuFacile = new JMenuItem(Difficulte.FACILE.name());
		JMenuItem menuNormal = new JMenuItem(Difficulte.NORMAL.name());
		JMenuItem menuDifficile = new JMenuItem(Difficulte.DIFFICILE.name());
		JMenuItem menuHeroique = new JMenuItem(Difficulte.HEROIQUE.name());
		JMenuItem menuCharger = new JMenuItem("Charger la derniere partie sauvegardee");
		JMenuItem menuSauvegarder = new JMenuItem("Sauvegarder la partie en cours");
		JMenuItem menuQuitter = new JMenuItem("Quitter");
		menuFichePerso = new JMenu("Fiche Perso");
		//action = new JMenu("Action...");
		
		// TODO Fiche perso uniquement pour les persos deja presentes
		if (!premiereFois) {
			refreshMenuFichePerso();
			premiereFois = false;
		}

//		menuFacile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
//				if (oldMainFrame != null) {
//					oldMainFrame.dispose();
//				}
//				VideoManager.hideAndStop();
//				MainFrame mainFrame = new MainFrame(Difficulte.FACILE);
//				MenuPrincipal.setMainFrame(mainFrame);
//				mainFrame.startMainFrame();
//			}
//		});
//
//		menuNormal.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
//				if (oldMainFrame != null) {
//					oldMainFrame.dispose();
//				}
//				VideoManager.hideAndStop();
//				MainFrame mainFrame = new MainFrame(Difficulte.NORMAL);
//				MenuPrincipal.setMainFrame(mainFrame);
//				mainFrame.startMainFrame();
//			}
//		});
//
//		menuDifficile.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
//				if (oldMainFrame != null) {
//					oldMainFrame.dispose();
//				}
//				VideoManager.hideAndStop();
//				MainFrame mainFrame = new MainFrame(Difficulte.DIFFICILE);
//				MenuPrincipal.setMainFrame(mainFrame);
//				mainFrame.startMainFrame();
//			}
//		});
//
//		menuHeroique.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
//				if (oldMainFrame != null) {
//					oldMainFrame.dispose();
//				}
//				VideoManager.hideAndStop();
//				MainFrame mainFrame = new MainFrame(Difficulte.HEROIQUE);
//				MenuPrincipal.setMainFrame(mainFrame);
//				mainFrame.startMainFrame();
//			}
//		});

		menuCharger.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame oldMainFrame = MenuPrincipal.getMainFrame();
				if (oldMainFrame != null) {
					oldMainFrame.dispose();
				}
				MainFrame load = SauvegardeManager.load();
				MenuPrincipal.setMainFrame(load);
				load.startMainFrame();
				MainFrame.getPanelPersonnage().refreshArriveePersonnage();
				MainFrame.getPanelPersonnage().refreshMortsPersonnage();
				JOptionPane.showMessageDialog(menuCharger.getParent().getParent(), "Chargement Réussi!");
			}
		});

		menuSauvegarder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SauvegardeManager.save();
				JOptionPane.showMessageDialog(menuCharger.getParent().getParent(), "Sauvegarde Réussie!");
			}
		});

		menuQuitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int reponse = JOptionPane.showOptionDialog(getParent(),
						"N'oublie pas de sauvegarder avant de quitter batard!", "Attention jeune puceau", 0, 0, null,
						new String[] { "Sauvegarder", "Quitter" }, "defaut");
				System.out.println(reponse);
				if (reponse == 0) {
					SauvegardeManager.save();
				} else if (reponse == 1) {
					FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
					fenetrePrincipal.setVisible(true);
					FenetrePrincipal.joueMusiquesAmbiances();

					// TODO : supprimer le panelVideo et la MainFrame (probleme de memoire)
					MenuPrincipal.getMainFrame().dispose();
					VideoManager.hideAndStop();
				}
			}
		});

		this.add(menuFichier);
		menuStart.add(menuFacile);
		menuStart.add(menuNormal);
		menuStart.add(menuDifficile);
		menuStart.add(menuHeroique);
		menuFichier.add(menuStart);
		menuFichier.add(menuCharger);
		menuFichier.add(menuSauvegarder);
		menuFichier.add(menuQuitter);
//		this.add(action);
		this.add(menuFichePerso);
//		action.add(aller);
//		aller.add(chezJohann);
//		chezJohann.add(piedJohann);
//		aller.add(chezNicolas);
//		chezNicolas.add(piedNicolas);
//		aller.add(chezPierre);
//		chezPierre.add(piedPierre);
//		aller.add(chezThomas);
//		chezThomas.add(piedThomas);
//		aller.add(chezYannick);
//		chezYannick.add(piedYannick);

		// TODO : 1er refresh
		// lanceRefreshMenu();

	}

	private void refreshMenuFichePerso() {
		menuFichePerso.removeAll();
		List<PersonnagePrincipal> persosDejaPresentes = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoDejaPresentes();
		
		for (PersonnagePrincipal perso : persosDejaPresentes) {
			JMenuItem item = new JMenuItem("Fiche de " + perso.getPrenom());
			item.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					PanelCentre panelCentre = MainFrame.getPanelCentre();
					panelCentre.afficheFichePerso(perso.getPrenom());
				}
			});
			menuFichePerso.add(item);
		}
	}

	public void lanceRefreshMenu() {
		refreshMenuFichePerso();

//		JLayeredPane panelShowing = MainFrame.getPanelCentre().getPanelShowing();
//		if (panelShowing.getName().contains(PersoPrenom.Johann.name())) {
//			action.setForeground(Color.BLUE);
//			refreshMenuParPerso(action, PersoPrenom.Johann);
//		} else if (panelShowing.getName().contains(PersoPrenom.Pierre.name())) {
//			action.setForeground(Color.GREEN);
//			refreshMenuParPerso(action, PersoPrenom.Pierre);
//		} else if (panelShowing.getName().contains(PersoPrenom.Thomas.name())) {
//			action.setForeground(Color.RED);
//			refreshMenuParPerso(action, PersoPrenom.Thomas);
//		} else if (panelShowing.getName().contains(PersoPrenom.Yannick.name())) {
//			action.setForeground(Color.MAGENTA);
//			refreshMenuParPerso(action, PersoPrenom.Yannick);
//		} else if (panelShowing.getName().contains(PersoPrenom.Nicolas.name())) {
//			action.setForeground(Color.YELLOW);
//			refreshMenuParPerso(action, PersoPrenom.Nicolas);
//		} else if (panelShowing.getName().contains(PersoPrenom.Ali.name())) {
//			action.setForeground(Color.PINK);
//			refreshMenuParPerso(action, PersoPrenom.Ali);
//		} else if (panelShowing.getName().contains(PersoPrenom.Guillaume.name())) {
//			action.setForeground(Color.ORANGE);
//			refreshMenuParPerso(action, PersoPrenom.Guillaume);
//		} else if (panelShowing.getName().contains(PersoPrenom.Jonathan.name())) {
//			action.setForeground(Color.CYAN);
//			refreshMenuParPerso(action, PersoPrenom.Jonathan);
//		} else if (panelShowing.getName().contains(PersoPrenom.GROUPE.name())) {
//			action.setForeground(Color.WHITE);
//			refreshMenuParPerso(action, PersoPrenom.GROUPE);
//		}
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
		}
	}
}

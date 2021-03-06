package front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.DateManager;
import core.ImageManager;
import core.MissionManager;
import core.MusiqueManager;
import core.configuration.Constante;
import modele.evenement.Evenement;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;

public class PanelHaut extends JPanel {

	private JLabel labelDate = null;
	
	public JLabel getLabelDate() {
		return labelDate;
	}

	public void generePanelHaut() {

		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxlayout);
		
		// bouton info
		
		// TODO faire mieux qu'un thread toute les seconde => refresh du label seulement quand on gagne de l'argent
		// label Argent du groupe
		int argent = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getBourse();
		JLabel labelArgent = new JLabel("Bourse : " + argent + " Francs");
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(1000);
						int argent = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getBourse();
						labelArgent.setText("Bourse : " + argent + " Francs");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if (!t1.isAlive()) {
			t1.start();
		}
		
		// label temps passe dans le jeu
//		JLabel labelTempsPasseDansLeJeu = new JLabel("0");
//		labelTempsPasseDansLeJeu.setFont(Constante.ZELDA_FONT);
//		long currentTimeMillis = System.currentTimeMillis();
//		long debutTimeMillis = currentTimeMillis;
//		Date timer = new Date(currentTimeMillis - debutTimeMillis);
//		Thread t = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				try {
//					while(true) {
//						Thread.sleep(1000);
//						long currentTimeMillis = System.currentTimeMillis();
//						timer.setTime(currentTimeMillis - debutTimeMillis);
//						String jours = null;
//						if ((timer.getDate()-1) >=2) {
//							jours = "jours";
//						} else {
//							jours = "jour";
//						}
//						int heure = timer.getHours()-1;
//						String heures = Integer.toString(heure);
//						if (heure<10) {
//							heures = "0" + heures;
//						}
//						int minute = timer.getMinutes();
//						String minutes = Integer.toString(minute);
//						if (minute<10) {
//							minutes = "0" + minutes;
//						}
//						int seconde = timer.getSeconds();
//						String secondes = Integer.toString(seconde);
//						if (seconde<10) {
//							secondes = "0" + secondes;
//						}
//						String text = timer.getDate()-1 + " " + jours + ", " + heures + ":" + minutes + ":" + secondes;
//						labelTempsPasseDansLeJeu.setText(text);
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//		if (!t.isAlive()) {
//			t.start();
//		}

		// label avancement du jeu
		JLabel labelAvancement = new JLabel(" 0 / 1000 ");
		
		// label Difficulte
		Difficulte difficultePartie = MenuPrincipal.getMainFrame().getCoreManager().getDifficultePartie();
		JLabel labelDifficulte = new JLabel(difficultePartie.name());
		
		if (difficultePartie == Difficulte.FACILE) {
			labelDifficulte.setForeground(Color.GREEN);
			labelAvancement.setForeground(Color.GREEN);
		} else if (difficultePartie == Difficulte.NORMAL) {
			labelDifficulte.setForeground(Color.BLUE);
			labelAvancement.setForeground(Color.BLUE);
		} else if (difficultePartie == Difficulte.DIFFICILE) {
			labelDifficulte.setForeground(Color.RED);
			labelAvancement.setForeground(Color.RED);
		} else if (difficultePartie == Difficulte.HEROIQUE) {
			labelDifficulte.setForeground(Color.MAGENTA);
			labelAvancement.setForeground(Color.MAGENTA);
		} 
		
		
		// date
		JPanel panelDate = new JPanel();
		panelDate.setBackground(Color.BLACK);
		labelDate = new JLabel(MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCouranteFormateeUpperCase());
		MissionManager missionManager = MenuPrincipal.getMainFrame().getCoreManager().getMissionManager();
	
		// heure / tranche horaire
		
		
		// bouton passer
		JButton boutonPasserNext = new JButton(Constante.SYMBOLE_PASSER_NEXT);
		boutonPasserNext.setToolTipText("Avance jusqu'au prochain evenement");
		JButton boutonPasser = new JButton(Constante.SYMBOLE_PASSER_1H);
		boutonPasser.setToolTipText("Avance dans le temps de une heure");
		boutonPasser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MusiqueManager.stopAll();
				
				// Raffraichissement bouton passer Next
				// TODO : probleme passe toujours dans le else
				if (MenuPrincipal.getMainFrame().getCoreManager().getEvenementManager().getEvenementsIndisponibles().isEmpty() && missionManager.getMissionsNonPresentees().isEmpty()) {
					boutonPasserNext.setEnabled(false);
				} else {
					boutonPasserNext.setEnabled(true);
				}
				
				DateManager dateManager = MenuPrincipal.getMainFrame().getCoreManager().getDateManager();
				dateManager.passeUneHeure();
				
				if (dateManager.getDateCourante().getHours() == 22) {
					// dodo a 22h

					// TODO NUIT (regen vie/mana et perte bouclier/charge)
					MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().regenerationNuit();
					
					MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager();
					MusiqueManager.playSonEvenement("musique/dodo/310-SecretOfMana-close-your-eyelids.mp3");
					ImageIcon resizeImageNuit = ImageManager.resizeImage(FenetrePrincipal.getImageIcon("image/defaut/defautItemNuit.png"), Constante.PERSO_IMAGE_DIMENSION_180_180);
					JLabel messageLabel = new JLabel("Bonne nuit les petits");
					messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(), messageLabel, "C'est l'heure de faire dodo", 0, resizeImageNuit);
					while (dateManager.getDateCourante().getHours() != 7) {
						dateManager.passeUneHeure();						
					}
					
					// TODO Gestion Missions quotidiennes ??
					
					MenuPrincipal.getMainFrame().getCoreManager().getMusiqueManager();
					// Reveil a 7h
					MusiqueManager.playSonEvenement("musique/reveil/32-Zelda-hyrule-field-morning-theme.mp3");
					ImageIcon resizeImageJour = ImageManager.resizeImage(FenetrePrincipal.getImageIcon("image/defaut/defautItemJour.png"), Constante.PERSO_IMAGE_DIMENSION_180_180);
					JLabel messageLabel2 = new JLabel("Bonjour madame");
					messageLabel2.setFont(Constante.MARIO_FONT_MENU_3);
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(), messageLabel2, "C'est l'heure de se reveiller", 0, resizeImageJour);
				}
				
				int score = MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().calculeScoreFinal();
				labelAvancement.setText(" "+ score + " / 1000 ");

				// Refresh du panel du perso courant
				MainFrame.getPanelBas().refreshPanelBasByPerso(MainFrame.getPanelCentre().getPanelShowing().getName());
				MainFrame.getPanelPersonnage().refreshMortsPersonnage();
				missionManager.refreshMissionsAPresenter();
			}
		});

		// bouton passer jusqu'au prochain evenement ou la prochaine mission
		boutonPasserNext.addActionListener(new ActionListener() {
			
			// TODO : gestion de la fin des evenements et des missions
			@Override
			public void actionPerformed(ActionEvent e) {
				
				MusiqueManager.stopAll();
				
				// Si il n'y a plus d'evenement et de mission, on grise le passage rapide
				if (MenuPrincipal.getMainFrame().getCoreManager().getEvenementManager().getEvenementsIndisponibles().isEmpty() && missionManager.getMissionsNonPresentees().isEmpty()) {
					boutonPasserNext.setEnabled(false);
					System.out.println("Fin des evenements et des missions a presenter");
					
				// Sinon on passe jusqu'au prochain evenement ou la prochaine mission
				} else {
					Evenement nextEvenement = MenuPrincipal.getMainFrame().getCoreManager().getEvenementManager().getNextEvenement();
					
					Mission nextMission = missionManager.getNextMissionAvecDateEtItemsDisponibles();
					boutonPasserNext.setEnabled(false);
					boolean evenementBloquant = false;
					if (nextMission == null && nextEvenement != null) {
						System.out.println("Fin des missions avec date");
						while (!nextEvenement.estDisponibleAPresenter() && evenementBloquant == false) {
							MenuPrincipal.getMainFrame().getCoreManager().getDateManager().passeUneHeure();
							if (MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCourante().getHours() == 7) {
								evenementBloquant = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().regenerationNuit();
							}
						}
						boutonPasserNext.setEnabled(true);
					} else if (nextEvenement == null && nextMission != null){
						System.out.println("Fin des evenements");
						// TODO probleme boucle infini : missions necessitants items
						while (!nextMission.estDisponibleAPresenter() && evenementBloquant == false) {
							MenuPrincipal.getMainFrame().getCoreManager().getDateManager().passeUneHeure();
							if (MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCourante().getHours() == 7) {
								evenementBloquant = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().regenerationNuit();
							}
						}
						boutonPasserNext.setEnabled(true);
						
					} else if (nextEvenement == null && nextMission == null) {
						System.out.println("Fin des missions avec date et des evenements");
					} else {
						while (!nextEvenement.estDisponibleAPresenter() && !nextMission.estDisponibleAPresenter() && evenementBloquant == false) {
							MenuPrincipal.getMainFrame().getCoreManager().getDateManager().passeUneHeure();
							if (MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCourante().getHours() == 7) {
								evenementBloquant = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().regenerationNuit();
							}
						}
						boutonPasserNext.setEnabled(true);
					}
				}
				
				int score = MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().calculeScoreFinal();
				labelAvancement.setText(" "+ score + " / 1000 ");
				
				// Refresh des panel du perso courant
				MainFrame.getPanelBas().refreshPanelBasByPerso(MainFrame.getPanelCentre().getPanelShowing().getName());
				MainFrame.getPanelPersonnage().refreshMortsPersonnage();
				missionManager.refreshMissionsAPresenter();
			}
		});
		
		// Font
		labelDifficulte.setFont(Constante.ZELDA_FONT);
		labelAvancement.setFont(Constante.ZELDA_FONT);
		labelArgent.setFont(Constante.ZELDA_FONT);
		labelArgent.setForeground(Color.YELLOW);
		labelDate.setFont(Constante.SERIF_FONT);
		labelDate.setForeground(Color.WHITE);
		boutonPasser.setFont(Constante.ZELDA_FONT);
		boutonPasserNext.setFont(Constante.ZELDA_FONT);
		
		// Ajout au panel
		panelDate.add(labelDate);
		this.add(labelArgent);
//		this.add(labelTempsPasseDansLeJeu);
		this.add(panelDate);
		this.add(labelDifficulte);
		this.add(labelAvancement);
		this.add(boutonPasser);
		this.add(boutonPasserNext);
	}

}

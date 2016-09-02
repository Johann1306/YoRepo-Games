package front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.DateManager;
import core.EvenementManager;
import core.MissionManager;
import core.configuration.Constante;
import modele.evenement.Evenement;
import modele.item.mission.Mission;

public class PanelHaut extends JPanel {

	private JLabel labelDate = null;
	
	public void generePanelHaut() {

		BoxLayout boxlayout = new BoxLayout(this, BoxLayout.X_AXIS);
		this.setLayout(boxlayout);
		
		// bouton info
		
		
		// label temps passe dans le jeu
		JLabel labelTempsPasseDansLeJeu = new JLabel("0");
		labelTempsPasseDansLeJeu.setFont(Constante.PRESS_START_FONT);
		long currentTimeMillis = System.currentTimeMillis();
		long debutTimeMillis = currentTimeMillis;
		Date timer = new Date(currentTimeMillis - debutTimeMillis);
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					while(true) {
						Thread.sleep(1000);
						long currentTimeMillis = System.currentTimeMillis();
						timer.setTime(currentTimeMillis - debutTimeMillis);
						String jours = null;
						if ((timer.getDate()-1) >=2) {
							jours = "jours";
						} else {
							jours = "jour";
						}
						int heure = timer.getHours()-1;
						String heures = Integer.toString(heure);
						if (heure<10) {
							heures = "0" + heures;
						}
						int minute = timer.getMinutes();
						String minutes = Integer.toString(minute);
						if (minute<10) {
							minutes = "0" + minutes;
						}
						int seconde = timer.getSeconds();
						String secondes = Integer.toString(seconde);
						if (seconde<10) {
							secondes = "0" + secondes;
						}
						String text = timer.getDate()-1 + " " + jours + ", " + heures + ":" + minutes + ":" + secondes;
						labelTempsPasseDansLeJeu.setText(text);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		if (!t.isAlive()) {
			t.start();
		}
		
		// label avancement du jeu
		JLabel labelAvancement = new JLabel("0/100");
		
		// date
		JPanel panelDate = new JPanel();
		panelDate.setBackground(Color.BLACK);
		labelDate = new JLabel(DateManager.getDateCouranteFormateeUpperCase());
	
		// heure / tranche horaire
		
		
		// bouton passer
		JButton boutonPasser = new JButton("PASSER");
		boutonPasser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DateManager.passeUneHeure(labelDate);
				// Refresh du panel du perso courant
				MainFrame.getPanelBas().refreshPanelBasByPerso(MainFrame.getPanelCentre().getPanelShowing().getName());
//				PanelPersonnage.refreshPanelPersonnage();
				MissionManager.refreshMissionsAPresenter();
			}
		});

		// bouton passer jusqu'au prochain evenement ou la prochaine mission
		JButton boutonPasserNext = new JButton(Constante.SYMBOLE_PASSER_NEXT);
		boutonPasserNext.addActionListener(new ActionListener() {
			// TODO : gestion de la fin des evenements et des missions
			@Override
			public void actionPerformed(ActionEvent e) {
				// Si il n'y a plus d'evenement et de mission, on grise le passage rapide
				if (EvenementManager.getEvenementsIndisponibles().isEmpty() && MissionManager.getMissionsNonPresentees().isEmpty()) {
					boutonPasserNext.setEnabled(false);
					System.out.println("Fin des evenements et des missions a presenter");
					// sinon on passe jusqu'au prochain evenement ou la prochaine mission
				} else {
					Evenement nextEvenement = EvenementManager.getNextEvenement();
					Mission nextMission = MissionManager.getNextMissionAvecDate();
					boutonPasserNext.setEnabled(false);
					if (nextMission == null && nextEvenement != null) {
						System.out.println("Fin des missions avec date");
						while (!nextEvenement.estDisponible()) {
							DateManager.passeUneHeure(labelDate);
						}
						boutonPasserNext.setEnabled(true);
					} else if (nextEvenement == null && nextMission != null){
						System.out.println("Fin des evenements");
						while (!nextMission.estDisponibleAPresenter()) {
							DateManager.passeUneHeure(labelDate);
						}
						boutonPasserNext.setEnabled(true);
						
					} else if (nextEvenement == null && nextMission == null) {
						System.out.println("Fin des missions avec date et des evenements");
						
					} else {
						while (!nextEvenement.estDisponible() && !nextMission.estDisponibleAPresenter()) {
							DateManager.passeUneHeure(labelDate);
						}
						boutonPasserNext.setEnabled(true);
					}
				}
				// Refresh des panel du perso courant
				MainFrame.getPanelBas().refreshPanelBasByPerso(MainFrame.getPanelCentre().getPanelShowing().getName());
//				PanelPersonnage.refreshPanelPersonnage();
				MissionManager.refreshMissionsAPresenter();
			}
		});
		
		// Font
		labelAvancement.setFont(Constante.PRESS_START_FONT);
		labelDate.setFont(Constante.PRESS_START_FONT);
		labelDate.setForeground(Color.WHITE);
		boutonPasser.setFont(Constante.PRESS_START_FONT);
		boutonPasserNext.setFont(Constante.PRESS_START_FONT);
		
		// Ajout au panel
		this.add(labelTempsPasseDansLeJeu);
		panelDate.add(labelDate);
		this.add(panelDate);
		this.add(labelAvancement);
		this.add(boutonPasser);
		this.add(boutonPasserNext);
	}

}

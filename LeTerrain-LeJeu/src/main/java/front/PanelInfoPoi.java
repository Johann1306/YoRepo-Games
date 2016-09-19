package front;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import core.MissionManager;
import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionType;
import modele.item.poi.Poi;

public class PanelInfoPoi extends JPanel {

	// Presentation des missions du Poi
	public PanelInfoPoi(Poi poi) {
		JPanel panelInfoMission = new JPanel();
		JPanel panelBoutons = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panelBoutons, BoxLayout.Y_AXIS);
		panelBoutons.setLayout(boxlayout);
		
		// Pour chaque missions du Poi
		for (Mission mission : poi.getMissions()) {
			if (mission.isDisponible() && (!mission.isDejaFaite() || mission.isRepetable())) {
				JButton bouton = new JButton(mission.getNom());
				if (mission.isRepetable()) {
					bouton.setBackground(Constante.COULEUR_MISSION_REPETABLE);
				} else if (mission.getType().equals(MissionType.PRINCIPAL)) {
					bouton.setBackground(Constante.COULEUR_MISSION_PRINCIPAL);
				} else if (mission.getType().equals(MissionType.BOSS)) {
					bouton.setBackground(Constante.COULEUR_MISSION_BOSS);
				}

				// Clic bouton mission
				bouton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						// Nettoyage
						panelInfoMission.removeAll();
						
						// Presentation de la mission
						panelInfoMission.add(new JLabel(mission.getInformations()));
						panelInfoMission.add(new JLabel(mission.getType().name()));
						panelInfoMission.add(new JLabel(mission.getProprietaire().name()));
						
						
						// Bouton lancer mission
						JButton boutonMission = new JButton("Lancer");
						boutonMission.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// Lance la mission
								MissionManager missionManager = MenuPrincipal.getMainFrame().getCoreManager().getMissionManager();
								missionManager.lanceMission(mission);

								// Refresh panel Boutons Missions
								if (!mission.isRepetable()) {
									panelBoutons.remove(bouton);
									panelInfoMission.removeAll();
								}
							}
						});
						panelInfoMission.add(boutonMission);
						repaint();
					}
				});
				panelBoutons.add(bouton);
			}
		}
		this.setLayout(new BorderLayout());
		this.add(new JLabel(poi.getNom()), BorderLayout.NORTH);
		this.add(panelBoutons, BorderLayout.WEST);
		this.add(panelInfoMission, BorderLayout.CENTER);
	}

}

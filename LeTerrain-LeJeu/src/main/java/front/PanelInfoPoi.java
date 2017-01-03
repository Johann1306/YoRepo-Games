package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import core.MissionManager;
import core.NomJeu;
import core.configuration.Constante;
import modele.item.Item;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.item.poi.Poi;

public class PanelInfoPoi extends JPanel {

	// Presentation des missions du Poi
	public PanelInfoPoi(Poi poi) {
		JPanel panelNord = new JPanel();
		JPanel panelOuest = new JPanel();
		JPanel panelCentre = new JPanel();
		JPanel panelEst = new JPanel();
		JPanel panelSud = new JPanel();

		// BoxLayout boxlayoutNord = new BoxLayout(panelNord, BoxLayout.Y_AXIS);
		// panelNord.setLayout(boxlayoutNord);
		BoxLayout boxlayoutBoutons = new BoxLayout(panelOuest, BoxLayout.Y_AXIS);
		panelOuest.setLayout(boxlayoutBoutons);
		BoxLayout boxlayoutInfo = new BoxLayout(panelCentre, BoxLayout.Y_AXIS);
		panelCentre.setLayout(boxlayoutInfo);

		// Panel Nord : Poi
		JLabel labelNomPoi = new JLabel(poi.getNom());
		JLabel labelInfoPoi = new JLabel(poi.getInformations());
		labelNomPoi.setFont(Constante.ZELDA_FONT_TITRE);
		labelInfoPoi.setFont(Constante.ZELDA_FONT);
		panelNord.add(labelNomPoi);
		panelNord.add(labelInfoPoi);
		System.out.println(this.getMaximumSize());
		labelNomPoi.setMaximumSize(this.getMaximumSize());

		// TODO : taille des boutons par rapport au plus grand nom de mission
		// Pour chaque missions du Poi
		int largeurMax = 0;
		for (Mission mission : poi.getMissions()) {
			if (mission != null) {
				if (mission.isDisponible() && (!mission.isDejaFaite() || mission.isRepetable())) {
					JButton bouton = new JButton(mission.getNom());
					bouton.setFont(Constante.ZELDA_FONT_MENU);
					if (mission.isRepetable()) {
						bouton.setBackground(Constante.COULEUR_MISSION_REPETABLE);
					} else if (mission.getMissionType().equals(MissionType.PRINCIPAL)) {
						bouton.setBackground(Constante.COULEUR_MISSION_PRINCIPAL);
					} else if (mission.getMissionType().equals(MissionType.BOSS)) {
						bouton.setBackground(Constante.COULEUR_MISSION_BOSS);
					}

					// Clic bouton mission
					bouton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							// Nettoyage
							panelCentre.removeAll();

							// Presentation de la mission
							JPanel panelProprio = new JPanel();
							JPanel panelNomMission = new JPanel();
							JPanel panelInfoMission = new JPanel();
							JPanel panelObjectif = new JPanel();
							JPanel panelCondVictoire = new JPanel();
							JPanel panelCondDfaite = new JPanel();
							JPanel panelDifficulte = new JPanel();
							JPanel panelTypeMission = new JPanel();
							JPanel panelNombreEssais = new JPanel();
							JPanel panelNombreVictoire = new JPanel();
							JPanel panelDateMission = new JPanel();
							JPanel panelLieuMission = new JPanel();

							panelProprio.add(new JLabel("Propriétaire : " + mission.getProprietaire().name()));
							panelNomMission.add(new JLabel("Nom de mission : " + mission.getNom()));
							panelInfoMission.add(new JLabel("Infos : " + mission.getInformations()));
							panelObjectif.add(new JLabel("Objectif : " + mission.getObjectif()));
							panelCondVictoire
									.add(new JLabel("Condition de victoire : " + mission.getConditionVictoire()));
							panelCondDfaite.add(new JLabel("Condition de defaite : " + mission.getConditionDefaite()));
							panelDifficulte.add(new JLabel("Difficulté : " + mission.getDifficulty().name()));
							panelTypeMission.add(new JLabel("Type de mission : " + mission.getMissionType().name()));
							panelNombreEssais.add(new JLabel("Essais : " + mission.getNombreEssai()));
							panelNombreVictoire.add(new JLabel("Victoires : " + mission.getNombreWin()));
							panelDateMission.add(new JLabel("Date : " + mission.getDate()));
							panelLieuMission.add(new JLabel("Lieu : " + mission.getLieu()));

							panelCentre.add(panelProprio);
							panelCentre.add(panelNomMission);
							panelCentre.add(panelInfoMission);
							panelCentre.add(panelObjectif);
							panelCentre.add(panelCondVictoire);
							panelCentre.add(panelCondDfaite);
							panelCentre.add(panelDifficulte);
							panelCentre.add(panelTypeMission);
							panelCentre.add(panelNombreEssais);
							panelCentre.add(panelNombreVictoire);
							panelCentre.add(panelDateMission);
							panelCentre.add(panelLieuMission);

							// TODO : a presenter
							// List<String> imagePaths =
							// mission.getImagePaths();
							// List<Item> itemsDebloques =
							// mission.getItemsDebloques();
							// List<Item> itemsNecessaires =
							// mission.getItemsNecessaires();
							// List<NomJeu> jeux = mission.getJeux();
							// List<PersonnagePrincipal> personnagesInterdits =
							// mission.getPersonnagesInterdits();
							// List<PersonnagePrincipal> personnagesRequis =
							// mission.getPersonnagesRequis();
							// List<PersonnageSecondaire> personnagesSecondaires
							// = mission.getPersonnagesSecondaires();
							// List<String> sonPaths = mission.getSonPaths();
							// List<String> videoPaths =
							// mission.getVideoPaths();

							// Bouton lancer mission
							JButton boutonMission = new JButton("START");
							boutonMission.setFont(Constante.ZELDA_FONT);
							boutonMission.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									// Lance la mission
									MissionManager missionManager = MenuPrincipal.getMainFrame().getCoreManager()
											.getMissionManager();
									missionManager.lanceMission(mission);

									// Refresh panel Boutons Missions
									if (!mission.isRepetable()) {
										panelOuest.remove(bouton);
										panelCentre.removeAll();
									}
								}
							});
							panelCentre.add(boutonMission);
							// TODO : repaint ou autre
							// repaint();
							revalidate();
						}
					});
					bouton.setMaximumSize(Constante.BOUTON_MISSIONS_DIMENSION);
					panelOuest.add(bouton);
//					if (bouton.getWidth() > largeurMax) {
//						largeurMax = bouton.getWidth();
//					}
////					panelOuest.setMaximumSize(new Dimension(largeurMax, 150));
//					Component[] components = panelOuest.getComponents();
//					for (Component component : components) {
//						component.setMinimumSize(new Dimension(largeurMax, 150));
//					}
				}
			}
		}
		
		panelOuest.setBackground(Color.PINK);
		panelCentre.setBackground(Color.YELLOW);
		panelNord.setBackground(Color.RED);
		panelEst.setBackground(Color.BLUE);
		panelSud.setBackground(Color.GREEN);

		this.setLayout(new BorderLayout());
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelOuest, BorderLayout.WEST);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelEst, BorderLayout.EAST);
		this.add(panelSud, BorderLayout.SOUTH);
	}

}

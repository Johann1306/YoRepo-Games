package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import core.ImageManager;
import core.MissionManager;
import core.MusiqueManager;
import core.configuration.Constante;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.PersonnagePrincipal;
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
		JLabel labelNomPoi = new JLabel(poi.getNom() + " :" );
		JLabel labelInfoPoi = new JLabel(poi.getInformations());
		labelNomPoi.setFont(Constante.MARIO_FONT_MENU_3);
		labelInfoPoi.setFont(Constante.MARIO_FONT_MENU_2);
		labelNomPoi.setForeground(Color.YELLOW);
		labelInfoPoi.setForeground(Color.WHITE);
		panelNord.add(labelNomPoi);
		panelNord.add(labelInfoPoi);
//		System.out.println(this.getMaximumSize());
		labelNomPoi.setMaximumSize(this.getMaximumSize());

		// TODO : taille des boutons par rapport au plus grand nom de mission
		// Pour chaque missions du Poi
		int largeurMax = 0;
		for (Mission mission : poi.getMissions()) {
			if (mission != null) {
				if (mission.isDisponible() && (!mission.isDejaFaite() || mission.isRepetable())) {
					JButton bouton = new JButton(mission.getNom());
					bouton.setFont(Constante.MARIO_FONT_MENU);
					bouton.setPreferredSize(Constante.BOUTON_MISSIONS_DIMENSION);
					bouton.setMaximumSize(Constante.BOUTON_MISSIONS_DIMENSION);
					if (mission.isRepetable()) {
						bouton.setBackground(Constante.COULEUR_MISSION_REPETABLE);
						bouton.setForeground(Constante.COULEUR_MISSION_REPETABLE_2);
					} else if (mission.getMissionType().equals(MissionType.PRINCIPAL)) {
						bouton.setBackground(Constante.COULEUR_MISSION_PRINCIPAL);
						bouton.setForeground(Constante.COULEUR_MISSION_PRINCIPAL_2);
					} else if (mission.getMissionType().equals(MissionType.BOSS)) {
						bouton.setBackground(Constante.COULEUR_MISSION_BOSS);
						bouton.setForeground(Constante.COULEUR_MISSION_BOSS_2);
					} else if (mission.getMissionType().equals(MissionType.QUIZZ)) {
						bouton.setBackground(Constante.COULEUR_MISSION_QUIZZ);
						bouton.setForeground(Constante.COULEUR_MISSION_QUIZZ_2);
					}
					
					bouton.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent e) {
						}
						
						@Override
						public void mousePressed(MouseEvent e) {
						}
						
						@Override
						public void mouseExited(MouseEvent e) {
							bouton.setFont(Constante.MARIO_FONT_MENU);
						}
						
						@Override
						public void mouseEntered(MouseEvent e) {
							bouton.setFont(Constante.MARIO_FONT_MENU_3);
						}
						
						@Override
						public void mouseClicked(MouseEvent e) {
						}
					});

					// Clic bouton mission
					bouton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							MusiqueManager.playSon("sonParDefaut/bom-ncis.mp3");

							// Nettoyage
							panelCentre.removeAll();
							
							panelCentre.setBackground(Color.BLACK);

							// Presentation de la mission
							JPanel panelProprio = new JPanel();
							JPanel panelNomMission = new JPanel();
							JPanel panelInfoMission = new JPanel();
							JPanel panelObjectif = new JPanel();
							JPanel panelCondVictoire = new JPanel();
							JPanel panelCondDfaite = new JPanel();
							JPanel panelDifficulte = new JPanel();
							JPanel panelTypeMission = new JPanel();
							JPanel panelTypeJeu = new JPanel();
							JPanel panelNombreEssais = new JPanel();
							JPanel panelNombreVictoire = new JPanel();
//							JPanel panelDateMission = new JPanel();
//							JPanel panelLieuMission = new JPanel();

							PersonnagePrincipal proprio = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(mission.getProprietaire());
							ImageIcon photo = null;
							if (proprio == null) {
								photo = FenetrePrincipal.getImageIcon("image/groupe.png");
							} else {
								photo = proprio.getPhotoCombat();	
							}
							ImageIcon resizeImage = ImageManager.resizeImage(photo, Constante.PERSO_IMAGE_DIMENSION_180_180);
							panelProprio.add(new JLabel(resizeImage));
							
							JLabel nomMissionLabel = new JLabel("Nom de mission : ");
							JLabel nomMissionValue = new JLabel(mission.getNom());
							nomMissionLabel.setFont(Constante.MARIO_FONT_MENU_3);
							nomMissionLabel.setForeground(Color.YELLOW);
							nomMissionValue.setFont(Constante.MARIO_FONT_MENU_3);
							nomMissionValue.setForeground(Color.WHITE);
							panelNomMission.add(nomMissionLabel);
							panelNomMission.add(nomMissionValue);
							
							JLabel infoMissionLabel = new JLabel("Infos : ");
							
							JTextArea infoMissionValue = new JTextArea(mission.getInformations());
							infoMissionValue.setLineWrap(true);
							infoMissionValue.setWrapStyleWord(true);
							infoMissionValue.setEditable(false);
							infoMissionValue.setFont(Constante.MARIO_FONT_MENU_3);
							infoMissionValue.setForeground(Color.WHITE);
							infoMissionValue.setBackground(Color.BLACK);
							infoMissionValue.setSize(Constante.INFO_MISSION_800_100);
							infoMissionValue.setMinimumSize(Constante.INFO_MISSION_800_100);  
							
							
//							JTextPane infoMissionValue = new JTextPane();
//							infoMissionValue.setBackground(Color.BLACK);
//							infoMissionValue.setPreferredSize(Constante.INFO_MISSION_800_100);
//							infoMissionValue.setText(mission.getInformations());
							infoMissionLabel.setFont(Constante.MARIO_FONT_MENU_3);
							infoMissionLabel.setForeground(Color.YELLOW);
//							infoMissionValue.setFont(Constante.MARIO_FONT_MENU_3);
//							infoMissionValue.setForeground(Color.WHITE);
							panelInfoMission.add(infoMissionLabel);
							panelInfoMission.add(infoMissionValue);
							
//							panelObjectif.add(new JLabel("Objectif : " + mission.getObjectif()));
//							panelCondVictoire
//									.add(new JLabel("Condition de victoire : " + mission.getConditionVictoire()));
//							panelCondDfaite.add(new JLabel("Condition de defaite : " + mission.getConditionDefaite()));
//							panelDifficulte.add(new JLabel("Difficulte : " + mission.getDifficulty().name()));
//							panelTypeMission.add(new JLabel("Type de mission : " + mission.getMissionType().name()));
//							panelTypeJeu.add(new JLabel("Type de jeu : " + mission.getJeu().name()));

							JLabel nbEssaisLabel = new JLabel("Nombre d'Essais :");
							JLabel nbEssaisValue = new JLabel(" " + mission.getNombreEssai());
							nbEssaisLabel.setFont(Constante.MARIO_FONT_MENU_3);
							nbEssaisLabel.setForeground(Color.YELLOW);
							nbEssaisValue.setFont(Constante.MARIO_FONT_MENU_3);
							nbEssaisValue.setForeground(Color.WHITE);
							panelNombreEssais.add(nbEssaisLabel);
							panelNombreEssais.add(nbEssaisValue);
							
							JLabel nbVictoiresLabel = new JLabel("Nombre de Victoires : ");
							JLabel nbVictoiresValue = new JLabel(" " + mission.getNombreWin());
							nbVictoiresLabel.setFont(Constante.MARIO_FONT_MENU_3);
							nbVictoiresLabel.setForeground(Color.YELLOW);
							nbVictoiresValue.setFont(Constante.MARIO_FONT_MENU_3);
							nbVictoiresValue.setForeground(Color.WHITE);
							panelNombreVictoire.add(nbVictoiresLabel);
							panelNombreVictoire.add(nbVictoiresValue);
//							
//							panelDateMission.add(new JLabel("Date de disponibilite: " + mission.getDate()));
//							panelLieuMission.add(new JLabel("Lieu : " + mission.getLieu()));
							
							panelCentre.add(panelProprio);
							panelCentre.add(panelNomMission);
							panelCentre.add(panelInfoMission);
//							panelCentre.add(panelObjectif);
//							panelCentre.add(panelCondVictoire);
//							panelCentre.add(panelCondDfaite);
//							panelCentre.add(panelDifficulte);
//							panelCentre.add(panelTypeMission);
//							panelCentre.add(panelTypeJeu);
							panelCentre.add(panelNombreEssais);
							panelCentre.add(panelNombreVictoire);
//							panelCentre.add(panelDateMission);
//							panelCentre.add(panelLieuMission);
							
							panelProprio.setBackground(Color.BLACK);
							panelNomMission.setBackground(Color.BLACK);
							panelInfoMission.setBackground(Color.BLACK);
							panelNombreEssais.setBackground(Color.BLACK);
							panelNombreVictoire.setBackground(Color.BLACK);

							panelCentre.setBackground(Color.BLACK);
							
							
							// Font
//							Component[] components = panelCentre.getComponents();
//							for (Component component : components) {
//								if (component instanceof JPanel) {
//									JPanel panel = (JPanel) component;
//									Component[] panelComponents = panel.getComponents();
//									for (Component panelComponent : panelComponents) {
//										panelComponent.setFont(Constante.MARIO_FONT_MENU_2);
//									}
//								}
//							}
							
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
							boutonMission.setBorderPainted(false);
							boutonMission.setFont(Constante.MARIO_FONT_MENU_START_2);
							boutonMission.setForeground(Color.GREEN);
							boutonMission.setBackground(Color.BLACK);
							boutonMission.setPreferredSize(boutonMission.getMaximumSize());
							boutonMission.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									
									// TODO son different pour demarrage de mission
									MusiqueManager.playSon("sonParDefaut/bom-ncis.mp3");
									
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
							boutonMission.addMouseListener(new MouseListener() {
								
								@Override
								public void mouseReleased(MouseEvent e) {
								}
								
								@Override
								public void mousePressed(MouseEvent e) {
								}
								
								@Override
								public void mouseExited(MouseEvent e) {
									boutonMission.setFont(Constante.MARIO_FONT_MENU_START_2);
								}
								
								@Override
								public void mouseEntered(MouseEvent e) {
									boutonMission.setFont(Constante.MARIO_FONT_MENU_START);
								}
								
								@Override
								public void mouseClicked(MouseEvent e) {
								}
							});
							
							JPanel panelBouton = new JPanel();
							panelBouton.add(boutonMission);
							panelBouton.setBackground(Color.BLACK);
							panelCentre.add(panelBouton);
							// TODO : repaint ou autre
							// repaint();
							revalidate();
						}
					});
//					bouton.setMaximumSize(Constante.BOUTON_MISSIONS_DIMENSION);
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
		
		panelOuest.setBackground(Color.BLACK);
		panelCentre.setBackground(Color.BLACK);
		panelNord.setBackground(Color.BLACK);
		panelEst.setBackground(Color.BLACK);
		panelSud.setBackground(Color.BLACK);
		
		// Gestion scroll dragged panel centre
		Moustener moustener = new Moustener(this);
		MainFrame.getScrollPaneCentre().getViewport().addMouseMotionListener(moustener);
		MainFrame.getScrollPaneCentre().getViewport().addMouseListener(moustener);

		this.setLayout(new BorderLayout());
		this.add(panelNord, BorderLayout.NORTH);
		this.add(panelOuest, BorderLayout.WEST);
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelEst, BorderLayout.EAST);
		this.add(panelSud, BorderLayout.SOUTH);
	}

	private class Moustener extends MouseAdapter {
		
	    private final Cursor defCursor = Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
	    private final Cursor hndCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
	    private final Point pp = new Point();
	    private JPanel image;

	    public Moustener(JPanel image) {
	        this.image = image;
	    }
		
		@Override
		public void mouseDragged(MouseEvent e) {
	        JViewport vport = (JViewport)e.getSource();
	        Point cp = e.getPoint();
	        Point vp = vport.getViewPosition();
	        vp.translate(pp.x-cp.x, pp.y-cp.y);
	        image.scrollRectToVisible(new Rectangle(vp, vport.getSize()));
	        pp.setLocation(cp);
		}
		
		public void mousePressed(MouseEvent e) {
	        image.setCursor(hndCursor);
	        pp.setLocation(e.getPoint());
	    }

	    public void mouseReleased(MouseEvent e) {
	        image.setCursor(defCursor);
	        image.repaint();
	    }
	}
}

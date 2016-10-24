package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

import core.ImageManager;
import core.MusiqueManager;
import core.RandomManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.item.Item;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionDifficulty;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.Personnage;
import modele.item.personnage.PersonnageBoss;
import modele.item.personnage.PersonnageEnnemi;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.action.ActionCombat;
import modele.item.personnage.action.ActionCombatType;
import modele.item.personnage.action.CibleType;
import modele.item.personnage.action.EnergieType;
import modele.item.personnage.action.SortType;

public class FrameCombat extends FrameJeu {

	private static final long serialVersionUID = 1L;

	private static boolean win;

	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private static JPanel panelCentre = new JPanel();
	private JPanel panelEst = new JPanel();
	private JPanel panelSud = new JPanel();

	private JButton boutonNicolas = null;
	private JButton boutonPierre = null;
	private JButton boutonYannick = null;
	private JButton boutonThomas = null;
	private JButton boutonJohann = null;
	private JButton boutonAli = null;
	private JButton boutonGuillaume = null;
	private JButton boutonJonathan = null;

	private Item itemSelectionne = null;
	private JPanel panelInfosCombat = null;
	private List<JButton> boutonsEnnemis = null;
	private List<JButton> boutonsAmis = null;
	private List<PersonnageEnnemi> ennemisVivants = null;
	private List<PersonnagePrincipal> amisVivants = null;
	private List<PersonnagePrincipal> amisPresents = null;

	private JMenu menuActions = new JMenu("ACTIONS");
	private Mission mission;
	private JPanel panelActions = null;
	private JPanel panelBoutonsGroupe = null;
	private Timer timerEnnemis = null;
	private Timer timerJoueurs = null;
	private JLabel labelTimer = null;
	private boolean peuxFuir = true;
	private int tempsMax = 0;

	public FrameCombat(Groupe groupe, Mission mission) {
		this.mission = mission;
		win = false;
		PersoPrenom firstPerso = null;

		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		panelActions = new JPanel();
		// BoxLayout boxlayoutActions = new BoxLayout(panelActions,
		// BoxLayout.X_AXIS);
		// panelActions.setLayout(boxlayoutActions);

		this.setAlwaysOnTop(true);
		this.setSize(Constante.FENETRE_COMBAT_DIMENSION);
		this.setMinimumSize(Constante.FENETRE_COMBAT_DIMENSION);
		centreFenetre();

		// Personnages principaux
		PersonnagePrincipal nicolas = groupe.getPersoByNom(PersoPrenom.Nicolas);
		PersonnagePrincipal pierre = groupe.getPersoByNom(PersoPrenom.Pierre);
		PersonnagePrincipal yannick = groupe.getPersoByNom(PersoPrenom.Yannick);
		PersonnagePrincipal thomas = groupe.getPersoByNom(PersoPrenom.Thomas);
		PersonnagePrincipal johann = groupe.getPersoByNom(PersoPrenom.Johann);
		PersonnagePrincipal ali = groupe.getPersoByNom(PersoPrenom.Ali);
		PersonnagePrincipal guillaume = groupe.getPersoByNom(PersoPrenom.Guillaume);
		PersonnagePrincipal jonathan = groupe.getPersoByNom(PersoPrenom.Jonathan);

		// -- Panel Nord - Info
		JPanel panelInfoMission = createPanelInfoMission(mission);
		panelNord.add(panelInfoMission);

		// -- Panel Ouest - Persos
		ImageIcon resizeImage = ImageManager.resizeImage(nicolas.getPhotoPrincipal(),
				Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonNicolas = new JButton(resizeImage);
		boutonPierre = new JButton(
				ImageManager.resizeImage(pierre.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonYannick = new JButton(
				ImageManager.resizeImage(yannick.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonThomas = new JButton(
				ImageManager.resizeImage(thomas.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonJohann = new JButton(
				ImageManager.resizeImage(johann.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonAli = new JButton(
				ImageManager.resizeImage(ali.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonGuillaume = new JButton(
				ImageManager.resizeImage(guillaume.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonJonathan = new JButton(
				ImageManager.resizeImage(jonathan.getPhotoPrincipal(), Constante.PERSO_IMAGE_DIMENSION_64_64));

		boutonNicolas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonPierre.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonYannick.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonThomas.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonJohann.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonAli.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonGuillaume.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
		boutonJonathan.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);

		boutonNicolas.setName(nicolas.getPrenom());
		boutonPierre.setName(pierre.getPrenom());
		boutonYannick.setName(yannick.getPrenom());
		boutonThomas.setName(thomas.getPrenom());
		boutonJohann.setName(johann.getPrenom());
		boutonAli.setName(ali.getPrenom());
		boutonGuillaume.setName(guillaume.getPrenom());
		boutonJonathan.setName(jonathan.getPrenom());

		JPanel panelPersos = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panelPersos, BoxLayout.Y_AXIS);
		panelPersos.setLayout(boxlayout);
		amisVivants = new ArrayList<PersonnagePrincipal>();
		amisPresents = new ArrayList<PersonnagePrincipal>();
		boutonsAmis = new ArrayList<JButton>();

		if (thomas.isDejaPresente() && !thomas.isMort()) {
			panelPersos.add(boutonThomas);
			boutonsAmis.add(boutonThomas);
			amisVivants.add(thomas);
			amisPresents.add(thomas);
			if (firstPerso == null) {
				firstPerso = thomas.getPrenomPerso();
			}
		}
		if (guillaume.isDejaPresente() && !guillaume.isMort()) {
			panelPersos.add(boutonGuillaume);
			boutonsAmis.add(boutonGuillaume);
			amisVivants.add(guillaume);
			amisPresents.add(guillaume);
			if (firstPerso == null) {
				firstPerso = guillaume.getPrenomPerso();
			}
		}
		if (nicolas.isDejaPresente() && !nicolas.isMort()) {
			panelPersos.add(boutonNicolas);
			boutonsAmis.add(boutonNicolas);
			amisVivants.add(nicolas);
			amisPresents.add(nicolas);
			if (firstPerso == null) {
				firstPerso = nicolas.getPrenomPerso();
			}
		}
		if (pierre.isDejaPresente() && !pierre.isMort()) {
			panelPersos.add(boutonPierre);
			boutonsAmis.add(boutonPierre);
			amisVivants.add(pierre);
			amisPresents.add(pierre);
			if (firstPerso == null) {
				firstPerso = pierre.getPrenomPerso();
			}
		}
		if (jonathan.isDejaPresente() && !jonathan.isMort()) {
			panelPersos.add(boutonJonathan);
			boutonsAmis.add(boutonJonathan);
			amisVivants.add(jonathan);
			amisPresents.add(jonathan);
			if (firstPerso == null) {
				firstPerso = jonathan.getPrenomPerso();
			}
		}
		if (yannick.isDejaPresente() && !yannick.isMort()) {
			panelPersos.add(boutonYannick);
			boutonsAmis.add(boutonYannick);
			amisVivants.add(yannick);
			amisPresents.add(yannick);
			if (firstPerso == null) {
				firstPerso = yannick.getPrenomPerso();
			}
		}
		if (johann.isDejaPresente() && !johann.isMort()) {
			panelPersos.add(boutonJohann);
			boutonsAmis.add(boutonJohann);
			amisVivants.add(johann);
			amisPresents.add(johann);
			if (firstPerso == null) {
				firstPerso = johann.getPrenomPerso();
			}
		}
		if (ali.isDejaPresente() && !ali.isMort()) {
			panelPersos.add(boutonAli);
			boutonsAmis.add(boutonAli);
			amisVivants.add(ali);
			amisPresents.add(ali);
			if (firstPerso == null) {
				firstPerso = ali.getPrenomPerso();
			}
		}

		boutonNicolas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Nicolas);
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Pierre);
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Yannick);
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Thomas);
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Johann);
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Ali);
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Guillaume);
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(PersoPrenom.Jonathan);
			}
		});

		panelOuest.add(panelPersos);

		// -- Panel Est
		JPanel panelEnnemis = new JPanel();
		BoxLayout boxlayoutEnnemis = new BoxLayout(panelEnnemis, BoxLayout.Y_AXIS);
		panelEnnemis.setLayout(boxlayoutEnnemis);

		// Gestion de la difficulte
		int nombreEnnemis = 1;
		if (mission.getMissionType() == MissionType.BOSS) {
			nombreEnnemis = 0;
		}
		if (mission.getDifficulty() == MissionDifficulty.FACILE) {
			nombreEnnemis = nombreEnnemis + 2;
		} else if (mission.getDifficulty() == MissionDifficulty.NORMAL) {
			nombreEnnemis = nombreEnnemis + 4;
		} else if (mission.getDifficulty() == MissionDifficulty.DIFFICILE) {
			nombreEnnemis = nombreEnnemis + 5;
		} else if (mission.getDifficulty() == MissionDifficulty.HEROIQUE) {
			nombreEnnemis = nombreEnnemis + 7;
		}

		// Gestion du type d ennemis / BOSS / type de mission
		boutonsEnnemis = new ArrayList<JButton>();
		ennemisVivants = new ArrayList<PersonnageEnnemi>();
		if (mission.getMissionType() == MissionType.BOSS) {
			PersonnageBoss boss = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
					.getPersonnageBossByNom(mission.getBossNom());
			ennemisVivants.add(boss);
			ImageIcon photoBoss = ImageManager.resizeImage(boss.getPhotoPrincipal(),
					Constante.PERSO_IMAGE_DIMENSION_64_64);
			JButton boutonBoss = new JButton(photoBoss);
			boutonBoss.setName(boss.getNom());
			boutonBoss.setToolTipText(boutonBoss.getName());
			boutonBoss.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
			boutonBoss.setFocusable(false);
			panelEnnemis.add(boutonBoss);
			boutonsEnnemis.add(boutonBoss);
		}

		for (int i = 1; i <= nombreEnnemis; i++) {
			PersonnageEnnemi ennemi = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
					.createPersonnageEnnemi(mission, i);
			ennemisVivants.add(ennemi);
			JButton boutonEnnemi = new JButton(ennemi.getPhotoPrincipal());
			boutonEnnemi.setName(ennemi.getNom());
			boutonEnnemi.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
			boutonEnnemi.setToolTipText(boutonEnnemi.getName());
			boutonEnnemi.setFocusable(false);
			panelEnnemis.add(boutonEnnemi);
			boutonsEnnemis.add(boutonEnnemi);
		}

		panelEst.add(panelEnnemis);

		// -- Panel Sud - Actions
		buildPanelActions(firstPerso);

		panelSud.add(panelActions);

		// -- Panel Centre
		buildPanelCentre();

		// --

		// Resize on resize frame
		// this.addComponentListener(new ComponentListener() {
		//
		// @Override
		// public void componentShown(ComponentEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void componentResized(ComponentEvent e) {
		// int x = getRootPane().getWidth();
		// panelInfoCombat.setMinimumSize(new Dimension(x-10,
		// Constante.PANEL_INFO_COMBAT_HAUTEUR));
		// panelActions.setPreferredSize(new Dimension(x-10,
		// Constante.PANEL_ACTION_HAUTEUR));
		// }
		//
		// @Override
		// public void componentMoved(ComponentEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void componentHidden(ComponentEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });

		// --
		panelNord.setBackground(Color.BLACK);
		panelOuest.setBackground(Color.GREEN);
		panelCentre.setBackground(Color.WHITE);
		panelEst.setBackground(Color.RED);
		panelSud.setBackground(Color.BLUE);

		content.add(panelNord, BorderLayout.NORTH);
		content.add(panelOuest, BorderLayout.WEST);
		content.add(panelCentre, BorderLayout.CENTER);
		content.add(panelEst, BorderLayout.EAST);
		content.add(panelSud, BorderLayout.SOUTH);

		this.setContentPane(content);
		this.setVisible(true);
	}

	private void buildPanelActions(PersoPrenom prenom) {

		PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
				.getPersoByPrenom(prenom);

		// On construit le panel uniquement si le perso n a pas encore joue ce
		// tour ci
		if (!perso.isaDejaJoue()) {

			manageItemSelectionne(prenom);

			// TODO : mieux que removeAll()
			panelActions.removeAll();
			BoxLayout boxlayoutActions = new BoxLayout(panelActions, BoxLayout.X_AXIS);
			panelActions.setLayout(boxlayoutActions);

			// Photo perso selectionne
			JPanel panelPerso = new JPanel();
			JLabel labelPerso = new JLabel(perso.getPhotoPrincipal());
			panelPerso.setMaximumSize(
					new Dimension(Constante.PANEL_COMBAT_PERSO_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
			panelPerso.add(labelPerso);

			// Boutons perso combat
			JPanel panelBoutonsPerso = new JPanel();
			BoxLayout boxlayoutBoutonsPerso = new BoxLayout(panelBoutonsPerso, BoxLayout.Y_AXIS);
			panelBoutonsPerso.setLayout(boxlayoutBoutonsPerso);

			JMenuBar menuBar = new JMenuBar();

			buildMenuActions(perso);

			JPanel panelMenu = new JPanel();
			menuBar.add(menuActions);
			panelMenu.add(menuBar);
			panelMenu.setMaximumSize(new Dimension(Constante.PANEL_ACTION_PERSO_LARGEUR, 30));

			panelBoutonsPerso.add(new JLabel("CHANCE CRIT : " + perso.getCompetence().getLuck()));
			panelBoutonsPerso.add(new JLabel("DEGATS CRIT : " + perso.getCompetence().getExploit()));
			panelBoutonsPerso.add(new JLabel("ATTAQUE MIN : " + perso.getCompetence().getTechnique()));
			panelBoutonsPerso.add(new JLabel("VIE MAX : " + perso.getCompetence().getEndurance()));
			panelBoutonsPerso.add(new JLabel("DEFENSE : " + perso.getCompetence().getResistance()));
			panelBoutonsPerso.add(new JLabel("REGEN STUN : " + perso.getCompetence().getRapidite()));
			panelBoutonsPerso.add(new JLabel("ESQUIVE : " + perso.getCompetence().getAgilite()));
			panelBoutonsPerso.add(new JLabel("MANA MAX : " + perso.getCompetence().getIntelligence()));
			panelBoutonsPerso.add(new JLabel("CHARGE MAX : " + perso.getCompetence().getNervosite()));
			panelBoutonsPerso.add(panelMenu);
			panelBoutonsPerso.setMaximumSize(
					new Dimension(Constante.PANEL_ACTION_PERSO_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));

			// Infos combat
			if (panelActions.getComponentCount() != 0) {
				panelInfosCombat = (JPanel) panelActions.getComponent(3);
			}
			if (panelInfosCombat == null) {
				panelInfosCombat = new JPanel();
				BoxLayout boxlayoutInfosCombat = new BoxLayout(panelInfosCombat, BoxLayout.Y_AXIS);
				panelInfosCombat.setLayout(boxlayoutInfosCombat);
				// TODO mieux
				// panelInfosCombat.setMinimumSize(new
				// Dimension(Constante.PANEL_INFO_COMBAT_LARGEUR,
				// Constante.PANEL_ACTION_HAUTEUR));
				// panelInfosCombat.setMaximumSize(new
				// Dimension(Constante.PANEL_INFO_COMBAT_LARGEUR,
				// Constante.PANEL_ACTION_HAUTEUR));
				// panelInfosCombat.setSize(new
				// Dimension(Constante.PANEL_INFO_COMBAT_LARGEUR,
				// Constante.PANEL_ACTION_HAUTEUR));
				// panelInfosCombat.setPreferredSize(new
				// Dimension(Constante.PANEL_INFO_COMBAT_LARGEUR,
				// Constante.PANEL_ACTION_HAUTEUR));
				panelInfosCombat.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
			}

			// Items combat
			JPanel panelItemsCombat = new JPanel();
			BoxLayout boxlayoutItemsCombat = new BoxLayout(panelItemsCombat, BoxLayout.Y_AXIS);
			panelItemsCombat.setLayout(boxlayoutItemsCombat);

			List<Item> itemsGroupe = MenuPrincipal.getMainFrame().getCoreManager().getItemManager()
					.getItemsDisponiblesByPerso(PersoPrenom.GROUPE);
			for (Item item : itemsGroupe) {
				// TODO si item consommable
				ImageIcon imageItem = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
				ImageIcon resizeImage2 = ImageManager.resizeImage(imageItem, Constante.ITEM_CONSOMMABLE_DIMENSION);
				JButton boutonItem = new JButton(resizeImage2);
				boutonItem.setPreferredSize(new Dimension(resizeImage2.getIconWidth(), resizeImage2.getIconHeight()));

				// Clic sur un item
				boutonItem.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						itemSelectionne = item;
						// TODO panelPerso en surbrillance
						panelOuest.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
						// TODO changer l icone de la souris jusqu a ce que l
						// item
						// soit utilise
					}
				});
				panelItemsCombat.add(boutonItem);
			}
			// panelItemsCombat.setMaximumSize(Constante.ITEM_CONSOMMABLE_DIMENSION);
			// panelItemsCombat.setMinimumSize(Constante.ITEM_CONSOMMABLE_DIMENSION);
			// TODO mieux
			// panelItemsCombat
			// .setMinimumSize(new
			// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
			// Constante.PANEL_ACTION_HAUTEUR));
			// panelItemsCombat
			// .setMaximumSize(new
			// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
			// Constante.PANEL_ACTION_HAUTEUR));
			// panelItemsCombat.setSize(new
			// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
			// Constante.PANEL_ACTION_HAUTEUR));
			// panelItemsCombat
			// .setPreferredSize(new
			// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
			// Constante.PANEL_ACTION_HAUTEUR));

			// Boutons groupe combat
			panelBoutonsGroupe = new JPanel();
			BoxLayout boxlayoutBoutonsGroupe = new BoxLayout(panelBoutonsGroupe, BoxLayout.Y_AXIS);
			panelBoutonsGroupe.setLayout(boxlayoutBoutonsGroupe);

			JButton boutonAuto = new JButton("COMBAT AUTO");
			boutonAuto.setName("boutonAuto");
			JButton boutonFuir = new JButton("S'ENFUIR");
			boutonFuir.setName("boutonFuir");
			if (!peuxFuir) {
				boutonFuir.setEnabled(false);
			}
			JButton boutonSeRendre = new JButton("SE RENDRE");
			boutonSeRendre.setName("boutonSeRendre");

			panelBoutonsGroupe.setMaximumSize(
					new Dimension(Constante.PANEL_BOUTON_GROUPE_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
			boutonAuto.setMaximumSize(panelBoutonsGroupe.getMaximumSize());
			boutonFuir.setMaximumSize(panelBoutonsGroupe.getMaximumSize());
			boutonSeRendre.setMaximumSize(panelBoutonsGroupe.getMaximumSize());

			boutonAuto.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				}
			});
			boutonFuir.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// Chance de fuir en fonction de la difficulte + nombre
					// ennemis restants (80% max - 20% min)

					// Chance de fuir en fonction du nombre d ennemis restants
					// (40% max - 10% min)
					int chanceFuite = 0;
					int nombreEnnemis = ennemisVivants.size(); // 1 a 8
					if (nombreEnnemis > 6) {
						chanceFuite = chanceFuite + 10;
					} else if (nombreEnnemis > 4) {
						chanceFuite = chanceFuite + 20;
					} else if (nombreEnnemis > 2) {
						chanceFuite = chanceFuite + 30;
					} else if (nombreEnnemis > 0) {
						chanceFuite = chanceFuite + 40;
					}

					// Chance de fuir en fonction de la difficulte (40% max -
					// 10% min)
					if (mission.getDifficulty() == MissionDifficulty.FACILE) {
						chanceFuite = chanceFuite + 40;
					} else if (mission.getDifficulty() == MissionDifficulty.NORMAL) {
						chanceFuite = chanceFuite + 30;
					} else if (mission.getDifficulty() == MissionDifficulty.DIFFICILE) {
						chanceFuite = chanceFuite + 20;
					} else if (mission.getDifficulty() == MissionDifficulty.HEROIQUE) {
						chanceFuite = chanceFuite + 10;
					}

					int randomFuite = RandomManager.random0_100();

					// Si on reussit a fuir
					if (randomFuite < chanceFuite) {
						// Message fuite reussi
						JOptionPane.showMessageDialog(FrameCombat.getFrameCombat(), "Vous avez réussi à fuir.");

						// On arrete la partie
						timerJoueurs.stop();
						win = false;
						stop(mission, win);
					} else {
						// TODO Sinon la partie continue avec un malus : action
						// negative si raté (mort, mana, charge, perte des
						// stats, de fric)
						// Message fuite echoue
						JOptionPane.showMessageDialog(FrameCombat.getFrameCombat(), "Vous n'avez pas réussi à fuir.");
						boutonFuir.setEnabled(false);
						peuxFuir = false;
					}

				}
			});
			boutonSeRendre.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO action negative se rendre (mort, mana, charge, perte
					// des stats, de fric) en fonction de la difficulte
					timerJoueurs.stop();
					win = false;
					stop(mission, win);
				}
			});

			panelBoutonsGroupe.add(boutonAuto);
			panelBoutonsGroupe.add(boutonFuir);
			panelBoutonsGroupe.add(boutonSeRendre);

			panelPerso.setBackground(Color.CYAN);
			panelBoutonsPerso.setBackground(Color.GREEN);
			panelInfosCombat.setBackground(Color.YELLOW);
			panelItemsCombat.setBackground(Color.PINK);
			panelBoutonsGroupe.setBackground(Color.BLACK);
			panelActions.setBackground(Color.RED);

			JScrollPane scrollPaneInfosCombat = new JScrollPane();
			// Vitesse de la barre de scroll
			JScrollBar jScrollBarInfos = new JScrollBar(1, 5, 5, 0, 10);
			jScrollBarInfos.setUnitIncrement(30);
			scrollPaneInfosCombat.setVerticalScrollBar(jScrollBarInfos);
			scrollPaneInfosCombat.getViewport().add(panelInfosCombat);

			JScrollPane scrollPaneItemsCombat = new JScrollPane();
			// Vitesse de la barre de scroll
			JScrollBar jScrollBarItems = new JScrollBar(1, 5, 5, 0, 10);
			jScrollBarItems.setUnitIncrement(30);
			scrollPaneItemsCombat.setVerticalScrollBar(jScrollBarItems);
			scrollPaneItemsCombat.getViewport().add(panelItemsCombat);
			scrollPaneItemsCombat.setHorizontalScrollBar(null);
			scrollPaneItemsCombat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			panelActions.add(panelPerso);
			panelActions.add(panelBoutonsPerso);
			panelActions.add(scrollPaneInfosCombat);
			panelActions.add(scrollPaneItemsCombat);
			panelActions.add(panelBoutonsGroupe);

			// Refresh Panel Bas
			panelActions
					.setPreferredSize(new Dimension(Constante.PANEL_MISSION_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
			panelActions.revalidate();
		}
	}

	private void buildMenuActions(Personnage perso) {

		menuActions.removeAll();

		JMenu menuAttaque = new JMenu("ATTAQUE");
		JMenu menuDefense = new JMenu("DEFENSE");
		JMenu menuPouvoir = new JMenu("POUVOIR");
		JMenu menuSpecial = new JMenu("SPECIAL");

		// Menu Attaque
		List<ActionCombat> actionsCombat = perso.getActionsCombat();

		if (actionsCombat != null) {
			for (ActionCombat actionCombat : actionsCombat) {
				// Si l'action est disponible
				if (actionCombat.isDisponible()) {
					AbstractButton action = configureBoutonAction(perso, actionCombat);

					if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE) {
						menuAttaque.add(action);
					} else if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE) {
						menuDefense.add(action);
					} else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR) {
						menuPouvoir.add(action);
					} else if (actionCombat.getActionCombatType() == ActionCombatType.SPECIAL) {
						menuSpecial.add(action);
					}
				}
			}
		}
		menuActions.add(menuAttaque);
		menuActions.add(menuDefense);
		menuActions.add(menuPouvoir);
		menuActions.add(menuSpecial);
	}

	// Creation des boutons ActionCombat
	private JMenu configureBoutonAction(Personnage lanceur, ActionCombat actionCombat) {

		JMenu menuAction = new JMenu("Niv. " + actionCombat.getNiveau() + " - " + actionCombat.getNom());
		testConsommationEnergie(menuAction, actionCombat, lanceur);
		JMenuItem menuCible = null;

		// Determination des cibles
		List<Personnage> cibles = new ArrayList<Personnage>();
		if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS
				|| actionCombat.getCibleType() == CibleType.ENNEMI) {
			for (Personnage ennemi : ennemisVivants) {
				cibles.add(ennemi);
			}
		} else if (actionCombat.getCibleType() == CibleType.GROUPE_ALLIES
				|| actionCombat.getCibleType() == CibleType.ALLIE) {
			// Cas particulier du REZ
			if (actionCombat.getSortType() == SortType.RESURRECTION_MONO
					|| actionCombat.getSortType() == SortType.RESURRECTION_MULTI) {
				cibles.addAll(amisPresents);
				for (Personnage ami : amisVivants) {
					cibles.remove(ami);
				}
			} else {
				for (Personnage ami : amisVivants) {
					cibles.add(ami);
				}
			}
		} else if (actionCombat.getCibleType() == CibleType.TOUS) {
			for (Personnage ennemi : ennemisVivants) {
				cibles.add(ennemi);
			}
			for (Personnage ami : amisVivants) {
				cibles.add(ami);
			}
		} else if (actionCombat.getCibleType() == CibleType.PERSO) {
			cibles.add(lanceur);
		}

		// Nombre de boutons cibles

		// Si plusieurs boutons cible
		if (actionCombat.getCibleType() == CibleType.ALLIE) {
			// Cas particulier du REZ
			if (actionCombat.getSortType() == SortType.RESURRECTION_MONO) {
				for (Personnage ami : amisPresents) {
					if (ami.isMort()) {
						menuCible = new JMenuItem(ami.getPrenom());
						menuCible.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// Execution du sort
								List<Personnage> unAmi = new ArrayList<Personnage>();
								unAmi.add(ami);
								executeSort(lanceur, actionCombat, unAmi, menuAction);
								revalidate();
							}
						});
						menuAction.add(menuCible);
					}
				}
			} else {
				for (Personnage ami : amisVivants) {
					menuCible = new JMenuItem(ami.getPrenom());
					menuCible.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Execution du sort
							List<Personnage> unAmi = new ArrayList<Personnage>();
							unAmi.add(ami);
							executeSort(lanceur, actionCombat, unAmi, menuAction);
							revalidate();
						}
					});
					menuAction.add(menuCible);
				}
			}

		} else if (actionCombat.getCibleType() == CibleType.ENNEMI) {
			for (Personnage ennemi : ennemisVivants) {
				menuCible = new JMenuItem(ennemi.getPrenom());
				menuCible.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> unEnnemi = new ArrayList<Personnage>();
						unEnnemi.add(ennemi);
						executeSort(lanceur, actionCombat, unEnnemi, menuAction);
						revalidate();
					}
				});
				menuAction.add(menuCible);
			}
			// Si un seul bouton cible
		} else {
			if (actionCombat.getCibleType() == CibleType.PERSO) {
				menuCible = new JMenuItem(lanceur.getPrenom());
			} else if (actionCombat.getCibleType() == CibleType.TOUS) {
				menuCible = new JMenuItem("Tout le monde");
			} else if (actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
				if (actionCombat.getSortType() == SortType.RESURRECTION_MULTI) {
					if (amisVivants.size() != amisPresents.size()) {
						menuCible = new JMenuItem("Tous les alliés morts");
					} else {
						return menuAction;
					}
				} else {
					menuCible = new JMenuItem("Tous les alliés");
				}
			} else if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
				menuCible = new JMenuItem("Tous les ennemis");
			}

			menuCible.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// Execution du sort
					executeSort(lanceur, actionCombat, cibles, menuAction);
					revalidate();
				}
			});
			menuAction.add(menuCible);
		}

		return menuAction;
	}

	private void testConsommationEnergie(AbstractButton action, ActionCombat actionCombat, Personnage perso) {
		// test consommation energie
		if (actionCombat.getEnergieType() == EnergieType.CHARGE) {
			if (perso.getNombreCharge() == 0) {
				action.setEnabled(false);
				action.setToolTipText("Pas assez de Charge");
			}
		} else if (actionCombat.getEnergieType() == EnergieType.MANA) {
			if (perso.getMana() < 10) {
				action.setEnabled(false);
				action.setToolTipText("Pas assez de Mana");
			}
		} else if (actionCombat.getEnergieType() == EnergieType.CHARGE_ET_MANA) {
			if (perso.getMana() < perso.getManaMax() / 2 || perso.getNombreCharge() != perso.getNombreChargeMax()) {
				action.setEnabled(false);
				action.setToolTipText("Pas assez de Charge et de Mana");
			}
		}
	}

	private void executeSort(Personnage lanceur, ActionCombat actionCombat, List<Personnage> cibles,
			AbstractButton action) {

		// TODO Gestion Amis/Ennemis

		// Gestion consommation energie
		int chargesConsommes = 0;
		if (actionCombat.getEnergieType() == EnergieType.CHARGE) {
			// On retire une charge
			chargesConsommes = 1;
			lanceur.setNombreCharge(lanceur.getNombreCharge() - 1);
		} else if (actionCombat.getEnergieType() == EnergieType.MANA) {
			// On retire 10 mana
			lanceur.setMana(lanceur.getMana() - 10);
		} else if (actionCombat.getEnergieType() == EnergieType.CHARGE_ET_MANA) {
			// On retire toutes les charges et la moitie du mana
			chargesConsommes = lanceur.getNombreCharge();
			lanceur.setNombreCharge(0);
			lanceur.setMana(lanceur.getMana() - (lanceur.getManaMax() / 2));
		}

		// PersonnagePrincipal / PersonnageEnnemi
		if (lanceur instanceof PersonnagePrincipal) {
			// PersonnagePrincipal

			// Augmente l'XP du sort
			actionCombat.setProgression(actionCombat.getProgression() + 1);
		} else {
			// PersonnageEnnemi

			// IA :Determination de la(les) cible(s)
			// cibles.clear();
			cibles = new ArrayList<Personnage>();
			if (actionCombat.getCibleType() == CibleType.ENNEMI) {
				// TODO cible en fonction de la difficulte aleatoire, aleatoire,
				// moins de vie, healer-moins de vie

				// cible aleatoire
				System.out.println("Persos presents : " + amisPresents.size());
				System.out.println("Persos vivants : " + amisVivants.size());
				int randomPerso = 0;
				if (!amisVivants.isEmpty()) {
					randomPerso = RandomManager.random(0, amisVivants.size() - 1);
				}
				Personnage cible = amisVivants.get(randomPerso);
				// TODO meilleurCible possible (moins de vie, healer)
				cibles.add(cible);
			} else if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
				cibles.addAll(amisVivants);
			} else if (actionCombat.getCibleType() == CibleType.ALLIE) {
				// TODO cible en fonction de la difficulte aleatoire, aleatoire,
				// moins de vie, healer-moins de vie
				// cible aleatoire
				System.out.println("Persos presents : " + amisVivants.size());
				int randomPerso = RandomManager.random(0, amisVivants.size() - 1);
				Personnage cible = ennemisVivants.get(randomPerso);
				// TODO meilleurCible possible (moins de vie, healer)
				cibles.add(cible);
			} else if (actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
				cibles.addAll(ennemisVivants);
			} else if (actionCombat.getCibleType() == CibleType.PERSO) {
				cibles.add(lanceur);
			} else if (actionCombat.getCibleType() == CibleType.TOUS) {
				cibles.addAll(ennemisVivants);
				cibles.addAll(amisVivants);
			}
		}

		// TODO gestion particuliere rez / stun / taunt / esquive / reflect
		// (score,critique)

		// Calcul du score
		int score = -1;
		boolean isCritique = false;
		int coupCritique = 1;
		int charge = 1;
		int niveau = 1;
		int min = 0;
		int max = 100;

		// TODO Score en fonction de la difficulte

		// PersonnagePrincipal / PersonnageEnnemi
		if (lanceur instanceof PersonnagePrincipal) {
			// PersonnagePrincipal

			// chance de critique : max = 33%
			// TODO son/image si critique
			int critique = lanceur.getCompetence().getLuck() / 3;
			int random = RandomManager.random(0, 100);
			if (random < critique) {
				// dégats de critique : max multiplicateur dégats x10
				coupCritique = lanceur.getCompetence().getExploit() / 10;
				isCritique = true;
			}

			// score en fonction du niveau du sort : max = x10
			niveau = actionCombat.getNiveau();

			// score min en fonction de la technique : max = 50
			min = lanceur.getCompetence().getTechnique() / 2;

			// score max en fonction de la competence du perso : max = 100
			max = lanceur.getCompetence().getStats().get(actionCombat.getPersoStat());

		} else {
			// PersonnageEnnemi

			// TODO score min/max en focntion des stats competences
			// score min en fonction de la difficulte 0,0,1,10
			// score max en fonction de la difficulte 20,40,70,100
			// niveau du sort en fonction de la difficulte +0,+1,+2,+3
			// chance de critique en fonction de la difficulte 5%,15%,25%,35%
			// dégats de critique en fonction de la difficulte x3,x5,x7,x10
			int random = RandomManager.random(0, 100);
			int chanceCritique = 1; // max chance de critique ennemi 35%
			int niveauMax = actionCombat.getNiveauMax();
			if (mission.getDifficulty() == MissionDifficulty.FACILE) {
				niveau = actionCombat.getNiveau();
				niveau = niveau + 0;
				min = 0;
				max = 20;
				chanceCritique = 5;
				if (random < chanceCritique) {
					coupCritique = 3;
					isCritique = true;
				}
			} else if (mission.getDifficulty() == MissionDifficulty.NORMAL) {
				niveau = actionCombat.getNiveau();
				niveau = niveau + 1;
				min = 0;
				max = 40;
				chanceCritique = 15;
				if (random < chanceCritique) {
					coupCritique = 5;
					isCritique = true;
				}
			} else if (mission.getDifficulty() == MissionDifficulty.DIFFICILE) {
				niveau = actionCombat.getNiveau();
				niveau = niveau + 2;
				min = 1;
				max = 70;
				chanceCritique = 25;
				if (random < chanceCritique) {
					coupCritique = 7;
					isCritique = true;
				}
			} else if (mission.getDifficulty() == MissionDifficulty.HEROIQUE) {
				niveau = actionCombat.getNiveau();
				niveau = niveau + 3;
				min = 10;
				max = 100;
				chanceCritique = 35;
				if (random < chanceCritique) {
					coupCritique = 10;
					isCritique = true;
				}
			}
			if (niveau > niveauMax) {
				niveau = niveauMax;
			}
		}

		if (min > max) {
			min = max;
		}

		// score en fonction du nombre de cibles si Multi (fonction difficulte?
		// => /2 /3 /4)
		int nombreCibles = cibles.size();

		// score en fonction du nombre de charge consommé (SPECIAL)
		if (actionCombat.getEnergieType() == EnergieType.CHARGE
				|| actionCombat.getEnergieType() == EnergieType.CHARGE_ET_MANA) {
			charge = chargesConsommes;
		}

		// Calcul du score
		score = (RandomManager.random(min, max) * coupCritique * niveau * charge) / nombreCibles;

		// TODO fail score = 0
		if (score == 0) {
		}

		// Animation lanceur de gauche a droite
		animationLanceur(lanceur, score, cibles);

		// TODO son/image si critique true

		// Affichage info sort
		JLabel messageInfoCombat = getMessage(lanceur, actionCombat, score, cibles, isCritique);
		panelInfosCombat.add(messageInfoCombat, 0);

		// Animation cible de haut en bas
		animationCible(lanceur, score, cibles);

		// Pour chaque cible
		for (Personnage cible : cibles) {
			// Distribution des dégats / protection / soins / absorption /
			// brulure / regen / stun

			// Si la cible est vivante ou que c'est un sort de rez
			if (!cible.isMort() || actionCombat.getSortType() == SortType.RESURRECTION_MONO
					|| actionCombat.getSortType() == SortType.RESURRECTION_MULTI) {

				// Si Bouclier
				if (actionCombat.getSortType() == SortType.BOUCLIER_PERSO
						|| actionCombat.getSortType() == SortType.BOUCLIER_MONO
						|| actionCombat.getSortType() == SortType.BOUCLIER_MULTI) {
					// Gestion defense de la cible
					cible.setBouclier(cible.getBouclier() + score);
				}
				// Si Regen Mana
				else if (actionCombat.getSortType() == SortType.REGEN_MANA_PERSO
						|| actionCombat.getSortType() == SortType.REGEN_MANA_MONO
						|| actionCombat.getSortType() == SortType.REGEN_MANA_MULTI) {
					// Gestion mana de la cible
					cible.setMana(cible.getMana() + score);
					if (cible.getMana() > cible.getManaMax()) {
						cible.setMana(cible.getManaMax());
					}
				}
				// Si Brulure de Mana
				else if (actionCombat.getSortType() == SortType.BRULURE_MANA_MONO
						|| actionCombat.getSortType() == SortType.BRULURE_MANA_MULTI) {
					// Gestion mana de la cible
					cible.setMana(cible.getMana() - score);
					if (cible.getMana() < 0) {
						cible.setMana(0);
					}
				}
				// Si Absorption Mana
				else if (actionCombat.getSortType() == SortType.ABSORPTION_MANA_MONO
						|| actionCombat.getSortType() == SortType.ABSORPTION_MANA_MULTI) {
					// Gestion mana du lanceur
					lanceur.setMana(lanceur.getMana() + score);
					if (lanceur.getMana() > lanceur.getManaMax()) {
						lanceur.setMana(lanceur.getManaMax());
					}
					// Gestion mana de la cible
					cible.setMana(cible.getMana() - score);
					if (cible.getMana() < 0) {
						cible.setMana(0);
					}
				}
				// Si Resurrection
				else if (actionCombat.getSortType() == SortType.RESURRECTION_MONO
						|| actionCombat.getSortType() == SortType.RESURRECTION_MULTI) {
					// Si critique
					if (isCritique) {
						// Resurrection de la cible : +100% de vie
						cible.setVie(cible.getVieMax());
					} else {
						// Resurrection de la cible : +10% de vie par niveau du
						// sort
						cible.setVie(
								cible.getVieMax() / ((actionCombat.getNiveauMax() + 1) - actionCombat.getNiveau()));
					}
					cible.setMort(false);
					cible.setaDejaJoue(true);
					// Reactive le bouton du perso regenere
					if (lanceur instanceof PersonnagePrincipal) {
						amisVivants.add((PersonnagePrincipal) cible);
						for (JButton bouton : boutonsAmis) {
							if (bouton.getName().equals(cible.getPrenom())) {
								bouton.setEnabled(true);
							}
						}
					} else {
						ennemisVivants.add((PersonnageEnnemi) cible);
						for (JButton bouton : boutonsEnnemis) {
							if (bouton.getName().equals(cible.getPrenom())) {
								bouton.setEnabled(true);
							}
						}
					}
					// TODO refresh resurrection ou pas
				}
				// Si Soins
				else if (actionCombat.getSortType() == SortType.REGEN_VIE_PERSO
						|| actionCombat.getSortType() == SortType.REGEN_VIE_MONO
						|| actionCombat.getSortType() == SortType.REGEN_VIE_MULTI) {
					// Gestion vie de l'allie
					cible.setVie(cible.getVie() + score);
					if (cible.getVie() > cible.getVieMax()) {
						cible.setVie(cible.getVieMax());
					}
				}
				// TODO Si Aura
				else if (actionCombat.getSortType() == SortType.AURA_PERSO
						|| actionCombat.getSortType() == SortType.AURA_MONO
						|| actionCombat.getSortType() == SortType.AURA_MULTI) {
					// TODO Gestion aura de la cible

				}
				// TODO Si Stun
				else if (actionCombat.getSortType() == SortType.STUN_MONO
						|| actionCombat.getSortType() == SortType.STUN_MULTI) {
					// if (isCritique) {
					// cible.setBloque(2);
					// } else {
					// cible.setBloque(1);
					// }
				}
				// Si Taunt
				else if (actionCombat.getSortType() == SortType.TAUNT_MONO
						|| actionCombat.getSortType() == SortType.TAUNT_MULTI) {
					// TODO Gestion taunt de la cible

				}
				// Si Renvoi Degats
				else if (actionCombat.getSortType() == SortType.RENVOI_DEGATS_PERSO) {
					// TODO Gestion renvoi degats de la cible

				}
				// Si Esquive
				else if (actionCombat.getSortType() == SortType.ESQUIVE) {
					if (isCritique) {
						cible.setNombreEsquive(2);
					} else {
						cible.setNombreEsquive(1);
					}
				}
				// Si dégats
				else {

					// Si Absorption Vie
					if (actionCombat.getSortType() == SortType.ABSORPTION_VIE_MONO
							|| actionCombat.getSortType() == SortType.ABSORPTION_VIE_MULTI) {
						// Gestion vie du lanceur
						lanceur.setVie(lanceur.getVie() + score);
						if (lanceur.getVie() > lanceur.getVieMax()) {
							lanceur.setVie(lanceur.getVieMax());
						}
					}

					// Si la cible a un bouclier
					if (cible.getBouclier() > 0) {
						cible.setBouclier(cible.getBouclier() - score);
						if (cible.getBouclier() < 0) {
							cible.setBouclier(0);
						}
					}

					// Sinon on retire de la vie a la cible
					else {
						System.out.println("Cible avant sort : " + cible.toString());

						// TODO Esquive (10% Chance - 10% Agilite - 10% Vitesse)
						int chanceEsquive = (cible.getCompetence().getLuck() / 10)
								+ (cible.getCompetence().getAgilite() / 10)
								+ (cible.getCompetence().getRapidite() / 10);
						int random = RandomManager.random0_100();

						// Gestion sort Esquive
						if (cible.getNombreEsquive() > 0) {
							chanceEsquive = 100;
							cible.setNombreEsquive(cible.getNombreEsquive() - 1);
						}

						// Esquive : max 30%
						if (random < chanceEsquive) {
							JLabel labelEsquive = new JLabel(cible.getPrenom() + " a esquivé l'attaque de "
									+ lanceur.getPrenom() + " avec (" + chanceEsquive + "%) de chance.");
							panelInfosCombat.add(labelEsquive, 0);
							revalidate();
						}
						// Esquive raté
						else {
							// Reduction degats en fonction de la resistance
							// : max -80% degats
							int reductionDegats = cible.getCompetence().getResistance() - 20;
							if (reductionDegats < 0) {
								reductionDegats = 0;
							}
							int degatsReels = score - ((score * reductionDegats) / 100);

							JLabel labelDegatsReel = new JLabel(cible.getPrenom() + " a subit " + score + " (-"
									+ (score - degatsReels) + ") dégats.");
							panelInfosCombat.add(labelDegatsReel, 0);
							revalidate();

							// Degats infligés
							cible.setVie(cible.getVie() - degatsReels);

							// Gestion vie/mort de l'ennemi
							if (cible.getVie() <= 0) {
								cible.setVie(0);
								cible.setMort(true);

								// Grise le bouton du perso
								if (lanceur instanceof PersonnagePrincipal) {
									ennemisVivants.remove(cible);
									for (JButton bouton : boutonsEnnemis) {
										if (bouton.getName().equals(cible.getPrenom())) {
											bouton.setEnabled(false);
										}
									}
								} else {
									amisVivants.remove(cible);
									for (JButton bouton : boutonsAmis) {
										if (bouton.getName().equals(cible.getPrenom())) {
											bouton.setEnabled(false);
										}
									}
								}
								// Message Info Combat ennemi mort
								JLabel labelMort = new JLabel(
										lanceur.getPrenom() + " a tué " + cible.getPrenom() + ".");
								// label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
								labelMort.setForeground(Color.RED);
								// label.setForeground(perso.getCouleur());
								panelInfosCombat.add(labelMort, 0);
								revalidate();

								// Test Fin du jeu
								boolean fin = true;
								if (lanceur instanceof PersonnagePrincipal) {
									for (JButton bouton : boutonsEnnemis) {
										if (bouton.isEnabled()) {
											fin = false;
										}
									}
									if (fin) {
										win = true;
										stop(mission, win);
									}
								} else {
									for (JButton bouton : boutonsAmis) {
										if (bouton.isEnabled()) {
											fin = false;
										}
									}
									if (fin) {
										win = false;
										stop(mission, win);
									}
								}
								if (lanceur instanceof PersonnagePrincipal) {
									// Refresh menu perso monoEnnemi
									buildMenuActions(lanceur);
								}
							}
						}
					}
				}
				System.out.println("Cible apres sort : " + cible.toString());

				// TODO ajoute charge que quand degats ???
				// Ajoute une charge a chaque cible
				cible.ajouteUneCharge();
			}

		}
		
		if (lanceur instanceof PersonnagePrincipal) {
			// gestion une action par perso par tour
			lanceur.setaDejaJoue(true);
			
			// // Refresh menu perso pour gestion mana et charge
			// buildMenuActions(perso);

			// Passe au prochain perso qui peux jouer
			PersonnagePrincipal persoDispo = null;
			for (PersonnagePrincipal persoPresent : amisVivants) {
				if (!persoPresent.isaDejaJoue()) {
					persoDispo = persoPresent;
				}
			}
			if (persoDispo == null) {
				// Fin du tour des joueurs
				repaint();
				revalidate();
				lanceTourEnnemis();
			} else {
				// Prochain perso dispo
				buildPanelActions(persoDispo.getPrenomPerso());
				revalidate();
			}
		}
		
		// Refresh panelCentre vie/mana/charge/bouclier
		buildPanelCentre();

	}

	private JLabel getMessage(Personnage perso, ActionCombat actionCombat, int score, List<Personnage> cibles,
			boolean isCritique) {

		JLabel label = null;

		String lance = " lance ";
		if (actionCombat.getActionCombatType() == ActionCombatType.SPECIAL) {
			lance = " lance son 'Special' ";
		}

		int nbTour = 1;
		if (isCritique) {
			nbTour = 2;
		}

		// Attaque Mono ennemi
		if (actionCombat.getSortType() == SortType.DEGATS_MONO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et inflige " + score + " dégats à "
					+ cibles.get(0).getPrenom() + ".");
		}
		// Attaque Multi ennemis
		else if (actionCombat.getSortType() == SortType.DEGATS_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et inflige " + score
					+ " dégats à tous les ennemis.");
		}
		// Attaque All
		else if (actionCombat.getSortType() == SortType.DEGATS_ALL) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et inflige " + score
					+ " dégats à tout le monde.");
		}
		// Bouclier Perso
		else if (actionCombat.getSortType() == SortType.BOUCLIER_PERSO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et se protege avec un bouclier ("
					+ score + ").");
		}
		// Bouclier Mono ami
		else if (actionCombat.getSortType() == SortType.BOUCLIER_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et protege "
					+ personnageCible.getPrenom() + " avec un bouclier (" + score + ").");
		}
		// Bouclier Multi amis
		else if (actionCombat.getSortType() == SortType.BOUCLIER_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom()
					+ " et protege tous les alliés avec un bouclier (" + score + ").");
		}
		// Soins Perso
		else if (actionCombat.getSortType() == SortType.REGEN_VIE_PERSO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et se soigne de " + score
					+ " points de vie.");
		}
		// Soins Mono ami
		else if (actionCombat.getSortType() == SortType.REGEN_VIE_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et soigne " + score
					+ " points de vie à " + personnageCible.getPrenom() + ".");
		}
		// Soins Multi amis
		else if (actionCombat.getSortType() == SortType.REGEN_VIE_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et soigne " + score
					+ " points de vie à tous les alliés.");
		}
		// Absorption vie mono
		else if (actionCombat.getSortType() == SortType.ABSORPTION_VIE_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et absorbe " + score
					+ " points de vie à " + personnageCible.getPrenom() + ".");
		}
		// Absorption vie multi
		else if (actionCombat.getSortType() == SortType.ABSORPTION_VIE_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et absorbe " + score
					+ " points de vie à tous les ennemis.");
		}
		// Regen Mana Perso
		else if (actionCombat.getSortType() == SortType.REGEN_MANA_PERSO) {
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et se redonne " + score + " points de mana.");
		}
		// Regen Mana Mono
		else if (actionCombat.getSortType() == SortType.REGEN_MANA_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et redonne " + score
					+ " points de mana à " + personnageCible.getPrenom() + ".");
		}
		// Regen Mana Multi
		else if (actionCombat.getSortType() == SortType.REGEN_MANA_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et redonne " + score
					+ " points de mana à tous les alliés.");
		}
		// Brulure Mana Mono
		else if (actionCombat.getSortType() == SortType.BRULURE_MANA_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et brule " + score
					+ " points de mana à " + personnageCible.getPrenom() + ".");
		}
		// Brulure Mana Multi
		else if (actionCombat.getSortType() == SortType.BRULURE_MANA_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et brule " + score
					+ " points de mana à tous les ennemis.");
		}
		// Absorption mana mono
		else if (actionCombat.getSortType() == SortType.ABSORPTION_MANA_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et absorbe " + score
					+ " points de mana à " + personnageCible.getPrenom() + ".");
		}
		// Absorption mana multi
		else if (actionCombat.getSortType() == SortType.ABSORPTION_MANA_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et absorbe " + score
					+ " points de mana à tous les ennemis.");
		}
		// Aura Perso
		else if (actionCombat.getSortType() == SortType.AURA_PERSO) {
			label = new JLabel(perso.getNom() + lance + actionCombat.getNom() + " et se protège avec une aura.");
		}
		// Aura Mono
		else if (actionCombat.getSortType() == SortType.AURA_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et protège "
					+ personnageCible.getPrenom() + " avec une aura.");
		}
		// Aura Multi
		else if (actionCombat.getSortType() == SortType.AURA_MULTI) {
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et protège tous les alliés avec une aura.");
		}
		// Resurrection Mono
		else if (actionCombat.getSortType() == SortType.RESURRECTION_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et redonne la vie à "
					+ personnageCible.getPrenom() + ".");
		}
		// Resurrection Multi
		else if (actionCombat.getSortType() == SortType.RESURRECTION_MULTI) {
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et redonne la vie à tous les alliés morts.");
		}
		// Esquive
		else if (actionCombat.getSortType() == SortType.ESQUIVE) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom()
					+ " et obtient 100% de chance d'esquiver pour " + nbTour + " tour(s).");
		}
		// Renvoi degats
		else if (actionCombat.getSortType() == SortType.RENVOI_DEGATS_PERSO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom()
					+ " et se met en position de renvoi de degats pour " + nbTour + " tour(s).");
		}
		// Stun Mono
		else if (actionCombat.getSortType() == SortType.STUN_MONO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et bloque "
					+ cibles.get(0).getPrenom() + " pour " + nbTour + " tour(s).");
		}
		// Stun Multi
		else if (actionCombat.getSortType() == SortType.STUN_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et bloque tous les ennemis pour "
					+ nbTour + " tour(s).");
		}
		// Taunt Mono
		else if (actionCombat.getSortType() == SortType.TAUNT_MONO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et provoque "
					+ cibles.get(0).getPrenom() + " pour " + nbTour + " tour(s).");
		}
		// Taunt Multi
		else if (actionCombat.getSortType() == SortType.TAUNT_MULTI) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et provoque tous les ennemis pour "
					+ nbTour + " tour(s).");
		}

		else {
			System.out.println("Ne devrait pas arriver la");
		}

		// Si critique
		if (isCritique) {
			label.setText("(CRITIQUE) " + label.getText());
		}

		// label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
		// label.setForeground(perso.getCouleur());
		return label;
	}

	private void animationLanceur(Personnage lanceur, int score, List<Personnage> cibles) {
		// TODO Deplacement de la fenetre du lanceur de gauche a droite

	}

	private void animationCible(Personnage lanceur, int score, List<Personnage> cibles) {
		// TODO Deplacement de la fenetre de la cible de haut en bas

		// TODO Affichage du score sur les cibles

	}

	public void start() {
		MenuPrincipal.getMainFrame().setEnabled(false);
		MenuPrincipal.getMainFrame().setVisible(false);
		VideoManager.hideAndStop();
		MusiqueManager.stop();
		JOptionPane.showMessageDialog(this, "Debut du jeu");

		// -- TODO Gestion IA
		lancePartiePremiereFois();
	}

	// Fin du jeu
	private void stop(Mission mission, boolean win) {
		
		// Remise a zero pour prochain combat (duplique avec lancePartie())
		for (PersonnagePrincipal ami : amisPresents){
			ami.setaDejaJoue(false);
		}
		if (timerEnnemis != null && timerEnnemis.isRunning()) {
			timerEnnemis.stop();
		}
		if (timerJoueurs != null && timerJoueurs.isRunning()) {
			timerJoueurs.stop();
		}
			
		// Message fin du jeu
		if (win) {
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautVictoire.png");
			JOptionPane.showMessageDialog(this, "Victoire !", "Fin du combat", 0, icon);
		} else {
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautDefaite.png");
			JOptionPane.showMessageDialog(this, "Defaite !", "Fin du combat", 0, icon);
		}

		// Gestion de la progression des sorts

		// Pour chaque sort
		List<ActionCombat> allActions = MenuPrincipal.getMainFrame().getCoreManager().getActionCombatManager()
				.getActionsCombatPersosPrincipaux();
		for (ActionCombat actionCombat : allActions) {
			// Si la barre de progression est pleine
			// niv1=10, niv2=20, .. , niv10=100
			if (actionCombat.getProgression() >= actionCombat.getNiveau() * 10) {
				// On ameliore le sort
				if (actionCombat.amelioreItem()) {
					// TODO son sort ameliore
					// Message sort ameliore
					JOptionPane.showMessageDialog(this,
							"Le sort de " + actionCombat.getProprietaire().name() + " : '" + actionCombat.getNom() + "' a progressé d'un niveau ! ("
									+ actionCombat.getNiveau() + ")",
							"Progression d'un sort", 0, new ImageIcon(actionCombat.getImagePath().get(0)));
				} else {
					// TODO Si item au niveau Max
				}
			}
		}

		// Fermeture de la frame combat et reaffichage de la mainframe
		this.dispose();
		MenuPrincipal.getMainFrame().setEnabled(true);
		MenuPrincipal.getMainFrame().setVisible(true);
		VideoManager.show();
		MusiqueManager.stop();

		// Fin de la mission
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, win);
	}

	private void centreFenetre() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}

	private void manageItemSelectionne(PersoPrenom prenom) {
		if (itemSelectionne != null) {
			int reponse = JOptionPane.showConfirmDialog(this,
					"T'es sur de vouloir utiliser " + itemSelectionne.getNom() + " sur " + prenom.name() + "?");
			if (reponse == 0) {
				// OUI
				boolean itemConsomme = itemSelectionne.consommeItem();
				if (itemConsomme) {
					JOptionPane.showMessageDialog(this, "Consomme : " + itemSelectionne.getNom());
					JLabel label = new JLabel(prenom.name() + " consomme " + itemSelectionne.getNom() + ".");
					// label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
					panelInfosCombat.add(label, 0);
					// TODO setDisponible(false)? ou etat consomme?
					itemSelectionne.setDisponible(false);

				} else {
					JOptionPane.showMessageDialog(this,
							"L'item : " + itemSelectionne.getNom() + " n'a pas pu etre consomme : raison");
				}
			}
			// TODO : remettre curseur souris normal
			panelOuest.setBorder(null);
			itemSelectionne = null;
		}
	}

	private void lancePartiePremiereFois() {
		// Initiative : quelle equipe commence? basé sur une competence + random
		// TODO initiative basé sur une competence
		boolean initiative = false;
		int random = RandomManager.random0_100();
		int chanceInitiative = 0;

		// tempsMax en fonction de la difficulte (oo, 45, 30, 20)
		// chanceInitiative en fonction de la difficulte (100, 75, 50, 25)
		if (mission.getDifficulty() == MissionDifficulty.FACILE) {
			tempsMax = 0; // TODO pas de timer
			chanceInitiative = 100;
		} else if (mission.getDifficulty() == MissionDifficulty.NORMAL) {
			tempsMax = 45;
			chanceInitiative = 75;
		} else if (mission.getDifficulty() == MissionDifficulty.DIFFICILE) {
			tempsMax = 30;
			chanceInitiative = 50;
		} else if (mission.getDifficulty() == MissionDifficulty.HEROIQUE) {
			tempsMax = 20;
			chanceInitiative = 25;
		}
		timerJoueurs = new Timer(10, new MyJoueurActionListener(tempsMax));

		if (random < chanceInitiative) {
			initiative = true;
		}
		
		if (!initiative) {
			JOptionPane.showMessageDialog(this, "Vous avez perdu l'initiative!");

			for (PersonnagePrincipal perso : amisVivants) {
				perso.setaDejaJoue(true);
			}
			lanceTourEnnemis();
		} else {

			for (PersonnagePrincipal perso : amisVivants) {
				perso.setaDejaJoue(false);
			}
			
			// lance tour joueurs
			JOptionPane.showMessageDialog(this, "Vous avez gagné l'initiative!");
			JOptionPane.showMessageDialog(this, "Tour des allies");

			// TODO lance chrono tour joueurs si difficulte facile+
			if (tempsMax != 0) {
				timerJoueurs.start();
			}
		}
	}

	// Gestion de l'IA (tour par tour / dynamique)
	private void lanceTourEnnemis() {

		// lance tour ennemis
		JOptionPane.showMessageDialog(this, "Tour des ennemis");

		timerEnnemis = new Timer(1000, new MyEnnemiActionListener());
		timerEnnemis.setInitialDelay(100);
		timerEnnemis.start();
	}

	private ActionCombat selectionneAttaqueEnnemi(PersonnageEnnemi ennemi) {
		List<ActionCombat> actionsCombat = ennemi.getActionsCombat();
		ActionCombat action = null;
		ActionCombat meilleurAction = null;
		ActionCombat actionDeBase = null;
		for (ActionCombat actionCombat : actionsCombat) {
			boolean sortLancable = testConsommationEnergieEnnemi(ennemi, actionCombat);
			if (sortLancable) {
				if (actionCombat.getActionCombatType() == ActionCombatType.SPECIAL) {
					meilleurAction = action;
					break;
				} else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR) {
					meilleurAction = action;
				} else if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE) {
					meilleurAction = action;
				} else if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE) {
					actionDeBase = actionCombat;
				}
			}
		}

		// Si on peux lancer un sort avec consommation, on le fait
		if (meilleurAction == null) {
			action = actionDeBase;
		} else {
			action = meilleurAction;
		}

		return action;
	}

	private boolean testConsommationEnergieEnnemi(PersonnageEnnemi ennemi, ActionCombat actionCombat) {
		boolean lancable = true;
		if (actionCombat.getEnergieType() == EnergieType.MANA) {
			if (ennemi.getMana() < 10) {
				lancable = false;
			}
		} else if (actionCombat.getEnergieType() == EnergieType.CHARGE) {
			if (ennemi.getNombreCharge() == 0) {
				lancable = false;
			}
		} else if (actionCombat.getEnergieType() == EnergieType.CHARGE_ET_MANA) {
			if (ennemi.getNombreCharge() != ennemi.getNombreChargeMax() || ennemi.getMana() < ennemi.getManaMax() / 2) {
				lancable = false;
			}
		}
		return lancable;
	}

	private void buildPanelCentre() {

		panelCentre.removeAll();

		BoxLayout boxlayoutCombat = new BoxLayout(panelCentre, BoxLayout.Y_AXIS);
		panelCentre.setLayout(boxlayoutCombat);

		JPanel panelJoueurs = new JPanel();
//		BoxLayout boxlayoutJoueurs = new BoxLayout(panelJoueurs, BoxLayout.Y_AXIS);
//		panelJoueurs.setLayout(boxlayoutJoueurs);
//		panelJoueurs.setAlignmentY(CENTER_ALIGNMENT);
//		panelJoueurs.setAlignmentX(CENTER_ALIGNMENT);

		JPanel panelAdversaires = new JPanel();
//		BoxLayout boxlayoutAdversaires = new BoxLayout(panelAdversaires, BoxLayout.Y_AXIS);
//		panelAdversaires.setLayout(boxlayoutAdversaires);
//		panelJoueurs.setAlignmentY(CENTER_ALIGNMENT);
//		panelJoueurs.setAlignmentX(CENTER_ALIGNMENT);

		for (PersonnagePrincipal perso : amisVivants) {
			JPanel panelPerso = buildPanelPerso(perso);
			panelJoueurs.add(panelPerso);
		}

		for (PersonnageEnnemi perso : ennemisVivants) {
			JPanel panelPerso = buildPanelPerso(perso);
			panelAdversaires.add(panelPerso);
		}

		labelTimer = new JLabel("OO");

		panelCentre.add(panelAdversaires);
		panelCentre.add(labelTimer);
		panelCentre.add(panelJoueurs);
	}

	private JPanel buildPanelPerso(Personnage perso) {
		JPanel panelPerso = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panelPerso, BoxLayout.Y_AXIS);
		panelPerso.setLayout(boxlayout);
		int largeur = Constante.PANEL_INFO_PERSO_LARGEUR;
		// panelPerso.setMinimumSize(new Dimension(largeur, 200));

		// Largeur 100
		JPanel barreCharge = new JPanel();
		barreCharge.setBackground(Color.YELLOW);
		barreCharge.add(new JLabel(perso.getNombreCharge() + "/" + perso.getNombreChargeMax()));
		JPanel barreMana = new JPanel();
		barreMana.setBackground(Color.BLUE);
		barreMana.add(new JLabel(perso.getMana() + "/" + perso.getManaMax()));
		JPanel barreBouclier = new JPanel();
		barreBouclier.setBackground(Color.WHITE);
		barreBouclier.add(new JLabel(String.valueOf(perso.getBouclier())));
		JPanel barreVie = new JPanel();
		barreVie.setBackground(Color.RED);
		barreVie.add(new JLabel(perso.getVie() + "/" + perso.getVieMax()));
		JPanel barrePersonnage = new JPanel();
		barrePersonnage.add(new JLabel(perso.getPrenom()));

		panelPerso.add(barreCharge);
		panelPerso.add(barreMana);
		panelPerso.add(barreBouclier);
		panelPerso.add(barreVie);
		panelPerso.add(barrePersonnage);

		return panelPerso;
	}

	public static FrameCombat getFrameCombat() {
		return (FrameCombat) panelCentre.getParent().getParent().getParent().getParent();
	}

	public class MyEnnemiActionListener implements ActionListener {

		private int index = ennemisVivants.size() - 1;

		@Override
		public void actionPerformed(ActionEvent e) {

			menuActions.setEnabled(false);
			for (int i = 0; i < 3; i++) {
				Component component = panelBoutonsGroupe.getComponent(i);
				component.setEnabled(false);
			}

			for (JButton boutonAmi : boutonsAmis) {
				boutonAmi.setFocusable(false);
			}

			if (!ennemisVivants.isEmpty() && !amisVivants.isEmpty()) {

			// Probleme quand sort dernier perso est un rez
			// Probleme java.lang.ArrayIndexOutOfBoundsException: -1 sur index
				PersonnageEnnemi ennemi = ennemisVivants.get(index);

				// Selectionne une attaque ennemi
				ActionCombat actionCombat = selectionneAttaqueEnnemi(ennemi);

				// lance attaque ennemi
				executeSort(ennemi, actionCombat, null, null);

				index = index - 1;

				// Quand tous les ennemis ont joue ou que tous les persos sont
				// morts
				if (index == -1 || amisVivants.isEmpty()) {
					timerEnnemis.stop();

					// Chaque persos vivants peut rejouer
					for (PersonnagePrincipal perso : amisVivants) {
						perso.setaDejaJoue(false);
					}

					// Reactive les boutons grises
					menuActions.setEnabled(true);
					for (int i = 0; i < 3; i++) {
						Component component = panelBoutonsGroupe.getComponent(i);
						if (component.getName().equals("boutonFuir") && !peuxFuir) {
							component.setEnabled(false);
						} else {
							component.setEnabled(true);
						}
					}

					// Raffraichissment panel Bas sur un perso vivant
					if (!amisVivants.isEmpty()) {
						PersoPrenom prenom = amisVivants.get(0).getPrenomPerso();
						buildPanelActions(prenom);

						// Message tour allie
						JOptionPane.showMessageDialog(FrameCombat.getFrameCombat(), "Tour des allies");

						// Lance chrono tour joueurs si difficulte normal+
						if (tempsMax != 0) {
							timerJoueurs.start();
						}
					}

				}
			} else {
				timerEnnemis.stop();
			}

			// TODO Affichage panel centre

			// Refresh
			revalidate();
			repaint();
		}
	}

	public class MyJoueurActionListener implements ActionListener {

		private double time;
		private double maxTime;
		private boolean running = false;

		public MyJoueurActionListener(double maxTime) {
			super();
			this.time = maxTime;
			this.maxTime = maxTime;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			this.time = time - 0.01;
			String format = String.format("%1$,.2f", time);
			labelTimer.setText(format);
			labelTimer.setForeground(Color.GREEN);
			if (time < (maxTime / 2)) {
				labelTimer.setForeground(Color.ORANGE);
			}
			if (time < (maxTime / 4)) {
				labelTimer.setForeground(Color.RED);
			}
			// Tic Tac quand il reste 4s
			if (time <= 4) {

				if (!running) {
					MusiqueManager.playSon("sonParDefaut/tictac.mp3");
					running = true;
				}

			}

			// On arrete le timer si tous les joueurs ont deja joue
			boolean finTourJoueurs = true;
			for (PersonnagePrincipal perso : amisVivants) {
				if (!perso.isaDejaJoue()) {
					finTourJoueurs = false;
				}
			}

			// Fin du Timer
			if (time <= 0 || finTourJoueurs) {
				// TODO son Ding de fin de timer
				// MusiqueManager.playSon("sonParDefaut/ding.mp3");

				labelTimer.setText(String.format("%1$,.2f", new Double(0.0)));

				// Quand le timer arrive a 0, on l'arrete
				timerJoueurs.stop();

				// On reinitialise le chrono pour le prochain tour
				time = maxTime;
				// Attention : ici on suppose que le son tictac de fin de timer
				// est fini, sinon il se relancera
				running = false;

				// On lance le tour ennemis
				if (!finTourJoueurs) {
					lanceTourEnnemis();
				}
			}
		}
	}
}
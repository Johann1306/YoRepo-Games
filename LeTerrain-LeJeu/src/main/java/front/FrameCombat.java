package front;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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

public class FrameCombat extends FrameJeu {

	private static final long serialVersionUID = 1L;

	private static boolean win;

	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private JPanel panelCentre = new JPanel();
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
	private List<Personnage> ennemis = null;

	private JMenu menuActions = new JMenu("ACTIONS");
	private Mission mission;

	public FrameCombat(Groupe groupe, Mission mission) {
		this.mission = mission;
		win = false;
		PersoPrenom firstPerso = null;

		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		JPanel panelActions = new JPanel();
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

		boutonNicolas.setName(nicolas.getPrenom().name());
		boutonPierre.setName(pierre.getPrenom().name());
		boutonYannick.setName(yannick.getPrenom().name());
		boutonThomas.setName(thomas.getPrenom().name());
		boutonJohann.setName(johann.getPrenom().name());
		boutonAli.setName(ali.getPrenom().name());
		boutonGuillaume.setName(guillaume.getPrenom().name());
		boutonJonathan.setName(jonathan.getPrenom().name());

		JPanel panelPersos = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panelPersos, BoxLayout.Y_AXIS);
		panelPersos.setLayout(boxlayout);

		if (thomas.isDejaPresente()) {
			panelPersos.add(boutonThomas);
			if (firstPerso == null) {
				firstPerso = thomas.getPrenom();
			}
		}
		if (guillaume.isDejaPresente()) {
			panelPersos.add(boutonGuillaume);
			if (firstPerso == null) {
				firstPerso = guillaume.getPrenom();
			}
		}
		if (nicolas.isDejaPresente()) {
			panelPersos.add(boutonNicolas);
			if (firstPerso == null) {
				firstPerso = nicolas.getPrenom();
			}
		}
		if (pierre.isDejaPresente()) {
			panelPersos.add(boutonPierre);
			if (firstPerso == null) {
				firstPerso = pierre.getPrenom();
			}
		}
		if (jonathan.isDejaPresente()) {
			panelPersos.add(boutonJonathan);
			if (firstPerso == null) {
				firstPerso = jonathan.getPrenom();
			}
		}
		if (yannick.isDejaPresente()) {
			panelPersos.add(boutonYannick);
			if (firstPerso == null) {
				firstPerso = yannick.getPrenom();
			}
		}
		if (johann.isDejaPresente()) {
			panelPersos.add(boutonJohann);
			if (firstPerso == null) {
				firstPerso = johann.getPrenom();
			}
		}
		if (ali.isDejaPresente()) {
			panelPersos.add(boutonAli);
			if (firstPerso == null) {
				firstPerso = ali.getPrenom();
			}
		}

		boutonNicolas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Nicolas);
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Pierre);
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Yannick);
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Thomas);
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Johann);
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Ali);
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Guillaume);
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.Jonathan);
			}
		});

		panelOuest.add(panelPersos);

		// -- Panel Centre

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
		ennemis = new ArrayList<Personnage>();
		if (mission.getMissionType() == MissionType.BOSS) {
			PersonnageBoss boss = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
					.getPersonnageBossByNom(mission.getBossNom());
			ennemis.add(boss);
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
			ennemis.add(ennemi);
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
		buildPanelActions(panelActions, firstPerso);

		panelSud.add(panelActions);
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

		// -- TODO Gestion IA
		// lancePartie();

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

	private void buildPanelActions(JPanel panelActions, PersoPrenom prenom) {

		manageItemSelectionne(prenom);

		// TODO : mieux que removeAll()
		panelActions.removeAll();
		BoxLayout boxlayoutActions = new BoxLayout(panelActions, BoxLayout.X_AXIS);
		panelActions.setLayout(boxlayoutActions);
		PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
				.getPersoByPrenom(prenom);

		// Photo perso selectionne
		JPanel panelPerso = new JPanel();
		JLabel labelPerso = new JLabel(perso.getPhotoPrincipal());
		panelPerso.setMaximumSize(new Dimension(Constante.PANEL_COMBAT_PERSO_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
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

		panelBoutonsPerso.add(new JLabel("VIE MAX : " + perso.getCompetence().getEndurance()));
		panelBoutonsPerso.add(new JLabel("ATTAQUE : " + perso.getCompetence().getTechnique()));
		panelBoutonsPerso.add(new JLabel("CRITIQUE : " + perso.getCompetence().getExploit()));
		panelBoutonsPerso.add(new JLabel("DEFENSE : " + perso.getCompetence().getResistance()));
		panelBoutonsPerso.add(new JLabel("REGEN : " + perso.getCompetence().getRapidite()));
		panelBoutonsPerso.add(new JLabel("MANA : " + perso.getCompetence().getIntelligence()));
		panelBoutonsPerso.add(new JLabel("CHARGE : " + perso.getCompetence().getNoobisme()));
		panelBoutonsPerso.add(new JLabel("AGILITE : " + perso.getCompetence().getAgilite()));
		panelBoutonsPerso.add(new JLabel("CHANCE : " + perso.getCompetence().getLuck()));
		panelBoutonsPerso.add(panelMenu);
		panelBoutonsPerso
				.setMaximumSize(new Dimension(Constante.PANEL_ACTION_PERSO_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));

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
					// TODO changer l icone de la souris jusqu a ce que l item
					// soit utilise
				}
			});
			panelItemsCombat.add(boutonItem);
		}
//		panelItemsCombat.setMaximumSize(Constante.ITEM_CONSOMMABLE_DIMENSION);
//		panelItemsCombat.setMinimumSize(Constante.ITEM_CONSOMMABLE_DIMENSION);
		// TODO mieux
//		panelItemsCombat
//				.setMinimumSize(new Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
//		panelItemsCombat
//				.setMaximumSize(new Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
//		panelItemsCombat.setSize(new Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
//		panelItemsCombat
//				.setPreferredSize(new Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));

		// Boutons groupe combat
		JPanel panelBoutonsGroupe = new JPanel();
		BoxLayout boxlayoutBoutonsGroupe = new BoxLayout(panelBoutonsGroupe, BoxLayout.Y_AXIS);
		panelBoutonsGroupe.setLayout(boxlayoutBoutonsGroupe);

		JButton boutonAuto = new JButton("COMBAT AUTO");
		JButton boutonFuir = new JButton("S'ENFUIR");
		JButton boutonSeRendre = new JButton("SE RENDRE");

		panelBoutonsGroupe
				.setMaximumSize(new Dimension(Constante.PANEL_BOUTON_GROUPE_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
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
				win = false;
				stop(mission, win);
			}
		});
		boutonSeRendre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		panelActions.setPreferredSize(new Dimension(Constante.PANEL_MISSION_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
		panelActions.revalidate();
	}

	private void buildMenuActions(PersonnagePrincipal perso) {

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

	// Gestion des Actions (ATTAQUE, DEFENSE, POUVOIR, SPECIAL)
	private AbstractButton configureBoutonAction(PersonnagePrincipal perso, ActionCombat actionCombat) {

		List<Personnage> persosDejaPresentes = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
				.getLeGroupe().getPersosDejaPresente();
		List<PersonnagePrincipal> persosPrincipauxDejaPresentes = MenuPrincipal.getMainFrame().getCoreManager()
				.getPersonnageManager().getLeGroupe().getPersosPrincipauxDejaPresente();
		// -- ATTAQUE
		if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE) {

			// Si Multicible/Ennemis
			if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
				// JMenuItem
				AbstractButton action = new JMenuItem(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				testConsommationEnergie(action, actionCombat, perso);
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
						executeSort(perso, actionCombat, ennemisTemp, action);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Ennemis
			if (actionCombat.getCibleType() == CibleType.ENNEMI) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				for (Personnage ennemi : ennemis) {
					JMenuItem menuEnnemi = new JMenuItem(ennemi.getNom());
					testConsommationEnergie(action, actionCombat, perso);
					menuEnnemi.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							// Execution du sort
							List<Personnage> unEnnemi = new ArrayList<Personnage>();
							unEnnemi.add(ennemi);
							executeSort(perso, actionCombat, unEnnemi, action);
							revalidate();
						}
					});
					action.add(menuEnnemi);
				}
				return action;
			}
		}

		// -- DEFENSE
		if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE) {

			// Si Multicible/Allies
			if (actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
				// JMenuItem
				AbstractButton action = new JMenuItem(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				testConsommationEnergie(action, actionCombat, perso);
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						executeSort(perso, actionCombat, persosDejaPresentes, action);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Allies
			if (actionCombat.getCibleType() == CibleType.ALLIE) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				for (PersonnagePrincipal persoPrincipal : persosPrincipauxDejaPresentes) {
					JMenuItem ami = new JMenuItem(persoPrincipal.getSurnomPrincipal());
					testConsommationEnergie(action, actionCombat, perso);
					ami.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Execution du sort
							executeSort(perso, actionCombat, persosDejaPresentes, action);
							revalidate();
						}
					});
					action.add(ami);
				}
				return action;
			}
		}
		// -- POUVOIR
		if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR) {

			// Si Multicible/Ennemis
			if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
				// JMenuItem
				AbstractButton action = new JMenuItem(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				testConsommationEnergie(action, actionCombat, perso);
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
						executeSort(perso, actionCombat, ennemisTemp, action);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Ennemis
			if (actionCombat.getCibleType() == CibleType.ENNEMI) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				for (Personnage ennemi : ennemis) {
					JMenuItem menuEnnemi = new JMenuItem(ennemi.getNom());
					testConsommationEnergie(action, actionCombat, perso);
					menuEnnemi.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Execution du sort
							List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
							executeSort(perso, actionCombat, ennemisTemp, action);
							revalidate();
						}
					});
					action.add(menuEnnemi);
				}
				return action;
			}

			// Si Multicible/Allies
			if (actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
				// JMenuItem
				AbstractButton action = new JMenuItem(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				testConsommationEnergie(action, actionCombat, perso);
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						executeSort(perso, actionCombat, persosDejaPresentes, action);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Allies
			if (actionCombat.getCibleType() == CibleType.ALLIE) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe()
						.getPersosDejaPresente();
				for (PersonnagePrincipal cible : persosPrincipauxDejaPresentes) {
					JMenuItem ami = new JMenuItem(cible.getSurnomPrincipal());
					testConsommationEnergie(action, actionCombat, perso);
					ami.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Execution du sort
							List<Personnage> unPerso = new ArrayList<Personnage>();
							unPerso.add(cible);
							executeSort(perso, actionCombat, unPerso, action);
							revalidate();
						}
					});
					action.add(ami);
				}
				return action;
			}

		}
		// -- SPECIAL
		if (actionCombat.getActionCombatType() == ActionCombatType.SPECIAL) {

			// Si Multicible/Ennemis
			if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
				// JMenuItem
				AbstractButton action = new JMenuItem(actionCombat.getNom() + " - lvl " + actionCombat.getNiveau());
				testConsommationEnergie(action, actionCombat, perso);
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
						executeSort(perso, actionCombat, ennemisTemp, action);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Ennemi
			// Si Multicible/Allies
			// Si Monocible/Allie
		}

		return null;
	}

	private void testConsommationEnergie(AbstractButton action, ActionCombat actionCombat, PersonnagePrincipal perso) {
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
			if (perso.getMana() != perso.getManaMax() || perso.getNombreCharge() != perso.getNombreChargeMax()) {
				action.setEnabled(false);
				action.setToolTipText("Pas assez de Charge et de Mana");
			}
		} 
	}

	private void executeSort(PersonnagePrincipal perso, ActionCombat actionCombat, List<Personnage> cibles,
			AbstractButton action) {

		// TODO gestion consommation type energie
		if (actionCombat.getEnergieType() == EnergieType.CHARGE) {
			perso.setNombreCharge(perso.getNombreCharge()-1);
			System.out.println(perso.getNom() + " Charge : " + perso.getNombreCharge() + "/" + perso.getNombreChargeMax() );
		} else if (actionCombat.getEnergieType() == EnergieType.MANA) {
			perso.setMana(perso.getMana()-10);
			System.out.println(perso.getNom() + " Mana : " + perso.getMana() + "/" + perso.getManaMax() );
		} else if (actionCombat.getEnergieType() == EnergieType.CHARGE_ET_MANA) {
			perso.setMana(0);
			perso.setNombreCharge(0);
			System.out.println(perso.getNom() + " Mana : " + perso.getMana() + "/" + perso.getManaMax() + " - Charge : " + perso.getNombreCharge() + "/" + perso.getNombreChargeMax()  );
		} 
		
		// Augmente l'XP du sort
		actionCombat.setProgression(actionCombat.getProgression() + 1);

		// score en fonction du coup critique
		int coupCritique = 1;

		// TODO son/image si critique
		boolean isCritique = false;
		// Chance de critique
		int critique = perso.getCompetence().getLuck() / 3; // max chance de critique 33%
		int random = RandomManager.random(0, 100);
		if (random < critique) {
			// Degats de critique
			coupCritique = perso.getCompetence().getExploit() / 10;
			isCritique = true;
		}

		// score en fonction du niveau du sort
		int niveau = actionCombat.getNiveau();

		int min = 1;

		// score en fonction de la competence du perso
		int max = perso.getCompetence().getStats().get(actionCombat.getPersoStat());

		// Calcul du score
		int score = RandomManager.random(min, max) * coupCritique * niveau;

		// Affichage info sort
		JLabel messageInfoCombat = getMessage(perso, actionCombat, score, cibles);
		panelInfosCombat.add(messageInfoCombat, 0);

		// Pour chaque cible
		for (Personnage cible : cibles) {

			// Si Bouclier
			if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE) {
				// Gestion defense de l'allie
				// TODO
				// cible.setBouclier(cible.getBouclier() + score);
			}
			// Si Soins
			else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR
					&& (actionCombat.getCibleType() == CibleType.ALLIE
							|| actionCombat.getCibleType() == CibleType.GROUPE_ALLIES)) {
				// Gestion vie de l'allie
				cible.setVie(cible.getVie() + score);
				if (cible.getVie() > cible.getVieMax()) {
					cible.setVie(cible.getVieMax());
				}
			} 
			// Si Degats
			else {
				// Gestion vie/mort de l'ennemi
				cible.setVie(cible.getVie() - score);
				System.out.println(cible.getNom() + " - Vie: " + cible.getVie());
				if (cible.getVie() < 0) {
					cible.setVie(0);
					cible.setMort(true);
					ennemis.remove(cible);
					for (JButton bouton : boutonsEnnemis) {
						if (bouton.getName().equals(cible.getNom())) {
							bouton.setEnabled(false);
						}
					}

					// Message Info Combat ennemi mort
					JLabel label = new JLabel(perso.getPrenom().name() + " a tué " + cible.getNom() + ".");
					label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
					label.setForeground(Color.RED);
//					label.setForeground(perso.getCouleur());
					panelInfosCombat.add(label, 0);
					revalidate();

					// Test Fin du jeu
					boolean fin = true;
					for (JButton bouton : boutonsEnnemis) {
						if (bouton.isEnabled()) {
							fin = false;
						}
					}
					if (fin) {
						win = true;
						stop(mission, win);
					}

					// Refresh menu perso monoEnnemi
					buildMenuActions(perso);

				}
			}
		}
		
		// Refresh menu perso pour gestion mana et charge
		buildMenuActions(perso);
	}

	private JLabel getMessage(PersonnagePrincipal perso, ActionCombat actionCombat, int score,
			List<Personnage> cibles) {

		JLabel label = null;

		// Attaque Mono ennemi
		if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE
				&& actionCombat.getCibleType() == CibleType.ENNEMI) {
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et inflige " + score
					+ " degats à " + cibles.get(0).getNom() + ".");
		}
		// Attaque Multi ennemis
		else if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE
				&& actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et inflige " + score
					+ " degats à tous les ennemis.");
		}
		// Defense Mono ami
		else if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE
				&& actionCombat.getCibleType() == CibleType.ALLIE) {
			PersonnagePrincipal personnageCible = (PersonnagePrincipal) cibles.get(0);
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et protege "
					+ personnageCible.getPrenom().name() + " avec un bouclier (" + score + ").");
		}
		// Defense Multi amis
		else if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE
				&& actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
					+ " et protege tous les alliés avec un bouclier (" + score + ").");
		}
		// Pouvoir Mono ennemi
		else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR
				&& actionCombat.getCibleType() == CibleType.ENNEMI) {
			Personnage cible = cibles.get(0);
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et inflige " + score
					+ " degats à " + cible.getNom() + ".");
		}
		// Pouvoir Multi ennemis
		else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR
				&& actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et inflige " + score
					+ " degats à tous les ennemis.");
		}
		// Pouvoir Mono ami
		else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR
				&& actionCombat.getCibleType() == CibleType.ALLIE) {
			PersonnagePrincipal personnageCible = (PersonnagePrincipal) cibles.get(0);
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et soigne " + score
					+ " points de vie à " + personnageCible.getPrenom().name() + ".");
		}
		// Pouvoir Multi amis
		else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR
				&& actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
			label = new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et soigne " + score
					+ " points de vie à tous les alliés.");
		}
		// Special Multi ennemis
		else if (actionCombat.getActionCombatType() == ActionCombatType.SPECIAL
				&& actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
			label = new JLabel(perso.getPrenom().name() + " lance son 'Special' " + actionCombat.getNom()
					+ " et inflige " + score + " degats à tous les ennemis autour de lui.");
		} else {
			System.out.println("Ne devrait pas arriver la");
		}
		// Special Mono ennemis
		// Special Multi amis
		// Special Mono ami
		
		label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
		label.setForeground(perso.getCouleur());
		return label;
	}

	public void start() {
		MenuPrincipal.getMainFrame().setEnabled(false);
		MenuPrincipal.getMainFrame().setVisible(false);
		VideoManager.hideAndStop();
		MusiqueManager.stop();
		JOptionPane.showMessageDialog(this, "Debut du jeu");
	}

	// Fin du jeu
	private void stop(Mission mission, boolean win) {

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
			if (actionCombat.getProgression() >= actionCombat.getNiveau()*10) { // niv1=10, niv2=20, .. niv10=100
 				// On ameliore le sort
				if (actionCombat.amelioreItem()) {
					// Message Item ameliore
					JOptionPane.showMessageDialog(this,
							"Votre sort '" + actionCombat.getNom() + "' a progressé d'un niveau ! ("
									+ actionCombat.getNiveau() + ")",
							"Progression d'un sort", 0, new ImageIcon(actionCombat.getImagePath().get(0)));
				} else {
					// TODO Si item au niveau Max
				}
			}
		}

		// Fermeture des fenetres
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
					label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
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
}
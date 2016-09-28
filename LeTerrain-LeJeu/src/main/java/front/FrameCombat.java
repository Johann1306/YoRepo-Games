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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

public class FrameCombat extends JFrame {

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
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		PersonnagePrincipal nicolas = leGroupe.getPersoByNom(PersoPrenom.NICOLAS);
		PersonnagePrincipal pierre = leGroupe.getPersoByNom(PersoPrenom.PIERRE);
		PersonnagePrincipal yannick = leGroupe.getPersoByNom(PersoPrenom.YANNICK);
		PersonnagePrincipal thomas = leGroupe.getPersoByNom(PersoPrenom.THOMAS);
		PersonnagePrincipal johann = leGroupe.getPersoByNom(PersoPrenom.JOHANN);
		PersonnagePrincipal ali = leGroupe.getPersoByNom(PersoPrenom.ALI);
		PersonnagePrincipal guillaume = leGroupe.getPersoByNom(PersoPrenom.GUILLAUME);
		PersonnagePrincipal jonathan = leGroupe.getPersoByNom(PersoPrenom.JONATHAN);

		// -- Panel Nord - Info
		JPanel panelInfoCombat = new JPanel();

		PersoPrenom prenom = mission.getProprietaire();
		ImageIcon image = null;
		if (prenom.name().equals("GROUPE")) {
			// TODO : image groupe
			image = FenetrePrincipal.getImageIcon("image/groupe.png");
		} else {
			PersonnagePrincipal proprietaire = leGroupe.getPersoByNom(prenom);
			image = proprietaire.getPhotoPrincipal();
		}
		ImageIcon resizeImagePerso = ImageManager.resizeImage(image,
				new Dimension(Constante.PANEL_INFO_COMBAT_HAUTEUR - 10, Constante.PANEL_INFO_COMBAT_HAUTEUR - 10));
		panelInfoCombat.add(new JLabel(resizeImagePerso));
		panelInfoCombat.add(new JLabel(mission.getProprietaire().name()));
		panelInfoCombat.add(new JLabel(mission.getNom()));
		panelInfoCombat.add(new JLabel(mission.getInformations()));
		panelInfoCombat.add(new JLabel(mission.getObjectif()));
		panelInfoCombat.add(new JLabel(mission.getConditionVictoire()));
		panelInfoCombat.add(new JLabel(mission.getDifficulty().name()));
		panelInfoCombat.add(new JLabel(mission.getMissionType().name()));

		panelInfoCombat
				.setPreferredSize(new Dimension(Constante.PANEL_COMBAT_LARGEUR, Constante.PANEL_INFO_COMBAT_HAUTEUR));

		panelNord.add(panelInfoCombat);

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
				buildPanelActions(panelActions, PersoPrenom.NICOLAS);
			}
		});
		boutonPierre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.PIERRE);
			}
		});
		boutonYannick.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.YANNICK);
			}
		});
		boutonThomas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.THOMAS);
			}
		});
		boutonJohann.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.JOHANN);
			}
		});
		boutonAli.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.ALI);
			}
		});
		boutonGuillaume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.GUILLAUME);
			}
		});
		boutonJonathan.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buildPanelActions(panelActions, PersoPrenom.JONATHAN);
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
			boutonItem.setPreferredSize(new Dimension(imageItem.getIconWidth(), imageItem.getIconHeight()));

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
			panelItemsCombat.setMaximumSize(boutonItem.getPreferredSize());
		}
		// TODO mieux
		// panelItemsCombat.setMinimumSize(new
		// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
		// Constante.PANEL_ACTION_HAUTEUR));
		// panelItemsCombat.setMaximumSize(new
		// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
		// Constante.PANEL_ACTION_HAUTEUR));
		// panelItemsCombat.setSize(new
		// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
		// Constante.PANEL_ACTION_HAUTEUR));
		// panelItemsCombat.setPreferredSize(new
		// Dimension(Constante.PANEL_ITEMS_COMBAT_LARGEUR,
		// Constante.PANEL_ACTION_HAUTEUR));

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
				// TODO Auto-generated method stub
			}
		});
		boutonSeRendre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		scrollPaneInfosCombat.getViewport().add(panelInfosCombat);

		JScrollPane scrollPaneItemsCombat = new JScrollPane();
		scrollPaneItemsCombat.getViewport().add(panelItemsCombat);

		panelActions.add(panelPerso);
		panelActions.add(panelBoutonsPerso);
		panelActions.add(scrollPaneInfosCombat);
		panelActions.add(scrollPaneItemsCombat);
		panelActions.add(panelBoutonsGroupe);

		// Refresh Panel Bas
		panelActions.setPreferredSize(new Dimension(Constante.PANEL_COMBAT_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
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

		//
		menuActions.add(menuAttaque);
		menuActions.add(menuDefense);
		menuActions.add(menuPouvoir);
		menuActions.add(menuSpecial);
	}

	// Gestion des Actions (ATTAQUE, DEFENSE, POUVOIR, SPECIAL)
	private AbstractButton configureBoutonAction(PersonnagePrincipal perso, ActionCombat actionCombat) {

		List<Personnage> persosDejaPresentes = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getPersosDejaPresente();
		List<PersonnagePrincipal> persosPrincipauxDejaPresentes = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getPersosPrincipauxDejaPresente();
		// -- ATTAQUE
		if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE) {

			// Si Multicible/Ennemis
			if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
				// JMenuItem
				AbstractButton action = new JMenuItem(actionCombat.getNom());
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
						int score = executeSort(perso, actionCombat, ennemisTemp);

						// Affichage info sort
						panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
								+ " et inflige " + score + " degats à tous les ennemis."), 0);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Ennemis
			if (actionCombat.getCibleType() == CibleType.ENNEMI) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom());
				for (Personnage ennemi : ennemis) {
					JMenuItem menuEnnemi = new JMenuItem(ennemi.getNom());
					menuEnnemi.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {

							// Execution du sort
							List<Personnage> unEnnemi = new ArrayList<Personnage>();
							unEnnemi.add(ennemi);
							int score = executeSort(perso, actionCombat, unEnnemi);

							// Affichage info sort
							panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
									+ " et inflige " + score + " degats à " + ennemi.getNom() + "."), 0);
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
				AbstractButton action = new JMenuItem(actionCombat.getNom());
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						int score = executeSort(perso, actionCombat, persosDejaPresentes);

						// Affichage info sort
						panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
								+ " et protege tous les alliés avec un bouclier (" + score + ")."), 0);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Allies
			if (actionCombat.getCibleType() == CibleType.ALLIE) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom());
				for (PersonnagePrincipal persoPrincipal : persosPrincipauxDejaPresentes) {
					JMenuItem ami = new JMenuItem(persoPrincipal.getSurnomPrincipal());
					ami.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Execution du sort
							int score = executeSort(perso, actionCombat, persosDejaPresentes);

							// Affichage info sort
							panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
									+ " et protege " + persoPrincipal.getPrenom().name() + " avec un bouclier ("
									+ score + ")."), 0);
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
				AbstractButton action = new JMenuItem(actionCombat.getNom());
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
						int score = executeSort(perso, actionCombat, ennemisTemp);

						// Affichage info sort
						panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
								+ " et inflige " + score + " degats à tous les ennemis."), 0);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Ennemis
			if (actionCombat.getCibleType() == CibleType.ENNEMI) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom());
				for (Personnage ennemi : ennemis) {
					JMenuItem menuEnnemi = new JMenuItem(ennemi.getNom());
					menuEnnemi.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Execution du sort
							List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
							int score = executeSort(perso, actionCombat, ennemisTemp);

							// Affichage info sort
							panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
									+ " et inflige " + score + " degats à " + ennemi.getNom() + "."), 0);

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
				AbstractButton action = new JMenuItem(actionCombat.getNom());
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						int	score = executeSort(perso, actionCombat, persosDejaPresentes);

						// Affichage info sort
						panelInfosCombat.add(new JLabel(perso.getPrenom().name() + " lance " + actionCombat.getNom()
								+ " et soigne " + score + " points de vie à tous les alliés."), 0);
						revalidate();
					}
				});
				return action;
			}

			// Si Monocible/Allies
			if (actionCombat.getCibleType() == CibleType.ALLIE) {
				// JMenu
				AbstractButton action = new JMenu(actionCombat.getNom());
				MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getPersosDejaPresente();
				for (PersonnagePrincipal cible : persosPrincipauxDejaPresentes) {
					JMenuItem ami = new JMenuItem(cible.getSurnomPrincipal());
					ami.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							
							// Execution du sort
							int score = executeSort(perso, actionCombat, persosDejaPresentes);

							// Affichage info sort
							panelInfosCombat.add(new JLabel(
									perso.getPrenom().name() + " lance " + actionCombat.getNom() + " et soigne " + score
											+ " points de vie à " + cible.getPrenom().name() + "."),
									0);
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
				AbstractButton action = new JMenuItem(actionCombat.getNom());
				action.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// Execution du sort
						List<Personnage> ennemisTemp = new ArrayList<Personnage>(ennemis);
						int score = executeSort(perso, actionCombat, ennemisTemp);

						// Affichage info sort
						panelInfosCombat.add(
								new JLabel(perso.getPrenom().name() + " lance son 'Special' " + actionCombat.getNom()
										+ " et inflige " + score + " degats à tous les ennemis autour de lui."),
								0);
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

	private int executeSort(PersonnagePrincipal perso, ActionCombat actionCombat, List<Personnage> cibles) {

		// Augmente l'XP du sort
		actionCombat.setProgression(actionCombat.getProgression() + 1);

		// Calcul du score
		int min = 1;
		// score en fonction de la competence du perso
		int max = perso.getCompetence().getStats().get(actionCombat.getPersoStat()); 
		
		// TODO score en fonction du niveau du sort
		int score = RandomManager.random(min, max);

		// Pour chaque cible
		for (Personnage cible : cibles) {

			if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE) {
				// Gestion defense de l'allie
				// TODO
				// cible.setBouclier(cible.getBouclier() + score);
			} else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR
					&& (actionCombat.getCibleType() == CibleType.ALLIE
							|| actionCombat.getCibleType() == CibleType.GROUPE_ALLIES)) {
				// Gestion vie de l'allie
				cible.setVie(cible.getVie() + score);
				if (cible.getVie() > cible.getVieMax()) {
					cible.setVie(cible.getVieMax());
				}
			} else {
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
		return score;
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
			if (actionCombat.getProgression() >= 10) {
				// On ameliore le sort
				if (actionCombat.amelioreItem()) {
					// Message Item ameliore
					JOptionPane.showMessageDialog(this,
							"Votre sort '" + actionCombat.getNom() + "' a progressé d'un niveau ! ("
									+ actionCombat.getNiveau() + ")",
							"Progression d'un sort", 0, new ImageIcon(actionCombat.getImagePath().get(0)));
				}
			}
		}

		this.dispose();
		MenuPrincipal.getMainFrame().setEnabled(true);
		MenuPrincipal.getMainFrame().setVisible(true);
		VideoManager.show();
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
					panelInfosCombat.add(new JLabel(prenom.name() + " consomme " + itemSelectionne.getNom() + "."), 0);
					// TODO setDisponible(false)? ou etat consomme?
					itemSelectionne.setDisponible(false);

				} else {
					JOptionPane.showMessageDialog(this,
							"L'item : " + itemSelectionne.getNom() + " n'a pas pu etre consomme : raison");
				}
			}
			// TODO : remettre curseur souris normal
			// TODO panelPerso en surbrillance false
			panelOuest.setBorder(null);
			itemSelectionne = null;
		}
	}

}
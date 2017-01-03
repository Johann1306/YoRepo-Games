package front;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import core.ImageManager;
import core.MusiqueManager;
import core.PersonnageManager;
import core.RandomManager;
import core.VideoManager;
import core.configuration.Constante;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.Aura;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoClasse;
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
	private PersoPrenom proprietaireItem = null;
	private JPanel panelInfosCombat = null;
	private List<JButton> boutonsEnnemis = null;
	private List<JButton> boutonsAmis = null;
	private List<PersonnageEnnemi> ennemisVivants = null;
	private List<PersonnageEnnemi> ennemisPresents = null;
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
		boutonNicolas = new JButton(
				ImageManager.resizeImage(nicolas.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonPierre = new JButton(
				ImageManager.resizeImage(pierre.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonYannick = new JButton(
				ImageManager.resizeImage(yannick.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonThomas = new JButton(
				ImageManager.resizeImage(thomas.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonJohann = new JButton(
				ImageManager.resizeImage(johann.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonAli = new JButton(
				ImageManager.resizeImage(ali.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonGuillaume = new JButton(
				ImageManager.resizeImage(guillaume.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));
		boutonJonathan = new JButton(
				ImageManager.resizeImage(jonathan.getPhotoCombat(), Constante.PERSO_IMAGE_DIMENSION_64_64));

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

		for (PersonnagePrincipal ami : amisPresents) {
			ami.setaDejaJoue(false);
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

		// Gestion du nombre d'ennemis en fonction de la difficulte et du nombre
		// de joueurs vivants
		// TODO difficulte generale + difficulte mission ? ou pas?
		Difficulte difficulteMission = mission.getDifficulty();
		int nombreJoueurs = amisVivants.size();
		int nombreEnnemis = nombreJoueurs;
		if (difficulteMission == Difficulte.FACILE) {
			nombreEnnemis = nombreEnnemis + RandomManager.random(0, 1);
		} else if (difficulteMission == Difficulte.NORMAL) {
			nombreEnnemis = nombreEnnemis + RandomManager.random(1, 2);
		} else if (difficulteMission == Difficulte.DIFFICILE) {
			nombreEnnemis = nombreEnnemis + RandomManager.random(2, 3);
		} else if (difficulteMission == Difficulte.HEROIQUE) {
			nombreEnnemis = nombreEnnemis + RandomManager.random(3, 4);
		}

		// random pour retirer des ennemis
		if (nombreEnnemis > 5) {
			int randomNombreEnnemis = RandomManager.random(0, 3);
			nombreEnnemis = nombreEnnemis - randomNombreEnnemis;
		}

		// 8 ennemis max
		if (nombreEnnemis > 8) {
			nombreEnnemis = 8;
		}
		if (mission.getMissionType() == MissionType.BOSS) {
			nombreEnnemis = 7;
		}
		// Gestion du type d ennemis / BOSS / type de mission
		boutonsEnnemis = new ArrayList<JButton>();
		ennemisVivants = new ArrayList<PersonnageEnnemi>();
		ennemisPresents = new ArrayList<PersonnageEnnemi>();
		PersonnageManager personnageManager = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager();
		if (mission.getMissionType() == MissionType.BOSS) {
			PersonnageBoss boss = personnageManager.getPersonnageBossByNom(mission.getBossNom());
			ennemisVivants.add(boss);
			ennemisPresents.add(boss);
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

		// On recupere le niveau du meilleur sort des joueurs (Pour augmenter la
		// difficulté des ennemis au fur et a mesure de la progression)
		int niveauSorts = personnageManager.getBestNiveauSorts();

		// Choix des classes en fonction du nombre d'ennemis et de la difficulté
		// (mission/generale)
		List<PersoClasse> classes = choixDesClassesEnnemi(nombreEnnemis, difficulteMission);

		// Creation des personnages ennemis
		for (int i = 1; i <= nombreEnnemis; i++) {
			PersoClasse classe = classes.get(i - 1);
			PersonnageEnnemi ennemi = personnageManager.createPersonnageEnnemi(mission, i, niveauSorts, classe);
			ennemisVivants.add(ennemi);
			ennemisPresents.add(ennemi);
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
		// }
		//
		// @Override
		// public void componentHidden(ComponentEvent e) {
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

	private List<PersoClasse> choixDesClassesEnnemi(int nombreEnnemis, Difficulte difficulteMission) {
		// TODO en fonction de la difficulte de la mission
		// TODO en fonction de la difficulte de la partie aussi ?
		// TODO random des classes restants
		// Difficulte difficultePartie =
		// MenuPrincipal.getMainFrame().getCoreManager().getDifficultePartie();
		List<PersoClasse> classes = new ArrayList<PersoClasse>();
		if (nombreEnnemis == 8) {
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.MAGE);
			classes.add(PersoClasse.DPS);
			classes.add(PersoClasse.DPS);
			classes.add(PersoClasse.BARDE);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 7) {
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.MAGE);
			classes.add(PersoClasse.DPS);
			classes.add(PersoClasse.BARDE);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 6) {
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.MAGE);
			classes.add(PersoClasse.DPS);
			classes.add(PersoClasse.BARDE);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 5) {
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.MAGE);
			classes.add(PersoClasse.DPS);
			classes.add(PersoClasse.BARDE);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 4) {
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.MAGE);
			classes.add(PersoClasse.DPS);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 3) {
			classes.add(PersoClasse.TANK);
			classes.add(PersoClasse.HEALER);
			classes.add(PersoClasse.MAGE);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 2) {
			classes.add(PersoClasse.DPS);
			classes.add(PersoClasse.MAGE);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		} else if (nombreEnnemis == 1) {
			classes.add(PersoClasse.DPS);
			if (difficulteMission == Difficulte.FACILE) {

			} else if (difficulteMission == Difficulte.NORMAL) {

			} else if (difficulteMission == Difficulte.DIFFICILE) {

			} else if (difficulteMission == Difficulte.HEROIQUE) {

			}
		}
		return classes;
	}

	private void buildPanelActions(PersoPrenom prenom) {

		PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
				.getPersoByPrenom(prenom);

		gestionItemSelectionne(prenom);

		// On construit le panel uniquement si le perso n a pas encore joue ce
		// tour ci et qu'il n'est pas bloqué
		if (!perso.isaDejaJoue() && perso.getNombreBloque() == 0) {

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

			// Gestion info stat
			// TODO faire une methode generique comme au debut plutot que
			// gestionLabel()
			JLabel labelAgilite = new JLabel(PersoStat.AGILITE.name() + " : " + perso.getCompetence().getAgilite());
			gestionLabel(perso, labelAgilite, PersoStat.AGILITE);
			JLabel labelEndurance = new JLabel(
					PersoStat.ENDURANCE.name() + " : " + perso.getCompetence().getEndurance());
			gestionLabel(perso, labelEndurance, PersoStat.ENDURANCE);
			JLabel labelExploit = new JLabel(PersoStat.EXPLOIT.name() + " : " + perso.getCompetence().getExploit());
			gestionLabel(perso, labelExploit, PersoStat.EXPLOIT);
			JLabel labelIntelligence = new JLabel(
					PersoStat.INTELLIGENCE.name() + " : " + perso.getCompetence().getIntelligence());
			gestionLabel(perso, labelIntelligence, PersoStat.INTELLIGENCE);
			JLabel labelChance = new JLabel(PersoStat.LUCK.name() + " : " + perso.getCompetence().getLuck());
			gestionLabel(perso, labelChance, PersoStat.LUCK);
			JLabel labelNervosite = new JLabel(
					PersoStat.NERVOSITE.name() + " : " + perso.getCompetence().getNervosite());
			gestionLabel(perso, labelNervosite, PersoStat.NERVOSITE);
			JLabel labelRapidite = new JLabel(PersoStat.RAPIDITE.name() + " : " + perso.getCompetence().getRapidite());
			gestionLabel(perso, labelRapidite, PersoStat.RAPIDITE);
			JLabel labelResistance = new JLabel(
					PersoStat.RESISTANCE.name() + " : " + perso.getCompetence().getResistance());
			gestionLabel(perso, labelResistance, PersoStat.RESISTANCE);
			JLabel labelTechnique = new JLabel(
					PersoStat.TECHNIQUE.name() + " : " + perso.getCompetence().getTechnique());
			gestionLabel(perso, labelTechnique, PersoStat.TECHNIQUE);

			panelBoutonsPerso.add(labelAgilite);
			panelBoutonsPerso.add(labelEndurance);
			panelBoutonsPerso.add(labelExploit);
			panelBoutonsPerso.add(labelIntelligence);
			panelBoutonsPerso.add(labelChance);
			panelBoutonsPerso.add(labelNervosite);
			panelBoutonsPerso.add(labelRapidite);
			panelBoutonsPerso.add(labelResistance);
			panelBoutonsPerso.add(labelTechnique);

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
			
			// On affiche les objets consommables du joueur (+ objets groupe ?)
			Map<Item, Integer> sac = perso.getSac();
			
			for (Item item : sac.keySet()) {
				Integer nbItems = sac.get(item);
				if (nbItems > 0) {
					// Si popo de vie ou popo de mana
					// TODO potion de combat (degats, bouclier, casse bouclier, charge, aura, )
					if (item.isConsommable()) {
						ImageIcon imageItem = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
						ImageIcon resizeImage2 = ImageManager.resizeImage(imageItem, Constante.ITEM_CONSOMMABLE_DIMENSION);
						JButton boutonItem = new JButton(resizeImage2);
						boutonItem.setToolTipText(item.getNom() + " (x" + nbItems + ")");
						boutonItem.setPreferredSize(new Dimension(resizeImage2.getIconWidth(), resizeImage2.getIconHeight()));
						// TODO afficher le nombre d'items si >1 (popup?)
		
						// Clic sur un item
						boutonItem.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								itemSelectionne = item;
								proprietaireItem = perso.getPrenomPerso();
								// TODO panelPerso en surbrillance
								panelOuest.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
								// TODO changer l icone de la souris jusqu a ce que l item soit utilise
							}
						});
						panelItemsCombat.add(boutonItem);
					}
				}
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

			JButton boutonFinTour = new JButton("FIN DU TOUR");
			boutonFinTour.setName("boutonAuto");
			JButton boutonFuir = new JButton("S'ENFUIR");
			boutonFuir.setName("boutonFuir");
			if (!peuxFuir) {
				boutonFuir.setEnabled(false);
			}
			JButton boutonSeRendre = new JButton("SE RENDRE");
			boutonSeRendre.setName("boutonSeRendre");

			panelBoutonsGroupe.setMaximumSize(
					new Dimension(Constante.PANEL_BOUTON_GROUPE_LARGEUR, Constante.PANEL_ACTION_HAUTEUR));
			boutonFinTour.setMaximumSize(panelBoutonsGroupe.getMaximumSize());
			boutonFuir.setMaximumSize(panelBoutonsGroupe.getMaximumSize());
			boutonSeRendre.setMaximumSize(panelBoutonsGroupe.getMaximumSize());

			// Pas de bouton fin du tour si il y a un timer
			Difficulte difficulte = mission.getDifficulty();
			if (difficulte != Difficulte.FACILE) {
				boutonFinTour.setEnabled(false);
			}

			boutonFinTour.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO bouton fin du tour / A supprimer ?
					if (timerJoueurs != null && timerJoueurs.isRunning()) {
						labelTimer.setText(String.format("%1$,.2f", new Double(0.0)));
						timerJoueurs.stop();
					}
					// TODO remettre des trucs a zero ??? + PROLEME reinit timer
					// a
					// tempsMax
					lanceTourEnnemis();
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
					if (difficulte == Difficulte.FACILE) {
						chanceFuite = chanceFuite + 40;
					} else if (difficulte == Difficulte.NORMAL) {
						chanceFuite = chanceFuite + 30;
					} else if (difficulte == Difficulte.DIFFICILE) {
						chanceFuite = chanceFuite + 20;
					} else if (difficulte == Difficulte.HEROIQUE) {
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

			panelBoutonsGroupe.add(boutonFinTour);
			panelBoutonsGroupe.add(boutonFuir);
			panelBoutonsGroupe.add(boutonSeRendre);

			panelPerso.setBackground(Color.BLACK);
			panelBoutonsPerso.setBackground(Color.BLACK);
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

	private void gestionLabel(PersonnagePrincipal perso, JLabel label, PersoStat stat) {
		// Couleur par defaut
		label.setForeground(Color.WHITE);

		// Si le perso a une aura sur cette stat
		Map<Personnage, Aura> auras = perso.getAuras();
		for (Aura aura : auras.values()) {
			if (aura.getStat() == stat) {
				label.setForeground(Color.YELLOW);
				// Ajoute valeur aura
				label.setText(label.getText() + " (+" + aura.getValeurAjoutee() + ")");
			}
		}
		int valeurStat = perso.getCompetence().getStats().get(stat);

		// Si la stat est au max du perso
		if (valeurStat >= perso.getCompetenceMax().getStats().get(stat)) {
			label.setForeground(Color.GREEN);
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

		// Gestion Taunt : cible ennemi obligatoire
		Map<Personnage, Integer> tauntBy = lanceur.getTauntBy();
		// Si lanceur est taunt (cas particulier) cible obligatoire (sort en
		// fonction => MONO, ENNEMI)
		if (!tauntBy.isEmpty()) {
			Set<Personnage> keySet = tauntBy.keySet();
			Object[] persos = keySet.toArray();
			Personnage persoCible = (Personnage) persos[0];
			if (cibles.contains(persoCible) && actionCombat.getCibleType() == CibleType.ENNEMI) {
				cibles.clear();
				cibles.add(persoCible);
			} else {
				menuAction.setEnabled(false);
				menuAction.setToolTipText("Vous êtes provoqué par " + persoCible.getPrenom() + ".");
			}
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
			for (Personnage ennemi : cibles) {
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

		// Gestion Amis/Ennemis

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
			PersonnageManager personnageManager = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager();

			// IA : Choix de la(les) cible(s)
			cibles = choixDeLaCible(lanceur, actionCombat, personnageManager);
		}

		// Calcul du score
		int score = -1;
		boolean isCritique = false;
		int degatsCritique = 1;
		int charges = 1;
		int niveau = 1;
		int min = 0;
		int max = 100;
		int handicap = 0;

		// chance de critique : max = 33%
		// TODO son/image si critique
		int chanceCritique = lanceur.getCompetence().getLuck() / 3;
		int randomCritique = RandomManager.random(0, 100);
		if (randomCritique < chanceCritique) {
			// dégats de critique : max multiplicateur dégats x5
			degatsCritique = lanceur.getCompetence().getExploit() / 20;
			isCritique = true;
		}

		// score en fonction du niveau du sort : max = x5
		niveau = actionCombat.getNiveau();
		if (niveau > 1) {
			niveau = niveau / 2;
		}

		// score min en fonction de la technique : max = 50
		min = lanceur.getCompetence().getTechnique() / 2;

		// score max en fonction de la competence du perso : max = 100
		max = lanceur.getCompetence().getStats().get(actionCombat.getPersoStat());

		// PersonnagePrincipal / PersonnageEnnemi
		if (lanceur instanceof PersonnagePrincipal) {
			// PersonnagePrincipal
			handicap = 0;
		} else {
			// PersonnageEnnemi
			if (mission.getDifficulty() == Difficulte.FACILE) {
				handicap = RandomManager.random(0, 2);
			} else if (mission.getDifficulty() == Difficulte.NORMAL) {
				handicap = RandomManager.random(1, 4);
			} else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
				handicap = RandomManager.random(4, 7);
			} else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
				handicap = RandomManager.random(5, 10);
			}
		}

		if (min > max) {
			max = min;
		}

		// score en fonction du nombre de cibles si Multi
		// TODO fonction difficulte? => /1 /2 /3 /4)
		int nombreCibles = cibles.size();

		// score en fonction du nombre de charge consommé (SPECIAL)
		if (actionCombat.getEnergieType() == EnergieType.CHARGE
				|| actionCombat.getEnergieType() == EnergieType.CHARGE_ET_MANA) {
			charges = chargesConsommes;
		}

		// Calcule du multiplicateur de Degats (3 => 25)
		int multiplicateurDegat = degatsCritique + niveau + charges + handicap;

		// Calcul du score
		score = (RandomManager.random(min, max) * multiplicateurDegat) / nombreCibles;

		// TODO fail score = 0 chance de raté 10% max - 1% min
		if (score == 0) {
		}

		// Animation lanceur de gauche a droite
		animationLanceur(lanceur, score, cibles);

		// TODO son/image si critique true
		if (isCritique) {
			MusiqueManager.playSon(actionCombat.getSonCritique());
		} else {
			MusiqueManager.playSon(actionCombat.getSon());
		}

		// TODO faire mieux ou pas/ a un autre endroit : Gestion specifique pour message
		// Aura
		if (actionCombat.getSortType() == SortType.AURA_PERSO || actionCombat.getSortType() == SortType.AURA_MONO
				|| actionCombat.getSortType() == SortType.AURA_MULTI) {
			int valeurAAjouter = 0;
			if (isCritique) {
				valeurAAjouter = actionCombat.getNiveau() * 4;
			} else {
				valeurAAjouter = actionCombat.getNiveau() * 2;
			}
			score = valeurAAjouter;
		}

		// Affichage info sort
		JLabel messageInfoCombat = getMessage(lanceur, actionCombat, score, cibles, isCritique);
		if (lanceur instanceof PersonnagePrincipal) {
			messageInfoCombat.setForeground(Color.GREEN);
		} else {
			messageInfoCombat.setForeground(Color.BLUE);
		}
		panelInfosCombat.add(messageInfoCombat, 0);

		// Animation cible de haut en bas
		animationCible(lanceur, score, cibles);

		// TODO son/image degats si critique true/false si bouclier si esquive
		// si stun si taunt
		// si degats

		// Pour chaque cible
		for (Personnage cible : cibles) {
			// Distribution des dégats / protection / soins / absorption /
			// brulure / regen / stun / esquive

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
						cible.setMana(cible.getManaMax());
					} else {
						// Resurrection de la cible : +10% de vie par niveau du
						// sort
						cible.setVie(
								cible.getVieMax() / ((actionCombat.getNiveauMax() + 1) - actionCombat.getNiveau()));
					}
					cible.setNombreCharge(-1); // FIX probleme apres rez multi,
												// tous les persos full charge
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
					// Gestion aura de la cible
					int valeurAAjouter = 0;
					if (isCritique) {
						valeurAAjouter = actionCombat.getNiveau() * 4;
					} else {
						valeurAAjouter = actionCombat.getNiveau() * 2;
					}
					PersoStat statAModifier = actionCombat.getPersoStat();
					Aura aura = new Aura(statAModifier, valeurAAjouter);
					cible.ajouteAura(lanceur, aura);
				}
				// Si Stun (Blocage)
				else if (actionCombat.getSortType() == SortType.STUN_MONO
						|| actionCombat.getSortType() == SortType.STUN_MULTI) {

					int chanceStun = (actionCombat.getNiveau() * 100) / actionCombat.getNiveauMax();
					if (actionCombat.getSortType() == SortType.STUN_MULTI) {
						chanceStun = chanceStun / 2;
					}
					int random = RandomManager.random0_100();
					// Si Stun reussi
					if (random < chanceStun) {
						if (cible instanceof PersonnageBoss) {
							JLabel labelStun = new JLabel(cible.getNom() + " ne peut pas être bloqué.");
							panelInfosCombat.add(labelStun, 0);
						} else {
							if (isCritique) {
								cible.setNombreBloque(cible.getNombreBloque() + 2);
							} else {
								cible.setNombreBloque(cible.getNombreBloque() + 1);
							}
							JLabel labelStun = new JLabel(
									lanceur.getPrenom() + " a réussi à bloquer " + cible.getPrenom() + ".");
							panelInfosCombat.add(labelStun, 0);
						}
						revalidate();
					}
					// Si Stun raté
					else {
						// Info inutiles ?
						// JLabel labelStun = new JLabel(
						// lanceur.getPrenom() + " n'a pas réussi à bloquer " +
						// cible.getPrenom() + ".");
						// panelInfosCombat.add(labelStun, 0);
						revalidate();
					}
				}
				// Si Taunt (Provocation)
				else if (actionCombat.getSortType() == SortType.TAUNT_MONO
						|| actionCombat.getSortType() == SortType.TAUNT_MULTI) {
					int chanceTaunt = (actionCombat.getNiveau() * 100) / actionCombat.getNiveauMax();
					if (actionCombat.getSortType() == SortType.TAUNT_MULTI) {
						chanceTaunt = chanceTaunt / 2;
					}
					int random = RandomManager.random0_100();
					// Si Taunt reussi
					if (random < chanceTaunt) {
						if (cible instanceof PersonnageBoss) {
							JLabel labelTaunt = new JLabel(cible.getNom() + " ne peut pas être provoqué.");
							panelInfosCombat.add(labelTaunt, 0);
						} else {
							Map<Personnage, Integer> tauntBy = cible.getTauntBy();
							// Si la cible est deja Taunt par le lanceur
							if (tauntBy.containsKey(lanceur)) {
								int nbTaunt = tauntBy.get(lanceur);
								if (isCritique) {
									tauntBy.remove(lanceur);
									tauntBy.put(lanceur, nbTaunt + 2);
								} else {
									tauntBy.remove(lanceur);
									tauntBy.put(lanceur, nbTaunt + 1);
								}
							}
							// Si la cible n'est pas deja Taunt
							else {
								if (isCritique) {
									tauntBy.put(lanceur, 2);
								} else {
									tauntBy.put(lanceur, 1);
								}
							}
							JLabel labelTaunt = new JLabel(
									lanceur.getPrenom() + " a réussi à provoquer " + cible.getPrenom() + ".");
							panelInfosCombat.add(labelTaunt, 0);
						}
						revalidate();
					}
					// Si taunt raté
					else {
						// Info inutiles ?
						// JLabel labelTaunt = new JLabel(
						// lanceur.getPrenom() + " n'a pas réussi à provoquer "
						// + cible.getPrenom() + ".");
						// panelInfosCombat.add(labelTaunt, 0);
						revalidate();
					}
				}
				// Si Renvoi Degats
				else if (actionCombat.getSortType() == SortType.RENVOI_DEGATS_PERSO) {
					// TODO Gestion renvoi degats de la cible (ou pas! trop de
					// contraintes)

				}
				// Si Esquive
				else if (actionCombat.getSortType() == SortType.ESQUIVE) {
					if (isCritique) {
						cible.setNombreEsquive(cible.getNombreEsquive() + 2);
					} else {
						cible.setNombreEsquive(cible.getNombreEsquive() + 1);
					}
					cible.setNiveauEsquive(actionCombat.getNiveau());
					cible.setNiveauEsquiveMax(actionCombat.getNiveauMax());
				}
				// Si dégats
				else {

					System.out.println("Cible avant degats : " + cible.toString());

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
					// TODO bloque tous les degats en fonction de la difficulte
					if (cible.getBouclier() > 0) {
						cible.setBouclier(cible.getBouclier() - score);
						if (cible.getBouclier() < 0) {
							cible.setBouclier(0);
						}
						JLabel labelEsquive = new JLabel(
								cible.getPrenom() + " a absorbé les degats avec son bouclier.");
						panelInfosCombat.add(labelEsquive, 0);
						revalidate();
					}

					// Sinon la cible essaye d'esquiver
					else {

						// Gestion de l Esquive

						// Esquive naturel (10% Chance - 10% Agilite - 10%
						// Vitesse) : max 30%
						int chanceEsquiveStats = (cible.getCompetence().getLuck() / 10)
								+ (cible.getCompetence().getAgilite() / 10)
								+ (cible.getCompetence().getRapidite() / 10);

						// Esquive sort (ajoute niveau/niveauMax * 100 * 70/100)
						// : max 70%
						int chanceEsquiveSort = 0;
						if (cible.getNombreEsquive() > 0) {
							chanceEsquiveSort = (((cible.getNiveauEsquive() * 100) / cible.getNiveauEsquiveMax()) * 70)
									/ 100;
							cible.setNombreEsquive(cible.getNombreEsquive() - 1);
						}

						// Esquive final
						int chanceEsquive = chanceEsquiveStats + chanceEsquiveSort;

						int random = RandomManager.random0_100();

						// Si Esquive
						if (random < chanceEsquive) {
							MusiqueManager.playSon("sonParDefaut/defautEsquive.mp3");
							JLabel labelEsquive = new JLabel(cible.getPrenom() + " a esquivé l'attaque de "
									+ lanceur.getPrenom() + " avec (" + chanceEsquive + "%) de chance.");
							panelInfosCombat.add(labelEsquive, 0);
							revalidate();
						}
						// Si Esquive ratee : on retire de la vie a la cible
						else {
							// Reduction degats en fonction de la resistance :
							// max -80% degats
							// TODO (50% max ?)
							int reductionDegats = cible.getCompetence().getResistance() - 20;
							if (reductionDegats < 0) {
								reductionDegats = 0;
							}
							int degatsReels = score - ((score * reductionDegats) / 100);

							JLabel labelDegatsReel = new JLabel(cible.getPrenom() + " a subit " + score + " (-"
									+ (score - degatsReels) + ") dégats.");
							panelInfosCombat.add(labelDegatsReel, 0);
							revalidate();

							// On enleve de la vie a la cible
							cible.setVie(cible.getVie() - degatsReels);

							// Gestion vie/mort de l'ennemi/ami
							// TODO gerer mort si renvoi degats au bon endroit
							if (cible.getVie() <= 0) {
								cible.setMort(true);
								// La cible perd sa vie, son bouclier, son mana,
								// ses charges, ses stun, ses esquives, ses
								// taunt et ses auras
								cible.setVie(0);
								cible.setBouclier(0);
								cible.setMana(0);
								cible.setNombreCharge(0);
								cible.setNombreBloque(0);
								cible.setNombreEsquive(0);
								cible.getTauntBy().clear();
								cible.enleveAuras();
								// On detaunt les cibles taunt par le mort
								for (Personnage perso : ennemisVivants) {
									if (perso.getTauntBy().containsKey(cible)) {
										perso.getTauntBy().remove(cible);
									}
								}
								for (Personnage perso : amisVivants) {
									if (perso.getTauntBy().containsKey(cible)) {
										perso.getTauntBy().remove(cible);
									}
								}

								// Grise le bouton du perso
								ennemisVivants.remove(cible);
								for (JButton bouton : boutonsEnnemis) {
									if (bouton.getName().equals(cible.getPrenom())) {
										bouton.setEnabled(false);
									}
								}
								amisVivants.remove(cible);
								for (JButton bouton : boutonsAmis) {
									if (bouton.getName().equals(cible.getPrenom())) {
										bouton.setEnabled(false);
									}
								}

								// Message Info Combat ennemi mort
								MusiqueManager.playSon("sonParDefaut/defautMort.mp3");
								JLabel labelMort = new JLabel(
										lanceur.getPrenom() + " a tué " + cible.getPrenom() + ".");
								labelMort.setFont(Constante.ZELDA_FONT_FRAMECOMBAT_INFO);
								labelMort.setForeground(Color.RED);
								//labelMort.setForeground(lanceur.getCouleur());
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

		refreshFinTourJoueur(lanceur);

	}

	private void refreshFinTourJoueur(Personnage lanceur) {
		if (lanceur instanceof PersonnagePrincipal) {
			// gestion une action par perso par tour
			lanceur.setaDejaJoue(true);

			// // Refresh menu perso pour gestion mana et charge
			// buildMenuActions(perso);

			// Passe au prochain perso qui peux jouer et qui n'est pas bloqué
			PersonnagePrincipal persoDispo = null;
			for (PersonnagePrincipal persoPresent : amisVivants) {
				if (!persoPresent.isaDejaJoue() && persoPresent.getNombreBloque() == 0) {
					persoDispo = persoPresent;
				}
			}
			if (persoDispo == null) {
				// Fin du tour des joueurs
				if (timerJoueurs != null && timerJoueurs.isRunning()) {
					timerJoueurs.stop();
				}
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

	private List<Personnage> choixDeLaCible(Personnage lanceur, ActionCombat actionCombat,
			PersonnageManager personnageManager) {

		List<Personnage> cibles = new ArrayList<Personnage>();

		// Decremente le taunt si taunt
		Map<Personnage, Integer> tauntBy = lanceur.getTauntBy();
		if (!tauntBy.isEmpty()) {
			Object[] persos = tauntBy.keySet().toArray();
			Personnage persoCible = (Personnage) persos[0];
			cibles.add(persoCible);
			int nbTaunt = tauntBy.get(persoCible);
			tauntBy.remove(persoCible);
			if (nbTaunt > 1) {
				tauntBy.put(persoCible, nbTaunt - 1);
			}
		} else if (actionCombat.getCibleType() == CibleType.ENNEMI) {
			// IA : Choix de la cible en fonction de la difficulte

			// FACILE => cible aleatoire
			if (mission.getDifficulty() == Difficulte.FACILE) {
				// cible aleatoire
				int randomPerso = 0;
				if (!amisVivants.isEmpty()) {
					randomPerso = RandomManager.random(0, amisVivants.size() - 1);
				}
				Personnage cible = amisVivants.get(randomPerso);
				cibles.add(cible);
			}
			// NORMAL => cible moins de vie / aleatoire
			else if (mission.getDifficulty() == Difficulte.NORMAL) {
				int random = RandomManager.random0_100();
				if (random < 50) {
					// Cible moins de vie
					Personnage meilleurCible = null;
					int vieMin = 10000;
					for (Personnage cible : amisVivants) {
						if (cible.getVie() < vieMin) {
							vieMin = cible.getVie();
							meilleurCible = cible;
						}
					}
					cibles.add(meilleurCible);
				} else {
					// Cible aleatoire
					int randomPerso = 0;
					if (!amisVivants.isEmpty()) {
						randomPerso = RandomManager.random(0, amisVivants.size() - 1);
					}
					Personnage cible = amisVivants.get(randomPerso);
					cibles.add(cible);
				}
			}
			// DIFFICILE => cible moins de vie / healer / aleatoire
			else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
				int random = RandomManager.random0_100();
				if (random < 30) {
					// Cible moins de vie
					Personnage meilleurCible = null;
					int vieMin = 10000;
					for (Personnage cible : amisVivants) {
						if (cible.getVie() < vieMin) {
							vieMin = cible.getVie();
							meilleurCible = cible;
						}
					}
					cibles.add(meilleurCible);
				} else if (random > 60) {
					// Cible aleatoire
					int randomPerso = 0;
					if (!amisVivants.isEmpty()) {
						randomPerso = RandomManager.random(0, amisVivants.size() - 1);
					}
					Personnage cible = amisVivants.get(randomPerso);
					cibles.add(cible);
				} else {
					// TODO cible healer (celui qui a le plus d'inte)
					PersonnagePrincipal perso = personnageManager.getBestPersoVivant(PersoStat.INTELLIGENCE);
					cibles.add(perso);
				}
			}
			// HEROIQUE => cible moins de vie / healer
			else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
				int random = RandomManager.random0_100();
				if (random < 50) {
					// Cible moins de vie
					Personnage meilleurCible = null;
					int vieMin = 10000;
					for (Personnage cible : amisVivants) {
						if (cible.getVie() < vieMin) {
							vieMin = cible.getVie();
							meilleurCible = cible;
						}
					}
					cibles.add(meilleurCible);
				} else {
					// TODO cible healer (celui qui a le plus d'inte)
					PersonnagePrincipal perso = personnageManager.getBestPersoVivant(PersoStat.INTELLIGENCE);
					cibles.add(perso);
				}
			}

		} else if (actionCombat.getCibleType() == CibleType.ALLIE) {
			// TODO cible en fonction de la difficulte aleatoire, aleatoire,
			// moins de vie, healer-moins de vie
			// cible aleatoire
			if (actionCombat.getSortType() == SortType.REGEN_VIE_MONO
					|| actionCombat.getSortType() == SortType.BOUCLIER_MONO) {
				// Cible moins de vie
				Personnage meilleurCible = null;
				int vieMin = 10000;
				for (Personnage cible : ennemisVivants) {
					if (cible.getVie() < vieMin) {
						vieMin = cible.getVie();
						meilleurCible = cible;
					}
				}
				cibles.add(meilleurCible);
			} else if (actionCombat.getSortType() == SortType.REGEN_MANA_MONO) {
				// Cible moins de mana
				Personnage meilleurCible = null;
				int manaMin = 10000;
				for (Personnage cible : ennemisVivants) {
					if (cible.getMana() < manaMin) {
						manaMin = cible.getMana();
						meilleurCible = cible;
					}
				}
				cibles.add(meilleurCible);
			} else if (actionCombat.getSortType() == SortType.RESURRECTION_MONO) {
				// Cible morte aleatoire (+ d'inte)
				Personnage meilleurCible = null;
				// Pour chaque amis morts
				List<Personnage> morts = new ArrayList<Personnage>();
				for (Personnage cible : ennemisPresents) {
					if (cible.isMort()) {
						morts.add(cible);
					}
				}
				// On prend celui qui a le plus d'intelligence
				meilleurCible = personnageManager.getBestStatPersoMorts(PersoStat.INTELLIGENCE, morts);
				cibles.add(meilleurCible);
			} else {
				int randomPerso = RandomManager.random(0, amisVivants.size() - 1);
				Personnage cible = ennemisVivants.get(randomPerso);
				// TODO meilleurCible possible (moins de vie, healer)
				cibles.add(cible);
			}
		} else if (actionCombat.getCibleType() == CibleType.GROUPE_ENNEMIS) {
			cibles.addAll(amisVivants);
		} else if (actionCombat.getCibleType() == CibleType.GROUPE_ALLIES) {
			cibles.addAll(ennemisVivants);
		} else if (actionCombat.getCibleType() == CibleType.PERSO) {
			cibles.add(lanceur);
		} else if (actionCombat.getCibleType() == CibleType.TOUS) {
			cibles.addAll(ennemisVivants);
			cibles.addAll(amisVivants);
		}
		return cibles;
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
			label = new JLabel(perso.getNom() + lance + actionCombat.getNom() + " et se protège avec une aura (+"
					+ score + " " + actionCombat.getPersoStat() + ").");
		}
		// Aura Mono
		else if (actionCombat.getSortType() == SortType.AURA_MONO) {
			Personnage personnageCible = cibles.get(0);
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et protège " + personnageCible.getPrenom()
							+ " avec une aura (+" + score + " " + actionCombat.getPersoStat() + ").");
		}
		// Aura Multi
		else if (actionCombat.getSortType() == SortType.AURA_MULTI) {
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et protège tous les alliés avec une aura (+"
							+ score + " " + actionCombat.getPersoStat() + ").");
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
			int chanceEsquiveSort = (((actionCombat.getNiveau() * 100) / actionCombat.getNiveauMax()) * 70) / 100;
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et augmente ses chances d'esquiver de "
							+ chanceEsquiveSort + "% pour " + nbTour + " prochaine(s) attaque(s).");
		}
		// Renvoi degats
		else if (actionCombat.getSortType() == SortType.RENVOI_DEGATS_PERSO) {
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom()
					+ " et se met en position de renvoi de degats pour " + nbTour + " tour(s).");
		}
		// Stun Mono
		else if (actionCombat.getSortType() == SortType.STUN_MONO) {
			int chanceStun = (actionCombat.getNiveau() * 100) / actionCombat.getNiveauMax();
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et tente de bloquer "
					+ cibles.get(0).getPrenom() + " avec " + chanceStun + "% de chance pour " + nbTour + " tour(s).");
		}
		// Stun Multi
		else if (actionCombat.getSortType() == SortType.STUN_MULTI) {
			int chanceStun = (actionCombat.getNiveau() * 50) / actionCombat.getNiveauMax();
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et tente de bloquer tous les ennemis avec "
							+ chanceStun + "% de chance pour " + nbTour + " tour(s).");
		}
		// Taunt Mono
		else if (actionCombat.getSortType() == SortType.TAUNT_MONO) {
			int chanceTaunt = (actionCombat.getNiveau() * 100) / actionCombat.getNiveauMax();
			label = new JLabel(perso.getPrenom() + lance + actionCombat.getNom() + " et tente de provoquer "
					+ cibles.get(0).getPrenom() + " avec " + chanceTaunt + "% de chance pour " + nbTour + " tour(s).");
		}
		// Taunt Multi
		else if (actionCombat.getSortType() == SortType.TAUNT_MULTI) {
			int chanceTaunt = (actionCombat.getNiveau() * 50) / actionCombat.getNiveauMax();
			label = new JLabel(
					perso.getPrenom() + lance + actionCombat.getNom() + " et tente de provoquer tous les ennemis avec "
							+ chanceTaunt + "% de chance pour " + nbTour + " tour(s).");
		}

		else {
			System.out.println("Ne devrait pas arriver la");
		}

		// Si critique
		if (isCritique) {
			label.setText("(CRITIQUE) " + label.getText());
		}

		label.setFont(Constante.ZELDA_FONT_FRAMECOMBAT_INFO);
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
		MusiqueManager.stopAll();
		MusiqueManager.startPlayListEnBoucle(mission);

		JOptionPane.showMessageDialog(this, "Debut du combat");

		// -- TODO Gestion IA
		lancePartiePremiereFois();
	}

	// Fin du jeu
	private void stop(Mission mission, boolean win) {

		// Eteint la musique de combat
		MusiqueManager.stopPlaylistEnBoucle();
		setMusiqueRunning(false);

		// Remise a zero pour prochain combat (duplique avec lancePartie())
		for (PersonnagePrincipal ami : amisPresents) {
			ami.setaDejaJoue(false);
		}
		if (timerEnnemis != null && timerEnnemis.isRunning()) {
			timerEnnemis.stop();
		}
		if (timerJoueurs != null && timerJoueurs.isRunning()) {
			timerJoueurs.stop();
		}

		// Remettre stats a zero pour prochain combat
		// Charge / bouclier / esquive / blocage / Taunt / Auras / vie Boss ? /
		// TODO remettre les bonus itemsCombat et aura a 0
		for (Personnage ami : amisPresents) {
			ami.setNombreBloque(0);
			ami.setNombreCharge(0);
			ami.setNombreEsquive(0);
			ami.setBouclier(0);
			ami.getTauntBy().clear();
			// TODO remove les competences aura de Competence
			ami.enleveAuras();
		}
		for (Personnage ennemi : ennemisVivants) {
			ennemi.setNombreBloque(0);
			ennemi.setNombreCharge(0);
			ennemi.setNombreEsquive(0);
			ennemi.setBouclier(0);
			ennemi.getTauntBy().clear();
			ennemi.enleveAuras();
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
							"Le sort de " + actionCombat.getProprietaire().name() + " : '" + actionCombat.getNom()
									+ "' a progressé d'un niveau ! (" + actionCombat.getNiveau() + ")",
							"Progression d'un sort", 0, FenetrePrincipal.getImageIcon(actionCombat.getImagePath().get(0)));
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
//		MusiqueManager.stopAll();

		// Fin de la mission
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, win);
	}

	private void centreFenetre() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}

	private void gestionItemSelectionne(PersoPrenom prenomCible) {
		if (itemSelectionne != null) {
			int reponse = JOptionPane.showConfirmDialog(this,
					"T'es sur de vouloir utiliser " + itemSelectionne.getNom() + " sur " + prenomCible.name() + "?");
			if (reponse == 0) {
				// OUI
				
				PersonnagePrincipal persoCible = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(prenomCible);
				PersonnagePrincipal persoLanceur = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(proprietaireItem);
				if (itemSelectionne.getType() == ItemType.POTION_VIE_25) {
					int vie = persoCible.getVie() + ((persoCible.getVieMax()*25)/100);
					if (vie > persoCible.getVieMax()) {
						vie = persoCible.getVieMax();
					}
					persoCible.setVie(vie);					
				} else if (itemSelectionne.getType() == ItemType.POTION_VIE_50) {
					int vie = persoCible.getVie() + ((persoCible.getVieMax()*50)/100);
					if (vie > persoCible.getVieMax()) {
						vie = persoCible.getVieMax();
					}
					persoCible.setVie(vie);	
				} else if (itemSelectionne.getType() == ItemType.POTION_VIE_75) {
					int vie = persoCible.getVie() + ((persoCible.getVieMax()*75)/100);
					if (vie > persoCible.getVieMax()) {
						vie = persoCible.getVieMax();
					}
					persoCible.setVie(vie);	
				} else if (itemSelectionne.getType() == ItemType.POTION_VIE_100) {
					persoCible.setVie(persoCible.getVieMax());	
					
				} else if (itemSelectionne.getType() == ItemType.POTION_MANA_25) {
					int mana = persoCible.getMana() + ((persoCible.getManaMax()*25)/100);
					if (mana > persoCible.getManaMax()) {
						mana = persoCible.getManaMax();
					}
					persoCible.setMana(mana);	
				} else if (itemSelectionne.getType() == ItemType.POTION_MANA_50) {
					int mana = persoCible.getMana() + ((persoCible.getManaMax()*50)/100);
					if (mana > persoCible.getManaMax()) {
						mana = persoCible.getManaMax();
					}
					persoCible.setMana(mana);	
				} else if (itemSelectionne.getType() == ItemType.POTION_MANA_75) {
					int mana = persoCible.getMana() + ((persoCible.getManaMax()*75)/100);
					if (mana > persoCible.getManaMax()) {
						mana = persoCible.getManaMax();
					}
					persoCible.setMana(mana);	
				} else if (itemSelectionne.getType() == ItemType.POTION_MANA_100) {
					persoCible.setMana(persoCible.getManaMax());	
					
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_CHANCE_5) {
					persoCible.addCompetences(PersoStat.LUCK, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_CHANCE_10) {
					persoCible.addCompetences(PersoStat.LUCK, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_CHANCE_20) {
					persoCible.addCompetences(PersoStat.LUCK, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_EXPLOIT_5) {
					persoCible.addCompetences(PersoStat.EXPLOIT, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_EXPLOIT_10) {
					persoCible.addCompetences(PersoStat.EXPLOIT, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_EXPLOIT_20) {
					persoCible.addCompetences(PersoStat.EXPLOIT, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_TECHNIQUE_5) {
					persoCible.addCompetences(PersoStat.TECHNIQUE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_TECHNIQUE_10) {
					persoCible.addCompetences(PersoStat.TECHNIQUE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_TECHNIQUE_20) {
					persoCible.addCompetences(PersoStat.TECHNIQUE, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_ENDURANCE_5) {
					persoCible.addCompetences(PersoStat.ENDURANCE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_ENDURANCE_10) {
					persoCible.addCompetences(PersoStat.ENDURANCE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_ENDURANCE_20) {
					persoCible.addCompetences(PersoStat.ENDURANCE, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RAPIDITE_5) {
					persoCible.addCompetences(PersoStat.RAPIDITE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RAPIDITE_10) {
					persoCible.addCompetences(PersoStat.RAPIDITE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RAPIDITE_20) {
					persoCible.addCompetences(PersoStat.RAPIDITE, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RESISTANCE_5) {
					persoCible.addCompetences(PersoStat.RESISTANCE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RESISTANCE_10) {
					persoCible.addCompetences(PersoStat.RESISTANCE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_RESISTANCE_20) {
					persoCible.addCompetences(PersoStat.RESISTANCE, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_AGILITE_5) {
					persoCible.addCompetences(PersoStat.AGILITE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_AGILITE_10) {
					persoCible.addCompetences(PersoStat.AGILITE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_AGILITE_20) {
					persoCible.addCompetences(PersoStat.AGILITE, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_INTELLIGENCE_5) {
					persoCible.addCompetences(PersoStat.INTELLIGENCE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_INTELLIGENCE_10) {
					persoCible.addCompetences(PersoStat.INTELLIGENCE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_INTELLIGENCE_20) {
					persoCible.addCompetences(PersoStat.INTELLIGENCE, 20);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_NERVOSITE_5) {
					persoCible.addCompetences(PersoStat.NERVOSITE, 5);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_NERVOSITE_10) {
					persoCible.addCompetences(PersoStat.NERVOSITE, 10);
				} else if (itemSelectionne.getType() == ItemType.BONUS_STAT_NERVOSITE_20) {
					persoCible.addCompetences(PersoStat.NERVOSITE, 20);
				}
				
				// TODO decremente l'item dans le sac du perso qui a utilisé l'item
				int valeur = persoLanceur.getSac().get(itemSelectionne);
				persoLanceur.getSac().put(itemSelectionne, valeur -1);
				
				JOptionPane.showMessageDialog(this, "Consomme : " + itemSelectionne.getNom());
				JLabel label = new JLabel(prenomCible.name() + " consomme " + itemSelectionne.getNom() + ".");
				label.setFont(Constante.ZELDA_FONT_FRAMECOMBAT_INFO);
				panelInfosCombat.add(label, 0);
				itemSelectionne = null;
				
				// Fin du tour du joueur (1 popo par tour par joueur)
				// FIXME probleme quand lanceur = cible la deuxieme fois, le focus reste sur le lanceur au lieu de switcher sur un autre joueur => ok?
				// FIXME probleme cible de la popo non selectionnable (alors que vivante) => ok?
				refreshFinTourJoueur(persoLanceur);

				
//				boolean itemConsomme = itemSelectionne.consommeItem();
//				if (itemConsomme) {
//					JOptionPane.showMessageDialog(this, "Consomme : " + itemSelectionne.getNom());
//					JLabel label = new JLabel(prenom.name() + " consomme " + itemSelectionne.getNom() + ".");
//					// label.setFont(Constante.PRESS_START_FONT_FRAMECOMBAT_INFO);
//					panelInfosCombat.add(label, 0);
//					// TODO setDisponible(false)? ou etat consomme?
//					// TODO modifier stats en fonction de l'item
//					itemSelectionne.setDisponible(false);
//
//				} else {
//					JOptionPane.showMessageDialog(this,
//							"L'item : " + itemSelectionne.getNom() + " n'a pas pu etre consomme : raison");
//				}
			}
			// TODO : remettre curseur souris normal
			panelOuest.setBorder(null);
			itemSelectionne = null;
			
			// TODO refresh panelCombat et panelAction
		}
	}

	private void lancePartiePremiereFois() {
		// Initiative : quelle equipe commence? basé sur une competence + random
		// Initiative basé sur meilleur stats (agilite, rapidite, chance) du groupe 
		boolean initiative = false;
		PersonnageManager personnageManager = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager();
		int agiliteMax = personnageManager.getBestStatPersoVivant(PersoStat.AGILITE) / 3;
		int rapiditeMax = personnageManager.getBestStatPersoVivant(PersoStat.RAPIDITE) / 3;
		int chanceMax = personnageManager.getBestStatPersoVivant(PersoStat.LUCK) / 3;
		int max = agiliteMax + rapiditeMax + chanceMax;
		int random = RandomManager.random(100 - max, 100);
		int chanceInitiative = 0;
		int nombreJoueurs = amisVivants.size();

		// tempsMax en fonction de la difficulte et du nombre de joueurs (oo,
		// 45, 30, 20)
		// chanceInitiative en fonction de la difficulte (100, 75, 50, 25)
		if (mission.getDifficulty() == Difficulte.FACILE) {
			tempsMax = 0; // Pas de timer
			chanceInitiative = 100;
		} else if (mission.getDifficulty() == Difficulte.NORMAL) {
			tempsMax = 5 * nombreJoueurs;
			chanceInitiative = 75;
		} else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
			tempsMax = 4 * nombreJoueurs;
			chanceInitiative = 50;
		} else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
			tempsMax = 3 * nombreJoueurs;
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

			// Lance chrono tour joueurs si difficulte facile+
			if (tempsMax != 0) {
				timerJoueurs.start();
			}
		}
	}

	// Gestion de l'IA (tour par tour / dynamique)
	private void lanceTourEnnemis() {

		// On debloque les alliés bloqués au tour precedant
		for (PersonnagePrincipal ami : amisVivants) {
			Map<Personnage, Integer> tauntBy = ami.getTauntBy();
			if (ami.getNombreBloque() > 0) {
				ami.setNombreBloque(ami.getNombreBloque() - 1);
			}
			// On deTaunt les alliés taunt au tour precedant
			else if (!tauntBy.isEmpty()) {
				Object[] persos = tauntBy.keySet().toArray();
				Personnage persoCible = (Personnage) persos[0];
				Integer nbTaunt = tauntBy.get(persoCible);
				tauntBy.remove(persoCible);
				if (nbTaunt > 1) {
					tauntBy.put(persoCible, nbTaunt - 1);
				}
			}
		}
		
		// Si il y a des ennemis vivants
		if (!ennemisVivants.isEmpty()) {
			// On lance tour ennemis
			JOptionPane.showMessageDialog(this, "Tour des ennemis");
	
			timerEnnemis = new Timer(1000, new MyEnnemiActionListener());
			timerEnnemis.setInitialDelay(100);
			timerEnnemis.start();
		}
	}

	private ActionCombat choixDuSortEnnemi(PersonnageEnnemi ennemi) {

		// TODO IA choix de l'attaque en fonction de la difficulte et de la
		// classe
		// TODO gestion choix quand plusieurs attaque dispo (systeme de score?)
		// essaie de rez
		// essaie de heal/mana/bouclier
		// essaie de tuer

		List<ActionCombat> actionsCombat = ennemi.getActionsCombat();
		ActionCombat action = null;
		Map<ActionCombat, Integer> actionsScores = new HashMap<ActionCombat, Integer>();

		// Gestion difficulte IA (handicap sur les chances d'un sort a etre
		// choisi)
		int handicap = 0;
		if (mission.getDifficulty() == Difficulte.FACILE) {
			handicap = 30;
		} else if (mission.getDifficulty() == Difficulte.NORMAL) {
			handicap = 20;
		} else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
			handicap = 10;
		} else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
			handicap = 0;
		}

		for (ActionCombat actionCombat : actionsCombat) {
			boolean sortLancable = testConsommationEnergieEnnemi(ennemi, actionCombat);
			if (sortLancable) {

				// TODO valeur du score mieux choisi (100,95,90,...)

				// Gestion par priorite
				if (actionCombat.getSortType() == SortType.RESURRECTION_MULTI) {
					// Si il y a au moins deux mort
					if (ennemisVivants.size() < ennemisPresents.size() - 2) {
						actionsScores.put(actionCombat, 100 - handicap);
					}
				} else if (actionCombat.getSortType() == SortType.RESURRECTION_MONO) {
					// Si il y a au moins un mort
					if (ennemisVivants.size() != ennemisPresents.size()) {
						actionsScores.put(actionCombat, 95 - handicap);
					}
				} else if (actionCombat.getSortType() == SortType.REGEN_VIE_MULTI) {
					int count = 0;
					for (Personnage perso : ennemisVivants) {
						// Si au moins deux des ennemis ont moins de la moitie
						// de leur vie
						if ((perso.getVie() < (perso.getVieMax() / 2))) {
							count = count++;
							if (count > 1) {
								actionsScores.put(actionCombat, 90 - handicap);
							}
						}
					}
				} else if (actionCombat.getSortType() == SortType.REGEN_VIE_PERSO) {
					// Si le lanceur a moins de la moitie de sa vie
					if (ennemi.getVie() < (ennemi.getVieMax() / 2)) {
						actionsScores.put(actionCombat, 85 - handicap);
					}
				} else if (actionCombat.getSortType() == SortType.REGEN_VIE_MONO) {
					for (Personnage perso : ennemisVivants) {
						// Si un des ennemis a moins de la moitie de sa vie
						if (perso.getVie() < (perso.getVieMax() / 2)) {
							actionsScores.put(actionCombat, 80 - handicap);
						}
					}
				} else if (actionCombat.getSortType() == SortType.REGEN_MANA_MULTI) {
					int count = 0;
					for (Personnage perso : ennemisVivants) {
						// Si au moins deux des ennemis ont moins de la moitie
						// de leur mana
						if (perso.getMana() < (perso.getManaMax() / 2)) {
							count = count++;
							if (count > 1) {
								actionsScores.put(actionCombat, 75 - handicap);
							}
						}
					}
				} else if (actionCombat.getSortType() == SortType.REGEN_MANA_PERSO) {
					// Si le lanceur a moins de la moitie de son mana
					if (ennemi.getMana() < (ennemi.getManaMax() / 2)) {
						actionsScores.put(actionCombat, 70 - handicap);
					}
				} else if (actionCombat.getSortType() == SortType.REGEN_MANA_MONO) {
					for (Personnage perso : ennemisVivants) {
						// Si un des ennemis a moins de la moitie de son mana
						if (perso.getMana() < (perso.getManaMax() / 2)) {
							actionsScores.put(actionCombat, 65 - handicap);
						}
					}
				} else if (actionCombat.getSortType() == SortType.BOUCLIER_MULTI) {
					int count = 0;
					for (Personnage perso : ennemisVivants) {
						// Si au moins deux des ennemis n'ont pas de bouclier
						if (perso.getBouclier() == 0) {
							count = count++;
							if (count > 1) {
								actionsScores.put(actionCombat, 60 - handicap);
							}
						}
					}
				} else if (actionCombat.getSortType() == SortType.BOUCLIER_PERSO) {
					// Si le lanceur n'a pas de bouclier
					if (ennemi.getBouclier() == 0) {
						actionsScores.put(actionCombat, 55 - handicap);
					}
				} else if (actionCombat.getSortType() == SortType.BOUCLIER_MONO) {
					for (Personnage perso : ennemisVivants) {
						// Si un des ennemis n'a pas de bouclier
						if (perso.getBouclier() == 0) {
							actionsScores.put(actionCombat, 50 - handicap);
						}
					}
				} else if (actionCombat.getSortType() == SortType.ABSORPTION_MANA_MULTI) {
					int count = 0;
					// Si le lanceur a moins de la moitie de son mana
					if (ennemi.getMana() < ennemi.getManaMax() / 2) {
						for (Personnage perso : ennemisVivants) {
							// Si au moins deux ennemis ont plus de la moitie de
							// son mana
							if (perso.getMana() > perso.getManaMax() / 2) {
								count = count++;
								if (count > 1) {
									actionsScores.put(actionCombat, 50 - handicap);
								}
							}
						}
					}
				} else if (actionCombat.getSortType() == SortType.ABSORPTION_MANA_MONO) {
					// Si le lanceur a moins de la moitie de son mana
					if (ennemi.getMana() < ennemi.getManaMax() / 2) {
						for (Personnage perso : ennemisVivants) {
							// Si un ennemi a plus de la moitie de son mana
							if (perso.getMana() > perso.getManaMax() / 2) {
								actionsScores.put(actionCombat, 50 - handicap);
							}
						}
					}
				} else if (actionCombat.getSortType() == SortType.ABSORPTION_VIE_MULTI) {
					int count = 0;
					// Si le lanceur a moins de la moitie de sa vie
					if (ennemi.getVie() < ennemi.getVieMax() / 2) {
						for (Personnage perso : ennemisVivants) {
							// Si au moins deux ennemis ont plus de la moitie de
							// sa vie
							if (perso.getVie() > perso.getVieMax() / 2) {
								count = count++;
								if (count > 1) {
									actionsScores.put(actionCombat, 50 - handicap);
								}
							}
						}
					}
				} else if (actionCombat.getSortType() == SortType.ABSORPTION_VIE_MONO) {
					// Si le lanceur a moins de la moitie de sa vie
					if (ennemi.getVie() < ennemi.getVieMax() / 2) {
						for (Personnage perso : ennemisVivants) {
							// Si un ennemi a plus de la moitie de sa vie
							if (perso.getVie() > perso.getVieMax() / 2) {
								actionsScores.put(actionCombat, 50 - handicap);
							}
						}
					}
					// TODO else if les autres sorts
				} else if (actionCombat.getActionCombatType() == ActionCombatType.SPECIAL) {
					actionsScores.put(actionCombat, 95 - handicap);
				} else if (actionCombat.getActionCombatType() == ActionCombatType.POUVOIR) {
					actionsScores.put(actionCombat, 50 - handicap);
				} else if (actionCombat.getActionCombatType() == ActionCombatType.DEFENSE) {
					actionsScores.put(actionCombat, 50 - handicap);
				} else if (actionCombat.getActionCombatType() == ActionCombatType.ATTAQUE) {
					actionsScores.put(actionCombat, 40 - handicap);
				}
			}
		}

		// TODO Si lanceur est Taunt
		if (!ennemi.getTauntBy().isEmpty()) {
			// limité a des sort mono Ennemi
			triActions(actionsScores);
			action = getBestActionByScore(action, actionsScores);

		} else {
			// Random parmis toutes les actions avec des coeff
			action = getBestActionByScore(action, actionsScores);
		}

		return action;
	}

	private void triActions(Map<ActionCombat, Integer> actionsScores) {
		Map<ActionCombat, Integer> temp = new HashMap<ActionCombat, Integer>(actionsScores);
		Set<ActionCombat> actions = temp.keySet();
		for (ActionCombat action : actions) {
			if (action.getCibleType() != CibleType.ENNEMI) {
				actionsScores.remove(action);
			}
		}
	}

	private ActionCombat getBestActionByScore(ActionCombat action, Map<ActionCombat, Integer> actionsScores) {
		Set<Entry<ActionCombat, Integer>> entrySet = actionsScores.entrySet();
		Set<Entry<ActionCombat, Integer>> entrySetTemp = new HashSet<Entry<ActionCombat, Integer>>(entrySet);
		while (action == null) {
			int meilleurScore = 0;
			ActionCombat meilleurAction = null;
			Entry<ActionCombat, Integer> meilleurEntry = null;
			for (Entry<ActionCombat, Integer> entry : entrySetTemp) {
				if (entry.getValue() > meilleurScore) {
					meilleurScore = entry.getValue();
					meilleurAction = entry.getKey();
					meilleurEntry = entry;
				}
			}
			int random = RandomManager.random(0, 100);
			System.out.println(
					"Essaie de lancer '" + meilleurAction.getNom() + "' avec (" + meilleurScore + "%) de chance.");
			if (random < meilleurScore) {
				action = meilleurAction;
				System.out.println("Reussie.");
			} else {
				System.out.println("Raté.");
				System.out.println("Il y a " + entrySetTemp.size() + " actions a essayer");
				entrySetTemp.remove(meilleurEntry);
				System.out.println("Il reste " + entrySetTemp.size() + " actions a essayer");
				if (entrySetTemp.isEmpty()) {
					action = meilleurAction;
				}
			}
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

		// TODO barres pleines

		panelCentre.removeAll();

		BoxLayout boxlayoutCombat = new BoxLayout(panelCentre, BoxLayout.Y_AXIS);
		panelCentre.setLayout(boxlayoutCombat);

		JPanel panelJoueurs = new JPanel();
		JPanel panelAdversaires = new JPanel();

		for (PersonnagePrincipal perso : amisVivants) {
			JPanel panelPerso = buildPanelPerso(perso);
			panelJoueurs.add(panelPerso);
		}

		for (PersonnageEnnemi perso : ennemisVivants) {
			JPanel panelPerso = buildPanelPerso(perso);
			panelAdversaires.add(panelPerso);
		}

		labelTimer = new JLabel("OO");
		labelTimer.setFont(Constante.ZELDA_FONT_MENU_SELECTED);

		panelCentre.add(panelAdversaires);
		panelCentre.add(labelTimer);
		panelCentre.add(panelJoueurs);
	}

	private JPanel buildPanelPerso(Personnage perso) {
		JPanel panelPerso = new JPanel();
		BoxLayout boxlayout = new BoxLayout(panelPerso, BoxLayout.Y_AXIS);
		panelPerso.setLayout(boxlayout);

		// Largeur des barres 200
		int largeur = Constante.PANEL_INFO_PERSO_LARGEUR;
		int hauteur = Constante.PANEL_INFO_PERSO_HAUTEUR;

		// Barre de Charge
		JLayeredPane barreCharge = new JLayeredPane();
		barreCharge.setLayout(new LayeredLayoutManager());

		JPanel barreChargeCouleur = new JPanel();
		barreChargeCouleur.setBackground(Color.MAGENTA);
		barreChargeCouleur.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		int largeurCharge = (largeur * perso.getNombreCharge()) / perso.getNombreChargeMax();
		barreChargeCouleur.setMaximumSize(new Dimension(largeurCharge, hauteur));

		JPanel barresCharge = new JPanel();
		barresCharge.setLayout(new BoxLayout(barresCharge, BoxLayout.X_AXIS));
		barresCharge.setBackground(Color.BLACK);
		barresCharge.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		barresCharge.add(barreChargeCouleur);
		barreCharge.add(barresCharge, Integer.valueOf(1));

		JLabel labelCharge = new JLabel(perso.getNombreCharge() + "/" + perso.getNombreChargeMax());
		labelCharge.setHorizontalAlignment(SwingConstants.CENTER);
		labelCharge.setVerticalAlignment(SwingConstants.CENTER);
		labelCharge.setForeground(Color.PINK);
		barreCharge.add(labelCharge, Integer.valueOf(5));

		barreCharge.setPreferredSize(new Dimension(largeur, hauteur));

		// Barre de Mana
		JLayeredPane barreMana = new JLayeredPane();
		barreMana.setLayout(new LayeredLayoutManager());

		JPanel barreManaCouleur = new JPanel();
		barreManaCouleur.setBackground(Color.BLUE);
		barreManaCouleur.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		int largeurMana = (largeur * perso.getMana()) / perso.getManaMax();
		barreManaCouleur.setMaximumSize(new Dimension(largeurMana, hauteur));

		JPanel barresMana = new JPanel();
		barresMana.setLayout(new BoxLayout(barresMana, BoxLayout.X_AXIS));
		barresMana.setBackground(Color.BLACK);
		barresMana.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		barresMana.add(barreManaCouleur);
		barreMana.add(barresMana, Integer.valueOf(1));

		JLabel labelMana = new JLabel(perso.getMana() + "/" + perso.getManaMax());
		labelMana.setHorizontalAlignment(SwingConstants.CENTER);
		labelMana.setVerticalAlignment(SwingConstants.CENTER);
		labelMana.setForeground(Color.CYAN);
		barreMana.add(labelMana, Integer.valueOf(5));

		barreMana.setPreferredSize(new Dimension(largeur, hauteur));

		// Barre de Bouclier
		JLayeredPane barreBouclier = new JLayeredPane();
		barreBouclier.setLayout(new LayeredLayoutManager());

		JPanel barreBouclierCouleur = new JPanel();
		barreBouclierCouleur.setBackground(Color.CYAN);
		barreBouclierCouleur.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		int largeurBouclier = (largeur * perso.getBouclier()) / perso.getVieMax();
		barreBouclierCouleur.setMaximumSize(new Dimension(largeurBouclier, hauteur));

		JPanel barresBouclier = new JPanel();
		barresBouclier.setLayout(new BoxLayout(barresBouclier, BoxLayout.X_AXIS));
		barresBouclier.setBackground(Color.BLACK);
		barresBouclier.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		barresBouclier.add(barreBouclierCouleur);
		barreBouclier.add(barresBouclier, Integer.valueOf(1));

		JLabel labelBouclier = new JLabel(perso.getBouclier() + "");
		labelBouclier.setHorizontalAlignment(SwingConstants.CENTER);
		labelBouclier.setVerticalAlignment(SwingConstants.CENTER);
		labelBouclier.setForeground(Color.WHITE);
		barreBouclier.add(labelBouclier, Integer.valueOf(5));

		barreBouclier.setPreferredSize(new Dimension(largeur, hauteur));

		// Barre de Vie
		JLayeredPane barreVie = new JLayeredPane();
		barreVie.setLayout(new LayeredLayoutManager());

		// Couleur en fonction de la vie
		JPanel barreVieCouleur = new JPanel();
		// Si full life
		if (perso.getVie() == perso.getVieMax()) {
			barreVieCouleur.setBackground(new Color(0, 255, 0));
		}
		// Si plus de la moitie de la vie
		else if (perso.getVie() > (perso.getVieMax() / 2)) {
			// red entre 0 et 255
			int red = 255 - ((perso.getVie() * (255 / 2)) / (perso.getVieMax()));
			barreVieCouleur.setBackground(new Color(red, 255, 0));
		}
		// Si moins de la moitie de la vie
		else {
			// green entre 255 et 0
			int green = (perso.getVie() * (255 * 2)) / (perso.getVieMax());
			barreVieCouleur.setBackground(new Color(255, green, 0));
		}
		barreVieCouleur.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		int largeurVie = (largeur * perso.getVie()) / perso.getVieMax();
		barreVieCouleur.setMaximumSize(new Dimension(largeurVie, hauteur));

		JPanel barresVie = new JPanel();
		barresVie.setLayout(new BoxLayout(barresVie, BoxLayout.X_AXIS));
		barresVie.setBackground(Color.BLACK);
		barresVie.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		barresVie.add(barreVieCouleur);
		barreVie.add(barresVie, Integer.valueOf(1));

		JLabel labelVie = new JLabel(perso.getVie() + "/" + perso.getVieMax());
		labelVie.setHorizontalAlignment(SwingConstants.CENTER);
		labelVie.setVerticalAlignment(SwingConstants.CENTER);
		labelVie.setForeground(Color.YELLOW);
		barreVie.add(labelVie, Integer.valueOf(5));

		barreVie.setPreferredSize(new Dimension(largeur, hauteur));

		// Barre de Personnage/Nom
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

				// TODO gestion fuite de l'ennemi si nombre inferieur (1/4, 2/6,
				// 3/8)
				// et qu'il n'y a pas de REZeur
				// et que ce n'est pas une mission boss
				// et fonction de la difficulte

				PersonnageEnnemi ennemi = ennemisVivants.get(index);

				// Si l'ennemi est bloqué
				if (ennemi.getNombreBloque() > 0) {
					ennemi.setNombreBloque(ennemi.getNombreBloque() - 1);
					JLabel label = new JLabel(ennemi.getPrenom() + " est bloqué ce tour-ci.");
					panelInfosCombat.add(label, 0);
				}
				// Si l'ennemi n'est pas bloqué
				else {
					// Selectionne une attaque ennemi
					ActionCombat actionCombat = choixDuSortEnnemi(ennemi);

					// Lance attaque ennemi
					executeSort(ennemi, actionCombat, null, null);
				}

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

					// Raffraichissment panel Bas sur un perso vivant et non
					// bloqué
					if (!amisVivants.isEmpty()) {
						PersoPrenom prenom = amisVivants.get(0).getPrenomPerso();
						for (PersonnagePrincipal ami : amisVivants) {
							if (ami.getNombreBloque() == 0) {
								prenom = ami.getPrenomPerso();
							}
						}
						buildPanelActions(prenom);

						// Message tour allie
						JOptionPane.showMessageDialog(FrameCombat.getFrameCombat(), "Tour des allies");

						boolean finduTourAmi = true;
						for (PersonnagePrincipal ami : amisVivants) {
							if (ami.getNombreBloque() == 0) {
								finduTourAmi = false;
								// break;
							}
						}

						// Si tous les allies vivants sont stun
						if (finduTourAmi) {
							lanceTourEnnemis();
						}
						// Lance chrono tour joueurs si difficulte normal+
						else if (tempsMax != 0) {
							MyJoueurActionListener actionListener = (MyJoueurActionListener) timerJoueurs
									.getActionListeners()[0];
							actionListener.resetTime();
							timerJoueurs.restart();
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
			// et qu'ils ne sont pas bloqué
			boolean finTourJoueurs = true;
			for (PersonnagePrincipal perso : amisVivants) {
				if (!perso.isaDejaJoue() && perso.getNombreBloque() == 0) {
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

		public void resetTime() {
			time = maxTime;
		}

	}
}
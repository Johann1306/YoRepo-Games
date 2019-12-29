package front;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.ImageManager;
import core.MusiqueManager;
import core.RandomManager;
import core.VideoManager;
import core.configuration.Constante;
import javafx.animation.AnimationTimer;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.event.Event;
import javafx.scene.input.DragEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.input.Dragboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.TransferMode;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import modele.competence.Competence;
import modele.foot.Poste;
import modele.item.Item;
import modele.item.media.audio.Musique;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.Personnage;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;

@SuppressWarnings("restriction")
public class FrameFootFX extends FrameJeu {
	
	private static final long serialVersionUID = 1L;

	private JPanel panelNord = new JPanel();
	private JPanel panelOuest = new JPanel();
	private JFXPanel panelCentre = new JFXPanel();
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
	private List<JButton> boutonsAdversaires = null;
	private List<JButton> boutonsAmis = null;
	private List<Personnage> ennemis = null;
	private Mission mission = null;
	
	
//	private Label labelSourisX;
//	private Label labelSourisY;
//	private Label labelVelocityX;
//	private Label labelVelocityY;
//	private Label labelVelocityZ;
//	private Label labelX;
//	private Label labelY;
//	private Label labelZ;
//	private Label labelPorteur;
//	private Label labelTireur;
//	private Label labelBallonX;
//	private Label labelBallonY;
//	private Label labelBallonVelociteX;
//	private Label labelBallonVelociteY;
//	private Label labelCibleX;
//	private Label labelCibleY;
//	private Label labelSpeed;
//	private Label labelJoueurAuto;
	
	private Label labelButsAllies;
	private Label labelButsAdverses;
	private Label labelTimer;
	
	private Label labelJoueurPrincipal;

	private Label labelNomPorteur;

	private Label labelNomButeur;

    PVector mouse = new PVector(0,0,0);
    double sourisX = 0;
    double sourisY = 0;

	private List<JoueurPrincipal> joueursEnnemis = null;
	private List<JoueurPrincipal> joueursAmis = null;
	private JoueurPrincipal joueur;
	private JoueurPrincipal porteur;
	private JoueurPrincipal tireur;
	
	private boolean joueurAutomatique = false;

	private AnimationTimer timer;
	private Group root;
	private Ballon ballon;

	private boolean gameStarted = false;
	private boolean ballonLibre = false;
	
	private int butsAllies;
	private int butsAdverses;

	private long dateDerniereAction;

	private TextArea logging;

	private Map<PersonnagePrincipal, Poste> equipeAmi;
	private Map<Personnage, Poste> equipeAdverse;

	private PersonnagePrincipal joueurPrincipal;

	private long timerStopped = 0;
    private long finDumatch = 0; // Duree du match en ms

	private List<PersonnagePrincipal> persosDispo;

	private Image imageEchangee;
	private Image imageDefaut;
	private Image imageDropped;

	private String textEchange;
	
	private List<ImageView> imageViewsTarget;

	private Button boutonValider;

	private Map<Poste, String> textViewsTarget;

	private List<Poste> postes;

	private Label labelInfoEquipe;
	
	private String lieuDuTerrain;

	private int facteurAgrandissement;

	public FrameFootFX(Mission mission) {
		
		// Les competences de chaque joueurs influent les reactions
			// - Rapidite : Vitesse max / reactivite (retournement / temps de reaction interception / temps de reaction clash) / Bonus zone interception
			// - Agilité : reussite clash / acceleration / reactivite (retournement / temps de reaction interception / temps de reaction clash) / precision du tir/passe / puissance du tir / controle/deviation / Bonus zone interception
			// - Technique : reussite clash / Vitesse max / acceleration / reactivite (retournement / temps de reaction interception / temps de reaction clash) / precision du tir/passe / puissance du tir / controle/deviation
			// - Exploit : reussite clash / precision du tir/passe / puissance du tir
			// - Intelligence : reussite clash / precision du tir/passe / Bonus zone interception 
			// - Nervosite : reussite clash / precision du tir/passe / puissance du tir / reactivite (retournement / temps de reaction interception / temps de reaction clash) / controle/deviation
			// - Resistance : reussite clash / controle/deviation
			// - Endurance : reussite clash / reactivite (retournement / temps de reaction interception / temps de reaction clash) / Vitesse max
			// - Luck : reussite clash / precision du tir/passe / puissance du tir / controle/deviation 

		// Calcul au debut du match
			// Vitesse max : RAPIDITE / TECHNIQUE / ENDURANCE
			// Reactivite (retournement / temps de reaction interception / temps de reaction clash) : RAPIDITE / AGILITE / TECHNIQUE / NERVOSITE / ENDURANCE
			// Bonus zone interception : AGILITE / RAPIDITE / INTELLIGENCE

		// Calcul a chaque action
			// Reussite clash : AGILITE / TECHNIQUE / EXPLOIT / INTELLIGENCE / NERVOSITE / RESISTANCE / ENDURANCE / LUCK
			// Precision du tir/passe : AGILITE / TECHNIQUE / EXPLOIT / NERVOSITE / LUCK
			// Puissance du tir : AGILITE / TECHNIQUE / EXPLOIT / NERVOSITE / LUCK
			// Controle/Deviation : AGILITE / TECHNIQUE / NERVOSITE / INTELLIGENCE / LUCK
		
		// TODO Attaquants proposent des solutions
		// TODO passe dans les pieds / dans la course 
		
		// TODO probleme a la selection des perso (le joueur disparait des fois pendant le drag and drop) ! reproduit (mettre un bouton retour! sinon on est bloqué)
		
		this.mission = mission;
		
		choixDesPersos();
		
		//Init
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(panelCentre, BorderLayout.CENTER);
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setContentPane(content);
		this.setVisible(true);
		
	}
	
	private boolean musiqueRunning = true;

	
	// TODO duplicate avec FrameJeu (mais resoud le probleme du bouton son)
	public JPanel createPanelInfoMission(Mission mission) {
		JPanel panelInfoMission = new JPanel();
		JButton boutonMusiqueOnOff = new JButton("Musique ON/OFF");
		boutonMusiqueOnOff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isMusiqueRunning()) {
					MusiqueManager.stopAll();
					setMusiqueRunning(false);
				} else {
					List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("musique/foot", 281100);
					MusiqueManager.playMusiquesRandom(musiques);	
					setMusiqueRunning(true);
				}
			}
		});
		PersoPrenom prenom = mission.getProprietaire();
		ImageIcon image = null;
		if (prenom.name().equals("GROUPE")) {
			image = FenetrePrincipal.getImageIcon("image/groupe.png");
		} else {
			PersonnagePrincipal proprietaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe().getPersoByNom(prenom);
			image = proprietaire.getPhotoPrincipal();
		}
		ImageIcon resizeImagePerso = ImageManager.resizeImage(image,
				new Dimension(Constante.PANEL_INFO_MISSION_HAUTEUR - 10, Constante.PANEL_INFO_MISSION_HAUTEUR - 10));
		
		JLabel labelProprio = new JLabel(mission.getProprietaire().name());
		JLabel labelNom = new JLabel(mission.getNom() + " : ");
		JLabel labelInfo = new JLabel(mission.getInformations());
		labelNom.setFont(Constante.MARIO_FONT_MENU_3);
		labelInfo.setFont(Constante.MARIO_FONT_MENU_2);
		labelNom.setForeground(java.awt.Color.YELLOW);
		labelInfo.setForeground(java.awt.Color.WHITE);
		labelNom.setMaximumSize(this.getMaximumSize());
		JLabel labelObjectif = new JLabel(mission.getObjectif());
		JLabel labelConditionVictoire = new JLabel(mission.getConditionVictoire());
		JLabel labelDifficulte = new JLabel(mission.getDifficulty().name());
		JLabel labelTypeMisson = new JLabel(mission.getMissionType().name());
		
		panelInfoMission.add(new JLabel(resizeImagePerso));
//		panelInfoMission.add(labelProprio);
		panelInfoMission.add(labelNom);
		panelInfoMission.add(labelInfo);
//		panelInfoMission.add(labelObjectif);
//		panelInfoMission.add(labelConditionVictoire);
//		panelInfoMission.add(labelDifficulte);
//		panelInfoMission.add(labelTypeMisson);
		panelInfoMission.add(boutonMusiqueOnOff);
		
		panelInfoMission.setBackground(java.awt.Color.BLACK);
		return panelInfoMission;
	}

	public boolean isMusiqueRunning() {
		return musiqueRunning;
	}

	public void setMusiqueRunning(boolean musiqueRunning) {
		this.musiqueRunning = musiqueRunning;
	}

	public void reinitialisation() {
		
		butsAllies = 0;
		butsAdverses = 0;
		
		joueursAmis = new ArrayList<>();
		joueursEnnemis = new ArrayList<>();
		
		// Initialisation des equipes et joueur principal
		Poste postePrincipal = equipeAmi.get(joueurPrincipal);
		joueur = new JoueurPrincipal(joueurPrincipal, true, postePrincipal, facteurAgrandissement);
		if (postePrincipal == Poste.BD) {
			porteur = joueur;
		}
		
		for (Personnage personnage : equipeAmi.keySet()) {
			if (personnage != joueurPrincipal) {
				Poste poste = equipeAmi.get(personnage);
				JoueurPrincipal joueurAmi = new JoueurPrincipal(personnage, true, poste, facteurAgrandissement);
				joueursAmis.add(joueurAmi);
				if (poste == Poste.BD) {
					porteur = joueurAmi;
				}
			}
		}
		
		// Les joueurs adverses clonent les competences des joueurs amis en fonction du poste
		// TODO faire mieux comme difficulte evolutive avec le temps
		for (Personnage personnage : equipeAdverse.keySet()) {
			Poste poste = equipeAdverse.get(personnage);
			for (Personnage ami : equipeAmi.keySet()) {
				if (equipeAmi.get(ami) == poste) {
					personnage.setCompetence(new Competence(ami.getCompetence().getStats()));
					
					// TODO gestion en fonction de la difficulte
					if (mission.getDifficulty() == Difficulte.FACILE) {
						personnage.addAllCompetences(5);
					} else if (mission.getDifficulty() == Difficulte.NORMAL) {
						personnage.addAllCompetences(10);
					} else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
						personnage.addAllCompetences(15);
					} else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
						personnage.addAllCompetences(20);
					}
					// TODO a supprimer (Pour tester les ennemis avec les competences au max (100/100))
//					personnage.addAllCompetences(100);

				}
			}
			joueursEnnemis.add(new JoueurPrincipal(personnage, false, poste, facteurAgrandissement));
		}

		// Configuration de la fenetre
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());

		this.setAlwaysOnTop(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// Personnages principaux
		Groupe groupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
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
		boutonsAmis = new ArrayList<JButton>();

		if (equipeAmi.keySet().contains(thomas)) {
			panelPersos.add(boutonThomas);
			boutonsAmis.add(boutonThomas);
		}
		if (equipeAmi.keySet().contains(guillaume)) {
			panelPersos.add(boutonGuillaume);
			boutonsAmis.add(boutonGuillaume);
		}
		if (equipeAmi.keySet().contains(nicolas)) {
			panelPersos.add(boutonNicolas);
			boutonsAmis.add(boutonNicolas);
		}
		if (equipeAmi.keySet().contains(pierre)) {
			panelPersos.add(boutonPierre);
			boutonsAmis.add(boutonPierre);
		}
		if (equipeAmi.keySet().contains(jonathan)) {
			panelPersos.add(boutonJonathan);
			boutonsAmis.add(boutonJonathan);
		}
		if (equipeAmi.keySet().contains(yannick)) {
			panelPersos.add(boutonYannick);
			boutonsAmis.add(boutonYannick);
		}
		if (equipeAmi.keySet().contains(johann)) {
			panelPersos.add(boutonJohann);
			boutonsAmis.add(boutonJohann);
		}
		if (equipeAmi.keySet().contains(ali)) {
			panelPersos.add(boutonAli);
			boutonsAmis.add(boutonAli);
		}

		// TODO action quand clic perso
		for (JButton boutonAmi : boutonsAmis) {
			boutonAmi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
	
		panelOuest.add(panelPersos);

		// -- Panel Est
		JPanel panelEnnemis = new JPanel();
		BoxLayout boxlayoutEnnemis = new BoxLayout(panelEnnemis, BoxLayout.Y_AXIS);
		panelEnnemis.setLayout(boxlayoutEnnemis);

		// Gestion des adversaires
		boutonsAdversaires = new ArrayList<JButton>();
		ennemis = new ArrayList<Personnage>();

		for (int i = 1; i <= boutonsAmis.size(); i++) {
//			PersonnageEnnemi ennemi = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager()
//					.createPersonnageEnnemi(mission, i);
//			adversaires.add(ennemi);
//			JButton boutonEnnemi = new JButton(ennemi.getPhotoPrincipal());
//			boutonEnnemi.setName(ennemi.getNom());
//			boutonEnnemi.setPreferredSize(Constante.PERSO_IMAGE_DIMENSION_64_64);
//			boutonEnnemi.setToolTipText(boutonEnnemi.getName());
//			boutonEnnemi.setFocusable(false);
//			panelEnnemis.add(boutonEnnemi);
//			boutonsAdversaires.add(boutonEnnemi);
		}

		panelEst.add(panelEnnemis);

		// -- Panel Sud - Actions

		// -- Panel Centre

		// --
		panelNord.setBackground(java.awt.Color.BLACK);
		panelOuest.setBackground(java.awt.Color.GREEN);
		panelCentre.setBackground(java.awt.Color.WHITE);
		panelEst.setBackground(java.awt.Color.RED);
		panelSud.setBackground(java.awt.Color.BLUE);

		content.add(panelNord, BorderLayout.NORTH);
		content.add(panelOuest, BorderLayout.WEST);
		content.add(panelCentre, BorderLayout.CENTER);
		content.add(panelEst, BorderLayout.EAST);
		content.add(panelSud, BorderLayout.SOUTH);

		this.setContentPane(content);
		this.setVisible(true);
	}

	public void start() {
		MenuPrincipal.getMainFrame().setEnabled(false);
		MenuPrincipal.getMainFrame().setVisible(false);
		VideoManager.hideAndStop();
		MusiqueManager.stopAll();
		
		// Musique selection des persos
		List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/selection", 280000);
		MusiqueManager.playSonRandom(musiques);	
	}

	private void lancePartie() {
		MusiqueManager.stopAll();
		MusiqueManager.stopPlaylistEnBoucle();
		List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("musique/foot", 281000);
		MusiqueManager.playMusiquesRandom(musiques);	
		JOptionPane.showMessageDialog(this, "Debut du match");
		new Thread(new Runnable() {
			@Override
			public void run() {
				initFX();
			}
		}).start();
	}
	
	private void initFX() {
		// This method is invoked on the JavaFX thread
		Scene scene = createScene();
		panelCentre.removeAll();
		panelCentre.setScene(scene);
	}
	
	private void choixDesPersos() {
		Scene scene = createScenePersos();
		panelCentre.removeAll();
		panelCentre.setScene(scene);
	}
	
	private Scene createScenePersos() {

		root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		
		equipeAmi = new HashMap<>();
		equipeAdverse = new HashMap<>();

		// Foot ecole 5v5
		if (mission.getId() == 3001) {
			choixDesJoueursAmis(5);
			
		// Foot terrain 5v5
		} else if (mission.getId() == 3002) {
			choixDesJoueursAmis(5);
			
		// Foot terrain 6v6
		} else if (mission.getId() == 3003) {
			choixDesJoueursAmis(6);
			
		// Foot terrain 7v7
		} else if (mission.getId() == 3004) {
			choixDesJoueursAmis(7);
			
		// Foot terrain 8v8
		} else if (mission.getId() == 3005) {
			choixDesJoueursAmis(8);
			
		// Foot Chelles 7v7
		} else if (mission.getId() == 3006) {
			choixDesJoueursAmis(7);
			
		// Foot Chelles 8v8
		} else if (mission.getId() == 3007) {
			choixDesJoueursAmis(8);
			
		// Foot Noisy 5v5
		} else if (mission.getId() == 3008) {
			choixDesJoueursAmis(5);
			
		// Foot Noisy 6v6
		} else if (mission.getId() == 3009) {
			choixDesJoueursAmis(6);
			
		} else {
			// TODO a supprimer
//			choixDesJoueursAmis(5);
////			choixDesJoueursAmis(8);
		}
		
		root.getChildren().addAll(boutonValider);
		return (scene);
	
	}

	private void choixDesAdversairesEcole() {
		List<PersonnageSecondaire> persosSecondaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getAdversairesEcole();
		cloneAdversaires(new ArrayList<>(persosSecondaire));
	}
	
	private void choixDesAdversairesTerrain() {
		List<PersonnageSecondaire> persosSecondaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getAdversairesTerrain();
		cloneAdversaires(new ArrayList<>(persosSecondaire));
	}
	
	private void choixDesAdversairesChelles() {
		List<PersonnageSecondaire> persosSecondaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getAdversairesChelles();
		cloneAdversaires(new ArrayList<>(persosSecondaire));
	}
	
	private void choixDesAdversairesNoisy() {
		List<PersonnageSecondaire> persosSecondaire = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getAdversairesNoisy();
		cloneAdversaires(new ArrayList<>(persosSecondaire));
	}

	private void cloneAdversaires(List<PersonnageSecondaire> persosSecondaire) {
		equipeAdverse.clear();
		for (Personnage joueurAmi : equipeAmi.keySet()) {
			int random = RandomManager.random(0, persosSecondaire.size()-1);
			PersonnageSecondaire persoSecondaire = persosSecondaire.get(random);
			persosSecondaire.remove(random);
			Poste poste = equipeAmi.get(joueurAmi);
			equipeAdverse.put(new PersonnageSecondaire(persoSecondaire.getPrenom(), persoSecondaire.getNom()), poste);
		}
	}
	
	private void choixDesJoueursAmis(int nombreDeJoueursMax) {
		
		persosDispo = new ArrayList<>();
		Groupe groupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();		
		List<PersonnagePrincipal> persosDejaPresentes = groupe.getPersosDejaPresentes();
		for (PersonnagePrincipal perso : persosDejaPresentes) {
			if (!perso.isMort()) {
				persosDispo.add(perso);
			}
		}
		
		// Mesage alerte "Il n'y a pas assez de joueurs disponibles" + retour a l'ecran mission (finDeMission(win=false))
		if (persosDispo.size() < nombreDeJoueursMax) {
			
			// TODO a reactiver pour empecher le match si le nombre de joueur est insuffisant
			JOptionPane.showMessageDialog(this, "Il n'y a pas assez de joueurs disponibles !", "Fin du match", 0, null);
			stopPartie(false);
			
			// TODO a supprimer (pour tester avant d'etre 5)
//			persosDispo.clear();
//			persosDispo.addAll(groupe.getPersos());
		}
		
		
		int x=100;
		for (PersonnagePrincipal perso : persosDispo) {
			ImageView view = new ImageView();
			Image image = new Image(perso.getImagePath().get(0), 180.0, 180.0, false, true);
			view.setImage(image);
			view.relocate(x, 200);
			Text text = new Text(perso.getPrenom());
			text.relocate(x, 450);
			
			view.setOnDragDetected(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
			    	
			    	imageDropped = view.getImage();
					
					Dragboard db = view.startDragAndDrop(TransferMode.ANY);
			        
			        /* Put an image on a dragboard */
			        ClipboardContent content = new ClipboardContent();
			        content.putImage(view.getImage());
			        content.putString(text.getText());
			        db.setContent(content);
			        
			        event.consume();
				}
				
			});
			
			view.setOnDragDone(new EventHandler<DragEvent>() {
			    

				public void handle(DragEvent event) {
			    	
			        /* the drag and drop gesture ended */
			        /* if the data was successfully moved, clear it */
			        if (event.getTransferMode() == TransferMode.MOVE) {
			        	view.setImage(imageEchangee);
			        	text.setText(textEchange);
			        }
			        
			        // bouton valider enable
			        boutonValider.setDisable(false);
			        for (ImageView imageView : imageViewsTarget) {
			        	if (imageView.getImage() == imageDefaut) {
			        		boutonValider.setDisable(true);			        		
			        	}
			        }

			        event.consume();
			    }
			});
			
		
			// Incremente x pour le decalage des images
			x = (int) (x + image.getWidth());

			root.getChildren().addAll(view, text);
		}
		
		x=100;
		imageViewsTarget = new ArrayList<>();
		postes = getPostesAPourvoir(nombreDeJoueursMax);
		
		textViewsTarget = new HashMap<>();
		imageDefaut = new Image("image/defaut/defautPersoInconnu.jpg", 180.0, 180.0, false, true);
		for (int i=0; i < nombreDeJoueursMax ; i++) {
			final int incremente = i;
			
			Label textTarget = new Label(" - ");
			textTarget.setMinWidth(imageDefaut.getWidth());
			textTarget.setAlignment(Pos.CENTER);
			textTarget.setFont(Constante.MARIO_FONT_JAVAFX);
			textTarget.setTextAlignment(TextAlignment.CENTER);
			textTarget.setTextFill(Color.BLACK);
			textTarget.relocate(x, 740);
			
			ImageView viewTarget = new ImageView();
			viewTarget.setImage(imageDefaut);
			viewTarget.relocate(x, 600);
			
			Label nomDuPoste = new Label(postes.get(i).name());
			nomDuPoste.setMinWidth(imageDefaut.getWidth());
			nomDuPoste.setAlignment(Pos.CENTER);
			nomDuPoste.setFont(Constante.MARIO_FONT_JAVAFX);
			nomDuPoste.setTextFill(Color.WHITE);
			nomDuPoste.relocate(x, 800);
			
			imageViewsTarget.add(viewTarget);
			textViewsTarget.put(postes.get(i), textTarget.getText());
			
			viewTarget.setOnDragOver(new EventHandler <DragEvent>() {

			    public void handle(DragEvent event) {
			        event.acceptTransferModes(TransferMode.ANY);
			        event.consume();
			    }
			});
			
			viewTarget.setOnDragDropped(new EventHandler<DragEvent>() {
			    public void handle(DragEvent event) {
			        /* data dropped */
			        /* if there is a string data on dragboard, read it and use it */
			        Dragboard db = event.getDragboard();
			        boolean success = false;
			        if (db.hasImage()) {
						imageEchangee = viewTarget.getImage();
						textEchange = textTarget.getText();
			        	viewTarget.setImage(imageDropped);
			        	textTarget.setText(db.getString());
			        	textViewsTarget.put(postes.get(incremente), textTarget.getText());
			        	success = true;
			        }
			        /* let the source know whether the string was successfully 
			         * transferred and used */
			        event.setDropCompleted(success);
			        
			        event.consume();
			     }
			});
			
			// Incremente x pour le decalage des images
			x = (int) (x + imageDefaut.getWidth());

			root.getChildren().addAll(viewTarget, textTarget, nomDuPoste);
			
		}
		
		labelInfoEquipe = new Label("Selectionne les joueurs de ton équipe");
		labelInfoEquipe.setFont(Constante.SIMPSON_FONT_JAVAFX);
		labelInfoEquipe.setTextFill(Color.WHITE);
		labelInfoEquipe.relocate(200, 150);
		
		// Bouton EXIT
		boutonValider = new Button("Valider l'Equipe");
		boutonValider.setFont(Constante.MARIO_FONT_JAVAFX);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int moitieEcran = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		boutonValider.relocate(moitieEcran - 200, 920);
		boutonValider.setDisable(true);
		boutonValider.setOnMouseClicked(new EventHandler<MouseEvent>() {

			private Button boutonValiderPersoPrincipal;
			private ImageView viewPersoSelected;
			private Label labelInfoJoueurPrincipal;
			

			@Override
			public void handle(MouseEvent event) {
				
				recupereLesJouersChoisis();
				
				if (mission.getId() == 3001) {
					choixDesAdversairesEcole();
					lieuDuTerrain = "ecole";
					
				// Foot terrain 5v5
				} else if (mission.getId() == 3002) {
					choixDesAdversairesTerrain();
					lieuDuTerrain = "terrain";
					
				// Foot terrain 6v6
				} else if (mission.getId() == 3003) {
					choixDesAdversairesTerrain();
					lieuDuTerrain = "terrain";
					
				// Foot terrain 7v7
				} else if (mission.getId() == 3004) {
					choixDesAdversairesTerrain();
					lieuDuTerrain = "terrain";
					
				// Foot terrain 8v8
				} else if (mission.getId() == 3005) {
					choixDesAdversairesTerrain();
					lieuDuTerrain = "terrain";
					
				// Foot Chelles 7v7
				} else if (mission.getId() == 3006) {
					choixDesAdversairesChelles();
					lieuDuTerrain = "chelles";
					
				// Foot Chelles 8v8
				} else if (mission.getId() == 3007) {
					choixDesAdversairesChelles();
					lieuDuTerrain = "chelles";
					
				// Foot Noisy 5v5
				} else if (mission.getId() == 3008) {
					choixDesAdversairesNoisy();
					lieuDuTerrain = "noisy";
					
				// Foot Noisy 6v6
				} else if (mission.getId() == 3009) {
					choixDesAdversairesNoisy();
					lieuDuTerrain = "noisy";
					
				} else {
					// TODO a supprimer
//					choixDesAdversairesNoisy();
//					lieuDuTerrain = "noisy";
//					choixDesAdversairesChelles();
//					lieuDuTerrain = "chelles";
//					choixDesAdversairesTerrain();
//					lieuDuTerrain = "terrain";			
//					choixDesAdversairesEcole();
//					lieuDuTerrain = "ecole";	
				}
				
				// Gestion facteur agrandissement en fonction du terrain
				if (lieuDuTerrain.equals("ecole")) {
					// TODO Facteur 5 (taille des persos / taille de la balle / precision) 
					facteurAgrandissement = 3;
					
				} else if (lieuDuTerrain.equals("terrain")) {
					// TODO Facteur 6 (taille des persos / taille de la balle / precision) 
					facteurAgrandissement = 3;
					
				} else if (lieuDuTerrain.equals("chelles")) {
					// TODO Facteur 1 (taille des persos / taille de la balle / precision) 
					facteurAgrandissement = 1;
					
				} else if (lieuDuTerrain.equals("noisy")) {
					// TODO Facteur 3 (taille des persos / taille de la balle / precision) 
					facteurAgrandissement = 2;
					
				} 
				
				choixDuPersoPrincipal();
			}

			private void recupereLesJouersChoisis() {
				for (Poste poste : postes) {
					String prenom = textViewsTarget.get(poste);
					PersonnagePrincipal perso = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getPersoByPrenom(prenom);	
					equipeAmi.put(perso, poste);
				}
			}

			private void choixDuPersoPrincipal() {
				Scene scene = createScenePersoPrincipal();
				panelCentre.removeAll();
				panelCentre.setScene(scene);
			}

			private Scene createScenePersoPrincipal() {
				root = new Group();
				Scene scene = new Scene(root, Color.BLACK);
				
				int x = 100;
				
				// Tri des persos par poste
				List<PersonnagePrincipal> persos = new ArrayList<>();
				List<Poste> postesAPourvoir = getPostesAPourvoir(nombreDeJoueursMax);
				for (Poste poste : postesAPourvoir) {
					Set<PersonnagePrincipal> keySet = equipeAmi.keySet();
					for (PersonnagePrincipal personnagePrincipal : keySet) {
						if (equipeAmi.get(personnagePrincipal) == poste) {
							persos.add(personnagePrincipal);
						}
					}
				}
				
				int j = 0;
				for (PersonnagePrincipal perso : persos) {
					Label nomDuPoste = new Label(postes.get(j).name());
					j++;
					nomDuPoste.setMinWidth(imageDefaut.getWidth());
					nomDuPoste.setAlignment(Pos.CENTER);
					nomDuPoste.setFont(Constante.MARIO_FONT_JAVAFX);
					nomDuPoste.setTextFill(Color.WHITE);
					nomDuPoste.relocate(x, 450);

					ImageView view = new ImageView();
					Image image = new Image(perso.getImagePath().get(0), 180.0, 180.0, false, true);
					view.setImage(image);
					view.relocate(x, 250);
					
					view.setOnMouseClicked(new EventHandler<Event>() {

						@Override
						public void handle(Event event) {
							joueurPrincipal = perso;
							viewPersoSelected.setImage(image);
							boutonValiderPersoPrincipal.setDisable(false);
							labelJoueurPrincipal.setText(perso.getPrenom());
						}
						
					});
					
					Text text = new Text(perso.getPrenom());
					text.relocate(x, 200);
					
					// Incremente x pour le decalage des images
					x = (int) (x + image.getWidth());
					root.getChildren().addAll(view, nomDuPoste);
				}
				
				viewPersoSelected = new ImageView();
				viewPersoSelected.relocate(moitieEcran - 90, 650);
				viewPersoSelected.setImage(imageDefaut);
				
				labelInfoJoueurPrincipal = new Label("Selectionne le joueur que tu veux controller");
				labelInfoJoueurPrincipal.setFont(Constante.SIMPSON_FONT_JAVAFX);
				labelInfoJoueurPrincipal.setTextFill(Color.WHITE);
				labelInfoJoueurPrincipal.relocate(200, 200);
				
				labelJoueurPrincipal = new Label("");
				labelJoueurPrincipal.setMinWidth(imageDefaut.getWidth());
				labelJoueurPrincipal.setAlignment(Pos.CENTER);
				labelJoueurPrincipal.setFont(Constante.MARIO_FONT_JAVAFX);
				labelJoueurPrincipal.setTextFill(Color.WHITE);
				labelJoueurPrincipal.relocate(moitieEcran - 90, 850);
				
				// Bouton EXIT
				boutonValiderPersoPrincipal = new Button("Valider");
				boutonValiderPersoPrincipal.setMinWidth(imageDefaut.getWidth());
				boutonValiderPersoPrincipal.setFont(Constante.MARIO_FONT_JAVAFX);
				boutonValiderPersoPrincipal.setDisable(true);
				boutonValiderPersoPrincipal.setAlignment(Pos.CENTER);
				boutonValiderPersoPrincipal.relocate(moitieEcran - 90, 900);
				boutonValiderPersoPrincipal.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						reinitialisation();
						lancePartie();

//						// Musique du match
//						MusiqueManager.stopAll();
//						List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("musique/foot", 270000);
//						MusiqueManager.playMusiquesRandom(musiques);	
					}
					
				});
				
				root.getChildren().addAll(labelInfoJoueurPrincipal, viewPersoSelected, labelJoueurPrincipal, boutonValiderPersoPrincipal);
				return (scene);
			}
		});
		root.getChildren().addAll(labelInfoEquipe);
	}

	private List<Poste> getPostesAPourvoir(int nombreDeJoueursMax) {
		
		List<Poste> postes = new ArrayList<>();
		if (nombreDeJoueursMax == 5) {
			postes.add(Poste.G);
			postes.add(Poste.DCG);
			postes.add(Poste.DCD);
			postes.add(Poste.BG);
			postes.add(Poste.BD);

		} else if (nombreDeJoueursMax == 6) {
			postes.add(Poste.G);
			postes.add(Poste.DCG);
			postes.add(Poste.DCD);
			postes.add(Poste.MC);
			postes.add(Poste.BG);
			postes.add(Poste.BD);
			
		} else if (nombreDeJoueursMax == 7) {
			postes.add(Poste.G);
			postes.add(Poste.DCG);
			postes.add(Poste.DCD);
			postes.add(Poste.MCG);
			postes.add(Poste.MCD);
			postes.add(Poste.BG);
			postes.add(Poste.BD);
			
		} else if (nombreDeJoueursMax == 8) {
			postes.add(Poste.G);
			postes.add(Poste.DCG);
			postes.add(Poste.DCD);
			postes.add(Poste.MG);
			postes.add(Poste.MC);
			postes.add(Poste.MD);
			postes.add(Poste.BG);
			postes.add(Poste.BD);
		} 
		
		return postes;
	}

	private Scene createScene() {
		
		root = new Group();
		Scene scene = new Scene(root, Color.BLACK);
		
		genereLeTerrain();
		
//		labelVelocityX = new Label("Velocity X : ");
//    	labelVelocityX.relocate(100, 0);
//		labelVelocityY = new Label("Velocity Y : ");
//    	labelVelocityY.relocate(100, 50);
//		labelVelocityZ = new Label("Velocity Z : ");
//    	labelVelocityZ.relocate(100, 100);
//    	
//		labelX = new Label("Position X : ");
//		labelX.relocate(300, 0);
//		labelY = new Label("Position Y : ");
//		labelY.relocate(300, 50);
//		labelZ = new Label("Position Z : ");
//		labelZ.relocate(300, 100);
//		
//		labelSourisX = new Label("X : " + sourisX);
//		labelSourisX.relocate(500, 0);
//		labelSourisY = new Label("Y : " + sourisY);
//		labelSourisY.relocate(500, 50);
//		
//		labelPorteur = new Label("Porteur : " + sourisX);
//		labelPorteur.relocate(700, 0);
//		labelTireur = new Label("Tireur : " + sourisY);
//		labelTireur.relocate(700, 50);
//		
//		labelBallonX = new Label("Position ballon x : ");
//		labelBallonX.relocate(900, 0);
//		labelBallonY = new Label("Position ballon Y : ");
//		labelBallonY.relocate(900, 50);
//
//		labelBallonVelociteX = new Label("Velocite ballon x : ");
//		labelBallonVelociteX.relocate(1100, 0);
//		labelBallonVelociteY = new Label("Velocite ballon Y : ");
//		labelBallonVelociteY.relocate(1100, 50);
//		
//		labelCibleX = new Label("Position cible x : ");
//		labelCibleX.relocate(1300, 0);
//		labelCibleY = new Label("Position cible Y : ");
//		labelCibleY.relocate(1300, 50);
//		
//		labelSpeed = new Label("Current Speed : ");
//		labelSpeed.relocate(1450, 0);
		
		labelButsAllies = new Label("Bleus : 0");
		labelButsAllies.setMinHeight(50);
		labelButsAllies.setMinWidth(200);
		labelButsAllies.setFont(Constante.MARIO_FONT_JAVAFX);
		labelButsAllies.setTextFill(Color.BLUE);;
		labelButsAllies.setBorder(new Border(new BorderStroke(Color.BLUE, 
	            BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));
		labelButsAllies.relocate(Constante.COORD_X_TERRAIN, Constante.COORD_Y_TERRAIN - (labelButsAllies.getMinHeight()*3)/2);
		labelButsAllies.setAlignment(Pos.CENTER);
		
		labelButsAdverses = new Label("Rouges : 0");
		labelButsAdverses.setMinHeight(50);
		labelButsAdverses.setMinWidth(200);
		labelButsAdverses.setFont(Constante.MARIO_FONT_JAVAFX);
		labelButsAdverses.setTextFill(Color.RED);;
		labelButsAdverses.setBorder(new Border(new BorderStroke(Color.RED, 
	            BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(3))));
		labelButsAdverses.relocate(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - labelButsAdverses.getMinWidth(), Constante.COORD_Y_TERRAIN - (labelButsAdverses.getMinHeight()*3)/2);
		labelButsAdverses.setAlignment(Pos.CENTER);

//		labelJoueurAuto = new Label("Joueur Auto : " + joueurAutomatique);
//		labelJoueurAuto.relocate(1700, 0);
		
		labelTimer = new Label("" + Constante.DUREE_DU_MATCH_EN_MINUTE + ":00");
		labelTimer.setMinHeight(50);
		labelTimer.setMinWidth(100);
		labelTimer.setFont(Constante.MARIO_FONT_JAVAFX);
		labelTimer.setTextFill(Color.YELLOW);
		labelTimer.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(3))));
		labelTimer.relocate(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2 - labelTimer.getMinWidth()/2, Constante.COORD_Y_TERRAIN - (labelTimer.getMinHeight()*3)/2);
		labelTimer.setAlignment(Pos.CENTER);
		
		labelNomPorteur = new Label();
		labelNomPorteur.setMinHeight(50);
		labelNomPorteur.setMinWidth(100);
		labelNomPorteur.setTextFill(Color.GREY);
		labelNomPorteur.setAlignment(Pos.CENTER);

		labelNomButeur = new Label();
		labelNomButeur.setMinHeight(100);
		labelNomButeur.setMinWidth(800);
		labelNomButeur.setFont(Constante.MARIO_FONT_JAVAFX);
		labelNomButeur.setTextFill(Color.WHITE);
		labelNomButeur.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(5))));
		labelNomButeur.relocate(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2 - labelNomButeur.getMinWidth()/2, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - labelNomButeur.getMinHeight()/2);
		labelNomButeur.setAlignment(Pos.CENTER);
		labelNomButeur.setVisible(false);

		
		root.getChildren().addAll(
//				labelVelocityX,
//				labelVelocityY,
//				labelVelocityZ,
//				labelX,
//				labelY,
//				labelZ,
//				labelSourisX,
//				labelSourisY,
//				labelPorteur,
//				labelTireur,
//				labelBallonX,
//				labelBallonY,
//				labelBallonVelociteX,
//				labelBallonVelociteY,
//				labelCibleX,
//				labelCibleY,
//				labelSpeed,
//				labelJoueurAuto,
				labelButsAllies,
				labelButsAdverses,
				labelTimer,
				labelNomPorteur,
				labelNomButeur);
		
		logging = new TextArea();
        logging.setMaxWidth(500);
        logging.setMaxHeight(Constante.LARGEUR_TERRAIN);
        logging.setEditable(false);
//        logging.setDisable(true);
        
        logging.relocate(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN + (2 *(Constante.LARGEUR_TERRAIN/16)) , Constante.COORD_Y_TERRAIN);
        root.getChildren().add(logging);
		
		ballon = new Ballon(javafx.scene.paint.Color.WHITE, porteur.getLocation(), logging, facteurAgrandissement);
		ballonLibre = false;
		
        final long dureeDuMatch = Constante.DUREE_DU_MATCH_EN_MINUTE * 60 * 1000000000l ; // Duree du match en nanoseconde

        timer = new AnimationTimer() { // On boucle 50 fois chaque seconde

        	private long momentButAllie = 0;
        	private long momentButAdverse = 0;
        	

			@Override
			public void handle(long now) {
				
				affichePrenomPorteur();
				
				// Gestion du timer du match et de la fin du match (win si plus de buts a la fin du temps)
				if (finDumatch == 0) {
					finDumatch = now + dureeDuMatch;
				}
				
				if (finDumatch < now) {
					if (butsAllies > butsAdverses) {
						stopPartie(true);
					} else {
						stopPartie(false);
					}
				}
				
				// Gestion joueur automatique/manuel
				long dateCourante = System.currentTimeMillis();
				if (dateCourante - dateDerniereAction > Constante.DELAI_AVANT_INACTIVITE) {
					joueurAutomatique = true;
					joueur.getCircle().setStroke(Color.YELLOW);
				}
				
				// Le joueur principal suit la souris
				if (!joueurAutomatique) {
					joueur.step(mouse);
				} 
				
				// Si le ballon est libre
				if (ballonLibre) {
					
					// Il continue vers sa location cible
					ballon.step();
					
					// Si un joueur l'intercepte
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						gestionInterceptionBallon(ennemi);
					}
					for (JoueurPrincipal ami : joueursAmis) {
						gestionInterceptionBallon(ami);
					} 
					
					// Si le joueur l'intercepte
					gestionInterceptionBallon(joueur);
					
					// Les joueurs (allies et ennemis) les plus proche du ballon et de la position cible vont vers la balle
					boolean joueurAmi = true;
					JoueurPrincipal joueurAllieProcheBallon = trouveJoueurProche(joueurAmi, ballon.getLocation());
					JoueurPrincipal joueurAllieProcheCible = trouveJoueurProche(joueurAmi, ballon.getBallonPositionCible());
					JoueurPrincipal joueurEnnemiProcheBallon = trouveJoueurProche(!joueurAmi, ballon.getLocation());
					JoueurPrincipal joueurEnnemiProcheCible = trouveJoueurProche(!joueurAmi, ballon.getBallonPositionCible());
					
					// Le reste se replace en fonction des adversaires
					
					// Les adversaires se remettent en place
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						
						if (!ennemi.vientDeClasher()) {
						
							// Le joueur le plus proche du ballon va vers le ballon
							if (ennemi == joueurEnnemiProcheBallon) {
								ennemi.step(ballon.getLocation());
								
							// Le joueur le plus proche de la position cible du ballon va vers la position cible
							} else if (ennemi == joueurEnnemiProcheCible) {
								ennemi.step(ballon.getBallonPositionCible());		
								
							// Le reste retourne a sa position de depart
							} else {
								ennemi.step(ennemi.getPositionDepart());
								
							}
						
						} 
						ennemi.checkBoundaries();
						ennemi.display();
					}
					
					// Les joueurs amis se remettent en place
					for (JoueurPrincipal ami : joueursAmis) {
						
						if (!ami.vientDeClasher()) {
						
							// Le joueur le plus proche du ballon va vers le ballon
							if (ami == joueurAllieProcheBallon) {
								ami.step(ballon.getLocation());
	
							// Le joueur le plus proche de la position cible du ballon va vers la position cible
							} else if (ami == joueurAllieProcheCible) {
								ami.step(ballon.getBallonPositionCible());		
	
							// Le reste retourne a sa position de depart
							} else {
								ami.step(ami.getPositionDepart());
							}
							
						} 
						ami.checkBoundaries();
						ami.display();
					} 
					
					// Le joueur principal se remet en place
					if (joueurAutomatique) {
						
						if (!joueur.vientDeClasher()) {
						
							if (joueur == joueurAllieProcheBallon) {
								joueur.step(ballon.getLocation());
								
							} else if (joueur == joueurAllieProcheCible) {
								joueur.step(ballon.getBallonPositionCible());		
								
							} else {
								joueur.step(joueur.getPositionDepart());
								
							}
							
						} 
						joueur.checkBoundaries();
						joueur.display();
					} 

					
				// Si le ballon n'est pas libre (si un joueur a le ballon dans les pieds)
				} else {
					
					// Le porteur garde le ballon
					ballon.setLocation(new PVector(porteur.getLocation().x, porteur.getLocation().y, 0));
					
					// Si un joueur allie a le ballon
					if (porteur.isAllie()) {
						
						// Si c'est le joueur principal
						if (porteur == joueur) {
							if (joueurAutomatique) {
								gestionTirOuPasse();
							}
							
						// Si c'est un joueur allie autre que le joueur principal
						} else {
							gestionTirOuPasse();
						}

						// Les adversaires retournent en defense
						for (JoueurPrincipal ennemi : joueursEnnemis) {
							// Gestion positionnement defense devant l'attaquant (ou entre les buts et l'attaquant) en fonction des postes et proche du ballon
							// Si assez proche de l'attaquant => tente de recuper le ballon 
							ennemi.step(calculePositionDefense(ennemi));
							ennemi.checkBoundaries();
							ennemi.display();
						}
						
						// Les joueurs amis vont en attaque
						for (JoueurPrincipal ami : joueursAmis) {
							ami.step(calculePositionAttaque(ami));
							ami.checkBoundaries();
							ami.display();
						} 
						if (joueurAutomatique){
							joueur.step(calculePositionAttaque(joueur));
						}
						
					// Si un joueur ennemi a le ballon
					} else {
						
						gestionTirOuPasse();

						// Les adversaires vont en attaque
						for (JoueurPrincipal ennemi : joueursEnnemis) {
							ennemi.step(calculePositionAttaque(ennemi));
							ennemi.checkBoundaries();
							ennemi.display();
						}
						
						// Les joueurs amis retournent en defense
						for (JoueurPrincipal ami : joueursAmis) {
							ami.step(calculePositionDefense(ami));
							ami.checkBoundaries();
							ami.display();
						} 
						if (joueurAutomatique){
							joueur.step(calculePositionDefense(joueur));
						}

					}
					
					// Gestion des clashs
					// TODO gestion plus fine de l'intersection des clash (bonus zone interception + joueur doit intersecter le centre du ballon)
					
					// Si un joueur allie a le ballon
					if (porteur != null && porteur.isAllie()) {
						
						for (JoueurPrincipal ennemi : joueursEnnemis) {
							if ((	(ennemi.getLocation().x - ennemi.getRadius() - ennemi.getBonusZoneInterception() < ballon.getLocation().x && ennemi.getLocation().x + ennemi.getRadius() + ennemi.getBonusZoneInterception() > ballon.getLocation().x)
									&& 	(ennemi.getLocation().y - ennemi.getRadius() - ennemi.getBonusZoneInterception() < ballon.getLocation().y && ennemi.getLocation().y + ennemi.getRadius() + ennemi.getBonusZoneInterception() > ballon.getLocation().y))
									&& 	(ennemi.vientDeTirer() == false)) {
								clashPorteurVS(ennemi);
							}
						}
						
					// Si un joueur ennemi a le ballon
					} else if (porteur != null && !porteur.isAllie()) {
						
						for (JoueurPrincipal ami : joueursAmis) {
							if ((	(ami.getLocation().x - ami.getRadius() - ami.getBonusZoneInterception() < ballon.getLocation().x && ami.getLocation().x + ami.getRadius() + ami.getBonusZoneInterception() > ballon.getLocation().x)
									&& 	(ami.getLocation().y - ami.getRadius() - ami.getBonusZoneInterception() < ballon.getLocation().y && ami.getLocation().y + ami.getRadius() + ami.getBonusZoneInterception() > ballon.getLocation().y))
									&& 	(ami.vientDeTirer() == false)) {
								clashPorteurVS(ami);
							}
						}
						
						if ((	(joueur.getLocation().x - joueur.getRadius() - joueur.getBonusZoneInterception() < ballon.getLocation().x && joueur.getLocation().x + joueur.getRadius() + joueur.getBonusZoneInterception() > ballon.getLocation().x)
								&& 	(joueur.getLocation().y - joueur.getRadius() - joueur.getBonusZoneInterception() < ballon.getLocation().y && joueur.getLocation().y + joueur.getRadius() + joueur.getBonusZoneInterception() > ballon.getLocation().y))
								&& 	(joueur.vientDeTirer() == false)) {
							clashPorteurVS(joueur);
						}
						
					}
					
				}
				
				joueur.checkBoundaries();
				joueur.display();
				
				int but = ballon.checkBoundaries();
				ballon.display();
				
				// But allie
				if (but == 1) {
					
					// timer attente apres le but
					if (momentButAllie == 0) {
						
						// Son de but
						List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/but", 200000);
						MusiqueManager.playSonRandom(musiques);	
						
						momentButAllie = now + Constante.DELAI_APRES_BUT;
						butsAllies = butsAllies + 1;
						labelButsAllies.setText("Bleus : " + butsAllies);
						labelNomButeur.setTextFill(Color.BLUE);
						labelNomButeur.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(5))));
						if (tireur != null) {
							labelNomButeur.setText("BUT de " + tireur.getPersonnage().getPrenom() + " " + tireur.getPersonnage().getNom() + " !!!");
						} else {
							labelNomButeur.setText("BUT !!!");
						}
						labelNomButeur.setVisible(true);
						logging.appendText(labelTimer.getText() + " - " + " (BUT) " + tireur.getPersonnage().getPrenom() + " a marqué un but" + "\n" ); 
					}
					
				// But adverse
				} else if (but == 2) {
					
					// timer attente apres le but
					if (momentButAdverse == 0) {
						
						// Son de but
						List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/but", 199000);
						MusiqueManager.playSonRandom(musiques);	

						
						momentButAdverse = now + Constante.DELAI_APRES_BUT;
						butsAdverses = butsAdverses + 1;
						labelButsAdverses.setText("Rouges : " + butsAdverses);
						labelNomButeur.setTextFill(Color.RED);
						labelNomButeur.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(30), new BorderWidths(5))));
						if (tireur != null) {
							labelNomButeur.setText("BUT de " + tireur.getPersonnage().getPrenom() + " " + tireur.getPersonnage().getNom() + " !!!");
						} else {
							labelNomButeur.setText("BUT !!!");
						}
						labelNomButeur.setVisible(true);
						logging.appendText(labelTimer.getText() + " - " + " (BUT) " + tireur.getPersonnage().getPrenom() + " a marqué un but" + "\n" ); 
					}
				}
				
				// Remise en jeu apres un but
				boolean pourLesAllies = true;
				if (momentButAllie != 0 && momentButAllie < now) {
					momentButAllie = 0;
					coupDEnvoi(!pourLesAllies);
					
				} else if (momentButAllie != 0) {
					// Scintillement label nom buteur
					if ((momentButAllie - now) % (Constante.DELAI_APRES_BUT/4) %16 == 0) {
						if (labelNomButeur.getTextFill() == Color.WHITE) {
							labelNomButeur.setTextFill(Color.BLUE);
						} else {
							labelNomButeur.setTextFill(Color.WHITE);
						}
					}
				}
				
				if (momentButAdverse != 0 && momentButAdverse < now) {
					momentButAdverse = 0;
					coupDEnvoi(pourLesAllies);
					
				} else if (momentButAdverse != 0) {
					// Scintillement label nom buteur
					if ((momentButAdverse - now) % (Constante.DELAI_APRES_BUT/4) %16 == 0) {
						if (labelNomButeur.getTextFill() == Color.WHITE) {
							labelNomButeur.setTextFill(Color.RED);
						} else {
							labelNomButeur.setTextFill(Color.WHITE);
						}
					}
				}
				
				// Maj des labels infos
//				labelBallonX.setText("Position ballon x : " + ballon.getLocation().x);
//				labelBallonY.setText("Position ballon Y : " + ballon.getLocation().y);
//
//				labelBallonVelociteX.setText("Velocite ballon x : " + ballon.getVelocity().x);
//				labelBallonVelociteY.setText("Velocite ballon Y : " + ballon.getVelocity().y);
//				
//				labelCibleX.setText("Position cible x : " + ballon.getBallonPositionCible().x);
//				labelCibleY.setText("Position cible Y : " + ballon.getBallonPositionCible().y);
//				
//				labelX.setText("Position X : " + joueur.getLocation().x);
//				labelY.setText("Position Y : " + joueur.getLocation().y);
//				labelZ.setText("Position Z : " + joueur.getLocation().z);
//				
//				labelVelocityX.setText("Velocity X : " + joueur.getVelocity().x);
//				labelVelocityY.setText("Velocity Y : " + joueur.getVelocity().y);
//				labelVelocityZ.setText("Velocity Z : " + joueur.getVelocity().z);
//				
//				labelSpeed.setText("Current Speed : " + ballon.getTopspeed());
//				
//				labelJoueurAuto.setText("Joueur Auto : " + joueurAutomatique);

				// Affichage temps restant du match
				long tempRestant = (finDumatch - now) /1000000000l;
				int minutes = (int) (tempRestant / 60);
				String secondes = String.valueOf((int) (tempRestant % 60));
				if ((int) (tempRestant % 60) < 10) {
					secondes = "0" + secondes;
				}
				labelTimer.setText(minutes + ":" + secondes);
				
			} // Fin handle() Timer

			private void gestionTirOuPasse() {
				if (!porteur.vientDIntercepter()) {
					
					// Si il est dans la zone de tir du terrain adverse
					if (porteur.estDansLaZoneDeTir()  && !voitUnDefenseurDevantLeBut()) {
						PVector cible = genereCibleDansBut();
						tir(cible.x, cible.y);

					} else {
						// 3 choix (passe devant (plus proche des buts > devant le joueur > plus proche du joueur) / passe aleatoire / avance)
						choixDuTypeDePasse();
					}
				}
			}

			private void choixDuTypeDePasse() {
				int inte = porteur.getPersonnage().getCompetence().getIntelligence();
				int tech = porteur.getPersonnage().getCompetence().getTechnique();
				int luck = porteur.getPersonnage().getCompetence().getLuck();
				int exploit = porteur.getPersonnage().getCompetence().getExploit();
				int moyenne = inte + tech + luck + exploit;
				moyenne = moyenne/4;
				int random = RandomManager.random(0, 100);
				
				if (moyenne > random) {
					// meilleur cible
					int random0_100 = RandomManager.random0_100();
					if (random0_100 < 33) {
						// plus proche des buts
						JoueurPrincipal cible = trouveJoueurPlusProcheDesButsAdverses();
						if (cible != null) {
							passe(cible.getLocation().x, cible.getLocation().y);
						}
						
					} else if (random0_100 > 66) {
						// devant le joueur
						JoueurPrincipal cible = trouveJoueurDevantLePorteur();
						if (cible != null) {
							passe(cible.getLocation().x, cible.getLocation().y);
						}
						
					} else {
						// plus proche du joueur
						JoueurPrincipal cible = trouveJoueurPlusProcheDuPorteur();
						if (cible != null) {
							passe(cible.getLocation().x, cible.getLocation().y);

						}
						
					}
					
				} else {
					int random100 = RandomManager.random0_100();
					if (random100 < 10) {
						// Passe aleatoire
						JoueurPrincipal cible = trouveJoueurCibleAleatoire();
						passe(cible.getLocation().x, cible.getLocation().y);

					} else {
						// Ne fait rien (avance)
						
					}
				}
			}
			
			private JoueurPrincipal trouveJoueurPlusProcheDesButsAdverses() {
				JoueurPrincipal cible = null;
				
				if (porteur.isAllie()) {
					double meilleurLocation = 0.0;
					for (JoueurPrincipal ami : joueursAmis) {
						if (ami != porteur && ami.getPoste() != Poste.G) {
							double locationX = ami.getLocation().x;
							if (meilleurLocation < locationX) {
								meilleurLocation = locationX;
								cible = ami;
							}
						}
					}
					
					if (joueur != porteur && joueur.getPoste() != Poste.G) {
						double locationX = joueur.getLocation().x;
						if (meilleurLocation < locationX) {
							meilleurLocation = locationX;
							cible = joueur;
						}
					}
					
				} else {
					double meilleurLocation = 10000.0;
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						if (ennemi != porteur && ennemi.getPoste() != Poste.G) {
							double locationX = ennemi.getLocation().x;
							if (meilleurLocation > locationX) {
								meilleurLocation = locationX;
								cible = ennemi;
							}
						}
					}
				}
				
				return cible;
			}

			private JoueurPrincipal trouveJoueurDevantLePorteur() {
				JoueurPrincipal cible = null;
				
				if (porteur.isAllie()) {
					for (JoueurPrincipal ami : joueursAmis) {
						if (ami != porteur && ami.getPoste() != Poste.G) {
							double locationX = ami.getLocation().x;
							if (porteur.getLocation().x < locationX) {
								cible = ami;
							}
						}
					}
					
					if (joueur != porteur && joueur.getPoste() != Poste.G) {
						double locationX = joueur.getLocation().x;
						if (porteur.getLocation().x < locationX) {
							cible = joueur;
						}
					}
					
				} else {
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						if (ennemi != porteur && ennemi.getPoste() != Poste.G) {
							double locationX = ennemi.getLocation().x;
							if (porteur.getLocation().x > locationX) {
								cible = ennemi;
							}
						}
					}
				}
				
				return cible;
			}

			private JoueurPrincipal trouveJoueurPlusProcheDuPorteur() {
				JoueurPrincipal cible = null;
				
				if (porteur.isAllie()) {
					double distanceFinal = 10000.0;
					for (JoueurPrincipal ami : joueursAmis) {
						if (ami != porteur && ami.getPoste() != Poste.G) {
							double distance = retourneDistanceEntre(porteur.getLocation(), ami.getLocation());
							if (distance < distanceFinal) {
								distanceFinal = distance;
								cible = ami;
							}
						}
					}
					
					if (joueur != porteur && joueur.getPoste() != Poste.G) {
						double distance = retourneDistanceEntre(porteur.getLocation(), joueur.getLocation());
						if (distance < distanceFinal) {
							distanceFinal = distance;
							cible = joueur;
						}
					}
					
				} else {
					double distanceFinal = 10000.0;
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						if (ennemi != porteur && ennemi.getPoste() != Poste.G) {
							double distance = retourneDistanceEntre(porteur.getLocation(), ennemi.getLocation());
							if (distance < distanceFinal) {
								distanceFinal = distance;
								cible = ennemi;
							}
						}
					}
				}
				
				return cible;
			}

			public boolean voitUnDefenseurDevantLeBut() {
				
				boolean intersecteHaut = false;
				boolean intersecteBas = false;
				
				// ligne avec le haut du but
				// ligne avec le bas du but
				if (porteur.isAllie()) {
					
					Line ligneHaute = new Line();
					ligneHaute.setStartX(porteur.getLocation().x);
					ligneHaute.setStartY(porteur.getLocation().y);
					ligneHaute.setEndX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN);
					ligneHaute.setEndY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
					
					Line ligneBasse = new Line();
					ligneBasse.setStartX(porteur.getLocation().x);
					ligneBasse.setStartY(porteur.getLocation().y);
					ligneBasse.setEndX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN);
					ligneBasse.setEndY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + Constante.LARGEUR_TERRAIN/8);

					for (JoueurPrincipal ennemi : joueursEnnemis) {
						if (ennemi.getPoste() != Poste.G) {
							if (ligneHaute.intersects(ennemi.getCircle().getBoundsInLocal())) {
								intersecteHaut = true;
							}
							if (ligneBasse.intersects(ennemi.getCircle().getBoundsInLocal())) {
								intersecteBas = true;
							}
						}
					}
					
				} else {
					
					// Si le porteur est un adversaire
					Line ligneHaute = new Line();
					ligneHaute.setStartX(porteur.getLocation().x);
					ligneHaute.setStartY(porteur.getLocation().y);
					ligneHaute.setEndX(Constante.COORD_X_TERRAIN);
					ligneHaute.setEndY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
					
					Line ligneBasse = new Line();
					ligneBasse.setStartX(porteur.getLocation().x);
					ligneBasse.setStartY(porteur.getLocation().y);
					ligneBasse.setEndX(Constante.COORD_X_TERRAIN);
					ligneBasse.setEndY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + Constante.LARGEUR_TERRAIN/8);

					for (JoueurPrincipal ami : joueursAmis) {
						if (ami.getPoste() != Poste.G) {
							if (ligneHaute.intersects(ami.getCircle().getBoundsInLocal())) {
								intersecteHaut = true;
							}
							if (ligneBasse.intersects(ami.getCircle().getBoundsInLocal())) {
								intersecteBas = true;
							}
						}
					}
				}
				
				return  intersecteHaut && intersecteBas;
			}

			private PVector calculePositionAttaque(JoueurPrincipal attaquant) {
				int signeX = RandomManager.random(0, 1);
				if (signeX == 0) {
					signeX = -1; 
				}
				int signeY = RandomManager.random(0, 1);
				if (signeY == 0) {
					signeY = -1; 
				}
				double x = attaquant.getPositionAttaque().x + RandomManager.random(100, 200) * signeX;
				double y = attaquant.getPositionAttaque().y + RandomManager.random(50, 100) * signeY;
				PVector positionAttaqueRandom = new PVector(x, y, 0);
				
				// Le defenseur reste en place pendant un moment
				if (attaquant.vientDeClasher()) {
					positionAttaqueRandom = new PVector(attaquant.getLocation().x, attaquant.getLocation().y, 0);
				}
				
				if (attaquant == porteur) {
					if(!aDesDefenseursDevantLui()) {
						
						int porteurY = (int)Math.round(porteur.getLocation().y);
						double locationY;
						if (porteurY < Constante.LARGEUR_TERRAIN/16) {
							locationY = RandomManager.random(porteurY, Constante.LARGEUR_TERRAIN/16);
						} else {
							locationY = RandomManager.random(Constante.LARGEUR_TERRAIN/16, porteurY);								
						}

						if (porteur.isAllie()) {
							positionAttaqueRandom = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN, locationY , 0); 
						} else {
							positionAttaqueRandom = new PVector(Constante.COORD_X_TERRAIN, locationY , 0); 
						}
					}
				}
				
				return positionAttaqueRandom;
			}

			private boolean aDesDefenseursDevantLui() {
				boolean aDesDefenseursDevantLui = false;
				if (porteur.isAllie()) {
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						if(ennemi.getPoste() != Poste.G) {
							if (ennemi.getLocation().x > porteur.getLocation().x) {
								aDesDefenseursDevantLui = true;
							}
						}
					}
				} else {
					for (JoueurPrincipal ami : joueursAmis) {
						if(ami.getPoste() != Poste.G) {
							if (ami.getLocation().x < porteur.getLocation().x) {
								aDesDefenseursDevantLui = true;
							}
						}
					}
				}
				return aDesDefenseursDevantLui;
			}

			private PVector calculePositionDefense(JoueurPrincipal defenseur) {
				PVector positionDefense = defenseur.getPositionDefense();
				
				if (defenseur.getPoste() == Poste.G) {
					// TODO s'aligner entre le joueur et le but sur l'axe Y
					positionDefense = defenseur.getPositionDefense();
					
				} else if (defenseur.getPoste() == Poste.AG) {
					// pas utilisé
					
				} else if (defenseur.getPoste() == Poste.DCG) {
					// Bloque le BD
					positionDefense = defendSur(Poste.BD, defenseur);

				} else if (defenseur.getPoste() == Poste.DCD) {
					// Bloque le BG
					positionDefense = defendSur(Poste.BG, defenseur);
					
				} else if (defenseur.getPoste() == Poste.AD) {
					// pas utilisé	
					
				} else if (defenseur.getPoste() == Poste.MG) {
					// Bloque le MD
					positionDefense = defendSur(Poste.MD, defenseur);

				} else if (defenseur.getPoste() == Poste.MCG) {
					// Bloque le MCD
					positionDefense = defendSur(Poste.MCD, defenseur);
					
				} else if (defenseur.getPoste() == Poste.MC) {
					// Bloque le MC
					positionDefense = defendSur(Poste.MC, defenseur);

				} else if (defenseur.getPoste() == Poste.MCD) {
					// Bloque le MCG
					positionDefense = defendSur(Poste.MCG, defenseur);

				} else if (defenseur.getPoste() == Poste.MD) {
					// Bloque le MG
					positionDefense = defendSur(Poste.MG, defenseur);

				} else if (defenseur.getPoste() == Poste.BG) {
					// Bloque le DCD
					positionDefense = defendSur(Poste.DCD, defenseur);

				} else if (defenseur.getPoste() == Poste.BD) {
					// Bloque le DCG
					positionDefense = defendSur(Poste.DCG, defenseur);
					
				}
				
				// Le defenseur essaie de reprendre la balle
				if (porteur != null) {
					double distance = retourneDistanceEntre(defenseur.getLocation(), porteur.getLocation());
					if (distance < Constante.DISTANCE_RECUPERATION_DEFENSE) {
						positionDefense = new PVector(porteur.getLocation().x, porteur.getLocation().y ,0);
					}
				}

				// Le defenseur reste en place pendant un moment
				if (defenseur.vientDeClasher()) {
					positionDefense = new PVector(defenseur.getLocation().x, defenseur.getLocation().y, 0);
				}
				
				return positionDefense;
			}

			private PVector defendSur(Poste poste, JoueurPrincipal defenseur) {
				
				PVector position = null;
				if (defenseur.isAllie()) {
					for (JoueurPrincipal ennemi : joueursEnnemis) {
						if (ennemi.getPoste() == poste) {
							position = new PVector(ennemi.getLocation().x - Constante.DISTANCE_POSITION_DEFENSE, ennemi.getLocation().y, 0);
						}
					}
				} else {
					for (JoueurPrincipal ami : joueursAmis) {
						if (ami.getPoste() == poste) {
							position = new PVector(ami.getLocation().x + Constante.DISTANCE_POSITION_DEFENSE, ami.getLocation().y, 0);
						}
					}
					if (joueur.getPoste() == poste) {
						position = new PVector(joueur.getLocation().x + Constante.DISTANCE_POSITION_DEFENSE, joueur.getLocation().y, 0);
					}
				}
				return position;
			}

			private PVector genereCibleDansBut() {
				PVector cible = null;
				
				if (porteur.isAllie()) {
					int randomX = RandomManager.random(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN, Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN + Constante.LARGEUR_TERRAIN/16);
					int randomY = RandomManager.random(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + Constante.LARGEUR_TERRAIN/8);
					cible = new PVector(randomX, randomY, 0);
					
				} else {
					int randomX = RandomManager.random(Constante.COORD_X_TERRAIN, Constante.COORD_X_TERRAIN + Constante.LARGEUR_TERRAIN/16);
					int randomY = RandomManager.random(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + Constante.LARGEUR_TERRAIN/8);
					cible = new PVector(randomX, randomY, 0);
				}
				
				return cible;
			}

			private void gestionInterceptionBallon(JoueurPrincipal intercepteur) {
				
				if ((	(intercepteur.getLocation().x - intercepteur.getRadius() - intercepteur.getBonusZoneInterception() < ballon.getLocation().x && intercepteur.getLocation().x + intercepteur.getRadius() + intercepteur.getBonusZoneInterception() > ballon.getLocation().x)
					&& 	(intercepteur.getLocation().y - intercepteur.getRadius() - intercepteur.getBonusZoneInterception() < ballon.getLocation().y && intercepteur.getLocation().y + intercepteur.getRadius() + intercepteur.getBonusZoneInterception() > ballon.getLocation().y))
					&& 	(intercepteur.vientDeTirer() == false)) {

					// Si l'intercepteur peut intercepter
					if (!intercepteur.vientDIntercepter() && !intercepteur.vientDeClasher()) {
						
						logging.appendText(labelTimer.getText() + " - " + "(INTERCEPTION) : tentative d'interception de " + intercepteur.getPersonnage().getPrenom() + "\n");

						// Le devieur ne pourra plus devier ou intercepter avant un laps de temps
						intercepteur.setDateDerniereInterception(System.currentTimeMillis());
						intercepteur.setVientDIntercepter(true);
						
						// Si le ballon est tres rapide
						if (ballon.getTopspeed() > Constante.VITESSE_MAX_BALLON - (Constante.VITESSE_MAX_BALLON/5)) {
							
							// Gestion specifique du gardien (peut controller les tirs rapides)
							if (intercepteur.getPoste() == Poste.G) {
								int chance = calculeChanceDeControler(intercepteur);
								int randomControle = RandomManager.random0_100();
								if (chance > randomControle) {
									// Le ballon est intercepté
									interceptePar(intercepteur);
									
								} else {
									int random50 = RandomManager.random(0, 1);
									if (random50 == 1) {
										deviePar(intercepteur);										
									}
								}
								
							} else {
							
								// Le ballon est devié ou le ballon passe a travers
								int random = RandomManager.random0_100();
								
								// Le ballon est devié
								if (random > 50) {
									deviePar(intercepteur);
									
								// Le ballon passe a travers
								} else {
									// Son d'esquive
									List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/esquive", 220000);
									MusiqueManager.playSonRandom(musiques);	
									
									logging.appendText(labelTimer.getText() + " - " + "(INTERCEPTION) : Le ballon passe a travers " + intercepteur.getPersonnage().getPrenom() + "\n");
									
								}
							}

						// Si le ballon est assez rapide
						} else if (ballon.getTopspeed() > Constante.VITESSE_MAX_BALLON - (Constante.VITESSE_MAX_BALLON/4)){
							
							// Le ballon est devié ou intercepté
							int random = RandomManager.random0_100();
							
							// Le ballon est devié
							if (random > 50) {
								deviePar(intercepteur);
								
							// Le ballon est intercepté
							} else {
								// Chance de controle ou deviation (90/10 au max)
								int chance = calculeChanceDeControler(intercepteur);
								int randomControle = RandomManager.random0_100();
								if (chance > randomControle) {
									// Le ballon est intercepté
									interceptePar(intercepteur);
								}
							}
							
						// Si le ballon est plutot lent
						} else {
							
							// Si le ballon est arrete
							if (ballon.getTopspeed() < Constante.VITESSE_MAX_BALLON/4) {
								// Le ballon est intercepté
								interceptePar(intercepteur);
								
							} else {
								
								// Chance de controle ou deviation (90/10 au max)
								int chance = calculeChanceDeControler(intercepteur);
								int randomControle = RandomManager.random0_100();
								if (chance > randomControle) {
									// Le ballon est intercepté
									interceptePar(intercepteur);
								} else {
									// Le ballon est devié
									deviePar(intercepteur);
								}
							}
						}
					}
				}
			}


			private void clashPorteurVS(JoueurPrincipal clasheur) {
				
				// Si le clasheur ne vient pas de clasher recemment
				if (!clasheur.vientDeClasher() && !clasheur.vientDIntercepter()) {

					logging.appendText(labelTimer.getText() + " - " + "(CLASH) " + clasheur.getPersonnage().getPrenom() + " VS " + porteur.getPersonnage().getPrenom() + "\n");
					
					// Reussite clash attaque : AGILITE / TECHNIQUE / EXPLOIT / INTELLIGENCE / NERVOSITE / LUCK
					int randomPorteurAttaque = calculeRandomClashAttaque(porteur);
					
					// Reussite clash defense : EXPLOIT / INTELLIGENCE / NERVOSITE / RESISTANCE / ENDURANCE / LUCK
					int randomClasheurDefense = calculeRandomClashDefense(clasheur);
					
					// Si le clasheur gagne le clash
					if (randomClasheurDefense > randomPorteurAttaque) {
						
						// Le porteur est stun
						porteur.setVitesseZero();

						// Le porteur ne pourra plus clasher pendant une courte periode
						porteur.setDateDernierClash(System.currentTimeMillis());
						porteur.setVientDeClasher(true);
	
						// Le clasheur recupere le ballon
						interceptePar(clasheur);
						
						logging.appendText(labelTimer.getText() + " - " + "(CLASH) " + clasheur.getPersonnage().getPrenom() + " recupere le ballon" + "\n");
					
					// Si le porteur gagne le clash
					} else {
						
						// Le porteur garde le ballon
						logging.appendText(labelTimer.getText() + " - " + "(CLASH) " + porteur.getPersonnage().getPrenom() + " elimine " + clasheur.getPersonnage().getPrenom() + "\n");
						
						// Le clasheur est stun
						clasheur.setVitesseZero();
						
						// Le clasheur ne pourra plus clasher pendant une courte periode
						clasheur.setDateDernierClash(System.currentTimeMillis());
						clasheur.setVientDeClasher(true);
						
						// Son d'esquive
						List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/esquive", 230000);
						MusiqueManager.playSonRandom(musiques);	
						
					}
					
				} else {
					// System.out.println("Le clasheur " + clasheur.getPersonnage().getPrenom() + " vient deja de clasher recemment");
				}
				
			}
			
			private int calculeChanceDeControler(JoueurPrincipal intercepteur) {
				// Chance de controler la balle : AGILITE / TECHNIQUE / NERVOSITE / INTELLIGENCE / LUCK
				int agilite = intercepteur.getPersonnage().getCompetence().getAgilite();
				int technique = intercepteur.getPersonnage().getCompetence().getTechnique();
				int intelligence = intercepteur.getPersonnage().getCompetence().getIntelligence();
				int nervosite = intercepteur.getPersonnage().getCompetence().getNervosite();
				int chance = intercepteur.getPersonnage().getCompetence().getLuck();
				
				int random = agilite + technique + intelligence + nervosite + chance;
				random = random / 5;
				random = random +25;
				if (random > 90) {
					random = 90;
				}
				return random;
			}

			private int calculeRandomClashDefense(JoueurPrincipal defenseur) {
				// Reussite clash defense : EXPLOIT / INTELLIGENCE / NERVOSITE / RESISTANCE / ENDURANCE / LUCK
				int exploit = defenseur.getPersonnage().getCompetence().getExploit();
				int intelligence = defenseur.getPersonnage().getCompetence().getIntelligence();
				int nervosite = defenseur.getPersonnage().getCompetence().getNervosite();
				int resistance = defenseur.getPersonnage().getCompetence().getResistance();
				int endurance = defenseur.getPersonnage().getCompetence().getEndurance();
				int chance = defenseur.getPersonnage().getCompetence().getLuck();
				
				int random = resistance + endurance + exploit + intelligence + nervosite + chance;
				random = random / 6;
				int valeur = RandomManager.random(0, random);
				return valeur;
			}

			private int calculeRandomClashAttaque(JoueurPrincipal attaquant) {
				// Reussite clash attaque : AGILITE / TECHNIQUE / EXPLOIT / INTELLIGENCE / NERVOSITE / LUCK
				int agilite = attaquant.getPersonnage().getCompetence().getAgilite();
				int technique = attaquant.getPersonnage().getCompetence().getTechnique();
				int exploit = attaquant.getPersonnage().getCompetence().getExploit();
				int intelligence = attaquant.getPersonnage().getCompetence().getIntelligence();
				int nervosite = attaquant.getPersonnage().getCompetence().getNervosite();
				int chance = attaquant.getPersonnage().getCompetence().getLuck();
				
				int random = agilite + technique + exploit + intelligence + nervosite + chance;
				random = random / 6;
				int valeur = RandomManager.random(0, random);
				return valeur;
			}

			private JoueurPrincipal trouveJoueurProche(boolean joueurAmi, PVector position) {
				
				JoueurPrincipal joueurProcheBallon = null;
				double distanceMin = 5000;
				List<JoueurPrincipal> joueurs = null;
				if (joueurAmi) {
					joueurs = new ArrayList<>(joueursAmis);
					if (joueurAutomatique) {
						joueurs.add(joueur);
					}
				} else {
					joueurs = joueursEnnemis;
				}
				for (JoueurPrincipal joueur : joueurs) {
					// Sauf le tireur
					if (joueur != tireur) {
						double distance = retourneDistanceEntre(joueur.getLocation(), position);
						if (distance < distanceMin) {
							distanceMin = distance;
							joueurProcheBallon = joueur;
						}
					}
				}
				return joueurProcheBallon;
			}

			private JoueurPrincipal trouveJoueurCibleAleatoire() {
				JoueurPrincipal joueurCible = porteur;
				if (porteur.isAllie()) {
					while(joueurCible == porteur || joueurCible.getPoste() == Poste.G) {
						int random = RandomManager.random(0, joueursAmis.size()-1);
						joueurCible = joueursAmis.get(random);
					}
				} else {
					while(joueurCible == porteur || joueurCible.getPoste() == Poste.G) {
						int random = RandomManager.random(0, joueursEnnemis.size()-1);
						joueurCible = joueursEnnemis.get(random);
					}
				}
				logging.appendText(labelTimer.getText() + " - " + "(Joueur cible aleatoire) : " + joueurCible.getPersonnage().getPrenom() + "\n");
				return joueurCible;
			}

			private void interceptePar(JoueurPrincipal joueur) {
				logging.appendText(labelTimer.getText() + " - " + "(INTERCEPTION) : " + joueur.getPersonnage().getPrenom() + " intercepte le ballon"  + "\n");
				ballonLibre = false;
				porteur = joueur;
				porteur.setDateDerniereInterception(System.currentTimeMillis());
				porteur.setVientDIntercepter(true);
				tireur = null;
				ballon.setaDepasseLaCible(false);
				ballon.resetTopSpeed();
				
				// Son d'interception
				List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/controle", 240000);
				MusiqueManager.playSonRandom(musiques);	
				
				// Maj labels
//				String nomPorteur = (porteur != null) ? porteur.getPersonnage().getPrenom() : "personne" ;
//				String nomTireur = (tireur != null) ? tireur.getPersonnage().getPrenom() : "personne" ;
//				labelPorteur.setText("Porteur : " + nomPorteur);
//				labelTireur.setText("Tireur : " + nomTireur);
			}
			
			private void deviePar(JoueurPrincipal ennemi) {
				
				// Le devieur ne pourra plus devier ou intercepter avant un laps de temps
				logging.appendText(labelTimer.getText() + " - " + "(DEVIATION) : " + ennemi.getPersonnage().getPrenom() + " devie le ballon"  + "\n");
				ennemi.setDateDerniereInterception(System.currentTimeMillis());
				ennemi.setVientDIntercepter(true);
				
				// Le ballon est devie vers une nouvelle position avec une nouvelle vitesse inferieure ou egale
				int nouvelleVitesseMax = 0;
				PVector nouvelleCible;
				
				// Variation aleatoire de la vitesse max et de la nouvelle position cible
				int random = RandomManager.random0_100();
				if (random > 75) {
					// On reduit un peu la vitesse max du ballon
					nouvelleVitesseMax = ballon.getTopspeed() - (ballon.getTopspeed()/4);
					
					// On eloigne moyennement la cible de la deviation
					int min = 10;
					int max = 100;
					nouvelleCible = genereNouvellePositionAleatoire(min, max);
					
				} else if (random > 50) {
					// On reduit moyennement la vitesse max du ballon
					nouvelleVitesseMax = ballon.getTopspeed() - (ballon.getTopspeed()/3);

					// On eloigne un peu la cible de la deviation
					int min = 10;
					int max = 50;
					nouvelleCible = genereNouvellePositionAleatoire(min, max);
				
				} else if (random > 25) {
					// On reduit beaucoup la vitesse max du ballon
					nouvelleVitesseMax = ballon.getTopspeed() - (ballon.getTopspeed()/2);

					// On eloigne un peu la cible de la deviation
					int min = 10;
					int max = 50;
					nouvelleCible = genereNouvellePositionAleatoire(min, max);
				
				} else {
					// On garde la meme vitesse max du ballon
					nouvelleVitesseMax = ballon.getTopspeed();
							
					// On eloigne beaucoup la cible de la deviation
					int min = 50;
					int max = 150;
					nouvelleCible = genereNouvellePositionAleatoire(min, max);

				}
				
				// On genere une nouvelle cible aleatoire dans l'entourage
				ballon.initMouvement(nouvelleCible, nouvelleVitesseMax);
				
				// Son de deviation/contre
				List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/deviation", 210000);
				MusiqueManager.playSonRandom(musiques);	
				
			}

			private PVector genereNouvellePositionAleatoire(int min, int max) {
				
				int randomX = RandomManager.random(min, max);
				int randomY = RandomManager.random(min, max);
				
				int randomNegatifX = RandomManager.random0_100();
				if (randomNegatifX > 50) {
					randomX =  -randomX;
				}
				int randomNegatifY = RandomManager.random0_100();
				if (randomNegatifY > 50) {
					randomY = -randomY;
				}
				
				double newX = ballon.getBallonPositionCible().x + randomX;
				double newY = ballon.getBallonPositionCible().y + randomY;
				
				return new PVector(newX, newY, 0);
			}
			

		}; // Fin Timer
		
		// Capture mouse position
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
        	
        	// Gestion inactivite du joueur principal
        	joueurAutomatique = false;
			joueur.getCircle().setStroke(Color.DEEPSKYBLUE);
        	dateDerniereAction = System.currentTimeMillis();

        	// Deplacement souris
        	mouse.set(e.getX(), e.getY(), 0);
//        	labelSourisX.setText("Souris X : " + mouse.x);
//        	labelSourisY.setText("Souris Y : " + mouse.y);
        });
        
        // Capture barre d espace
//        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
//        	System.out.println("PRESS ESPACE");
//        	if (event.getCode() == KeyCode.SPACE) {
//	        	if (!gameStarted) {
//	        		gameStarted = true;
//	        		timer.start();
//	        		
//	        		// Engagement => fait une passse vers le haut
//	        		passe(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5));
//	        	}
//        	}
//        });
        
        // Capture mouse click gauche/droit
        scene.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
        	
        	// Gestion inactivite du joueur principal
        	joueurAutomatique = false;
        	joueur.getCircle().setStroke(Color.DEEPSKYBLUE);
        	dateDerniereAction = System.currentTimeMillis();
        	
        	// Clic gauche
        	if (e.getButton() == MouseButton.PRIMARY) {
        		
//        		System.out.println("-----------CLIC GAUCHE----------");
        		
        		// Engagement
        		if (!gameStarted) {
	        		gameStarted = true;
	        		if (finDumatch != 0) {
	        			long difference = System.currentTimeMillis() - timerStopped;
	        			finDumatch = finDumatch + (difference * 1000000);
	        		}
	        		timer.start();
	        		
	        		// Engagement => fait une passse vers le haut
	        		passe(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5));
	        	
        		// Passe
	        	} else {
	        		
	        		if (!ballonLibre) {
	        			
	        			// Si le joueur principal possede le ballon
	        			if (joueur == porteur) {
	        				// Fait une passe vers la zone clické
	        				passe(e.getX(), e.getY());
	        				
	        			// Si un joueur allie possede le ballon
	        			} else if (porteur.isAllie()){
	        				// Fait une passe au joueur principal
	        				passe(joueur.getLocation().x, joueur.getLocation().y);
	        			}
	        		}
        		}

           	// Clic droit
        	} else if (e.getButton() == MouseButton.SECONDARY) {
//            	System.out.println("-----------CLIC DROIT----------");            	
            	
        		if (!ballonLibre) {
        			
        			// Si le joueur principal possede le ballon
        			if (joueur.getPersonnage().getNom().equals(porteur.getPersonnage().getNom())) {
        				// Fait un tir dans cette direction
        				tir(e.getX(), e.getY());
        			}
        		}
            }
        	
        });
		
		// Bouton EXIT
		Button boutonExit = new Button("Abandonner");
		boutonExit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				stopPartie(false);
			}
			
		});
		
		// 1er Affichage
		joueur.display();
		ballon.display();
		for (JoueurPrincipal personnage : joueursAmis) {
			personnage.display();
		}
		for (JoueurPrincipal personnage : joueursEnnemis) {
			personnage.display();
		}
        
		root.getChildren().addAll(joueursAmis);
		root.getChildren().addAll(joueursEnnemis);
        root.getChildren().addAll(joueur, ballon);
		root.getChildren().addAll(boutonExit);
		
		return (scene);
	}


	private void affichePrenomPorteur() {
		if (porteur!= null) {
			labelNomPorteur.setVisible(true);
			labelNomPorteur.setText(porteur.getPersonnage().getPrenom());
			labelNomPorteur.relocate(porteur.getLocation().x -50, porteur.getLocation().y - (porteur.getHauteur() * 2));
		} else {
			labelNomPorteur.setVisible(false);
		}
	}

	private void genereLeTerrain() {

		int coordXTerrain = Constante.COORD_X_TERRAIN;
		int coordYTerrain = Constante.COORD_Y_TERRAIN;
		
		// Terrain en fonction du lieu
		if (lieuDuTerrain.equals("ecole")) {
			
			Rectangle terrain = new Rectangle(Constante.LONGEUR_TERRAIN, Constante.LARGEUR_TERRAIN);
			terrain.relocate(coordXTerrain, coordYTerrain);
			terrain.setStroke(Color.GREY);
			terrain.setFill(Color.LIGHTGREY);
			terrain.setStrokeWidth(5);
			root.getChildren().add(terrain);
			
			Rectangle butAllie = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAllie.relocate(coordXTerrain - Constante.LARGEUR_TERRAIN/16, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAllie.setStroke(Color.GREY);
			butAllie.setFill(Color.GREY.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAllie);
			
			Rectangle butAdverse = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAdverse.setStroke(Color.GREY);
			butAdverse.setFill(Color.GREY.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAdverse);
			
			Rectangle couloirDroit = new Rectangle(Constante.LONGEUR_TERRAIN/4, Constante.LARGEUR_TERRAIN - Constante.LARGEUR_TERRAIN/8);
			couloirDroit.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2 + Constante.LONGEUR_TERRAIN/8, coordYTerrain + Constante.LARGEUR_TERRAIN/8);
			couloirDroit.setStroke(Color.YELLOW);
			couloirDroit.setFill(Color.LIGHTGREY);
			couloirDroit.setStrokeWidth(5);
			root.getChildren().add(couloirDroit);
			
			Rectangle couloirInterieur = new Rectangle(Constante.LONGEUR_TERRAIN/8, Constante.LARGEUR_TERRAIN - Constante.LARGEUR_TERRAIN/8);
			couloirInterieur.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2 + (3*Constante.LONGEUR_TERRAIN)/16, coordYTerrain + Constante.LARGEUR_TERRAIN/8);
			couloirInterieur.setStroke(Color.YELLOW);
			couloirInterieur.setFill(Color.LIGHTGREY);
			couloirInterieur.setStrokeWidth(5);
			root.getChildren().add(couloirInterieur);
			
			Line ligne = new Line();
			ligne.setStartX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2 + Constante.LONGEUR_TERRAIN/4);
			ligne.setStartY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/8);
			ligne.setEndX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2 + Constante.LONGEUR_TERRAIN/4);
			ligne.setEndY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN);
			ligne.setStroke(Color.YELLOW);
			ligne.setStrokeWidth(5);
			root.getChildren().add(ligne);
			
		} else if (lieuDuTerrain.equals("terrain")) {
			
			Rectangle terrain = new Rectangle(Constante.LONGEUR_TERRAIN, Constante.LARGEUR_TERRAIN);
			terrain.relocate(coordXTerrain, coordYTerrain);
			terrain.setStroke(Color.WHITE);
			terrain.setFill(Color.BROWN);
			root.getChildren().add(terrain);
			
			Rectangle butAllie = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAllie.relocate(coordXTerrain - Constante.LARGEUR_TERRAIN/16, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAllie.setStroke(Color.WHITE);
			butAllie.setFill(Color.WHITE.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAllie);
			
			Rectangle butAdverse = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAdverse.setStroke(Color.WHITE);
			butAdverse.setFill(Color.WHITE.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAdverse);
			
			Line carreServiceVertical = new Line();
			carreServiceVertical.setStartX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2);
			carreServiceVertical.setStartY(Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN);
			carreServiceVertical.setEndX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2);
			carreServiceVertical.setEndY(Constante.COORD_Y_TERRAIN + (2*Constante.LARGEUR_TERRAIN)/3);
			carreServiceVertical.setStroke(Color.WHITE);
			root.getChildren().add(carreServiceVertical);
			
			Line carreServiceHorizontal = new Line();
			carreServiceHorizontal.setStartX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/3);
			carreServiceHorizontal.setStartY(Constante.COORD_Y_TERRAIN + (2*Constante.LARGEUR_TERRAIN)/3);
			carreServiceHorizontal.setEndX(Constante.COORD_X_TERRAIN + (2*Constante.LONGEUR_TERRAIN)/3);
			carreServiceHorizontal.setEndY(Constante.COORD_Y_TERRAIN + (2*Constante.LARGEUR_TERRAIN)/3);
			carreServiceHorizontal.setStroke(Color.WHITE);
			root.getChildren().add(carreServiceHorizontal);
			
			Line fondDeCours = new Line();
			fondDeCours.setStartX(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/3);
			fondDeCours.setStartY(Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN)/3);
			fondDeCours.setEndX(Constante.COORD_X_TERRAIN + (2*Constante.LONGEUR_TERRAIN)/3);
			fondDeCours.setEndY(Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN)/3);
			fondDeCours.setStroke(Color.WHITE);
			root.getChildren().add(fondDeCours);
			
			Rectangle couloirGauche = new Rectangle(Constante.LONGEUR_TERRAIN/16, (2*Constante.LARGEUR_TERRAIN)/3);
			couloirGauche.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/3 - Constante.LONGEUR_TERRAIN/16, coordYTerrain + Constante.LARGEUR_TERRAIN/3);
			couloirGauche.setStroke(Color.WHITE);
			couloirGauche.setFill(Color.BROWN);
			root.getChildren().add(couloirGauche);
			
			Rectangle couloirDroit = new Rectangle(Constante.LONGEUR_TERRAIN/16, (2*Constante.LARGEUR_TERRAIN)/3);
			couloirDroit.relocate(coordXTerrain + (2*Constante.LONGEUR_TERRAIN)/3 , coordYTerrain + Constante.LARGEUR_TERRAIN/3);
			couloirDroit.setStroke(Color.WHITE);
			couloirDroit.setFill(Color.BROWN);
			root.getChildren().add(couloirDroit);
			
		} else if (lieuDuTerrain.equals("chelles")) {
			
			Rectangle terrain = new Rectangle(Constante.LONGEUR_TERRAIN, Constante.LARGEUR_TERRAIN);
			terrain.relocate(coordXTerrain, coordYTerrain);
			terrain.setStroke(Color.WHITE);
			terrain.setFill(Color.GREEN);
			root.getChildren().add(terrain);
			
			Rectangle butAllie = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAllie.relocate(coordXTerrain - Constante.LARGEUR_TERRAIN/16, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAllie.setStroke(Color.WHITE);
			butAllie.setFill(Color.WHITE.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAllie);
			
			Rectangle butAdverse = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAdverse.setStroke(Color.WHITE);
			butAdverse.setFill(Color.WHITE.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAdverse);
			
			Circle rondCentrale = new Circle(Constante.LARGEUR_TERRAIN/10);
			rondCentrale.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/10, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/10);
			rondCentrale.setStroke(Color.WHITE);
			rondCentrale.setFill(Color.GREEN);
			root.getChildren().add(rondCentrale);
			
			Rectangle ligneCentrale = new Rectangle(0, Constante.LARGEUR_TERRAIN);
			ligneCentrale.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2, coordYTerrain);
			ligneCentrale.setStroke(Color.WHITE);
			root.getChildren().add(ligneCentrale);
			
			Circle rondPenaltyAllie = new Circle(Constante.LARGEUR_TERRAIN/10);
			rondPenaltyAllie.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/10 - rondPenaltyAllie.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - rondPenaltyAllie.getRadius());
			rondPenaltyAllie.setStroke(Color.WHITE);
			rondPenaltyAllie.setFill(Color.GREEN);
			root.getChildren().add(rondPenaltyAllie);
			
			Circle rondPenaltyAdverse = new Circle(Constante.LARGEUR_TERRAIN/10);
			rondPenaltyAdverse.relocate(coordXTerrain + + Constante.LONGEUR_TERRAIN - Constante.LONGEUR_TERRAIN/10 - rondPenaltyAdverse.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - rondPenaltyAdverse.getRadius());
			rondPenaltyAdverse.setStroke(Color.WHITE);
			rondPenaltyAdverse.setFill(Color.GREEN);
			root.getChildren().add(rondPenaltyAdverse);
			
			Rectangle surfaceAllie = new Rectangle(Constante.LONGEUR_TERRAIN/6, Constante.LARGEUR_TERRAIN/2);
			surfaceAllie.relocate(coordXTerrain, coordYTerrain + Constante.LARGEUR_TERRAIN/4);
			surfaceAllie.setStroke(Color.WHITE);
			surfaceAllie.setFill(Color.GREEN);
			root.getChildren().add(surfaceAllie);
			
			Rectangle surfaceAdverse = new Rectangle(Constante.LONGEUR_TERRAIN/6, Constante.LARGEUR_TERRAIN/2);
			surfaceAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN - Constante.LONGEUR_TERRAIN/6, coordYTerrain + Constante.LARGEUR_TERRAIN/4);
			surfaceAdverse.setStroke(Color.WHITE);
			surfaceAdverse.setFill(Color.GREEN);
			root.getChildren().add(surfaceAdverse);
			
			Circle pointPenaltyAllie = new Circle(4);
			pointPenaltyAllie.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/10 - pointPenaltyAllie.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - pointPenaltyAllie.getRadius());
			pointPenaltyAllie.setStroke(Color.WHITE);
			pointPenaltyAllie.setFill(Color.WHITE);
			root.getChildren().add(pointPenaltyAllie);
			
			Circle pointPenaltyAdverse = new Circle(4);
			pointPenaltyAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN - Constante.LONGEUR_TERRAIN/10 - pointPenaltyAdverse.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - pointPenaltyAdverse.getRadius());
			pointPenaltyAdverse.setStroke(Color.WHITE);
			pointPenaltyAdverse.setFill(Color.WHITE);
			root.getChildren().add(pointPenaltyAdverse);
			
			Circle pointCentral = new Circle(4);
			pointCentral.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2 - pointCentral.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - pointCentral.getRadius());
			pointCentral.setStroke(Color.WHITE);
			pointCentral.setFill(Color.WHITE);
			root.getChildren().add(pointCentral);
			
		} else if (lieuDuTerrain.equals("noisy")) {
			
			Rectangle terrain = new Rectangle(Constante.LONGEUR_TERRAIN, Constante.LARGEUR_TERRAIN);
			terrain.relocate(coordXTerrain, coordYTerrain);
			terrain.setStroke(Color.WHITE);
			terrain.setFill(Color.GREEN);
			root.getChildren().add(terrain);
			
			Rectangle ligneCentrale = new Rectangle(0, Constante.LARGEUR_TERRAIN);
			ligneCentrale.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2, coordYTerrain);
			ligneCentrale.setStroke(Color.WHITE);
			root.getChildren().add(ligneCentrale);
			
			Circle surfaceAllie = new Circle(Constante.LARGEUR_TERRAIN/5);
			surfaceAllie.relocate(coordXTerrain - surfaceAllie.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - surfaceAllie.getRadius());
			surfaceAllie.setStroke(Color.WHITE);
			surfaceAllie.setFill(Color.GREEN);
			root.getChildren().add(surfaceAllie);
			
			Circle surfaceAdverse = new Circle(Constante.LARGEUR_TERRAIN/5);
			surfaceAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN - surfaceAllie.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - surfaceAllie.getRadius());
			surfaceAdverse.setStroke(Color.WHITE);
			surfaceAdverse.setFill(Color.GREEN);
			root.getChildren().add(surfaceAdverse);
			
			Rectangle ecranGauche = new Rectangle(Constante.COORD_X_TERRAIN, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN);
			ecranGauche.relocate(0, 0);
			ecranGauche.setFill(Color.BLACK);
			root.getChildren().add(ecranGauche);
			
			Rectangle ecranDroit = new Rectangle(Constante.COORD_X_TERRAIN *2, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN);
			ecranDroit.relocate(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN, 0);
			ecranDroit.setFill(Color.BLACK);
			root.getChildren().add(ecranDroit);
			
			Rectangle butAllie = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAllie.relocate(coordXTerrain - Constante.LARGEUR_TERRAIN/16, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAllie.setStroke(Color.WHITE);
			butAllie.setFill(Color.WHITE.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAllie);
			
			Rectangle butAdverse = new Rectangle(Constante.LARGEUR_TERRAIN/16, Constante.LARGEUR_TERRAIN/4);
			butAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN, coordYTerrain + Constante.LARGEUR_TERRAIN/2 - Constante.LARGEUR_TERRAIN/8);
			butAdverse.setStroke(Color.WHITE);
			butAdverse.setFill(Color.WHITE.deriveColor(1, 1, 1, 0.3));
			root.getChildren().add(butAdverse);
			
			Circle pointPenaltyAllie = new Circle(4);
			pointPenaltyAllie.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/5 - pointPenaltyAllie.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - pointPenaltyAllie.getRadius());
			pointPenaltyAllie.setStroke(Color.WHITE);
			pointPenaltyAllie.setFill(Color.WHITE);
			root.getChildren().add(pointPenaltyAllie);
			
			Circle pointPenaltyAdverse = new Circle(4);
			pointPenaltyAdverse.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN - Constante.LONGEUR_TERRAIN/5 - pointPenaltyAdverse.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - pointPenaltyAdverse.getRadius());
			pointPenaltyAdverse.setStroke(Color.WHITE);
			pointPenaltyAdverse.setFill(Color.WHITE);
			root.getChildren().add(pointPenaltyAdverse);
			
			Circle pointCentral = new Circle(4);
			pointCentral.relocate(coordXTerrain + Constante.LONGEUR_TERRAIN/2 - pointCentral.getRadius(), coordYTerrain + Constante.LARGEUR_TERRAIN/2 - pointCentral.getRadius());
			pointCentral.setStroke(Color.WHITE);
			pointCentral.setFill(Color.WHITE);
			root.getChildren().add(pointCentral);
		}
		
	}

	private double retourneDistanceEntre(PVector location1, PVector location2) {
		PVector difference = new PVector(location1.x - location2.x, location1.y - location2.y, 0);
		return Math.sqrt(((difference.x * difference.x) + (difference.y * difference.y)));
	}
	
	private void passe(double x, double y) {
		
		tireur = porteur;
		tireur.setDateDernierTir(System.currentTimeMillis());
		tireur.setVientDeTirer(true);
		
		// Ralenti la course quand le joueur fait une passe
		// TODO en fonction de l'agilite (reset 0 / moitie / full)
		tireur.setVitesseZero();
		
		PVector cible = calculePrecisionDeLaPasse(x, y);
		
		int vitesseMax = calculePuissanceDeLaPasse(cible);

		logging.appendText(labelTimer.getText() + " - " + "(PASSE) : " + porteur.getPersonnage().getPrenom() + " fait une passe (vitesse : " + vitesseMax + ")\n");
		
		porteur = null;
		ballonLibre = true;

		ballon.initMouvement(cible, vitesseMax);
		
		// Son de tir
		List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/passe", 240000);
		MusiqueManager.playSonRandom(musiques);	
		
		// Maj info Affichage
//		String nomPorteur = (porteur != null) ? porteur.getPersonnage().getPrenom() : "personne" ;
//		String nomTireur = (tireur != null) ? tireur.getPersonnage().getPrenom() : "personne" ;
//		labelPorteur.setText("Porteur : " + nomPorteur);
//		labelTireur.setText("Tireur : " + nomTireur);
	}

	private void tir(double x, double y) {
		
		tireur = porteur;
		tireur.setDateDernierTir(System.currentTimeMillis());
		tireur.setVientDeTirer(true);
		
		// Ralenti la course quand le joueur fait un tir
		// TODO en fonction de l'agilite (reset 0 / moitie / full)
		tireur.setVitesseZero();

		PVector cible = calculePrecisionDuTir(x, y);
		
		int vitesseMax = calculePuissanceDuTir();
	
		logging.appendText(labelTimer.getText() + " - " + "(TIR) : " + porteur.getPersonnage().getPrenom() + " tir (vitesse : " + vitesseMax + ")\n");
		
		porteur = null;
		ballonLibre = true;

		ballon.initMouvement(cible, vitesseMax);
		
		// Son de tir
		List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/tir", 250000);
		MusiqueManager.playSonRandom(musiques);	
		
		// Maj info Affichage
//		String nomPorteur = (porteur != null) ? porteur.getPersonnage().getPrenom() : "personne" ;
//		String nomTireur = (tireur != null) ? tireur.getPersonnage().getPrenom() : "personne" ;
//		labelPorteur.setText("Porteur : " + nomPorteur);
//		labelTireur.setText("Tireur : " + nomTireur);
	}

	private PVector calculePrecisionDeLaPasse(double x, double y) {
		double precisionX = randomPrecision(Constante.ECART_MAX_PRECISON_PASSE / facteurAgrandissement);
		double precisionY = randomPrecision(Constante.ECART_MAX_PRECISON_PASSE / facteurAgrandissement);
		return new PVector(x + precisionX, y + precisionY, 0);
	}
	
	private PVector calculePrecisionDuTir(double x, double y) {
		double precisionX = randomPrecision(Constante.ECART_MAX_PRECISON_TIR / facteurAgrandissement);
		double precisionY = randomPrecision(Constante.ECART_MAX_PRECISON_TIR / facteurAgrandissement);
		return new PVector(x + precisionX, y + precisionY, 0);
	}
	
	private double randomPrecision(int ecartMax) {
		// Precision du tir/passe : AGILITE / TECHNIQUE / EXPLOIT / NERVOSITE / LUCK (0 - 100)
		int agilite = tireur.getPersonnage().getCompetence().getAgilite();
		int technique = tireur.getPersonnage().getCompetence().getTechnique();
		int exploit = tireur.getPersonnage().getCompetence().getExploit();
		int nervosite = tireur.getPersonnage().getCompetence().getNervosite();
		int chance = tireur.getPersonnage().getCompetence().getLuck();
		
		int random = agilite + technique + exploit + nervosite + chance;
		random = random / 5;
		int valeur = RandomManager.random(0, random);
		valeur = ecartMax - valeur;
		if (valeur < 1) {
			valeur = 1;
		}
		int precision = RandomManager.random(0, valeur); 
		
		int random0_100 = RandomManager.random0_100();
		if (random0_100 < 50) {
			precision = -precision;
		}
		return precision;
	}

	private int calculePuissanceDeLaPasse(PVector cible) {
		int vitesseMax = 0;
		double distance = retourneDistanceEntre(tireur.getLocation(), cible);
		if (distance > Constante.LONGEUR_TERRAIN/2) {
			vitesseMax = Constante.VITESSE_MAX_BALLON;
			
		} else if (distance > Constante.LONGEUR_TERRAIN/3){
			vitesseMax = Constante.VITESSE_MAX_BALLON - (Constante.VITESSE_MAX_BALLON/5);
			
		} else if (distance > Constante.LONGEUR_TERRAIN/4){
			vitesseMax = Constante.VITESSE_MAX_BALLON - (Constante.VITESSE_MAX_BALLON/4);
			
		} else if (distance > Constante.LONGEUR_TERRAIN/5){
			vitesseMax = Constante.VITESSE_MAX_BALLON - (Constante.VITESSE_MAX_BALLON/3);
			
		} else {
			vitesseMax = Constante.VITESSE_MAX_BALLON - (Constante.VITESSE_MAX_BALLON/2);
		}
		
		// On reduit la vitesse max generale des passes par rapport aux tirs
		vitesseMax = (2 * vitesseMax)/3;
		return vitesseMax;
	}
	
	private int calculePuissanceDuTir() {
		// Puissance du tir : AGILITE / TECHNIQUE / EXPLOIT / NERVOSITE / LUCK (100 - Constante.VITESSE_MAX_BALLON)
		int agilite = tireur.getPersonnage().getCompetence().getAgilite();
		int technique = tireur.getPersonnage().getCompetence().getTechnique();
		int exploit = tireur.getPersonnage().getCompetence().getExploit();
		int intelligence = tireur.getPersonnage().getCompetence().getIntelligence();
		int nervosite = tireur.getPersonnage().getCompetence().getNervosite();
		int chance = tireur.getPersonnage().getCompetence().getLuck();
		
		int random = agilite + technique + exploit + intelligence + nervosite + chance;
		random = random / 6;
		int valeur = RandomManager.random(0, random);
		valeur = valeur + Constante.VITESSE_MAX_BALLON/2;
		return valeur;
	}

	private void coupDEnvoi(boolean pourLesAllies) {
		
		labelNomButeur.setVisible(false);
		labelNomPorteur.setVisible(false);
		
		String equipe;
		if (pourLesAllies) {
			equipe = "alliés";
		} else {
			equipe = "ennemis";
		}
		logging.appendText(labelTimer.getText() + " - " + "(ENGAGEMENT) Coup d'envoi pour les " + equipe + "\n");
		
		// Replacement des joueurs a leur poste initial
		for (JoueurPrincipal personnage : joueursAmis) {
			personnage.reinitPositionsAllies(pourLesAllies);
			// L'attaquant droit fait le coup d'envoi
			if (personnage.getPoste() == Poste.BD) {
				if (pourLesAllies) {
					porteur = personnage;
				} 
			} 
		}
		
		for (JoueurPrincipal personnage : joueursEnnemis) {
			personnage.reinitPositionsAdverses(pourLesAllies);
			// L'attaquant gauche fait le coup d'envoi
			if (personnage.getPoste() == Poste.BG) {
				if (!pourLesAllies) {
					porteur = personnage;
				}
			}
		}
		
		joueur.reinitPositionsAllies(pourLesAllies);
		if (joueur.getPoste() == Poste.BD) {
			if (pourLesAllies) {
				porteur = joueur;
			}
		}
		
		ballon.setEstEntre(false);
		ballonLibre = false;
		ballon.setLocation(porteur.getLocation());
		
		joueur.display();
		ballon.display();
		for (JoueurPrincipal personnage : joueursAmis) {
			personnage.display();
		}
		for (JoueurPrincipal personnage : joueursEnnemis) {
			personnage.display();
		}
		
		timer.stop();
		timerStopped = System.currentTimeMillis();
		gameStarted = false;

	}

	// Fin du jeu
	public void stopPartie(boolean win) {
		
		if (timer != null) {
			timer.stop();
		}
		gameStarted = false;
		root.getChildren().clear();
		
		// Message fin du jeu
		if (win) {
			MusiqueManager.playSonItem("sonParDefaut/defautVictoire.mp3");
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautVictoire.png");
			ImageIcon resizeImage = ImageManager.resizeImage(icon, Constante.PERSO_IMAGE_DIMENSION_180_180);
			JLabel labelMessage = new JLabel("Victoire !");
			labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
			JOptionPane.showMessageDialog(this, labelMessage, "Fin du match", 0, resizeImage);
		} else {
			MusiqueManager.playSonItem("sonParDefaut/defautDefaite.mp3");
			ImageIcon icon = FenetrePrincipal.getImageIcon("image/defaut/defautDefaite.png");
			ImageIcon resizeImage = ImageManager.resizeImage(icon, Constante.PERSO_IMAGE_DIMENSION_180_180);
			JLabel labelMessage = new JLabel("Defaite !");
			labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
			JOptionPane.showMessageDialog(this, labelMessage, "Fin du match", 0, resizeImage);
		}
		
		// Cachage de la frame foot et reaffichage de la mainframe
		this.setVisible(false);
		MenuPrincipal.getMainFrame().setEnabled(true);
		MenuPrincipal.getMainFrame().setVisible(true);
		VideoManager.show();
		MusiqueManager.stopAll();
		MusiqueManager.stopPlaylistEnBoucle();

		// Fin de la mission
		MenuPrincipal.getMainFrame().getCoreManager().getMissionManager().termineMission(mission, win);
	}

	private void centreFenetre() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}	
	
	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

}

package core;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import core.configuration.Constante;
import front.FenetrePrincipal;
import front.MenuPrincipal;
import modele.competence.Competence;
import modele.item.Item;
import modele.item.media.audio.Musique;
import modele.item.media.audio.Son;
import modele.item.mission.BossNom;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionDifficulty;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.Groupe;
import modele.item.personnage.MomentCle;
import modele.item.personnage.Objectif;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnageBoss;
import modele.item.personnage.PersonnageEnnemi;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.item.personnage.action.ActionCombat;

public class PersonnageManager implements Serializable {

	// Need PouvoirManager instancie avant
	
	private static final long serialVersionUID = 1L;
	
	private Groupe leGroupe;
	private List<PersonnageSecondaire> personnagesSecondaires;
	private List<PersonnageBoss> personnagesBoss;
	private List<PersonnageEnnemi> personnagesEnnemis;

	public void initialise(ActionCombatManager actionCombatManager, MissionDifficulty difficultePartie) {

		leGroupe = new Groupe();

		// Chargement des personnages Principaux
		
		ImageIcon iconNicolas = FenetrePrincipal.getImageIcon("image/nico petit.png");
		ImageIcon iconPierre = FenetrePrincipal.getImageIcon("image/pierre petit.png");
		ImageIcon iconYannick = FenetrePrincipal.getImageIcon("image/yannick petit.png");
		ImageIcon iconThomas = FenetrePrincipal.getImageIcon("image/thomas petit.png");
		ImageIcon iconJohann = FenetrePrincipal.getImageIcon("image/johann petit.png");
		ImageIcon iconAli = FenetrePrincipal.getImageIcon("image/ali.png");
		ImageIcon iconGuillaume = FenetrePrincipal.getImageIcon("image/guillaume.png");
		ImageIcon iconJonathan = FenetrePrincipal.getImageIcon("image/jonathan.png");
		
		PersonnagePrincipal johann = new PersonnagePrincipal(PersoNom.AVELINE, PersoPrenom.Johann, "Yo", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), iconJohann, new ArrayList<ImageIcon>(), Color.BLUE, actionCombatManager.getActionsCombat(PersoPrenom.Johann.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal nicolas = new PersonnagePrincipal(PersoNom.LOPEZ, PersoPrenom.Nicolas, "Nico",new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconNicolas, new ArrayList<ImageIcon>(), Color.YELLOW, actionCombatManager.getActionsCombat(PersoPrenom.Nicolas.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal pierre = new PersonnagePrincipal(PersoNom.SERMAIN, PersoPrenom.Pierre, "Pip", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconPierre, new ArrayList<ImageIcon>(), Color.GREEN, actionCombatManager.getActionsCombat(PersoPrenom.Pierre.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal thomas = new PersonnagePrincipal(PersoNom.DARMOUNI, PersoPrenom.Thomas, "Darm", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconThomas, new ArrayList<ImageIcon>(), Color.RED, actionCombatManager.getActionsCombat(PersoPrenom.Thomas.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal yannick = new PersonnagePrincipal(PersoNom.BERCOT, PersoPrenom.Yannick, "Ya", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconYannick, new ArrayList<ImageIcon>(), Color.MAGENTA, actionCombatManager.getActionsCombat(PersoPrenom.Yannick.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal ali = new PersonnagePrincipal(PersoNom.CHAUDHRY, PersoPrenom.Ali, "Ali", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconAli, new ArrayList<ImageIcon>(), Color.PINK, actionCombatManager.getActionsCombat(PersoPrenom.Ali.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal guillaume = new PersonnagePrincipal(PersoNom.BURGUET, PersoPrenom.Guillaume, "Guy", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconGuillaume, new ArrayList<ImageIcon>(), Color.ORANGE, actionCombatManager.getActionsCombat(PersoPrenom.Guillaume.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal jonathan = new PersonnagePrincipal(PersoNom.RUSCITO, PersoPrenom.Jonathan, "Russ", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),  iconJonathan, new ArrayList<ImageIcon>(), Color.CYAN, actionCombatManager.getActionsCombat(PersoPrenom.Jonathan.name()), new ArrayList<Objectif>(), new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		
		leGroupe.ajoutePerso(johann);
		leGroupe.ajoutePerso(nicolas);
		leGroupe.ajoutePerso(pierre);
		leGroupe.ajoutePerso(thomas);
		leGroupe.ajoutePerso(yannick);
		leGroupe.ajoutePerso(ali);
		leGroupe.ajoutePerso(guillaume);
		leGroupe.ajoutePerso(jonathan);

		// Chargement des personnages Secondaires
		personnagesSecondaires = new ArrayList<PersonnageSecondaire>();
		PersonnageSecondaire barbara = new PersonnageSecondaire("Barbara", "Stolic");
		
		personnagesSecondaires.add(barbara);
		
		// Chargement des personnages Ennemis
		personnagesEnnemis = new ArrayList<PersonnageEnnemi>();
		
		// Chargement des Boss
		personnagesBoss = new ArrayList<PersonnageBoss>();
		List<String> particularitesPhysique = new ArrayList<String>();
		List<String> particularitesSocial = new ArrayList<String>();
		List<String> phrasesPerso = new ArrayList<String>();
		ImageIcon photoBoss = FenetrePrincipal.getImageIcon("image/guillaume.png");
		
		List<ImageIcon> photos = new ArrayList<ImageIcon>();
		// TODO en fonction de la difficulte
		
		int vieMax = 1000;
		int manaMax = 500;
		int chargeMax = 5;
		
		// Competences pour les BOSS en fonction de la difficulte
		Competence competence = null;
		
		// En fonction difficulte Partie 
		if (difficultePartie == MissionDifficulty.FACILE) {
			vieMax = 500;
			manaMax = 100;
			chargeMax = 3;
			competence = new Competence(25);
		} else if (difficultePartie == MissionDifficulty.NORMAL) {
			vieMax = 1000;
			manaMax = 200;
			chargeMax = 5;
			competence = new Competence(50);
		} else if (difficultePartie == MissionDifficulty.DIFFICILE) {
			vieMax = 5000;
			manaMax = 500;
			chargeMax = 7;
			competence = new Competence(75);
		} else if (difficultePartie == MissionDifficulty.HEROIQUE) {
			vieMax = 10000;
			manaMax = 1000;
			chargeMax = 10;
			competence = new Competence(100);
		} 

		// ActionsCombat du BOSS
		List<ActionCombat> actionsCombat = actionCombatManager.getActionsCombat(BossNom.BOSS1.name());
		
		PersonnageBoss boss1 = new PersonnageBoss(BossNom.BOSS1.name(), vieMax, manaMax, chargeMax, particularitesPhysique, particularitesSocial, phrasesPerso, photoBoss, photos, actionsCombat, competence);
		personnagesBoss.add(boss1);
	}

	public PersonnagePrincipal getPersoByPrenom(PersoPrenom nom) {
		return leGroupe.getPersoByNom(nom);
	}
	

	public PersonnagePrincipal getPersoByPrenom(String prenom) {
		return leGroupe.getPersoByNom(prenom);
	}

	public Groupe getLeGroupe() {
		return leGroupe;
	}

	public List<PersonnageSecondaire> getPersonnagesSecondaires() {
		return personnagesSecondaires;
	}

	public List<PersonnageBoss> getPersonnagesBoss() {
		return personnagesBoss;
	}

	public List<PersonnageEnnemi> getPersonnagesEnnemis() {
		return personnagesEnnemis;
	}

	public PersonnageBoss getPersonnageBossByNom(BossNom bossNom) {
		for(PersonnageBoss personnageBoss : personnagesBoss) {
			System.out.println("Nom : " + personnageBoss.getNom());
			System.out.println("Nom : " + bossNom.name());
			if(personnageBoss.getNom().equals(bossNom.name())) {
				return personnageBoss;
			}
		}
		return null;
	}

	public PersonnageEnnemi createPersonnageEnnemi(Mission mission, int numero) {

		// TODO pour chaque type d ennemis
		List<ImageIcon> photos = new ArrayList<ImageIcon>();
		List<String> particularitesPhysique = new ArrayList<String>();
		List<String> particularitesSocial = new ArrayList<String>();
		List<String> phrasesPerso = new ArrayList<String>();

		String imagePath = null;
		String nom = null;
		
		if (mission.getTypeEnnemis() == EnnemiType.GITANS) {
			imagePath = "image/ennemi/gitan.png";
			nom = "Ennemi Gitan " + numero;
			phrasesPerso.add("T'inquietes pas que je sais l'en faire du vélo mon copain!");
			phrasesPerso.add("J'te met un coup de botte dans les couilles, tu montes jusqu'à la lune!");
			phrasesPerso.add("J'prends v'la le pavée et je te le jette dans la gueule!");
			particularitesPhysique.add("Parle bizarrement en phonétique.");
			particularitesSocial.add("Nomade.");
			particularitesSocial.add("Se marie qu'avec des gitans.");
			particularitesSocial.add("Appelle les autres gitans : mes cousins.");
		} else if (mission.getTypeEnnemis() == EnnemiType.ARABES) {
			imagePath = "image/ennemi/arabe.png";
			nom = "Ennemi Arabe " + numero;
		} else if (mission.getTypeEnnemis() == EnnemiType.HANDICAPES) {
			imagePath = "image/ennemi/handicape.png";
			nom = "Ennemi Handicapé " + numero;
		} else if (mission.getTypeEnnemis() == EnnemiType.NOIRS) {
			imagePath = "image/ennemi/noir.png";
			nom = "Ennemi Noir " + numero;
		}
		ImageIcon photoPrincipal = ImageManager.resizeImage(FenetrePrincipal.getImageIcon(imagePath),
				Constante.PERSO_IMAGE_DIMENSION_64_64);


		int vieMax = 0;
		int manaMax = 0;
		int chargeMax = 0;
		
		// TODO actionsCombat pour les ennemis en fonction de la difficulte
		List<ActionCombat> actionsCombat = MenuPrincipal.getMainFrame().getCoreManager().getActionCombatManager().getActionsCombat(mission.getTypeEnnemis().name());

		// Competences pour les ennemis en fonction de la difficulte
		Competence competence = null;
		
		if (mission.getDifficulty() == MissionDifficulty.FACILE) {
			vieMax = 500;
			manaMax = 100;
			chargeMax = 1;
			competence = new Competence(25);
		} else if (mission.getDifficulty() == MissionDifficulty.NORMAL) {
			vieMax = 1000;
			manaMax = 200;
			chargeMax = 2;
			competence = new Competence(50);
		} else if (mission.getDifficulty() == MissionDifficulty.DIFFICILE) {
			vieMax = 2000;
			manaMax = 500;
			chargeMax = 3;
			competence = new Competence(75);
		} else if (mission.getDifficulty() == MissionDifficulty.HEROIQUE) {
			vieMax = 5000;
			manaMax = 1000;
			chargeMax = 5;
			competence = new Competence(100);
		} 

		PersonnageEnnemi ennemi = new PersonnageEnnemi(nom, vieMax, manaMax, chargeMax, particularitesPhysique, particularitesSocial, phrasesPerso, photoPrincipal, photos, actionsCombat, mission.getTypeEnnemis(), competence);
		return ennemi;
	}

	public List<PersonnagePrincipal> getPersoVivants() {
		List<PersonnagePrincipal> persosVivants = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			if (!personnage.isMort()) {
				persosVivants.add(personnage);
			}
		}
		return persosVivants;
	}
	
}

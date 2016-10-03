package core;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import core.configuration.Constante;
import front.FenetrePrincipal;
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

	public void initialise(ActionCombatManager actionCombatManager) {

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
		PersonnageSecondaire barbara = new PersonnageSecondaire();
		
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
		int vieMax = 100;
		int manaMax = 50;
		int chargeMax = 50;
		List<ActionCombat> actionsCombat = actionCombatManager.getActionsCombat(BossNom.BOSS1.name());
		
		PersonnageBoss boss1 = new PersonnageBoss(BossNom.BOSS1.name(), vieMax, manaMax, chargeMax, particularitesPhysique, particularitesSocial, phrasesPerso, photoBoss, photos, actionsCombat);
		personnagesBoss.add(boss1);
	}

	public PersonnagePrincipal getPersoByPrenom(PersoPrenom nom) {
		return leGroupe.getPersoByNom(nom);
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
			if(personnageBoss.getNom().equals(bossNom.name())) {
				return personnageBoss;
			}
		}
		return null;
	}

	public PersonnageEnnemi createPersonnageEnnemi(Mission mission, int numero) {

		String imagePath = null;
		if (mission.getTypeEnnemis() == EnnemiType.GITANS) {
			imagePath = "image/ennemi/gitan.png";
		} else if (mission.getTypeEnnemis() == EnnemiType.ARABES) {
			imagePath = "image/ennemi/arabe.png";
		} else if (mission.getTypeEnnemis() == EnnemiType.HANDICAPES) {
			imagePath = "image/ennemi/handicape.png";
		} else if (mission.getTypeEnnemis() == EnnemiType.NOIRS) {
			imagePath = "image/ennemi/noir.png";
		}
		ImageIcon photoPrincipal = ImageManager.resizeImage(FenetrePrincipal.getImageIcon(imagePath),
				Constante.PERSO_IMAGE_DIMENSION_64_64);
		
		String nom = "Ennemi " + numero;
		// TODO
		List<String> particularitesPhysique = new ArrayList<String>();
		List<String> particularitesSocial = new ArrayList<String>();
		List<String> phrasesPerso = new ArrayList<String>();
		List<ImageIcon> photos = new ArrayList<ImageIcon>();

		int vieMax = 0;
		int manaMax = 0;
		int chargeMax = 0;
		// TODO actionsCombat pour les ennemis en fonction de la difficulte
		List<ActionCombat> actionsCombat = new ArrayList<ActionCombat>();

		if (mission.getDifficulty() == MissionDifficulty.FACILE) {
			vieMax = 100;
			manaMax = 100;
			chargeMax = 100;
		} else if (mission.getDifficulty() == MissionDifficulty.NORMAL) {
			vieMax = 200;
			manaMax = 200;
			chargeMax = 200;
		} else if (mission.getDifficulty() == MissionDifficulty.DIFFICILE) {
			vieMax = 500;
			manaMax = 500;
			chargeMax = 500;
		} else if (mission.getDifficulty() == MissionDifficulty.HEROIQUE) {
			vieMax = 1000;
			manaMax = 1000;
			chargeMax = 1000;
		} 
		PersonnageEnnemi ennemi = new PersonnageEnnemi(nom, vieMax, manaMax, chargeMax, particularitesPhysique, particularitesSocial, phrasesPerso, photoPrincipal, photos, actionsCombat, mission.getTypeEnnemis());
		return ennemi;
	}
	
}

package core;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import core.configuration.Constante;
import front.FenetrePrincipal;
import front.MenuPrincipal;
import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.media.audio.Musique;
import modele.item.media.audio.Son;
import modele.item.mission.BossNom;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.Groupe;
import modele.item.personnage.MomentCle;
import modele.item.personnage.Objectif;
import modele.item.personnage.PersoClasse;
import modele.item.personnage.PersoNom;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.Personnage;
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

	public void initialise(ActionCombatManager actionCombatManager, Difficulte difficultePartie) {

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

		PersonnagePrincipal johann = new PersonnagePrincipal(PersoNom.AVELINE, PersoPrenom.Johann, "Yo",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconJohann, new ArrayList<ImageIcon>(), Color.BLUE,
				actionCombatManager.getActionsCombat(PersoPrenom.Johann.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal nicolas = new PersonnagePrincipal(PersoNom.LOPEZ, PersoPrenom.Nicolas, "Nico",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconNicolas, new ArrayList<ImageIcon>(), Color.YELLOW,
				actionCombatManager.getActionsCombat(PersoPrenom.Nicolas.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal pierre = new PersonnagePrincipal(PersoNom.SERMAIN, PersoPrenom.Pierre, "Pip",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconPierre, new ArrayList<ImageIcon>(), Color.GREEN,
				actionCombatManager.getActionsCombat(PersoPrenom.Pierre.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal thomas = new PersonnagePrincipal(PersoNom.DARMOUNI, PersoPrenom.Thomas, "Darm",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconThomas, new ArrayList<ImageIcon>(), Color.RED,
				actionCombatManager.getActionsCombat(PersoPrenom.Thomas.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal yannick = new PersonnagePrincipal(PersoNom.BERCOT, PersoPrenom.Yannick, "Ya",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconYannick, new ArrayList<ImageIcon>(), Color.MAGENTA,
				actionCombatManager.getActionsCombat(PersoPrenom.Yannick.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal ali = new PersonnagePrincipal(PersoNom.CHAUDHRY, PersoPrenom.Ali, "Ali",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconAli, new ArrayList<ImageIcon>(), Color.PINK,
				actionCombatManager.getActionsCombat(PersoPrenom.Ali.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal guillaume = new PersonnagePrincipal(PersoNom.BURGUET, PersoPrenom.Guillaume, "Guy",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconGuillaume, new ArrayList<ImageIcon>(), Color.ORANGE,
				actionCombatManager.getActionsCombat(PersoPrenom.Guillaume.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);
		PersonnagePrincipal jonathan = new PersonnagePrincipal(PersoNom.RUSCITO, PersoPrenom.Jonathan, "Russ",
				new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconJonathan, new ArrayList<ImageIcon>(), Color.CYAN,
				actionCombatManager.getActionsCombat(PersoPrenom.Jonathan.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), new ArrayList<Musique>(), new ArrayList<Item>(), null, new Competence(), true);

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
		int manaMax = 200;
		int chargeMax = 10;

		// Competences pour les BOSS en fonction de la difficulte
		Competence competence = null;

		// En fonction difficulte Partie
		if (difficultePartie == Difficulte.FACILE) {
			vieMax = 500;
			manaMax = 100;
			chargeMax = 3;
			competence = new Competence(25);
		} else if (difficultePartie == Difficulte.NORMAL) {
			vieMax = 650;
			manaMax = 150;
			chargeMax = 5;
			competence = new Competence(50);
		} else if (difficultePartie == Difficulte.DIFFICILE) {
			vieMax = 850;
			manaMax = 150;
			chargeMax = 7;
			competence = new Competence(75);
		} else if (difficultePartie == Difficulte.HEROIQUE) {
			vieMax = 1000;
			manaMax = 200;
			chargeMax = 10;
			competence = new Competence(100);
		}

		// ActionsCombat du BOSS
		List<ActionCombat> actionsCombat = actionCombatManager.getActionsCombat(BossNom.BOSS1.name());

		PersonnageBoss boss1 = new PersonnageBoss(BossNom.BOSS1.name(), vieMax, manaMax, chargeMax,
				particularitesPhysique, particularitesSocial, phrasesPerso, photoBoss, photos, actionsCombat,
				competence);
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
		for (PersonnageBoss personnageBoss : personnagesBoss) {
			System.out.println("Nom : " + personnageBoss.getNom());
			System.out.println("Nom : " + bossNom.name());
			if (personnageBoss.getNom().equals(bossNom.name())) {
				return personnageBoss;
			}
		}
		return null;
	}

	public PersonnageEnnemi createPersonnageEnnemi(Mission mission, int numero, int niveauSorts, PersoClasse classe) {

		// TODO pour chaque type d ennemis
		List<ImageIcon> photos = new ArrayList<ImageIcon>();
		List<String> particularitesPhysique = new ArrayList<String>();
		List<String> particularitesSocial = new ArrayList<String>();
		List<String> phrasesPerso = new ArrayList<String>();

		String imagePath = null;
		String nom = null;
		List<PersoStat> statsParType = new ArrayList<PersoStat>();
		List<PersoStat> statsParClasse = new ArrayList<PersoStat>();
		// GITANS
		if (mission.getTypeEnnemis() == EnnemiType.GITANS) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.RESISTANCE);
			statsParType.add(PersoStat.NERVOSITE);
			imagePath = "image/ennemi/gitan.png";
			nom = "Ennemi Gitan " + numero + "(" + classe.name() + ")";
			phrasesPerso.add("Hey Gadjo!");
			phrasesPerso.add("Mange tes maures!");
			phrasesPerso.add("Ca c'est mon cousin!");
			phrasesPerso.add("T'inquietes pas que je sais l'en faire du vélo mon copain!");
			phrasesPerso.add("J'te met un coup d'botte dans les couilles, tu décolles jusqu'à la lune!");
			phrasesPerso.add("J'ai pris v'la l'pavée!");
			particularitesPhysique.add("Parle bizzarement en phonétique.");
			particularitesSocial.add("Ne sait ni lire, ni ecrire.");
			particularitesSocial.add("Nomade.");
			particularitesSocial.add("Se marie qu'avec des gitans.");
			particularitesSocial.add("Appelle les autres gitans : mes cousins.");
		}
		// ARABES
		else if (mission.getTypeEnnemis() == EnnemiType.ARABES) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.TECHNIQUE);
			statsParType.add(PersoStat.RAPIDITE);
			statsParType.add(PersoStat.NERVOSITE);
			imagePath = "image/ennemi/arabe.png";
			nom = "Ennemi Arabe " + numero + "(" + classe.name() + ")";
			phrasesPerso.add("Wesh ma gueule!");
			phrasesPerso.add("Meskine!");
			phrasesPerso.add("Wesh, t'as pas une garette-ci?");
			phrasesPerso.add("Hey Mademoiselle! Vous êtes trop charmante!");
			phrasesPerso.add("Wesh ma gueule!");
			phrasesPerso.add("Naal dine oumouk!");
			phrasesPerso.add("Naal din bebek!");
			particularitesPhysique.add("Parle en verlan.");
			particularitesPhysique.add("Porte un jogging, une casquette et des baskets.");
			particularitesSocial.add("Se deplace uniquement en groupe.");
			particularitesSocial.add("Se marie qu'avec des rebeu.");
			particularitesSocial.add("Appelle les autres arabes : ma gueule/ma couille.");
		}
		// NOIRS
		else if (mission.getTypeEnnemis() == EnnemiType.NOIRS) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.ENDURANCE);
			statsParType.add(PersoStat.RAPIDITE);
			statsParType.add(PersoStat.EXPLOIT);
			imagePath = "image/ennemi/noir.png";
			nom = "Ennemi Noir " + numero + "(" + classe.name() + ")";
			phrasesPerso.add("Hey Garçon!");
			particularitesPhysique.add("Tchip");
			particularitesPhysique.add("A le rythme dans la peau, une grosse bite, sent fort et possede une piste d'athletisme dans son jardin.");
			particularitesPhysique.add("Parle en verlan.");
			particularitesPhysique.add("Porte un jogging, une casquette et des baskets.");
			particularitesSocial.add("Se deplace uniquement en groupe.");
			particularitesSocial.add("Se marie qu'avec des francais pour obtenir les papiers.");
			particularitesSocial.add("Appelle les autres noirs : mon frère/négro.");
		}
		// HANDICAPES
		else if (mission.getTypeEnnemis() == EnnemiType.HANDICAPES) {
			statsParType.add(PersoStat.INTELLIGENCE);
			statsParType.add(PersoStat.LUCK);
			statsParType.add(PersoStat.EXPLOIT);
			imagePath = "image/ennemi/handicape.png";
			nom = "Ennemi Handicapé " + numero + "(" + classe.name() + ")";
		}
		// TODO autres type d'ennemi skin/alqueda/...

		// TODO Stats par classe en fonction de la difficulte

		// Stats par classe
		// PersoStat.AGILITE = 10% chance d'esquive
		// PersoStat.ENDURANCE = Vie max (max = 1000)
		// PersoStat.EXPLOIT = Degats critiques (max x10)
		// PersoStat.INTELLIGENCE = Mana max (max = 100)
		// PersoStat.LUCK = 10% chance esquive / chance critique (max = 33%)
		// PersoStat.NERVOSITE = Charges max (max = 5)
		// PersoStat.RAPIDITE = 10% chance d'esquive
		// PersoStat.RESISTANCE = Reduction Degats (max = 80%)
		// PersoStat.TECHNIQUE = Degats min (max = 50)
		// + PersoStat actionCombat = Degats max (max = 100)

		// TANK
		if (classe == PersoClasse.TANK) {
			statsParClasse.add(PersoStat.ENDURANCE);
			statsParClasse.add(PersoStat.NERVOSITE);
			statsParClasse.add(PersoStat.RESISTANCE);
		}
		// HEALER
		else if (classe == PersoClasse.HEALER) {
			statsParClasse.add(PersoStat.AGILITE);
			statsParClasse.add(PersoStat.INTELLIGENCE);
			statsParClasse.add(PersoStat.LUCK);
			statsParClasse.add(PersoStat.RAPIDITE);
			statsParClasse.add(PersoStat.TECHNIQUE);
		}
		// DPS
		else if (classe == PersoClasse.DPS) {
			statsParClasse.add(PersoStat.AGILITE);
			statsParClasse.add(PersoStat.EXPLOIT);
			statsParClasse.add(PersoStat.LUCK);
			statsParClasse.add(PersoStat.NERVOSITE);
			statsParClasse.add(PersoStat.RAPIDITE);
			statsParClasse.add(PersoStat.TECHNIQUE);
		}
		// MAGE
		else if (classe == PersoClasse.MAGE) {
			statsParClasse.add(PersoStat.AGILITE);
			statsParClasse.add(PersoStat.EXPLOIT);
			statsParClasse.add(PersoStat.INTELLIGENCE);
			statsParClasse.add(PersoStat.LUCK);
			statsParClasse.add(PersoStat.RAPIDITE);
			statsParClasse.add(PersoStat.TECHNIQUE);
		}
		// BARDE
		else if (classe == PersoClasse.BARDE) {
			statsParClasse.add(PersoStat.AGILITE);
			statsParClasse.add(PersoStat.ENDURANCE);
			statsParClasse.add(PersoStat.INTELLIGENCE);
			statsParClasse.add(PersoStat.NERVOSITE);
			statsParClasse.add(PersoStat.RAPIDITE);
		}

		ImageIcon photoPrincipal = ImageManager.resizeImage(FenetrePrincipal.getImageIcon(imagePath),
				Constante.PERSO_IMAGE_DIMENSION_64_64);

		// TODO actionsCombat pour les ennemis en fonction de la difficulte du
		// type d'ennemi et de la classe de l'ennemi
		List<ActionCombat> actionsCombat = MenuPrincipal.getMainFrame().getCoreManager().getActionCombatManager()
				.getActionsCombat(mission.getTypeEnnemis().name() + classe.name());

		// Si le niveau du meilleur sort d'un joueur est plus grand que le
		// niveau de base (1,3,6,10) du sort de l'ennemi
		if (niveauSorts > actionsCombat.get(0).getNiveau()) {
			for (ActionCombat action : actionsCombat) {
				action.setNiveau(niveauSorts);
			}
		}

		// Competences pour les ennemis en fonction de la difficulte
		// TODO Competences pour les ennemis en fonction du type d'ennemis
		// (gitans, arabes, ...)
		// TODO Competences pour les ennemis en fonction de la classe d'ennemis
		// (Tank, heal, dps, controle)
		// TODO vie/mana/charge max en fonction des competences comme les
		// joueurs
		// TODO IMPORTANT Difficulté croissante : Competences en fonction de
		// l'avancement du jeu (par rapport au niveau du meilleur sort du
		// groupe?)
		int vieMax = 0;
		int manaMax = 0;
		int chargeMax = 0;
		Competence competence = null;

		if (mission.getDifficulty() == Difficulte.FACILE) {
			vieMax = 20;
			manaMax = 20;
			chargeMax = 1;
			competence = new Competence(25);
		} else if (mission.getDifficulty() == Difficulte.NORMAL) {
			vieMax = 30;
			manaMax = 30;
			chargeMax = 2;
			competence = new Competence(50);
		} else if (mission.getDifficulty() == Difficulte.DIFFICILE) {
			vieMax = 40;
			manaMax = 40;
			chargeMax = 3;
			competence = new Competence(75);
		} else if (mission.getDifficulty() == Difficulte.HEROIQUE) {
			vieMax = 50;
			manaMax = 50;
			chargeMax = 5;
			competence = new Competence(100);
		}
		// Met les competences de type et de classe au meme niveau que la
		// competence max du groupe (progression de la difficulté)
		Map<PersoStat, Integer> stats = competence.getStats();
		// Meilleur stat par type
		for (PersoStat statParType : statsParType) {
			int valeurStatParType = getBestStatPersoVivant(statParType);
			if (stats.get(statParType) < valeurStatParType) {
				stats.put(statParType, valeurStatParType);
			}
		}
		// Meilleurs stats par classe
		for (PersoStat statParClasse : statsParClasse) {
			int valeurStatParClasse = getBestStatPersoVivant(statParClasse);
			if (stats.get(statParClasse) < valeurStatParClasse) {
				stats.put(statParClasse, valeurStatParClasse);
			}
		}

		PersonnageEnnemi ennemi = new PersonnageEnnemi(nom, vieMax, manaMax, chargeMax, particularitesPhysique,
				particularitesSocial, phrasesPerso, photoPrincipal, photos, actionsCombat, mission.getTypeEnnemis(),
				competence);

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

	public int getBestStatPersoVivant(PersoStat stat) {
		int max = 0;
		for (PersonnagePrincipal personnage : getPersoVivants()) {
			Integer valeur = personnage.getCompetence().getStats().get(stat);
			if (valeur > max) {
				max = valeur;
			}
		}
		return max;
	}

	public int getBestNiveauSorts() {
		int max = 0;
		for (PersonnagePrincipal personnage : getPersoVivants()) {
			for (ActionCombat action : personnage.getActionsCombat()) {
				int valeur = action.getNiveau();
				if (valeur > max) {
					max = valeur;
				}
			}
		}
		return max;
	}

	public PersonnagePrincipal getBestPersoVivant(PersoStat stat) {
		int max = 0;
		PersonnagePrincipal perso = null;
		for (PersonnagePrincipal personnage : getPersoVivants()) {
			Integer valeur = personnage.getCompetence().getStats().get(stat);
			if (valeur > max) {
				max = valeur;
				perso = personnage;
			}
		}
		return perso;
	}

	public Personnage getBestStatPersoMorts(PersoStat stat, List<Personnage> morts) {
		int max = 0;
		Personnage perso = null;
		for (Personnage personnage : morts) {
			Integer valeur = personnage.getCompetence().getStats().get(stat);
			if (valeur > max) {
				max = valeur;
				perso = personnage;
			}
		}
		return perso;
	}

}

package core;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

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
import modele.location.Location;

public class PersonnageManager implements Serializable {

	// Need PouvoirManager instancié avant

	private static final long serialVersionUID = 1L;
	
	private Groupe leGroupe;
	private List<PersonnageSecondaire> personnagesSecondaires;
	private List<PersonnageBoss> personnagesBoss;
	private List<PersonnageEnnemi> personnagesEnnemis;
	private PersoPrenom personnagePrincipal;
	private Difficulte difficulte = Difficulte.FACILE;

	public void initialise(ActionCombatManager actionCombatManager, Difficulte difficultePartie) {

		leGroupe = new Groupe();
		difficulte = difficultePartie;

		// Chargement des personnages Principaux

		ImageIcon iconNicolas = FenetrePrincipal.getImageIcon("image/nico petit.png");
		ImageIcon iconPierre = FenetrePrincipal.getImageIcon("image/pierre petit.png");
		ImageIcon iconYannick = FenetrePrincipal.getImageIcon("image/yannick petit.png");
		ImageIcon iconThomas = FenetrePrincipal.getImageIcon("image/thomas petit.png");
		ImageIcon iconJohann = FenetrePrincipal.getImageIcon("image/johann petit.png");
		ImageIcon iconAli = FenetrePrincipal.getImageIcon("image/ali.png");
		ImageIcon iconGuillaume = FenetrePrincipal.getImageIcon("image/guillaume.png");
		ImageIcon iconJonathan = FenetrePrincipal.getImageIcon("image/jonathan.png");

		ImageIcon iconCombatNicolas = FenetrePrincipal.getImageIcon("image/nico petit 2.png");
		ImageIcon iconCombatPierre = FenetrePrincipal.getImageIcon("image/pierre petit 2.png");
		ImageIcon iconCombatYannick = FenetrePrincipal.getImageIcon("image/yannick petit 2.png");
		ImageIcon iconCombatThomas = FenetrePrincipal.getImageIcon("image/thomas petit 2.png");
		ImageIcon iconCombatJohann = FenetrePrincipal.getImageIcon("image/johann petit 2.png");
		ImageIcon iconCombatAli = FenetrePrincipal.getImageIcon("image/ali 2.png");
		ImageIcon iconCombatGuillaume = FenetrePrincipal.getImageIcon("image/guillaume 2.png");
		ImageIcon iconCombatJonathan = FenetrePrincipal.getImageIcon("image/jonathan 2.png");
		
		// Les messages de dieu d'arrivee de chaque perso
		String messageDieuJohann = ConfigurationManager.getProperties("message.dieu.johann");
		String messageDieuNicolas = ConfigurationManager.getProperties("message.dieu.nicolas");
		String messageDieuPierre = ConfigurationManager.getProperties("message.dieu.pierre");
		String messageDieuThomas = ConfigurationManager.getProperties("message.dieu.thomas");
		String messageDieuYannick = ConfigurationManager.getProperties("message.dieu.yannick");
		String messageDieuAli = ConfigurationManager.getProperties("message.dieu.ali");
		String messageDieuGuillaume = ConfigurationManager.getProperties("message.dieu.guillaume");
		String messageDieuJonathan = ConfigurationManager.getProperties("message.dieu.jonathan");
		
		String surnomJohann = ConfigurationManager.getProperties("surnom.principal.johann");
		String surnomNicolas = ConfigurationManager.getProperties("surnom.principal.nicolas");
		String surnomPierre = ConfigurationManager.getProperties("surnom.principal.pierre");
		String surnomThomas = ConfigurationManager.getProperties("surnom.principal.thomas");
		String surnomYannick = ConfigurationManager.getProperties("surnom.principal.yannick");
		String surnomAli = ConfigurationManager.getProperties("surnom.principal.ali");
		String surnomGuillaume = ConfigurationManager.getProperties("surnom.principal.guillaume");
		String surnomJonathan = ConfigurationManager.getProperties("surnom.principal.jonathan");
		
		String originesJohann = ConfigurationManager.getProperties("origines.johann");
		String originesNicolas = ConfigurationManager.getProperties("origines.nicolas");
		String originesPierre = ConfigurationManager.getProperties("origines.pierre");
		String originesThomas = ConfigurationManager.getProperties("origines.thomas");
		String originesYannick = ConfigurationManager.getProperties("origines.yannick");
		String originesAli = ConfigurationManager.getProperties("origines.ali");
		String originesGuillaume = ConfigurationManager.getProperties("origines.guillaume");
		String originesJonathan = ConfigurationManager.getProperties("origines.jonathan");
		
		// Musiques Johann
		// TODO 
		// principal : Retour vers le futur Theme
		// Son de clic : bruit de son retour vers le futur / de vomi
		// secondaire : Dance Attitude, Lady Gaga, Supermen Lovers,
		List<Musique> musiquesJohann = MusiqueManager.chargeMusiquesPerso("musique/personnage/johann", 1000);
		// TODO 
		// principal : JamesBond Theme
		// Son de clic : JamesBond sons
		// secondaire : Secteur A, Dre DRE, Snoop Dog, Eminem, Xzibit,  
		List<Musique> musiquesPierre = MusiqueManager.chargeMusiquesPerso("musique/personnage/pierre", 2000);
		// TODO 
		// principal : Warcraft 2 Theme
		// Son de clic : Voie de peon
		// secondaire : Funk, Black EYed Peas, 
		List<Musique> musiquesThomas = MusiqueManager.chargeMusiquesPerso("musique/personnage/thomas", 3000);
		// TODO 
		// principal : Matrix Theme
		// Son de clic : Matrix sons
		// secondaire : Carapitcho, Bailando, Drag Queen, Thriller, El Tiburon
		List<Musique> musiquesNicolas = MusiqueManager.chargeMusiquesPerso("musique/personnage/nicolas", 4000);
		// TODO 
		// principal : StarWars Theme
		// Son de clic : Laser star wars
		// secondaire : Nirvana, NickelBack, Radiohead, Coldplay, Placebo,  
		List<Musique> musiquesYannick = MusiqueManager.chargeMusiquesPerso("musique/personnage/yannick", 5000);
		// TODO 
		// principal : Le seigneur des anneaux Theme
		// Son de clic : Bruit de Morgul
		// secondaire : Mon vieu, 
		List<Musique> musiquesAli = MusiqueManager.chargeMusiquesPerso("musique/personnage/ali", 6000);
		// TODO 
		// principal : Indiana Jones Theme
		// Son de clic : Son de liquide qui remplit un verre / de serpent a sonette
		// secondaire : Camaro, Bouga, 
		List<Musique> musiquesGuillaume = MusiqueManager.chargeMusiquesPerso("musique/personnage/guillaume", 7000);
		// TODO 
		// principal : Le Parrain Theme
		// Son de clic : crissement de pneu
		// secondaire : Eve, DelaSoul,  
		List<Musique> musiquesJonathan = MusiqueManager.chargeMusiquesPerso("musique/personnage/jonathan", 8000);
		
		// TODO remettre new Competence(PersoPrenom.Johann, true) a false pour
		// competence debut de jeu
		PersonnagePrincipal johann = new PersonnagePrincipal(PersoNom.AVELINE, PersoPrenom.Johann, surnomJohann,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.JUNE, 13, 9, 0, 0), originesJohann, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconJohann, iconCombatJohann, new ArrayList<ImageIcon>(), Color.BLUE,
				actionCombatManager.getActionsCombat(PersoPrenom.Johann.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuJohann, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesJohann, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Johann, false), new Competence(PersoPrenom.Johann, true), false);
		PersonnagePrincipal nicolas = new PersonnagePrincipal(PersoNom.LOPEZ, PersoPrenom.Nicolas, surnomNicolas,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.SEPTEMBER, 7, 9, 0, 0), originesNicolas, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconNicolas, iconCombatNicolas, new ArrayList<ImageIcon>(), Color.YELLOW,
				actionCombatManager.getActionsCombat(PersoPrenom.Nicolas.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuNicolas, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesNicolas, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Nicolas, false), new Competence(PersoPrenom.Nicolas, true), false);
		PersonnagePrincipal pierre = new PersonnagePrincipal(PersoNom.SERMAIN, PersoPrenom.Pierre, surnomPierre,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.AUGUST, 4, 9, 0, 0), originesPierre, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconPierre, iconCombatPierre, new ArrayList<ImageIcon>(), Color.GREEN,
				actionCombatManager.getActionsCombat(PersoPrenom.Pierre.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuPierre, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesPierre, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Pierre, false), new Competence(PersoPrenom.Pierre, true), false);
		PersonnagePrincipal thomas = new PersonnagePrincipal(PersoNom.DARMOUNI, PersoPrenom.Thomas, surnomThomas,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.SEPTEMBER, 5, 9, 0, 0), originesThomas, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconThomas, iconCombatThomas, new ArrayList<ImageIcon>(), Color.RED,
				actionCombatManager.getActionsCombat(PersoPrenom.Thomas.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuThomas, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesThomas, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Thomas, false), new Competence(PersoPrenom.Thomas, true), false);
		PersonnagePrincipal yannick = new PersonnagePrincipal(PersoNom.BERCOT, PersoPrenom.Yannick, surnomYannick,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.APRIL, 14, 9, 0, 0), originesYannick, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconYannick, iconCombatYannick, new ArrayList<ImageIcon>(), Color.MAGENTA,
				actionCombatManager.getActionsCombat(PersoPrenom.Yannick.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuYannick, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesYannick, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Yannick, false), new Competence(PersoPrenom.Yannick, true), false);
		PersonnagePrincipal ali = new PersonnagePrincipal(PersoNom.CHAUDHRY, PersoPrenom.Ali, surnomAli,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.JULY, 1, 9, 0, 0), originesAli, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconAli, iconCombatAli, new ArrayList<ImageIcon>(), Color.PINK,
				actionCombatManager.getActionsCombat(PersoPrenom.Ali.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuAli, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesAli, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Ali, false), new Competence(PersoPrenom.Ali, true), false);
		PersonnagePrincipal guillaume = new PersonnagePrincipal(PersoNom.BURGUET, PersoPrenom.Guillaume, surnomGuillaume,
				new ArrayList<String>(), DateManager.genereUneDate(1982, Calendar.JANUARY, 11, 9, 0, 0), originesGuillaume, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconGuillaume, iconCombatGuillaume, new ArrayList<ImageIcon>(), Color.ORANGE,
				actionCombatManager.getActionsCombat(PersoPrenom.Guillaume.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuGuillaume, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesGuillaume, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Guillaume, false), new Competence(PersoPrenom.Guillaume, true), false);
		PersonnagePrincipal jonathan = new PersonnagePrincipal(PersoNom.RUSCITO, PersoPrenom.Jonathan, surnomJonathan,
				new ArrayList<String>(), DateManager.genereUneDate(1983, Calendar.MAY, 19, 9, 0, 0), originesJonathan, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				iconJonathan, iconCombatJonathan, new ArrayList<ImageIcon>(), Color.CYAN,
				actionCombatManager.getActionsCombat(PersoPrenom.Jonathan.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuJonathan, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesJonathan, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Jonathan, false), new Competence(PersoPrenom.Jonathan, true), false);

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
		PersonnageSecondaire jonathanMatignon = new PersonnageSecondaire("Jonathan", "Matignon");
		PersonnageSecondaire ludovicVandeville = new PersonnageSecondaire("Ludovic", "Vandeville");
		PersonnageSecondaire ludovicDasNeves = new PersonnageSecondaire("Ludovic", "Das neves");
		PersonnageSecondaire mickaelKaragoz = new PersonnageSecondaire("Mickael", "Karagoz");
		PersonnageSecondaire georgeCharpentier = new PersonnageSecondaire("George", "Charpentier");
		PersonnageSecondaire miguelDosSantos = new PersonnageSecondaire("Miguel", "Dos Santos");
		PersonnageSecondaire jonathanFlama = new PersonnageSecondaire("Jonathan", "Flama");
		PersonnageSecondaire benjaminBlondel = new PersonnageSecondaire("Benjamin", "Blondel");
		PersonnageSecondaire geoffreyMartino = new PersonnageSecondaire("Geoffrey", "Martino");
		
		PersonnageSecondaire pattyMartino = new PersonnageSecondaire("Patty", "Martino");
		PersonnageSecondaire barbaraStolic = new PersonnageSecondaire("Barbara", "Stolic");
		PersonnageSecondaire claireBB = new PersonnageSecondaire("Claire", "Blaque-Belair");
		PersonnageSecondaire claireJaquet = new PersonnageSecondaire("Claire", "Jaquet");
		PersonnageSecondaire jacquelineGuinet = new PersonnageSecondaire("Jacqueline", "Guinet");
		PersonnageSecondaire shanazRicard = new PersonnageSecondaire("Shanaz", "Ricard");
		PersonnageSecondaire priscillaRemy = new PersonnageSecondaire("Priscilla", "Remy");
		PersonnageSecondaire judithRosenkrantz = new PersonnageSecondaire("Judith", "Rosenkrantz");
		PersonnageSecondaire virginieIdjer = new PersonnageSecondaire("Virginie", "Idjer");
		PersonnageSecondaire sophieLemoulec = new PersonnageSecondaire("Sophie", "Lemoulec");

		personnagesSecondaires.add(barbaraStolic);

		// Chargement des personnages Ennemis
		personnagesEnnemis = new ArrayList<PersonnageEnnemi>();

		// Chargement des Boss
		personnagesBoss = new ArrayList<PersonnageBoss>();
		
		// TODO particularités/phrases par Boss		
		List<String> particularitesPhysique1 = new ArrayList<String>();
		List<String> particularitesPhysique2 = new ArrayList<String>();
		List<String> particularitesPhysique3 = new ArrayList<String>();
		List<String> particularitesPhysique4 = new ArrayList<String>();
		List<String> particularitesPhysique5 = new ArrayList<String>();
		List<String> particularitesPhysique6 = new ArrayList<String>();
		List<String> particularitesPhysique7 = new ArrayList<String>();
		List<String> particularitesPhysique8 = new ArrayList<String>();
		List<String> particularitesPhysique11 = new ArrayList<String>();
		List<String> particularitesPhysique12 = new ArrayList<String>();
		List<String> particularitesPhysique13 = new ArrayList<String>();
		List<String> particularitesPhysique14 = new ArrayList<String>();
		List<String> particularitesPhysique15 = new ArrayList<String>();
		
		List<String> particularitesSocial1 = new ArrayList<String>();
		List<String> particularitesSocial2 = new ArrayList<String>();
		List<String> particularitesSocial3 = new ArrayList<String>();
		List<String> particularitesSocial4 = new ArrayList<String>();
		List<String> particularitesSocial5 = new ArrayList<String>();
		List<String> particularitesSocial6 = new ArrayList<String>();
		List<String> particularitesSocial7 = new ArrayList<String>();
		List<String> particularitesSocial8 = new ArrayList<String>();
		List<String> particularitesSocial11 = new ArrayList<String>();
		List<String> particularitesSocial12 = new ArrayList<String>();
		List<String> particularitesSocial13 = new ArrayList<String>();
		List<String> particularitesSocial14 = new ArrayList<String>();
		List<String> particularitesSocial15 = new ArrayList<String>();

		// Phrase perso d'introduction de chaque Boss
		List<String> phrasesPerso1 = new ArrayList<String>();
		phrasesPerso1.add(ConfigurationManager.getProperties("boss.citation.1"));
		List<String> phrasesPerso2 = new ArrayList<String>();
		phrasesPerso2.add(ConfigurationManager.getProperties("boss.citation.2"));
		List<String> phrasesPerso3 = new ArrayList<String>();
		phrasesPerso3.add(ConfigurationManager.getProperties("boss.citation.3"));
		List<String> phrasesPerso4 = new ArrayList<String>();
		phrasesPerso4.add(ConfigurationManager.getProperties("boss.citation.4"));
		List<String> phrasesPerso5 = new ArrayList<String>();
		phrasesPerso5.add(ConfigurationManager.getProperties("boss.citation.5"));
		List<String> phrasesPerso6 = new ArrayList<String>();
		phrasesPerso6.add(ConfigurationManager.getProperties("boss.citation.6"));
		List<String> phrasesPerso7 = new ArrayList<String>();
		phrasesPerso7.add(ConfigurationManager.getProperties("boss.citation.7"));
		List<String> phrasesPerso8 = new ArrayList<String>();
		phrasesPerso8.add(ConfigurationManager.getProperties("boss.citation.8"));
		List<String> phrasesPerso11 = new ArrayList<String>();
		
		// Phrase perso d'introduction de chaque mini Boss ecole
		phrasesPerso11.add(ConfigurationManager.getProperties("boss.citation.11"));
		List<String> phrasesPerso12 = new ArrayList<String>();
		phrasesPerso12.add(ConfigurationManager.getProperties("boss.citation.12"));
		List<String> phrasesPerso13 = new ArrayList<String>();
		phrasesPerso13.add(ConfigurationManager.getProperties("boss.citation.13"));
		List<String> phrasesPerso14 = new ArrayList<String>();
		phrasesPerso14.add(ConfigurationManager.getProperties("boss.citation.14"));
		List<String> phrasesPerso15 = new ArrayList<String>();
		phrasesPerso15.add(ConfigurationManager.getProperties("boss.citation.15"));
		
		ImageIcon photoBoss1 = FenetrePrincipal.getImageIcon("image/boss/zinedine_zidane.png");
		ImageIcon photoBoss2 = FenetrePrincipal.getImageIcon("image/boss/lara_croft.png");
		ImageIcon photoBoss3 = FenetrePrincipal.getImageIcon("image/boss/dr_dre.png");
		ImageIcon photoBoss4 = FenetrePrincipal.getImageIcon("image/boss/adolph_hitler.png");
		ImageIcon photoBoss5 = FenetrePrincipal.getImageIcon("image/boss/anakin_skywalker.png");
		ImageIcon photoBoss6 = FenetrePrincipal.getImageIcon("image/boss/thriller.png");
		ImageIcon photoBoss7 = FenetrePrincipal.getImageIcon("image/boss/liquid_snake.png");
		ImageIcon photoBoss8 = FenetrePrincipal.getImageIcon("image/boss/arnaud.png");
		ImageIcon photoBoss11 = FenetrePrincipal.getImageIcon("image/miniboss/Chatelain.png");
		ImageIcon photoBoss12 = FenetrePrincipal.getImageIcon("image/miniboss/Dubois.png");
		ImageIcon photoBoss13 = FenetrePrincipal.getImageIcon("image/miniboss/Durand.png");
		ImageIcon photoBoss14 = FenetrePrincipal.getImageIcon("image/miniboss/Braquet.png");
		ImageIcon photoBoss15 = FenetrePrincipal.getImageIcon("image/miniboss/Bouchera.png");

		List<ImageIcon> photos1 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos2 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos3 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos4 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos5 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos6 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos7 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos8 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos11 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos12 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos13 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos14 = new ArrayList<ImageIcon>();
		List<ImageIcon> photos15 = new ArrayList<ImageIcon>();
		

		// TODO vie/mana/charge par Boss ??
		int vieMax = 1000;
		int manaMax = 200;
		int chargeMax = 10;

		if (difficultePartie == Difficulte.FACILE) {
			vieMax = 1500;
			manaMax = 50;
			chargeMax = 3;
		} else if (difficultePartie == Difficulte.NORMAL) {
			vieMax = 2000;
			manaMax = 100;
			chargeMax = 5;
		} else if (difficultePartie == Difficulte.DIFFICILE) {
			vieMax = 3000;
			manaMax = 150;
			chargeMax = 7;
		} else if (difficultePartie == Difficulte.HEROIQUE) {
			vieMax = 5000;
			manaMax = 200;
			chargeMax = 10;
		}

		// TODO mieux / a verifier (asList)
//		Set<PersoStat> stats = johann.getCompetence().getStats().keySet();
		Set<PersoStat> stats = new HashSet<PersoStat>(Arrays.asList(PersoStat.values()));
		List<PersoStat> statsParType = new ArrayList<PersoStat>(stats);
		List<PersoStat> statsParClasse = new ArrayList<PersoStat>(stats);
		
		// Choix des competences pour les BOSS par difficulte, type et classe
		Competence competence1 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence2 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence3 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence4 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence5 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence6 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence7 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence8 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence11 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence12 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence13 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence14 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		Competence competence15 = choixDesCompetences(difficultePartie, statsParType, statsParClasse);
		
		// ActionsCombat des BOSS
		List<ActionCombat> actionsCombat1 = actionCombatManager.getActionsCombat(BossNom.BOSS1.name());
		List<ActionCombat> actionsCombat2 = actionCombatManager.getActionsCombat(BossNom.BOSS2.name());
		List<ActionCombat> actionsCombat3 = actionCombatManager.getActionsCombat(BossNom.BOSS3.name());
		List<ActionCombat> actionsCombat4 = actionCombatManager.getActionsCombat(BossNom.BOSS4.name());
		List<ActionCombat> actionsCombat5 = actionCombatManager.getActionsCombat(BossNom.BOSS5.name());
		List<ActionCombat> actionsCombat6 = actionCombatManager.getActionsCombat(BossNom.BOSS6.name());
		List<ActionCombat> actionsCombat7 = actionCombatManager.getActionsCombat(BossNom.BOSS7.name());
		List<ActionCombat> actionsCombat8 = actionCombatManager.getActionsCombat(BossNom.BOSS8.name());
		List<ActionCombat> actionsCombat11 = actionCombatManager.getActionsCombat(BossNom.BOSS11.name());
		List<ActionCombat> actionsCombat12 = actionCombatManager.getActionsCombat(BossNom.BOSS12.name());
		List<ActionCombat> actionsCombat13 = actionCombatManager.getActionsCombat(BossNom.BOSS13.name());
		List<ActionCombat> actionsCombat14 = actionCombatManager.getActionsCombat(BossNom.BOSS14.name());
		List<ActionCombat> actionsCombat15 = actionCombatManager.getActionsCombat(BossNom.BOSS15.name());

		// Creation des MINI BOSS
		PersonnageBoss boss11 = new PersonnageBoss(BossNom.BOSS11.name(), BossNom.BOSS11.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique11, particularitesSocial11, phrasesPerso11, photoBoss11, photos11, actionsCombat11,
				competence11);

		PersonnageBoss boss12 = new PersonnageBoss(BossNom.BOSS12.name(), BossNom.BOSS12.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique12, particularitesSocial12, phrasesPerso12, photoBoss12, photos12, actionsCombat12,
				competence12);

		PersonnageBoss boss13 = new PersonnageBoss(BossNom.BOSS13.name(), BossNom.BOSS13.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique13, particularitesSocial13, phrasesPerso13, photoBoss13, photos13, actionsCombat13,
				competence13);

		PersonnageBoss boss14 = new PersonnageBoss(BossNom.BOSS14.name(), BossNom.BOSS14.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique14, particularitesSocial14, phrasesPerso14, photoBoss14, photos14, actionsCombat14,
				competence14);

		PersonnageBoss boss15 = new PersonnageBoss(BossNom.BOSS15.name(), BossNom.BOSS15.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique15, particularitesSocial15, phrasesPerso15, photoBoss15, photos15, actionsCombat15,
				competence15);
		
		// Creation des BOSS
		
		// BOSS YO
		PersonnageBoss boss1 = new PersonnageBoss(BossNom.BOSS1.name(), BossNom.BOSS1.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique1, particularitesSocial1, phrasesPerso1, photoBoss1, photos1, actionsCombat1,
				competence1);

		// BOSS NICO
		PersonnageBoss boss2 = new PersonnageBoss(BossNom.BOSS2.name(), BossNom.BOSS2.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique2, particularitesSocial2, phrasesPerso2, photoBoss2, photos2, actionsCombat2,
				competence2);

		// BOSS PIP
		PersonnageBoss boss3 = new PersonnageBoss(BossNom.BOSS3.name(), BossNom.BOSS3.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique3, particularitesSocial3, phrasesPerso3, photoBoss3, photos3, actionsCombat3,
				competence3);

		// BOSS TOM
		PersonnageBoss boss4 = new PersonnageBoss(BossNom.BOSS4.name(), BossNom.BOSS4.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique4, particularitesSocial4, phrasesPerso4, photoBoss4, photos4, actionsCombat4,
				competence4);

		// BOSS YA
		PersonnageBoss boss5 = new PersonnageBoss(BossNom.BOSS5.name(), BossNom.BOSS5.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique5, particularitesSocial5, phrasesPerso5, photoBoss5, photos5, actionsCombat5,
				competence5);

		// BOSS ALI
		PersonnageBoss boss6 = new PersonnageBoss(BossNom.BOSS6.name(), BossNom.BOSS6.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique6, particularitesSocial6, phrasesPerso6, photoBoss6, photos6, actionsCombat6,
				competence6);

		// BOSS GUY
		PersonnageBoss boss7 = new PersonnageBoss(BossNom.BOSS7.name(), BossNom.BOSS7.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique7, particularitesSocial7, phrasesPerso7, photoBoss7, photos7, actionsCombat7,
				competence7);

		// BOSS RUSS
		PersonnageBoss boss8 = new PersonnageBoss(BossNom.BOSS8.name(), BossNom.BOSS8.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique8, particularitesSocial8, phrasesPerso8, photoBoss8, photos8, actionsCombat8,
				competence8);
		
		
		personnagesBoss.add(boss1);
		personnagesBoss.add(boss2);
		personnagesBoss.add(boss3);
		personnagesBoss.add(boss4);
		personnagesBoss.add(boss5);
		personnagesBoss.add(boss6);
		personnagesBoss.add(boss7);
		personnagesBoss.add(boss8);
		personnagesBoss.add(boss11);
		personnagesBoss.add(boss12);
		personnagesBoss.add(boss13);
		personnagesBoss.add(boss14);
		personnagesBoss.add(boss15);
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
		// TODO Update competences si utilisé 
		return personnagesBoss;
	}

	public List<PersonnageEnnemi> getPersonnagesEnnemis() {
		return personnagesEnnemis;
	}

	public PersonnageBoss getPersonnageBossByNom(BossNom bossNom) {
		for (PersonnageBoss personnageBoss : personnagesBoss) {
			System.out.println("Nom : " + personnageBoss.getNom());
			System.out.println("Nom : " + bossNom.name());
			if (personnageBoss.getNom().equals(bossNom.getNom())) {
				// Update competences boss en fonction des stats des joueurs
				updateCompetences(personnageBoss);
				return personnageBoss;
			}
		}
		return null;
	}

	private void updateCompetences(Personnage personnage) {
		Set<PersoStat> stats = new HashSet<PersoStat>(Arrays.asList(PersoStat.values()));
		List<PersoStat> statsParType = new ArrayList<PersoStat>(stats);
		List<PersoStat> statsParClasse = new ArrayList<PersoStat>(stats);
		personnage.setCompetence(choixDesCompetences(difficulte, statsParType, statsParClasse));
	}

	public PersonnageEnnemi createPersonnageEnnemi(Mission mission, int niveauSorts, PersoClasse classe) {

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

			// Random des images par type
			File fileGitan = new File(FenetrePrincipal.getURL("image/ennemi/gitan/").getPath());
			String[] pathsGitan = fileGitan.list();
			imagePath = "image/ennemi/gitan/" + randomPhotoEnnemi(pathsGitan);
			
			// Random des noms des ennemis
			String nomsGitan = ConfigurationManager.getProperties("ennemi.noms.gitan");
			String[] nomsGitanTab = nomsGitan.split(",");
			String nomGitanRandom = nomsGitanTab[RandomManager.random(0, nomsGitanTab.length-1)];
			nom = nomGitanRandom + " (" + classe.name() + ")";
			phrasesPerso.add("Hey Gadjo!");
			phrasesPerso.add("Mange tes maures!");
			phrasesPerso.add("Ca c'est mon cousin! Viens mon cousin!");
			phrasesPerso.add("T'inquietes pas que je sais l'en faire du vélo mon copain!");
			phrasesPerso.add("J'te met un coup d'botte dans les couilles, tu décolles jusqu'à la lune!");
			phrasesPerso.add("J'ai pris v'la l'pavée!");
			particularitesPhysique.add("Parle bizzarement en phonétique.");
			particularitesSocial.add("Ne sait ni lire, ni ecrire.");
			particularitesSocial.add("Nomade.");
			particularitesSocial.add("Se marie qu'avec des gitans.");
			particularitesSocial.add("Appelle les autres gitans : mon cousin.");
		}
		// ARABES
		else if (mission.getTypeEnnemis() == EnnemiType.ARABES) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.TECHNIQUE);
			statsParType.add(PersoStat.RAPIDITE);
			statsParType.add(PersoStat.NERVOSITE);

			// Random des images par type
			File fileArabe = new File(FenetrePrincipal.getURL("image/ennemi/arabe/").getPath());
			String[] pathsArabe = fileArabe.list();
			imagePath = "image/ennemi/arabe/" + randomPhotoEnnemi(pathsArabe);
			
			// Random des noms des ennemis
			String nomsArabe = ConfigurationManager.getProperties("ennemi.noms.arabe");
			String[] nomsArabeTab = nomsArabe.split(",");
			String nomArabeRandom = nomsArabeTab[RandomManager.random(0, nomsArabeTab.length-1)];
			nom = nomArabeRandom + " (" + classe.name() + ")";
			phrasesPerso.add("Wesh ma gueule!");
			phrasesPerso.add("Meskine!");
			phrasesPerso.add("Wesh, t'as une garette-ci?");
			phrasesPerso.add("Hey Mademoiselle! Vous êtes trop charmante!");
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
			
			// Random des images par type
			File fileNoir = new File(FenetrePrincipal.getURL("image/ennemi/noir/").getPath());
			String[] pathsNoir = fileNoir.list();
			imagePath = "image/ennemi/noir/" + randomPhotoEnnemi(pathsNoir);
			
			// Random des noms des ennemis
			String nomsNoir = ConfigurationManager.getProperties("ennemi.noms.noir");
			String[] nomsNoirTab = nomsNoir.split(",");
			String nomNoirRandom = nomsNoirTab[RandomManager.random(0, nomsNoirTab.length-1)];
			nom = nomNoirRandom + " (" + classe.name() + ")";
			phrasesPerso.add("Hey Garçon!");
			particularitesPhysique.add("Tchip");
			particularitesPhysique.add(
					"A le rythme dans la peau, une grosse bite, sent fort et possede une piste d'athletisme dans son jardin. (M.Delneuf)");
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

			// Random des images par type
			File fileHandicape = new File(FenetrePrincipal.getURL("image/ennemi/handicape/").getPath());
			String[] pathsHandicape = fileHandicape.list();
			imagePath = "image/ennemi/handicape/" + randomPhotoEnnemi(pathsHandicape);
			
			// Random des noms des ennemis
			String nomsHandicape = ConfigurationManager.getProperties("ennemi.noms.handicape");
			String[] nomsHandicapeTab = nomsHandicape.split(",");
			String nomHandicapeRandom = nomsHandicapeTab[RandomManager.random(0, nomsHandicapeTab.length-1)];
			nom = nomHandicapeRandom + " (" + classe.name() + ")";
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
		// niveau de base (1,3,6,10) du sort de l'ennemi (progression de la difficulte)
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
		int vieMax;
		int manaMax;
		int chargeMax;

		// Choix des competences par difficulte, type et classe
		Competence competence = choixDesCompetences(mission.getDifficulty(), statsParType, statsParClasse);

		// Vie Mana Charge
		vieMax = competence.getEndurance() * 10;
		manaMax = competence.getIntelligence();
		chargeMax = competence.getNervosite() / 20;

		PersonnageEnnemi ennemi = new PersonnageEnnemi(nom, nom, vieMax, manaMax, chargeMax, particularitesPhysique,
				particularitesSocial, phrasesPerso, photoPrincipal, photos, actionsCombat, mission.getTypeEnnemis(),
				competence);

		return ennemi;
	}

	private String randomPhotoEnnemi(String[] paths) {
		String randomPhotoPath = paths[RandomManager.random(0, paths.length -1)];
		System.out.println("RandomPhotoPath : " + randomPhotoPath);
		return randomPhotoPath;
	}

	private Competence choixDesCompetences(Difficulte difficulte, List<PersoStat> statsParType,
			List<PersoStat> statsParClasse) {
		
		// TODO cas particulier des boss
		

		int valeurParDifficulte = 25;
		Competence competence = null;
		
		// TODO virer valeurParDifficulte ??? Tout a 25 ?

		competence = new Competence(25);
		if (difficulte == Difficulte.FACILE) {
			valeurParDifficulte = 25;
		} else if (difficulte == Difficulte.NORMAL) {
			valeurParDifficulte = 50;
		} else if (difficulte == Difficulte.DIFFICILE) {
			valeurParDifficulte = 75;
		} else if (difficulte == Difficulte.HEROIQUE) {
			valeurParDifficulte = 100;
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
			if (stats.get(statParType) < valeurParDifficulte) {
				stats.put(statParType, valeurParDifficulte);
			}
		}
		// Meilleurs stats par classe
		for (PersoStat statParClasse : statsParClasse) {
			int valeurStatParClasse = getBestStatPersoVivant(statParClasse);
			if (stats.get(statParClasse) < valeurStatParClasse) {
				stats.put(statParClasse, valeurStatParClasse);
			}
			if (stats.get(statParClasse) < valeurParDifficulte) {
				stats.put(statParClasse, valeurParDifficulte);
			}
		}
		return competence;
	}

	public List<PersonnagePrincipal> getPersoVivants() {
		List<PersonnagePrincipal> persosVivants = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			if (!personnage.isMort() && personnage.isDejaPresente()) {
				persosVivants.add(personnage);
			}
		}
		return persosVivants;
	}
	

	public List<PersonnagePrincipal> getPersoDejaPresentes() {
		List<PersonnagePrincipal> persosDejaPresentes = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			if (personnage.isDejaPresente()) {
				persosDejaPresentes.add(personnage);
			}
		}
		return persosDejaPresentes;
	}
	
	public List<PersoPrenom> getPersoPrenomDejaPresentes() {
		List<PersoPrenom> persosPrenomDejaPresentes = new ArrayList<PersoPrenom>();
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			if (personnage.isDejaPresente()) {
				persosPrenomDejaPresentes.add(personnage.getPrenomPerso());
			}
		}
		return persosPrenomDejaPresentes;
	}

	
	public List<PersonnagePrincipal> getPersoVivantsEtDejaPresentes() {
		List<PersonnagePrincipal> persosVivantsEtDejaPresentes = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			if (!personnage.isMort() && personnage.isDejaPresente()) {
				persosVivantsEtDejaPresentes.add(personnage);
			}
		}
		return persosVivantsEtDejaPresentes;
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
			for (ActionCombat action : personnage.getActionsCombatDisponibles()) {
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

	public PersoPrenom getPersonnagePrincipal() {
		return personnagePrincipal;
	}

	public void setPersonnagePrincipal(PersoPrenom personnagePrincipal) {
		this.personnagePrincipal = personnagePrincipal;
	}

	public void regenerationNuit() {
		//System.out.println("Regeneration nuit");
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			if (personnage.isMort()) {
				// On ressucite les morts
				personnage.setMort(false);
			}
			// Recalcul des stats en fonction des competences
			personnage.setVieMax(personnage.getCompetence().getEndurance()*10);
			personnage.setVie(personnage.getVieMax());
			personnage.setManaMax(personnage.getCompetence().getIntelligence());
			personnage.setMana(personnage.getManaMax());
			personnage.setBouclier(0);
			// TODO protection si item de defense
			personnage.setNombreCharge(0);
			personnage.setNombreChargeMax(personnage.getCompetence().getNervosite()/20);
			// Inutile normalement
			personnage.getAuras().clear();
			
			// Et tout le monde retourne a la base
			personnage.setLocation(new Location(personnage.getDomicile(), personnage.getDomicile().getPosition()));
		}
	}

}

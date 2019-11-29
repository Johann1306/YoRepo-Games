package core;

import java.awt.Color;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import core.configuration.Constante;
import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.drogue.Drogue;
import modele.item.drogue.DrogueClasse;
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

	private List<PersonnageSecondaire> adversairesEcole;
	private List<PersonnageSecondaire> adversairesTerrainSamir;
	private List<PersonnageSecondaire> adversairesTerrainGitan;
	private List<PersonnageSecondaire> adversairesTerrainBoulets;
	private List<PersonnageSecondaire> adversairesChellesFred;
	private List<PersonnageSecondaire> adversairesChellesGiani;
	private List<PersonnageSecondaire> adversairesNoisyHakim;
	private List<PersonnageSecondaire> adversairesNoisyBene;
	private List<PersonnageSecondaire> adversairesNoisyTom;
	
	private static List<Integer> numsEnnemi = new ArrayList<>();

	public void initialise(ActionCombatManager actionCombatManager, Difficulte difficultePartie) {

		leGroupe = new Groupe();
		difficulte = difficultePartie;

		// Chargement des personnages Principaux

		List<String> photoPathsNicolas = new ArrayList<>(); 
		photoPathsNicolas.add("image/nico petit.png");
		ImageIcon iconNicolas = FenetrePrincipal.getImageIcon(photoPathsNicolas.get(0));
		
		List<String> photoPathsPierre = new ArrayList<>(); 
		photoPathsPierre.add("image/pierre petit.png");
		ImageIcon iconPierre = FenetrePrincipal.getImageIcon(photoPathsPierre.get(0));
		
		List<String> photoPathsYannick = new ArrayList<>(); 
		photoPathsYannick.add("image/yannick petit.png");
		ImageIcon iconYannick = FenetrePrincipal.getImageIcon(photoPathsYannick.get(0));
		
		List<String> photoPathsThomas = new ArrayList<>(); 
		photoPathsThomas.add("image/thomas petit.png");
		ImageIcon iconThomas = FenetrePrincipal.getImageIcon(photoPathsThomas.get(0));
		
		List<String> photoPathsJohann = new ArrayList<>(); 
		photoPathsJohann.add("image/johann petit.png");
		ImageIcon iconJohann = FenetrePrincipal.getImageIcon(photoPathsJohann.get(0));
		
		List<String> photoPathsAli = new ArrayList<>(); 
		photoPathsAli.add("image/ali.png");
		ImageIcon iconAli = FenetrePrincipal.getImageIcon(photoPathsAli.get(0));
		
		List<String> photoPathsGuillaume = new ArrayList<>(); 
		photoPathsGuillaume.add("image/guillaume.png");
		ImageIcon iconGuillaume = FenetrePrincipal.getImageIcon(photoPathsGuillaume.get(0));
		
		List<String> photoPathsJonathan = new ArrayList<>(); 
		photoPathsJonathan.add("image/jonathan.png");
		ImageIcon iconJonathan = FenetrePrincipal.getImageIcon(photoPathsJonathan.get(0));
		

		ImageIcon iconCombatNicolas = FenetrePrincipal.getImageIcon("image/nico petit 2.png");
		ImageIcon iconCombatPierre = FenetrePrincipal.getImageIcon("image/pierre petit 2.png");
		ImageIcon iconCombatYannick = FenetrePrincipal.getImageIcon("image/yannick petit 2.png");
		ImageIcon iconCombatThomas = FenetrePrincipal.getImageIcon("image/thomas petit 2.png");
		ImageIcon iconCombatJohann = FenetrePrincipal.getImageIcon("image/johann petit 2.png");
		ImageIcon iconCombatAli = FenetrePrincipal.getImageIcon("image/ali 2.png");
		ImageIcon iconCombatGuillaume = FenetrePrincipal.getImageIcon("image/guillaume 2.png");
		ImageIcon iconCombatJonathan = FenetrePrincipal.getImageIcon("image/jonathan 2.png");
		
		ImageIcon photoPrincipal230 = FenetrePrincipal.getImageIcon("image/pnj/omar.png");
		ImageIcon photoPrincipal240 = FenetrePrincipal.getImageIcon("image/pnj/jafar.png");
		ImageIcon photoPrincipal250 = FenetrePrincipal.getImageIcon("image/pnj/jawad.png");
		ImageIcon photoPrincipal260 = FenetrePrincipal.getImageIcon("image/pnj/banania.png");
		
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
		List<Musique> musiquesJohann = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/johann", 1000);
		// TODO 
		// principal : JamesBond Theme
		// Son de clic : JamesBond sons
		// secondaire : Secteur A, Dre DRE, Snoop Dog, Eminem, Xzibit,  
		List<Musique> musiquesPierre = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/pierre", 2000);
		// TODO 
		// principal : Warcraft 2 Theme
		// Son de clic : Voie de peon
		// secondaire : Funk, Black EYed Peas, 
		List<Musique> musiquesThomas = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/thomas", 3000);
		// TODO 
		// principal : Matrix Theme
		// Son de clic : Matrix sons
		// secondaire : Carapitcho, Bailando, Drag Queen, Thriller, El Tiburon
		List<Musique> musiquesNicolas = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/nicolas", 4000);
		// TODO 
		// principal : StarWars Theme
		// Son de clic : Laser star wars
		// secondaire : Nirvana, NickelBack, Radiohead, Coldplay, Placebo,  
		List<Musique> musiquesYannick = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/yannick", 5000);
		// TODO 
		// principal : Le seigneur des anneaux Theme
		// Son de clic : Bruit de Morgul
		// secondaire : Mon vieu, 
		List<Musique> musiquesAli = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/ali", 6000);
		// TODO 
		// principal : Indiana Jones Theme
		// Son de clic : Son de liquide qui remplit un verre / de serpent a sonette
		// secondaire : Camaro, Bouga, 
		List<Musique> musiquesGuillaume = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/guillaume", 7000);
		// TODO 
		// principal : Le Parrain Theme
		// Son de clic : crissement de pneu
		// secondaire : Eve, DelaSoul,  
		List<Musique> musiquesJonathan = MusiqueManager.chargeMusiquesParRepertoire("musique/personnage/jonathan", 8000);
		
		// TODO remettre new Competence(PersoPrenom.Johann, true) a false pour
		// competence debut de jeu
		PersonnagePrincipal johann = new PersonnagePrincipal(PersoNom.AVELINE, PersoPrenom.Johann, surnomJohann,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.JUNE, 13, 9, 0, 0), originesJohann, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsJohann, iconJohann, iconCombatJohann, new ArrayList<ImageIcon>(), Color.BLUE,
				actionCombatManager.getActionsCombat(PersoPrenom.Johann.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuJohann, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesJohann, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Johann, false), new Competence(PersoPrenom.Johann, true), false);
		PersonnagePrincipal nicolas = new PersonnagePrincipal(PersoNom.LOPEZ, PersoPrenom.Nicolas, surnomNicolas,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.SEPTEMBER, 7, 9, 0, 0), originesNicolas, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsNicolas, iconNicolas, iconCombatNicolas, new ArrayList<ImageIcon>(), Color.YELLOW,
				actionCombatManager.getActionsCombat(PersoPrenom.Nicolas.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuNicolas, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesNicolas, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Nicolas, false), new Competence(PersoPrenom.Nicolas, true), false);
		PersonnagePrincipal pierre = new PersonnagePrincipal(PersoNom.SERMAIN, PersoPrenom.Pierre, surnomPierre,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.AUGUST, 4, 9, 0, 0), originesPierre, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsPierre, iconPierre, iconCombatPierre, new ArrayList<ImageIcon>(), Color.GREEN,
				actionCombatManager.getActionsCombat(PersoPrenom.Pierre.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuPierre, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesPierre, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Pierre, false), new Competence(PersoPrenom.Pierre, true), false);
		PersonnagePrincipal thomas = new PersonnagePrincipal(PersoNom.DARMOUNI, PersoPrenom.Thomas, surnomThomas,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.SEPTEMBER, 5, 9, 0, 0), originesThomas, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsThomas, iconThomas, iconCombatThomas, new ArrayList<ImageIcon>(), Color.RED,
				actionCombatManager.getActionsCombat(PersoPrenom.Thomas.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuThomas, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesThomas, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Thomas, false), new Competence(PersoPrenom.Thomas, true), false);
		PersonnagePrincipal yannick = new PersonnagePrincipal(PersoNom.BERCOT, PersoPrenom.Yannick, surnomYannick,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.APRIL, 14, 9, 0, 0), originesYannick, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsYannick, iconYannick, iconCombatYannick, new ArrayList<ImageIcon>(), Color.MAGENTA,
				actionCombatManager.getActionsCombat(PersoPrenom.Yannick.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuYannick, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesYannick, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Yannick, false), new Competence(PersoPrenom.Yannick, true), false);
		PersonnagePrincipal ali = new PersonnagePrincipal(PersoNom.CHAUDHRY, PersoPrenom.Ali, surnomAli,
				new ArrayList<String>(), DateManager.genereUneDate(1984, Calendar.JULY, 1, 9, 0, 0), originesAli, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsAli, iconAli, iconCombatAli, new ArrayList<ImageIcon>(), Color.PINK,
				actionCombatManager.getActionsCombat(PersoPrenom.Ali.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuAli, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesAli, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Ali, false), new Competence(PersoPrenom.Ali, true), false);
		PersonnagePrincipal guillaume = new PersonnagePrincipal(PersoNom.BURGUET, PersoPrenom.Guillaume, surnomGuillaume,
				new ArrayList<String>(), DateManager.genereUneDate(1982, Calendar.JANUARY, 11, 9, 0, 0), originesGuillaume, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsGuillaume, iconGuillaume, iconCombatGuillaume, new ArrayList<ImageIcon>(), Color.ORANGE,
				actionCombatManager.getActionsCombat(PersoPrenom.Guillaume.name()), new ArrayList<Objectif>(),
				new ArrayList<MomentCle>(), messageDieuGuillaume, new ArrayList<PersonnageEnnemi>(), new ArrayList<PersonnageSecondaire>(),
				new ArrayList<Son>(), musiquesGuillaume, new HashMap<Item, Integer>(), null,
				new Competence(PersoPrenom.Guillaume, false), new Competence(PersoPrenom.Guillaume, true), false);
		PersonnagePrincipal jonathan = new PersonnagePrincipal(PersoNom.RUSCITO, PersoPrenom.Jonathan, surnomJonathan,
				new ArrayList<String>(), DateManager.genereUneDate(1983, Calendar.MAY, 19, 9, 0, 0), originesJonathan, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
				photoPathsJonathan, iconJonathan, iconCombatJonathan, new ArrayList<ImageIcon>(), Color.CYAN,
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

		PersonnageSecondaire omarChefre = new PersonnageSecondaire("Omar", "Chefre");
		omarChefre.setPhotoPrincipal(photoPrincipal230);
		List<String> phrasesPerso230 = new ArrayList<>();
		phrasesPerso230.add("Bonjour chef!");
		phrasesPerso230.add("Repasses nous voir! Les stocks sont renouveles tous les mois!");
		omarChefre.setPhrasesPerso(phrasesPerso230);
		PersonnageSecondaire hassanCehef = new PersonnageSecondaire("Hassan", "Cehef");
		hassanCehef.setPhotoPrincipal(photoPrincipal240);
		List<String> phrasesPerso240 = new ArrayList<>();
		phrasesPerso240.add("Bienvenue mon ami!");
		phrasesPerso240.add("Reviens vite! J'ai de nouveaux trucs a vendre tous les mois!");
		hassanCehef.setPhrasesPerso(phrasesPerso240);
		PersonnageSecondaire omarIjuana = new PersonnageSecondaire("Omar", "Ijuana");
		omarIjuana.setPhotoPrincipal(photoPrincipal250);
		List<String> phrasesPerso250 = new ArrayList<>();
		phrasesPerso250.add("Wesh");
		phrasesPerso250.add("Si tu te fais choper par les condes, tu dis pas que c'est moi!");
		omarIjuana.setPhrasesPerso(phrasesPerso250);
		PersonnageSecondaire bencoBamboulaChocolat = new PersonnageSecondaire("Benco Bamboula", "Banania");
		bencoBamboulaChocolat.setPhotoPrincipal(photoPrincipal260);
		List<String> phrasesPerso260 = new ArrayList<>();
		phrasesPerso260.add("Bien ou bien ?");
		phrasesPerso260.add("Allez bouge de la avant que je te casses tes dents!");
		bencoBamboulaChocolat.setPhrasesPerso(phrasesPerso260);

		// TODO integrer les persos secondaires
		
		// FOOT a l'ecole (5v5) Team Cancres de l'ecole
		// Joueurs : 	- "Miguel", "Dos Santos"
		//				- "Jonathan", "Matignon"
		//				- "Ludovic", "Vandeville"
		//				- "Geoffrey", "Martino"
		//				- "Mickael", "Karagoz"

		//				- "George", "Charpentier"
		//				- "Jonathan", "Flama"
		//				- "Benjamin", "Blondel"
		

		// FOOT au terrain (5v5 6v6 7v7 ou 8v8) Team Samir / Team Gitans / Team Boulets
		// Joueurs : 	- "Samir"
		//				- "Frere de Samir"
		//				- "Cousin de Samir 1"
		//				- "Cousin de Samir 2"
		
		//				- "Petit Gitan"
		//				- "Cousin du petit gitan 1"
		//				- "Cousin du petit gitan 2"

		//				- "Renaud"
		//				- "Marc"
		//				- "Tristan"

		// FOOT a Chelles (7v7 ou 8v8) Team Fred / Team Giani
		// Joueurs : 	- "Fred"
		//				- "Pote de Fred bourré"
		//				- "Pote de Fred 1"
		//				- "Pote de Fred 2"

		//				- "Giani"
		//				- "Frere de Giani"
		//				- "Pote de Giani 1"
		//				- "Pote de Giani 2"


		// FOOT a Noisy (5v5 ou 6v6) Team Hakim / Team Bene / Team Thomas
		// Joueurs : 	- "Hakim"
		//				- "Ryhad"
		//				- "Frere d'Hakim"
		//				- "Pote d'Hakim 1"
		//				- "Pote d'Hakim 2"

		//				- "Bene"
		//				- "Yaya"
		//				- "Dridri"
		//				- "Costi"
		//				- "Alessandro"
		//				- "Maxxxou"
		//				- "PV"
		//				- "Pote de Bene 1"
		//				- "Pote de Bene 2"
				
		//				- "Pote de Thomas 1"
		//				- "Pote de Thomas 2"
		
		
		// Adversaires Ecole
		PersonnageSecondaire jonathanMatignon = new PersonnageSecondaire("Jonathan", "Matignon");
		PersonnageSecondaire ludovicVandeville = new PersonnageSecondaire("Ludovic", "Vandeville");
		PersonnageSecondaire mickaelKaragoz = new PersonnageSecondaire("Mickael", "Karagoz");
		PersonnageSecondaire georgeCharpentier = new PersonnageSecondaire("George", "Charpentier");
		PersonnageSecondaire miguelDosSantos = new PersonnageSecondaire("Miguel", "Dos Santos");
		PersonnageSecondaire jonathanFlama = new PersonnageSecondaire("Jonathan", "Flama");
		PersonnageSecondaire benjaminBlondel = new PersonnageSecondaire("Benjamin", "Blondel");
		PersonnageSecondaire geoffreyMartino = new PersonnageSecondaire("Geoffrey", "Martino");
		
		adversairesEcole = new ArrayList<>();
		adversairesEcole.add(miguelDosSantos);
		adversairesEcole.add(jonathanMatignon);
		adversairesEcole.add(ludovicVandeville);
		adversairesEcole.add(mickaelKaragoz);
		adversairesEcole.add(georgeCharpentier);
		adversairesEcole.add(jonathanFlama);
		adversairesEcole.add(benjaminBlondel);
		adversairesEcole.add(geoffreyMartino);

		// Adversaires Terrain
		PersonnageSecondaire samir = new PersonnageSecondaire("Samir", "Karchaoui");
		PersonnageSecondaire frereSamir1 = new PersonnageSecondaire("Frère de Samir 1", "");
		PersonnageSecondaire frereSamir2 = new PersonnageSecondaire("Frère de Samir 2", "");
		PersonnageSecondaire cousinSamir1 = new PersonnageSecondaire("Cousin de Samir 1", "");
		PersonnageSecondaire gitan = new PersonnageSecondaire("Le ptit gitan", "Monkouzin");
		PersonnageSecondaire cousinGitan1 = new PersonnageSecondaire("Le cousin du ptit gitan 1", "");
		PersonnageSecondaire cousinGitan2 = new PersonnageSecondaire("Le cousin du ptit gitan 2", "");
		PersonnageSecondaire cousinGitan3 = new PersonnageSecondaire("Le cousin du ptit gitan 3", "");
		PersonnageSecondaire marc = new PersonnageSecondaire("Marc", "Bastien");
		PersonnageSecondaire tristan = new PersonnageSecondaire("Tristan", "JeSaisPlus");
		PersonnageSecondaire renault = new PersonnageSecondaire("Renault", "JeSaisPlus");
		
		adversairesTerrainSamir = new ArrayList<>();
		adversairesTerrainSamir.add(samir);
		adversairesTerrainSamir.add(frereSamir1);
		adversairesTerrainSamir.add(frereSamir2);
		adversairesTerrainSamir.add(cousinSamir1);
		adversairesTerrainSamir.add(gitan);
		adversairesTerrainSamir.add(cousinGitan1);
		adversairesTerrainSamir.add(marc);
		adversairesTerrainSamir.add(tristan);

		adversairesTerrainGitan = new ArrayList<>();
		adversairesTerrainGitan.add(gitan);
		adversairesTerrainGitan.add(cousinGitan1);
		adversairesTerrainGitan.add(cousinGitan2);
		adversairesTerrainGitan.add(cousinGitan3);
		adversairesTerrainGitan.add(samir);
		adversairesTerrainGitan.add(frereSamir1);
		adversairesTerrainGitan.add(frereSamir2);
		adversairesTerrainGitan.add(cousinSamir1);
		
		adversairesTerrainBoulets = new ArrayList<>();
		adversairesTerrainBoulets.add(marc);
		adversairesTerrainBoulets.add(tristan);
		adversairesTerrainBoulets.add(renault);
		adversairesTerrainBoulets.add(samir);
		adversairesTerrainBoulets.add(gitan);
		adversairesTerrainBoulets.add(frereSamir1);
		adversairesTerrainBoulets.add(cousinSamir1);
		adversairesTerrainBoulets.add(frereSamir2);

		
		// Adversaires Chelles
		PersonnageSecondaire fred = new PersonnageSecondaire("Frederic", "Darmouni");
		PersonnageSecondaire poteDeFred1 = new PersonnageSecondaire("Pote de Fred bourré", "");
		PersonnageSecondaire poteDeFred2 = new PersonnageSecondaire("Pote de Fred 1", "");
		PersonnageSecondaire poteDeFred3 = new PersonnageSecondaire("Pote de Fred 2", "");
		PersonnageSecondaire poteDeFred4 = new PersonnageSecondaire("Pote de Fred 3", "");
		PersonnageSecondaire giani = new PersonnageSecondaire("Giani", "Le Rital");
		PersonnageSecondaire frereDeGiani = new PersonnageSecondaire("Frère de Giani", "");
		PersonnageSecondaire poteDeGiani1 = new PersonnageSecondaire("Pote de Giani 1", "");
		PersonnageSecondaire poteDeGiani2 = new PersonnageSecondaire("Pote de Giani 2", "");
		
		adversairesChellesFred = new ArrayList<>();
		adversairesChellesFred.add(fred);
		adversairesChellesFred.add(poteDeFred1);
		adversairesChellesFred.add(poteDeFred2);
		adversairesChellesFred.add(poteDeFred3);
		adversairesChellesFred.add(poteDeFred4);
		adversairesChellesFred.add(samir);
		adversairesChellesFred.add(frereSamir1);
		adversairesChellesFred.add(frereSamir2);
		adversairesChellesFred.add(cousinSamir1);

		adversairesChellesGiani = new ArrayList<>();
		adversairesChellesGiani.add(giani);
		adversairesChellesGiani.add(frereDeGiani);
		adversairesChellesGiani.add(poteDeGiani1);
		adversairesChellesGiani.add(poteDeGiani2);
		adversairesChellesGiani.add(fred);
		adversairesChellesGiani.add(poteDeFred1);
		adversairesChellesGiani.add(samir);
		adversairesChellesGiani.add(frereSamir1);
		
		// Adversaires Noisy
		PersonnageSecondaire hakim = new PersonnageSecondaire("Hakim", "Guenineche");
		PersonnageSecondaire frereHakim = new PersonnageSecondaire("Frère d'Hakim", "");
		PersonnageSecondaire ryhad = new PersonnageSecondaire("Ryhad", "Amani");
		PersonnageSecondaire poteHakim1 = new PersonnageSecondaire("Pote d'Hakim 1", "");
		PersonnageSecondaire poteHakim2 = new PersonnageSecondaire("Pote d'Hakim 2", "");
		PersonnageSecondaire poteHakim3 = new PersonnageSecondaire("Pote d'Hakim 3", "");
		PersonnageSecondaire poteHakim4 = new PersonnageSecondaire("Pote d'Hakim 4", "");
		
		PersonnageSecondaire bene = new PersonnageSecondaire("Benoit", "Salidot");
		PersonnageSecondaire dridri = new PersonnageSecondaire("Adrian", "Salmeron");
		PersonnageSecondaire costi = new PersonnageSecondaire("Cedric", "Heustache");
		PersonnageSecondaire yaya = new PersonnageSecondaire("Yacine", "Amara");
		PersonnageSecondaire alessandro = new PersonnageSecondaire("Alessandro", "");
		PersonnageSecondaire maxou = new PersonnageSecondaire("Maxime", "Clement");
		PersonnageSecondaire pv = new PersonnageSecondaire("Pierre-Vincent", "Jacquier");
		PersonnageSecondaire poteBene1 = new PersonnageSecondaire("Pote de Bene 1", "");
		PersonnageSecondaire poteBene2 = new PersonnageSecondaire("Pote de Bene 2", "");

		PersonnageSecondaire poteDeTom1 = new PersonnageSecondaire("Pote de Tom 1", "");
		PersonnageSecondaire poteDeTom2 = new PersonnageSecondaire("Pote de Tom 2", "");
		PersonnageSecondaire poteDeTom3 = new PersonnageSecondaire("Pote de Tom 3", "");
		PersonnageSecondaire poteDeTom4 = new PersonnageSecondaire("Pote de Tom 4", "");
		PersonnageSecondaire poteDeTom5 = new PersonnageSecondaire("Pote de Tom 5", "");
		PersonnageSecondaire poteDeTom6 = new PersonnageSecondaire("Pote de Tom 6", "");
		
		adversairesNoisyHakim = new ArrayList<>();
		adversairesNoisyHakim.add(hakim);
		adversairesNoisyHakim.add(frereHakim);
		adversairesNoisyHakim.add(ryhad);
		adversairesNoisyHakim.add(poteHakim1);
		adversairesNoisyHakim.add(poteHakim2);
		adversairesNoisyHakim.add(poteHakim3);
		adversairesNoisyHakim.add(poteHakim4);

		adversairesNoisyBene = new ArrayList<>();
		adversairesNoisyBene.add(bene);
		adversairesNoisyBene.add(dridri);
		adversairesNoisyBene.add(yaya);
		adversairesNoisyBene.add(costi);
		adversairesNoisyBene.add(alessandro);
		adversairesNoisyBene.add(maxou);
		adversairesNoisyBene.add(pv);
		adversairesNoisyBene.add(poteBene1);
		adversairesNoisyBene.add(poteBene2);

		adversairesNoisyTom = new ArrayList<>();
		adversairesNoisyTom.add(poteDeTom1);
		adversairesNoisyTom.add(poteDeTom2);
		adversairesNoisyTom.add(poteDeTom3);
		adversairesNoisyTom.add(poteDeTom4);
		adversairesNoisyTom.add(poteDeTom5);
		adversairesNoisyTom.add(poteDeTom6);
		
//		PersonnageSecondaire pattyMartino = new PersonnageSecondaire("Patty", "Martino");
//		PersonnageSecondaire barbaraStolic = new PersonnageSecondaire("Barbara", "Stolic");
//		PersonnageSecondaire claireBB = new PersonnageSecondaire("Claire", "Blaque-Belair");
//		PersonnageSecondaire claireJaquet = new PersonnageSecondaire("Claire", "Jaquet");
//		PersonnageSecondaire jacquelineGuinet = new PersonnageSecondaire("Jacqueline", "Guinet");
//		PersonnageSecondaire shanazRicard = new PersonnageSecondaire("Shanaz", "Ricard");
//		PersonnageSecondaire priscillaRemy = new PersonnageSecondaire("Priscilla", "Remy");
//		PersonnageSecondaire judithRosenkrantz = new PersonnageSecondaire("Judith", "Rosenkrantz");
//		PersonnageSecondaire virginieIdjer = new PersonnageSecondaire("Virginie", "Idjer");
//		PersonnageSecondaire sophieLemoulec = new PersonnageSecondaire("Sophie", "Lemoulec");

		personnagesSecondaires.add(omarChefre);
		personnagesSecondaires.add(hassanCehef);
		personnagesSecondaires.add(omarIjuana);
		personnagesSecondaires.add(bencoBamboulaChocolat);

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
			vieMax = 2500;
			manaMax = 150;
			chargeMax = 7;
		} else if (difficultePartie == Difficulte.HEROIQUE) {
			vieMax = 3000;
			manaMax = 200;
			chargeMax = 10;
		}

		// TODO mieux / a verifier (asList)
//		Set<PersoStat> stats = johann.getCompetence().getStats().keySet();
		Set<PersoStat> stats = new HashSet<PersoStat>(Arrays.asList(PersoStat.values()));
		List<PersoStat> statsParType = new ArrayList<PersoStat>(stats);
		List<PersoStat> statsParClasse = new ArrayList<PersoStat>(stats);
		
		// Choix des competences pour les BOSS par difficulte, type et classe
		Competence competence1 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence2 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence3 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence4 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence5 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence6 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence7 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence8 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence11 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence12 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence13 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence14 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		Competence competence15 = choixDesCompetences(difficultePartie, statsParType, statsParClasse, null);
		
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
		PersonnageBoss boss11 = new PersonnageBoss(BossNom.BOSS11.getNom(), BossNom.BOSS11.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique11, particularitesSocial11, phrasesPerso11, photoBoss11, photos11, actionsCombat11,
				competence11);

		PersonnageBoss boss12 = new PersonnageBoss(BossNom.BOSS12.getNom(), BossNom.BOSS12.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique12, particularitesSocial12, phrasesPerso12, photoBoss12, photos12, actionsCombat12,
				competence12);

		PersonnageBoss boss13 = new PersonnageBoss(BossNom.BOSS13.getNom(), BossNom.BOSS13.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique13, particularitesSocial13, phrasesPerso13, photoBoss13, photos13, actionsCombat13,
				competence13);

		PersonnageBoss boss14 = new PersonnageBoss(BossNom.BOSS14.getNom(), BossNom.BOSS14.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique14, particularitesSocial14, phrasesPerso14, photoBoss14, photos14, actionsCombat14,
				competence14);

		PersonnageBoss boss15 = new PersonnageBoss(BossNom.BOSS15.getNom(), BossNom.BOSS15.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique15, particularitesSocial15, phrasesPerso15, photoBoss15, photos15, actionsCombat15,
				competence15);
		
		// Creation des BOSS
		
		// BOSS YO
		PersonnageBoss boss1 = new PersonnageBoss(BossNom.BOSS1.getNom(), BossNom.BOSS1.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique1, particularitesSocial1, phrasesPerso1, photoBoss1, photos1, actionsCombat1,
				competence1);

		// BOSS NICO
		PersonnageBoss boss2 = new PersonnageBoss(BossNom.BOSS2.getNom(), BossNom.BOSS2.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique2, particularitesSocial2, phrasesPerso2, photoBoss2, photos2, actionsCombat2,
				competence2);

		// BOSS PIP
		PersonnageBoss boss3 = new PersonnageBoss(BossNom.BOSS3.getNom(), BossNom.BOSS3.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique3, particularitesSocial3, phrasesPerso3, photoBoss3, photos3, actionsCombat3,
				competence3);

		// BOSS TOM
		PersonnageBoss boss4 = new PersonnageBoss(BossNom.BOSS4.getNom(), BossNom.BOSS4.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique4, particularitesSocial4, phrasesPerso4, photoBoss4, photos4, actionsCombat4,
				competence4);

		// BOSS YA
		PersonnageBoss boss5 = new PersonnageBoss(BossNom.BOSS5.getNom(), BossNom.BOSS5.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique5, particularitesSocial5, phrasesPerso5, photoBoss5, photos5, actionsCombat5,
				competence5);

		// BOSS ALI
		PersonnageBoss boss6 = new PersonnageBoss(BossNom.BOSS6.getNom(), BossNom.BOSS6.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique6, particularitesSocial6, phrasesPerso6, photoBoss6, photos6, actionsCombat6,
				competence6);

		// BOSS GUY
		PersonnageBoss boss7 = new PersonnageBoss(BossNom.BOSS7.getNom(), BossNom.BOSS7.getNom(), vieMax, manaMax, chargeMax,
				particularitesPhysique7, particularitesSocial7, phrasesPerso7, photoBoss7, photos7, actionsCombat7,
				competence7);

		// BOSS RUSS
		PersonnageBoss boss8 = new PersonnageBoss(BossNom.BOSS8.getNom(), BossNom.BOSS8.getNom(), vieMax, manaMax, chargeMax,
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
		personnage.setCompetence(choixDesCompetences(difficulte, statsParType, statsParClasse, personnage));
	}

	public PersonnageEnnemi createPersonnageEnnemi(Mission mission, int niveauSorts, PersoClasse classe, int numeroEnnemi) {

		// TODO pour chaque type d ennemis
		List<ImageIcon> photos = new ArrayList<ImageIcon>();
		List<String> particularitesPhysique = new ArrayList<String>();
		List<String> particularitesSocial = new ArrayList<String>();
		List<String> phrasesPerso = new ArrayList<String>();

		String imagePath = null;
		String nom = null;
		List<PersoStat> statsParType = new ArrayList<PersoStat>();
		List<PersoStat> statsParClasse = new ArrayList<PersoStat>();
		
		EnnemiType typeEnnemis = mission.getTypeEnnemis();
		if (typeEnnemis == EnnemiType.TOUS) {
			// Random du type d'ennemis
			List <EnnemiType> types = new ArrayList<>();{
				types.add(EnnemiType.ARABES);
				types.add(EnnemiType.NOIRS);
				types.add(EnnemiType.HANDICAPES);
				types.add(EnnemiType.GITANS);
			}
			int random = RandomManager.random(0, types.size() -1);
			typeEnnemis = types.get(random);
		}
		
		// GITANS
		if (typeEnnemis == EnnemiType.GITANS) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.RESISTANCE);
			statsParType.add(PersoStat.NERVOSITE);

			// Random des images par type
			String path = "image/ennemi/gitan/";
			imagePath = randomImage(numeroEnnemi, path);
			
			// Random des noms des ennemis
			String nomsGitan = ConfigurationManager.getProperties("ennemi.noms.gitan");
			String[] nomsGitanTab = nomsGitan.split(",");
			String nomGitanRandom = nomsGitanTab[RandomManager.random(0, nomsGitanTab.length-1)];
			nom = nomGitanRandom + " (" + classe.name() + ")";
			phrasesPerso.add("Hey Gadjo!");
			phrasesPerso.add("Mange tes maures!");
			phrasesPerso.add("Ca c'est mon cousin! Viens mon cousin!");
			phrasesPerso.add("T'inquietes pas que j'sais l'en faire du vélo mon copaing!");
			phrasesPerso.add("J'te met un coup d'botte dans les couilles, tu décolles jusqu'à la lune!");
			phrasesPerso.add("J'ai pris v'la l'pavée!");
			particularitesPhysique.add("Parle bizzarement en phonétique.");
			particularitesSocial.add("Ne sait ni lire, ni ecrire.");
			particularitesSocial.add("Nomade.");
			particularitesSocial.add("Se marie qu'avec des gitans.");
			particularitesSocial.add("Appelle les autres gitans : mon cousin.");
		}
		// ARABES
		else if (typeEnnemis == EnnemiType.ARABES) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.TECHNIQUE);
			statsParType.add(PersoStat.RAPIDITE);
			statsParType.add(PersoStat.NERVOSITE);

			// Random des images par type
			String path = "image/ennemi/arabe/";
			imagePath = randomImage(numeroEnnemi, path);
			
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
		else if (typeEnnemis == EnnemiType.NOIRS) {
			statsParType.add(PersoStat.AGILITE);
			statsParType.add(PersoStat.ENDURANCE);
			statsParType.add(PersoStat.RAPIDITE);
			statsParType.add(PersoStat.EXPLOIT);
			
			// Random des images par type
			String path = "image/ennemi/noir/";
			imagePath = randomImage(numeroEnnemi, path);
			
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
		else if (typeEnnemis == EnnemiType.HANDICAPES) {
			statsParType.add(PersoStat.INTELLIGENCE);
			statsParType.add(PersoStat.LUCK);
			statsParType.add(PersoStat.EXPLOIT);

			// Random des images par type
			String path = "image/ennemi/handicape/";
			imagePath = randomImage(numeroEnnemi, path);
			
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

		ImageIcon imageIcon = FenetrePrincipal.getImageIcon(imagePath);
		ImageIcon photoPrincipal = ImageManager.resizeImage(imageIcon,
				Constante.PERSO_IMAGE_DIMENSION_64_64);

		// TODO actionsCombat pour les ennemis en fonction de la difficulte du
		// type d'ennemi et de la classe de l'ennemi
		List<ActionCombat> actionsCombat = MenuPrincipal.getMainFrame().getCoreManager().getActionCombatManager()
				.getActionsCombat(typeEnnemis.name() + classe.name());

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
		Competence competence = choixDesCompetences(mission.getDifficulty(), statsParType, statsParClasse, null);

		// Vie Mana Charge
		vieMax = competence.getEndurance() * 10;
		manaMax = competence.getIntelligence();
		chargeMax = competence.getNervosite() / 20;

		PersonnageEnnemi ennemi = new PersonnageEnnemi(nom, nom, vieMax, manaMax, chargeMax, particularitesPhysique,
				particularitesSocial, phrasesPerso, photoPrincipal, photos, actionsCombat, typeEnnemis,
				competence);

		return ennemi;
	}

	private String randomImage(int numeroEnnemi, String path) {
		String imagePath;
		File file = new File(FenetrePrincipal.getURL(path).getPath());
		String[] paths = file.list();
		if (paths == null) {
			path = "classes/" + path;
			file = new File(path);
			paths = file.list();
		}
		imagePath = path + randomPhotoEnnemi(paths, numeroEnnemi);
		return imagePath;
	}

	private String randomPhotoEnnemi(String[] paths, int numeroEnnemi) {
		// Si c'est le premier ennemi
		int random = RandomManager.random(0, paths.length -1);
		if (numeroEnnemi == 1 || numeroEnnemi > (paths.length)) {
			numsEnnemi = new ArrayList<>();
			
		// Sinon 
		} else {
			while(numsEnnemi.contains(random)) {
				random = RandomManager.random(0, paths.length -1);
//				System.out.println("RANDOM PHOTO ENNEMI");
			}
		}
		numsEnnemi.add(random);
		String randomPhotoPath = paths[random];
		return randomPhotoPath;
	}

	private Competence choixDesCompetences(Difficulte difficulte, List<PersoStat> statsParType,
			List<PersoStat> statsParClasse, Personnage personnage) {
		
		

		int valeurParDifficulte = 25;
		Competence competence = null;
		
		// TODO virer valeurParDifficulte ??? Tout a 25 ?

		competence = new Competence(25);
		if (difficulte == Difficulte.FACILE) {
			valeurParDifficulte = 25;
		} else if (difficulte == Difficulte.NORMAL) {
			valeurParDifficulte = 30;
		} else if (difficulte == Difficulte.DIFFICILE) {
			valeurParDifficulte = 35;
		} else if (difficulte == Difficulte.HEROIQUE) {
			valeurParDifficulte = 40;
		}
		
		// TODO cas particulier des boss (50-75)
		if (personnage != null && personnage instanceof PersonnageBoss) {
			valeurParDifficulte = valeurParDifficulte + 35;
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

	public boolean regenerationNuit() {

		boolean evenementBloquant = false;
		
		// Pour chaque personnage
		for (PersonnagePrincipal personnage : leGroupe.getPersos()) {
			
			// On ressucite les morts
			if (personnage.isMort()) {
				personnage.setMort(false);
			}
			
			// On supprime les bonus de drogues consommes sur le perso
			personnage.supprimeEffetsDrogues();

			// Inutile normalement
			personnage.getAuras().clear();
			
			// On recalcule les stats en fonction des competences acquises la veille
			personnage.setVieMax(personnage.getCompetence().getEndurance()*10);
			personnage.setVie(personnage.getVieMax());
			personnage.setManaMax(personnage.getCompetence().getIntelligence());
			personnage.setMana(personnage.getManaMax());
			personnage.setBouclier(0);
			// TODO protection si item de defense
			personnage.setNombreCharge(0);
			personnage.setNombreChargeMax(personnage.getCompetence().getNervosite()/20);
			
			// Et tout le monde retourne a la base
			personnage.setLocation(new Location(personnage.getDomicile(), personnage.getDomicile().getPosition()));
		}
		
		// Maj de l'etat de peremption des drogues
		Map<Item, Integer> sac = leGroupe.getSac();
		for (Item item : sac.keySet()) {
			if (item instanceof Drogue) {
				Date dateCourante = MenuPrincipal.getMainFrame().getCoreManager().getDateManager().getDateCourante();
				long diff = ((Drogue)item).getDatePeremption().getTime() - dateCourante.getTime();
				
				// Si la date de peremption est depassee
				if (diff < 1 && !((Drogue) item).getDrogueClasse().name().equals(DrogueClasse.GRIS.name())) {
					
					// La drogue devient gris si la date de peremption est depasse
					((Drogue) item).setDrogueClasse(DrogueClasse.GRIS);
					
					// On supprime les bonus par stat de la drogue
					((Drogue) item).getBonusParStat().clear();
					
					// On informe l'utilisateur que la drogue est perime
					ImageIcon image = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
					ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.EVENEMENT_IMAGE_DIMENSION_300_300);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "T'as laissé pourir ta drogue!", "Pertes de memoire", JOptionPane.PLAIN_MESSAGE, resizeImage);
					evenementBloquant = true;
					
				// Si il reste une semaine avant la date de peremption	
				} else if ( (diff / (1000 * 60 * 60 * 24)) == 7 ) {

					// On informe l'utilisateur qu il reste 7 jours avant la date de peremption	
					ImageIcon image = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
					ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.EVENEMENT_IMAGE_DIMENSION_300_300);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "Il reste une semaine avant que ta drogue perime!", "Pertes de memoire", JOptionPane.PLAIN_MESSAGE, resizeImage);
					evenementBloquant = true;
				}
			}
		}
		return evenementBloquant;
	}

	public PersonnageSecondaire getPersonnageSecondaireByNomDeFamille(String name) {
		for (PersonnageSecondaire perso : personnagesSecondaires) {
			if (perso.getNom().equalsIgnoreCase(name)) {
				return perso;
			}
		}
		return null;
	}

	public List<PersonnageSecondaire> getAdversairesEcole() {
		return adversairesEcole;
	}

	public List<PersonnageSecondaire> getAdversairesTerrain() {
		List<PersonnageSecondaire> adversaires = null;
		int random = RandomManager.random(0, 2);
		if (random == 0) {
			adversaires = adversairesTerrainSamir;
		} else if (random == 1) {
			adversaires = adversairesTerrainGitan;
		} else if (random == 2) {
			adversaires = adversairesTerrainBoulets;
		}
		return adversaires;
	}

	public List<PersonnageSecondaire> getAdversairesChelles() {
		List<PersonnageSecondaire> adversaires = null;
		int random = RandomManager.random(0, 1);
		if (random == 0) {
			adversaires = adversairesChellesFred;
		} else if (random == 1) {
			adversaires = adversairesChellesGiani;
		} 
		return adversaires;
	}

	public List<PersonnageSecondaire> getAdversairesNoisy() {
		List<PersonnageSecondaire> adversaires = null;
		int random = RandomManager.random(0, 2);
		if (random == 0) {
			adversaires = adversairesNoisyHakim;
		} else if (random == 1) {
			adversaires = adversairesNoisyBene;
		} else if (random == 2) {
			adversaires = adversairesNoisyTom;
		}
		return adversaires;
	}

}

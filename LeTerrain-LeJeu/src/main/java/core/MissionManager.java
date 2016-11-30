package core;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import modele.bonus.Bonus;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.mission.BossNom;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.item.personnage.action.ActionCombat;
import modele.jeu.Jeu;

public class MissionManager implements Serializable  {

	private static final long serialVersionUID = 1L;
	private List<Mission> missions;
	private List<Mission> missionsDisponibles;
	private List<Mission> missionsIndisponibles;
	private List<Mission> missionsJouables;
	private List<Mission> missionsTerminees;
	private int id = 0;

	public void initialise(Difficulte difficultePartie, ActionCombatManager actionCombatManager, PersonnageManager personnageManager) {

		missions = new ArrayList<Mission>();
		missionsDisponibles = new ArrayList<Mission>();
		missionsIndisponibles = new ArrayList<Mission>();
		missionsJouables = new ArrayList<Mission>();
		missionsTerminees = new ArrayList<Mission>();
		
		// Chargement des missions

		// Images
		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> imagePaths3 = new ArrayList<String>();
		String imagePath3 = "image/mp3Player/back.png";
		imagePaths3.add(imagePath3);
		
		// Sons
		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "sonParDefaut/photoBruit2.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
		// Videos
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		// Dates
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 9, 00, 00);
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 17, 00, 00);
		Date date3 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 4, 9, 00, 00);
		Date dateNull = null;
		Date dateCleTerrain = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 4, 9, 00, 00);
		Date dateRencontreAli = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 5, 9, 00, 00);
		Date dateRencontreGuy = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 6, 9, 00, 00);
		Date dateRencontreJo = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 7, 9, 00, 00);
		
		// Bonus
		List<Bonus> bonus = BonusManager.getAllBonus();
		Bonus bonusVide = bonus.get(0);
		Bonus bonus1 = bonus.get(1);
		Bonus malus1 = bonus.get(2);
		
		// Items necessaires
		
		// Mission 106
		List<Item> itemsNecessairesMission106 = new ArrayList<Item>();
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Items a debloquer

		// Mission 101
		List<Item> itemsDebloquesMission101 = new ArrayList<Item>();
		itemsDebloquesMission101.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		// Mission 102
		List<Item> itemsDebloquesMission102 = new ArrayList<Item>();
		itemsDebloquesMission102.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		// Mission 103
		List<Item> itemsDebloquesMission103 = new ArrayList<Item>();
		itemsDebloquesMission103.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		// Mission 104
		List<Item> itemsDebloquesMission104 = new ArrayList<Item>();
		itemsDebloquesMission104.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		// Mission 105
		List<Item> itemsDebloquesMission105 = new ArrayList<Item>();
		itemsDebloquesMission105.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		// Mission 106
		List<Item> itemsDebloquesMission106 = new ArrayList<Item>();
		itemsDebloquesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		// Mission 107
		List<Item> itemsDebloquesMission107 = new ArrayList<Item>();
		itemsDebloquesMission107.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		// Mission 108
		List<Item> itemsDebloquesMission108 = new ArrayList<Item>();
		itemsDebloquesMission108.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		
		// Mission 18
		List<Item> itemsDebloquesMission18 = new ArrayList<Item>();
		ActionCombat action1 = actionCombatManager.getActionById(181);
		ActionCombat action2 = actionCombatManager.getActionById(182);
		ActionCombat action3 = actionCombatManager.getActionById(281);
		ActionCombat action4 = actionCombatManager.getActionById(282);
		ActionCombat action5 = actionCombatManager.getActionById(381);
		ActionCombat action6 = actionCombatManager.getActionById(382);
		ActionCombat action7 = actionCombatManager.getActionById(481);
		ActionCombat action8 = actionCombatManager.getActionById(482);
		ActionCombat action9 = actionCombatManager.getActionById(581);
		ActionCombat action10 = actionCombatManager.getActionById(582);
		ActionCombat action11 = actionCombatManager.getActionById(681);
		ActionCombat action12 = actionCombatManager.getActionById(682);
		ActionCombat action13 = actionCombatManager.getActionById(781);
		ActionCombat action14 = actionCombatManager.getActionById(782);
		ActionCombat action15 = actionCombatManager.getActionById(881);
		ActionCombat action16 = actionCombatManager.getActionById(882);
		itemsDebloquesMission18.add(action1);
		itemsDebloquesMission18.add(action2);
		itemsDebloquesMission18.add(action3);
		itemsDebloquesMission18.add(action4);
		itemsDebloquesMission18.add(action5);
		itemsDebloquesMission18.add(action6);
		itemsDebloquesMission18.add(action7);
		itemsDebloquesMission18.add(action8);
		itemsDebloquesMission18.add(action9);
		itemsDebloquesMission18.add(action10);
		itemsDebloquesMission18.add(action11);
		itemsDebloquesMission18.add(action12);
		itemsDebloquesMission18.add(action13);
		itemsDebloquesMission18.add(action14);
		itemsDebloquesMission18.add(action15);
		itemsDebloquesMission18.add(action16);
		
		int lieuDebloqueMission101 = 1;
		int lieuDebloqueMission102 = 2;
		int lieuDebloqueMission103 = 3;
		int lieuDebloqueMission104 = 4;
		int lieuDebloqueMission105 = 5;
		int lieuDebloqueMission106 = 6;
		int lieuDebloqueMission107 = 7;
		int lieuDebloqueMission108 = 8;
		int lieuDebloqueMission200 = 10;

		//		Mission m1 = new Mission(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, lieu, chanceVictoire, conditionVictoire, conditionDefaite, objectif, gain, perte, gainMax, perteMax, date, type, difficulty, personnagesRequis, personnagesInterdits, personnagesSecondaires, itemsNecessaires, itemsDebloques, isRepetable)

		// MISSION PRINCIPAL
		// Deblocages des persos et domiciles
		Mission mission101 = new Mission(101, "Rencontrer Johann",    "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,			  MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission101, lieuDebloqueMission101, false);
		Mission mission102 = new Mission(102, "Rencontrer Pierre",    "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, 			  MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission102, lieuDebloqueMission102, false);
		Mission mission103 = new Mission(103, "Rencontrer Nicolas",   "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,			  MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission103, lieuDebloqueMission103, false);
		Mission mission104 = new Mission(104, "Rencontrer Yannick",   "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, 			  MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission104, lieuDebloqueMission104, false);
		Mission mission105 = new Mission(105, "Rencontrer Thomas",    "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,			  MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission105, lieuDebloqueMission105, false);
		Mission mission106 = new Mission(106, "Rencontrer Ali",       "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreAli, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission106, lieuDebloqueMission106, false);
		Mission mission107 = new Mission(107, "Rencontrer Guillaume", "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreGuy, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission107, lieuDebloqueMission107, false);
		Mission mission108 = new Mission(108, "Rencontrer Jonathan",  "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann,  null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreJo,  MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission108, lieuDebloqueMission108, false);
			
		// MISSION ECOLE
		
		// MISSION TERRAIN
		// Deblocage du lieu : Terrain
		Mission mission200 = new Mission(200, "Avoir les clés du terrain", "Avoir un accès illimité au terrain", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 50, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCleTerrain, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), lieuDebloqueMission200 , false);
		Mission mission201 = new Mission(201, "Jouer au foot", "Se dépenser sans compter",  imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonus1, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0 , false);
		Mission mission202 = new Mission(201, "Fumer un pet", "Le Bedo, c'est de la merde", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonus1, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0 , false);
		 
		
		// MISSION MAISON YO
		// MISSION MAISON NICO

		// MISSION YO
		// MISSION NICO

		// TEST
		Mission mission900 = new Mission(900, "Premier Combat", "Combat tests dispo des le debut", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonus1, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0, false);
		// MISSION DEBLOQUEE PAR ITEMS
		Mission mission901 = new Mission(901, "Les perfs", "Battre la classe de perfectionnement", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonus1, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission106, new ArrayList<Item>(), 0, false);
		// MISSION DEBLOQUEE PAR DATE
		Mission mission902 = new Mission(902, "J+1", "                                          ", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonus1, bonusVide, 1, 1, date3, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0, true);

		
		// MISSION DEBLOQUE ACTION_COMBAT
		
		// Missions repetables => recompenses aleatoires (popo, fric, bonus leger)
		
//		Mission mission1  = new Mission(incrementId(), "Premier Perso", "info1", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 70, "", "", "objectif1", bonus1, bonusVide, 1, 1, date1, MissionType.BOSS, Difficulte.FACILE, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission2  = new Mission(incrementId(), "gitans facile", "info2", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Nicolas, null, 70, "", "", "objectif1", bonusVide, malus1, 1, 1, date2, MissionType.BOSS, Difficulte.FACILE, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), true);
//		Mission mission3  = new Mission(incrementId(), "gitans normal", "info3", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.NORMAL, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission4  = new Mission(incrementId(), "gitans difficile", "info4", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Yannick, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.DIFFICILE, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission5  = new Mission(incrementId(), "gitans heroique", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.HEROIQUE, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission6  = new Mission(incrementId(), "arabes facile", "info2", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Nicolas, null, 70, "", "", "objectif1", bonusVide, malus1, 1, 1, date2, MissionType.BOSS, Difficulte.FACILE, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), true);
//		Mission mission7  = new Mission(incrementId(), "arabes normal", "info3", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.NORMAL, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission8  = new Mission(incrementId(), "arabes difficile", "info4", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Yannick, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.DIFFICILE, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission9  = new Mission(incrementId(), "arabes heroique", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.HEROIQUE, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission10 = new Mission(incrementId(), "noirs facile", "info2", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Nicolas, null, 70, "", "", "objectif1", bonusVide, malus1, 1, 1, date2, MissionType.BOSS, Difficulte.FACILE, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), true);
//		Mission mission11 = new Mission(incrementId(), "noirs normal", "info3", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.NORMAL, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission12 = new Mission(incrementId(), "noirs difficile", "info4", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Yannick, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.DIFFICILE, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission13 = new Mission(incrementId(), "noirs heroique", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOSS, Difficulte.HEROIQUE, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission14 = new Mission(incrementId(), "handi facile", "info2", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Nicolas, null, 70, "", "", "objectif1", bonusVide, malus1, 1, 1, date2, MissionType.PRINCIPAL, Difficulte.FACILE, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), true);
//		Mission mission15 = new Mission(incrementId(), "handi normal", "info3", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, Difficulte.NORMAL, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission16 = new Mission(incrementId(), "handi difficile", "info4", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.Yannick, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, Difficulte.DIFFICILE, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission17 = new Mission(incrementId(), "handi heroique", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, Difficulte.HEROIQUE, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), false);
//		Mission mission18 = new Mission(incrementId(), "Debloque les multis speciaux", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, Difficulte.HEROIQUE, EnnemiType.HANDICAPES, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission18, false);
		
		// Ajout a la liste
//		missions.add(mission1);
//		missions.add(mission2);
//		missions.add(mission3);
//		missions.add(mission4);
//		missions.add(mission5);
//		missions.add(mission6);
//		missions.add(mission7);
//		missions.add(mission8);
//		missions.add(mission9);
//		missions.add(mission10);
//		missions.add(mission11);
//		missions.add(mission12);
//		missions.add(mission13);
//		missions.add(mission14);
//		missions.add(mission15);
//		missions.add(mission16);
//		missions.add(mission17);
//		missions.add(mission18);
		missions.add(mission101);
		missions.add(mission102);
		missions.add(mission103);
		missions.add(mission104);
		missions.add(mission105);
		missions.add(mission106);
		missions.add(mission107);
		missions.add(mission108);
		missions.add(mission200);
		missions.add(mission201);
		missions.add(mission202);

		missions.add(mission900);
		missions.add(mission901);
		missions.add(mission902);

		// Refresh Listes
		triMissions();
	}

	public List<Mission> getAllMissions() {
		return missions;
	}

	public Mission getMissionById(int id) {
		for (Mission mission : missions) {
			if (mission.getId() == id) {
				return mission;
			}
		}
		System.err.println("Mauvaise identifiant de la Mission. ID = (" + id + ")");
		return null;
	}
	
	public Mission getMissionByNom(String nom) {
		for (Mission mission : missions) {
			if (mission.getNom().equals(nom)) {
				return mission;
			}
		}
		return null;
	}
	
	public List<Mission> getMissionsByPerso(PersoPrenom nomPerso) {
		List<Mission> missionPerso = new ArrayList<Mission>();
		for (Mission mission : missionsJouables) {
			if (mission.getProprietaire().equals(nomPerso)) {
				missionPerso.add(mission);
			}
		}
		return missionPerso;
	}

	public List<Mission> getMissionsDisponibles() {
		refreshMissions();
		return missionsDisponibles;
	}

	public List<Mission> getMissionsIndisponibles() {
		refreshMissions();
		return missionsIndisponibles;
	}
	
	public List<Mission> getMissionsTerminees() {
		refreshMissionsJouables();
		return missionsTerminees;
	}
	
	public List<Mission> getMissionsJouables() {
		refreshMissionsJouables();
		return missionsJouables;
	}

	private void refreshMissions() {
		List<Mission> indispoTemp = new ArrayList<Mission>(missionsIndisponibles);
		for (Mission mission : indispoTemp) {
			if (mission.isDisponible()) {
				// Refresh
				missionsDisponibles.add(mission);
				missionsIndisponibles.remove(mission);
			}
		}
	}

	private void refreshMissionsJouables() {
		List<Mission> indispoTemp = new ArrayList<Mission>(missionsJouables);
		for (Mission mission : indispoTemp) {
			if (mission.isDejaFaite() && !mission.isRepetable()) {
				missionsTerminees.add(mission);
				missionsJouables.remove(mission);
			}
		}
	}
	
	public void refreshMissionsAPresenter() {
		List<Mission> dispoTemp = new ArrayList<Mission>(missions);
		for (Mission mission : dispoTemp) {
			if (mission.estDisponibleAPresenter()) {
				
				// On presente la mission qu'une seule fois
				mission.setDejaPresentee(true);
				
				// ajouter mission a la liste des missions jouables + suppression des autres listes
				missionsJouables.add(mission);
				if (missionsDisponibles.contains(mission)){
					missionsDisponibles.remove(mission);
				}
				if (missionsIndisponibles.contains(mission)){
					missionsIndisponibles.remove(mission);
				}
				
				// Lancer le son ou la musique associe a la mission
				MusiqueManager.playSonMission(mission.getSonPaths());
				
				// Lancer la video associe a la mission
				// TODO get(0)
				VideoManager.play(mission.getVideoPaths().get(0));
				
				// Afficher JDialog pour la mission
				int type = getTypeMission(mission);
				ImageIcon image = new ImageIcon(mission.getImagePaths().get(0));
				// Si il n y a pas d image, on retourne l icone par defaut d une mission
				if (image.getIconWidth() == -1) {
					image = new ImageIcon("image/defaut/defautMission.png");
				}
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), mission.getInformations() + "/nMission debloquée pour " + mission.getProprietaire().name(), mission.getNom(), type, image);
			
				refreshMissions();
			}
		}
		// TODO refresh panel centre si nouvelle mission disponible
		MainFrame.getPanelCentre().refreshPanelCourant();
	}
	
	public void lanceMission(Mission mission) {
		
		// Lancement du jeu
		JeuManager jeuManager = MenuPrincipal.getMainFrame().getCoreManager().getJeuManager();
		Jeu jeu = jeuManager.getJeu(mission.getJeu());
		JeuManager.lanceJeu(jeu, mission);
	}
	
	
	public void termineMission(Mission mission, boolean win) {
		// Gestion des recompenses et stats missions
		
		// Si win
		if (win) {
			mission.setDejaFaite(true);
			// Message mission win
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "Mission réussie!", mission.getNom(), 0, new ImageIcon(mission.getImagePaths().get(0)));
			// TODO : Ajouter un son de victoire
			if (!mission.isRepetable()) {
				mission.setNombreWin(1);
				distribueRecompenses(mission, true);
				// TODO : ajouter la mission aux achievments
			} else {
				mission.setNombreWin(mission.getNombreWin()+1);
				distribueRecompenses(mission, true);
			}
		// Si loose
		} else {
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "Mission échouée!", mission.getNom(), 1, new ImageIcon(mission.getImagePaths().get(0)));
			// TODO : Ajouter un son de defaite
			mission.setNombreEssai(mission.getNombreEssai()+1);
			distribueRecompenses(mission, false);
		}

		// A chaque fin de mission, on passe une heure
		MenuPrincipal.getMainFrame().getCoreManager().getDateManager().passeUneHeure();
		
		// refresh liste missions jouables par perso
		refreshMissionsJouables();
		// TODO gestion des missions par le menu ?
		MenuPrincipal.getMainFrame().getCoreManager().getMenuManager().lanceRefreshMenu();
		
		// Refresh panelPerso persos morts
		MenuPrincipal.getMainFrame().getPanelPersonnage().refreshMortsPersonnage();
		
	}
	
	public Mission getNextMissionAvecDate() {
		Mission nextMission = null;
		List<Mission> missionsIndisponibles = getMissionsIndisponiblesAvecDate();
		long minDiff = 1000000000;
		for (Mission mission : missionsIndisponibles) {
			long diff = MenuPrincipal.getMainFrame().getCoreManager().getDateManager().compare(mission.getDate());
			if (diff < minDiff ) {
				minDiff = diff;
				nextMission = mission;
			}
		}
		return nextMission;
	}

	public List<Mission> getMissionsNonPresentees() {
		List<Mission> missionsNonPresentees = new ArrayList<Mission>();
		for (Mission mission : missions) {
			if (!mission.isDejaPresentee()) {
				missionsNonPresentees.add(mission);
			}
		}
		return missionsNonPresentees;
	}
	
	private List<Mission> getMissionsIndisponiblesAvecDate() {
		List<Mission> missionsIndisponiblesAvecDate = new ArrayList<>();
		List<Mission> missionsIndisponibles = getMissionsIndisponibles();
		for (Mission mission : missionsIndisponibles) {
			if (mission.getDate() != null) {
				missionsIndisponiblesAvecDate.add(mission);
			}
		}
		return missionsIndisponiblesAvecDate;
	}

	private int getTypeMission(Mission mission) {
		int type = JOptionPane.PLAIN_MESSAGE;
		if (mission.getMissionType().equals(MissionType.PRINCIPAL)) {
			type = JOptionPane.ERROR_MESSAGE;
		}
		return type;
	}

	private void triMissions() {
		for (Mission mission : missions) {
			if (mission.isDisponible()) {
				missionsDisponibles.add(mission);
			} else {
				missionsIndisponibles.add(mission);
			}
		}
	}
	
	private int incrementId() {
		id = id +1;
		return id;
	}
	
	public void distribueRecompenses(Mission mission, boolean win) {
		// TODO si une mission a debloque une actionCombat
		// Debloquer les items a debloquer 
		List<Item> itemsDebloques = mission.getItemsDebloques();
		for (Item item : itemsDebloques) {
		
			int type = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getTypeItem(item);

			// TODO get(0)
			// Lancer le son ou la musique associe a l item
			if (item.getSonPath() != null) {
				MusiqueManager.playSonItem(item.getSonPath().get(0));
			}
					
			// Lancer la video associe a l item
			if (item.getVideoPaths() != null) {
				VideoManager.play(item.getVideoPaths().get(0));
			}
					
			// Afficher JDialog pour l item
			ImageIcon itemImage = null;
			if (item.getImagePath() != null) {
				itemImage = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
			} else {
				itemImage = FenetrePrincipal.getImageIcon("image/defaut/defautItem.png");
			}
			String itemType = item.getType().name().toLowerCase();
			// TODO meilleur nom que ACTION_COMBAT
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), item.getProprietaire() + " a débloqué : " + item.getNom(), "Nouvel item disponible !" + itemType, type, itemImage);
			item.setDisponible(true);
		}	
		
		// Debloquer les lieux a debloquer 
		int idLieu = mission.getLieuDebloque();
		if (idLieu != 0) {
			Lieu lieuById = MenuPrincipal.getMainFrame().getCoreManager().getLieuManager().getLieuById(idLieu);
			if (lieuById != null) {
				lieuById.setDisponible(true);
				// Afficher JDialog pour le lieu debloque
				ImageIcon itemLieu = FenetrePrincipal.getImageIcon("image/defaut/defautLieu.png");
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), lieuById.getProprietaire() + " a débloqué un nouveau Lieu : " + lieuById.getNom(), "Nouveau Lieu disponible !", 0, itemLieu);
			} else {
				System.err.println("Mauvaise identifiant de Lieu pendant le deblocage. ID = (" + idLieu + ")");
			}
		}
					
		// Distribution des bonus/malus
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		if (win) {
			BonusManager.distribueBonus(leGroupe, mission.getGain());
		} else {
			BonusManager.distribueBonus(leGroupe, mission.getPerte());
		}

		// Si une mission a debloque un perso
		MainFrame.getPanelPersonnage().refreshArriveePersonnage();
	}

}

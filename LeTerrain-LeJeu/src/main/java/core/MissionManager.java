package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import core.configuration.Constante;
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

public class MissionManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Mission> missions;
	private List<Mission> missionsDisponibles;
	private List<Mission> missionsIndisponibles;
	private List<Mission> missionsJouables;
	private List<Mission> missionsTerminees;
//	private int id = 0;

	public void initialise(Difficulte difficultePartie, ActionCombatManager actionCombatManager,
			PersonnageManager personnageManager, ItemManager itemManager) {

		missions = new ArrayList<Mission>();
		missionsDisponibles = new ArrayList<Mission>();
		missionsIndisponibles = new ArrayList<Mission>();
		missionsJouables = new ArrayList<Mission>();
		missionsTerminees = new ArrayList<Mission>();

		// Chargement des missions

		// Images
		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "image/defaut/defautItemMission.jpg";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> imagePaths3 = new ArrayList<String>();
		String imagePath3 = "image/mp3Player/back.png";
		imagePaths3.add(imagePath3);

		// Sons
		List<String> sonPathsFilm = new ArrayList<String>();
		String sonPathFilm = "sonParDefaut/film.mp3";
		sonPathsFilm.add(sonPathFilm);
		
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

		// TODO bonnes Dates
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 9, 00, 00);
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 17, 00, 00);
		Date date3 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 4, 9, 00, 00);
		Date dateNull = null;
		
		Date dateCleTerrain = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 1, 9, 00, 00);
	
		Date dateRencontreAli = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 7, 14, 00, 00);
		Date dateRencontreGuy = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 7, 14, 00, 00);
		Date dateRencontreJo = DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 7, 14, 00, 00);
		
		Date dateTrilogie = DateManager.genereUneDate(1999, Calendar.DECEMBER, 6, 21, 00, 00);
		Date dateAchatRequins = DateManager.genereUneDate(1999, Calendar.DECEMBER, 25, 9, 00, 00);
		Date dateAchatPunto = DateManager.genereUneDate(2001, Calendar.MAY, 19, 14, 00, 00);

		Date dateAzopardi = DateManager.genereUneDate(2001, Calendar.AUGUST, 19, 19, 00, 00);
		Date dateAchatDoudoune = DateManager.genereUneDate(1999, Calendar.DECEMBER, 25, 10, 00, 00);
		Date dateJonglerettes = DateManager.genereUneDate(1998, Calendar.JUNE, 7, 14, 00, 00);
		Date dateGuyApart = DateManager.genereUneDate(2001, Calendar.JUNE, 21, 14, 00, 00);
		Date dateFacebook = DateManager.genereUneDate(2004, Calendar.MARCH, 1, 14, 00, 00);
		Date dateEscargot = DateManager.genereUneDate(2002, Calendar.JUNE, 18, 19, 00, 00);
		Date dateIngurgite = DateManager.genereUneDate(2001, Calendar.JULY, 18, 19, 00, 00);
		Date dateBite = DateManager.genereUneDate(2010, Calendar.MAY, 1, 19, 00, 00);
		
		Date date911 = DateManager.genereUneDate(2001, Calendar.SEPTEMBER, 11, 12, 0, 0);
		Date datePermisVoler = DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateSAV = DateManager.genereUneDate(2005, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateEspagne = DateManager.genereUneDate(1999, Calendar.AUGUST, 11, 14, 00, 00);
		Date dateLacrymo = DateManager.genereUneDate(2002, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateRap = DateManager.genereUneDate(2010, Calendar.MAY, 8, 14, 00, 00);
		Date dateCul = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateCroche = DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 11, 14, 00, 00);

		Date dateTortue = DateManager.genereUneDate(1991, Calendar.SEPTEMBER, 5, 12, 0, 0);
		Date dateScout = DateManager.genereUneDate(1994, Calendar.SEPTEMBER, 5, 14, 00, 00);
		Date dateColRoulé = DateManager.genereUneDate(1990, Calendar.OCTOBER, 11, 14, 00, 00);
		Date dateSquat = DateManager.genereUneDate(1995, Calendar.JUNE, 7, 14, 00, 00);
		Date dateMillenium = DateManager.genereUneDate(1999, Calendar.NOVEMBER, 1, 14, 00, 00);
		Date dateDrDre = DateManager.genereUneDate(2000, Calendar.JULY, 18, 14, 00, 00);
		Date datePerfusion = DateManager.genereUneDate(1990, Calendar.NOVEMBER, 11, 14, 00, 00);
		Date dateSpiritisme = DateManager.genereUneDate(1997, Calendar.JUNE, 25, 14, 00, 00);
		
		
		Date date310 = DateManager.genereUneDate(1999, Calendar.OCTOBER, 7, 14, 00, 00);
		Date date308 = DateManager.genereUneDate(2000, Calendar.JANUARY, 7, 14, 00, 00);
		Date date304 = DateManager.genereUneDate(2000, Calendar.MAY, 7, 14, 00, 00);
		Date date305 = DateManager.genereUneDate(2000, Calendar.JUNE, 7, 14, 00, 00);

		
		
		// Bonus
		Bonus bonusVide = BonusManager.getBonusById(0);
		Bonus bonusPiscine = BonusManager.getBonusById(10);
		Bonus bonusFoot = BonusManager.getBonusById(20);
		Bonus bonusBoss1 = BonusManager.getBonusById(101);
		Bonus bonusBoss2 = BonusManager.getBonusById(102);
		Bonus bonusBoss3 = BonusManager.getBonusById(103);
		Bonus bonusBoss4 = BonusManager.getBonusById(104);
		Bonus bonusBoss5 = BonusManager.getBonusById(105);
		Bonus bonusBoss6 = BonusManager.getBonusById(106);
		Bonus bonusBoss7 = BonusManager.getBonusById(10);
		Bonus bonusBoss8 = BonusManager.getBonusById(108);


		
		// Items a debloquer
		// Consommables
		Item popoVie25 = itemManager.getItemById(100);
		Item popoVie50 = itemManager.getItemById(101);
		Item popoVie75 = itemManager.getItemById(102);
		Item popoVie100 = itemManager.getItemById(103);
		Item popoMana25 = itemManager.getItemById(200);
		Item popoMana50 = itemManager.getItemById(201);
		Item popoMana75 = itemManager.getItemById(202);
		Item popoMana100 = itemManager.getItemById(203);
		Item bonusChance5 = itemManager.getItemById(300);
		Item bonusChance10 = itemManager.getItemById(301);
		Item bonusChance20 = itemManager.getItemById(302);
		Item bonusExploit5 = itemManager.getItemById(303);
		Item bonusExploit10 = itemManager.getItemById(304);
		Item bonusExploit20 = itemManager.getItemById(305);
		Item bonusTechnique5 = itemManager.getItemById(306);
		Item bonusTechnique10 = itemManager.getItemById(307);
		Item bonusTechnique20 = itemManager.getItemById(308);
		Item bonusEndurance5 = itemManager.getItemById(309);
		Item bonusEndurance10 = itemManager.getItemById(310);
		Item bonusEndurance20 = itemManager.getItemById(311);
		Item bonusRapidite5 = itemManager.getItemById(312);
		Item bonusRapidite10 = itemManager.getItemById(313);
		Item bonusRapidite20 = itemManager.getItemById(314);
		Item bonusResistance5 = itemManager.getItemById(315);
		Item bonusResistance10 = itemManager.getItemById(316);
		Item bonusResistance20 = itemManager.getItemById(317);
		Item bonusAgilite5 = itemManager.getItemById(318);
		Item bonusAgilite10 = itemManager.getItemById(319);
		Item bonusAgilite20 = itemManager.getItemById(320);
		Item bonusIntelligence5 = itemManager.getItemById(321);
		Item bonusIntelligence10 = itemManager.getItemById(322);
		Item bonusIntelligence20 = itemManager.getItemById(323);
		Item bonusNervosite5 = itemManager.getItemById(324);
		Item bonusNervosite10 = itemManager.getItemById(325);
		Item bonusNervosite20 = itemManager.getItemById(326);

		Item clesDuTerrain = itemManager.getItemById(400);
		Item graisseATraire = itemManager.getItemById(401);

		// Items necessaires

		// Mission 106
		List<Item> itemsNecessairesMission106 = new ArrayList<Item>();
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));

		// Mission 300
		List<Item> itemsNecessairesMission300 = new ArrayList<Item>();
		itemsNecessairesMission300.add(itemManager.getItemById(600));
		itemsNecessairesMission300.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		
		// Mission 306
		List<Item> itemsNecessairesMission306 = new ArrayList<Item>();
		itemsNecessairesMission306.add(graisseATraire);
		itemsNecessairesMission306.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));

		// Mission 504
		List<Item> itemsNecessairesMission504 = new ArrayList<Item>();
		itemsNecessairesMission504.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission504.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
	
		// Mission 506
		List<Item> itemsNecessairesMission506 = new ArrayList<Item>();
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 603
		List<Item> itemsNecessairesMission603 = new ArrayList<Item>();
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 607
		List<Item> itemsNecessairesMission607 = new ArrayList<Item>();
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		
		// Mission Terrain
		List<Item> itemsNecessairesMissionTerrain = new ArrayList<Item>();
		itemsNecessairesMissionTerrain.add(clesDuTerrain);

		// Mission Russ
		List<Item> itemsNecessairesMissionRuss = new ArrayList<Item>();
		itemsNecessairesMissionRuss.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));

		// Mission Guy
		List<Item> itemsNecessairesMissionGuy = new ArrayList<Item>();
		itemsNecessairesMissionGuy.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		
		// Mission Ali
		List<Item> itemsNecessairesMissionAli = new ArrayList<Item>();
		itemsNecessairesMissionAli.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		
		// Mission Tom
		List<Item> itemsNecessairesMissionTom = new ArrayList<Item>();
		itemsNecessairesMissionTom.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Missions Boss
		// TODO : verifier que les items debloquer correspondent aux SPECIAL
		List<Item> itemsNecessairesMissionBoss1 = new ArrayList<Item>();
		itemsNecessairesMissionBoss1.add(actionCombatManager.getActionById(181));
		List<Item> itemsNecessairesMissionBoss2 = new ArrayList<Item>();
		itemsNecessairesMissionBoss2.add(actionCombatManager.getActionById(281));
		List<Item> itemsNecessairesMissionBoss3 = new ArrayList<Item>();
		itemsNecessairesMissionBoss3.add(actionCombatManager.getActionById(381));
		List<Item> itemsNecessairesMissionBoss4 = new ArrayList<Item>();
		itemsNecessairesMissionBoss4.add(actionCombatManager.getActionById(581));
		List<Item> itemsNecessairesMissionBoss5 = new ArrayList<Item>();
		itemsNecessairesMissionBoss5.add(actionCombatManager.getActionById(481));
		List<Item> itemsNecessairesMissionBoss6 = new ArrayList<Item>();
		itemsNecessairesMissionBoss6.add(actionCombatManager.getActionById(781));
		List<Item> itemsNecessairesMissionBoss7 = new ArrayList<Item>();
		itemsNecessairesMissionBoss7.add(actionCombatManager.getActionById(681));
		List<Item> itemsNecessairesMissionBoss8 = new ArrayList<Item>();
		itemsNecessairesMissionBoss8.add(actionCombatManager.getActionById(882));
		
		
		// TODO item potion de combat (rez, degats, stunt, taunt)

		// Mission 101
		List<Item> itemsDebloquesMission101 = new ArrayList<Item>();
		itemsDebloquesMission101.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsDebloquesMission101.add(popoVie25);
		itemsDebloquesMission101.add(popoMana25);
		itemsDebloquesMission101.add(bonusChance5);
		// Mission 102
		List<Item> itemsDebloquesMission102 = new ArrayList<Item>();
		itemsDebloquesMission102.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsDebloquesMission102.add(popoVie25);
		itemsDebloquesMission102.add(popoMana25);
		itemsDebloquesMission102.add(bonusRapidite5);
		// Mission 103
		List<Item> itemsDebloquesMission103 = new ArrayList<Item>();
		itemsDebloquesMission103.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsDebloquesMission103.add(popoVie25);
		itemsDebloquesMission103.add(popoMana25);
		itemsDebloquesMission103.add(bonusExploit5);
		// Mission 104
		List<Item> itemsDebloquesMission104 = new ArrayList<Item>();
		itemsDebloquesMission104.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsDebloquesMission104.add(popoVie25);
		itemsDebloquesMission104.add(popoMana25);
		itemsDebloquesMission104.add(bonusResistance5);
		// Mission 105
		List<Item> itemsDebloquesMission105 = new ArrayList<Item>();
		itemsDebloquesMission105.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsDebloquesMission105.add(popoVie25);
		itemsDebloquesMission105.add(popoMana25);
		itemsDebloquesMission105.add(bonusIntelligence5);
		// Mission 106
		List<Item> itemsDebloquesMission106 = new ArrayList<Item>();
		itemsDebloquesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsDebloquesMission106.add(popoVie50);
		itemsDebloquesMission106.add(popoMana50);
		itemsDebloquesMission106.add(bonusAgilite10);
		// Mission 107
		List<Item> itemsDebloquesMission107 = new ArrayList<Item>();
		itemsDebloquesMission107.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		itemsDebloquesMission104.add(popoVie75);
		itemsDebloquesMission104.add(popoMana75);
		itemsDebloquesMission104.add(bonusTechnique10);
		// Mission 108
		List<Item> itemsDebloquesMission108 = new ArrayList<Item>();
		itemsDebloquesMission108.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		itemsDebloquesMission108.add(popoVie100);
		itemsDebloquesMission108.add(popoMana100);
		itemsDebloquesMission108.add(bonusEndurance20);
		itemsDebloquesMission108.add(bonusNervosite20);

		// Mission 200
		List<Item> itemsDebloquesMission200 = new ArrayList<Item>();
		itemsDebloquesMission200.add(clesDuTerrain);

		// Mission 300
		List<Item> itemsDebloquesMission300 = new ArrayList<Item>();
		itemsDebloquesMission300.add(actionCombatManager.getActionById(846));

		// Mission 301
		List<Item> itemsDebloquesMission301 = new ArrayList<Item>();
		itemsDebloquesMission301.add(actionCombatManager.getActionById(848));

		// Mission 302
		List<Item> itemsDebloquesMission302 = new ArrayList<Item>();
		itemsDebloquesMission302.add(actionCombatManager.getActionById(847));
		
		// Mission 305
		List<Item> itemsDebloquesMission305 = new ArrayList<Item>();
		itemsDebloquesMission305.add(graisseATraire);
		
		// Mission 306
		List<Item> itemsDebloquesMission306 = new ArrayList<Item>();
		itemsDebloquesMission306.add(actionCombatManager.getActionById(842));
		
		// Mission 307
		List<Item> itemsDebloquesMission307 = new ArrayList<Item>();
		itemsDebloquesMission307.add(actionCombatManager.getActionById(836));

		// Mission 308
		List<Item> itemsDebloquesMission308 = new ArrayList<Item>();
		itemsDebloquesMission308.add(actionCombatManager.getActionById(818));
		
		// Mission 309
		List<Item> itemsDebloquesMission309 = new ArrayList<Item>();
		itemsDebloquesMission309.add(actionCombatManager.getActionById(817));

		// Mission 310
		List<Item> itemsDebloquesMission310 = new ArrayList<Item>();
		itemsDebloquesMission310.add(actionCombatManager.getActionById(812));
		
		// Mission 400
		List<Item> itemsDebloquesMission400 = new ArrayList<Item>();
		itemsDebloquesMission400.add(actionCombatManager.getActionById(612));
		
		// Mission 401
		List<Item> itemsDebloquesMission401 = new ArrayList<Item>();
		itemsDebloquesMission401.add(actionCombatManager.getActionById(613));
		
		// Mission 402
		List<Item> itemsDebloquesMission402 = new ArrayList<Item>();
		itemsDebloquesMission402.add(actionCombatManager.getActionById(617));

		// Mission 403
		List<Item> itemsDebloquesMission403 = new ArrayList<Item>();
		itemsDebloquesMission403.add(actionCombatManager.getActionById(631));
		
		// Mission 404
		List<Item> itemsDebloquesMission404 = new ArrayList<Item>();
		itemsDebloquesMission404.add(actionCombatManager.getActionById(634));

		// Mission 405
		List<Item> itemsDebloquesMission405 = new ArrayList<Item>();
		itemsDebloquesMission405.add(actionCombatManager.getActionById(636));
		
		// Mission 406
		List<Item> itemsDebloquesMission406 = new ArrayList<Item>();
		itemsDebloquesMission406.add(actionCombatManager.getActionById(640));

		// Mission 407
		List<Item> itemsDebloquesMission407 = new ArrayList<Item>();
		itemsDebloquesMission407.add(actionCombatManager.getActionById(648));
		
		// Mission 500
		List<Item> itemsDebloquesMission500 = new ArrayList<Item>();
		itemsDebloquesMission500.add(actionCombatManager.getActionById(712));
		
		// Mission 501
		List<Item> itemsDebloquesMission501 = new ArrayList<Item>();
		itemsDebloquesMission501.add(actionCombatManager.getActionById(717));

		// Mission 502
		List<Item> itemsDebloquesMission502 = new ArrayList<Item>();
		itemsDebloquesMission502.add(actionCombatManager.getActionById(718));

		// Mission 503
		List<Item> itemsDebloquesMission503 = new ArrayList<Item>();
		itemsDebloquesMission503.add(actionCombatManager.getActionById(731));
		
		// Mission 504
		List<Item> itemsDebloquesMission504 = new ArrayList<Item>();
		itemsDebloquesMission504.add(actionCombatManager.getActionById(742));
		
		// Mission 505
		List<Item> itemsDebloquesMission505 = new ArrayList<Item>();
		itemsDebloquesMission505.add(actionCombatManager.getActionById(743));

		// Mission 506
		List<Item> itemsDebloquesMission506 = new ArrayList<Item>();
		itemsDebloquesMission506.add(actionCombatManager.getActionById(746));
		
		// Mission 507
		List<Item> itemsDebloquesMission507 = new ArrayList<Item>();
		itemsDebloquesMission507.add(actionCombatManager.getActionById(747));
		
		// Mission 600
		List<Item> itemsDebloquesMission600 = new ArrayList<Item>();
		itemsDebloquesMission600.add(actionCombatManager.getActionById(512));
		
		// Mission 601
		List<Item> itemsDebloquesMission601 = new ArrayList<Item>();
		itemsDebloquesMission601.add(actionCombatManager.getActionById(517));

		// Mission 602
		List<Item> itemsDebloquesMission602 = new ArrayList<Item>();
		itemsDebloquesMission602.add(actionCombatManager.getActionById(531));

		// Mission 603
		List<Item> itemsDebloquesMission603 = new ArrayList<Item>();
		itemsDebloquesMission603.add(actionCombatManager.getActionById(533));
		
		// Mission 604
		List<Item> itemsDebloquesMission604 = new ArrayList<Item>();
		itemsDebloquesMission604.add(actionCombatManager.getActionById(535));
		
		// Mission 605
		List<Item> itemsDebloquesMission605 = new ArrayList<Item>();
		itemsDebloquesMission605.add(actionCombatManager.getActionById(541));

		// Mission 606
		List<Item> itemsDebloquesMission606 = new ArrayList<Item>();
		itemsDebloquesMission606.add(actionCombatManager.getActionById(543));
		
		// Mission 607
		List<Item> itemsDebloquesMission607 = new ArrayList<Item>();
		itemsDebloquesMission607.add(actionCombatManager.getActionById(544));
		
		// Mission 1001
		List<Item> itemsDebloquesMission1001 = new ArrayList<Item>();
		itemsDebloquesMission1001.add(bonusChance20);
		itemsDebloquesMission1001.add(popoVie100);
		itemsDebloquesMission1001.add(popoMana100);
		
		// Mission 1002
		List<Item> itemsDebloquesMission1002 = new ArrayList<Item>();
		itemsDebloquesMission1002.add(bonusChance20);
		itemsDebloquesMission1002.add(popoVie100);
		itemsDebloquesMission1002.add(popoMana100);
		
		// Mission 1003
		List<Item> itemsDebloquesMission1003 = new ArrayList<Item>();
		itemsDebloquesMission1003.add(bonusChance20);
		itemsDebloquesMission1003.add(popoVie100);
		itemsDebloquesMission1003.add(popoMana100);
		
		// Mission 1004
		List<Item> itemsDebloquesMission1004 = new ArrayList<Item>();
		itemsDebloquesMission1004.add(bonusChance20);
		itemsDebloquesMission1004.add(popoVie100);
		itemsDebloquesMission1004.add(popoMana100);
		
		// Mission 1005
		List<Item> itemsDebloquesMission1005 = new ArrayList<Item>();
		itemsDebloquesMission1005.add(bonusChance20);
		itemsDebloquesMission1005.add(popoVie100);
		itemsDebloquesMission1005.add(popoMana100);
		
		// Mission 1006
		List<Item> itemsDebloquesMission1006 = new ArrayList<Item>();
		itemsDebloquesMission1006.add(bonusChance20);
		itemsDebloquesMission1006.add(popoVie100);
		itemsDebloquesMission1006.add(popoMana100);
		
		// Mission 1007
		List<Item> itemsDebloquesMission1007 = new ArrayList<Item>();
		itemsDebloquesMission1007.add(bonusChance20);
		itemsDebloquesMission1007.add(popoVie100);
		itemsDebloquesMission1007.add(popoMana100);
		
		// Mission 1008
		List<Item> itemsDebloquesMission1008 = new ArrayList<Item>();
		itemsDebloquesMission1008.add(bonusChance20);
		itemsDebloquesMission1008.add(popoVie100);
		itemsDebloquesMission1008.add(popoMana100);
		
		// MISSIONS PRINCIPAL
		// Deblocages des persos et domiciles
		Mission mission101 = new Mission(101, "Rencontrer Johann", "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission101, 1, false);
		Mission mission102 = new Mission(102, "Rencontrer Pierre", "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission102, 2, false);
		Mission mission103 = new Mission(103, "Rencontrer Nicolas", "Rassembler le groupe", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,	MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null,	new ArrayList<Item>(), itemsDebloquesMission103, 3, false);
		Mission mission104 = new Mission(104, "Rencontrer Yannick", "Rassembler le groupe", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,	MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null,	new ArrayList<Item>(), itemsDebloquesMission104, 4, false);
		Mission mission105 = new Mission(105, "Rencontrer Thomas", "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission105, 5, false);
		Mission mission106 = new Mission(106, "Rencontrer Ali", "Rassembler le groupe", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreAli, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission106, 6, false);
		Mission mission107 = new Mission(107, "Rencontrer Guillaume", "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreGuy, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM,	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission107, 7, false);
		Mission mission108 = new Mission(108, "Rencontrer Jonathan", "Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreJo, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission108, 8, false);

		// MISSIONS ECOLE

		// MISSIONS TERRAIN
		// Deblocage du lieu : Terrain
		Mission mission200 = new Mission(200, "Le terrain, gratuit et illimité", "Avoir les clés du terrain", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCleTerrain, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM,	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission200, 10, false);
		Mission mission201 = new Mission(201, "Se dépenser sans compter", "Jouer au foot", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTerrain, new ArrayList<Item>(), 0, true);
		Mission mission202 = new Mission(202, "Le Bedo, c'est de la merde", "Fumer un pet", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull,	MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTerrain, new ArrayList<Item>(), 0, false);

		// MISSIONS ACTION COMBAT
		
		// Sorts RUSS
		// TODO verifier : date + objet requis => ???
		Mission mission300 = new Mission(300, "Une journée en enfer", "Regarder le film - Die Hard 3", 			imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission300, itemsDebloquesMission300, 0, false);
		Mission mission301 = new Mission(301, "Pompes de racaille", "Acheter des requins", 						imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatRequins, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission301, 0, false);
		Mission mission302 = new Mission(302, "Fiat Punto : Un poing c'est tout", "Acheter une Punto", 			imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatPunto, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission302, 0, false);
		Mission mission303 = new Mission(303, "Comme un poisson dans l'eau", "Aller à la piscine", 				imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusPiscine, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, new ArrayList<Item>(), 0, true);
		Mission mission304 = new Mission(304, "Epilation désopilante", "Se raser intégralement", 				imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date304, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, new ArrayList<Item>(), 0, false);
		Mission mission305 = new Mission(305, "Prise en main des mamelles", "Acheter de la graisse à traire", 	imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date305, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission305, 0, false);
		Mission mission306 = new Mission(306, "Bronzage extreme", "Prendre un coup de soleil", 					imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission306, itemsDebloquesMission306, 0, false);
		Mission mission307 = new Mission(307, "Peau de caméléon", "S'entretenir l'épiderme",					imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission306, itemsDebloquesMission307, 0, false);
		Mission mission308 = new Mission(308, "Vibreur silencieux", "Ne pas répondre au GSM", 					imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date308, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission308, 0, false);
		Mission mission309 = new Mission(309, "La Trilogie du Samedi", "Regarder la trilogie du samedi sur M6", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTrilogie, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission309, 0, false);
		Mission mission310 = new Mission(310, "Torse poil", "Se regarder dans un miroir", 						imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date310, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission310, 0, false);
		// TODO mission pasteque
		
		// Sorts GUY
		Mission mission400 = new Mission(400, "Le calme après la tempête", "Survivre à une grosse soirée houleuse", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAzopardi, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission400, 0, false);
		Mission mission401 = new Mission(401, "Au top de la mode", "Acheter un vêtement qui protégera son porteur", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatDoudoune, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission401, 0, false);
		Mission mission402 = new Mission(402, "La ronde des jonglerettes", "Trouver un moyen d'ameliorer la technique de ses alliés", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateJonglerettes, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission402, 0, false);
		Mission mission403 = new Mission(403, "GuiHam Burger", "Trouver une recette saine et équilibrée pour se nourrir quotidiennement", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGuyApart, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission403, 0, false);
		Mission mission404 = new Mission(404, "Réseaux sociaux anonymes", "Trouver un moyen d'avoir plein d'amies sur facebook", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFacebook, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission404, 0, false);
		Mission mission405 = new Mission(405, "Repos chamanique", "Faire une petite sieste en soirée, le temps de retrouver ses esprits", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEscargot, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission405, 0, false);
		Mission mission406 = new Mission(406, "Gorge profonde", "Boire comme un trou pour être immunisé contre le vomissement", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateIngurgite, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission406, 0, false);
		Mission mission407 = new Mission(407, "Le dauphin, la baleine, et l'éléphant", "Trouver un moyen de focaliser l'attention sur vous, tout en prenant du bon temps dans le jacuzzi", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBite, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission407, 0, false);
		// TODO mission special
		
		// Sorts ALI
		Mission mission500 = new Mission(500, "Dépucelage mécanique", "Apprendre à conduire des engins motorisés", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date911, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission500, 0, false);
		Mission mission501 = new Mission(501, "Permis de voler", "Emprunter des trucs chez Jafar sans se faire prendre", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePermisVoler, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission501, 0, false);
		Mission mission502 = new Mission(502, "Tu viens plus aux soirées?", "Regarder le SAV d'Omar et Fred", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSAV, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission502, 0, false);
		Mission mission503 = new Mission(503, "Expérience sensorielle", "Trouver un moyen de survivre à la chaleur écrasante de l'Espagne", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEspagne, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission503, 0, false);
		Mission mission504 = new Mission(504, "Roulette pakistanaise", "Tirer avec un pistolet dans une pièce fermé sans savoir si il est chargé avec de vraies balles", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateLacrymo, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission504, itemsDebloquesMission504, 0, false);
		Mission mission505 = new Mission(505, "Heal the world", "Ecrire une chanson qui redonne espoir en la vie", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRap, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission505, 0, false);
		Mission mission506 = new Mission(506, "Cambriolage amical", "Trouver un moyen d'entrer par effraction chez Yannick", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCul, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission506, itemsDebloquesMission506, 0, false);
		Mission mission507 = new Mission(507, "Le maitre et l'élève", "Admirer les techniques de combat sur chaise de Johann et en prendre de la graine de star", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCroche, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission504, itemsDebloquesMission507, 0, false);
		// TODO mission special
	
		// Sorts TOM
		Mission mission600 = new Mission(600, "La technique de la Tortue", "Développer son instinct de survie en inventant une technique personnelle de parade imparable", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTortue, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission600, 0, false);
		Mission mission601 = new Mission(601, "Scout toujours", "Survivre à une nuit en forêt en évitant les animaux, les bêtes et les attouchements des moniteurs", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateScout, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission601, 0, false);
		Mission mission602 = new Mission(602, "Coagulation nasale", "Trouver un moyen de maitriser son afflux sanguin", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateColRoulé, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission602, 0, false);
		Mission mission603 = new Mission(603, "Grand saigneur", "Inviter ses alliés à squatter dans son apart, dans son jardin et dans la voiture de son frère", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSquat, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission603, itemsDebloquesMission603, 0, false);
		Mission mission604 = new Mission(604, "Abonnement illimité", "Acheter un paquet de mouchoirs ultra-absorbants", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMillenium, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission604, 0, false);
		Mission mission605 = new Mission(605, "Mange pas mes papiers", "Acheter un briquet et bruler du papier par crémation", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDrDre, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission605, 0, false);
		Mission mission606 = new Mission(606, "Perfusion sanguine", "Trouver un moyen d'utiliser son surplus sanguin à des fins curatives", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePerfusion, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission606, 0, false);
		Mission mission607 = new Mission(607, "Expert en communication", "Faire une séance de spiritisme dans son salon", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSpiritisme, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission607, itemsDebloquesMission607, 0, false);
		// TODO mission special

		// MISSIONS REPETABLES BONUS
		
		// MISSIONS DATE FIXE

		// MISSIONS EVENEMENTS
		
		
		// MISSIONS ACHAT
		// LES DHALLIAS
		// JAFAR
		// LA TONELLE
		// TABAC
		// ARABE

		// MISSION MAISON YO
		// MISSION MAISON NICO

		// TODO objet debloqués correspondant a la mission boss
		
		// MISSIONS YO
		Mission mission1001 = new Mission(1001, "Boss Yo", "Père de Yo", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusBoss1, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, itemsNecessairesMissionBoss1, itemsDebloquesMission1001, 0, false);
		
		// MISSIONS NICO
		Mission mission1002 = new Mission(1002, "Boss Nico", "Lara Croft", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusBoss2, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS2, itemsNecessairesMissionBoss2, itemsDebloquesMission1002, 0, false);
		
		// MISSIONS PIP
		Mission mission1003 = new Mission(1003, "Boss Pip", "Dumbo", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusBoss3, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS3, itemsNecessairesMissionBoss3, itemsDebloquesMission1003, 0, false);

		// MISSIONS TOM
		Mission mission1004 = new Mission(1004, "Boss Tom", "Hitler", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusBoss4, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS4, itemsNecessairesMissionBoss4, itemsDebloquesMission1004, 0, false);

		// MISSIONS YA
		Mission mission1005 = new Mission(1005, "Boss Ya", "Kurt Skywalker", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusBoss5, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS5, itemsNecessairesMissionBoss5, itemsDebloquesMission1005, 0, false);

		// MISSIONS ALI
		Mission mission1006 = new Mission(1006, "Boss Ali", "Mickael Jackson", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusBoss6, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS6, itemsNecessairesMissionBoss6, itemsDebloquesMission1006, 0, false);

		// MISSIONS GUY
		Mission mission1007 = new Mission(1007, "Boss Guy", "Al Pacino", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusBoss7, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS7, itemsNecessairesMissionBoss7, itemsDebloquesMission1007, 0, false);

		// MISSIONS RUSS
		Mission mission1008 = new Mission(1008, "Boss Russ", "...", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusBoss8, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS8, itemsNecessairesMissionBoss8, itemsDebloquesMission1008, 0, false);

		// MISSION FINAL
		// TODO faire dependre la mission final de toutes les missions boss (item)
		// TODO (TOUS LES BOSS)
		Mission mission1000 = new Mission(1000, "Mission Final", "La fin justifie les moyens", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0, false);
		
		
		
		// TEST
		Mission mission900 = new Mission(900, "Premier Combat", "Combat tests dispo des le debut", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0, false);
		
		// MISSION DEBLOQUEE PAR ITEMS
		Mission mission901 = new Mission(901, "Les perfs", "Battre la classe de perfectionnement", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission106, new ArrayList<Item>(), 0, false);

		// MISSION DEBLOQUEE PAR DATE
		Mission mission902 = new Mission(902, "J+1", "                                          ", imagePaths1,	sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date3, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), new ArrayList<Item>(), 0, true);

		// MISSION DEBLOQUE ACTION_COMBAT

		// Missions repetables => recompenses aleatoires (popo, fric, bonus leger)

		// Ajout a la liste
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

		missions.add(mission300);
		missions.add(mission301);
		missions.add(mission302);
		missions.add(mission303);
		missions.add(mission304);
		missions.add(mission305);
		missions.add(mission306);
		missions.add(mission307);
		missions.add(mission308);
		missions.add(mission309);
		missions.add(mission310);
		
		missions.add(mission400);
		missions.add(mission401);
		missions.add(mission402);
		missions.add(mission403);
		missions.add(mission404);
		missions.add(mission405);
		missions.add(mission406);
		missions.add(mission407);
		
		missions.add(mission500);
		missions.add(mission501);
		missions.add(mission502);
		missions.add(mission503);
		missions.add(mission504);
		missions.add(mission505);
		missions.add(mission506);
		missions.add(mission507);
		
		missions.add(mission600);
		missions.add(mission601);
		missions.add(mission602);
		missions.add(mission603);
		missions.add(mission604);
		missions.add(mission605);
		missions.add(mission606);
		missions.add(mission607);
		
		missions.add(mission900);
		missions.add(mission901);
		missions.add(mission902);

		missions.add(mission1000);
		missions.add(mission1001);
		missions.add(mission1002);
		missions.add(mission1003);
		missions.add(mission1004);
		missions.add(mission1005);
		missions.add(mission1006);
		missions.add(mission1007);
		missions.add(mission1008);

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

				// ajouter mission a la liste des missions jouables +
				// suppression des autres listes
				missionsJouables.add(mission);
				if (missionsDisponibles.contains(mission)) {
					missionsDisponibles.remove(mission);
				}
				if (missionsIndisponibles.contains(mission)) {
					missionsIndisponibles.remove(mission);
				}

				// Lancer le son ou la musique associe a la mission
				MusiqueManager.playSonMission(mission.getSonPaths());

				// Lancer la video associe a la mission
				// TODO get(0)
				VideoManager.play(mission.getVideoPaths().get(0));

				// Afficher JDialog pour la mission
				int type = getTypeMission(mission);
				ImageIcon image = FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0));
				// Si il n y a pas d image, on retourne l icone par defaut d une
				// mission
				if (image.getIconWidth() == -1) {
					image =  FenetrePrincipal.getImageIcon("image/defaut/defautItemMission.jpg");
				}
				ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.PERSO_IMAGE_DIMENSION_180_180);
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
						mission.getNom() + " : " + mission.getInformations(),"Mission debloquée pour " + mission.getProprietaire().name(), type, resizeImage);

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
		boolean finduJeu = false;
		if (win) {
			mission.setDejaFaite(true);
			// Message mission win
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "Mission réussie!", mission.getNom(),
					0, FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0)));
			// TODO : Ajouter un son de victoire
			if (!mission.isRepetable()) {
				mission.setNombreWin(1);
				distribueRecompenses(mission, true);
				// TODO : ajouter la mission aux achievments
			} else {
				mission.setNombreWin(mission.getNombreWin() + 1);
				distribueRecompenses(mission, true);
			}

			// TODO Fin du jeu
			if (mission.getId() == 1000) {
				System.out.println("FIN DU JEU");

				// Musique fin du jeu
				// TODO sur un lecteur arretable
				MusiqueManager.playSonEvenement("sonParDefaut/defautFinDuJeu.mp3");

				// Message fin du jeu
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Félicitations! T'as terminé le jeu en difficulté " + mission.getDifficulty().name() + " !");
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Envoie tes statistiques sur le site pour comparer ton score avec les autres!");
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Envoie moi tes remarques/critiques/souhaits pour une eventuelle future prochaine version possible!");
				// TODO messages en fonction de la difficulte
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"T'as désormais le droit de sucer le frère d'Ali!");

				// TODO message progression/missionsTermines/missionsRates

				// TODO quitter ou continuer
				int quitter = JOptionPane.showOptionDialog(MenuPrincipal.getMainFrame(),
						"Tu peux rester dans le jeu et continuer de clicker sur suivant si tu n'as rien de mieux à faire!",
						"Fin du jeu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
						FenetrePrincipal.getImageIcon("image/defaut/defautEvenement.png"),
						new String[] { "Continuer", "Me barrer de ce jeu de merde" }, "default");
				if (quitter == 1) {
					// Retour menuPrincipal
					FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
					fenetrePrincipal.setVisible(true);
					FenetrePrincipal.joueMusiquesAmbiances();

					// Supprime le panelVideo et la MainFrame
					MenuPrincipal.getMainFrame().dispose();
					VideoManager.hideAndStop();
					MusiqueManager.stopAll();
					finduJeu = true;
				}
			}

			// Si loose
		} else {
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "Mission échouée!", mission.getNom(),
					1, FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0)));
			// TODO : Ajouter un son de defaite
			mission.setNombreEssai(mission.getNombreEssai() + 1);
			distribueRecompenses(mission, false);
		}

		// A chaque fin de mission, on passe une heure
		MenuPrincipal.getMainFrame().getCoreManager().getDateManager().passeUneHeure();

		// refresh liste missions jouables par perso
		refreshMissionsJouables();
		// TODO gestion des missions par le menu ?
		MenuPrincipal.getMainFrame().getCoreManager().getMenuManager().lanceRefreshMenu();

		// Refresh panelPerso persos morts
		if (!finduJeu) {
			MenuPrincipal.getMainFrame().getPanelPersonnage().refreshMortsPersonnage();
		}

	}

	public Mission getNextMissionAvecDateEtItemsDisponibles() {
		Mission nextMission = null;
		List<Mission> missionsIndisponibles = getMissionsIndisponiblesAvecDate();
		long minDiff = 10000000000000000L;
		for (Mission mission : missionsIndisponibles) {
			boolean itemsDisponibles = true;
			for (Item item : mission.getItemsNecessaires()) {
				if (!item.isDisponible()) {
					itemsDisponibles = false;
				}
			}
			if (itemsDisponibles) {
				long diff = MenuPrincipal.getMainFrame().getCoreManager().getDateManager().compare(mission.getDate());
				if (diff < minDiff) {
					minDiff = diff;
					nextMission = mission;
				}
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

//	private int incrementId() {
//		id = id + 1;
//		return id;
//	}

	public void distribueRecompenses(Mission mission, boolean win) {
		
		// TODO if win
		PersonnageManager personnageManager = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager();
		if (win) {
			// Debloquer les lieux a debloquer
			int idLieu = mission.getLieuDebloque();
			if (idLieu != 0) {
				Lieu lieuById = MenuPrincipal.getMainFrame().getCoreManager().getLieuManager().getLieuById(idLieu);
				if (lieuById != null) {
					lieuById.setDisponible(true);
					// Afficher JDialog pour le lieu debloque
					ImageIcon itemLieu = FenetrePrincipal.getImageIcon("image/defaut/defautLieu.png");
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
							lieuById.getProprietaire() + " a débloqué un nouveau Lieu : " + lieuById.getNom(),
							"Nouveau Lieu disponible !", 0, itemLieu);
				} else {
					System.err.println("Mauvaise identifiant de Lieu pendant le deblocage. ID = (" + idLieu + ")");
				}
			}
			
			// TODO si une mission a debloque une actionCombat
			// Debloquer les items a debloquer
			List<Item> itemsDebloques = mission.getItemsDebloques();
			for (Item item : itemsDebloques) {
				int type = JOptionPane.PLAIN_MESSAGE;
				ImageIcon itemImage = null;
				if (item.getImagePath() != null) {
					itemImage = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
				} else {
					itemImage = FenetrePrincipal.getImageIcon("image/defaut/defautItem.png");
				}
				ImageIcon resizedImage = ImageManager.resizeImage(itemImage, Constante.PERSO_IMAGE_DIMENSION_180_180);
				String itemType = item.getType().name().toLowerCase();
	
				// Si premiere fois, presentation de l'item
				if (!item.isDisponible()) {
	
					// Lancer le son par defaut nouvel item
					MusiqueManager.playSonItem("sonParDefaut/08-Zelda-item-catch.mp3");
	
					// Lancer la video associe a l item
					if (item.getVideoPaths() != null) {
						VideoManager.play(item.getVideoPaths().get(0));
					}
	
					// Afficher JDialog pour l item
					// TODO meilleur nom que ACTION_COMBAT
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
							item.getProprietaire() + " a débloqué : " + item.getNom(),
							"Nouvel item disponible !" + itemType, type, resizedImage);
					item.setDisponible(true);
				}
				
				// Si c'est un item consommable, on l'ajoute au sac du perso
				if (item.isConsommable()) {
					PersonnagePrincipal perso = null;
					PersoPrenom proprietaire = mission.getProprietaire();
					if (proprietaire == PersoPrenom.GROUPE) {
						// Si c'est une mission groupe, on l'ajoute au perso principal
						perso = personnageManager.getPersoByPrenom(personnageManager.getPersonnagePrincipal());
					} else {
						// Si c'est une mission perso
						perso = personnageManager.getPersoByPrenom(proprietaire);
					}
					Integer valeur = perso.getSac().get(item);
					// Si le perso n'a pas encore cet objet
					if (valeur == null) {
						perso.getSac().put(item, 1);
					} else {
						// Sinon on incremente
						perso.getSac().put(item, valeur + 1);
					}
					MusiqueManager.playSonItem("sonParDefaut/09-Zelda-small-item-catch.mp3");
					
					// TODO meilleur nom que ACTION_COMBAT
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), perso.getPrenom()
							+ " a gagné : " + item.getNom(), "Nouvel item !" + itemType, type, resizedImage);
				}
			}
		}

		// TODO mieux (perso present pendant la mission) Distribution des bonus/malus
		Groupe leGroupe = personnageManager.getLeGroupe();
		if (win) {
			BonusManager.distribueBonus(leGroupe, mission.getGain());
		} else {
			BonusManager.distribueBonus(leGroupe, mission.getPerte());
		}

		// Si une mission a debloque un perso
		MainFrame.getPanelPersonnage().refreshArriveePersonnage();
	}

}

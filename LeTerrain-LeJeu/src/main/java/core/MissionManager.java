package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import core.configuration.Constante;
import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import modele.bonus.Bonus;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.lieu.Lieu;
import modele.item.mission.BossNom;
import modele.item.mission.Mission;
import modele.item.mission.enums.Difficulte;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.EnnemiType;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.Personnage;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.jeu.Jeu;

public class MissionManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Mission> missions;
	private List<Mission> missionsDisponibles;
	private List<Mission> missionsIndisponibles;
	private List<Mission> missionsJouables;
	private List<Mission> missionsTerminees;
	private Difficulte difficultePartie;

	public void initialise(Difficulte difficultePartie, ActionCombatManager actionCombatManager,
			PersonnageManager personnageManager, ItemManager itemManager) {

		this.difficultePartie = difficultePartie;
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
		
		List<String> imagePaths404 = new ArrayList<String>();
		String imagePath404 = "image/mission/guillaumeFroissard.jpg";
		imagePaths404.add(imagePath404);
		
		List<String> imagePaths1001 = new ArrayList<String>();
		String imagePath1001 = "image/mission/boss/ballon.png";
		imagePaths1001.add(imagePath1001);
		
		List<String> imagePaths1002 = new ArrayList<String>();
		String imagePath1002 = "image/mission/boss/laureSaintClair.png";
		imagePaths1002.add(imagePath1002);
		
		List<String> imagePaths1003 = new ArrayList<String>();
		String imagePath1003 = "image/mission/boss/eminem.png";
		imagePaths1003.add(imagePath1003);
		
		List<String> imagePaths1004 = new ArrayList<String>();
		String imagePath1004 = "image/mission/boss/dieudonne.png";
		imagePaths1004.add(imagePath1004);
		
		List<String> imagePaths1005 = new ArrayList<String>();
		String imagePath1005 = "image/mission/boss/lego.png";
		imagePaths1005.add(imagePath1005);
		
		List<String> imagePaths1006 = new ArrayList<String>();
		String imagePath1006 = "image/mission/boss/gants.png";
		imagePaths1006.add(imagePath1006);
		
		List<String> imagePaths1007 = new ArrayList<String>();
		String imagePath1007 = "image/mission/boss/scream.png";
		imagePaths1007.add(imagePath1007);
		
		List<String> imagePaths1008 = new ArrayList<String>();
		String imagePath1008 = "image/mission/boss/serge.png";
		imagePaths1008.add(imagePath1008);

		// Sons
		List<String> sonPathsFilm = new ArrayList<String>();
		String sonPathFilm = "sonParDefaut/film.mp3";
		sonPathsFilm.add(sonPathFilm);
		
		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "sonParDefaut/inception.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);

		// Videos
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "video/Trololo.mp4";
		videoPaths1.add(videoPath1);

		///////////
		// DATES //
		///////////
		
		// TODO bonnes Dates
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 9, 00, 00);
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 17, 00, 00);
		Date date3 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 4, 9, 00, 00);
		Date dateNull = null;
		
		Date dateCleTerrain = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 1, 9, 00, 00);
	
		Date dateRencontreAli = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 7, 14, 00, 00);
		Date dateRencontreGuy = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 7, 14, 00, 00);
		Date dateRencontreJo = DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 7, 14, 00, 00);
		
		// Russ
		Date dateTrilogie = DateManager.genereUneDate(1999, Calendar.DECEMBER, 6, 21, 00, 00);
		Date dateAchatRequins = DateManager.genereUneDate(1999, Calendar.DECEMBER, 25, 9, 00, 00);
		Date dateAchatPunto = DateManager.genereUneDate(2001, Calendar.MAY, 19, 14, 00, 00);
		Date datePoil = DateManager.genereUneDate(1999, Calendar.OCTOBER, 7, 14, 00, 00);
		Date dateGSM = DateManager.genereUneDate(2000, Calendar.JANUARY, 7, 14, 00, 00);
		Date dateRasage = DateManager.genereUneDate(2000, Calendar.MAY, 7, 14, 00, 00);
		Date dateGraisse = DateManager.genereUneDate(2000, Calendar.JUNE, 7, 14, 00, 00);
		Date dateStCyprien = DateManager.genereUneDate(2001, Calendar.JULY, 14, 14, 00, 00);
		
		// Guy
		Date dateAzopardi = DateManager.genereUneDate(2002, Calendar.AUGUST, 19, 19, 00, 00);
		Date dateAchatDoudoune = DateManager.genereUneDate(1999, Calendar.DECEMBER, 25, 10, 00, 00);
		Date dateJonglerettes = DateManager.genereUneDate(1998, Calendar.JUNE, 7, 14, 00, 00);
		Date dateGuyApart = DateManager.genereUneDate(2001, Calendar.JUNE, 21, 14, 00, 00);
		Date dateFacebook = DateManager.genereUneDate(2004, Calendar.MARCH, 1, 14, 00, 00);
		Date dateEscargot = DateManager.genereUneDate(2002, Calendar.JUNE, 18, 19, 00, 00);
		Date dateIngurgite = DateManager.genereUneDate(2001, Calendar.JULY, 18, 19, 00, 00);
		Date dateBite = DateManager.genereUneDate(2010, Calendar.MAY, 1, 19, 00, 00);
		Date dateAzopardi2 = DateManager.genereUneDate(2002, Calendar.AUGUST, 23, 19, 00, 00);
		
		// Ali
		Date date911 = DateManager.genereUneDate(2001, Calendar.SEPTEMBER, 11, 12, 0, 0);
		Date datePermisVoler = DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateSAV = DateManager.genereUneDate(2005, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateEspagne = DateManager.genereUneDate(1999, Calendar.AUGUST, 11, 14, 00, 00);
		Date dateLacrymo = DateManager.genereUneDate(2002, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateRap = DateManager.genereUneDate(2010, Calendar.MAY, 8, 14, 00, 00);
		Date dateCul = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateCroche = DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateAliAli = DateManager.genereUneDate(2009, Calendar.SEPTEMBER, 6, 21, 00, 00);

		// Tom
		Date dateTortue = DateManager.genereUneDate(1991, Calendar.SEPTEMBER, 5, 12, 0, 0);
		Date dateScout = DateManager.genereUneDate(1994, Calendar.SEPTEMBER, 5, 14, 00, 00);
		Date dateColRoulé = DateManager.genereUneDate(1990, Calendar.OCTOBER, 11, 14, 00, 00);
		Date dateSquat = DateManager.genereUneDate(1997, Calendar.JUNE, 7, 14, 00, 00);
		Date dateMillenium = DateManager.genereUneDate(1999, Calendar.NOVEMBER, 1, 14, 00, 00);
		Date dateDrDre = DateManager.genereUneDate(2000, Calendar.JULY, 18, 14, 00, 00);
		Date datePerfusion = DateManager.genereUneDate(1990, Calendar.NOVEMBER, 11, 14, 00, 00);
		Date dateSpiritisme = DateManager.genereUneDate(1997, Calendar.JUNE, 25, 14, 00, 00);
		Date dateFreres = DateManager.genereUneDate(2000, Calendar.AUGUST, 25, 14, 00, 00);
		
		// Ya
		Date datePoker = DateManager.genereUneDate(1998, Calendar.MAY, 20, 14, 00, 00);
		Date dateGrotte = DateManager.genereUneDate(1996, Calendar.MAY, 18, 14, 00, 00);
		Date dateEau = DateManager.genereUneDate(1999, Calendar.MAY, 16, 14, 00, 00);
		Date dateBase = DateManager.genereUneDate(1997, Calendar.DECEMBER, 31, 20, 00, 00);
		Date dateBuffy = DateManager.genereUneDate(2003, Calendar.OCTOBER, 17, 20, 00, 00);
		Date dateRomeo = DateManager.genereUneDate(1997, Calendar.APRIL, 9, 20, 00, 00);
		Date date6eme = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 15, 10, 00, 00);
		Date dateBalcon = DateManager.genereUneDate(1997, Calendar.JUNE, 15, 21, 00, 00);
		Date dateWorms = DateManager.genereUneDate(1999, Calendar.JULY, 4, 21, 00, 00);

		// Pip
		Date dateCa = DateManager.genereUneDate(1993, Calendar.OCTOBER, 16, 21, 00, 00);
		Date dateNoel = DateManager.genereUneDate(1992, Calendar.DECEMBER, 25, 10, 00, 00);
		Date dateFlaque = DateManager.genereUneDate(1999, Calendar.JULY, 25, 14, 00, 00);
		Date dateMole = DateManager.genereUneDate(2000, Calendar.SEPTEMBER, 11, 14, 00, 00);
		Date dateBranlette = DateManager.genereUneDate(1997, Calendar.JUNE, 30, 14, 00, 00);
		Date dateRacaille = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 30, 14, 00, 00);
		Date date2000 = DateManager.genereUneDate(2000, Calendar.JANUARY, 1, 9, 00, 00);
		Date dateBoysBand = DateManager.genereUneDate(1998, Calendar.MAY, 14, 9, 00, 00);
		Date dateOptic2000 = DateManager.genereUneDate(2001, Calendar.JANUARY, 1, 9, 00, 00);
		
		// Nico
		Date dateStreetFighter = DateManager.genereUneDate(1993, Calendar.MAY, 1, 13, 00, 00);
		Date dateDBZ = DateManager.genereUneDate(1996, Calendar.JANUARY, 31, 10, 00, 00);		
		Date dateStade = DateManager.genereUneDate(1996, Calendar.JUNE, 20, 15, 00, 00);		
		Date dateMatrix = DateManager.genereUneDate(1999, Calendar.MARCH, 31, 18, 00, 00);		
		Date dateXMen = DateManager.genereUneDate(2000, Calendar.AUGUST, 16, 18, 00, 00);
		Date dateRapTout = DateManager.genereUneDate(1991, Calendar.JUNE, 14, 18, 00, 00);		
		Date dateMiranda = DateManager.genereUneDate(1998, Calendar.DECEMBER, 24, 18, 00, 00);		
		Date dateMuscu = DateManager.genereUneDate(1999, Calendar.MARCH, 20, 18, 00, 00);		
		Date dateMortalKombat = DateManager.genereUneDate(1996, Calendar.NOVEMBER, 21, 18, 00, 00);		

		// Yo
		Date datePisse = DateManager.genereUneDate(1997, Calendar.AUGUST, 25, 18, 00, 00);
		Date dateCarnaval = DateManager.genereUneDate(1993, Calendar.JUNE, 13, 15, 00, 00);		
		Date dateBooster = DateManager.genereUneDate(2001, Calendar.JUNE, 20, 15, 00, 00);		
		Date dateWow = DateManager.genereUneDate(2004, Calendar.NOVEMBER, 24, 18, 00, 00);		
		Date dateEscalope = DateManager.genereUneDate(1999, Calendar.AUGUST, 16, 18, 00, 00);
		Date datePlantage = DateManager.genereUneDate(1993, Calendar.MARCH, 14, 14, 00, 00);		
		Date dateDance = DateManager.genereUneDate(1994, Calendar.JANUARY, 2, 18, 00, 00);		
		Date dateHalloween = DateManager.genereUneDate(1997, Calendar.OCTOBER, 31, 18, 00, 00);	
		Date dateChiasse = DateManager.genereUneDate(1998, Calendar.MARCH, 20, 18, 00, 00);	
		
		// Date Mini Boss de fin d'année
		Date dateMiniBoss11 = DateManager.genereUneDate(1991, Calendar.JUNE, 20, 9, 00, 00);	
		Date dateMiniBoss12 = DateManager.genereUneDate(1992, Calendar.JUNE, 20, 9, 00, 00);	
		Date dateMiniBoss13 = DateManager.genereUneDate(1993, Calendar.JUNE, 20, 9, 00, 00);	
		Date dateMiniBoss14 = DateManager.genereUneDate(1994, Calendar.JUNE, 20, 9, 00, 00);	
		Date dateMiniBoss15 = DateManager.genereUneDate(1995, Calendar.JUNE, 20, 9, 00, 00);	
		
		///////////
		// BONUS //
		///////////
		
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
		Bonus bonusBoss7 = BonusManager.getBonusById(107);
		Bonus bonusBoss8 = BonusManager.getBonusById(108);
		Bonus bonusBoss11 = BonusManager.getBonusById(111);
		Bonus bonusBoss12 = BonusManager.getBonusById(112);
		Bonus bonusBoss13 = BonusManager.getBonusById(113);
		Bonus bonusBoss14 = BonusManager.getBonusById(114);
		Bonus bonusBoss15 = BonusManager.getBonusById(115);

		///////////////////////
		// ITEMS A DEBLOQUER //
		///////////////////////
		
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

		Item ballon_dor = itemManager.getItemById(1001);
		Item grappin_dor = itemManager.getItemById(1002);
		Item medaille_dor = itemManager.getItemById(1003);
		Item mouchoir_dor = itemManager.getItemById(1004);
		Item sabre_dor = itemManager.getItemById(1005);
		Item micro_dor = itemManager.getItemById(1006);
		Item coupe_dor = itemManager.getItemById(1007);
		Item palme_dor = itemManager.getItemById(1008);

		///////////////////////
		// ITEMS NECESSAIRES //
		///////////////////////

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

		// Mission 311
		List<Item> itemsNecessairesMission311 = new ArrayList<Item>();
		itemsNecessairesMission311.add(graisseATraire);
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));

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
		
		// Mission 508
		List<Item> itemsNecessairesMission508 = new ArrayList<Item>();
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
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
		
		// Mission 700
		List<Item> itemsNecessairesMission700 = new ArrayList<Item>();
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 701
		List<Item> itemsNecessairesMission701 = new ArrayList<Item>();
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 702
		List<Item> itemsNecessairesMission702 = new ArrayList<Item>();
		itemsNecessairesMission702.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission702.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		
		// Mission 703
		List<Item> itemsNecessairesMission703 = new ArrayList<Item>();
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 707
		List<Item> itemsNecessairesMission707 = new ArrayList<Item>();
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission 708
		List<Item> itemsNecessairesMission708 = new ArrayList<Item>();
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 808
		List<Item> itemsNecessairesMission808 = new ArrayList<Item>();
		itemsNecessairesMission808.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission808.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission 900
		List<Item> itemsNecessairesMission900 = new ArrayList<Item>();
		itemsNecessairesMission900.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission900.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission 907
		List<Item> itemsNecessairesMission907 = new ArrayList<Item>();
		itemsNecessairesMission907.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission907.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));

		// Mission 1100
		List<Item> itemsNecessairesMission1100 = new ArrayList<Item>();
		itemsNecessairesMission1100.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission1100.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 1105
		List<Item> itemsNecessairesMission1105 = new ArrayList<Item>();
		itemsNecessairesMission1105.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission1105.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission1105.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission 1108
		List<Item> itemsNecessairesMission1108 = new ArrayList<Item>();
		itemsNecessairesMission1108.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission1108.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission 1000 (Mission Finale)
		List<Item> itemsNecessairesMissionFinale = new ArrayList<Item>();
		itemsNecessairesMissionFinale.add(ballon_dor);
		itemsNecessairesMissionFinale.add(grappin_dor);
		itemsNecessairesMissionFinale.add(medaille_dor);
		itemsNecessairesMissionFinale.add(mouchoir_dor);
		itemsNecessairesMissionFinale.add(sabre_dor);
		itemsNecessairesMissionFinale.add(micro_dor);
		itemsNecessairesMissionFinale.add(coupe_dor);
		itemsNecessairesMissionFinale.add(palme_dor);
		
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
		
		// Mission Ya
		List<Item> itemsNecessairesMissionYa = new ArrayList<Item>();
		itemsNecessairesMissionYa.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		
		// Mission Pip
		List<Item> itemsNecessairesMissionPip = new ArrayList<Item>();
		itemsNecessairesMissionPip.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission Nico
		List<Item> itemsNecessairesMissionNico = new ArrayList<Item>();
		itemsNecessairesMissionNico.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission Yo
		List<Item> itemsNecessairesMissionYo = new ArrayList<Item>();
		itemsNecessairesMissionYo.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		
		// Missions Boss
		// TODO : verifier que les items debloques correspondent aux SPECIAL
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
		
		List<Item> itemsNecessairesMissionMiniBoss = new ArrayList<Item>();
		itemsNecessairesMissionMiniBoss.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMissionMiniBoss.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMissionMiniBoss.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMissionMiniBoss.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMissionMiniBoss.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		
		
		///////////////////////
		// ITEMS A DEBLOQUER //
		///////////////////////

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
		
		//////////////////////////
		// POUVOIRS A DEBLOQUER //
		//////////////////////////

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
		
		// Mission 311
		List<Item> itemsDebloquesMission311 = new ArrayList<Item>();
		itemsDebloquesMission311.add(actionCombatManager.getActionById(882));
		
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

		// Mission 408
		List<Item> itemsDebloquesMission408 = new ArrayList<Item>();
		itemsDebloquesMission408.add(actionCombatManager.getActionById(681));

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
		
		// Mission 508
		List<Item> itemsDebloquesMission508 = new ArrayList<Item>();
		itemsDebloquesMission508.add(actionCombatManager.getActionById(781));

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
		
		// Mission 608
		List<Item> itemsDebloquesMission608 = new ArrayList<Item>();
		itemsDebloquesMission608.add(actionCombatManager.getActionById(581));

		// Mission 700
		List<Item> itemsDebloquesMission700 = new ArrayList<Item>();
		itemsDebloquesMission700.add(actionCombatManager.getActionById(412));
		
		// Mission 701
		List<Item> itemsDebloquesMission701 = new ArrayList<Item>();
		itemsDebloquesMission701.add(actionCombatManager.getActionById(414));
	
		// Mission 702
		List<Item> itemsDebloquesMission702 = new ArrayList<Item>();
		itemsDebloquesMission702.add(actionCombatManager.getActionById(416));
		
		// Mission 703
		List<Item> itemsDebloquesMission703 = new ArrayList<Item>();
		itemsDebloquesMission703.add(actionCombatManager.getActionById(417));
		
		// Mission 704
		List<Item> itemsDebloquesMission704 = new ArrayList<Item>();
		itemsDebloquesMission704.add(actionCombatManager.getActionById(439));
		
		// Mission 705
		List<Item> itemsDebloquesMission705 = new ArrayList<Item>();
		itemsDebloquesMission705.add(actionCombatManager.getActionById(442));
		
		// Mission 706
		List<Item> itemsDebloquesMission706 = new ArrayList<Item>();
		itemsDebloquesMission706.add(actionCombatManager.getActionById(446));
		
		// Mission 707
		List<Item> itemsDebloquesMission707 = new ArrayList<Item>();
		itemsDebloquesMission707.add(actionCombatManager.getActionById(448));
		
		// Mission 708
		List<Item> itemsDebloquesMission708 = new ArrayList<Item>();
		itemsDebloquesMission708.add(actionCombatManager.getActionById(481));
		
		// Mission 800
		List<Item> itemsDebloquesMission800 = new ArrayList<Item>();
		itemsDebloquesMission800.add(actionCombatManager.getActionById(302));
		
		// Mission 801
		List<Item> itemsDebloquesMission801 = new ArrayList<Item>();
		itemsDebloquesMission801.add(actionCombatManager.getActionById(313));
	
		// Mission 802
		List<Item> itemsDebloquesMission802 = new ArrayList<Item>();
		itemsDebloquesMission802.add(actionCombatManager.getActionById(314));
		
		// Mission 803
		List<Item> itemsDebloquesMission803 = new ArrayList<Item>();
		itemsDebloquesMission803.add(actionCombatManager.getActionById(317));
		
		// Mission 804
		List<Item> itemsDebloquesMission804 = new ArrayList<Item>();
		itemsDebloquesMission804.add(actionCombatManager.getActionById(334));
		
		// Mission 805
		List<Item> itemsDebloquesMission805 = new ArrayList<Item>();
		itemsDebloquesMission805.add(actionCombatManager.getActionById(338));
		
		// Mission 806
		List<Item> itemsDebloquesMission806 = new ArrayList<Item>();
		itemsDebloquesMission806.add(actionCombatManager.getActionById(343));
		
		// Mission 807
		List<Item> itemsDebloquesMission807 = new ArrayList<Item>();
		itemsDebloquesMission807.add(actionCombatManager.getActionById(346));
		
		// Mission 808
		List<Item> itemsDebloquesMission808 = new ArrayList<Item>();
		itemsDebloquesMission808.add(actionCombatManager.getActionById(381));
		
		// Mission 900
		List<Item> itemsDebloquesMission900 = new ArrayList<Item>();
		itemsDebloquesMission900.add(actionCombatManager.getActionById(202));
		
		// Mission 901
		List<Item> itemsDebloquesMission901 = new ArrayList<Item>();
		itemsDebloquesMission901.add(actionCombatManager.getActionById(212));
	
		// Mission 902
		List<Item> itemsDebloquesMission902 = new ArrayList<Item>();
		itemsDebloquesMission902.add(actionCombatManager.getActionById(217));
		
		// Mission 903
		List<Item> itemsDebloquesMission903 = new ArrayList<Item>();
		itemsDebloquesMission903.add(actionCombatManager.getActionById(218));
		
		// Mission 904
		List<Item> itemsDebloquesMission904 = new ArrayList<Item>();
		itemsDebloquesMission904.add(actionCombatManager.getActionById(231));
		
		// Mission 905
		List<Item> itemsDebloquesMission905 = new ArrayList<Item>();
		itemsDebloquesMission905.add(actionCombatManager.getActionById(234));
		
		// Mission 906
		List<Item> itemsDebloquesMission906 = new ArrayList<Item>();
		itemsDebloquesMission906.add(actionCombatManager.getActionById(241));
		
		// Mission 907
		List<Item> itemsDebloquesMission907 = new ArrayList<Item>();
		itemsDebloquesMission907.add(actionCombatManager.getActionById(248));
		
		// Mission 908
		List<Item> itemsDebloquesMission908 = new ArrayList<Item>();
		itemsDebloquesMission908.add(actionCombatManager.getActionById(281));
		
		// Mission 1100
		List<Item> itemsDebloquesMission1100 = new ArrayList<Item>();
		itemsDebloquesMission1100.add(actionCombatManager.getActionById(112));
		
		// Mission 1101
		List<Item> itemsDebloquesMission1101 = new ArrayList<Item>();
		itemsDebloquesMission1101.add(actionCombatManager.getActionById(113));
		
		// Mission 1102
		List<Item> itemsDebloquesMission1102 = new ArrayList<Item>();
		itemsDebloquesMission1102.add(actionCombatManager.getActionById(117));
		
		// Mission 1103
		List<Item> itemsDebloquesMission1103 = new ArrayList<Item>();
		itemsDebloquesMission1103.add(actionCombatManager.getActionById(118));
		
		// Mission 1104
		List<Item> itemsDebloquesMission1104 = new ArrayList<Item>();
		itemsDebloquesMission1104.add(actionCombatManager.getActionById(131));
		
		// Mission 1105
		List<Item> itemsDebloquesMission1105 = new ArrayList<Item>();
		itemsDebloquesMission1105.add(actionCombatManager.getActionById(139));
		
		// Mission 1106
		List<Item> itemsDebloquesMission1106 = new ArrayList<Item>();
		itemsDebloquesMission1106.add(actionCombatManager.getActionById(145));
		
		// Mission 1107
		List<Item> itemsDebloquesMission1107 = new ArrayList<Item>();
		itemsDebloquesMission1107.add(actionCombatManager.getActionById(147));
		
		// Mission 1108
		List<Item> itemsDebloquesMission1108 = new ArrayList<Item>();
		itemsDebloquesMission1108.add(actionCombatManager.getActionById(181));
		
		/////////////////////////
		// ITEMS MISSIONS BOSS //
		/////////////////////////
		
		// TODO items debloqués apres missions boss
		
		// BOSS FINAUX
		
		// Mission 1001
		List<Item> itemsDebloquesMission1001 = new ArrayList<Item>();
		itemsDebloquesMission1001.add(ballon_dor);
		itemsDebloquesMission1001.add(bonusChance20);
		itemsDebloquesMission1001.add(popoVie100);
		itemsDebloquesMission1001.add(popoMana100);
		
		// Mission 1002
		List<Item> itemsDebloquesMission1002 = new ArrayList<Item>();
		itemsDebloquesMission1002.add(grappin_dor);
		itemsDebloquesMission1002.add(bonusExploit20);
		itemsDebloquesMission1002.add(popoVie100);
		itemsDebloquesMission1002.add(popoMana100);
		
		// Mission 1003
		List<Item> itemsDebloquesMission1003 = new ArrayList<Item>();
		itemsDebloquesMission1003.add(medaille_dor);
		itemsDebloquesMission1003.add(bonusAgilite20);
		itemsDebloquesMission1003.add(popoVie100);
		itemsDebloquesMission1003.add(popoMana100);
		
		// Mission 1004
		List<Item> itemsDebloquesMission1004 = new ArrayList<Item>();
		itemsDebloquesMission1004.add(mouchoir_dor);
		itemsDebloquesMission1004.add(bonusIntelligence20);
		itemsDebloquesMission1004.add(popoVie100);
		itemsDebloquesMission1004.add(popoMana100);
		
		// Mission 1005
		List<Item> itemsDebloquesMission1005 = new ArrayList<Item>();
		itemsDebloquesMission1005.add(sabre_dor);
		itemsDebloquesMission1005.add(bonusResistance20);
		itemsDebloquesMission1005.add(popoVie100);
		itemsDebloquesMission1005.add(popoMana100);
		
		// Mission 1006
		List<Item> itemsDebloquesMission1006 = new ArrayList<Item>();
		itemsDebloquesMission1006.add(micro_dor);
		itemsDebloquesMission1006.add(bonusRapidite20);
		itemsDebloquesMission1006.add(popoVie100);
		itemsDebloquesMission1006.add(popoMana100);
		
		// Mission 1007
		List<Item> itemsDebloquesMission1007 = new ArrayList<Item>();
		itemsDebloquesMission1007.add(coupe_dor);
		itemsDebloquesMission1007.add(bonusTechnique20);
		itemsDebloquesMission1007.add(popoVie100);
		itemsDebloquesMission1007.add(popoMana100);
		
		// Mission 1008
		List<Item> itemsDebloquesMission1008 = new ArrayList<Item>();
		itemsDebloquesMission1008.add(palme_dor);
		itemsDebloquesMission1008.add(bonusEndurance20);
		itemsDebloquesMission1008.add(popoVie100);
		itemsDebloquesMission1008.add(popoMana100);
		
		// MINI BOSS ECOLE
		
		// Mission 1011
		List<Item> itemsDebloquesMission1011 = new ArrayList<Item>();
		itemsDebloquesMission1011.add(popoVie50);
		itemsDebloquesMission1011.add(popoMana50);
		
		// Mission 1012
		List<Item> itemsDebloquesMission1012 = new ArrayList<Item>();
		itemsDebloquesMission1012.add(popoVie50);
		itemsDebloquesMission1012.add(popoMana50);
		
		// Mission 1013
		List<Item> itemsDebloquesMission1013 = new ArrayList<Item>();
		itemsDebloquesMission1013.add(popoVie50);
		itemsDebloquesMission1013.add(popoMana50);
		
		// Mission 1014
		List<Item> itemsDebloquesMission1014 = new ArrayList<Item>();
		itemsDebloquesMission1014.add(popoVie50);
		itemsDebloquesMission1014.add(popoMana50);
		
		// Mission 1015
		List<Item> itemsDebloquesMission1015 = new ArrayList<Item>();
		itemsDebloquesMission1015.add(popoVie50);
		itemsDebloquesMission1015.add(popoMana50);
		
		// MISSIONS PRINCIPAL
		// Deblocages des persos et domiciles
		Mission mission101 = new Mission(101, "Rencontrer Johann", 		"Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission101, 1, false);
		Mission mission102 = new Mission(102, "Rencontrer Pierre", 		"Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission102, 2, false);
		Mission mission103 = new Mission(103, "Rencontrer Nicolas", 	"Rassembler le groupe", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,	MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null,	new ArrayList<Item>(), itemsDebloquesMission103, 3, false);
		Mission mission104 = new Mission(104, "Rencontrer Yannick", 	"Rassembler le groupe", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,	MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null,	new ArrayList<Item>(), itemsDebloquesMission104, 4, false);
		Mission mission105 = new Mission(105, "Rencontrer Thomas", 		"Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission105, 5, false);
		Mission mission106 = new Mission(106, "Rencontrer Ali", 		"Rassembler le groupe", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreAli, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission106, 6, false);
		Mission mission107 = new Mission(107, "Rencontrer Guillaume", 	"Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreGuy, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM,	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission107, 7, false);
		Mission mission108 = new Mission(108, "Rencontrer Jonathan", 	"Rassembler le groupe", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreJo, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission108, 8, false);

		// MISSIONS ECOLE

		// MISSIONS TERRAIN
		// Deblocage du lieu : Terrain
		Mission mission200 = new Mission(200, "Le terrain, gratuit et illimité", "Avoir les clés du terrain", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCleTerrain, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM,	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnageSecondaire>(), null, new ArrayList<Item>(), itemsDebloquesMission200, 10, false);
		Mission mission201 = new Mission(201, "Se dépenser sans compter", "Jouer au foot", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTerrain, new ArrayList<Item>(), 0, true);
		Mission mission202 = new Mission(202, "Le Bedo, c'est de la merde", "Fumer un pet", imagePaths1, sonPaths1,	videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull,	MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTerrain, new ArrayList<Item>(), 0, false);

		// MISSIONS TONELLE
		// TODO Deblocage du lieu : La Tonelle
		
		// MISSIONS ACTION COMBAT
		
		// Sorts RUSS
		// TODO verifier : date + objet requis => ???
		// TODO titre trop long mission 310
		Mission mission310 = new Mission(310, ConfigurationManager.getProperties("mission.jonathan.310.nom"), ConfigurationManager.getProperties("mission.jonathan.310.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePoil, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission310, 0, false);
		Mission mission309 = new Mission(309, ConfigurationManager.getProperties("mission.jonathan.309.nom"), ConfigurationManager.getProperties("mission.jonathan.309.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTrilogie, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission309, 0, false);
		Mission mission308 = new Mission(308, ConfigurationManager.getProperties("mission.jonathan.308.nom"), ConfigurationManager.getProperties("mission.jonathan.308.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGSM, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission308, 0, false);
		Mission mission307 = new Mission(307, ConfigurationManager.getProperties("mission.jonathan.307.nom"), ConfigurationManager.getProperties("mission.jonathan.307.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission306, itemsDebloquesMission307, 0, false);
		Mission mission306 = new Mission(306, ConfigurationManager.getProperties("mission.jonathan.306.nom"), ConfigurationManager.getProperties("mission.jonathan.306.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission306, itemsDebloquesMission306, 0, false);
			Mission mission305 = new Mission(305, ConfigurationManager.getProperties("mission.jonathan.305.nom"), ConfigurationManager.getProperties("mission.jonathan.305.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGraisse, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission305, 0, false);
			Mission mission304 = new Mission(304, ConfigurationManager.getProperties("mission.jonathan.304.nom"), ConfigurationManager.getProperties("mission.jonathan.304.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRasage, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, new ArrayList<Item>(), 0, false);
			Mission mission303 = new Mission(303, ConfigurationManager.getProperties("mission.jonathan.303.nom"), ConfigurationManager.getProperties("mission.jonathan.303.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusPiscine, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, new ArrayList<Item>(), 0, true);
		Mission mission300 = new Mission(300, ConfigurationManager.getProperties("mission.jonathan.300.nom"), ConfigurationManager.getProperties("mission.jonathan.300.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission300, itemsDebloquesMission300, 0, false);
		Mission mission302 = new Mission(302, ConfigurationManager.getProperties("mission.jonathan.302.nom"), ConfigurationManager.getProperties("mission.jonathan.302.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatPunto, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission302, 0, false);
		Mission mission301 = new Mission(301, ConfigurationManager.getProperties("mission.jonathan.301.nom"), ConfigurationManager.getProperties("mission.jonathan.301.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatRequins, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission301, 0, false);
		Mission mission311 = new Mission(311, ConfigurationManager.getProperties("mission.jonathan.311.nom"), ConfigurationManager.getProperties("mission.jonathan.311.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateStCyprien, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission311, itemsDebloquesMission311, 0, false);

		// Sorts GUY
		Mission mission400 = new Mission(400, ConfigurationManager.getProperties("mission.guillaume.400.nom"), ConfigurationManager.getProperties("mission.guillaume.400.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAzopardi, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission400, 0, false);
		Mission mission401 = new Mission(401, ConfigurationManager.getProperties("mission.guillaume.401.nom"), ConfigurationManager.getProperties("mission.guillaume.401.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatDoudoune, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission401, 0, false);
		Mission mission402 = new Mission(402, ConfigurationManager.getProperties("mission.guillaume.402.nom"), ConfigurationManager.getProperties("mission.guillaume.402.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateJonglerettes, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission402, 0, false);
		Mission mission403 = new Mission(403, ConfigurationManager.getProperties("mission.guillaume.403.nom"), ConfigurationManager.getProperties("mission.guillaume.403.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGuyApart, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission403, 0, false);
		Mission mission404 = new Mission(404, ConfigurationManager.getProperties("mission.guillaume.404.nom"), ConfigurationManager.getProperties("mission.guillaume.404.inf"), imagePaths404, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFacebook, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission404, 0, false);
		Mission mission405 = new Mission(405, ConfigurationManager.getProperties("mission.guillaume.405.nom"), ConfigurationManager.getProperties("mission.guillaume.405.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEscargot, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission405, 0, false);
		Mission mission406 = new Mission(406, ConfigurationManager.getProperties("mission.guillaume.406.nom"), ConfigurationManager.getProperties("mission.guillaume.406.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateIngurgite, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission406, 0, false);
		Mission mission407 = new Mission(407, ConfigurationManager.getProperties("mission.guillaume.407.nom"), ConfigurationManager.getProperties("mission.guillaume.407.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBite, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission407, 0, false);
		Mission mission408 = new Mission(408, ConfigurationManager.getProperties("mission.guillaume.408.nom"), ConfigurationManager.getProperties("mission.guillaume.408.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAzopardi2, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission408, 0, false);
		
		// Sorts ALI
		Mission mission500 = new Mission(500, ConfigurationManager.getProperties("mission.ali.500.nom"), ConfigurationManager.getProperties("mission.ali.500.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date911, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission500, 0, false);
		Mission mission501 = new Mission(501, ConfigurationManager.getProperties("mission.ali.501.nom"), ConfigurationManager.getProperties("mission.ali.501.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePermisVoler, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission501, 0, false);
		Mission mission502 = new Mission(502, ConfigurationManager.getProperties("mission.ali.502.nom"), ConfigurationManager.getProperties("mission.ali.502.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSAV, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission502, 0, false);
		Mission mission503 = new Mission(503, ConfigurationManager.getProperties("mission.ali.503.nom"), ConfigurationManager.getProperties("mission.ali.503.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEspagne, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission503, 0, false);
		Mission mission504 = new Mission(504, ConfigurationManager.getProperties("mission.ali.504.nom"), ConfigurationManager.getProperties("mission.ali.504.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateLacrymo, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission504, itemsDebloquesMission504, 0, false);
		Mission mission505 = new Mission(505, ConfigurationManager.getProperties("mission.ali.505.nom"), ConfigurationManager.getProperties("mission.ali.505.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRap, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission505, 0, false);
		Mission mission506 = new Mission(506, ConfigurationManager.getProperties("mission.ali.506.nom"), ConfigurationManager.getProperties("mission.ali.506.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCul, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission506, itemsDebloquesMission506, 0, false);
		Mission mission507 = new Mission(507, ConfigurationManager.getProperties("mission.ali.507.nom"), ConfigurationManager.getProperties("mission.ali.507.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCroche, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission504, itemsDebloquesMission507, 0, false);
		Mission mission508 = new Mission(508, ConfigurationManager.getProperties("mission.ali.508.nom"), ConfigurationManager.getProperties("mission.ali.508.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAliAli, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission508, itemsDebloquesMission508, 0, false);
	
		// Sorts TOM
		Mission mission600 = new Mission(600, ConfigurationManager.getProperties("mission.thomas.600.nom"), ConfigurationManager.getProperties("mission.thomas.600.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTortue, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission600, 0, false);
		Mission mission601 = new Mission(601, ConfigurationManager.getProperties("mission.thomas.601.nom"), ConfigurationManager.getProperties("mission.thomas.601.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateScout, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission601, 0, false);
		Mission mission602 = new Mission(602, ConfigurationManager.getProperties("mission.thomas.602.nom"), ConfigurationManager.getProperties("mission.thomas.602.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateColRoulé, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission602, 0, false);
		Mission mission603 = new Mission(603, ConfigurationManager.getProperties("mission.thomas.603.nom"), ConfigurationManager.getProperties("mission.thomas.603.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSquat, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission603, itemsDebloquesMission603, 0, false);
		Mission mission604 = new Mission(604, ConfigurationManager.getProperties("mission.thomas.604.nom"), ConfigurationManager.getProperties("mission.thomas.604.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMillenium, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission604, 0, false);
		Mission mission605 = new Mission(605, ConfigurationManager.getProperties("mission.thomas.605.nom"), ConfigurationManager.getProperties("mission.thomas.605.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDrDre, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission605, 0, false);
		Mission mission606 = new Mission(606, ConfigurationManager.getProperties("mission.thomas.606.nom"), ConfigurationManager.getProperties("mission.thomas.606.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePerfusion, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission606, 0, false);
		Mission mission607 = new Mission(607, ConfigurationManager.getProperties("mission.thomas.607.nom"), ConfigurationManager.getProperties("mission.thomas.607.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSpiritisme, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission607, itemsDebloquesMission607, 0, false);
		Mission mission608 = new Mission(608, ConfigurationManager.getProperties("mission.thomas.608.nom"), ConfigurationManager.getProperties("mission.thomas.608.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFreres, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission608, 0, false);

		// Sorts YA
		Mission mission700 = new Mission(700, ConfigurationManager.getProperties("mission.yannick.700.nom"), ConfigurationManager.getProperties("mission.yannick.700.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePoker, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission700, itemsDebloquesMission700, 0, false);
		Mission mission701 = new Mission(701, ConfigurationManager.getProperties("mission.yannick.701.nom"), ConfigurationManager.getProperties("mission.yannick.701.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGrotte, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission701, itemsDebloquesMission701, 0, false);
		Mission mission702 = new Mission(702, ConfigurationManager.getProperties("mission.yannick.702.nom"), ConfigurationManager.getProperties("mission.yannick.702.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEau, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission702, itemsDebloquesMission702, 0, false);
		Mission mission703 = new Mission(703, ConfigurationManager.getProperties("mission.yannick.703.nom"), ConfigurationManager.getProperties("mission.yannick.703.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBase, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission703, itemsDebloquesMission703, 0, false);
		Mission mission704 = new Mission(704, ConfigurationManager.getProperties("mission.yannick.704.nom"), ConfigurationManager.getProperties("mission.yannick.704.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBuffy, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMission704, 0, false);
		Mission mission705 = new Mission(705, ConfigurationManager.getProperties("mission.yannick.705.nom"), ConfigurationManager.getProperties("mission.yannick.705.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRomeo, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMission705, 0, false);
		Mission mission706 = new Mission(706, ConfigurationManager.getProperties("mission.yannick.706.nom"), ConfigurationManager.getProperties("mission.yannick.706.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date6eme, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMission706, 0, false);
		Mission mission707 = new Mission(707, ConfigurationManager.getProperties("mission.yannick.707.nom"), ConfigurationManager.getProperties("mission.yannick.707.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBalcon, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission707, itemsDebloquesMission707, 0, false);
		Mission mission708 = new Mission(708, ConfigurationManager.getProperties("mission.yannick.708.nom"), ConfigurationManager.getProperties("mission.yannick.708.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateWorms, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission708, itemsDebloquesMission708, 0, false);
		
		// Sorts PIP
		Mission mission800 = new Mission(800, ConfigurationManager.getProperties("mission.pierre.800.nom"), ConfigurationManager.getProperties("mission.pierre.800.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCa, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission800, 0, false);
		Mission mission801 = new Mission(801, ConfigurationManager.getProperties("mission.pierre.801.nom"), ConfigurationManager.getProperties("mission.pierre.801.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNoel, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission801, 0, false);
		Mission mission802 = new Mission(802, ConfigurationManager.getProperties("mission.pierre.802.nom"), ConfigurationManager.getProperties("mission.pierre.802.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFlaque, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission802, 0, false);
		Mission mission803 = new Mission(803, ConfigurationManager.getProperties("mission.pierre.803.nom"), ConfigurationManager.getProperties("mission.pierre.803.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMole, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission803, 0, false);
		Mission mission804 = new Mission(804, ConfigurationManager.getProperties("mission.pierre.804.nom"), ConfigurationManager.getProperties("mission.pierre.804.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBranlette, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission804, 0, false);
		Mission mission805 = new Mission(805, ConfigurationManager.getProperties("mission.pierre.805.nom"), ConfigurationManager.getProperties("mission.pierre.805.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRacaille, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission805, 0, false);
		Mission mission806 = new Mission(806, ConfigurationManager.getProperties("mission.pierre.806.nom"), ConfigurationManager.getProperties("mission.pierre.806.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date2000, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission806, 0, false);
		Mission mission807 = new Mission(807, ConfigurationManager.getProperties("mission.pierre.807.nom"), ConfigurationManager.getProperties("mission.pierre.807.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBoysBand, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission807, 0, false);
		Mission mission808 = new Mission(808, ConfigurationManager.getProperties("mission.pierre.808.nom"), ConfigurationManager.getProperties("mission.pierre.808.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateOptic2000, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission808, itemsDebloquesMission808, 0, false);

		// Sorts NICO
		Mission mission900 = new Mission(900, ConfigurationManager.getProperties("mission.nicolas.900.nom"), ConfigurationManager.getProperties("mission.nicolas.900.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateStreetFighter, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission900, itemsDebloquesMission900, 0, false);
		// TODO video kaamelott 'fort en pomme'
		Mission mission901 = new Mission(901, ConfigurationManager.getProperties("mission.nicolas.901.nom"), ConfigurationManager.getProperties("mission.nicolas.901.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDBZ, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission901, 0, false);
		Mission mission902 = new Mission(902, ConfigurationManager.getProperties("mission.nicolas.902.nom"), ConfigurationManager.getProperties("mission.nicolas.902.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateStade, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission902, 0, false);
		Mission mission903 = new Mission(903, ConfigurationManager.getProperties("mission.nicolas.903.nom"), ConfigurationManager.getProperties("mission.nicolas.903.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMatrix, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission903, 0, false);
		Mission mission904 = new Mission(904, ConfigurationManager.getProperties("mission.nicolas.904.nom"), ConfigurationManager.getProperties("mission.nicolas.904.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateXMen, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission904, 0, false);
		Mission mission905 = new Mission(905, ConfigurationManager.getProperties("mission.nicolas.905.nom"), ConfigurationManager.getProperties("mission.nicolas.905.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRapTout, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission905, 0, false);
		Mission mission906 = new Mission(906, ConfigurationManager.getProperties("mission.nicolas.906.nom"), ConfigurationManager.getProperties("mission.nicolas.906.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMiranda, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission906, 0, false);
		Mission mission907 = new Mission(907, ConfigurationManager.getProperties("mission.nicolas.907.nom"), ConfigurationManager.getProperties("mission.nicolas.907.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMuscu, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission907, itemsDebloquesMission907, 0, false);
		Mission mission908 = new Mission(908, ConfigurationManager.getProperties("mission.nicolas.908.nom"), ConfigurationManager.getProperties("mission.nicolas.908.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMortalKombat, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission908, 0, false);

		// Sorts Yo
		Mission mission1100 = new Mission(1100, ConfigurationManager.getProperties("mission.johann.1100.nom"), ConfigurationManager.getProperties("mission.johann.1100.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePisse, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission1100, itemsDebloquesMission1100, 0, false);
		Mission mission1101 = new Mission(1101, ConfigurationManager.getProperties("mission.johann.1101.nom"), ConfigurationManager.getProperties("mission.johann.1101.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCarnaval, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1101, 0, false);
		Mission mission1102 = new Mission(1102, ConfigurationManager.getProperties("mission.johann.1102.nom"), ConfigurationManager.getProperties("mission.johann.1102.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBooster, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1102, 0, false);
		Mission mission1103 = new Mission(1103, ConfigurationManager.getProperties("mission.johann.1103.nom"), ConfigurationManager.getProperties("mission.johann.1103.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateWow, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1103, 0, false);
		Mission mission1104 = new Mission(1104, ConfigurationManager.getProperties("mission.johann.1104.nom"), ConfigurationManager.getProperties("mission.johann.1104.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEscalope, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1104, 0, false);
		Mission mission1105 = new Mission(1105, ConfigurationManager.getProperties("mission.johann.1105.nom"), ConfigurationManager.getProperties("mission.johann.1105.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePlantage, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission1105, itemsDebloquesMission1105, 0, false);
		Mission mission1106 = new Mission(1106, ConfigurationManager.getProperties("mission.johann.1106.nom"), ConfigurationManager.getProperties("mission.johann.1106.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDance, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1106, 0, false);
		Mission mission1107 = new Mission(1107, ConfigurationManager.getProperties("mission.johann.1107.nom"), ConfigurationManager.getProperties("mission.johann.1107.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateHalloween, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1107, 0, false);
		Mission mission1108 = new Mission(1108, ConfigurationManager.getProperties("mission.johann.1108.nom"), ConfigurationManager.getProperties("mission.johann.1108.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateChiasse, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission1108, itemsDebloquesMission1108, 0, false);

		
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

		// TODO objets debloqués correspondant a la mission boss
		// TODO relier les missions boss a des pois
		// TODO faire des missions mini BOSS (les profs et persos secondaires)
		
		// 				/  ANIMAL / FILM / SPORT / CHANTEUR / MUSIQUE / GROUPE DE MUSIQUE / JEU VIDEO / PERSONNAGE DE FILM )
		// GUILLAUME	/ Serpent
		// PIERRE		/ Elephant
		// JONATHAN		/ 
		// NICOLAS		/ 
		// THOMAS		/ Tortue
		// ALI			/ 
		// JOHANN		/ Aigle /
		// YANNICK		/ 
		
		///////////////
		// MINI BOSS //
		///////////////

		Mission mission1011 = new Mission(1011, ConfigurationManager.getProperties("mission.miniboss.1011.nom"), ConfigurationManager.getProperties("mission.miniboss.1011.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss11, bonusVide, 1, 1, dateMiniBoss11, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS11, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1011, 0, false);
		Mission mission1012 = new Mission(1012, ConfigurationManager.getProperties("mission.miniboss.1012.nom"), ConfigurationManager.getProperties("mission.miniboss.1012.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss12, bonusVide, 1, 1, dateMiniBoss12, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS12, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1012, 0, false);
		Mission mission1013 = new Mission(1013, ConfigurationManager.getProperties("mission.miniboss.1013.nom"), ConfigurationManager.getProperties("mission.miniboss.1013.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss13, bonusVide, 1, 1, dateMiniBoss13, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS13, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1013, 0, false);
		Mission mission1014 = new Mission(1014, ConfigurationManager.getProperties("mission.miniboss.1014.nom"), ConfigurationManager.getProperties("mission.miniboss.1014.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss14, bonusVide, 1, 1, dateMiniBoss14, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS14, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1014, 0, false);
		Mission mission1015 = new Mission(1015, ConfigurationManager.getProperties("mission.miniboss.1015.nom"), ConfigurationManager.getProperties("mission.miniboss.1015.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss15, bonusVide, 1, 1, dateMiniBoss15, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS15, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1015, 0, false);
		
		/////////////////
		// BOSS FINAUX //
		/////////////////
		
		// MISSIONS BOSS YO (Pere/Zidane/Daft Punk/Nemo/Lady Gaga) (image : olive et tom) (recompense : Le ballon d'or)
		Mission mission1001 = new Mission(1001, ConfigurationManager.getProperties("mission.boss.johann.1001.nom"), ConfigurationManager.getProperties("mission.boss.johann.1001.inf"), imagePaths1001, sonPaths1, videoPaths1, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusBoss1, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, itemsNecessairesMissionBoss1, itemsDebloquesMission1001, 0, false);
		
		// MISSIONS BOSS NICO (Lara Croft) (image : Laure Saintclair) (recompense : Le grappin en or)
		Mission mission1002 = new Mission(1002, ConfigurationManager.getProperties("mission.boss.nicolas.1002.nom"), ConfigurationManager.getProperties("mission.boss.nicolas.1002.inf"), imagePaths1002, sonPaths1, videoPaths1, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusBoss2, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS2, itemsNecessairesMissionBoss2, itemsDebloquesMission1002, 0, false);
		
		// MISSIONS BOSS PIP (DUMBO / DR DRE / EMiNEM / MARAK-Marek) (image : eminem) (recompense : La médaille d'or)
		Mission mission1003 = new Mission(1003, ConfigurationManager.getProperties("mission.boss.pierre.1003.nom"), ConfigurationManager.getProperties("mission.boss.pierre.1003.inf"), imagePaths1003, sonPaths1, videoPaths1, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusBoss3, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS3, itemsNecessairesMissionBoss3, itemsDebloquesMission1003, 0, false);

		// MISSIONS BOSS TOM (Sosie : Ben Stiller / Juninho / Hitler) (image : dieudonne quenelle) (recompense : Le mouchoir d'or)
		Mission mission1004 = new Mission(1004, ConfigurationManager.getProperties("mission.boss.thomas.1004.nom"), ConfigurationManager.getProperties("mission.boss.thomas.1004.inf"), imagePaths1004, sonPaths1, videoPaths1, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusBoss4, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS4, itemsNecessairesMissionBoss4, itemsDebloquesMission1004, 0, false);
  
		// MISSIONS BOSS YA (Anakin Skywalker) (image : lego starwars / worms armaggedon) (recompense : Le sabre d'or)
		Mission mission1005 = new Mission(1005, ConfigurationManager.getProperties("mission.boss.yannick.1005.nom"), ConfigurationManager.getProperties("mission.boss.yannick.1005.inf"), imagePaths1005, sonPaths1, videoPaths1, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusBoss5, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS5, itemsNecessairesMissionBoss5, itemsDebloquesMission1005, 0, false);

		// MISSIONS BOSS ALI (Mickeal Jackson) (image : gants de medecin) (recompense : Le micro d'or)
		Mission mission1006 = new Mission(1006, ConfigurationManager.getProperties("mission.boss.ali.1006.nom"), ConfigurationManager.getProperties("mission.boss.ali.1006.inf"), imagePaths1006, sonPaths1, videoPaths1, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusBoss6, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS6, itemsNecessairesMissionBoss6, itemsDebloquesMission1006, 0, false);

		// MISSIONS BOSS GUY (Solid Snke / Indiana Jones / Robert de Niro / Serpent / Scream) (image : scream) (recompense : La coupe en or)
		Mission mission1007 = new Mission(1007, ConfigurationManager.getProperties("mission.boss.guillaume.1007.nom"), ConfigurationManager.getProperties("mission.boss.guillaume.1007.inf"), imagePaths1007, sonPaths1, videoPaths1, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusBoss7, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS7, itemsNecessairesMissionBoss7, itemsDebloquesMission1007, 0, false);

		// MISSIONS BOSS RUSS (Son double Arnaud de la piscine) (5 mytho par semaine) (image : serge le mytho) (recompense : La palme d'or)
		Mission mission1008 = new Mission(1008, ConfigurationManager.getProperties("mission.boss.jonathan.1008.nom"), ConfigurationManager.getProperties("mission.boss.jonathan.1008.inf"), imagePaths1008, sonPaths1, videoPaths1, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusBoss8, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS8, itemsNecessairesMissionBoss8, itemsDebloquesMission1008, 0, false);

		// MISSION FINALE
		// TODO (TOUS LES BOSS)
		Mission mission1000 = new Mission(1000, ConfigurationManager.getProperties("mission.final.1000.nom"), ConfigurationManager.getProperties("mission.final.1000.inf"), imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionFinale, new ArrayList<Item>(), 0, false);
		
		
		// MISSIONS PERSO

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
		missions.add(mission311);
		
		missions.add(mission400);
		missions.add(mission401);
		missions.add(mission402);
		missions.add(mission403);
		missions.add(mission404);
		missions.add(mission405);
		missions.add(mission406);
		missions.add(mission407);
		missions.add(mission408);
		
		missions.add(mission500);
		missions.add(mission501);
		missions.add(mission502);
		missions.add(mission503);
		missions.add(mission504);
		missions.add(mission505);
		missions.add(mission506);
		missions.add(mission507);
		missions.add(mission508);
		
		missions.add(mission600);
		missions.add(mission601);
		missions.add(mission602);
		missions.add(mission603);
		missions.add(mission604);
		missions.add(mission605);
		missions.add(mission606);
		missions.add(mission607);
		missions.add(mission608);
		
		missions.add(mission700);
		missions.add(mission701);
		missions.add(mission702);
		missions.add(mission703);
		missions.add(mission704);
		missions.add(mission705);
		missions.add(mission706);
		missions.add(mission707);
		missions.add(mission708);
		
		missions.add(mission800);
		missions.add(mission801);
		missions.add(mission802);
		missions.add(mission803);
		missions.add(mission804);
		missions.add(mission805);
		missions.add(mission806);
		missions.add(mission807);
		missions.add(mission808);
		
		missions.add(mission900);
		missions.add(mission901);
		missions.add(mission902);
		missions.add(mission903);
		missions.add(mission904);
		missions.add(mission905);
		missions.add(mission906);
		missions.add(mission907);
		missions.add(mission908);

		missions.add(mission1100);
		missions.add(mission1101);
		missions.add(mission1102);
		missions.add(mission1103);
		missions.add(mission1104);
		missions.add(mission1105);
		missions.add(mission1106);
		missions.add(mission1107);
		missions.add(mission1108);

		// Missions BOSS
		missions.add(mission1000);
		missions.add(mission1001);
		missions.add(mission1002);
		missions.add(mission1003);
		missions.add(mission1004);
		missions.add(mission1005);
		missions.add(mission1006);
		missions.add(mission1007);
		missions.add(mission1008);
		
		missions.add(mission1011);
		missions.add(mission1012);
		missions.add(mission1013);
		missions.add(mission1014);
		missions.add(mission1015);
		

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
			ImageIcon resizeImage = ImageManager.resizeImage(FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0)), Constante.PERSO_IMAGE_DIMENSION_180_180);
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "Mission réussie!", mission.getNom(), 0, resizeImage);
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
						"Félicitations! T'as terminé le jeu en difficulté " + difficultePartie.name() + " !");
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Envoie tes statistiques sur le site pour comparer ton score avec les autres!");
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Envoie moi tes remarques/critiques/souhaits pour une eventuelle future prochaine version possible!");
				// TODO messages en fonction de la difficulte
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"T'as désormais le droit de sucer le frère d'Ali pour une durée indeterminée!");

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
					ImageIcon resizeImage = ImageManager.resizeImage(itemLieu, Constante.PERSO_IMAGE_DIMENSION_180_180);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
							lieuById.getProprietaire() + " a débloqué un nouveau Lieu : " + lieuById.getNom(),
							"Nouveau Lieu disponible !", 0, resizeImage);
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
				PersoPrenom proprietaire = item.getProprietaire();
	
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

					if (item.getType().name().equals(ItemType.PERSONNAGE.name())) {
						Personnage perso = (Personnage)item;
						itemImage = FenetrePrincipal.getImageIcon("image/defaut/defautNouveauPersonnage.png");
						ImageIcon image = ImageManager.resizeImage(itemImage, Constante.PERSO_IMAGE_DIMENSION_180_180);
						JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
								proprietaire + " acceuille un nouveau personnage : " + perso.getPrenom(),
								"Nouvel arrivant", type, image);
					} else {	
						JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
								proprietaire + " a débloqué : " + item.getNom() + " - " + item.getInformations(),
								"Nouveau type d'objet disponible ! (" + itemType + ")", type, resizedImage);
					}
					
					item.setDisponible(true);
				}
				
				// Si c'est un item consommable, on l'ajoute au sac du groupe
				if (item.isConsommable()) {
					Groupe leGroupe = personnageManager.getLeGroupe();
					Map<Item, Integer> sacGroupe = leGroupe.getSac();
					Integer valeur = sacGroupe.get(item);
					// Si le sac ne contient pas encore cet objet
					if (valeur == null) {
						sacGroupe.put(item, 1);
					} else {
						// Sinon on incremente
						sacGroupe.put(item, valeur + 1);
					}
				} else if (proprietaire != PersoPrenom.GROUPE) {
					// Si c'est un objet perso on l'ajoute au sac du proprietaire
					Map<Item, Integer> sacPerso = personnageManager.getPersoByPrenom(proprietaire).getSac();
					sacPerso.put(item, 1);
				}
				
				// Si ce n'est pas l'arrivée d'un personnage, on lance la popup
				if (!item.getType().name().equals(ItemType.PERSONNAGE.name())) {
					
					MusiqueManager.playSonItem("sonParDefaut/09-Zelda-small-item-catch.mp3");
					// TODO meilleur nom que ACTION_COMBAT
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
							"Vous avez gagné : " + item.getNom(), "Nouvel objet ! (" + itemType + ")", type, resizedImage);
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

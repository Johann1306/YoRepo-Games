package core;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import core.configuration.Constante;
import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import modele.bonus.Bonus;
import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.arme.Arme;
import modele.item.lieu.Lieu;
import modele.item.media.audio.Musique;
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
import modele.item.personnage.action.ActionCombat;
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
		
		List<String> sonPathsAnniversaire = new ArrayList<String>();
		String sonPathAnniversaire = "musique/mission/Joyeux anniversaire.mp3";
		sonPathsAnniversaire.add(sonPathAnniversaire);
		
		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "sonParDefaut/inception.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);

		// Videos
//		List<String> videoPaths1 = new ArrayList<String>();
//		String videoPath1 = "video/Trololo.mp4";
//		videoPaths1.add(videoPath1);

		///////////
		// DATES //
		///////////
		
		// TODO bonnes Dates
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 9, 00, 00);
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 17, 00, 00);
		Date date3 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 4, 9, 00, 00);
		Date dateNull = null;
		
		// TODO remettre les bonnes dates
		Date dateCleTerrain = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 1, 9, 00, 00);
		Date dateFootChelles = DateManager.genereUneDate(2002, Calendar.SEPTEMBER, 1, 9, 00, 00);
		Date dateFootNoisy = DateManager.genereUneDate(2005, Calendar.SEPTEMBER, 1, 9, 00, 00);
		// Pour tester les matchs en debut de partie
//		Date dateCleTerrain = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 12, 9, 00, 00);
//		Date dateFootChelles = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 12, 9, 00, 00);
//		Date dateFootNoisy = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 12, 9, 00, 00);
		
		// TODO remettre les bonnes dates
		Date dateMiranda = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 11, 9, 00, 00);
		Date dateTonelle = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 11, 9, 00, 00);
		Date dateDahlias = DateManager.genereUneDate(1998, Calendar.DECEMBER, 31, 20, 00, 00);
		Date dateBosquets = DateManager.genereUneDate(2000, Calendar.SEPTEMBER, 11, 9, 00, 00);
		// Pour tester les boutiques en debut de partie
//		Date dateMiranda = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 11, 9, 00, 00);
//		Date dateTonelle = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 11, 9, 00, 00);
//		Date dateDahlias = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 11, 9, 00, 00);
//		Date dateBosquets = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 11, 9, 00, 00);
	
		Date dateRencontreAli = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 7, 14, 00, 00);
		Date dateRencontreGuy = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 7, 14, 00, 00);
		Date dateRencontreJo = DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 7, 14, 00, 00);
		
		Date dateSortieDuJeu = DateManager.genereUneDate(2020, Calendar.JANUARY, 1, 9, 00, 00);
		
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
		Date dateMirandaMission = DateManager.genereUneDate(1998, Calendar.DECEMBER, 24, 18, 00, 00);		
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
		
		// Date anniv pour mission bonus (Quizz)
		Date dateAnnivNico1990 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1991 = DateManager.genereUneDate(1991, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1992 = DateManager.genereUneDate(1992, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1993 = DateManager.genereUneDate(1993, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1994 = DateManager.genereUneDate(1994, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1995 = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1996 = DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1997 = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1998 = DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico1999 = DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 5, 10, 00, 00);
		Date dateAnnivNico2000 = DateManager.genereUneDate(2000, Calendar.SEPTEMBER, 5, 10, 00, 00);

		Date dateAnnivTom1990 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1991 = DateManager.genereUneDate(1991, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1992 = DateManager.genereUneDate(1992, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1993 = DateManager.genereUneDate(1993, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1994 = DateManager.genereUneDate(1994, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1995 = DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1996 = DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1997 = DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1998 = DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom1999 = DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 7, 10, 00, 00);
		Date dateAnnivTom2000 = DateManager.genereUneDate(2000, Calendar.SEPTEMBER, 7, 10, 00, 00);
		
		Date dateAnnivYa1991 = DateManager.genereUneDate(1991, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1992 = DateManager.genereUneDate(1992, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1993 = DateManager.genereUneDate(1993, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1994 = DateManager.genereUneDate(1994, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1995 = DateManager.genereUneDate(1995, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1996 = DateManager.genereUneDate(1996, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1997 = DateManager.genereUneDate(1997, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1998 = DateManager.genereUneDate(1998, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa1999 = DateManager.genereUneDate(1999, Calendar.APRIL, 14, 10, 00, 00);
		Date dateAnnivYa2000 = DateManager.genereUneDate(2000, Calendar.APRIL, 14, 10, 00, 00);
		
		Date dateAnnivYo1991 = DateManager.genereUneDate(1991, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1992 = DateManager.genereUneDate(1992, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1993 = DateManager.genereUneDate(1993, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1994 = DateManager.genereUneDate(1994, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1995 = DateManager.genereUneDate(1995, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1996 = DateManager.genereUneDate(1996, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1997 = DateManager.genereUneDate(1997, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1998 = DateManager.genereUneDate(1998, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo1999 = DateManager.genereUneDate(1999, Calendar.JUNE, 13, 10, 00, 00);
		Date dateAnnivYo2000 = DateManager.genereUneDate(2000, Calendar.JUNE, 13, 10, 00, 00);
		
		Date dateAnnivPip1991 = DateManager.genereUneDate(1991, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1992 = DateManager.genereUneDate(1992, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1993 = DateManager.genereUneDate(1993, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1994 = DateManager.genereUneDate(1994, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1995 = DateManager.genereUneDate(1995, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1996 = DateManager.genereUneDate(1996, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1997 = DateManager.genereUneDate(1997, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1998 = DateManager.genereUneDate(1998, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip1999 = DateManager.genereUneDate(1999, Calendar.AUGUST, 4, 10, 00, 00);
		Date dateAnnivPip2000 = DateManager.genereUneDate(2000, Calendar.AUGUST, 4, 10, 00, 00);
		
		Date dateAnnivAli1996 = DateManager.genereUneDate(1996, Calendar.JULY, 1, 10, 00, 00);
		Date dateAnnivAli1997 = DateManager.genereUneDate(1997, Calendar.JULY, 1, 10, 00, 00);
		Date dateAnnivAli1998 = DateManager.genereUneDate(1998, Calendar.JULY, 1, 10, 00, 00);
		Date dateAnnivAli1999 = DateManager.genereUneDate(1999, Calendar.JULY, 1, 10, 00, 00);
		Date dateAnnivAli2000 = DateManager.genereUneDate(2000, Calendar.JULY, 1, 10, 00, 00);

		Date dateAnnivGuy1998 = DateManager.genereUneDate(1998, Calendar.JANUARY, 11, 10, 00, 00);
		Date dateAnnivGuy1999 = DateManager.genereUneDate(1999, Calendar.JANUARY, 11, 10, 00, 00);
		Date dateAnnivGuy2000 = DateManager.genereUneDate(2000, Calendar.JANUARY, 11, 10, 00, 00);

		Date dateAnnivRuss2000 = DateManager.genereUneDate(2000, Calendar.MAY, 19, 10, 00, 00);

		Date date21siecle = DateManager.genereUneDate(2001, Calendar.JANUARY, 1, 10, 00, 00);

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

		Item clesMiranda = itemManager.getItemById(403);
		Item clesTonelle = itemManager.getItemById(404);
		Item clesDahlias = itemManager.getItemById(405);
		Item clesBosquets = itemManager.getItemById(406);
		
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
		List<Item> itemsNecessairesMission106 = new ArrayList<>();
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Missions 230 240 250 260 (Lieux Marchands)
		List<Item> itemsNecessairesMission230 = new ArrayList<>();
		itemsNecessairesMission230.add(clesMiranda);
		List<Item> itemsNecessairesMission240 = new ArrayList<>();
		itemsNecessairesMission240.add(clesTonelle);
		List<Item> itemsNecessairesMission250 = new ArrayList<>();
		itemsNecessairesMission250.add(clesDahlias);
		List<Item> itemsNecessairesMission260 = new ArrayList<>();
		itemsNecessairesMission260.add(clesBosquets);
		

		// Mission 300
		List<Item> itemsNecessairesMission300 = new ArrayList<>();
		itemsNecessairesMission300.add(itemManager.getItemById(600));
		itemsNecessairesMission300.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		
		// Mission 306
		List<Item> itemsNecessairesMission306 = new ArrayList<>();
		itemsNecessairesMission306.add(graisseATraire);
		itemsNecessairesMission306.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));

		// Mission 311
		List<Item> itemsNecessairesMission311 = new ArrayList<>();
		itemsNecessairesMission311.add(graisseATraire);
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission311.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));

		// Mission 504
		List<Item> itemsNecessairesMission504 = new ArrayList<>();
		itemsNecessairesMission504.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission504.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
	
		// Mission 506
		List<Item> itemsNecessairesMission506 = new ArrayList<>();
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission506.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 508
		List<Item> itemsNecessairesMission508 = new ArrayList<>();
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission508.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission 603
		List<Item> itemsNecessairesMission603 = new ArrayList<>();
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission603.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 607
		List<Item> itemsNecessairesMission607 = new ArrayList<>();
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission607.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		
		// Mission 700
		List<Item> itemsNecessairesMission700 = new ArrayList<>();
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission700.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 701
		List<Item> itemsNecessairesMission701 = new ArrayList<>();
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission701.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 702
		List<Item> itemsNecessairesMission702 = new ArrayList<>();
		itemsNecessairesMission702.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission702.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		
		// Mission 703
		List<Item> itemsNecessairesMission703 = new ArrayList<>();
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission703.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 707
		List<Item> itemsNecessairesMission707 = new ArrayList<>();
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission707.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission 708
		List<Item> itemsNecessairesMission708 = new ArrayList<>();
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission708.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 808
		List<Item> itemsNecessairesMission808 = new ArrayList<>();
		itemsNecessairesMission808.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission808.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission 900
		List<Item> itemsNecessairesMission900 = new ArrayList<>();
		itemsNecessairesMission900.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission900.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission 907
		List<Item> itemsNecessairesMission907 = new ArrayList<>();
		itemsNecessairesMission907.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission907.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));

		// Mission 1100
		List<Item> itemsNecessairesMission1100 = new ArrayList<>();
		itemsNecessairesMission1100.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission1100.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission 1105
		List<Item> itemsNecessairesMission1105 = new ArrayList<>();
		itemsNecessairesMission1105.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission1105.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission1105.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission 1108
		List<Item> itemsNecessairesMission1108 = new ArrayList<>();
		itemsNecessairesMission1108.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission1108.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission 1000 (Mission Finale)
		List<Item> itemsNecessairesMissionFinale = new ArrayList<>();
		itemsNecessairesMissionFinale.add(ballon_dor);
		itemsNecessairesMissionFinale.add(grappin_dor);
		itemsNecessairesMissionFinale.add(medaille_dor);
		itemsNecessairesMissionFinale.add(mouchoir_dor);
		itemsNecessairesMissionFinale.add(sabre_dor);
		itemsNecessairesMissionFinale.add(micro_dor);
		itemsNecessairesMissionFinale.add(coupe_dor);
		itemsNecessairesMissionFinale.add(palme_dor);
		
		// Mission Foot Ecole
		List<Item> itemsNecessairesMission3001 = new ArrayList<>();
		itemsNecessairesMission3001.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3001.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3001.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3001.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3001.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		List<Item> itemsNecessairesMission3002 = new ArrayList<>();
		itemsNecessairesMission3002.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3002.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3002.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3002.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3002.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3002.add(clesDuTerrain);
		
		List<Item> itemsNecessairesMission3003 = new ArrayList<>();
		itemsNecessairesMission3003.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3003.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3003.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3003.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3003.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3003.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission3003.add(clesDuTerrain);
		
		List<Item> itemsNecessairesMission3004 = new ArrayList<>();
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission3004.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		itemsNecessairesMission3004.add(clesDuTerrain);
		
		List<Item> itemsNecessairesMission3005 = new ArrayList<>();
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		itemsNecessairesMission3005.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		itemsNecessairesMission3005.add(clesDuTerrain);
		
		List<Item> itemsNecessairesMission3006 = new ArrayList<>();
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission3006.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		
		List<Item> itemsNecessairesMission3007 = new ArrayList<>();
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		itemsNecessairesMission3007.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		
		List<Item> itemsNecessairesMission3008 = new ArrayList<>();
		itemsNecessairesMission3008.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3008.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3008.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3008.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3008.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		List<Item> itemsNecessairesMission3009 = new ArrayList<>();
		itemsNecessairesMission3009.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsNecessairesMission3009.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsNecessairesMission3009.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsNecessairesMission3009.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsNecessairesMission3009.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsNecessairesMission3009.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		
		// Mission Terrain
		List<Item> itemsNecessairesMissionTerrain = new ArrayList<>();
		itemsNecessairesMissionTerrain.add(clesDuTerrain);

		// Mission Russ
		List<Item> itemsNecessairesMissionRuss = new ArrayList<>();
		itemsNecessairesMissionRuss.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));

		// Mission Guy
		List<Item> itemsNecessairesMissionGuy = new ArrayList<>();
		itemsNecessairesMissionGuy.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		
		// Mission Ali
		List<Item> itemsNecessairesMissionAli = new ArrayList<>();
		itemsNecessairesMissionAli.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		
		// Mission Tom
		List<Item> itemsNecessairesMissionTom = new ArrayList<>();
		itemsNecessairesMissionTom.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		
		// Mission Ya
		List<Item> itemsNecessairesMissionYa = new ArrayList<>();
		itemsNecessairesMissionYa.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		
		// Mission Pip
		List<Item> itemsNecessairesMissionPip = new ArrayList<>();
		itemsNecessairesMissionPip.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		
		// Mission Nico
		List<Item> itemsNecessairesMissionNico = new ArrayList<>();
		itemsNecessairesMissionNico.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		
		// Mission Yo
		List<Item> itemsNecessairesMissionYo = new ArrayList<>();
		itemsNecessairesMissionYo.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		
		// Missions Boss
		// TODO : verifier que les items debloques correspondent aux SPECIAL
		List<Item> itemsNecessairesMissionBoss1 = new ArrayList<>();
		itemsNecessairesMissionBoss1.add(actionCombatManager.getActionById(181));
		List<Item> itemsNecessairesMissionBoss2 = new ArrayList<>();
		itemsNecessairesMissionBoss2.add(actionCombatManager.getActionById(281));
		List<Item> itemsNecessairesMissionBoss3 = new ArrayList<>();
		itemsNecessairesMissionBoss3.add(actionCombatManager.getActionById(381));
		List<Item> itemsNecessairesMissionBoss4 = new ArrayList<>();
		itemsNecessairesMissionBoss4.add(actionCombatManager.getActionById(581));
		List<Item> itemsNecessairesMissionBoss5 = new ArrayList<>();
		itemsNecessairesMissionBoss5.add(actionCombatManager.getActionById(481));
		List<Item> itemsNecessairesMissionBoss6 = new ArrayList<>();
		itemsNecessairesMissionBoss6.add(actionCombatManager.getActionById(781));
		List<Item> itemsNecessairesMissionBoss7 = new ArrayList<>();
		itemsNecessairesMissionBoss7.add(actionCombatManager.getActionById(681));
		List<Item> itemsNecessairesMissionBoss8 = new ArrayList<>();
		itemsNecessairesMissionBoss8.add(actionCombatManager.getActionById(882));
		
		List<Item> itemsNecessairesMissionMiniBoss = new ArrayList<>();
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
		List<Item> itemsDebloquesMission101 = new ArrayList<>();
		itemsDebloquesMission101.add(personnageManager.getPersoByPrenom(PersoPrenom.Johann));
		itemsDebloquesMission101.add(popoVie25);
		itemsDebloquesMission101.add(popoMana25);
		itemsDebloquesMission101.add(bonusChance5);
		// Mission 102
		List<Item> itemsDebloquesMission102 = new ArrayList<>();
		itemsDebloquesMission102.add(personnageManager.getPersoByPrenom(PersoPrenom.Pierre));
		itemsDebloquesMission102.add(popoVie25);
		itemsDebloquesMission102.add(popoMana25);
		itemsDebloquesMission102.add(bonusRapidite5);
		// Mission 103
		List<Item> itemsDebloquesMission103 = new ArrayList<>();
		itemsDebloquesMission103.add(personnageManager.getPersoByPrenom(PersoPrenom.Nicolas));
		itemsDebloquesMission103.add(popoVie25);
		itemsDebloquesMission103.add(popoMana25);
		itemsDebloquesMission103.add(bonusExploit5);
		// Mission 104
		List<Item> itemsDebloquesMission104 = new ArrayList<>();
		itemsDebloquesMission104.add(personnageManager.getPersoByPrenom(PersoPrenom.Yannick));
		itemsDebloquesMission104.add(popoVie25);
		itemsDebloquesMission104.add(popoMana25);
		itemsDebloquesMission104.add(bonusResistance5);
		// Mission 105
		List<Item> itemsDebloquesMission105 = new ArrayList<>();
		itemsDebloquesMission105.add(personnageManager.getPersoByPrenom(PersoPrenom.Thomas));
		itemsDebloquesMission105.add(popoVie25);
		itemsDebloquesMission105.add(popoMana25);
		itemsDebloquesMission105.add(bonusIntelligence5);
		// Mission 106
		List<Item> itemsDebloquesMission106 = new ArrayList<>();
		itemsDebloquesMission106.add(personnageManager.getPersoByPrenom(PersoPrenom.Ali));
		itemsDebloquesMission106.add(popoVie50);
		itemsDebloquesMission106.add(popoMana50);
		itemsDebloquesMission106.add(bonusAgilite10);
		// Mission 107
		List<Item> itemsDebloquesMission107 = new ArrayList<>();
		itemsDebloquesMission107.add(personnageManager.getPersoByPrenom(PersoPrenom.Guillaume));
		itemsDebloquesMission107.add(popoVie75);
		itemsDebloquesMission107.add(popoMana75);
		itemsDebloquesMission107.add(bonusTechnique10);
		// Mission 108
		List<Item> itemsDebloquesMission108 = new ArrayList<>();
		itemsDebloquesMission108.add(personnageManager.getPersoByPrenom(PersoPrenom.Jonathan));
		itemsDebloquesMission108.add(popoVie100);
		itemsDebloquesMission108.add(popoMana100);
		itemsDebloquesMission108.add(bonusEndurance10);
		itemsDebloquesMission108.add(bonusNervosite10);
		
		// Mission 200
		List<Item> itemsDebloquesMission200 = new ArrayList<>();
		itemsDebloquesMission200.add(clesDuTerrain);
		
		// Mission 203
		List<Item> itemsDebloquesMission203 = new ArrayList<>();
		itemsDebloquesMission203.add(clesMiranda);
		
		// Mission 204
		List<Item> itemsDebloquesMission204 = new ArrayList<>();
		itemsDebloquesMission204.add(clesTonelle);

		// Mission 205
		List<Item> itemsDebloquesMission205 = new ArrayList<>();
		itemsDebloquesMission205.add(clesDahlias);
		// Canabis
		itemsDebloquesMission205.add(itemManager.getItemById(800));
		// Herbe
		itemsDebloquesMission205.add(itemManager.getItemById(801));
		

		// Mission 206
		List<Item> itemsDebloquesMission206 = new ArrayList<>();
		itemsDebloquesMission206.add(clesBosquets);

		//////////////////////////
		// POUVOIRS A DEBLOQUER //
		//////////////////////////

		// Mission 300
		List<Item> itemsDebloquesMission300 = new ArrayList<>();
		itemsDebloquesMission300.add(actionCombatManager.getActionById(846));
		itemsDebloquesMission300.add(itemManager.getArmeById(571));

		// Mission 301
		List<Item> itemsDebloquesMission301 = new ArrayList<>();
		itemsDebloquesMission301.add(actionCombatManager.getActionById(848));
		itemsDebloquesMission301.add(itemManager.getArmeById(569));
	
		// Mission 302
		List<Item> itemsDebloquesMission302 = new ArrayList<>();
		itemsDebloquesMission302.add(actionCombatManager.getActionById(847));
			
		// Mission 305
		List<Item> itemsDebloquesMission305 = new ArrayList<>();
		itemsDebloquesMission305.add(graisseATraire);
		itemsDebloquesMission305.add(itemManager.getArmeById(518));
		
		// Mission 306
		List<Item> itemsDebloquesMission306 = new ArrayList<>();
		itemsDebloquesMission306.add(actionCombatManager.getActionById(842));
		itemsDebloquesMission306.add(itemManager.getArmeById(521));
		itemsDebloquesMission306.add(itemManager.getItemById(918));
			
		// Mission 307
		List<Item> itemsDebloquesMission307 = new ArrayList<>();
		itemsDebloquesMission307.add(actionCombatManager.getActionById(836));
		itemsDebloquesMission307.add(itemManager.getArmeById(518));
		// Champignon
		itemsDebloquesMission307.add(itemManager.getItemById(810));
		
		// Mission 308
		List<Item> itemsDebloquesMission308 = new ArrayList<>();
		itemsDebloquesMission308.add(actionCombatManager.getActionById(818));
		itemsDebloquesMission308.add(itemManager.getArmeById(551));
		itemsDebloquesMission308.add(itemManager.getItemById(908));
			
		// Mission 309
		List<Item> itemsDebloquesMission309 = new ArrayList<>();
		itemsDebloquesMission309.add(actionCombatManager.getActionById(817));
		
		// Mission 310
		List<Item> itemsDebloquesMission310 = new ArrayList<>();
		itemsDebloquesMission310.add(actionCombatManager.getActionById(812));
		itemsDebloquesMission310.add(itemManager.getArmeById(521));
		itemsDebloquesMission310.add(itemManager.getItemById(928));

			
		// Mission 311
		List<Item> itemsDebloquesMission311 = new ArrayList<>();
		itemsDebloquesMission311.add(actionCombatManager.getActionById(882));
		itemsDebloquesMission311.add(itemManager.getArmeById(519));
		itemsDebloquesMission311.add(itemManager.getArmeById(583));
		itemsDebloquesMission311.add(bonusNervosite10);
		itemsDebloquesMission311.add(bonusEndurance10);
		
				
		// Mission 400
		List<Item> itemsDebloquesMission400 = new ArrayList<>();
		itemsDebloquesMission400.add(actionCombatManager.getActionById(612));
		itemsDebloquesMission400.add(itemManager.getArmeById(516));
		itemsDebloquesMission400.add(itemManager.getArmeById(566));
		
		// Mission 401
		List<Item> itemsDebloquesMission401 = new ArrayList<>();
		itemsDebloquesMission401.add(actionCombatManager.getActionById(613));
		
		// Mission 402
		List<Item> itemsDebloquesMission402 = new ArrayList<>();
		itemsDebloquesMission402.add(actionCombatManager.getActionById(617));

		// Mission 403
		List<Item> itemsDebloquesMission403 = new ArrayList<>();
		itemsDebloquesMission403.add(actionCombatManager.getActionById(631));
		itemsDebloquesMission403.add(itemManager.getItemById(927));
		
		// Mission 404
		List<Item> itemsDebloquesMission404 = new ArrayList<>();
		itemsDebloquesMission404.add(actionCombatManager.getActionById(634));
		itemsDebloquesMission404.add(itemManager.getArmeById(575));

		// Mission 405
		List<Item> itemsDebloquesMission405 = new ArrayList<>();
		itemsDebloquesMission405.add(actionCombatManager.getActionById(636));
		itemsDebloquesMission405.add(itemManager.getArmeById(516));
		// LSD
		itemsDebloquesMission405.add(itemManager.getItemById(807));
		
		// Mission 406
		List<Item> itemsDebloquesMission406 = new ArrayList<>();
		itemsDebloquesMission406.add(actionCombatManager.getActionById(640));
		itemsDebloquesMission406.add(itemManager.getArmeById(516));
		itemsDebloquesMission406.add(itemManager.getArmeById(517));
		itemsDebloquesMission406.add(itemManager.getItemById(917));

		// Mission 407
		List<Item> itemsDebloquesMission407 = new ArrayList<>();
		itemsDebloquesMission407.add(actionCombatManager.getActionById(648));
		itemsDebloquesMission407.add(itemManager.getItemById(901));

		// Mission 408
		List<Item> itemsDebloquesMission408 = new ArrayList<>();
		itemsDebloquesMission408.add(actionCombatManager.getActionById(681));
		itemsDebloquesMission408.add(itemManager.getArmeById(515));
		itemsDebloquesMission408.add(itemManager.getArmeById(584));
		itemsDebloquesMission408.add(bonusTechnique10);

		
		// Mission 500
		List<Item> itemsDebloquesMission500 = new ArrayList<>();
		itemsDebloquesMission500.add(actionCombatManager.getActionById(712));
		itemsDebloquesMission500.add(itemManager.getArmeById(585));
		itemsDebloquesMission500.add(itemManager.getArmeById(581));
		// Speed
		itemsDebloquesMission500.add(itemManager.getItemById(805));

		// Mission 501
		List<Item> itemsDebloquesMission501 = new ArrayList<>();
		itemsDebloquesMission501.add(actionCombatManager.getActionById(717));
		itemsDebloquesMission501.add(itemManager.getArmeById(512));
		
		// Mission 502
		List<Item> itemsDebloquesMission502 = new ArrayList<>();
		itemsDebloquesMission502.add(actionCombatManager.getActionById(718));
		itemsDebloquesMission502.add(itemManager.getArmeById(522));
		itemsDebloquesMission502.add(itemManager.getItemById(916));

		// Mission 503
		List<Item> itemsDebloquesMission503 = new ArrayList<>();
		itemsDebloquesMission503.add(actionCombatManager.getActionById(731));
		itemsDebloquesMission503.add(itemManager.getArmeById(523));
		
		// Mission 504
		List<Item> itemsDebloquesMission504 = new ArrayList<>();
		itemsDebloquesMission504.add(actionCombatManager.getActionById(742));
		itemsDebloquesMission504.add(itemManager.getArmeById(572));
		
		// Mission 505
		List<Item> itemsDebloquesMission505 = new ArrayList<>();
		itemsDebloquesMission505.add(actionCombatManager.getActionById(743));
		itemsDebloquesMission505.add(itemManager.getArmeById(513));
		itemsDebloquesMission505.add(itemManager.getItemById(903));
		
		// Mission 506
		List<Item> itemsDebloquesMission506 = new ArrayList<>();
		itemsDebloquesMission506.add(actionCombatManager.getActionById(746));
		itemsDebloquesMission506.add(itemManager.getArmeById(560));
		itemsDebloquesMission506.add(itemManager.getItemById(926));
		// Poppers
		itemsDebloquesMission506.add(itemManager.getItemById(809));
		
		// Mission 507
		List<Item> itemsDebloquesMission507 = new ArrayList<>();
		itemsDebloquesMission507.add(actionCombatManager.getActionById(747));
		itemsDebloquesMission507.add(itemManager.getArmeById(555));
		
		// Mission 508
		List<Item> itemsDebloquesMission508 = new ArrayList<>();
		itemsDebloquesMission508.add(actionCombatManager.getActionById(781));
		itemsDebloquesMission508.add(itemManager.getArmeById(514));
		itemsDebloquesMission508.add(bonusRapidite10);
		
		
		// Mission 600
		List<Item> itemsDebloquesMission600 = new ArrayList<>();
		itemsDebloquesMission600.add(actionCombatManager.getActionById(512));
		itemsDebloquesMission600.add(itemManager.getArmeById(568));
		
		// Mission 601
		List<Item> itemsDebloquesMission601 = new ArrayList<>();
		itemsDebloquesMission601.add(actionCombatManager.getActionById(517));
		itemsDebloquesMission601.add(itemManager.getArmeById(539));
		
		// Mission 602
		List<Item> itemsDebloquesMission602 = new ArrayList<>();
		itemsDebloquesMission602.add(actionCombatManager.getActionById(531));
		itemsDebloquesMission602.add(itemManager.getArmeById(538));
		
		// Mission 603
		List<Item> itemsDebloquesMission603 = new ArrayList<>();
		itemsDebloquesMission603.add(actionCombatManager.getActionById(533));
		itemsDebloquesMission603.add(itemManager.getArmeById(539));
		itemsDebloquesMission603.add(itemManager.getArmeById(576));
		itemsDebloquesMission603.add(itemManager.getItemById(924));
		
		// Mission 604
		List<Item> itemsDebloquesMission604 = new ArrayList<>();
		itemsDebloquesMission604.add(actionCombatManager.getActionById(535));
		itemsDebloquesMission604.add(itemManager.getArmeById(500));
		
		// Mission 605
		List<Item> itemsDebloquesMission605 = new ArrayList<>();
		itemsDebloquesMission605.add(actionCombatManager.getActionById(541));
		itemsDebloquesMission605.add(itemManager.getArmeById(500));
		itemsDebloquesMission605.add(itemManager.getItemById(915));

		
		// Mission 606
		List<Item> itemsDebloquesMission606 = new ArrayList<>();
		itemsDebloquesMission606.add(actionCombatManager.getActionById(543));
		itemsDebloquesMission606.add(itemManager.getArmeById(520));
		itemsDebloquesMission606.add(itemManager.getItemById(906));
		
		// Mission 607
		List<Item> itemsDebloquesMission607 = new ArrayList<>();
		itemsDebloquesMission607.add(actionCombatManager.getActionById(544));
		itemsDebloquesMission607.add(itemManager.getArmeById(540));
		itemsDebloquesMission607.add(itemManager.getArmeById(552));
		
		// Mission 608
		List<Item> itemsDebloquesMission608 = new ArrayList<>();
		itemsDebloquesMission608.add(actionCombatManager.getActionById(581));
		itemsDebloquesMission608.add(itemManager.getArmeById(501));
		itemsDebloquesMission608.add(bonusIntelligence10);
		// GHB
		itemsDebloquesMission608.add(itemManager.getItemById(808));
		
		
		// Mission 700
		List<Item> itemsDebloquesMission700 = new ArrayList<>();
		itemsDebloquesMission700.add(actionCombatManager.getActionById(412));
		itemsDebloquesMission700.add(itemManager.getArmeById(502));
		
		// Mission 701
		List<Item> itemsDebloquesMission701 = new ArrayList<>();
		itemsDebloquesMission701.add(actionCombatManager.getActionById(414));
		itemsDebloquesMission701.add(itemManager.getArmeById(505));
		itemsDebloquesMission701.add(itemManager.getItemById(921));

		// Mission 702
		List<Item> itemsDebloquesMission702 = new ArrayList<>();
		itemsDebloquesMission702.add(actionCombatManager.getActionById(416));
		itemsDebloquesMission702.add(itemManager.getArmeById(503));
		itemsDebloquesMission702.add(itemManager.getArmeById(574));
		// Pavot
		itemsDebloquesMission702.add(itemManager.getItemById(813));
		itemsDebloquesMission702.add(itemManager.getItemById(914));
		
		// Mission 703
		List<Item> itemsDebloquesMission703 = new ArrayList<>();
		itemsDebloquesMission703.add(actionCombatManager.getActionById(417));
		itemsDebloquesMission703.add(itemManager.getArmeById(509));
		itemsDebloquesMission703.add(itemManager.getItemById(904));
		
		// Mission 704
		List<Item> itemsDebloquesMission704 = new ArrayList<>();
		itemsDebloquesMission704.add(actionCombatManager.getActionById(439));
		itemsDebloquesMission704.add(itemManager.getArmeById(504));
		itemsDebloquesMission704.add(itemManager.getArmeById(562));
		// Heroine
		itemsDebloquesMission704.add(itemManager.getItemById(806));

		// Mission 705
		List<Item> itemsDebloquesMission705 = new ArrayList<>();
		itemsDebloquesMission705.add(actionCombatManager.getActionById(442));
		itemsDebloquesMission705.add(itemManager.getArmeById(565));
		
		// Mission 706
		List<Item> itemsDebloquesMission706 = new ArrayList<>();
		itemsDebloquesMission706.add(actionCombatManager.getActionById(446));
		itemsDebloquesMission706.add(itemManager.getArmeById(525));
		
		// Mission 707
		List<Item> itemsDebloquesMission707 = new ArrayList<>();
		itemsDebloquesMission707.add(actionCombatManager.getActionById(448));
		itemsDebloquesMission707.add(itemManager.getArmeById(573));
		
		// Mission 708
		List<Item> itemsDebloquesMission708 = new ArrayList<>();
		itemsDebloquesMission708.add(actionCombatManager.getActionById(481));
		itemsDebloquesMission708.add(itemManager.getArmeById(524));
		itemsDebloquesMission708.add(itemManager.getArmeById(578));
		itemsDebloquesMission708.add(bonusResistance10);
		
		// Mission 800
		List<Item> itemsDebloquesMission800 = new ArrayList<>();
		itemsDebloquesMission800.add(actionCombatManager.getActionById(302));
		itemsDebloquesMission800.add(itemManager.getArmeById(508));
		
		// Mission 801
		List<Item> itemsDebloquesMission801 = new ArrayList<>();
		itemsDebloquesMission801.add(actionCombatManager.getActionById(313));
		
		// Mission 802
		List<Item> itemsDebloquesMission802 = new ArrayList<>();
		itemsDebloquesMission802.add(actionCombatManager.getActionById(314));
		itemsDebloquesMission802.add(itemManager.getArmeById(530));
		itemsDebloquesMission802.add(itemManager.getArmeById(554));
		itemsDebloquesMission802.add(itemManager.getItemById(923));
		
		// Mission 803
		List<Item> itemsDebloquesMission803 = new ArrayList<>();
		itemsDebloquesMission803.add(actionCombatManager.getActionById(317));
		itemsDebloquesMission803.add(itemManager.getArmeById(585));
		// Ecstasy
		itemsDebloquesMission803.add(itemManager.getItemById(803));
		itemsDebloquesMission803.add(itemManager.getItemById(913));
		
	
		// Mission 804
		List<Item> itemsDebloquesMission804 = new ArrayList<>();
		itemsDebloquesMission804.add(actionCombatManager.getActionById(334));
		itemsDebloquesMission804.add(itemManager.getArmeById(529));
		itemsDebloquesMission804.add(itemManager.getItemById(907));

		// Mission 805
		List<Item> itemsDebloquesMission805 = new ArrayList<>();
		itemsDebloquesMission805.add(actionCombatManager.getActionById(338));
		itemsDebloquesMission805.add(itemManager.getArmeById(529));
		itemsDebloquesMission805.add(itemManager.getArmeById(570));

		// Mission 806
		List<Item> itemsDebloquesMission806 = new ArrayList<>();
		itemsDebloquesMission806.add(actionCombatManager.getActionById(343));
		itemsDebloquesMission806.add(itemManager.getArmeById(527));

		// Mission 807
		List<Item> itemsDebloquesMission807 = new ArrayList<>();
		itemsDebloquesMission807.add(actionCombatManager.getActionById(346));
		itemsDebloquesMission807.add(itemManager.getArmeById(528));

		// Mission 808
		List<Item> itemsDebloquesMission808 = new ArrayList<>();
		itemsDebloquesMission808.add(actionCombatManager.getActionById(381));
		itemsDebloquesMission808.add(itemManager.getArmeById(526));
		itemsDebloquesMission808.add(itemManager.getArmeById(579));
		itemsDebloquesMission808.add(bonusAgilite10);
		// Cristal
		itemsDebloquesMission808.add(itemManager.getItemById(812));
		

		
		// Mission 900
		List<Item> itemsDebloquesMission900 = new ArrayList<>();
		itemsDebloquesMission900.add(actionCombatManager.getActionById(202));
		
		// Mission 901
		List<Item> itemsDebloquesMission901 = new ArrayList<>();
		itemsDebloquesMission901.add(actionCombatManager.getActionById(212));
		itemsDebloquesMission901.add(itemManager.getItemById(905));
		
		// Mission 902
		List<Item> itemsDebloquesMission902 = new ArrayList<>();
		itemsDebloquesMission902.add(actionCombatManager.getActionById(217));
		itemsDebloquesMission902.add(itemManager.getArmeById(531));	
		itemsDebloquesMission902.add(itemManager.getArmeById(558));	
		
		// Mission 903
		List<Item> itemsDebloquesMission903 = new ArrayList<>();
		itemsDebloquesMission903.add(actionCombatManager.getActionById(218));
		itemsDebloquesMission903.add(itemManager.getArmeById(533));	

		// Mission 904
		List<Item> itemsDebloquesMission904 = new ArrayList<>();
		itemsDebloquesMission904.add(actionCombatManager.getActionById(231));
		itemsDebloquesMission904.add(itemManager.getArmeById(550));	
		// Cocaine
		itemsDebloquesMission904.add(itemManager.getItemById(802));	
		

		// Mission 905
		List<Item> itemsDebloquesMission905 = new ArrayList<>();
		itemsDebloquesMission905.add(actionCombatManager.getActionById(234));
		itemsDebloquesMission905.add(itemManager.getArmeById(531));
		itemsDebloquesMission905.add(itemManager.getArmeById(567));

		// Mission 906
		List<Item> itemsDebloquesMission906 = new ArrayList<>();
		itemsDebloquesMission906.add(actionCombatManager.getActionById(241));
		itemsDebloquesMission906.add(itemManager.getArmeById(511));	
		itemsDebloquesMission906.add(itemManager.getItemById(925));	

		// Mission 907
		List<Item> itemsDebloquesMission907 = new ArrayList<>();
		itemsDebloquesMission907.add(actionCombatManager.getActionById(248));
		itemsDebloquesMission907.add(itemManager.getArmeById(532));	
		itemsDebloquesMission907.add(itemManager.getArmeById(582));	
		itemsDebloquesMission907.add(itemManager.getItemById(912));

		// Amphetamine
		itemsDebloquesMission907.add(itemManager.getItemById(811));	

		// Mission 908
		List<Item> itemsDebloquesMission908 = new ArrayList<>();
		itemsDebloquesMission908.add(actionCombatManager.getActionById(281));
		itemsDebloquesMission908.add(itemManager.getArmeById(510));	
		itemsDebloquesMission908.add(bonusExploit10);
		
		// Mission 1100
		List<Item> itemsDebloquesMission1100 = new ArrayList<>();
		itemsDebloquesMission1100.add(actionCombatManager.getActionById(112));
		itemsDebloquesMission1100.add(itemManager.getArmeById(534));	
		itemsDebloquesMission1100.add(itemManager.getItemById(911));
		
		// Mission 1101
		List<Item> itemsDebloquesMission1101 = new ArrayList<>();
		itemsDebloquesMission1101.add(actionCombatManager.getActionById(113));
		itemsDebloquesMission1101.add(itemManager.getArmeById(535));	
		
		// Mission 1102
		List<Item> itemsDebloquesMission1102 = new ArrayList<>();
		itemsDebloquesMission1102.add(actionCombatManager.getActionById(117));
		itemsDebloquesMission1102.add(itemManager.getArmeById(536));	
		itemsDebloquesMission1102.add(itemManager.getItemById(922));	

		// Mission 1103
		List<Item> itemsDebloquesMission1103 = new ArrayList<>();
		itemsDebloquesMission1103.add(actionCombatManager.getActionById(118));
		itemsDebloquesMission1103.add(itemManager.getArmeById(537));
		itemsDebloquesMission1103.add(itemManager.getArmeById(577));
		itemsDebloquesMission1103.add(itemManager.getItemById(902));
		// MDMA
		itemsDebloquesMission1103.add(itemManager.getItemById(804));

		// Mission 1104
		List<Item> itemsDebloquesMission1104 = new ArrayList<>();
		itemsDebloquesMission1104.add(actionCombatManager.getActionById(131));
		itemsDebloquesMission1104.add(itemManager.getArmeById(506));	

		// Mission 1105
		List<Item> itemsDebloquesMission1105 = new ArrayList<>();
		itemsDebloquesMission1105.add(actionCombatManager.getActionById(139));
		itemsDebloquesMission1105.add(itemManager.getArmeById(564));	

		// Mission 1106
		List<Item> itemsDebloquesMission1106 = new ArrayList<>();
		itemsDebloquesMission1106.add(actionCombatManager.getActionById(145));

		// Mission 1107
		List<Item> itemsDebloquesMission1107 = new ArrayList<>();
		itemsDebloquesMission1107.add(actionCombatManager.getActionById(147));
		itemsDebloquesMission1107.add(itemManager.getArmeById(507));	

		// Mission 1108
		List<Item> itemsDebloquesMission1108 = new ArrayList<>();
		itemsDebloquesMission1108.add(actionCombatManager.getActionById(181));
		itemsDebloquesMission1108.add(itemManager.getArmeById(531));
		itemsDebloquesMission1108.add(itemManager.getArmeById(580));
		itemsDebloquesMission1108.add(bonusChance10);
		
		// Mission Foot Ecole
		List<Item> itemsDebloquesMission3001 = new ArrayList<>();
		itemsDebloquesMission3001.add(bonusEndurance5);
		itemsDebloquesMission3001.add(bonusAgilite5);
		itemsDebloquesMission3001.add(bonusRapidite5);
		itemsDebloquesMission3001.add(bonusTechnique5);
		
		// Missions Quizz anniversaire
		List<Item> itemsDebloquesMissionAnniversaireINT5 = new ArrayList<>();
		itemsDebloquesMissionAnniversaireINT5.add(itemManager.getItemById(321));

		List<Item> itemsDebloquesMissionAnniversaireINT10 = new ArrayList<>();
		itemsDebloquesMissionAnniversaireINT10.add(itemManager.getItemById(322));
		
		List<Item> itemsDebloquesMissionAnniversaireINT20 = new ArrayList<>();
		itemsDebloquesMissionAnniversaireINT20.add(itemManager.getItemById(323));
		
		/////////////////////////
		// ITEMS MISSIONS BOSS //
		/////////////////////////
		
		// TODO items debloqués apres missions boss
		
		// BOSS FINAUX
		
		// Mission 1001
		List<Item> itemsDebloquesMission1001 = new ArrayList<>();
		itemsDebloquesMission1001.add(ballon_dor);
		itemsDebloquesMission1001.add(bonusChance20);
		itemsDebloquesMission1001.add(popoVie100);
		itemsDebloquesMission1001.add(popoMana100);
		
		// Mission 1002
		List<Item> itemsDebloquesMission1002 = new ArrayList<>();
		itemsDebloquesMission1002.add(grappin_dor);
		itemsDebloquesMission1002.add(bonusExploit20);
		itemsDebloquesMission1002.add(popoVie100);
		itemsDebloquesMission1002.add(popoMana100);
		
		// Mission 1003
		List<Item> itemsDebloquesMission1003 = new ArrayList<>();
		itemsDebloquesMission1003.add(medaille_dor);
		itemsDebloquesMission1003.add(bonusAgilite20);
		itemsDebloquesMission1003.add(popoVie100);
		itemsDebloquesMission1003.add(popoMana100);
		
		// Mission 1004
		List<Item> itemsDebloquesMission1004 = new ArrayList<>();
		itemsDebloquesMission1004.add(mouchoir_dor);
		itemsDebloquesMission1004.add(bonusIntelligence20);
		itemsDebloquesMission1004.add(popoVie100);
		itemsDebloquesMission1004.add(popoMana100);
		
		// Mission 1005
		List<Item> itemsDebloquesMission1005 = new ArrayList<>();
		itemsDebloquesMission1005.add(sabre_dor);
		itemsDebloquesMission1005.add(bonusResistance20);
		itemsDebloquesMission1005.add(popoVie100);
		itemsDebloquesMission1005.add(popoMana100);
		
		// Mission 1006
		List<Item> itemsDebloquesMission1006 = new ArrayList<>();
		itemsDebloquesMission1006.add(micro_dor);
		itemsDebloquesMission1006.add(bonusRapidite20);
		itemsDebloquesMission1006.add(popoVie100);
		itemsDebloquesMission1006.add(popoMana100);
		
		// Mission 1007
		List<Item> itemsDebloquesMission1007 = new ArrayList<>();
		itemsDebloquesMission1007.add(coupe_dor);
		itemsDebloquesMission1007.add(bonusTechnique20);
		itemsDebloquesMission1007.add(popoVie100);
		itemsDebloquesMission1007.add(popoMana100);
		
		// Mission 1008
		List<Item> itemsDebloquesMission1008 = new ArrayList<>();
		itemsDebloquesMission1008.add(palme_dor);
		itemsDebloquesMission1008.add(bonusEndurance20);
		itemsDebloquesMission1008.add(bonusNervosite20);
		itemsDebloquesMission1008.add(popoVie100);
		itemsDebloquesMission1008.add(popoMana100);
		
		// MINI BOSS ECOLE
		
		// Mission 1011
		List<Item> itemsDebloquesMission1011 = new ArrayList<>();
		itemsDebloquesMission1011.add(popoVie50);
		itemsDebloquesMission1011.add(popoMana50);
		itemsDebloquesMission1011.add(bonusTechnique5);		
		
		// Mission 1012
		List<Item> itemsDebloquesMission1012 = new ArrayList<>();
		itemsDebloquesMission1012.add(popoVie50);
		itemsDebloquesMission1012.add(popoMana50);
		itemsDebloquesMission1011.add(bonusEndurance5);	
		
		// Mission 1013
		List<Item> itemsDebloquesMission1013 = new ArrayList<>();
		itemsDebloquesMission1013.add(popoVie50);
		itemsDebloquesMission1013.add(popoMana50);
		itemsDebloquesMission1011.add(bonusAgilite5);	
		
		// Mission 1014
		List<Item> itemsDebloquesMission1014 = new ArrayList<>();
		itemsDebloquesMission1014.add(popoVie50);
		itemsDebloquesMission1014.add(popoMana50);
		itemsDebloquesMission1011.add(bonusNervosite5);	
		
		// Mission 1015
		List<Item> itemsDebloquesMission1015 = new ArrayList<>();
		itemsDebloquesMission1015.add(popoVie50);
		itemsDebloquesMission1015.add(popoMana50);
		itemsDebloquesMission1011.add(bonusTechnique5);	
		
		// Personnages secondaires Boutique
		PersonnageSecondaire perso230 = personnageManager.getPersonnageSecondaireByNomDeFamille("Chefre");
		List<PersonnageSecondaire> persosSecondairesMission230 = new ArrayList<>();
		persosSecondairesMission230.add(perso230);

		PersonnageSecondaire perso240 = personnageManager.getPersonnageSecondaireByNomDeFamille("Cehef");
		List<PersonnageSecondaire> persosSecondairesMission240 = new ArrayList<>();
		persosSecondairesMission240.add(perso240);
		
		PersonnageSecondaire perso250 = personnageManager.getPersonnageSecondaireByNomDeFamille("Ijuana");
		List<PersonnageSecondaire> persosSecondairesMission250 = new ArrayList<>();
		persosSecondairesMission250.add(perso250);

		PersonnageSecondaire perso260 = personnageManager.getPersonnageSecondaireByNomDeFamille("Banania");
		List<PersonnageSecondaire> persosSecondairesMission260 = new ArrayList<>();
		persosSecondairesMission260.add(perso260);

		// MISSIONS PRINCIPAL
		// Deblocages des persos et domiciles
		Mission mission101 = new Mission(101, "Rencontrer Johann", 		"Rassembler le groupe", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission101, 1, false);
		Mission mission102 = new Mission(102, "Rencontrer Pierre", 		"Rassembler le groupe", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission102, 2, false);
		Mission mission103 = new Mission(103, "Rencontrer Nicolas", 	"Rassembler le groupe", imagePaths1, sonPaths1,	null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,	MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null,	new ArrayList<>(), itemsDebloquesMission103, 3, false);
		Mission mission104 = new Mission(104, "Rencontrer Yannick", 	"Rassembler le groupe", imagePaths1, sonPaths1,	null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1,	MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null,	new ArrayList<>(), itemsDebloquesMission104, 4, false);
		Mission mission105 = new Mission(105, "Rencontrer Thomas", 		"Rassembler le groupe", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission105, 5, false);
		Mission mission106 = new Mission(106, "Rencontrer Ali", 		"Rassembler le groupe", imagePaths1, sonPaths1,	null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreAli, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission106, 6, false);
		Mission mission107 = new Mission(107, "Rencontrer Guillaume", 	"Rassembler le groupe", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreGuy, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM,	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission107, 7, false);
		Mission mission108 = new Mission(108, "Rencontrer Jonathan", 	"Rassembler le groupe", imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRencontreJo, MissionType.PRINCIPAL, Difficulte.FACILE, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission108, 8, false);

		// MISSIONS ECOLE

		// MISSIONS TERRAIN
		// Deblocage du lieu : Terrain
		Mission mission200 = new Mission(200, "Le terrain, gratuit et illimite", "Avoir les cles du terrain", imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCleTerrain, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM,	new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(),	new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission200, 10, false);

		// MISSIONS MARCHAND
		// TODO Deblocage du lieu : La Miranda
		Mission mission203 = new Mission(203, "Place des Fetes", "Nettoyez la place des gens du voyage pour acceder a la boutique", imagePaths1, sonPaths1,	null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMiranda, MissionType.PRINCIPAL, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission203, 11, false);

		// TODO Deblocage du lieu : La Tonelle
		Mission mission204 = new Mission(204, "Carrefour Dangereux", "Deratisez la rue pour acceder au magasin", imagePaths1, sonPaths1,	null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTonelle, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission204, 12, false);

		// TODO Deblocage du lieu : Les Dahlias
		Mission mission205 = new Mission(205, "Herbe Fraiche", "Arrachez les mauvaises herbes pour acceder a la cite", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDahlias, MissionType.PRINCIPAL, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission205, 13, false);

		// TODO Deblocage du lieu : Les Bosquets
		Mission mission206 = new Mission(206, "Compteur Electrique", "Karcherisez la Racaille pour acceder a la cite", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBosquets, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), itemsDebloquesMission206, 14, false);
		
		Mission mission230 = new Mission(230, "La Miranda", "Tous les bonbons a 5 centimes de Franc", imagePaths1, sonPaths1,	null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOUTIQUE, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_SHOP_ENFANT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), persosSecondairesMission230, null, itemsNecessairesMission230, new ArrayList<>(), 0, true);
		Mission mission240 = new Mission(240, "La Tonnelle", "ATTENTION : Camera anti-vol integree dans Jafar", imagePaths1, sonPaths1,	null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOUTIQUE, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_SHOP_ENFANT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), persosSecondairesMission240, null, itemsNecessairesMission240, new ArrayList<>(), 0, true);
		Mission mission250 = new Mission(250, "Les Dahlias", "Arnaques et Business lucratif", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOUTIQUE, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_SHOP_ADULTE, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), persosSecondairesMission250, null, itemsNecessairesMission250, new ArrayList<>(), 0, true);
		Mission mission260 = new Mission(260, "Les Bosquets", "Location AirBNB pas chere", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.BOUTIQUE, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_SHOP_ADULTE, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), persosSecondairesMission260, null, itemsNecessairesMission260, new ArrayList<>(), 0, true);

		
		
		// MISSIONS ACTION COMBAT
		
		// TODO gestion type d'ennemis TOUS, ARABES, NOIRS, GITANS, HANDICAPES en fonction de la mission
		
		// Sorts RUSS
		// TODO verifier : date + objet requis => ???
		// TODO titre trop long mission 310
		Mission mission310 = new Mission(310, ConfigurationManager.getProperties("mission.jonathan.310.nom"), ConfigurationManager.getProperties("mission.jonathan.310.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePoil, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission310, 0, false);
		Mission mission309 = new Mission(309, ConfigurationManager.getProperties("mission.jonathan.309.nom"), ConfigurationManager.getProperties("mission.jonathan.309.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTrilogie, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission309, 0, false);
		Mission mission308 = new Mission(308, ConfigurationManager.getProperties("mission.jonathan.308.nom"), ConfigurationManager.getProperties("mission.jonathan.308.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGSM, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission308, 0, false);
		Mission mission307 = new Mission(307, ConfigurationManager.getProperties("mission.jonathan.307.nom"), ConfigurationManager.getProperties("mission.jonathan.307.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission306, itemsDebloquesMission307, 0, false);
		Mission mission306 = new Mission(306, ConfigurationManager.getProperties("mission.jonathan.306.nom"), ConfigurationManager.getProperties("mission.jonathan.306.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission306, itemsDebloquesMission306, 0, false);
			Mission mission305 = new Mission(305, ConfigurationManager.getProperties("mission.jonathan.305.nom"), ConfigurationManager.getProperties("mission.jonathan.305.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGraisse, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission305, 0, false);
			Mission mission304 = new Mission(304, ConfigurationManager.getProperties("mission.jonathan.304.nom"), ConfigurationManager.getProperties("mission.jonathan.304.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRasage, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, new ArrayList<>(), 0, false);
			Mission mission303 = new Mission(303, ConfigurationManager.getProperties("mission.jonathan.303.nom"), ConfigurationManager.getProperties("mission.jonathan.303.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusPiscine, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, new ArrayList<>(), 0, true);
		Mission mission300 = new Mission(300, ConfigurationManager.getProperties("mission.jonathan.300.nom"), ConfigurationManager.getProperties("mission.jonathan.300.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission300, itemsDebloquesMission300, 0, false);
		Mission mission302 = new Mission(302, ConfigurationManager.getProperties("mission.jonathan.302.nom"), ConfigurationManager.getProperties("mission.jonathan.302.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatPunto, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission302, 0, false);
		Mission mission301 = new Mission(301, ConfigurationManager.getProperties("mission.jonathan.301.nom"), ConfigurationManager.getProperties("mission.jonathan.301.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatRequins, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMission301, 0, false);
		Mission mission311 = new Mission(311, ConfigurationManager.getProperties("mission.jonathan.311.nom"), ConfigurationManager.getProperties("mission.jonathan.311.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateStCyprien, MissionType.PRINCIPAL, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission311, itemsDebloquesMission311, 0, false);

		// Sorts GUY
		Mission mission400 = new Mission(400, ConfigurationManager.getProperties("mission.guillaume.400.nom"), ConfigurationManager.getProperties("mission.guillaume.400.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAzopardi, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission400, 0, false);
		Mission mission401 = new Mission(401, ConfigurationManager.getProperties("mission.guillaume.401.nom"), ConfigurationManager.getProperties("mission.guillaume.401.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAchatDoudoune, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission401, 0, false);
		Mission mission402 = new Mission(402, ConfigurationManager.getProperties("mission.guillaume.402.nom"), ConfigurationManager.getProperties("mission.guillaume.402.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateJonglerettes, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission402, 0, false);
		Mission mission403 = new Mission(403, ConfigurationManager.getProperties("mission.guillaume.403.nom"), ConfigurationManager.getProperties("mission.guillaume.403.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGuyApart, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission403, 0, false);
		Mission mission404 = new Mission(404, ConfigurationManager.getProperties("mission.guillaume.404.nom"), ConfigurationManager.getProperties("mission.guillaume.404.inf"), imagePaths404, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFacebook, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission404, 0, false);
		Mission mission405 = new Mission(405, ConfigurationManager.getProperties("mission.guillaume.405.nom"), ConfigurationManager.getProperties("mission.guillaume.405.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEscargot, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission405, 0, false);
		Mission mission406 = new Mission(406, ConfigurationManager.getProperties("mission.guillaume.406.nom"), ConfigurationManager.getProperties("mission.guillaume.406.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateIngurgite, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission406, 0, false);
		Mission mission407 = new Mission(407, ConfigurationManager.getProperties("mission.guillaume.407.nom"), ConfigurationManager.getProperties("mission.guillaume.407.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBite, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission407, 0, false);
		Mission mission408 = new Mission(408, ConfigurationManager.getProperties("mission.guillaume.408.nom"), ConfigurationManager.getProperties("mission.guillaume.408.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAzopardi2, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMission408, 0, false);
		
		// Sorts ALI
		Mission mission500 = new Mission(500, ConfigurationManager.getProperties("mission.ali.500.nom"), ConfigurationManager.getProperties("mission.ali.500.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date911, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission500, 0, false);
		Mission mission501 = new Mission(501, ConfigurationManager.getProperties("mission.ali.501.nom"), ConfigurationManager.getProperties("mission.ali.501.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePermisVoler, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission501, 0, false);
		Mission mission502 = new Mission(502, ConfigurationManager.getProperties("mission.ali.502.nom"), ConfigurationManager.getProperties("mission.ali.502.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSAV, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission502, 0, false);
		Mission mission503 = new Mission(503, ConfigurationManager.getProperties("mission.ali.503.nom"), ConfigurationManager.getProperties("mission.ali.503.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEspagne, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission503, 0, false);
		Mission mission504 = new Mission(504, ConfigurationManager.getProperties("mission.ali.504.nom"), ConfigurationManager.getProperties("mission.ali.504.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateLacrymo, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission504, itemsDebloquesMission504, 0, false);
		Mission mission505 = new Mission(505, ConfigurationManager.getProperties("mission.ali.505.nom"), ConfigurationManager.getProperties("mission.ali.505.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRap, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMission505, 0, false);
		Mission mission506 = new Mission(506, ConfigurationManager.getProperties("mission.ali.506.nom"), ConfigurationManager.getProperties("mission.ali.506.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCul, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission506, itemsDebloquesMission506, 0, false);
		Mission mission507 = new Mission(507, ConfigurationManager.getProperties("mission.ali.507.nom"), ConfigurationManager.getProperties("mission.ali.507.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCroche, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission504, itemsDebloquesMission507, 0, false);
		Mission mission508 = new Mission(508, ConfigurationManager.getProperties("mission.ali.508.nom"), ConfigurationManager.getProperties("mission.ali.508.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAliAli, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission508, itemsDebloquesMission508, 0, false);
	
		// Sorts TOM
		Mission mission600 = new Mission(600, ConfigurationManager.getProperties("mission.thomas.600.nom"), ConfigurationManager.getProperties("mission.thomas.600.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateTortue, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission600, 0, false);
		Mission mission601 = new Mission(601, ConfigurationManager.getProperties("mission.thomas.601.nom"), ConfigurationManager.getProperties("mission.thomas.601.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateScout, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission601, 0, false);
		Mission mission602 = new Mission(602, ConfigurationManager.getProperties("mission.thomas.602.nom"), ConfigurationManager.getProperties("mission.thomas.602.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateColRoulé, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission602, 0, false);
		Mission mission603 = new Mission(603, ConfigurationManager.getProperties("mission.thomas.603.nom"), ConfigurationManager.getProperties("mission.thomas.603.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSquat, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission603, itemsDebloquesMission603, 0, false);
		Mission mission604 = new Mission(604, ConfigurationManager.getProperties("mission.thomas.604.nom"), ConfigurationManager.getProperties("mission.thomas.604.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMillenium, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission604, 0, false);
		Mission mission605 = new Mission(605, ConfigurationManager.getProperties("mission.thomas.605.nom"), ConfigurationManager.getProperties("mission.thomas.605.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDrDre, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission605, 0, false);
		Mission mission606 = new Mission(606, ConfigurationManager.getProperties("mission.thomas.606.nom"), ConfigurationManager.getProperties("mission.thomas.606.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePerfusion, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission606, 0, false);
		Mission mission607 = new Mission(607, ConfigurationManager.getProperties("mission.thomas.607.nom"), ConfigurationManager.getProperties("mission.thomas.607.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSpiritisme, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission607, itemsDebloquesMission607, 0, false);
		Mission mission608 = new Mission(608, ConfigurationManager.getProperties("mission.thomas.608.nom"), ConfigurationManager.getProperties("mission.thomas.608.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFreres, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMission608, 0, false);

		// Sorts YA
		Mission mission700 = new Mission(700, ConfigurationManager.getProperties("mission.yannick.700.nom"), ConfigurationManager.getProperties("mission.yannick.700.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePoker, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission700, itemsDebloquesMission700, 0, false);
		Mission mission701 = new Mission(701, ConfigurationManager.getProperties("mission.yannick.701.nom"), ConfigurationManager.getProperties("mission.yannick.701.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateGrotte, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission701, itemsDebloquesMission701, 0, false);
		Mission mission702 = new Mission(702, ConfigurationManager.getProperties("mission.yannick.702.nom"), ConfigurationManager.getProperties("mission.yannick.702.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEau, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission702, itemsDebloquesMission702, 0, false);
		Mission mission703 = new Mission(703, ConfigurationManager.getProperties("mission.yannick.703.nom"), ConfigurationManager.getProperties("mission.yannick.703.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBase, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission703, itemsDebloquesMission703, 0, false);
		Mission mission704 = new Mission(704, ConfigurationManager.getProperties("mission.yannick.704.nom"), ConfigurationManager.getProperties("mission.yannick.704.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBuffy, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMission704, 0, false);
		Mission mission705 = new Mission(705, ConfigurationManager.getProperties("mission.yannick.705.nom"), ConfigurationManager.getProperties("mission.yannick.705.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRomeo, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMission705, 0, false);
		Mission mission706 = new Mission(706, ConfigurationManager.getProperties("mission.yannick.706.nom"), ConfigurationManager.getProperties("mission.yannick.706.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date6eme, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMission706, 0, false);
		Mission mission707 = new Mission(707, ConfigurationManager.getProperties("mission.yannick.707.nom"), ConfigurationManager.getProperties("mission.yannick.707.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBalcon, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission707, itemsDebloquesMission707, 0, false);
		Mission mission708 = new Mission(708, ConfigurationManager.getProperties("mission.yannick.708.nom"), ConfigurationManager.getProperties("mission.yannick.708.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateWorms, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission708, itemsDebloquesMission708, 0, false);
		
		// Sorts PIP
		Mission mission800 = new Mission(800, ConfigurationManager.getProperties("mission.pierre.800.nom"), ConfigurationManager.getProperties("mission.pierre.800.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCa, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission800, 0, false);
		Mission mission801 = new Mission(801, ConfigurationManager.getProperties("mission.pierre.801.nom"), ConfigurationManager.getProperties("mission.pierre.801.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNoel, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission801, 0, false);
		Mission mission802 = new Mission(802, ConfigurationManager.getProperties("mission.pierre.802.nom"), ConfigurationManager.getProperties("mission.pierre.802.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateFlaque, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission802, 0, false);
		Mission mission803 = new Mission(803, ConfigurationManager.getProperties("mission.pierre.803.nom"), ConfigurationManager.getProperties("mission.pierre.803.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMole, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission803, 0, false);
		Mission mission804 = new Mission(804, ConfigurationManager.getProperties("mission.pierre.804.nom"), ConfigurationManager.getProperties("mission.pierre.804.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBranlette, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission804, 0, false);
		Mission mission805 = new Mission(805, ConfigurationManager.getProperties("mission.pierre.805.nom"), ConfigurationManager.getProperties("mission.pierre.805.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRacaille, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission805, 0, false);
		Mission mission806 = new Mission(806, ConfigurationManager.getProperties("mission.pierre.806.nom"), ConfigurationManager.getProperties("mission.pierre.806.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date2000, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission806, 0, false);
		Mission mission807 = new Mission(807, ConfigurationManager.getProperties("mission.pierre.807.nom"), ConfigurationManager.getProperties("mission.pierre.807.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBoysBand, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMission807, 0, false);
		Mission mission808 = new Mission(808, ConfigurationManager.getProperties("mission.pierre.808.nom"), ConfigurationManager.getProperties("mission.pierre.808.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateOptic2000, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission808, itemsDebloquesMission808, 0, false);

		// Sorts NICO
		Mission mission900 = new Mission(900, ConfigurationManager.getProperties("mission.nicolas.900.nom"), ConfigurationManager.getProperties("mission.nicolas.900.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateStreetFighter, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission900, itemsDebloquesMission900, 0, false);
		// TODO video kaamelott 'fort en pomme'
		Mission mission901 = new Mission(901, ConfigurationManager.getProperties("mission.nicolas.901.nom"), ConfigurationManager.getProperties("mission.nicolas.901.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDBZ, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission901, 0, false);
		Mission mission902 = new Mission(902, ConfigurationManager.getProperties("mission.nicolas.902.nom"), ConfigurationManager.getProperties("mission.nicolas.902.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateStade, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission902, 0, false);
		Mission mission903 = new Mission(903, ConfigurationManager.getProperties("mission.nicolas.903.nom"), ConfigurationManager.getProperties("mission.nicolas.903.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMatrix, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission903, 0, false);
		Mission mission904 = new Mission(904, ConfigurationManager.getProperties("mission.nicolas.904.nom"), ConfigurationManager.getProperties("mission.nicolas.904.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateXMen, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission904, 0, false);
		Mission mission905 = new Mission(905, ConfigurationManager.getProperties("mission.nicolas.905.nom"), ConfigurationManager.getProperties("mission.nicolas.905.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateRapTout, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission905, 0, false);
		Mission mission906 = new Mission(906, ConfigurationManager.getProperties("mission.nicolas.906.nom"), ConfigurationManager.getProperties("mission.nicolas.906.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMirandaMission, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission906, 0, false);
		Mission mission907 = new Mission(907, ConfigurationManager.getProperties("mission.nicolas.907.nom"), ConfigurationManager.getProperties("mission.nicolas.907.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMuscu, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission907, itemsDebloquesMission907, 0, false);
		Mission mission908 = new Mission(908, ConfigurationManager.getProperties("mission.nicolas.908.nom"), ConfigurationManager.getProperties("mission.nicolas.908.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateMortalKombat, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMission908, 0, false);

		// Sorts Yo
		Mission mission1100 = new Mission(1100, ConfigurationManager.getProperties("mission.johann.1100.nom"), ConfigurationManager.getProperties("mission.johann.1100.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePisse, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission1100, itemsDebloquesMission1100, 0, false);
		Mission mission1101 = new Mission(1101, ConfigurationManager.getProperties("mission.johann.1101.nom"), ConfigurationManager.getProperties("mission.johann.1101.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateCarnaval, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1101, 0, false);
		Mission mission1102 = new Mission(1102, ConfigurationManager.getProperties("mission.johann.1102.nom"), ConfigurationManager.getProperties("mission.johann.1102.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateBooster, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1102, 0, false);
		Mission mission1103 = new Mission(1103, ConfigurationManager.getProperties("mission.johann.1103.nom"), ConfigurationManager.getProperties("mission.johann.1103.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateWow, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1103, 0, false);
		Mission mission1104 = new Mission(1104, ConfigurationManager.getProperties("mission.johann.1104.nom"), ConfigurationManager.getProperties("mission.johann.1104.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateEscalope, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1104, 0, false);
		Mission mission1105 = new Mission(1105, ConfigurationManager.getProperties("mission.johann.1105.nom"), ConfigurationManager.getProperties("mission.johann.1105.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, datePlantage, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission1105, itemsDebloquesMission1105, 0, false);
		Mission mission1106 = new Mission(1106, ConfigurationManager.getProperties("mission.johann.1106.nom"), ConfigurationManager.getProperties("mission.johann.1106.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateDance, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1106, 0, false);
		Mission mission1107 = new Mission(1107, ConfigurationManager.getProperties("mission.johann.1107.nom"), ConfigurationManager.getProperties("mission.johann.1107.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateHalloween, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMission1107, 0, false);
		Mission mission1108 = new Mission(1108, ConfigurationManager.getProperties("mission.johann.1108.nom"), ConfigurationManager.getProperties("mission.johann.1108.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateChiasse, MissionType.PRINCIPAL, difficultePartie, EnnemiType.TOUS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission1108, itemsDebloquesMission1108, 0, false);

		
		// MISSIONS REPETABLES BONUS

		
		// MISSIONS ANNIVERSAIRE QUIZZ - NICOLAS
		Mission mission2001 = new Mission(2001, ConfigurationManager.getProperties("mission.nicolas.2001.nom"), ConfigurationManager.getProperties("mission.nicolas.2001.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1990, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2002 = new Mission(2002, ConfigurationManager.getProperties("mission.nicolas.2002.nom"), ConfigurationManager.getProperties("mission.nicolas.2002.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1991, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2003 = new Mission(2003, ConfigurationManager.getProperties("mission.nicolas.2003.nom"), ConfigurationManager.getProperties("mission.nicolas.2003.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1992, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2004 = new Mission(2004, ConfigurationManager.getProperties("mission.nicolas.2004.nom"), ConfigurationManager.getProperties("mission.nicolas.2004.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1993, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2005 = new Mission(2005, ConfigurationManager.getProperties("mission.nicolas.2005.nom"), ConfigurationManager.getProperties("mission.nicolas.2005.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1994, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2006 = new Mission(2006, ConfigurationManager.getProperties("mission.nicolas.2006.nom"), ConfigurationManager.getProperties("mission.nicolas.2006.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1995, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2007 = new Mission(2007, ConfigurationManager.getProperties("mission.nicolas.2007.nom"), ConfigurationManager.getProperties("mission.nicolas.2007.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1996, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2008 = new Mission(2008, ConfigurationManager.getProperties("mission.nicolas.2008.nom"), ConfigurationManager.getProperties("mission.nicolas.2008.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1997, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2009 = new Mission(2009, ConfigurationManager.getProperties("mission.nicolas.2009.nom"), ConfigurationManager.getProperties("mission.nicolas.2009.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2010 = new Mission(2010, ConfigurationManager.getProperties("mission.nicolas.2010.nom"), ConfigurationManager.getProperties("mission.nicolas.2010.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2011 = new Mission(2011, ConfigurationManager.getProperties("mission.nicolas.2011.nom"), ConfigurationManager.getProperties("mission.nicolas.2011.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivNico2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionNico, itemsDebloquesMissionAnniversaireINT10, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - THOMAS
		Mission mission2012 = new Mission(2012, ConfigurationManager.getProperties("mission.thomas.2012.nom"), ConfigurationManager.getProperties("mission.thomas.2012.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1990, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2013 = new Mission(2013, ConfigurationManager.getProperties("mission.thomas.2013.nom"), ConfigurationManager.getProperties("mission.thomas.2013.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1991, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2014 = new Mission(2014, ConfigurationManager.getProperties("mission.thomas.2014.nom"), ConfigurationManager.getProperties("mission.thomas.2014.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1992, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2015 = new Mission(2015, ConfigurationManager.getProperties("mission.thomas.2015.nom"), ConfigurationManager.getProperties("mission.thomas.2015.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1993, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2016 = new Mission(2016, ConfigurationManager.getProperties("mission.thomas.2016.nom"), ConfigurationManager.getProperties("mission.thomas.2016.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1994, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2017 = new Mission(2017, ConfigurationManager.getProperties("mission.thomas.2017.nom"), ConfigurationManager.getProperties("mission.thomas.2017.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1995, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2018 = new Mission(2018, ConfigurationManager.getProperties("mission.thomas.2018.nom"), ConfigurationManager.getProperties("mission.thomas.2018.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1996, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2019 = new Mission(2019, ConfigurationManager.getProperties("mission.thomas.2019.nom"), ConfigurationManager.getProperties("mission.thomas.2019.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1997, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2020 = new Mission(2020, ConfigurationManager.getProperties("mission.thomas.2020.nom"), ConfigurationManager.getProperties("mission.thomas.2020.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2021 = new Mission(2021, ConfigurationManager.getProperties("mission.thomas.2021.nom"), ConfigurationManager.getProperties("mission.thomas.2021.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2022 = new Mission(2022, ConfigurationManager.getProperties("mission.thomas.2022.nom"), ConfigurationManager.getProperties("mission.thomas.2022.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivTom2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionTom, itemsDebloquesMissionAnniversaireINT10, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - YANNICK
		Mission mission2023 = new Mission(2023, ConfigurationManager.getProperties("mission.yannick.2023.nom"), ConfigurationManager.getProperties("mission.yannick.2023.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1991, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2024 = new Mission(2024, ConfigurationManager.getProperties("mission.yannick.2024.nom"), ConfigurationManager.getProperties("mission.yannick.2024.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1992, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2025 = new Mission(2025, ConfigurationManager.getProperties("mission.yannick.2025.nom"), ConfigurationManager.getProperties("mission.yannick.2025.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1993, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2026 = new Mission(2026, ConfigurationManager.getProperties("mission.yannick.2026.nom"), ConfigurationManager.getProperties("mission.yannick.2026.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1994, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2027 = new Mission(2027, ConfigurationManager.getProperties("mission.yannick.2027.nom"), ConfigurationManager.getProperties("mission.yannick.2027.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1995, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2028 = new Mission(2028, ConfigurationManager.getProperties("mission.yannick.2028.nom"), ConfigurationManager.getProperties("mission.yannick.2028.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1996, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2029 = new Mission(2029, ConfigurationManager.getProperties("mission.yannick.2029.nom"), ConfigurationManager.getProperties("mission.yannick.2029.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1997, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2030 = new Mission(2030, ConfigurationManager.getProperties("mission.yannick.2030.nom"), ConfigurationManager.getProperties("mission.yannick.2030.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2031 = new Mission(2031, ConfigurationManager.getProperties("mission.yannick.2031.nom"), ConfigurationManager.getProperties("mission.yannick.2031.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2032 = new Mission(2032, ConfigurationManager.getProperties("mission.yannick.2032.nom"), ConfigurationManager.getProperties("mission.yannick.2032.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYa2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYa, itemsDebloquesMissionAnniversaireINT10, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - JOHANN
		Mission mission2033 = new Mission(2033, ConfigurationManager.getProperties("mission.johann.2033.nom"), ConfigurationManager.getProperties("mission.johann.2033.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1991, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2034 = new Mission(2034, ConfigurationManager.getProperties("mission.johann.2034.nom"), ConfigurationManager.getProperties("mission.johann.2034.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1992, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2035 = new Mission(2035, ConfigurationManager.getProperties("mission.johann.2035.nom"), ConfigurationManager.getProperties("mission.johann.2035.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1993, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2036 = new Mission(2036, ConfigurationManager.getProperties("mission.johann.2036.nom"), ConfigurationManager.getProperties("mission.johann.2036.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1994, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2037 = new Mission(2037, ConfigurationManager.getProperties("mission.johann.2037.nom"), ConfigurationManager.getProperties("mission.johann.2037.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1995, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2038 = new Mission(2038, ConfigurationManager.getProperties("mission.johann.2038.nom"), ConfigurationManager.getProperties("mission.johann.2038.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1996, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2039 = new Mission(2039, ConfigurationManager.getProperties("mission.johann.2039.nom"), ConfigurationManager.getProperties("mission.johann.2039.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1997, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2040 = new Mission(2040, ConfigurationManager.getProperties("mission.johann.2040.nom"), ConfigurationManager.getProperties("mission.johann.2040.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2041 = new Mission(2041, ConfigurationManager.getProperties("mission.johann.2041.nom"), ConfigurationManager.getProperties("mission.johann.2041.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2042 = new Mission(2042, ConfigurationManager.getProperties("mission.johann.2042.nom"), ConfigurationManager.getProperties("mission.johann.2042.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivYo2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionYo, itemsDebloquesMissionAnniversaireINT10, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - PIERRE
		Mission mission2043 = new Mission(2043, ConfigurationManager.getProperties("mission.pierre.2043.nom"), ConfigurationManager.getProperties("mission.pierre.2043.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1991, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2044 = new Mission(2044, ConfigurationManager.getProperties("mission.pierre.2044.nom"), ConfigurationManager.getProperties("mission.pierre.2044.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1992, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2045 = new Mission(2045, ConfigurationManager.getProperties("mission.pierre.2045.nom"), ConfigurationManager.getProperties("mission.pierre.2045.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1993, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2046 = new Mission(2046, ConfigurationManager.getProperties("mission.pierre.2046.nom"), ConfigurationManager.getProperties("mission.pierre.2046.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1994, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2047 = new Mission(2047, ConfigurationManager.getProperties("mission.pierre.2047.nom"), ConfigurationManager.getProperties("mission.pierre.2047.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1995, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2048 = new Mission(2048, ConfigurationManager.getProperties("mission.pierre.2048.nom"), ConfigurationManager.getProperties("mission.pierre.2048.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1996, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2049 = new Mission(2049, ConfigurationManager.getProperties("mission.pierre.2049.nom"), ConfigurationManager.getProperties("mission.pierre.2049.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1997, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2050 = new Mission(2050, ConfigurationManager.getProperties("mission.pierre.2050.nom"), ConfigurationManager.getProperties("mission.pierre.2050.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2051 = new Mission(2051, ConfigurationManager.getProperties("mission.pierre.2051.nom"), ConfigurationManager.getProperties("mission.pierre.2051.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2052 = new Mission(2052, ConfigurationManager.getProperties("mission.pierre.2052.nom"), ConfigurationManager.getProperties("mission.pierre.2052.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivPip2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionPip, itemsDebloquesMissionAnniversaireINT10, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - ALI
		Mission mission2053 = new Mission(2053, ConfigurationManager.getProperties("mission.ali.2053.nom"), ConfigurationManager.getProperties("mission.ali.2053.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivAli1996, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2054 = new Mission(2054, ConfigurationManager.getProperties("mission.ali.2054.nom"), ConfigurationManager.getProperties("mission.ali.2054.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivAli1997, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2055 = new Mission(2055, ConfigurationManager.getProperties("mission.ali.2055.nom"), ConfigurationManager.getProperties("mission.ali.2055.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivAli1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2056 = new Mission(2056, ConfigurationManager.getProperties("mission.ali.2056.nom"), ConfigurationManager.getProperties("mission.ali.2056.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivAli1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2057 = new Mission(2057, ConfigurationManager.getProperties("mission.ali.2057.nom"), ConfigurationManager.getProperties("mission.ali.2057.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivAli2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionAli, itemsDebloquesMissionAnniversaireINT20, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - GUILLAUME
		Mission mission2058 = new Mission(2058, ConfigurationManager.getProperties("mission.guillaume.2058.nom"), ConfigurationManager.getProperties("mission.guillaume.2058.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivGuy1998, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2059 = new Mission(2059, ConfigurationManager.getProperties("mission.guillaume.2059.nom"), ConfigurationManager.getProperties("mission.guillaume.2059.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivGuy1999, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMissionAnniversaireINT5, 0, false);
		Mission mission2060 = new Mission(2060, ConfigurationManager.getProperties("mission.guillaume.2060.nom"), ConfigurationManager.getProperties("mission.guillaume.2060.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivGuy2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionGuy, itemsDebloquesMissionAnniversaireINT20, 0, false);

		// MISSIONS ANNIVERSAIRE QUIZZ - JONATHAN
		Mission mission2061 = new Mission(2061, ConfigurationManager.getProperties("mission.jonathan.2061.nom"), ConfigurationManager.getProperties("mission.jonathan.2061.inf"), imagePaths1, sonPathsAnniversaire, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateAnnivRuss2000, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMissionAnniversaireINT20, 0, false);

		// MISSION QUIZZ REPETABLE POUR FINIR TOUTES LES QUESTIONS
		Mission mission2062 = new Mission(2062, ConfigurationManager.getProperties("mission.repetable.quizz.2062.nom"), ConfigurationManager.getProperties("mission.repetable.quizz.2062.inf"), imagePaths1, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, date21siecle, MissionType.QUIZZ, difficultePartie, null, NomJeu.JEU_QUIZZ, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionRuss, itemsDebloquesMissionAnniversaireINT5, 0, true);

		
		// MISSIONS FOOT
		
		// MISSIONS FOOT ECOLE
		Mission mission3001 = new Mission(3001, ConfigurationManager.getProperties("mission.repetable.foot.ecole.5v5.3001.nom"), ConfigurationManager.getProperties("mission.repetable.foot.ecole.5v5.3001.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3001, itemsDebloquesMission3001, 0, true);
	
		// MISSIONS FOOT TERRAIN
		Mission mission3002 = new Mission(3002, ConfigurationManager.getProperties("mission.repetable.foot.terrain.5v5.3002.nom"), ConfigurationManager.getProperties("mission.repetable.foot.terrain.5v5.3002.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3002, itemsDebloquesMission3001, 0, true);
		Mission mission3003 = new Mission(3003, ConfigurationManager.getProperties("mission.repetable.foot.terrain.6v6.3003.nom"), ConfigurationManager.getProperties("mission.repetable.foot.terrain.6v6.3003.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3003, itemsDebloquesMission3001, 0, true);
		Mission mission3004 = new Mission(3004, ConfigurationManager.getProperties("mission.repetable.foot.terrain.7v7.3004.nom"), ConfigurationManager.getProperties("mission.repetable.foot.terrain.7v7.3004.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3004, itemsDebloquesMission3001, 0, true);
		Mission mission3005 = new Mission(3005, ConfigurationManager.getProperties("mission.repetable.foot.terrain.8v8.3005.nom"), ConfigurationManager.getProperties("mission.repetable.foot.terrain.8v8.3005.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateNull, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3005, itemsDebloquesMission3001, 0, true);
	
		// MISSIONS FOOT CHELLES
		Mission mission3006 = new Mission(3006, ConfigurationManager.getProperties("mission.repetable.foot.chelles.7v7.3006.nom"), ConfigurationManager.getProperties("mission.repetable.foot.chelles.7v7.3006.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateFootChelles, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3006, itemsDebloquesMission3001, 0, true);
		Mission mission3007 = new Mission(3007, ConfigurationManager.getProperties("mission.repetable.foot.chelles.8v8.3007.nom"), ConfigurationManager.getProperties("mission.repetable.foot.chelles.8v8.3007.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateFootChelles, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3007, itemsDebloquesMission3001, 0, true);
	
		// MISSIONS FOOT NOISY
		Mission mission3008 = new Mission(3008, ConfigurationManager.getProperties("mission.repetable.foot.noisy.5v5.3008.nom"), ConfigurationManager.getProperties("mission.repetable.foot.noisy.5v5.3008.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateFootNoisy, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3008, itemsDebloquesMission3001, 0, true);
		Mission mission3009 = new Mission(3009, ConfigurationManager.getProperties("mission.repetable.foot.noisy.6v6.3009.nom"), ConfigurationManager.getProperties("mission.repetable.foot.noisy.6v6.3009.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusFoot, bonusVide, 1, 1, dateFootNoisy, MissionType.FOOT, difficultePartie, null, NomJeu.JEU_FOOT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMission3009, itemsDebloquesMission3001, 0, true);

		
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
		// TODO faire des missions mini BOSS (les profs et persos secondaires)
		
		// 				/  ANIMAL / FILM / SPORT / CHANTEUR / MUSIQUE / GROUPE DE MUSIQUE / JEU VIDEO / PERSONNAGE DE FILM )
		// GUILLAUME	/ Serpent
		// PIERRE		/ Elephant
		// JONATHAN		/ Taureau
		// NICOLAS		/ Fouine
		// THOMAS		/ Tortue
		// ALI			/ Hibou
		// JOHANN		/ Aigle /
		// YANNICK		/ Vache
		
		///////////////
		// MINI BOSS //
		///////////////

		Mission mission1011 = new Mission(1011, ConfigurationManager.getProperties("mission.miniboss.1011.nom"), ConfigurationManager.getProperties("mission.miniboss.1011.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss11, bonusVide, 1, 1, dateMiniBoss11, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, 	NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS11, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1011, 0, false);
		Mission mission1012 = new Mission(1012, ConfigurationManager.getProperties("mission.miniboss.1012.nom"), ConfigurationManager.getProperties("mission.miniboss.1012.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss12, bonusVide, 1, 1, dateMiniBoss12, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS12, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1012, 0, false);
		Mission mission1013 = new Mission(1013, ConfigurationManager.getProperties("mission.miniboss.1013.nom"), ConfigurationManager.getProperties("mission.miniboss.1013.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss13, bonusVide, 1, 1, dateMiniBoss13, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, 	NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS13, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1013, 0, false);
		Mission mission1014 = new Mission(1014, ConfigurationManager.getProperties("mission.miniboss.1014.nom"), ConfigurationManager.getProperties("mission.miniboss.1014.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss14, bonusVide, 1, 1, dateMiniBoss14, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, 	NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS14, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1014, 0, false);
		Mission mission1015 = new Mission(1015, ConfigurationManager.getProperties("mission.miniboss.1015.nom"), ConfigurationManager.getProperties("mission.miniboss.1015.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusBoss15, bonusVide, 1, 1, dateMiniBoss15, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, 	NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS15, itemsNecessairesMissionMiniBoss, itemsDebloquesMission1015, 0, false);
		
		/////////////////
		// BOSS FINAUX //
		/////////////////
		
		// MISSIONS BOSS YO (Pere/Zidane/Daft Punk/Nemo/Lady Gaga) (image : olive et tom) (recompense : Le ballon d'or)
		Mission mission1001 = new Mission(1001, ConfigurationManager.getProperties("mission.boss.johann.1001.nom"), ConfigurationManager.getProperties("mission.boss.johann.1001.inf"), imagePaths1001, sonPaths1, null, PersoPrenom.Johann, null, 100, "", "", "objectif1", bonusBoss1, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS1, itemsNecessairesMissionBoss1, itemsDebloquesMission1001, 0, false);
		
		// MISSIONS BOSS NICO (Lara Croft) (image : Laure Saintclair) (recompense : Le grappin en or)
		Mission mission1002 = new Mission(1002, ConfigurationManager.getProperties("mission.boss.nicolas.1002.nom"), ConfigurationManager.getProperties("mission.boss.nicolas.1002.inf"), imagePaths1002, sonPaths1, null, PersoPrenom.Nicolas, null, 100, "", "", "objectif1", bonusBoss2, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS2, itemsNecessairesMissionBoss2, itemsDebloquesMission1002, 0, false);
		
		// MISSIONS BOSS PIP (DUMBO / DR DRE / EMiNEM / MARAK-Marek) (image : eminem) (recompense : La médaille d'or)
		Mission mission1003 = new Mission(1003, ConfigurationManager.getProperties("mission.boss.pierre.1003.nom"), ConfigurationManager.getProperties("mission.boss.pierre.1003.inf"), imagePaths1003, sonPaths1, null, PersoPrenom.Pierre, null, 100, "", "", "objectif1", bonusBoss3, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS3, itemsNecessairesMissionBoss3, itemsDebloquesMission1003, 0, false);

		// MISSIONS BOSS TOM (Sosie : Ben Stiller / Juninho / Hitler) (image : dieudonne quenelle) (recompense : Le mouchoir d'or)
		Mission mission1004 = new Mission(1004, ConfigurationManager.getProperties("mission.boss.thomas.1004.nom"), ConfigurationManager.getProperties("mission.boss.thomas.1004.inf"), imagePaths1004, sonPaths1, null, PersoPrenom.Thomas, null, 100, "", "", "objectif1", bonusBoss4, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.ARABES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS4, itemsNecessairesMissionBoss4, itemsDebloquesMission1004, 0, false);
  
		// MISSIONS BOSS YA (Anakin Skywalker) (image : lego starwars / worms armaggedon) (recompense : Le sabre d'or)
		Mission mission1005 = new Mission(1005, ConfigurationManager.getProperties("mission.boss.yannick.1005.nom"), ConfigurationManager.getProperties("mission.boss.yannick.1005.inf"), imagePaths1005, sonPaths1, null, PersoPrenom.Yannick, null, 100, "", "", "objectif1", bonusBoss5, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS5, itemsNecessairesMissionBoss5, itemsDebloquesMission1005, 0, false);

		// MISSIONS BOSS ALI (Mickeal Jackson) (image : gants de medecin) (recompense : Le micro d'or)
		Mission mission1006 = new Mission(1006, ConfigurationManager.getProperties("mission.boss.ali.1006.nom"), ConfigurationManager.getProperties("mission.boss.ali.1006.inf"), imagePaths1006, sonPaths1, null, PersoPrenom.Ali, null, 100, "", "", "objectif1", bonusBoss6, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.GITANS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS6, itemsNecessairesMissionBoss6, itemsDebloquesMission1006, 0, false);

		// MISSIONS BOSS GUY (Solid Snke / Indiana Jones / Robert de Niro / Serpent / Scream) (image : scream) (recompense : La coupe en or)
		Mission mission1007 = new Mission(1007, ConfigurationManager.getProperties("mission.boss.guillaume.1007.nom"), ConfigurationManager.getProperties("mission.boss.guillaume.1007.inf"), imagePaths1007, sonPaths1, null, PersoPrenom.Guillaume, null, 100, "", "", "objectif1", bonusBoss7, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.HANDICAPES, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS7, itemsNecessairesMissionBoss7, itemsDebloquesMission1007, 0, false);

		// MISSIONS BOSS RUSS (Son double Arnaud de la piscine) (5 mytho par semaine) (image : serge le mytho) (recompense : La palme d'or)
		Mission mission1008 = new Mission(1008, ConfigurationManager.getProperties("mission.boss.jonathan.1008.nom"), ConfigurationManager.getProperties("mission.boss.jonathan.1008.inf"), imagePaths1008, sonPaths1, null, PersoPrenom.Jonathan, null, 100, "", "", "objectif1", bonusBoss8, bonusVide, 1, 1, dateNull, MissionType.BOSS, difficultePartie, EnnemiType.NOIRS, NomJeu.JEU_COMBAT, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), BossNom.BOSS8, itemsNecessairesMissionBoss8, itemsDebloquesMission1008, 0, false);

		// MISSION FINALE
		// TODO (TOUS LES BOSS)
		Mission mission1000 = new Mission(1000, ConfigurationManager.getProperties("mission.final.1000.nom"), ConfigurationManager.getProperties("mission.final.1000.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, itemsNecessairesMissionFinale, new ArrayList<>(), 0, false);
		
		Mission mission999 = new Mission(999, ConfigurationManager.getProperties("mission.final.999.nom"), ConfigurationManager.getProperties("mission.final.999.inf"), imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, null, 100, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateSortieDuJeu, MissionType.PRINCIPAL, difficultePartie, null, NomJeu.JEU_RANDOM, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), null, new ArrayList<>(), new ArrayList<>(), 0, false);
	
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

		missions.add(mission203);
		missions.add(mission204);
		missions.add(mission205);
		missions.add(mission206);

		missions.add(mission230);
		missions.add(mission240);
		missions.add(mission250);
		missions.add(mission260);

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
		missions.add(mission999);
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
		
		missions.add(mission2001);
		missions.add(mission2002);
		missions.add(mission2003);
		missions.add(mission2004);
		missions.add(mission2005);
		missions.add(mission2006);
		missions.add(mission2007);
		missions.add(mission2008);
		missions.add(mission2009);
		missions.add(mission2010);
		missions.add(mission2011);
		missions.add(mission2012);
		missions.add(mission2013);
		missions.add(mission2014);
		missions.add(mission2015);
		missions.add(mission2016);
		missions.add(mission2017);
		missions.add(mission2018);
		missions.add(mission2019);
		missions.add(mission2020);
		missions.add(mission2021);
		missions.add(mission2022);
		missions.add(mission2023);
		missions.add(mission2024);
		missions.add(mission2025);
		missions.add(mission2026);
		missions.add(mission2027);
		missions.add(mission2028);
		missions.add(mission2029);
		missions.add(mission2030);
		missions.add(mission2031);
		missions.add(mission2032);
		missions.add(mission2033);
		missions.add(mission2034);
		missions.add(mission2035);
		missions.add(mission2036);
		missions.add(mission2037);
		missions.add(mission2038);
		missions.add(mission2039);
		missions.add(mission2040);
		missions.add(mission2041);
		missions.add(mission2042);
		missions.add(mission2043);
		missions.add(mission2044);
		missions.add(mission2045);
		missions.add(mission2046);
		missions.add(mission2047);
		missions.add(mission2048);
		missions.add(mission2049);
		missions.add(mission2050);
		missions.add(mission2051);
		missions.add(mission2052);
		missions.add(mission2053);
		missions.add(mission2054);
		missions.add(mission2055);
		missions.add(mission2056);
		missions.add(mission2057);
		missions.add(mission2058);
		missions.add(mission2059);
		missions.add(mission2060);
		missions.add(mission2061);
		missions.add(mission2062);
		
		missions.add(mission3001);
		missions.add(mission3002);
		missions.add(mission3003);
		missions.add(mission3004);
		missions.add(mission3005);
		missions.add(mission3006);
		missions.add(mission3007);
		missions.add(mission3008);
		missions.add(mission3009);

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
			// Si la mission est deja faite et non repetable, on la retire des missions jouables
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
				if (mission.getVideoPaths() != null && mission.getVideoPaths().get(0) != null) {
					VideoManager.play(mission.getVideoPaths().get(0));
				}
				
				// Afficher JDialog pour la mission
				int type = getTypeMission(mission);
				ImageIcon image = FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0));
				// Si il n y a pas d image, on retourne l icone par defaut d une
				// mission
				if (image.getIconWidth() == -1) {
					image =  FenetrePrincipal.getImageIcon("image/defaut/defautItemMission.jpg");
				}
				ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.PERSO_IMAGE_DIMENSION_180_180);
				
				JTextArea labelMessage = new JTextArea(mission.getNom() + " : " + mission.getInformations());
				labelMessage.setLineWrap(true);
				labelMessage.setWrapStyleWord(true);
				labelMessage.setEditable(false);
				labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
				labelMessage.setForeground(Color.BLACK);
				labelMessage.setOpaque(false);
				labelMessage.setSize(Constante.INFO_MISSION_800_100);
				labelMessage.setMinimumSize(Constante.INFO_MISSION_800_100);  
				
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
						labelMessage,"Mission debloquée pour " + mission.getProprietaire().name(), type, resizeImage);

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
		
		MusiqueManager.stopAll();
		MusiqueManager.stopPlaylistEnBoucle();

		// Si win
		boolean finduJeu = false;
		if (win) {
			
			// Musique de victoire
			List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("musique/victoire", 25000);
			MusiqueManager.playMusiquesRandom(musiques);
			
			mission.setDejaFaite(true);
			// Message mission win
			ImageIcon resizeImage = ImageManager.resizeImage(FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0)), Constante.PERSO_IMAGE_DIMENSION_180_180);
			JLabel labelMessage = new JLabel("Mission reussie!");
			labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), labelMessage, mission.getNom(), 0, resizeImage);
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

				if (difficultePartie == Difficulte.HEROIQUE) {
					MusiqueManager.stopAll();
					MusiqueManager.playSonEvenement("sonParDefaut/Yiruma - River Flows in You.mp3");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Voila, c'est fini!");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Toutes les bonnes choses ont une fin.");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Click sur le bouton et attends la fin de la chanson.");
					
				
					// TODO Hommage Suzie Le Guyader
					ImageIcon resizeImage2 = ImageManager.resizeImage(FenetrePrincipal.getImageIcon("image/suzon/suzon.png"), Constante.PERSO_IMAGE_DIMENSION_360_360);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), "En hommage à Suzon", "...", 0, resizeImage2);
					
					MusiqueManager.stopAll();
					MusiqueManager.playSonEvenement("sonParDefaut/Louane - Je vole.mp3");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Merci!");
				} else {
					
					// Musique fin du jeu
					MusiqueManager.stopAll();
					MusiqueManager.playSonEvenement("sonParDefaut/defautFinDuJeu.mp3");

					// Message fin du jeu
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Félicitations! T'as terminé le jeu en difficulté " + difficultePartie.name() + " !");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Envoie tes statistiques sur le site pour comparer ton score avec les autres!");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Envoie moi tes remarques/critiques/souhaits pour une eventuelle future prochaine version possible!");
					
					if (difficultePartie == Difficulte.FACILE) {
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"T'as désormais le droit de traverser la route sans adulte et en dehors des passages pietons!");
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"Si t'es une racaille, tu peux essayer en difficulté 'NORMAL'");
						
					} else if (difficultePartie == Difficulte.NORMAL) {
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"T'as désormais le droit de te branler sans demander a tes parents l'autorisation!");
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"Si t'es un homme, tu peux essayer en difficulté 'DIFFICILE'");
						
					} else if (difficultePartie == Difficulte.DIFFICILE) {
						// TODO messages en fonction de la difficulte
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"Si tu as aimé ce jeu, tu peux faire directement un don à l'équipe de développement!");
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"L'intégralité des recettes sera reversée à des oeuvres caritatives telles que 'La croix rouge', 'Médecin sans frontières' ou 'Des millions de copains'!");
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"Nan j'déconne!");
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"Je vais tout garder pour moi!");
						
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"T'as désormais le droit de sucer le frère d'Ali pour une durée indeterminée!");
						JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
								"Si t'es un vrai ouf, tu peux essayer en difficulté 'HEROIQUE'");
					} 
					
					MusiqueManager.stopAll();
					MusiqueManager.playSonEvenement("sonParDefaut/Sad Emotional Piano Music.mp3");
					JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
							"Merci!");
				}
				
				int score = calculeScoreFinal();
				
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Prends en photo ton score et envoie le sur le groupe du Terrain!");
				
				JOptionPane.showMessageDialog(MenuPrincipal.getMainFrame(),
						"Ton score est de " + score + " / 1000 en difficulte " + difficultePartie.name() + "!");
							
				// Quitter ou continuer
				int quitter = JOptionPane.showOptionDialog(MenuPrincipal.getMainFrame(),
						"Tu peux rester dans le jeu et continuer de clicker sur suivant si tu n'as rien de mieux à faire!",
						"Fin du jeu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
						FenetrePrincipal.getImageIcon("image/defaut/defautEvenement.png"),
						new String[] { "Continuer", "Me barrer de ce jeu de merde" }, "default");
				if (quitter == 1) {
					// Retour menuPrincipal
					FenetrePrincipal fenetrePrincipal = FenetrePrincipal.getFenetrePrincipal();
					fenetrePrincipal.setVisible(true);

					// Supprime le panelVideo et la MainFrame
					MenuPrincipal.getMainFrame().dispose();
					VideoManager.hideAndStop();
					finduJeu = true;
				}
			}

			// Si loose
		} else {
			
			// Musique de defaite
			List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("musique/defaite", 30000);
			MusiqueManager.playMusiquesRandom(musiques);
			
			JLabel labelMessage = new JLabel("Mission echouee!");
			labelMessage.setFont(Constante.MARIO_FONT_MENU_2);
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), labelMessage, mission.getNom(),
					1, FenetrePrincipal.getImageIcon(mission.getImagePaths().get(0)));
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
			MainFrame.getPanelPersonnage().refreshMortsPersonnage();
		}

	}

	public int calculeScoreFinal() {
		
		int scoreFinal = 0;
		
		if (missionsTerminees == null || missionsTerminees.isEmpty()) {

		} else {
			
			// TODO meilleur calcule du score /1000 ? 100 points par competences
			
			
			// -Luck
			// Random (0-100) en fonction de la chance moyenne de l'equipe? random(moyenne - 100)
			
			// -Exploit
			// Argent final (0-100 000)
			
			// -Technique
			// Avoir toutes les cartes (10 par carte)
			
			// -Endurance
			// Competences full (80 et 100%)
			
			// -Rapidite
			// Nombre de missions/sorts restantes (100 si au moins 10 missions restantes)
			
			// -Resistance
			// Nombre de mission rates (10 max) nb essais
			
			// -Agilite
			// Si tout le monde a une arme epique (20-100)
			
			// -Intelligence
			// Quizz (0-100 10 mauvaises reponses)
			
			// -Nervosite
			// Action combat niv 10 par perso (10 par perso qui a un lvl 10)

			
			// On ajoute 40 point pour chaque carte decouverte (max 960)
			List<Item> itemsDisponibles = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getItemsDisponibles();
			for (Item item : itemsDisponibles) {
				if (item.getType() == ItemType.CARTE_CRADOS) {
					scoreFinal = scoreFinal + 40;
				} else if (item.getType() == ItemType.CARTE_DBZ) {
					scoreFinal = scoreFinal + 40;
				} else if (item.getType() == ItemType.CARTE_STARWARS) {
					scoreFinal = scoreFinal + 40;
				}
			}
			
			// On retire un point pour chaque mission effectue
			int nbMissionsTerminees = missionsTerminees.size();
			scoreFinal = scoreFinal - nbMissionsTerminees;
			
			// On retire un point pour chaque question quizz ratee
			for (Mission mission : missionsTerminees) {
				if (mission.getMissionType() == MissionType.QUIZZ) {
					int scoreNegatif = mission.getNombreEssai() - mission.getNombreWin();
					if (scoreNegatif > 0) {
						scoreFinal = scoreFinal - scoreNegatif;
					}
				}
			}
			
			if (scoreFinal < 0) {
				scoreFinal = 0;
			}

		}
		
		return scoreFinal;
			
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
					
					// Lancer le son par defaut nouvel item
					MusiqueManager.playSonItem("sonParDefaut/harpe.mp3");
					
					// Afficher JDialog pour le lieu debloque
					ImageIcon itemLieu = FenetrePrincipal.getImageIcon("image/defaut/defautLieu.png");
					ImageIcon resizeImage = ImageManager.resizeImage(itemLieu, Constante.PERSO_IMAGE_DIMENSION_180_180);
					JLabel labelMessage = new JLabel(lieuById.getProprietaire() + " a debloque un nouveau Lieu : " + lieuById.getNom());
					labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
							labelMessage,
							"Nouveau Lieu disponible !", 0, resizeImage);
				} else {
					System.err.println("Mauvaise identifiant de Lieu pendant le deblocage. ID = (" + idLieu + ")");
				}
			}
			
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
				if(itemType.equals(ItemType.ACTION_COMBAT.name().toLowerCase())) {
					itemType = "Sort";
				}
				if (item.getType() == ItemType.CARTE_CRADOS) {
					resizedImage = ImageManager.resizeImage(itemImage, Constante.CRADOS_IMAGE_DIMENSION_360_500);
				} else if (item.getType() == ItemType.CARTE_DBZ) {
					resizedImage = ImageManager.resizeImage(itemImage, Constante.DBZ_IMAGE_DIMENSION_360_500);
				} else if (item.getType() == ItemType.CARTE_STARWARS) {
					resizedImage = ImageManager.resizeImage(itemImage, Constante.STARWARS_IMAGE_DIMENSION_360_500);
				}


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
						JLabel labelMessage = new JLabel(proprietaire + " acceuille un nouveau personnage : " + perso.getPrenom());
						labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
						JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), labelMessage,
								"Nouvel arrivant", type, image);
					} else {	
						String info = "";
						if (!item.getInformations().isEmpty()) {
							info = " - " + item.getInformations();
						}
						
						JTextArea infoMissionValue = new JTextArea(proprietaire + " a debloque : " + item.getNom() + info);
						infoMissionValue.setLineWrap(true);
						infoMissionValue.setWrapStyleWord(true);
						infoMissionValue.setEditable(false);
						infoMissionValue.setFont(Constante.MARIO_FONT_MENU_3);
						infoMissionValue.setForeground(Color.BLACK);
						infoMissionValue.setOpaque(false);
						infoMissionValue.setSize(Constante.INFO_MISSION_800_100);
						infoMissionValue.setMinimumSize(Constante.INFO_MISSION_800_100);  
						
						
						JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), infoMissionValue,
								"Nouveau type d'objet disponible ! (" + itemType + ")", type, resizedImage);
					}
					
					item.setDisponible(true);
				}
				Groupe leGroupe = personnageManager.getLeGroupe();
				
				// Si c'est une Arme
				if (item.getType().name().equals(ItemType.ARME.name())) {
					// On genere un nouvelle arme pour le proprio ou pour le groupe
					Arme arme = ItemManager.genereArme((Arme)item, mission, personnageManager, proprietaire);
					
					// Si c'est une arme perso
					if (proprietaire != PersoPrenom.GROUPE) {
						// On l'ajoute au sac du perso
						Map<Item, Integer> sacPerso = personnageManager.getPersoByPrenom(proprietaire).getSac();
						sacPerso.put(arme, 1);
						
					// Si c'est une arme de groupe
					} else {
						// On l'ajoute au sac du groupe
						leGroupe.ajouteItem(arme);
					}
					
				// Si c'est un item consommable, on l'ajoute au sac du groupe
				} else if (item.isConsommable()) {
					leGroupe.ajouteItem(item);
					
				// Si c'est un objet perso (pas arme pas sort) on l'ajoute au sac du proprietaire
				} else if (proprietaire != PersoPrenom.GROUPE && !item.getType().name().equals(ItemType.ACTION_COMBAT.name())) {
					Map<Item, Integer> sacPerso = personnageManager.getPersoByPrenom(proprietaire).getSac();
					sacPerso.put(item, 1);
				}
				
				// Si ce n'est pas l'arrivée d'un personnage ou le deblocage d'un sort, on lance la popup de gain de l'objet
				if (!item.getType().name().equals(ItemType.PERSONNAGE.name()) && !item.getType().name().equals(ItemType.ACTION_COMBAT.name())) {
					
					MusiqueManager.playSonItem("sonParDefaut/09-Zelda-small-item-catch.mp3");
					// TODO meilleur nom que ACTION_COMBAT
					JLabel labelMessage = new JLabel("Vous avez gagne : " + item.getNom());
					labelMessage.setFont(Constante.MARIO_FONT_MENU_3);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), labelMessage, "Nouvel objet ! (" + itemType + ")", type, resizedImage);
				}

			}
		}

		// TODO mieux (perso present pendant la mission) Distribution des bonus/malus
		Groupe leGroupe = personnageManager.getLeGroupe();
		if (win) {
			BonusManager.distribueBonus(leGroupe, mission.getGain());
			
			// TODO gestion du gain d'argent par type de mission, par difficulte, par stat(Luck), (par progression du jeu?) par tranche (entre 100 et 150) (variation de 50% aleatoire arrondi a un chiffre rond si >100 (730 et non 733)
			if (!mission.getMissionType().name().equals(MissionType.BOUTIQUE.name())) {
				BonusManager.distribueArgent(leGroupe, mission);
			}
			
		} else {
			BonusManager.distribueBonus(leGroupe, mission.getPerte());
		}

		// Si une mission a debloque un perso
		MainFrame.getPanelPersonnage().refreshArriveePersonnage();
	}

}

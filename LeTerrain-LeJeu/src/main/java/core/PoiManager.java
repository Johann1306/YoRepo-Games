package core;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.mission.Mission;
import modele.item.personnage.PersoPrenom;
import modele.item.poi.Poi;

public class PoiManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Poi> pois = null;
	private List<Poi> poisDisponible = null;
	private List<Poi> poisIndisponible = null;
	
	public void initialise(MissionManager missionManager) {

		// Chargement de tous les Pois
		
		pois = new ArrayList<Poi>();
		poisDisponible = new ArrayList<Poi>();
		poisIndisponible = new ArrayList<Poi>();
		
		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "sonParDefaut/photoBruit2.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
//		List<String> null = new ArrayList<String>();
		String videoPath1 = "video/Trololo.mp4";
//		null.add(videoPath1);
		
		// TODO faire toutes les missions
		List<Mission> missionsPoiClasse = new ArrayList<Mission>();
		List<Mission> missionsPoiCour = new ArrayList<Mission>();
		List<Mission> missionsPoiPreau = new ArrayList<Mission>();
		List<Mission> missionsPoiCantine = new ArrayList<Mission>();
		List<Mission> missionsPoiLecture = new ArrayList<Mission>();
		List<Mission> missionsPoi100 = new ArrayList<Mission>();
		List<Mission> missionsPoi101 = new ArrayList<Mission>();
		List<Mission> missionsPoi200 = new ArrayList<Mission>();
		List<Mission> missionsPoi201 = new ArrayList<Mission>();
		List<Mission> missionsPoi202 = new ArrayList<Mission>();
		List<Mission> missionsPoi203 = new ArrayList<Mission>();
		List<Mission> missionsPoi204 = new ArrayList<Mission>();
		List<Mission> missionsPoi205 = new ArrayList<Mission>();
		List<Mission> missionsPoi1000 = new ArrayList<Mission>();
		List<Mission> missionsPoi1001 = new ArrayList<Mission>();
		List<Mission> missionsPoi1002 = new ArrayList<Mission>();
		List<Mission> missionsPoi1003 = new ArrayList<Mission>();
		List<Mission> missionsPoi1100 = new ArrayList<Mission>();
		List<Mission> missionsPoi1101 = new ArrayList<Mission>();
		List<Mission> missionsPoi1200 = new ArrayList<Mission>();
		List<Mission> missionsPoi1201 = new ArrayList<Mission>();
		List<Mission> missionsPoi1202 = new ArrayList<Mission>();
		List<Mission> missionsPoi1300 = new ArrayList<Mission>();
		List<Mission> missionsPoi1301 = new ArrayList<Mission>();
		List<Mission> missionsPoi1302 = new ArrayList<Mission>();
		List<Mission> missionsPoi1303 = new ArrayList<Mission>();
		List<Mission> missionsPoi1400 = new ArrayList<Mission>();
		List<Mission> missionsPoi1401 = new ArrayList<Mission>();
		List<Mission> missionsPoi1402 = new ArrayList<Mission>();		
		List<Mission> missionsPoi1500 = new ArrayList<Mission>();
		List<Mission> missionsPoi1501 = new ArrayList<Mission>();
		List<Mission> missionsPoi1502 = new ArrayList<Mission>();
		List<Mission> missionsPoi1503 = new ArrayList<Mission>();
		List<Mission> missionsPoi1600 = new ArrayList<Mission>();
		List<Mission> missionsPoi1601 = new ArrayList<Mission>();
		List<Mission> missionsPoi1602 = new ArrayList<Mission>();
		List<Mission> missionsPoi1603 = new ArrayList<Mission>();

		List<Mission> missionsPoi2001 = new ArrayList<Mission>();
		List<Mission> missionsPoi2002 = new ArrayList<Mission>();
		List<Mission> missionsPoi2003 = new ArrayList<Mission>();
		List<Mission> missionsPoi2004 = new ArrayList<Mission>();
		List<Mission> missionsPoi2005 = new ArrayList<Mission>();
		List<Mission> missionsPoi2006 = new ArrayList<Mission>();
		List<Mission> missionsPoi2007 = new ArrayList<Mission>();
		List<Mission> missionsPoi2008 = new ArrayList<Mission>();

		// Ecole
		missionsPoiClasse.add(missionManager.getMissionById(101));
		missionsPoiClasse.add(missionManager.getMissionById(1011));
		missionsPoiCour.add(missionManager.getMissionById(102));
		missionsPoiCour.add(missionManager.getMissionById(606));
		missionsPoiCour.add(missionManager.getMissionById(1101));
		missionsPoiCour.add(missionManager.getMissionById(1105));
		missionsPoiCour.add(missionManager.getMissionById(1015));
		missionsPoiCour.add(missionManager.getMissionById(203));
		missionsPoiCour.add(missionManager.getMissionById(3001));
		missionsPoiPreau.add(missionManager.getMissionById(103));
		missionsPoiPreau.add(missionManager.getMissionById(1014));
		missionsPoiCantine.add(missionManager.getMissionById(104));
		missionsPoiCantine.add(missionManager.getMissionById(1012));
		missionsPoiLecture.add(missionManager.getMissionById(105));
		missionsPoiLecture.add(missionManager.getMissionById(1013));

		// Terrain
		missionsPoi100.add(missionManager.getMissionById(106));
		missionsPoi100.add(missionManager.getMissionById(107));
		missionsPoi100.add(missionManager.getMissionById(108));		
		missionsPoi100.add(missionManager.getMissionById(500));
		missionsPoi100.add(missionManager.getMissionById(999));
		missionsPoi100.add(missionManager.getMissionById(1000));
		missionsPoi100.add(missionManager.getMissionById(804));
		missionsPoi101.add(missionManager.getMissionById(402));
		missionsPoi101.add(missionManager.getMissionById(3002));
		missionsPoi101.add(missionManager.getMissionById(3003));
		missionsPoi101.add(missionManager.getMissionById(3004));
		missionsPoi101.add(missionManager.getMissionById(3005));
			
		// Yo
		missionsPoi200.add(missionManager.getMissionById(206));
		missionsPoi200.add(missionManager.getMissionById(1102));
		missionsPoi200.add(missionManager.getMissionById(1103));
		missionsPoi200.add(missionManager.getMissionById(1106));
		missionsPoi200.add(missionManager.getMissionById(1107));
		missionsPoi200.add(missionManager.getMissionById(1001));
		missionsPoi200.add(missionManager.getMissionById(3006));
		missionsPoi200.add(missionManager.getMissionById(3007));
		missionsPoi200.add(missionManager.getMissionById(3008));
		missionsPoi200.add(missionManager.getMissionById(3009));
		missionsPoi201.add(missionManager.getMissionById(200));
		missionsPoi201.add(missionManager.getMissionById(703));
		missionsPoi201.add(missionManager.getMissionById(1104));
		missionsPoi202.add(missionManager.getMissionById(504));
		missionsPoi203.add(missionManager.getMissionById(507));
		missionsPoi203.add(missionManager.getMissionById(900));
		missionsPoi204.add(missionManager.getMissionById(707));
		missionsPoi205.add(missionManager.getMissionById(1100));
		
		// Russ
		missionsPoi1000.add(missionManager.getMissionById(300));
		missionsPoi1000.add(missionManager.getMissionById(308));
		missionsPoi1000.add(missionManager.getMissionById(309));
		missionsPoi1001.add(missionManager.getMissionById(205));
		missionsPoi1001.add(missionManager.getMissionById(301));
		missionsPoi1001.add(missionManager.getMissionById(302));
		missionsPoi1001.add(missionManager.getMissionById(303));
		missionsPoi1001.add(missionManager.getMissionById(305));
		missionsPoi1001.add(missionManager.getMissionById(311));
		missionsPoi1001.add(missionManager.getMissionById(1008));
		missionsPoi1002.add(missionManager.getMissionById(306));
		missionsPoi1003.add(missionManager.getMissionById(304));
		missionsPoi1003.add(missionManager.getMissionById(307));
		missionsPoi1003.add(missionManager.getMissionById(310));
		
		// Guy
		missionsPoi1100.add(missionManager.getMissionById(400));
		missionsPoi1100.add(missionManager.getMissionById(401));
		missionsPoi1100.add(missionManager.getMissionById(405));
		missionsPoi1100.add(missionManager.getMissionById(407));
		missionsPoi1100.add(missionManager.getMissionById(408));
		missionsPoi1100.add(missionManager.getMissionById(1007));
		missionsPoi1101.add(missionManager.getMissionById(403));
		missionsPoi1101.add(missionManager.getMissionById(404));
		missionsPoi1101.add(missionManager.getMissionById(406));
		
		// Ali
		missionsPoi1200.add(missionManager.getMissionById(501));
		missionsPoi1200.add(missionManager.getMissionById(503));
		missionsPoi1200.add(missionManager.getMissionById(1006));
		missionsPoi1201.add(missionManager.getMissionById(502));
		missionsPoi1201.add(missionManager.getMissionById(505));
		missionsPoi1202.add(missionManager.getMissionById(508));
		
		// Ya
		missionsPoi1300.add(missionManager.getMissionById(701));
		missionsPoi1300.add(missionManager.getMissionById(706));
		missionsPoi1300.add(missionManager.getMissionById(708));
		missionsPoi1300.add(missionManager.getMissionById(1005));
		missionsPoi1301.add(missionManager.getMissionById(704));
		missionsPoi1301.add(missionManager.getMissionById(705));
		missionsPoi1302.add(missionManager.getMissionById(506));
		missionsPoi1303.add(missionManager.getMissionById(702));
		
		// Tom
		missionsPoi1400.add(missionManager.getMissionById(601));
		missionsPoi1400.add(missionManager.getMissionById(604));
		missionsPoi1400.add(missionManager.getMissionById(608));
		missionsPoi1400.add(missionManager.getMissionById(1004));
		missionsPoi1401.add(missionManager.getMissionById(602));
		missionsPoi1401.add(missionManager.getMissionById(605));
		missionsPoi1401.add(missionManager.getMissionById(607));
		missionsPoi1401.add(missionManager.getMissionById(700));
		missionsPoi1402.add(missionManager.getMissionById(600));
		missionsPoi1402.add(missionManager.getMissionById(603));
		
		// Pip
		missionsPoi1500.add(missionManager.getMissionById(802));
		missionsPoi1500.add(missionManager.getMissionById(805));
		missionsPoi1500.add(missionManager.getMissionById(806));
		missionsPoi1500.add(missionManager.getMissionById(1003));
		missionsPoi1501.add(missionManager.getMissionById(800));
		missionsPoi1501.add(missionManager.getMissionById(801));
		missionsPoi1503.add(missionManager.getMissionById(803));
		missionsPoi1503.add(missionManager.getMissionById(807));
		missionsPoi1503.add(missionManager.getMissionById(808));
		
		// Nico
		missionsPoi1600.add(missionManager.getMissionById(204));
		missionsPoi1600.add(missionManager.getMissionById(902));
		missionsPoi1600.add(missionManager.getMissionById(904));
		missionsPoi1600.add(missionManager.getMissionById(906));
		missionsPoi1600.add(missionManager.getMissionById(1002));
		missionsPoi1601.add(missionManager.getMissionById(901));
		missionsPoi1603.add(missionManager.getMissionById(903));
		missionsPoi1603.add(missionManager.getMissionById(905));
		missionsPoi1603.add(missionManager.getMissionById(907));
		missionsPoi1603.add(missionManager.getMissionById(908));
		missionsPoi1603.add(missionManager.getMissionById(1108));
		
		// Missions quizz anniversaire
		missionsPoi1601.add(missionManager.getMissionById(2001));
		missionsPoi1601.add(missionManager.getMissionById(2002));
		missionsPoi1601.add(missionManager.getMissionById(2003));
		missionsPoi1601.add(missionManager.getMissionById(2004));
		missionsPoi1601.add(missionManager.getMissionById(2005));
		missionsPoi1601.add(missionManager.getMissionById(2006));
		missionsPoi1601.add(missionManager.getMissionById(2007));
		missionsPoi1601.add(missionManager.getMissionById(2008));
		missionsPoi1601.add(missionManager.getMissionById(2009));
		missionsPoi1601.add(missionManager.getMissionById(2010));
		missionsPoi1601.add(missionManager.getMissionById(2011));
		
		missionsPoi1401.add(missionManager.getMissionById(2012));
		missionsPoi1401.add(missionManager.getMissionById(2013));
		missionsPoi1401.add(missionManager.getMissionById(2014));
		missionsPoi1401.add(missionManager.getMissionById(2015));
		missionsPoi1401.add(missionManager.getMissionById(2016));
		missionsPoi1401.add(missionManager.getMissionById(2017));
		missionsPoi1401.add(missionManager.getMissionById(2018));
		missionsPoi1401.add(missionManager.getMissionById(2019));
		missionsPoi1401.add(missionManager.getMissionById(2020));
		missionsPoi1401.add(missionManager.getMissionById(2021));
		missionsPoi1401.add(missionManager.getMissionById(2022));

		missionsPoi1301.add(missionManager.getMissionById(2023));
		missionsPoi1301.add(missionManager.getMissionById(2024));
		missionsPoi1301.add(missionManager.getMissionById(2025));
		missionsPoi1301.add(missionManager.getMissionById(2026));
		missionsPoi1301.add(missionManager.getMissionById(2027));
		missionsPoi1301.add(missionManager.getMissionById(2028));
		missionsPoi1301.add(missionManager.getMissionById(2029));
		missionsPoi1301.add(missionManager.getMissionById(2030));
		missionsPoi1301.add(missionManager.getMissionById(2031));
		missionsPoi1301.add(missionManager.getMissionById(2032));

		missionsPoi201.add(missionManager.getMissionById(2033));
		missionsPoi201.add(missionManager.getMissionById(2034));
		missionsPoi201.add(missionManager.getMissionById(2035));
		missionsPoi201.add(missionManager.getMissionById(2036));
		missionsPoi201.add(missionManager.getMissionById(2037));
		missionsPoi201.add(missionManager.getMissionById(2038));
		missionsPoi201.add(missionManager.getMissionById(2039));
		missionsPoi201.add(missionManager.getMissionById(2040));
		missionsPoi201.add(missionManager.getMissionById(2041));
		missionsPoi201.add(missionManager.getMissionById(2042));
		
		missionsPoi1501.add(missionManager.getMissionById(2043));
		missionsPoi1501.add(missionManager.getMissionById(2044));
		missionsPoi1501.add(missionManager.getMissionById(2045));
		missionsPoi1501.add(missionManager.getMissionById(2046));
		missionsPoi1501.add(missionManager.getMissionById(2047));
		missionsPoi1501.add(missionManager.getMissionById(2048));
		missionsPoi1501.add(missionManager.getMissionById(2049));
		missionsPoi1501.add(missionManager.getMissionById(2050));
		missionsPoi1501.add(missionManager.getMissionById(2051));
		missionsPoi1501.add(missionManager.getMissionById(2052));
		
		missionsPoi1201.add(missionManager.getMissionById(2053));
		missionsPoi1201.add(missionManager.getMissionById(2054));
		missionsPoi1201.add(missionManager.getMissionById(2055));
		missionsPoi1201.add(missionManager.getMissionById(2056));
		missionsPoi1201.add(missionManager.getMissionById(2057));
		
		missionsPoi1101.add(missionManager.getMissionById(2058));
		missionsPoi1101.add(missionManager.getMissionById(2059));
		missionsPoi1101.add(missionManager.getMissionById(2060));
		
		missionsPoi1000.add(missionManager.getMissionById(2061));
		missionsPoi1000.add(missionManager.getMissionById(2062));
		
		// Acheter/Vendre
		missionsPoi2001.add(missionManager.getMissionById(230));
		missionsPoi2003.add(missionManager.getMissionById(240));
		missionsPoi2005.add(missionManager.getMissionById(250));
		missionsPoi2007.add(missionManager.getMissionById(260));

		
		// (X,Y) en partant du haut-gauche
		// Pour une Map (2000 x 1000)
		// X (min= 0, max= 1800)
		// Y (min= 56, max= 980)
		Poi poiEcole1 = new Poi(1, "La salle de classe", "Avec une bonne odeur de pisse, de vomi et d'eau de javel", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, true, new Point(0, 250), missionsPoiClasse);
		Poi poiEcole2 = new Poi(2, "La cour de recreation", "Marelle, Balle au prisonnier, Foot, Mur d'escalade, Chenille et 3 arbres", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-150, 400), missionsPoiCour);
		Poi poiEcole3 = new Poi(3, "Le preau", "Partageons nos morbacs quand il pleut", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-400, 400), missionsPoiPreau);
		Poi poiEcole4 = new Poi(4, "La cantine", "Gober son Flamby pour flamber", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(300, 250), missionsPoiCantine);
		Poi poiEcole5 = new Poi(5, "La salle de lecture", "Et cric et crac ...", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-500, 470), missionsPoiLecture);
		
		Poi poiTerrain_Cabane = new Poi(100, "La cabane", "La cabane du terrain", imagePaths1, sonPaths1, null, PersoPrenom.GROUPE, true, new Point(200, 950), missionsPoi100);
		Poi poiTerrain_Terrain = new Poi(101, "Le terrain", "Le terrain de tennis du terrain", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-200, 300), missionsPoi101);

		Poi poiChezYo_Portail = new Poi(200, "Sortie", "Possibilite de passer par le balcon et le voisin", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 650), missionsPoi200);
		Poi poiChezYo_Salon = new Poi(201, "Salon", "Avec la possibilite de tourner en rond", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-150, 450), missionsPoi201);
		Poi poiChezYo_Garage = new Poi(202, "Garage", "Contient des chiottes jamais utilisees", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(130, 500), missionsPoi202);
		Poi poiChezYo_Chambre = new Poi(203, "Chambre", "Lit superpose, fenetre, radiateur et chaise roulante", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-150, 350), missionsPoi203);
		Poi poiChezYo_Jardin = new Poi(204, "Jardin", "Avec un angle de tir sur la fenetre des voisins", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(200, 250), missionsPoi204);
		Poi poiChezYo_SalleDeBain = new Poi(205, "Salle de bain", "Pour nudiste seulement", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(200, 400), missionsPoi205);

		Poi poiChezRuss_Salon = new Poi(1000, "Salon", "A rechauffer au chauffage electrique", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-300, 600), missionsPoi1000);
		Poi poiChezRuss_Portail = new Poi(1001, "Sortie", "Attention aux etrangers", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(100, 300), missionsPoi1001);
		Poi poiChezRuss_Jardin = new Poi(1002, "Jardin", "Attention aux chiens", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 600), missionsPoi1002);
		Poi poiChezRuss_SalleDeBain = new Poi(1003, "Salle de bain", "Salon de beaute", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-300, 800), missionsPoi1003);
		
		Poi poiChezGuy_Portail = new Poi(1100, "Sortie", "Rendez vous a la butte", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(100, 600), missionsPoi1100);
		Poi poiChezGuy_Salon = new Poi(1101, "Chambre", "Peux voir la chambre de Johann de sa chambre", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(200, 300), missionsPoi1101);

		Poi poiChezAli_Portail = new Poi(1200, "Sortie", "Ne pas reveiller les chiens en sortant en cachette", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 650), missionsPoi1200);
		Poi poiChezAli_Salon = new Poi(1201, "Salon", "Recouvert d'un mur de babioles", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 450), missionsPoi1201);
		Poi poiChezAli_Chambre = new Poi(1202, "Chambre", "La chambre froide", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-200, 450), missionsPoi1202);

		Poi poiChezYa_Portail = new Poi(1300, "Sortie", "Attention a Mme Menudier qui regarde pas sa fenetre", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 650), missionsPoi1300);
		Poi poiChezYa_Salon = new Poi(1301, "Salon", "Le lieu du premier contact du developpeur avec internet", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-70, 450), missionsPoi1301);
		Poi poiChezYa_Jardin = new Poi(1302, "Jardin", "Le seul panier de basket disponible", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(130, 250), missionsPoi1302);
		Poi poiChezYa_Chambre = new Poi(1303, "Chambre", "Hey, on pourrait sortir par la fenetre nan?", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(100, 400), missionsPoi1303);

		Poi poiChezTom_Portail = new Poi(1400, "Sortie", "Sortie la plus longue EVER", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(200, 700), missionsPoi1400);
		Poi poiChezTom_Salon = new Poi(1401, "Salon", "Fait egalement chambre, salle a manger et fumoir", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-150, 450), missionsPoi1401);
		Poi poiChezTom_Jardin = new Poi(1402, "Jardin", "Parfait pour une partie de Magic en plein air", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-300, 400), missionsPoi1402);
		
		Poi poiChezPip_Portail = new Poi(1500, "Sortie", "Ne pas oublier de se couvrir les extremites", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 600), missionsPoi1500);
		Poi poiChezPip_Salon = new Poi(1501, "Salon", "Un magnetoscope pour tous", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-50, 400), missionsPoi1501);
		Poi poiChezPip_Jardin = new Poi(1502, "Jardin", "Barbecue et oeufs pourris", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(100, 300), missionsPoi1502);
		Poi poiChezPip_Chambre = new Poi(1503, "Chambre", "Mezzanine en faux plafond a un etage et demi du rez de chaussee sureleve", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(-150, 280), missionsPoi1503);
		
		Poi poiChezNico_Portail = new Poi(1600, "Sortie", "Et laisses pas sortir le chien. C'est bien mon chien!", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(400, 540), missionsPoi1600);
		Poi poiChezNico_Salon = new Poi(1601, "Salon", "Le lieu ou repose le celebre Telefono", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(300, 340), missionsPoi1601);
		Poi poiChezNico_Jardin = new Poi(1602, "Jardin", "Avec une cabane dans l'arbre et une tyrolienne! ", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(235, 450), missionsPoi1602);
		Poi poiChezNico_Chambre = new Poi(1603, "Chambre", "Hey, on peut descendre en rappel par la fenetre nan?", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(250, 240), missionsPoi1603);
		
		Poi poiAchatMiranda = new Poi(2001, "Entrer", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 600), missionsPoi2001);
//		Poi poiVenteMiranda = new Poi(2002, "Autres Deals", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 300), missionsPoi2002);
		Poi poiAchatTonelle = new Poi(2003, "Entrer", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 600), missionsPoi2003);
//		Poi poiVenteTonelle = new Poi(2004, "Autres Deals", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 300), missionsPoi2004);
		Poi poiAchatDahlias = new Poi(2005, "Entrer", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(450, 600), missionsPoi2005);
//		Poi poiVenteDahlias = new Poi(2006, "Autres Deals", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi2006);
		Poi poiAchatBosquets = new Poi(2007, "Entrer", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 600), missionsPoi2007);
//		Poi poiVenteBosquets = new Poi(2008, "Autres Deals", "info", imagePaths2, null, null, PersoPrenom.GROUPE, true, new Point(0, 300), missionsPoi2008);

		pois.add(poiChezRuss_Portail);
		pois.add(poiChezRuss_Salon);
		pois.add(poiChezRuss_Jardin);
		pois.add(poiChezRuss_SalleDeBain);

		pois.add(poiChezGuy_Portail);
		pois.add(poiChezGuy_Salon);
		
		pois.add(poiChezAli_Portail);
		pois.add(poiChezAli_Salon);
		pois.add(poiChezAli_Chambre);
		
		pois.add(poiChezYo_Portail);
		pois.add(poiChezYo_Salon);
		pois.add(poiChezYo_Garage);
		pois.add(poiChezYo_Chambre);
		pois.add(poiChezYo_Jardin);
		pois.add(poiChezYo_SalleDeBain);
		
		pois.add(poiChezYa_Portail);
		pois.add(poiChezYa_Salon);
		pois.add(poiChezYa_Jardin);
		pois.add(poiChezYa_Chambre);

		pois.add(poiChezTom_Portail);
		pois.add(poiChezTom_Salon);
		pois.add(poiChezTom_Jardin);

		pois.add(poiChezPip_Portail);
		pois.add(poiChezPip_Salon);
		pois.add(poiChezPip_Jardin);
		pois.add(poiChezPip_Chambre);

		pois.add(poiChezNico_Portail);
		pois.add(poiChezNico_Salon);
		pois.add(poiChezNico_Jardin);
		pois.add(poiChezNico_Chambre);
		
		pois.add(poiEcole1);
		pois.add(poiEcole2);
		pois.add(poiEcole3);
		pois.add(poiEcole4);
		pois.add(poiEcole5);
		pois.add(poiTerrain_Cabane);
		pois.add(poiTerrain_Terrain);
		
		pois.add(poiAchatMiranda);
		pois.add(poiAchatTonelle);
		pois.add(poiAchatDahlias);
		pois.add(poiAchatBosquets);

		// TODO ou pas (Autre deals)
//		pois.add(poiVenteMiranda);
//		pois.add(poiVenteTonelle);
//		pois.add(poiVenteDahlias);
//		pois.add(poiVenteBosquets);
		
		// On suppose que tous les pois sont indisponibles au depart
		poisIndisponible.addAll(pois);
		// sinon refresh
		// refreshPoisDisponible();
	}

	public List<Poi> getPois() {
		return pois;
	}

	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}

	public List<Poi> getPoisDisponible() {
		refreshPois();
		return poisDisponible;
	}

	public List<Poi> getPoisIndisponible() {
		refreshPois();
		return poisIndisponible;
	}

	private void refreshPois() {
		List<Poi> poisTemp = new ArrayList<>(poisIndisponible);
		for (Poi poi : poisTemp) {
			if (poi.isDisponible()) {
				poisDisponible.add(poi);
				poisIndisponible.remove(poi);
			}
		}
	}

	public Poi getPoisByNom(String nom) {
		for (Poi poi : pois) {
			if (poi.getNom().equals(nom)) {
				return poi;
			}
		}		
		return null;
	}
	
	public Poi getPoisById(int id) {
		for (Poi poi : pois) {
			if (poi.getId() == id) {
				return poi;
			}
		}		
		return null;
	}
	
}

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
		
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		// TODO faire toutes les missions
		List<Mission> allMissions = missionManager.getAllMissions();
		List<Mission> missionsPoiClasse = new ArrayList<Mission>();
		List<Mission> missionsPoiCour = new ArrayList<Mission>();
		List<Mission> missionsPoiPreau = new ArrayList<Mission>();
		List<Mission> missionsPoiCantine = new ArrayList<Mission>();
		List<Mission> missionsPoiLecture = new ArrayList<Mission>();
		List<Mission> missionsPoi6 = new ArrayList<Mission>();
		List<Mission> missionsPoi7 = new ArrayList<Mission>();
		List<Mission> missionsPoi8 = new ArrayList<Mission>();
		List<Mission> missionsPoi100 = new ArrayList<Mission>();
		List<Mission> missionsPoi101 = new ArrayList<Mission>();
		List<Mission> missionsPoi200 = new ArrayList<Mission>();
		List<Mission> missionsPoi201 = new ArrayList<Mission>();
		List<Mission> missionsPoi202 = new ArrayList<Mission>();
		List<Mission> missionsPoi203 = new ArrayList<Mission>();
		List<Mission> missionsPoi1000 = new ArrayList<Mission>();
		List<Mission> missionsPoi1001 = new ArrayList<Mission>();
		List<Mission> missionsPoi1002 = new ArrayList<Mission>();
		List<Mission> missionsPoi1003 = new ArrayList<Mission>();
		List<Mission> missionsPoi1100 = new ArrayList<Mission>();
		List<Mission> missionsPoi1101 = new ArrayList<Mission>();
		List<Mission> missionsPoi1200 = new ArrayList<Mission>();
		List<Mission> missionsPoi1201 = new ArrayList<Mission>();
		List<Mission> missionsPoi1300 = new ArrayList<Mission>();
		List<Mission> missionsPoi1301 = new ArrayList<Mission>();
		List<Mission> missionsPoi1302 = new ArrayList<Mission>();
		List<Mission> missionsPoi1400 = new ArrayList<Mission>();
		List<Mission> missionsPoi1401 = new ArrayList<Mission>();
		List<Mission> missionsPoi1402 = new ArrayList<Mission>();		
		// Ecole
		missionsPoiClasse.add(missionManager.getMissionById(101));
		missionsPoiCour.add(missionManager.getMissionById(102));
		missionsPoiCour.add(missionManager.getMissionById(606));
		missionsPoiPreau.add(missionManager.getMissionById(103));
		missionsPoiCantine.add(missionManager.getMissionById(104));
		missionsPoiLecture.add(missionManager.getMissionById(105));

		// Terrain
		missionsPoi100.add(missionManager.getMissionById(201));
		missionsPoi100.add(missionManager.getMissionById(106));
		missionsPoi100.add(missionManager.getMissionById(107));
		missionsPoi100.add(missionManager.getMissionById(108));		
		missionsPoi100.add(missionManager.getMissionById(500));
		missionsPoi100.add(missionManager.getMissionById(1000));
		missionsPoi101.add(missionManager.getMissionById(402));
			missionsPoi101.add(missionManager.getMissionById(202));
			
		// Yo
		missionsPoi201.add(missionManager.getMissionById(200));
		missionsPoi202.add(missionManager.getMissionById(504));
		missionsPoi203.add(missionManager.getMissionById(507));
		
		// Russ
		missionsPoi1000.add(missionManager.getMissionById(300));
		missionsPoi1000.add(missionManager.getMissionById(308));
		missionsPoi1000.add(missionManager.getMissionById(309));
		missionsPoi1001.add(missionManager.getMissionById(301));
		missionsPoi1001.add(missionManager.getMissionById(302));
		missionsPoi1001.add(missionManager.getMissionById(303));
		missionsPoi1001.add(missionManager.getMissionById(305));
		missionsPoi1002.add(missionManager.getMissionById(306));
		missionsPoi1003.add(missionManager.getMissionById(304));
		missionsPoi1003.add(missionManager.getMissionById(307));
		missionsPoi1003.add(missionManager.getMissionById(310));
		
		// Guy
		missionsPoi1100.add(missionManager.getMissionById(400));
		missionsPoi1100.add(missionManager.getMissionById(401));
		missionsPoi1100.add(missionManager.getMissionById(405));
		missionsPoi1100.add(missionManager.getMissionById(407));
		missionsPoi1101.add(missionManager.getMissionById(403));
		missionsPoi1101.add(missionManager.getMissionById(404));
		missionsPoi1101.add(missionManager.getMissionById(406));
		
		// Ali
		missionsPoi1200.add(missionManager.getMissionById(501));
		missionsPoi1200.add(missionManager.getMissionById(503));
		missionsPoi1201.add(missionManager.getMissionById(502));
		missionsPoi1201.add(missionManager.getMissionById(505));
		
		// Ya
		missionsPoi1302.add(missionManager.getMissionById(506));
		
		// Tom
		missionsPoi1400.add(missionManager.getMissionById(601));
		missionsPoi1400.add(missionManager.getMissionById(604));
		missionsPoi1401.add(missionManager.getMissionById(602));
		missionsPoi1401.add(missionManager.getMissionById(605));
		missionsPoi1401.add(missionManager.getMissionById(607));
		missionsPoi1402.add(missionManager.getMissionById(600));
		missionsPoi1402.add(missionManager.getMissionById(603));
		
		// (X,Y) en partant du haut-gauche
		// Pour une Map (2000 x 1000)
		// X (min= 0, max= 1800)
		// Y (min= 56, max= 980)
		Poi poiEcole1 = new Poi(1, "Classe", "info", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, true, new Point(200, 200), missionsPoiClasse);
		Poi poiEcole2 = new Poi(2, "Cour", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoiCour);
		Poi poiEcole3 = new Poi(3, "Préau", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 250), missionsPoiPreau);
		Poi poiEcole4 = new Poi(4, "Cantine", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(300, 200), missionsPoiCantine);
		Poi poiEcole5 = new Poi(5, "Salle de lecture", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 300), missionsPoiLecture);
		
		Poi poiTerrain_Cabane = new Poi(100, "La cabane", "La cabane du terrain", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, true, new Point(200, 200), missionsPoi100);
		Poi poiTerrain_Terrain = new Poi(101, "Le terrain", "Le terrain de tennis du terrain", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi101);

		Poi poiChezYo_Portail = new Poi(200, "Portail", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi200);
		Poi poiChezYo_Salon = new Poi(201, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 200), missionsPoi201);
		Poi poiChezYo_Garage = new Poi(202, "Garage", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 300), missionsPoi202);
		Poi poiChezYo_Chambre = new Poi(203, "Chambre", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 450), missionsPoi203);

		Poi poiChezRuss_Salon = new Poi(1000, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi1000);
		Poi poiChezRuss_Portail = new Poi(1001, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi1001);
		Poi poiChezRuss_Jardin = new Poi(1002, "Jardin", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 300), missionsPoi1002);
		Poi poiChezRuss_SalleDeBain = new Poi(1003, "Salle de bain", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 500), missionsPoi1003);
		
		Poi poiChezGuy_Portail = new Poi(1100, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi1100);
		Poi poiChezGuy_Salon = new Poi(1101, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 500), missionsPoi1101);

		Poi poiChezAli_Portail = new Poi(1200, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi1200);
		Poi poiChezAli_Salon = new Poi(1201, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 500), missionsPoi1201);

		Poi poiChezYa_Portail = new Poi(1300, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi1300);
		Poi poiChezYa_Salon = new Poi(1301, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 500), missionsPoi1301);
		Poi poiChezYa_Jardin = new Poi(1302, "Jardin", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 300), missionsPoi1302);

		Poi poiChezTom_Portail = new Poi(1400, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi1400);
		Poi poiChezTom_Salon = new Poi(1401, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 500), missionsPoi1401);
		Poi poiChezTom_Jardin = new Poi(1402, "Jardin", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 300), missionsPoi1402);
		
		pois.add(poiChezRuss_Portail);
		pois.add(poiChezRuss_Salon);
		pois.add(poiChezRuss_Jardin);
		pois.add(poiChezRuss_SalleDeBain);

		pois.add(poiChezGuy_Portail);
		pois.add(poiChezGuy_Salon);
		
		pois.add(poiChezAli_Portail);
		pois.add(poiChezAli_Salon);
		
		pois.add(poiChezYo_Portail);
		pois.add(poiChezYo_Salon);
		pois.add(poiChezYo_Garage);
		pois.add(poiChezYo_Chambre);

		pois.add(poiChezYa_Portail);
		pois.add(poiChezYa_Salon);
		pois.add(poiChezYa_Jardin);

		pois.add(poiChezTom_Portail);
		pois.add(poiChezTom_Salon);
		pois.add(poiChezTom_Jardin);

		pois.add(poiEcole1);
		pois.add(poiEcole2);
		pois.add(poiEcole3);
		pois.add(poiEcole4);
		pois.add(poiEcole5);
		pois.add(poiTerrain_Cabane);
		pois.add(poiTerrain_Terrain);
		
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

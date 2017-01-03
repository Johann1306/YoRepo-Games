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
		
		// TODO
		List<Mission> allMissions = missionManager.getAllMissions();
		List<Mission> missionsPoi1 = new ArrayList<Mission>();
		List<Mission> missionsPoi2 = new ArrayList<Mission>();
		List<Mission> missionsPoi3 = new ArrayList<Mission>();
		List<Mission> missionsPoi4 = new ArrayList<Mission>();
		List<Mission> missionsPoi5 = new ArrayList<Mission>();
		List<Mission> missionsPoi6 = new ArrayList<Mission>();
		List<Mission> missionsPoi7 = new ArrayList<Mission>();
		List<Mission> missionsPoi8 = new ArrayList<Mission>();
		List<Mission> missionsPoi100 = new ArrayList<Mission>();
		List<Mission> missionsPoi101 = new ArrayList<Mission>();
		List<Mission> missionsPoi201 = new ArrayList<Mission>();
		List<Mission> missionsPoi1000 = new ArrayList<Mission>();
		List<Mission> missionsPoi1001 = new ArrayList<Mission>();
		List<Mission> missionsPoi1002 = new ArrayList<Mission>();
		List<Mission> missionsPoi1003 = new ArrayList<Mission>();

		Mission mission101 = missionManager.getMissionById(101);		
		Mission mission102 = missionManager.getMissionById(102);		
		Mission mission103 = missionManager.getMissionById(103);		
		Mission mission104 = missionManager.getMissionById(104);		
		Mission mission105 = missionManager.getMissionById(105);		
		Mission mission106 = missionManager.getMissionById(106);		
		Mission mission107 = missionManager.getMissionById(107);		
		Mission mission108 = missionManager.getMissionById(108);		
		Mission mission200 = missionManager.getMissionById(200);		
		Mission mission201 = missionManager.getMissionById(201);		
		Mission mission202 = missionManager.getMissionById(202);		
		Mission mission1000 = missionManager.getMissionById(1000);		
		
		missionsPoi1.add(mission101);
		missionsPoi2.add(mission102);
		missionsPoi3.add(mission103);
		missionsPoi4.add(mission104);
		missionsPoi5.add(mission105);

		missionsPoi100.add(mission201);
		missionsPoi100.add(mission106);
		missionsPoi100.add(mission107);
		missionsPoi100.add(mission108);		
		missionsPoi100.add(mission1000);
		missionsPoi101.add(mission202);
		missionsPoi201.add(mission200);
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
		
		Poi poiEcole1 = new Poi(1, "Classe", "info", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, true, new Point(200, 200), missionsPoi1);
		Poi poiEcole2 = new Poi(2, "Cour", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi2);
		Poi poiEcole3 = new Poi(3, "Préau", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 250), missionsPoi3);
		Poi poiEcole4 = new Poi(4, "Cantine", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(300, 200), missionsPoi4);
		Poi poiEcole5 = new Poi(5, "Salle de lecture", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 300), missionsPoi5);
		
		Poi poiChezYo_Portail = new Poi(201, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi201);

		Poi poiChezRuss_Salon = new Poi(1000, "Salon", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi1000);
		Poi poiChezRuss_Portail = new Poi(1001, "Sortie", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(450, 300), missionsPoi1001);
		Poi poiChezRuss_Jardin = new Poi(1002, "Jardin", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 300), missionsPoi1002);
		Poi poiChezRuss_SalleDeBain = new Poi(1003, "Salle de bain", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(650, 500), missionsPoi1003);
		

		Poi poiTerrain1 = new Poi(100, "poiTerrain1", "info", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, true, new Point(200, 200), missionsPoi100);
		Poi poiTerrain2 = new Poi(101, "poiTerrain2", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(250, 200), missionsPoi101);

		pois.add(poiChezRuss_Salon);
		pois.add(poiChezRuss_Portail);
		pois.add(poiChezRuss_Jardin);
		pois.add(poiChezRuss_SalleDeBain);

		pois.add(poiEcole1);
		pois.add(poiEcole2);
		pois.add(poiEcole3);
		pois.add(poiEcole4);
		pois.add(poiEcole5);
		pois.add(poiChezYo_Portail);
		pois.add(poiTerrain1);
		pois.add(poiTerrain2);
		
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

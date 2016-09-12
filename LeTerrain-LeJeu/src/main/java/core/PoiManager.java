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
	private int id = 0;
	
	public void initialise(MissionManager missionManager) {

		// Chargement de tous les Pois
		
		pois = new ArrayList<Poi>();
		poisDisponible = new ArrayList<Poi>();
		poisIndisponible = new ArrayList<Poi>();
		
		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "src/main/resources/image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "src/main/resources/image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "src/main/resources/sonParDefaut/photoBruit2.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "src/main/resources/sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		// TODO
		List<Mission> allMissions = missionManager.getAllMissions();
		
		Poi poi1 = new Poi(incrementeId(), "poi1", "info", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, true, new Point(200, 200), allMissions);
		Poi poi2 = new Poi(incrementeId(), "poi2", "info", imagePaths2, null, videoPaths1, PersoPrenom.GROUPE, true, new Point(50, 200), allMissions);
		Poi poi3 = new Poi(incrementeId(), "poi3", "info", imagePaths1, sonPaths2, null, PersoPrenom.GROUPE, true, new Point(200, 50), allMissions);
		
		pois.add(poi1);
		pois.add(poi2);
		pois.add(poi3);
		
		// On suppose que tous les pois sont indisponibles au depart
		poisIndisponible.addAll(pois);
		// sinon refresh
		// refreshPoisDisponible();
	}

	private int incrementeId() {
		id = id +1;
		return id;
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
	
}

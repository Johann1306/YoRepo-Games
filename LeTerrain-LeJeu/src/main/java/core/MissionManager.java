package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modele.bonus.Bonus;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionDifficulty;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.PersoNom;

public class MissionManager implements Serializable  {

	private static final long serialVersionUID = 1L;
	private static List<Mission> missions;
	private static List<Mission> missionsDisponibles;
	private static List<Mission> missionsIndisponibles;
	private static int id = 0;

	public void initialise() {

		missions = new ArrayList<>();
		missionsDisponibles = new ArrayList<>();
		missionsIndisponibles = new ArrayList<>();

		// Chargement des missions

		List<String> imagePaths1 = new ArrayList<>();
		String imagePath1 = "src/main/resources/image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<>();
		String imagePath2 = "src/main/resources/image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> imagePaths3 = new ArrayList<>();
		String imagePath3 = "src/main/resources/image/mp3Player/back.png";
		imagePaths3.add(imagePath3);

		List<String> sonPaths1 = new ArrayList<>();
		String sonPath1 = "src/main/resources/sonParDefaut/photoBruit2.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<>();
		String sonPath2 = "src/main/resources/sonParDefaut/08-Zelda-mission-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<>();
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		Date date1 = DateManager.genereUneDate(1990, 9, 3, 11, 00, 00);
		Date dateVide = null;

		Mission mission1 = new Mission(incrementId(), "mission1", "info1", imagePaths1, sonPaths1, videoPaths1, PersoNom.JOHANN, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, date1, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission2 = new Mission(incrementId(), "mission2", "info2", imagePaths2, sonPaths2, videoPaths1, PersoNom.NICOLAS, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission3 = new Mission(incrementId(), "mission3", "info3", imagePaths3, sonPaths1, videoPaths1, PersoNom.THOMAS, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission4 = new Mission(incrementId(), "mission4", "info4", imagePaths2, sonPaths2, videoPaths1, PersoNom.YANNICK, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission5 = new Mission(incrementId(), "mission5", "info3", imagePaths1, sonPaths1, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission6 = new Mission(incrementId(), "mission6", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission7 = new Mission(incrementId(), "mission7", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission8 = new Mission(incrementId(), "mission8", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), false);
		Mission mission9 = new Mission(incrementId(), "mission9", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE,  70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		Mission mission10 = new Mission(incrementId(), "mission10", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		Mission mission11 = new Mission(incrementId(), "mission11", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		Mission mission12 = new Mission(incrementId(), "mission12", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		Mission mission13 = new Mission(incrementId(), "mission13", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, 70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		Mission mission14 = new Mission(incrementId(), "mission14", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE,  70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		Mission mission15 = new Mission(incrementId(), "mission15", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE,  70, "", "", "objectif1", new Bonus(), new Bonus(), 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), true);
		
		// Ajout a la liste
		missions.add(mission1);
		missions.add(mission2);
		missions.add(mission3);
		missions.add(mission4);
		missions.add(mission5);
		missions.add(mission6);
		missions.add(mission7);
		missions.add(mission8);
		missions.add(mission9);
		missions.add(mission10);
		missions.add(mission11);
		missions.add(mission12);
		missions.add(mission13);
		missions.add(mission14);
		missions.add(mission15);

		// Refresh Listes
		triMissions();
	}

	public static List<Mission> getAllMissions() {
		return missions;
	}

	public static Mission getMissionByNom(String nom) {
		for (Mission mission : missions) {
			if (mission.getNom().equals(nom)) {
				return mission;
			}
		}
		return null;
	}

	
	public static List<Mission> getMissionsByPerso(PersoNom nomPerso) {
		List<Mission> missionPerso = new ArrayList<>();
		for (Mission mission : missions) {
			if (mission.getProprietaire().equals(nomPerso) && mission.isDisponible()) {
				missionPerso.add(mission);
			}
		}
		return missionPerso;
	}

	public static List<Mission> getMissionsDisponibles() {
		refreshMissions();
		return missionsDisponibles;
	}

	public static List<Mission> getMissionsIndisponibles() {
		refreshMissions();
		return missionsIndisponibles;
	}

	private static void triMissions() {
		for (Mission mission : missions) {
			if (mission.isDisponible()) {
				missionsDisponibles.add(mission);
			} else {
				missionsIndisponibles.add(mission);
			}
		}
	}

	private static void refreshMissions() {
		List<Mission> indispoTemp = new ArrayList<>(missionsIndisponibles);
		for (Mission mission : indispoTemp) {
			if (mission.isDisponible()) {
				// Refresh
				missionsDisponibles.add(mission);
				missionsIndisponibles.remove(mission);
			}
		}
	}
	
	private static int incrementId() {
		id = id +1;
		return id;
	}
}

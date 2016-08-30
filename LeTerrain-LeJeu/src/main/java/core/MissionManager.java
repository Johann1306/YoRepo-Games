package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modele.bonus.Bonus;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionDifficulty;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;

public class MissionManager implements Serializable  {

	private static final long serialVersionUID = 1L;
	private static List<Mission> missions;
	private static List<Mission> missionsDisponibles;
	private static List<Mission> missionsIndisponibles;
	private static int id = 0;

	public void initialise() {

		missions = new ArrayList<Mission>();
		missionsDisponibles = new ArrayList<Mission>();
		missionsIndisponibles = new ArrayList<Mission>();

		// Chargement des missions

		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "src/main/resources/image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "src/main/resources/image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> imagePaths3 = new ArrayList<String>();
		String imagePath3 = "src/main/resources/image/mp3Player/back.png";
		imagePaths3.add(imagePath3);

		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "src/main/resources/sonParDefaut/photoBruit2.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "src/main/resources/sonParDefaut/08-Zelda-mission-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 11, 00, 00);
		Date dateVide = null;
		
		List<Bonus> bonus = BonusManager.getAllBonus();
		Bonus bonusVide = bonus.get(0);
		Bonus bonus1 = bonus.get(1);
		Bonus malus1 = bonus.get(2);
		
		Mission mission1 = new Mission(incrementId(), "Premier Perso", "Selectionner un Personnage principal", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "Choisir votre premier Personnage", bonus1, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission2 = new Mission(incrementId(), "mission2", "info2", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.NICOLAS, new Lieu(), 70, "", "", "objectif1", bonusVide, malus1, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission3 = new Mission(incrementId(), "mission3", "info3", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.THOMAS, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission4 = new Mission(incrementId(), "mission4", "info4", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.YANNICK, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission5 = new Mission(incrementId(), "mission5", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission6 = new Mission(incrementId(), "mission6", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission7 = new Mission(incrementId(), "mission7", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission8 = new Mission(incrementId(), "mission8", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission9 = new Mission(incrementId(), "mission9", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(),  70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission10 = new Mission(incrementId(), "mission10", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission11 = new Mission(incrementId(), "mission11", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission12 = new Mission(incrementId(), "mission12", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission13 = new Mission(incrementId(), "mission13", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission14 = new Mission(incrementId(), "mission14", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(),  70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission15 = new Mission(incrementId(), "mission15", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(),  70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateVide, MissionType.MINIJEU, MissionDifficulty.NORMAL, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		
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

	public static Mission getMissionById(int id) {
		for (Mission mission : missions) {
			if (mission.getId() == id) {
				return mission;
			}
		}
		return null;
	}
	
	public static Mission getMissionByNom(String nom) {
		for (Mission mission : missions) {
			if (mission.getNom().equals(nom)) {
				return mission;
			}
		}
		return null;
	}
	
	public static List<Mission> getMissionsByPerso(PersoPrenom nomPerso) {
		List<Mission> missionPerso = new ArrayList<Mission>();
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
		List<Mission> indispoTemp = new ArrayList<Mission>(missionsIndisponibles);
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

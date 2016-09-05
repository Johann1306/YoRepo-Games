package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import front.MainFrame;
import front.MenuPrincipal;
import front.PanelPersonnage;
import modele.bonus.Bonus;
import modele.item.Item;
import modele.item.lieu.Lieu;
import modele.item.mission.Mission;
import modele.item.mission.enums.MissionDifficulty;
import modele.item.mission.enums.MissionType;
import modele.item.personnage.Groupe;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.personnage.PersonnageSecondaire;
import modele.jeu.Jeu;

public class MissionManager implements Serializable  {

	private static final long serialVersionUID = 1L;
	private List<Mission> missions;
	private List<Mission> missionsDisponibles;
	private List<Mission> missionsIndisponibles;
	private List<Mission> missionsJouables;
	private List<Mission> missionsTerminees;
	private static int id = 0;

	public void initialise() {

		missions = new ArrayList<Mission>();
		missionsDisponibles = new ArrayList<Mission>();
		missionsIndisponibles = new ArrayList<Mission>();
		missionsJouables = new ArrayList<Mission>();
		missionsTerminees = new ArrayList<Mission>();
		
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
		String sonPath2 = "src/main/resources/sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 11, 00, 00);
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 17, 00, 00);
		Date dateNull = null;
		
		List<Bonus> bonus = BonusManager.getAllBonus();
		Bonus bonusVide = bonus.get(0);
		Bonus bonus1 = bonus.get(1);
		Bonus malus1 = bonus.get(2);
		
		List<NomJeu> jeux = new ArrayList<NomJeu>();
		jeux.add(NomJeu.JEU_RANDOM);
		jeux.add(NomJeu.JEU_RANDOM);
		jeux.add(NomJeu.JEU_RANDOM);
		
//		Mission m1 = new Mission(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, lieu, chanceVictoire, conditionVictoire, conditionDefaite, objectif, gain, perte, gainMax, perteMax, date, type, difficulty, personnagesRequis, personnagesInterdits, personnagesSecondaires, itemsNecessaires, itemsDebloques, isRepetable)
		Mission mission1 = new Mission(incrementId(), "Premier Perso", "Selectionne ton personnage principal :", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "Choisir votre premier Personnage", bonus1, bonusVide, 1, 1, date1, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission2 = new Mission(incrementId(), "mission2", "info2", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.NICOLAS, new Lieu(), 70, "", "", "objectif1", bonusVide, malus1, 1, 1, date2, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission3 = new Mission(incrementId(), "mission3", "info3", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.THOMAS, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission4 = new Mission(incrementId(), "mission4", "info4", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.YANNICK, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission5 = new Mission(incrementId(), "mission5", "info3", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission6 = new Mission(incrementId(), "mission6", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission7 = new Mission(incrementId(), "mission7", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission8 = new Mission(incrementId(), "mission8", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.PRINCIPAL, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), false);
		Mission mission9 = new Mission(incrementId(), "mission9", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(),  70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission10 = new Mission(incrementId(), "mission10", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission11 = new Mission(incrementId(), "mission11", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission12 = new Mission(incrementId(), "mission12", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission13 = new Mission(incrementId(), "mission13", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(), 70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission14 = new Mission(incrementId(), "mission14", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(),  70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		Mission mission15 = new Mission(incrementId(), "mission15", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, new Lieu(),  70, "", "", "objectif1", bonusVide, bonusVide, 1, 1, dateNull, MissionType.MINIJEU, MissionDifficulty.NORMAL, jeux, new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnagePrincipal>(), new ArrayList<PersonnageSecondaire>(), new ArrayList<Item>(), new ArrayList<Item>(), true);
		
		// Ajout a la liste
		missions.add(mission1);
		missions.add(mission2);
		missions.add(mission3);
		missions.add(mission4);
		missions.add(mission5);
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
					image = new ImageIcon("src/main/resources/image/defaut/defautMission.png");
				}
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), mission.getInformations() + "/nMission debloquée pour " + mission.getProprietaire().name(), mission.getNom(), type, image);
			
				refreshMissions();
			}
		}
	}
	
	public void lanceMission(Mission mission) {
		// Choix aleatoire du jeu
		List<NomJeu> jeux = mission.getJeux();
		Jeu randomJeu = RandomManager.getRandomJeu(jeux);
		
		// Lancement du jeu
		boolean win = JeuManager.lanceJeu(randomJeu, mission);
		
		// Gestion des recompenses et stats missions
		
		// Si win
		if (win) {
			mission.setDejaFaite(true);
			// Message mission win
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), mission.getInformations() + "/nMission réussie!", mission.getNom(), 0, new ImageIcon(mission.getImagePaths().get(0)));
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
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), mission.getInformations() + "/nMission échouée!", mission.getNom(), 1, new ImageIcon(mission.getImagePaths().get(0)));
			mission.setNombreEssai(mission.getNombreEssai()+1);
			distribueRecompenses(mission, false);
		}
		// refresh liste missions jouables par perso
		refreshMissionsJouables();
		MenuPrincipal.getMainFrame().getCoreManager().getMenuManager().lanceRefreshMenu();
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
		if (mission.getType().equals(MissionType.PRINCIPAL)) {
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
	
	private static int incrementId() {
		id = id +1;
		return id;
	}
	
	private void distribueRecompenses(Mission mission, boolean win) {
		// Debloquer les items a debloquer 
		List<Item> itemsDebloques = mission.getItemsDebloques();
		for (Item item : itemsDebloques) {
		
			int type = MenuPrincipal.getMainFrame().getCoreManager().getItemManager().getTypeItem(item);

			// TODO get(0)
			// Lancer le son ou la musique associe a l item
			MusiqueManager.playSonItem(item.getSonPath().get(0));
					
			// Lancer la video associe a l item
			VideoManager.play(item.getVideoPaths().get(0));
					
			// Afficher JDialog pour l item
			ImageIcon itemImage = new ImageIcon(item.getImagePath().get(0));
			if (itemImage.getIconWidth() == -1) {
				itemImage = new ImageIcon("src/main/resources/image/defaut/defautItem.png");
			}
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), item.getInformations(), item.getNom(), type, itemImage);
			item.setDisponible(true);
		}	
					
		// Distribution des bonus/malus
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		if (win) {
			BonusManager.distribueBonus(leGroupe, mission.getGain());
		} else {
			BonusManager.distribueBonus(leGroupe, mission.getPerte());
		}

		// Si un evenement a debloque un perso
		PanelPersonnage.refreshArriveePersonnage();
	}

}

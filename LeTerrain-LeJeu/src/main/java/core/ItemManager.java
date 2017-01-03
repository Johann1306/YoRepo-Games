package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoPrenom;

public class ItemManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Item> items;
	private List<Item> itemsDisponibles;
	private List<Item> itemsIndisponibles;
	private int id = 0;

	public void initialise() {

		items = new ArrayList<Item>();
		itemsDisponibles = new ArrayList<Item>();
		itemsIndisponibles = new ArrayList<Item>();

		// Chargement des items
		
		// Images
		List<String> imagePathsPopoVie = new ArrayList<String>();
		String imagePathPopoVie = "image/item/consommable/popoVie.jpg";
		imagePathsPopoVie.add(imagePathPopoVie);

		List<String> imagePathsPopoMana = new ArrayList<String>();
		String imagePathPopoMana = "image/item/consommable/popoMana.jpg";
		imagePathsPopoMana.add(imagePathPopoMana);
		
		List<String> imagePathsBonus = new ArrayList<String>();
		String imagePathBonus = "image/item/consommable/popoBonus.jpg";
		imagePathsBonus.add(imagePathBonus);
		
		
		List<String> imagePathsdiehard3VHS = new ArrayList<String>();
		String imagePathVHS = "image/film/diehard3_VHS.jpg";
		imagePathsdiehard3VHS.add(imagePathVHS);
		
		
		List<String> imagePathsCles = new ArrayList<String>();
		String imagePathCles = "image/item/quete/cles.png";
		imagePathsCles.add(imagePathCles);
		
		List<String> imagePathsGraisse = new ArrayList<String>();
		String imagePathGraisse = "image/item/quete/graisseATraire.jpg";
		imagePathsGraisse.add(imagePathGraisse);
		
		

		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "image/mp3Player/stop.png";
		imagePaths1.add(imagePath1);

		List<String> imagePaths2 = new ArrayList<String>();
		String imagePath2 = "image/mp3Player/pause.png";
		imagePaths2.add(imagePath2);

		List<String> imagePaths3 = new ArrayList<String>();
		String imagePath3 = "image/mp3Player/back.png";
		imagePaths3.add(imagePath3);
		
		// Sons
		List<String> sonPathsManger1 = new ArrayList<String>();
		String sonPathManger1 = "sonParDefaut/manger1.mp3";
		sonPathsManger1.add(sonPathManger1);
		
		List<String> sonPathsdiehard3 = new ArrayList<String>();
		String sonPathdiehard3 = "son/film/diehard3.mp3";
		sonPathsdiehard3.add(sonPathdiehard3);
		
		List<String> sonPathsBoire1 = new ArrayList<String>();
		String sonPathBoire1 = "sonParDefaut/manger2.mp3";
		sonPathsBoire1.add(sonPathBoire1);
		
		
		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "sonParDefaut/photoBruit2.mp3";
		sonPaths1.add(sonPath1);

		List<String> sonPaths2 = new ArrayList<String>();
		String sonPath2 = "sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "video/Trololo.mp4";
		videoPaths1.add(videoPath1);

		// Consommables Combat
		
		// Popo : vie/mana
		Item popoVie25   = new Item(100, "Potion de vie (25%)",   "info1", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_25, false);
		Item popoVie50   = new Item(101, "Potion de vie (50%)",   "info1", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_50, false);
		Item popoVie75   = new Item(102, "Potion de vie (75%)",   "info1", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_75, false);
		Item popoVie100  = new Item(103, "Potion de vie (100%)",  "info1", imagePathsPopoVie, sonPathsManger1, null, PersoPrenom.GROUPE, ItemType.POTION_VIE_100, false);
		Item popoMana25  = new Item(200, "Potion de mana (25%)",  "info2", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_25, false);
		Item popoMana50  = new Item(201, "Potion de mana (50%)",  "info2", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_50, false);
		Item popoMana75  = new Item(202, "Potion de mana (75%)",  "info2", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_75, false);
		Item popoMana100 = new Item(203, "Potion de mana (100%)", "info2", imagePathsPopoMana, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.POTION_MANA_100, false);
		
		// Bonus competences (+5, +10, +20)
		Item bonusChance5 = 	   new Item(300, "Bonus de chance (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_CHANCE_5, false);
		Item bonusChance10 =       new Item(301, "Bonus de chance (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_CHANCE_10, false);
		Item bonusChance20 =       new Item(302, "Bonus de chance (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_CHANCE_20, false);
		Item bonusExploit5 =       new Item(303, "Bonus d'exploit (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_EXPLOIT_5, false);
		Item bonusExploit10 =      new Item(304, "Bonus d'exploit (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_EXPLOIT_10, false);
		Item bonusExploit20 =      new Item(305, "Bonus d'exploit (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_EXPLOIT_20, false);
		Item bonusTechnique5 =     new Item(306, "Bonus de technique (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_TECHNIQUE_5, false);
		Item bonusTechnique10 =    new Item(307, "Bonus de technique (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_TECHNIQUE_10, false);
		Item bonusTechnique20 =    new Item(308, "Bonus de technique (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_TECHNIQUE_20, false);
		Item bonusEndurance5 =     new Item(309, "Bonus d'endurance (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_ENDURANCE_5, false);
		Item bonusEndurance10 =    new Item(310, "Bonus d'endurance (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_ENDURANCE_10, false);
		Item bonusEndurance20 =    new Item(311, "Bonus d'endurance (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_ENDURANCE_20, false);
		Item bonusRapidite5 =      new Item(312, "Bonus de rapidité (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RAPIDITE_5, false);
		Item bonusRapidite10 =     new Item(313, "Bonus de rapidité (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RAPIDITE_10, false);
		Item bonusRapidite20 =     new Item(314, "Bonus de rapidité (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RAPIDITE_20, false);
		Item bonusResistance5 =    new Item(315, "Bonus de resistance (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RESISTANCE_5, false);
		Item bonusResistance10 =   new Item(316, "Bonus de resistance (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RESISTANCE_10, false);
		Item bonusResistance20 =   new Item(317, "Bonus de resistance (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_RESISTANCE_20, false);
		Item bonusAgilite5 =       new Item(318, "Bonus d'agilité (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_AGILITE_5, false);
		Item bonusAgilite10 = 	   new Item(319, "Bonus d'agilité (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_AGILITE_10, false);
		Item bonusAgilite20 = 	   new Item(320, "Bonus d'agilité (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_AGILITE_20, false);
		Item bonusIntelligence5 =  new Item(321, "Bonus d'intelligence (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_INTELLIGENCE_5, false);
		Item bonusIntelligence10 = new Item(322, "Bonus d'intelligence (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_INTELLIGENCE_10, false);
		Item bonusIntelligence20 = new Item(323, "Bonus d'intelligence (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_INTELLIGENCE_20, false);
		Item bonusNervosite5 = 	   new Item(324, "Bonus de nervosité (+5)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_NERVOSITE_5, false);
		Item bonusNervosite10 =    new Item(325, "Bonus de nervosité (+10)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_NERVOSITE_10, false);
		Item bonusNervosite20 =    new Item(326, "Bonus de nervosité (+20)", "info2", imagePathsBonus, sonPathsBoire1, null, PersoPrenom.GROUPE, ItemType.BONUS_STAT_NERVOSITE_20, false);

		// Objets de quete (pas d'utilisation)
		Item cleTerrain = new Item(400, "Clés du terrain", "info2", imagePathsCles, sonPaths1, null, PersoPrenom.Johann, ItemType.OBJET_QUETE, false);
		Item graisse = new Item(401, "Graisse à traire", "info2", imagePathsGraisse, sonPaths1, null, PersoPrenom.Jonathan, ItemType.OBJET_QUETE, false);
		
		// Films
		Item VHS_diehard3 = new Item(600, "VHS - Die Hard 3", "", imagePathsdiehard3VHS, sonPathsdiehard3, null, PersoPrenom.GROUPE, ItemType.FILM, false);
		
		// Objets evenements
		
		// Armes
		Item mouchoir = new Item(500, "Paquet de mouchoir", "info2", imagePaths1, sonPaths1, null, PersoPrenom.Thomas, ItemType.ARME, false);
		Item ventoline = new Item(501, "Ventoline", "info2", imagePaths1, sonPaths1, null, PersoPrenom.Pierre, ItemType.ARME, false);

		// Equipements
		
		// Objets sort (REZ, damage, casse bouclier)
		
		// Collections (Cartes (dbz, panini foot), billes, pogs, pins, jouets (puce rebondissante, ressort multicolore, jeu video pocket, avions en papier, ) 
		Item carteDBZ1 = new Item(901, "Carte DBZ n°1", "Carte de San Goku",  imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ2 = new Item(902, "Carte DBZ n°2", "Carte de San Gohan", imagePaths2, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ3 = new Item(903, "Carte DBZ n°3", "Carte de Krilin",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ4 = new Item(904, "Carte DBZ n°4", "Carte de Yamcha",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ5 = new Item(905, "Carte DBZ n°5", "Carte de Picolo",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ6 = new Item(906, "Carte DBZ n°6", "Carte de Vegeta",    imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ7 = new Item(907, "Carte DBZ n°7", "Carte de Cell",      imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		Item carteDBZ8 = new Item(908, "Carte DBZ n°8", "Carte de Spopovich", imagePaths3, sonPaths1, videoPaths1, PersoPrenom.GROUPE, ItemType.CARTE_DBZ, false);
		
		Item item10 = new Item(incrementeId(), "item10", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item11 = new Item(incrementeId(), "item11", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item12 = new Item(incrementeId(), "item12", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item13 = new Item(incrementeId(), "item13", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item14 = new Item(incrementeId(), "item14", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item15 = new Item(incrementeId(), "item15", "info4", imagePaths3, sonPaths2, videoPaths1, PersoPrenom.GROUPE, ItemType.OBJET_QUETE, false);
		
		// Ajout a la liste
		items.add(popoVie25);
		items.add(popoVie50);
		items.add(popoVie75);
		items.add(popoVie100);
		items.add(popoMana25);
		items.add(popoMana50);
		items.add(popoMana75);
		items.add(popoMana100);
		items.add(bonusChance5);
		items.add(bonusChance10);
		items.add(bonusChance20);
		items.add(bonusExploit5);
		items.add(bonusExploit10);
		items.add(bonusExploit20);
		items.add(bonusTechnique5);
		items.add(bonusTechnique10);
		items.add(bonusTechnique20);
		items.add(bonusEndurance5);
		items.add(bonusEndurance10);
		items.add(bonusEndurance20);
		items.add(bonusRapidite5);
		items.add(bonusRapidite10);
		items.add(bonusRapidite20);
		items.add(bonusResistance5);
		items.add(bonusResistance10);
		items.add(bonusResistance20);
		items.add(bonusAgilite5);
		items.add(bonusAgilite10);
		items.add(bonusAgilite20);
		items.add(bonusIntelligence5);
		items.add(bonusIntelligence10);
		items.add(bonusIntelligence20);
		items.add(bonusNervosite5);
		items.add(bonusNervosite10);
		items.add(bonusNervosite20);
		
		items.add(cleTerrain);
		items.add(graisse);
		items.add(VHS_diehard3);
		items.add(mouchoir);
		items.add(ventoline);
		
		items.add(carteDBZ1);
		items.add(carteDBZ2);
		items.add(carteDBZ3);

		items.add(item10);
		items.add(item11);
		items.add(item12);
		items.add(item13);
		items.add(item14);
		items.add(item15);

		// Refresh Listes
		triItems();
	}

	public List<Item> getAllItems() {
		return items;
	}

	public Item getItemByNom(String nom) {
		for (Item item : items) {
			if (item.getNom().equals(nom)) {
				return item;
			}
		}
		return null;
	}
	
	public Item getItemById(int id) {
		for (Item item : items) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public List<Item> getItemsDisponiblesByPerso(PersoPrenom nomPerso) {
		List<Item> itemPerso = new ArrayList<Item>();
		for (Item item : items) {
			if (item.getProprietaire().equals(nomPerso) && item.isDisponible()) {
				itemPerso.add(item);
			}
		}
		return itemPerso;
	}

	public List<Item> getItemsDisponibles() {
		refreshItems();
		return itemsDisponibles;
	}

	public List<Item> getItemsIndisponibles() {
		refreshItems();
		return itemsIndisponibles;
	}

	private void triItems() {
		for (Item item : items) {
			if (item.isDisponible()) {
				itemsDisponibles.add(item);
			} else {
				itemsIndisponibles.add(item);
			}
		}
	}

	private void refreshItems() {
		List<Item> indispoTemp = new ArrayList<Item>(itemsIndisponibles);
		for (Item item : indispoTemp) {
			if (item.isDisponible()) {
				// Refresh
				itemsDisponibles.add(item);
				itemsIndisponibles.remove(item);
			}
		}
	}
	
	private int incrementeId() {
		id = id +1;
		return id;
	}

}

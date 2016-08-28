package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoNom;

public class ItemManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static List<Item> items;
	private static List<Item> itemsDisponibles;
	private static List<Item> itemsIndisponibles;
	private static int id = 0;

	public void initialise() {

		items = new ArrayList<>();
		itemsDisponibles = new ArrayList<>();
		itemsIndisponibles = new ArrayList<>();

		// Chargement des items

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
		String sonPath2 = "src/main/resources/sonParDefaut/08-Zelda-item-catch.mp3";
		sonPaths2.add(sonPath2);
		
		List<String> videoPaths1 = new ArrayList<>();
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		videoPaths1.add(videoPath1);

		Item item1 = new Item(incrementeId(), "item1", "info1", imagePaths1, sonPaths1, videoPaths1, PersoNom.JOHANN, ItemType.CARTES, false);
		Item item2 = new Item(incrementeId(), "item2", "info2", imagePaths2, sonPaths2, videoPaths1, PersoNom.NICOLAS, ItemType.BILLES, false);
		Item item3 = new Item(incrementeId(), "item3", "info3", imagePaths3, sonPaths1, videoPaths1, PersoNom.THOMAS, ItemType.OBJET_QUETE, false);
		Item item4 = new Item(incrementeId(), "item4", "info4", imagePaths2, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item5 = new Item(incrementeId(), "item5", "info3", imagePaths1, sonPaths1, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item6 = new Item(incrementeId(), "item6", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item7 = new Item(incrementeId(), "item7", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item8 = new Item(incrementeId(), "item8", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item9 = new Item(incrementeId(), "item9", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item10 = new Item(incrementeId(), "item10", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item11 = new Item(incrementeId(), "item11", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item12 = new Item(incrementeId(), "item12", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item13 = new Item(incrementeId(), "item13", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item14 = new Item(incrementeId(), "item14", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		Item item15 = new Item(incrementeId(), "item15", "info4", imagePaths3, sonPaths2, videoPaths1, PersoNom.GROUPE, ItemType.OBJET_QUETE, false);
		
		// Ajout a la liste
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		items.add(item5);
		items.add(item6);
		items.add(item7);
		items.add(item8);
		items.add(item9);
		items.add(item10);
		items.add(item11);
		items.add(item12);
		items.add(item13);
		items.add(item14);
		items.add(item15);

		// Refresh Listes
		triItems();
	}

	public static List<Item> getAllItems() {
		return items;
	}

	public static Item getItemByNom(String nom) {
		for (Item item : items) {
			if (item.getNom().equals(nom)) {
				return item;
			}
		}
		return null;
	}

	
	public static List<Item> getItemsByPerso(PersoNom nomPerso) {
		List<Item> itemPerso = new ArrayList<>();
		for (Item item : items) {
			if (item.getProprietaire().equals(nomPerso) && item.isDisponible()) {
				itemPerso.add(item);
			}
		}
		return itemPerso;
	}

	public static List<Item> getItemsDisponibles() {
		refreshItems();
		return itemsDisponibles;
	}

	public static List<Item> getItemsIndisponibles() {
		refreshItems();
		return itemsIndisponibles;
	}

	private static void triItems() {
		for (Item item : items) {
			if (item.isDisponible()) {
				itemsDisponibles.add(item);
			} else {
				itemsIndisponibles.add(item);
			}
		}
	}

	private static void refreshItems() {
		List<Item> indispoTemp = new ArrayList<>(itemsIndisponibles);
		for (Item item : indispoTemp) {
			if (item.isDisponible()) {
				// Refresh
				itemsDisponibles.add(item);
				itemsIndisponibles.remove(item);
			}
		}
	}
	
	private static int incrementeId() {
		id = id +1;
		return id;
	}
}

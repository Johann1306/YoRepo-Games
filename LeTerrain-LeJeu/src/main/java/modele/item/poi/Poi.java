package modele.item.poi;

import java.io.Serializable;
import java.util.List;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.mission.Mission;
import modele.item.personnage.PersoPrenom;

public class Poi extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name; // Nom du POI (ex : la marelle, 
	private int x; // Coordonnee x sur la map
	private int y; // Coordonnee x sur la map
	private List<Mission> missions; // Missions proposees a cet endroit
	
	public Poi(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, boolean isDisponible, String name, int x,
			int y, List<Mission> missions) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.POI, false);
		this.name = name;
		this.x = x;
		this.y = y;
		this.missions = missions;
	}
	
	
}

package modele.item.poi;

import java.util.List;

import modele.item.mission.Mission;

public class Poi {

	private String name; // Nom du POI (ex : la marelle, 
	private int x; // Coordonnée x sur la map
	private int y; // Coordonnée x sur la map
	private List<Mission> missions; // Missions proposées a cet endroit
}

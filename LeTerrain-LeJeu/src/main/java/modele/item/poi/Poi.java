package modele.item.poi;

import java.io.Serializable;
import java.util.List;

import modele.item.mission.Mission;

public class Poi implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name; // Nom du POI (ex : la marelle, 
	private int x; // Coordonnee x sur la map
	private int y; // Coordonnee x sur la map
	private List<Mission> missions; // Missions proposees a cet endroit
}

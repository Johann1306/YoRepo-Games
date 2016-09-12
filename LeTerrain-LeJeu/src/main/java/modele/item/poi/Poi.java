package modele.item.poi;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.mission.Mission;
import modele.item.personnage.PersoPrenom;

public class Poi extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private Point point; // Coordonnees sur le lieu
	private List<Mission> missions; // Missions proposees a cet endroit
	
	public Poi(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, boolean isDisponible, Point point, List<Mission> missions) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.POI, isDisponible);
		this.point = point;
		this.missions = missions;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public List<Mission> getMissions() {
		return missions;
	}

	public void setMissions(List<Mission> missions) {
		this.missions = missions;
	}

}

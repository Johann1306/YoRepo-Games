package modele.item.lieu;

import java.awt.Point;
import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.personnage.PersoPrenom;
import modele.item.poi.Poi;

public class Lieu extends Item implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Point position; // Coordonnees sur la carte
	private ImageIcon background; // Background du lieu
	private String backgroundPath; // Chemin du background du lieu
	private List<Poi> pois; // Points of Interest du lieu
//	private Carte carte;

	public Lieu(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths, List<String> videoPaths,
			PersoPrenom proprietaire, Point position, String backgroundPath, List<Poi> pois, boolean isDisponible) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.LIEU, isDisponible);
		this.position = position;
		this.background = new ImageIcon(backgroundPath);
		this.backgroundPath = backgroundPath;
		this.pois = pois;
	}
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public ImageIcon getBackground() {
		return background;
	}
	public String getBackgroundPath() {
		return backgroundPath;
	}
	public void setBackground(ImageIcon background) {
		this.background = background;
	}
	public List<Poi> getPois() {
		return pois;
	}
	public void setPois(List<Poi> pois) {
		this.pois = pois;
	}

}

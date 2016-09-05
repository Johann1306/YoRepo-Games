package modele.item.lieu;

import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

import modele.item.poi.Poi;

public class Lieu implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int x; // Coordonnee x sur la map
	private int y; // Coordonnee x sur la map
	private String name; // Nom du lieu
	private ImageIcon background; // Background du lieu
	private List<Poi> pois; // Points of Interest du lieu
//	private Carte carte;

}

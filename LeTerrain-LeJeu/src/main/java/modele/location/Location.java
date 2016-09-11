package modele.location;

import java.awt.Point;
import java.io.Serializable;

import modele.item.lieu.Lieu;

public class Location implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Lieu lieu;
	private Point coordonnees;
	
	public Location(Lieu lieu, Point coordonnees) {
		super();
		this.lieu = lieu;
		this.coordonnees = coordonnees;
	}
	public Point getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(Point coordonnees) {
		this.coordonnees = coordonnees;
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	

}

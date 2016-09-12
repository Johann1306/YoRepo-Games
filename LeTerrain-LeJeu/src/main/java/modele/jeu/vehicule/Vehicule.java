package modele.jeu.vehicule;

import java.awt.Point;

public class Vehicule {
	
	private Point position;
	private int vitesse;
	private int direction;
	private int angle;
	private int vitesseMax;
	private int acceleration;
	private int freinage;
	
	public Vehicule(Point position, int vitesse, int direction, int angle, int vitesseMax, int acceleration, int freinage) {
		super();
		this.position = position;
		this.vitesse = vitesse;
		this.direction = direction;
		this.angle = angle;
		this.vitesseMax = vitesseMax;
		this.acceleration = acceleration;
		this.freinage = freinage;
	}

	public void avance() {
		// TODO Auto-generated method stub
		
	}

	public void freine() {
		// TODO Auto-generated method stub
		
	}

	public void tourneGauche() {
		// TODO Auto-generated method stub
		
	}

	public void tourneDroite() {
		// TODO Auto-generated method stub
		
	}

	public void freineLentement() {
		// TODO Auto-generated method stub
		
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getVitesseMax() {
		return vitesseMax;
	}

	public void setVitesseMax(int vitesseMax) {
		this.vitesseMax = vitesseMax;
	}

	public int getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	public int getFreinage() {
		return freinage;
	}

	public void setFreinage(int freinage) {
		this.freinage = freinage;
	}

}

package front;

import java.util.List;

import core.MusiqueManager;
import core.configuration.Constante;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modele.item.media.audio.Musique;

@SuppressWarnings("restriction")
public class Ballon extends Pane {
	
	private PVector ballonPositionCible = new PVector(0, 0, 0);
    private PVector location;
	private PVector velocity;
    private int topspeed;

    private double width;
    private double height;
    private double centerX;
    private double centerY;
    private double rayon;

    Circle circle;
	private PVector direction;
	private boolean aDepasseLaCible = false;

	private boolean estEntreDansLeBut = false;
	
	private TextArea logging;

    public Ballon(Color color, PVector positionDepart, TextArea logging, int facteurAgrandissement) {

    	this.logging = logging;
    	this.topspeed = Constante.VITESSE_MAX_BALLON / facteurAgrandissement;
    	this.width = Constante.RAYON_BALLON *2 *facteurAgrandissement;
    	this.height = width;
    	this.centerX = width / 2.0;
    	this.centerY = height / 2.0;
    	this.rayon = width / 2.0;
    	
        location = positionDepart;
        velocity = new PVector(0, 0, 0);

        circle = new Circle(rayon);
        circle.setCenterX(rayon);
        circle.setCenterY(rayon);

        circle.setStroke(Color.BLACK);
        circle.setFill(color);

        getChildren().add(circle);

    }

    public void step() {
    	
    	// Si on rentre dans la zone cible (!!! l'interval doit etre plus grand que le pas maximum (vitesse max) (si vitesse max = 100 => le pas doit etre > 10)) 
    	if ((((location.x - ballonPositionCible.x) <= Constante.VITESSE_MAX_BALLON/20 
    			&& (location.x - ballonPositionCible.x) >= - Constante.VITESSE_MAX_BALLON/20)) 
    			&& ((location.y - ballonPositionCible.y) <= Constante.VITESSE_MAX_BALLON/20 
    			&& (location.y - ballonPositionCible.y) >= - Constante.VITESSE_MAX_BALLON/20)) {

//    		System.out.println("------INTERSECTION BALLON AVEC LA CIBLE--------");
    		aDepasseLaCible = true;
    		
    	} 
    		
		// Si la cible n'est pas encore atteinte
		if (!aDepasseLaCible) {
    		
			
		// Si la cible a été dépassée ou rebond sur mur
		} else {

			// On decremente la vitesse
			if (topspeed > 0) {
    			topspeed = topspeed -Constante.VITESSE_MAX_BALLON/100;
    		}
			velocity = new PVector(0, 0, 0);
			velocity.add(direction);
			
			// Si le ballon est entree
			if (estEntreDansLeBut) {
				
    			// On divise la vitesse max par 3
    			velocity.limit(topspeed/30);
				
    		// Si le ballon n'est pas entree
			} else {

				// On garde la vitesse max courante
    			velocity.limit(topspeed/10);
			}
		}
    	
    	location = new PVector(location.x + velocity.x, location.y + velocity.y, 0);

    }
    
    public void initMouvement(PVector cible, int vitesseMax) {
		setPositionCible(cible);
		direction = PVector.sub(ballonPositionCible, location);
		velocity = new PVector(0, 0, 0);
		velocity.add(direction);
		topspeed = vitesseMax;
		velocity.limit(topspeed/10);
	}

	public int checkBoundaries() {
		
		int but = 0;
		
		// Tant que le ballon n'est pas rentré
		if (!estEntreDansLeBut) {
			
			// Si ballon passe la ligne de but adverse
			if (location.x >= (Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - rayon)) {
				
				if ((location.y >= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon - Constante.LARGEUR_TERRAIN/8)) 
						&& (location.y <= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon + Constante.LARGEUR_TERRAIN/8))) {
//					System.out.println("------- Ballon touche la ligne de but---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					
					// Si but allie
					if (location.x > Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN) {
//						System.out.println("------- Ballon depasse la ligne de but => BUT - " + "(x:" + location.x + "," + "y:" + location.y + ")");
						setEstEntre(true);
						but = 1;
					}
					
				} else {
					setLocation(new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN -1 - rayon, getLocation().y, 0));
					rebondDroiteGauche();
				}
				
			// Si ballon passe la ligne de but allie
			} else if (location.x <= (Constante.COORD_X_TERRAIN + rayon)) {
				
				if ((location.y >= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon - Constante.LARGEUR_TERRAIN/8)) 
						&& (location.y <= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon + Constante.LARGEUR_TERRAIN/8))) {
//					System.out.println("------- Ballon touche la ligne de but---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
			
					// Si but adverse
					if (location.x < Constante.COORD_X_TERRAIN) {
//						System.out.println("------- Ballon depasse la ligne de but => BUT - " + "(x:" + location.x + "," + "y:" + location.y + ")");
						setEstEntre(true);
						but = 2;
					} 
					
				} else {
					setLocation(new PVector(Constante.COORD_X_TERRAIN +1 + rayon, getLocation().y, 0));
					rebondDroiteGauche();
				}
				
			}  else {
				
				// Rebond sur le mur droite
				if ((location.x >= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - rayon)
					&& ((location.y >= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon - Constante.LARGEUR_TERRAIN/8)) 
					|| (location.y <= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon + Constante.LARGEUR_TERRAIN/8)))) {
					
//					System.out.println("------- Rebond mur gauche/droite---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN -1 - rayon, getLocation().y, 0));
					rebondDroiteGauche();
					
				// Rebond sur le mur gauche
				} else if ((location.x <= Constante.COORD_X_TERRAIN + rayon) 
					&& ((location.y >= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon - Constante.LARGEUR_TERRAIN/8)) 
							|| (location.y <= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon + Constante.LARGEUR_TERRAIN/8)))) {
					
//					System.out.println("------- Rebond mur gauche/droite---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(Constante.COORD_X_TERRAIN +1 + rayon, getLocation().y, 0));
					rebondDroiteGauche();
				}
				
				// Rebond sur le mur haut et bas
				if (location.y >= Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN - rayon) {
//					System.out.println("------- Rebond haut/bas ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(getLocation().x, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN - rayon -1, 0));
					rebondHautBas();
				} else if (location.y <= Constante.COORD_Y_TERRAIN + rayon) {
//					System.out.println("------- Rebond haut/bas ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(getLocation().x, Constante.COORD_Y_TERRAIN + rayon +1, 0));
					rebondHautBas();
				}
			}
			
		// Si le ballon est entrée
		} else {
			
			// Rebond dans les buts adverse
			if ((location.x >= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN + Constante.LARGEUR_TERRAIN/16 - rayon)) {
//				System.out.println("------- Rebond gauche droite dans les but ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
				setLocation(new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN + Constante.LARGEUR_TERRAIN/16 - rayon -1, getLocation().y, 0));
				rebondDroiteGauche();
			}
			
			if (location.x >= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN) {
				
				if (location.y <= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon - Constante.LARGEUR_TERRAIN/8)) {
//					System.out.println("------- Rebond haut/bas dans les but ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(getLocation().x, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon +1 - Constante.LARGEUR_TERRAIN/8, 0));
					rebondHautBas();
				} else if (location.y >= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon + Constante.LARGEUR_TERRAIN/8)) {
//					System.out.println("------- Rebond haut/bas dans les but ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(getLocation().x, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon -1 + Constante.LARGEUR_TERRAIN/8, 0));
					rebondHautBas();
				}
			}
			
			// Rebond dans les buts allie
			if ((location.x <= Constante.COORD_X_TERRAIN - Constante.LARGEUR_TERRAIN/16 + rayon)) {
//				System.out.println("------- Rebond gauche droite dans les but ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
				setLocation(new PVector(Constante.COORD_X_TERRAIN - Constante.LARGEUR_TERRAIN/16 + rayon + 1, getLocation().y, 0));
				rebondDroiteGauche();
			}
			
			if (location.x <= Constante.COORD_X_TERRAIN) {
				if (location.y <= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon - Constante.LARGEUR_TERRAIN/8)) {
//					System.out.println("------- Rebond haut/bas dans les but ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(getLocation().x, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 + rayon +1 - Constante.LARGEUR_TERRAIN/8, 0));
					rebondHautBas();
				} else if (location.y >= (Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon + Constante.LARGEUR_TERRAIN/8)) {
//					System.out.println("------- Rebond haut/bas dans les but ---------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
					setLocation(new PVector(getLocation().x, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2 - rayon -1 + Constante.LARGEUR_TERRAIN/8, 0));
					rebondHautBas();
				}
			}
		}
		
		return but;
    }

	private void rebondDroiteGauche() {
//		System.out.println("------REBOND X-------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
		
//		if (location.x > Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN) {
//			location.x = Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN -1 - rayon;
//		} else if (location.x < Constante.COORD_X_TERRAIN) {
//			location.x = Constante.COORD_X_TERRAIN +1 +rayon;
//		}
		
		aDepasseLaCible = true;
		// On inverse la direction sur l'axe X
		direction = new PVector(-direction.x, direction.y, 0);
		velocity.set(0, 0, 0);
		velocity.add(direction);
		// On empeche le blocage dans le mur lors du rebond (a cause de la deceleration)
		topspeed = topspeed + Constante.VITESSE_MAX_BALLON/100 +1;
		// On diminue la vitesse au rebond
		if (topspeed > 150) {
			topspeed = 150;
		} else if (topspeed > 100) {
			topspeed = 100;
		}
		velocity.limit(topspeed/10);
		
		// Son de rebond
		List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/rebondMur", 210000);
		MusiqueManager.playSonRandom(musiques);	
	}

	private void rebondHautBas() {
//		System.out.println("------REBOND Y-------- " + "(x:" + location.x + "," + "y:" + location.y + ")");
		
//		if (location.y > Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN) {
//			location.y = Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN -1 -rayon;
//		} else if (location.y < Constante.COORD_Y_TERRAIN) {
//			location.y = Constante.COORD_Y_TERRAIN +1 + rayon;
//		}
		
		aDepasseLaCible = true;
		// On inverse la direction sur l'axe Y
		direction = new PVector(direction.x, -direction.y, 0);
		velocity.set(0, 0, 0);
		velocity.add(direction);
		// On empeche le blocage dans le mur lors du rebond (a cause de la deceleration)
		topspeed = topspeed + Constante.VITESSE_MAX_BALLON/100 +1;
		// On diminue la vitesse au rebond
		if (topspeed > 150) {
			topspeed = 150;
		} else if (topspeed > 100) {
			topspeed = 100;
		}
		velocity.limit(topspeed/10);
		
		// Son de rebond
		List<Musique> musiques = MusiqueManager.chargeMusiquesParRepertoire("son/football/rebondMur", 210000);
		MusiqueManager.playSonRandom(musiques);	

	}

    public void display() {
        relocate(location.x - centerX, location.y - centerY);
    }

	public void setPositionCible(PVector ballonPositionCible) {
		this.ballonPositionCible = ballonPositionCible;
	}

	public PVector getBallonPositionCible() {
		return ballonPositionCible;
	}

    public boolean isaDepasseLaCible() {
		return aDepasseLaCible;
	}

	public void setaDepasseLaCible(boolean aDepasseLaCible) {
		this.aDepasseLaCible = aDepasseLaCible;
	}

    public int getTopspeed() {
		return topspeed;
	}

	public void setTopspeed(int topspeed) {
		this.topspeed = topspeed;
	}
	
	public void resetTopSpeed() {
		topspeed = Constante.VITESSE_MAX_BALLON;		
	}

	public PVector getLocation() {
		return location;
	}

	public void setLocation(PVector location) {
		this.location = location;
	}

	public PVector getVelocity() {
		return velocity;
	}

	public void setVelocity(PVector velocity) {
		this.velocity = velocity;
	}

	public void setBallonPositionCible(PVector ballonPositionCible) {
		this.ballonPositionCible = ballonPositionCible;
	}

	public boolean isEstEntre() {
		return estEntreDansLeBut;
	}

	public void setEstEntre(boolean estEntre) {
		this.estEntreDansLeBut = estEntre;
	}
	
	
	
}
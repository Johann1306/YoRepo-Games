package front;

import core.configuration.Constante;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.paint.ImagePattern;
import javafx.scene.image.Image;
import javafx.scene.effect.DropShadow;
import modele.foot.Poste;
import modele.item.personnage.Personnage;

@SuppressWarnings("restriction")
public class JoueurPrincipal extends Pane {

    private PVector positionDepart;
    private PVector positionDefense;
    private PVector positionAttaque;

    private PVector location;
    private PVector velocity;
    private PVector acceleration;
    
    float topspeed;
    
    double largeur;
	double hauteur;
    double centerX;
    double centerY;
    double radius;

    private Circle circle;

	private boolean vientDeTirer = false;
	private boolean vientDIntercepter = false;
	private boolean vientDeClasher = false;

	private long dateDernierTir;
	private long dateDerniereInterception;
	private long dateDernierClash;

	private Poste poste;
	
	private Personnage personnage;
	private boolean isAllie;
	private long tempsDeReactionInterception; 	
	private long tempsDeReactionClash; 			
	private double bonusZoneInterception;
	private double vitesseRetournement;

    public JoueurPrincipal(Personnage personnage, boolean isAllie, Poste poste, int facteurAgrandissement) {
    	
    	System.out.println("-- Creation du personnage " + personnage.getPrenom());
    	
    	this.largeur = Constante.RAYON_JOUEUR *2 * (1 + facteurAgrandissement/2);
    	this.hauteur = largeur;
    	this.centerX = largeur / 2.0;
    	this.centerY = hauteur / 2.0;
    	this.radius = largeur / 2.0;
    	
    	this.topspeed = calculeVitesseMax(personnage, facteurAgrandissement);
    	
    	this.vitesseRetournement = calculeVitesseRetournement(personnage);
    	
    	this.bonusZoneInterception = calculeBonusZoneInterception(personnage);
    	
    	this.tempsDeReactionInterception = calculeTempsDeReactionInterception(personnage);
    	
    	this.tempsDeReactionClash = calculeTempsDeReactionClash(personnage);
    	
    	this.setAllie(isAllie);
    	this.setPoste(poste);
    	this.setPersonnage(personnage);
    	
    	if (isAllie) {
    		
    		// Postes Ami
	    	if (poste == Poste.G) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + 50, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2, 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + 50, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2, 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + 100, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2, 0);
	    		
	    	} else if (poste == Poste.AG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		
	    	} else if (poste == Poste.DCG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		
	    	} else if (poste == Poste.DCD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		
	    	} else if (poste == Poste.AD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 1/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		
	    	} else if (poste == Poste.MG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		
	    	} else if (poste == Poste.MCG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		
	    	} else if (poste == Poste.MC) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/2), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/2), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/2), 0);
	    		
	    	} else if (poste == Poste.MCD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		
	    	} else if (poste == Poste.MD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 2/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		
	    	} else if (poste == Poste.BG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		
	    	} else if (poste == Poste.BD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		
	    	} 
	    	
    	} else {
    		// Postes Adverse
    		if (poste == Poste.G) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - 50, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2, 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - 50, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2, 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - 100, Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN/2, 0);
	    		
	    	} else if (poste == Poste.AG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		
	    	} else if (poste == Poste.DCG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		
	    	} else if (poste == Poste.DCD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		
	    	} else if (poste == Poste.AD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 + 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 5/6 - 100, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		
	    	} else if (poste == Poste.MG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		
	    	} else if (poste == Poste.MCG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		
	    	} else if (poste == Poste.MC) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/2), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/2), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/2), 0);
	    		
	    	} else if (poste == Poste.MCD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		
	    	} else if (poste == Poste.MD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 4/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		
	    	} else if (poste == Poste.BG) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5), 0);
	    		
	    	} else if (poste == Poste.BD) {
	    		this.positionDepart = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5), 0);
	    		this.positionDefense = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 + 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		this.positionAttaque = new PVector(Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN * 3/6 - 150, Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5), 0);
	    		
	    	} 
    	}
    	

        location = new PVector(positionDepart.x, positionDepart.y, positionDepart.z);
        velocity = new PVector(0, 0, 0);

        circle = new Circle(radius);
        circle.setCenterX(radius);
        circle.setCenterY(radius);

        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(3);
        if (isAllie) {
//        	circle.setFill(Color.BLUE.deriveColor(1, 1, 1, 0.3));
        	Image im = new Image(personnage.getImagePath().get(0),false);
        	circle.setFill(new ImagePattern(im));
        	circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKSEAGREEN));
        } else {
//        	circle.setFill(Color.RED.deriveColor(1, 1, 1, 0.3));
        	circle.setFill(Color.RED);
        	circle.setEffect(new DropShadow(+25d, 0d, +2d, Color.DARKGOLDENROD));
        }

        getChildren().add(circle);
	}

	private double calculeVitesseRetournement(Personnage personnage) {
		// Vitesse retournement : RAPIDITE / AGILITE / TECHNIQUE / NERVOSITE / ENDURANCE (0.5 - 2)
		int rapidite = personnage.getCompetence().getRapidite();
		int agilite = personnage.getCompetence().getAgilite();
    	int technique = personnage.getCompetence().getTechnique();
    	int nervosite = personnage.getCompetence().getNervosite();
		int endurance = personnage.getCompetence().getEndurance();
		double moyenne = (technique + agilite + rapidite + nervosite + endurance) / 5;
    	moyenne = moyenne / 50;
    	System.out.println("STAT vitesse retournement (0.5 - 2) = " + moyenne);
		return moyenne;
	}

	private float calculeVitesseMax(Personnage personnage, int facteurAgrandissement) {
		// Vitesse max : RAPIDITE / TECHNIQUE / ENDURANCE (3-6)
		int rapidite = personnage.getCompetence().getRapidite();
    	int technique = personnage.getCompetence().getTechnique();
    	int endurance = personnage.getCompetence().getEndurance();
    	float moyenne = (technique + endurance + rapidite) / 3;
    	moyenne = (moyenne * 3) / 100;
    	moyenne = moyenne + 1;
    	moyenne = moyenne * facteurAgrandissement;
    	moyenne = moyenne / 2;
    	System.out.println("STAT vitesse max (2-4) = " + moyenne);
		return moyenne;
	}

	private long calculeTempsDeReactionClash(Personnage personnage) {
		// Bonus temps de reaction clash : Technique / Agilite / Rapidite / Nervosité (0.5 - 1.25)
    	int technique = personnage.getCompetence().getTechnique();
    	int agilite = personnage.getCompetence().getAgilite();
    	int rapidite = personnage.getCompetence().getRapidite();
    	int nervosite = personnage.getCompetence().getNervosite();
		int exploit = personnage.getCompetence().getExploit();
		int moyenne = (technique + agilite + rapidite + nervosite + exploit) / 5;
    	int delaiReaction = 1500 - moyenne*10;
    	if (delaiReaction < 0) {
    		delaiReaction = 0;
    	}
    	System.out.println("STAT temps de reaction clash = " + delaiReaction  + "ms");
		return delaiReaction;
	}

	private int calculeTempsDeReactionInterception(Personnage personnage) {
		// Bonus temps de reaction interception : Technique / Agilite / Rapidite (0.5 - 1.25)
    	int technique = personnage.getCompetence().getTechnique();
    	int agilite = personnage.getCompetence().getAgilite();
    	int rapidite = personnage.getCompetence().getRapidite();
    	int moyenne = (technique + agilite + rapidite)/3;
    	int delaiReaction = 1500 - moyenne*10;
    	if (delaiReaction < 0) {
    		delaiReaction = 0;
    	}
    	System.out.println("STAT temps de reaction interception = " + delaiReaction  + "ms");
		return delaiReaction;
	}

	private double calculeBonusZoneInterception(Personnage personnage) {
		// Bonus zone interception : AGILITE / RAPIDITE / INTELLIGENCE (0-ballon.getRayon)
		int bonus = personnage.getCompetence().getAgilite() + personnage.getCompetence().getRapidite() + personnage.getCompetence().getIntelligence();
		bonus = bonus / 3; // /100
		// En fonction du rayon du ballon
		bonus = bonus * Constante.RAYON_BALLON / 100;
		System.out.println("BONUS zone interception = " + bonus + "/" + Constante.RAYON_BALLON);
		return bonus;
	}

	public void step(PVector cible) {

        PVector direction = PVector.sub(cible, location);
        direction.normalize();
        // Vitesse de retournement - reactivité (agilité) (entre 0.5 et 2)
        direction.mult(vitesseRetournement);
        acceleration = direction;
        velocity.add(acceleration);
        velocity.limit(topspeed);
        location.add(velocity);

    }

    public void checkBoundaries() {

		if (location.x >= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - radius) {
			location.x = Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN - radius;
		} else if (location.x <= Constante.COORD_X_TERRAIN + radius) {
			location.x = Constante.COORD_X_TERRAIN + radius;
		}

		if (location.y >= Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN - radius) {
			location.y = Constante.COORD_Y_TERRAIN + Constante.LARGEUR_TERRAIN - radius;
		} else if (location.y <= Constante.COORD_Y_TERRAIN + radius) {
			location.y = Constante.COORD_Y_TERRAIN + radius;
		}
    	
    }
    
	public void reinitPositionsAllies(boolean coupEnvoiAllie) {
		location.x = getPositionDepart().x;
		location.y = getPositionDepart().y;
		if (poste == Poste.BD) {
			if (!coupEnvoiAllie) {
				location.x = Constante.COORD_X_TERRAIN + (Constante.LONGEUR_TERRAIN * 3/6);
				location.y = Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 1/5);
			}
		} else if (poste == Poste.BG) {
			if (!coupEnvoiAllie) {
				location.x = Constante.COORD_X_TERRAIN + (Constante.LONGEUR_TERRAIN * 3/6);
				location.y = Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 4/5);
			} 
		}
	}
	
	public void reinitPositionsAdverses(boolean coupEnvoiAllie) {
		location.x = getPositionDepart().x;
		location.y = getPositionDepart().y;
		if (poste == Poste.BD) {
			if (!coupEnvoiAllie) {
				location.x = Constante.COORD_X_TERRAIN + (Constante.LONGEUR_TERRAIN * 3/6);
				location.y = Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 2/5);
			}
		} else if (poste == Poste.BG) {
			if (!coupEnvoiAllie) {
				location.x = Constante.COORD_X_TERRAIN + (Constante.LONGEUR_TERRAIN * 3/6);
				location.y = Constante.COORD_Y_TERRAIN + (Constante.LARGEUR_TERRAIN * 3/5);
			} 
		}
	}

	public boolean vientDeTirer() {
		long dateCourante = System.currentTimeMillis();
		if (vientDeTirer && (dateCourante - dateDernierTir >=  500)) {
			vientDeTirer = false;
		}
		return vientDeTirer;
	}
	
	public boolean vientDIntercepter() {
		long dateCourante = System.currentTimeMillis();
		if (vientDIntercepter && (dateCourante - dateDerniereInterception >=  tempsDeReactionInterception)) {
			vientDIntercepter = false;
		}
		return vientDIntercepter;
	}
	
	public boolean vientDeClasher() {
		long dateCourante = System.currentTimeMillis();
		if (vientDeClasher && (dateCourante - dateDernierClash >=  tempsDeReactionClash)) {
			vientDeClasher = false;
		}
		return vientDeClasher;
	}

	public void setVitesseZero() {
		velocity = new PVector(0, 0, 0);		
	}
	
	public boolean estDansLeCampsAdverse() {
		if (isAllie) {
			if (location.x >= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2) {
				return true;
			}
		} else {
			if (location.x <= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/2) {
				return true;
			}
		}
		return false;
	}
	
	public boolean estDansLaZoneDeTir() {
		if (isAllie) {
			if (location.x >= Constante.COORD_X_TERRAIN + ((Constante.LONGEUR_TERRAIN * 2)/3)) {
				return true;
			}
		} else {
			if (location.x <= Constante.COORD_X_TERRAIN + Constante.LONGEUR_TERRAIN/3) {
				return true;
			}
		}
		return false;
	}

    public void display() {
        relocate(location.x - centerX, location.y - centerY);
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

	public PVector getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(PVector acceleration) {
		this.acceleration = acceleration;
	}

	public float getTopspeed() {
		return topspeed;
	}

	public void setTopspeed(float topspeed) {
		this.topspeed = topspeed;
	}


	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public boolean isVientDeTirer() {
		return vientDeTirer;
	}

	public void setVientDeTirer(boolean vientDeTirer) {
		this.vientDeTirer = vientDeTirer;
	}

	public boolean isVientDIntercepter() {
		return vientDIntercepter;		
	}
	
	public void setVientDIntercepter(boolean vientDIntercepter) {
		this.vientDIntercepter = vientDIntercepter;		
	}

	public void setVientDeClasher(boolean vientDeClasher) {
		this.vientDeClasher = vientDeClasher;		
	}

	public long getDateDernierTir() {
		return dateDernierTir;
	}

	public void setDateDernierTir(long dateDernierTir) {
		this.dateDernierTir = dateDernierTir;
	}

	public long getDateDerniereInterception() {
		return dateDerniereInterception;
	}

	public void setDateDerniereInterception(long dateDerniereInterception) {
		this.dateDerniereInterception = dateDerniereInterception;
	}
	
	public long getDateDernierClash() {
		return dateDernierClash;
	}

	public void setDateDernierClash(long dateDernierClash) {
		this.dateDernierClash = dateDernierClash;
	}
	
	public PVector getPositionDepart() {
		return positionDepart;
	}

	public void setPositionDepart(PVector positionDepart) {
		this.positionDepart = positionDepart;
	}

	public PVector getPositionDefense() {
		return positionDefense;
	}

	public void setPositionDefense(PVector positionDefense) {
		this.positionDefense = positionDefense;
	}

	public PVector getPositionAttaque() {
		return positionAttaque;
	}

	public void setPositionAttaque(PVector positionAttaque) {
		this.positionAttaque = positionAttaque;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPersonnage(Personnage personnage) {
		this.personnage = personnage;
	}

	public boolean isAllie() {
		return isAllie;
	}

	public void setAllie(boolean isAllie) {
		this.isAllie = isAllie;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getBonusZoneInterception() {
		return bonusZoneInterception;
	}


}
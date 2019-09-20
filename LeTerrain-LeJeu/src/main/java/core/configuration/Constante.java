package core.configuration;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Constante {
	
	public static final Dimension PERSO_IMAGE_DIMENSION_64_64 = new Dimension(64, 64);
	public static final Dimension PERSO_IMAGE_DIMENSION_50_50 = new Dimension(50, 50);
	public static final Dimension SHOP_TAB_ENTETES_DIMENSION = new Dimension(50, 50);
	public static final Dimension PERSO_IMAGE_DIMENSION_40_40 = new Dimension(40, 40);
	public static final Dimension PERSO_IMAGE_DIMENSION_180_180 = new Dimension(180, 180);
	public static final Dimension ARME_IMAGE_DIMENSION_25_25 = new Dimension(25, 25);
	public static final Dimension ARME_IMAGE_DIMENSION_100_100 = new Dimension(100, 100);

	// Dimension image piece d'un Franc
	public static final Dimension ARGENT_IMAGE_DIMENSION_100_100 = new Dimension(100, 100);
	
	public static final Dimension EVENEMENT_IMAGE_DIMENSION_300_300 = new Dimension(300, 300);
	
	public static final int MAX_EVENEMENTS_AFFICHES = 5;
	public static final int MAX_CASE_PAR_LIGNE = 10;
	
	public static final Dimension ITEM_TAILLE_DIMENSION = new Dimension(32,32);
	public static final Dimension ITEM_CONSOMMABLE_DIMENSION = new Dimension(32,32);
	public static final Dimension FENETRE_PRINCIPAL_DIMENSION = new Dimension(700,700);
	public static final Dimension FENETRE_COMBAT_DIMENSION = new Dimension(1000,1000);
	public static final Dimension FENETRE_COURSE_DIMENSION = new Dimension(1000,1000);
	public static final Dimension FENETRE_QUIZZ_DIMENSION = new Dimension(1000,1000);
	public static final Dimension FENETRE_QUIZZ_DIMENSION_QUESTION = new Dimension(750,500);
	public static final Dimension PANEL_CENTRE_DIMENSION = new Dimension(2000,1000);
	public static final Dimension BOUTON_MISSIONS_DIMENSION = new Dimension(300,50); // pas exact
	public static final Dimension BOUTON_LIEU_DIMENSION = new Dimension(500,50);

	public static final int PANEL_BAS_HAUTEUR = 120;		// Pour 2 barres d'inventaire TODO mieux
	public static final int PANEL_GAUCHE_LARGEUR = 180;
	public static final int PANEL_GAUCHE_MAX_HAUTEUR = 1470;	// Pour 8 persos principaux
	
	public static final int PANEL_ACTION_HAUTEUR = 190;
	public static final int PANEL_INFO_MISSION_HAUTEUR = 100;		
	
	public static final int PANEL_COMBAT_PERSO_LARGEUR = PANEL_ACTION_HAUTEUR;		
	public static final int PANEL_MISSION_LARGEUR = 975;		
	public static final int PANEL_BOUTON_GROUPE_LARGEUR = 150;
	public static final int PANEL_ACTION_PERSO_LARGEUR = 150;
	public static final int PANEL_INFO_COMBAT_LARGEUR = 465;
	public static final int PANEL_ITEMS_COMBAT_LARGEUR = 95;
	public static final int PANEL_INFO_PERSO_LARGEUR = 200;
	public static final int PANEL_INFO_PERSO_HAUTEUR = 25;

	// FONT
	public static final Font ZELDA_FONT_FRAMECOMBAT_INFO = new Font("Triforce", Font.PLAIN, 15);
	public static final Font ZELDA_FONT = new Font("Triforce", Font.PLAIN, 20);
	public static final Font SIMPSON_FONT = new Font("Simpsonfont", Font.PLAIN, 15);
	public static final Font ZELDA_FONT_MENU = new Font("Triforce", Font.PLAIN, 20);
	public static final Font ZELDA_FONT_MENU_SELECTED = new Font("Triforce", Font.PLAIN, 23);
	public static final Font ZELDA_FONT_TITRE = new Font("Triforce", Font.PLAIN, 30);
	public static final Font MARIO_FONT_TITRE = new Font("Super Mario 256", Font.PLAIN, 100);
	public static final Font MARIO_FONT_SOUS_TITRE = new Font("codeman38_press-start", Font.PLAIN, 30);
	public static final Font MARIO_FONT_INFO_TITRE = new Font("codeman38_press-start", Font.PLAIN, 20);
	public static final Font MARIO_FONT_MENU = new Font("Super Mario Bros.", Font.PLAIN, 20);
	public static final Font MARIO_FONT_MENU_2 = new Font("Super Mario 256", Font.PLAIN, 20);
	public static final Font MARIO_FONT_QUESTION_QUIZZ = new Font("Super Mario 256", Font.PLAIN, 30);
	public static final Font MARIO_FONT_PANEL_INFO_MISSION = new Font("Super Mario 256", Font.ITALIC, 10);
	public static final Font MARIO_FONT_SHOP_TABLEAU = new Font("Super Mario 256", Font.BOLD, 12);
	public static final Font MARIO_FONT_SHOP_TABLEAU_BOUTONS = new Font("Super Mario 256", Font.BOLD, 20);
	public static final Font MARIO_FONT_SHOP_ENTETES = new Font("Super Mario 256", Font.BOLD, 12);
	public static final Font MARIO_FONT_LABEL_SHOP = new Font("Super Mario 256", Font.BOLD, 30);
	
	public static final String SYMBOLE_PASSER_NEXT = ">>";

	public static final int MENU_HEIGHT = 250;
	public static final int MENU_WIDTH = 380;

	public static final int ESPACE_PANEL_CENTRE = 10;

	public static final Color COULEUR_MISSION_REPETABLE = Color.GREEN;
	public static final Color COULEUR_MISSION_PRINCIPAL = Color.BLUE;
	public static final Color COULEUR_MISSION_BOSS = Color.MAGENTA;
	public static final double QUIZZ_MAX_TEMPS = 10.00;
	
	public static final int COEF_PRIX_VENTE = 5;










}

package core.configuration;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;

public class Constante {
	
	public static final Dimension PERSO_IMAGE_DIMENSION = new Dimension(new ImageIcon("src/main/resources/image/nico petit.png").getIconWidth(), new ImageIcon("src/main/resources/image/nico petit.png").getIconHeight());
	
	public static final int MAX_EVENEMENTS_AFFICHES = 10;
	public static final int MAX_CASE_PAR_LIGNE = 10;
	public static final Dimension ITEM_TAILLE = new Dimension(32,32);
	public static final Dimension FENETRE_PRINCIPAL_DIMENSION = new Dimension(700,700);
	public static final Dimension FENETRE_COMBAT_DIMENSION = new Dimension(1000,1000);;

	public static final int PANEL_BAS_HAUTEUR = 120;		// Pour 2 barres d'inventaire
	public static final int PANEL_GAUCHE_LARGEUR = 180;
	public static final int PANEL_GAUCHE_MAX_HAUTEUR = 1470;	// Pour 8 persos principaux
	
	public static final Font PRESS_START_FONT = new Font("Press Start", Font.PLAIN, 10);
	public static final Font PRESS_START_FONT_MENU = new Font("Press Start", Font.PLAIN, 20);
	public static final Font PRESS_START_FONT_MENU_SELECTED = new Font("Press Start", Font.PLAIN, 23);
	public static final Font PRESS_START_FONT_TITRE = new Font("Press Start", Font.PLAIN, 30);
	public static final String SYMBOLE_PASSER_NEXT = ">>";

	public static final int MENU_HEIGHT = 250;
	public static final int MENU_WIDTH = 380;


}

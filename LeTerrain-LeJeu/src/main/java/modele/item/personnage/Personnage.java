package modele.item.personnage;

import java.util.List;

import javax.swing.ImageIcon;

import modele.item.personnage.action.ActionCombat;

public class Personnage {
	
	private String nom;
	private String prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;	
	private List<ActionCombat> actionsCombat;

}

package modele.item.personnage;

import java.util.List;

import javax.swing.ImageIcon;

import modele.item.personnage.action.ActionCombat;

public class Personnage {
	
	private String nom;
	private int vie;
	private int vieMax;
	private boolean mort;
	private String prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;	
	private List<ActionCombat> actionsCombat;
	
	
	public String getNom() {
		return nom;
	}
	
	public int getVieMax() {
		return vieMax;
	}
	
	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}
	
	public boolean isMort() {
		return mort;
	}

}

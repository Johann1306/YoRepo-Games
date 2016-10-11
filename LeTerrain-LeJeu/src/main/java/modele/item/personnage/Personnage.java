package modele.item.personnage;

import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

import modele.item.personnage.action.ActionCombat;

public class Personnage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nom;
	private boolean mort = false;
	private int vie;
	private int vieMax;
	private int mana;
	private int manaMax;
	private int nombreCharge;
	private int nombreChargeMax;
	private int vitesseCharge;
	private int bouclier;
	private String prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;	
	private List<ActionCombat> actionsCombat;
	private boolean aDejaJoue = false;
	
	public Personnage(String nom) {
		this.nom = nom;
	}
	
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

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}

	public int getManaMax() {
		return manaMax;
	}

	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	public int getNombreCharge() {
		return nombreCharge;
	}

	public void setNombreCharge(int nombreCharge) {
		this.nombreCharge = nombreCharge;
	}

	public int getNombreChargeMax() {
		return nombreChargeMax;
	}

	public void setNombreChargeMax(int nombreChargeMax) {
		this.nombreChargeMax = nombreChargeMax;
	}

	public int getVitesseCharge() {
		return vitesseCharge;
	}

	public void setVitesseCharge(int vitesseCharge) {
		this.vitesseCharge = vitesseCharge;
	}

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", vie=" + vie + "/" + vieMax + ", mort=" + mort + ", mana=" + mana
				+ "/" + manaMax + ", nombreCharge=" + nombreCharge + "/" + nombreChargeMax
				+ ", vitesseCharge=" + vitesseCharge + ", bouclier=" + bouclier + ", prenom=" + prenom
				+ ", surnomPrincipal=" + surnomPrincipal + ", surnoms=" + surnoms + ", particularitesPhysique="
				+ particularitesPhysique + ", particularitesSocial=" + particularitesSocial + ", phrasesPerso="
				+ phrasesPerso + ", photoPrincipal=" + photoPrincipal + ", photos=" + photos + ", actionsCombat="
				+ actionsCombat + "]";
	}

	public boolean isaDejaJoue() {
		return aDejaJoue;
	}

	public void setaDejaJoue(boolean aDejaJoue) {
		this.aDejaJoue = aDejaJoue;
	}

	public void ajouteUneCharge() {
		if (nombreCharge < nombreChargeMax) {
			nombreCharge = nombreCharge + 1;
		}
	}
	
}

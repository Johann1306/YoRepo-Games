package modele.item.personnage;

import java.io.Serializable;
import java.util.List;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.item.personnage.action.ActionCombat;

public class Personnage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nom;
	private String prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
	private boolean mort = false;
	private int vie;
	private int vieMax;
	private int mana;
	private int manaMax;
	private int nombreCharge;
	private int nombreChargeMax;
	private int vitesseCharge;
	private int bouclier;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;
	private List<ActionCombat> actionsCombat;
	private Competence competence;
	private boolean aDejaJoue = false;

	public Personnage(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isMort() {
		return mort;
	}

	public void setMort(boolean mort) {
		this.mort = mort;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public int getVieMax() {
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
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

	public int getBouclier() {
		return bouclier;
	}

	public void setBouclier(int bouclier) {
		this.bouclier = bouclier;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSurnomPrincipal() {
		return surnomPrincipal;
	}

	public void setSurnomPrincipal(String surnomPrincipal) {
		this.surnomPrincipal = surnomPrincipal;
	}

	public List<String> getSurnoms() {
		return surnoms;
	}

	public void setSurnoms(List<String> surnoms) {
		this.surnoms = surnoms;
	}

	public List<String> getParticularitesPhysique() {
		return particularitesPhysique;
	}

	public void setParticularitesPhysique(List<String> particularitesPhysique) {
		this.particularitesPhysique = particularitesPhysique;
	}

	public List<String> getParticularitesSocial() {
		return particularitesSocial;
	}

	public void setParticularitesSocial(List<String> particularitesSocial) {
		this.particularitesSocial = particularitesSocial;
	}

	public List<String> getPhrasesPerso() {
		return phrasesPerso;
	}

	public void setPhrasesPerso(List<String> phrasesPerso) {
		this.phrasesPerso = phrasesPerso;
	}

	public ImageIcon getPhotoPrincipal() {
		return photoPrincipal;
	}

	public void setPhotoPrincipal(ImageIcon photoPrincipal) {
		this.photoPrincipal = photoPrincipal;
	}

	public List<ImageIcon> getPhotos() {
		return photos;
	}

	public void setPhotos(List<ImageIcon> photos) {
		this.photos = photos;
	}

	public List<ActionCombat> getActionsCombat() {
		return actionsCombat;
	}

	public void setActionsCombat(List<ActionCombat> actionsCombat) {
		this.actionsCombat = actionsCombat;
	}

	public Competence getCompetence() {
		return competence;
	}

	public void setCompetence(Competence competence) {
		this.competence = competence;
	}

	public boolean isaDejaJoue() {
		return aDejaJoue;
	}

	public void setaDejaJoue(boolean aDejaJoue) {
		this.aDejaJoue = aDejaJoue;
	}

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", vie=" + vie + "/" + vieMax + ", mort=" + mort + ", mana=" + mana + "/"
				+ manaMax + ", nombreCharge=" + nombreCharge + "/" + nombreChargeMax + ", vitesseCharge="
				+ vitesseCharge + ", bouclier=" + bouclier + ", prenom=" + prenom + ", surnomPrincipal="
				+ surnomPrincipal + ", surnoms=" + surnoms + ", particularitesPhysique=" + particularitesPhysique
				+ ", particularitesSocial=" + particularitesSocial + ", phrasesPerso=" + phrasesPerso
				+ ", photoPrincipal=" + photoPrincipal + ", photos=" + photos + ", actionsCombat=" + actionsCombat
				+ "]";
	}

	public void ajouteUneCharge() {
		if (nombreCharge < nombreChargeMax) {
			nombreCharge = nombreCharge + 1;
		}
	}
}

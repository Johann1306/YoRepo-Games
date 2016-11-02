package modele.item.personnage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.personnage.action.ActionCombat;

public class Personnage implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nom;
	private String prenom;
	private String surnomPrincipal;
	private List<String> surnoms;
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

	private boolean mort = false;
	private boolean aDejaJoue = false;
	private int nombreEsquive = 0;
	private int niveauEsquive = 0;
	private int niveauEsquiveMax = 0;
	private int nombreBloque = 0;
	private Map<Personnage, Integer> tauntBy = new HashMap<Personnage, Integer>();

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

	public int getNombreEsquive() {
		return nombreEsquive;
	}

	public void setNombreEsquive(int nombreEsquive) {
		this.nombreEsquive = nombreEsquive;
	}

	public int getNiveauEsquive() {
		return niveauEsquive;
	}

	public void setNiveauEsquive(int niveauEsquive) {
		this.niveauEsquive = niveauEsquive;
	}

	public int getNiveauEsquiveMax() {
		return niveauEsquiveMax;
	}

	public void setNiveauEsquiveMax(int niveauEsquiveMax) {
		this.niveauEsquiveMax = niveauEsquiveMax;
	}

	public int getNombreBloque() {
		return nombreBloque;
	}

	public void setNombreBloque(int nombreBloque) {
		this.nombreBloque = nombreBloque;
	}

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", prenom=" + prenom + ", mort=" + mort + ", vie=" + vie + "/" + vieMax
				+ ", mana=" + mana + "/" + manaMax + ", charges=" + nombreCharge + "/" + nombreChargeMax
				+ ", vitesseCharge=" + vitesseCharge + ", bouclier=" + bouclier + ", esquive=" + nombreEsquive + "(" + niveauEsquive + "/" + niveauEsquiveMax + ")" + ", surnomPrincipal=" + surnomPrincipal
				+ ", surnoms=" + surnoms + ", particularitesPhysique=" + particularitesPhysique
				+ ", particularitesSocial=" + particularitesSocial + ", phrasesPerso=" + phrasesPerso
				+ ", photoPrincipal=" + photoPrincipal + ", photos=" + photos + ", actionsCombat=" + actionsCombat
				+ "]";
	}

	public void ajouteUneCharge() {
		if (nombreCharge < nombreChargeMax) {
			nombreCharge = nombreCharge + 1;
		}
	}

	public Map<Personnage, Integer> getTauntBy() {
		return tauntBy;
	}


}

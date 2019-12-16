package modele.item.personnage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.competence.PersoStat;
import modele.item.Item;
import modele.item.ItemType;
import modele.item.arme.Arme;
import modele.item.personnage.action.ActionCombat;

public class Personnage extends Item implements Serializable {

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
	private ImageIcon photoCombat;
	private List<ImageIcon> photos;
	private List<ActionCombat> actionsCombat;
	private Competence competence;
	private Map<Personnage, Aura> auras;
	private Arme arme;

	private boolean mort = false;
	private boolean aDejaJoue = false;
	private int nombreEsquive = 0;
	private int niveauEsquive = 0;
	private int niveauEsquiveMax = 0;
	private int nombreBloque = 0;
	private Map<Personnage, Integer> tauntBy = new HashMap<Personnage, Integer>();

	public Personnage(String prenom, String nom, boolean disponible) {
		super(0, prenom, "informations", null, null, null, PersoPrenom.GROUPE, ItemType.PERSONNAGE, disponible);
		this.prenom = prenom;
		this.nom = nom;
		this.auras = new HashMap<Personnage, Aura>();
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

	public ImageIcon getPhotoCombat() {
		return photoCombat;
	}

	public void setPhotoCombat(ImageIcon photoCombat) {
		this.photoCombat = photoCombat;
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

	public Map<Personnage, Integer> getTauntBy() {
		return tauntBy;
	}

	public Map<Personnage, Aura> getAuras() {
		return auras;
	}

	public void setAuras(Map<Personnage, Aura> auras) {
		this.auras = auras;
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", prenom=" + prenom + ", mort=" + mort + ", vie=" + vie + "/" + vieMax
				+ ", mana=" + mana + "/" + manaMax + ", charges=" + nombreCharge + "/" + nombreChargeMax
				+ ", vitesseCharge=" + vitesseCharge + ", bouclier=" + bouclier + ", esquive=" + nombreEsquive + "("
				+ niveauEsquive + "/" + niveauEsquiveMax + ")" + ", surnomPrincipal=" + surnomPrincipal + ", surnoms="
				+ surnoms + ", particularitesPhysique=" + particularitesPhysique + ", particularitesSocial="
				+ particularitesSocial + ", phrasesPerso=" + phrasesPerso + ", photoPrincipal=" + photoPrincipal
				+ ", photos=" + photos + ", actionsCombat=" + actionsCombat + "]";
	}

	public void ajouteUneCharge() {
		if (nombreCharge < nombreChargeMax) {
			nombreCharge = nombreCharge + 1;
		}
	}

	public void enleveAuras() {
		// Pour chaque Aura
		for (Aura aura : auras.values()) {
			int valeurAjoutee = aura.getValeurAjoutee();
			PersoStat stat = aura.getStat();
			Map<PersoStat, Integer> stats = competence.getStats();
			Integer valeurDeBase = stats.get(stat);
			// On retire la valeur de l'aura pour la stat donne
			stats.put(stat, valeurDeBase - valeurAjoutee);
		}
		// On nettoie la map
		auras.clear();
	}

	private void enleveAura(Personnage lanceur) {
		Aura aura = auras.get(lanceur);
		int valeurAjoutee = aura.getValeurAjoutee();
		PersoStat stat = aura.getStat();
		Map<PersoStat, Integer> stats = competence.getStats();
		Integer valeurDeBase = stats.get(stat);
		// On retire la valeur de l'aura pour la stat donne
		stats.put(stat, valeurDeBase - valeurAjoutee);		
		auras.remove(lanceur);
	}
	
	public void ajouteAura(Personnage lanceur, Aura aura) {

		// Si la cible a deja une aura sur cette stat
		if (auras.containsKey(lanceur)) {
			// On enleve l'ancienne aura
			enleveAura(lanceur);
		}
		// On ajoute la valeur de l'aura a la stat donne
		int valeurAAjouter = aura.getValeur();
		PersoStat statAModifier = aura.getStat();
		Map<PersoStat, Integer> stats = competence.getStats();
		Integer valeurDeBase = stats.get(statAModifier);
		int nouvelleValeur = valeurDeBase + valeurAAjouter;
		// On plafonne a 100
		if (nouvelleValeur > 100) {
			int valeurAjoutee = 100 - valeurDeBase;
			aura.setValeurAjoutee(valeurAjoutee);
			nouvelleValeur = 100;
		} else {
			aura.setValeurAjoutee(valeurAAjouter);
		}
		stats.put(statAModifier, nouvelleValeur);

		// On ajoute le lanceur et l'aura a la map
		auras.put(lanceur, aura);
	}

	public void addAllCompetences(int valeur) {
		for (PersoStat persoStat : competence.getStats().keySet()) {
			int nouvelleValeur = competence.getStats().get(persoStat) + valeur;
			if (nouvelleValeur > 100) {
				nouvelleValeur = 100;
			}
			competence.getStats().put(persoStat, nouvelleValeur);
		}
	}

}

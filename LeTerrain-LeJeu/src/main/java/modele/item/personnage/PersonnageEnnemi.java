package modele.item.personnage;

import java.util.List;

import javax.swing.ImageIcon;

import modele.item.personnage.action.ActionCombat;

public class PersonnageEnnemi extends Personnage {

	private static final long serialVersionUID = 1L;

	private int vie;
	private int vieMax;
	private int mana;
	private int manaMax;
	private int charge;
	private int chargeMax;
	private List<String> particularitesPhysique;
	private List<String> particularitesSocial;
	private List<String> phrasesPerso;
	// TODO private String photoPath;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;
	private List<ActionCombat> actionsCombat;
	private EnnemiType ennemiType;

	public PersonnageEnnemi(String nom, int vieMax, int manaMax, int chargeMax, List<String> particularitesPhysique,
			List<String> particularitesSocial, List<String> phrasesPerso, ImageIcon photoPrincipal,
			List<ImageIcon> photos, List<ActionCombat> actionsCombat, EnnemiType ennemiType) {
		super(nom);
		this.vieMax = vieMax;
		this.vie = vieMax;
		this.manaMax = manaMax;
		this.mana = manaMax;
		this.chargeMax = chargeMax;
		this.charge = 0;
		this.particularitesPhysique = particularitesPhysique;
		this.particularitesSocial = particularitesSocial;
		this.phrasesPerso = phrasesPerso;
		this.photoPrincipal = photoPrincipal;
		this.photos = photos;
		this.actionsCombat = actionsCombat;
		this.ennemiType = ennemiType;
	}

	public int getVie() {
		return vie;
	}
	
	public void setVie(int vie) {
		this.vie = vie;
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

	public int getVieMax() {
		return vieMax;
	}

	public void setVieMax(int vieMax) {
		this.vieMax = vieMax;
	}

	public int getManaMax() {
		return manaMax;
	}

	public void setManaMax(int manaMax) {
		this.manaMax = manaMax;
	}

	public int getChargeMax() {
		return chargeMax;
	}

	public void setChargeMax(int chargeMax) {
		this.chargeMax = chargeMax;
	}

	public EnnemiType getEnnemiType() {
		return ennemiType;
	}

	public void setEnnemiType(EnnemiType ennemiType) {
		this.ennemiType = ennemiType;
	}

	public List<ActionCombat> getActionsCombat() {
		return actionsCombat;
	}

	public void setActionsCombat(List<ActionCombat> actionsCombat) {
		this.actionsCombat = actionsCombat;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}
	
}

package modele.item.personnage;

import java.util.List;

import javax.swing.ImageIcon;

import modele.competence.Competence;
import modele.item.personnage.action.ActionCombat;

public class PersonnageEnnemi extends Personnage {

	private static final long serialVersionUID = 1L;

	// TODO private String photoPath;
	private ImageIcon photoPrincipal;
	private List<ImageIcon> photos;
	private EnnemiType ennemiType;

	public PersonnageEnnemi(String nom, int vieMax, int manaMax, int chargeMax, List<String> particularitesPhysique,
			List<String> particularitesSocial, List<String> phrasesPerso, ImageIcon photoPrincipal,
			List<ImageIcon> photos, List<ActionCombat> actionsCombat, EnnemiType ennemiType, Competence competence) {
		super(nom, nom, true);
		this.setVieMax(vieMax);
		this.setVie(vieMax);
		this.setManaMax(manaMax);
		this.setMana(manaMax);
		this.setNombreChargeMax(competence.getNervosite()/20);
		this.setNombreCharge(0);
		this.setBouclier(0);
		this.setVitesseCharge(50);
		this.setParticularitesPhysique(particularitesPhysique);
		this.setParticularitesSocial(particularitesSocial);
		this.setPhrasesPerso(phrasesPerso);
		this.photoPrincipal = photoPrincipal;
		this.photos = photos;
		this.setActionsCombat(actionsCombat);
		this.ennemiType = ennemiType;
		this.setCompetence(competence);
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

	public EnnemiType getEnnemiType() {
		return ennemiType;
	}

	public void setEnnemiType(EnnemiType ennemiType) {
		this.ennemiType = ennemiType;
	}
	
}

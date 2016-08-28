package modele.item;

import java.util.List;

import modele.item.personnage.PersoNom;

public class Item implements Disponible {

	private int id;
	private String nom;
	private String informations;
	private List<String> imagePaths;
	private List<String> sonPaths;
	private List<String> videoPaths;
	private PersoNom proprietaire;
	private ItemType type;
	private boolean isDisponible = false;
	
	public Item(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths, List<String> videoPaths, PersoNom proprietaire, ItemType type,  boolean isDisponible) {
		super();
		this.id = id;
		this.nom = nom;
		this.informations = informations;
		this.imagePaths = imagePaths;
		this.sonPaths = sonPaths;
		this.videoPaths = videoPaths;
		this.proprietaire = proprietaire;
		this.type = type;
		this.isDisponible = isDisponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getInformations() {
		return informations;
	}

	public void setInformations(String informations) {
		this.informations = informations;
	}

	public List<String> getImagePath() {
		return imagePaths;
	}
	
	public List<String> getSonPath() {
		return sonPaths;
	}
	
	public PersoNom getProprietaire() {
		return proprietaire;
	}
	
	public boolean isDisponible() {
		return isDisponible;
	}

	public void setDisponible(boolean isDisponible) {
		this.isDisponible = isDisponible;
	}

	public ItemType getType() {
		return type;
	}

	public List<String> getVideoPaths() {
		return videoPaths;
	}


}

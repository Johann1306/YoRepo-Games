package modele.item;

import java.io.Serializable;
import java.util.List;

import modele.item.personnage.PersoPrenom;

public class Item implements Disponible, Consommable, Utilisable, Ameliorable, Serializable { 

	private static final long serialVersionUID = 1L;

	private int id;
	private String nom;
	private String informations;
	private List<String> imagePaths;
	private List<String> sonPaths;
	private List<String> videoPaths;
	private PersoPrenom proprietaire;
	private ItemType type;
	private boolean isDisponible = false;
	
	public Item(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths, List<String> videoPaths, PersoPrenom proprietaire, ItemType type, boolean isDisponible) {
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

	public void setImagePaths(List<String> imagePaths) {
		this.imagePaths = imagePaths;
	}
	
	public List<String> getSonPath() {
		return sonPaths;
	}
	
	public PersoPrenom getProprietaire() {
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

	@Override
	public boolean consommeItem() {
		// TODO consomme Item
		// TODO test possibilite de consommer l'item
		
		return true;
	}

	@Override
	public boolean utiliseItem() {
		// TODO test possibilite d utiliser l'item
		return true;
	}

	@Override
	public boolean amelioreItem() {
		// TODO test possibilite d ameliorer l'item
		return true;
	}

	public boolean isConsommable() {
		boolean isConsommable = false;
		ItemType typeItem = this.getType();
		if ((typeItem == ItemType.POTION_VIE_25) || (typeItem == ItemType.POTION_VIE_50) || (typeItem == ItemType.POTION_VIE_75) || (typeItem == ItemType.POTION_VIE_100) || 
				(typeItem == ItemType.POTION_MANA_25) || (typeItem == ItemType.POTION_MANA_50) || (typeItem == ItemType.POTION_MANA_75) || (typeItem == ItemType.POTION_MANA_100) || 
				(typeItem == ItemType.BONUS_STAT_CHANCE_5) || (typeItem == ItemType.BONUS_STAT_CHANCE_10) || (typeItem == ItemType.BONUS_STAT_CHANCE_20) ||
				(typeItem == ItemType.BONUS_STAT_EXPLOIT_5) || (typeItem == ItemType.BONUS_STAT_EXPLOIT_10) || (typeItem == ItemType.BONUS_STAT_EXPLOIT_20) ||
				(typeItem == ItemType.BONUS_STAT_TECHNIQUE_5) || (typeItem == ItemType.BONUS_STAT_TECHNIQUE_10) || (typeItem == ItemType.BONUS_STAT_TECHNIQUE_20) ||
				(typeItem == ItemType.BONUS_STAT_ENDURANCE_5) || (typeItem == ItemType.BONUS_STAT_ENDURANCE_10) || (typeItem == ItemType.BONUS_STAT_ENDURANCE_20) ||
				(typeItem == ItemType.BONUS_STAT_RAPIDITE_5) || (typeItem == ItemType.BONUS_STAT_RAPIDITE_10) || (typeItem == ItemType.BONUS_STAT_RAPIDITE_20) ||
				(typeItem == ItemType.BONUS_STAT_RESISTANCE_5) || (typeItem == ItemType.BONUS_STAT_RESISTANCE_10) || (typeItem == ItemType.BONUS_STAT_RESISTANCE_20) ||
				(typeItem == ItemType.BONUS_STAT_AGILITE_5) || (typeItem == ItemType.BONUS_STAT_AGILITE_10) || (typeItem == ItemType.BONUS_STAT_AGILITE_20) ||
				(typeItem == ItemType.BONUS_STAT_INTELLIGENCE_5) || (typeItem == ItemType.BONUS_STAT_INTELLIGENCE_10) || (typeItem == ItemType.BONUS_STAT_INTELLIGENCE_20) ||
				(typeItem == ItemType.BONUS_STAT_NERVOSITE_5) || (typeItem == ItemType.BONUS_STAT_NERVOSITE_10) || (typeItem == ItemType.BONUS_STAT_NERVOSITE_20) ||		
				(typeItem == ItemType.POTION_COMBAT)) {
			isConsommable = true;
		}
		return isConsommable;
	}

}

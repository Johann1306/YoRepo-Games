package modele.item.carte;

import java.io.Serializable;
import java.util.List;

import modele.item.Item;
import modele.item.ItemType;
import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;

public class Carte extends Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Lieu> lieux;

	public Carte(int id, String nom, String informations, List<String> imagePaths, List<String> sonPaths,
			List<String> videoPaths, PersoPrenom proprietaire, boolean isDisponible, List<Lieu> lieux) {
		super(id, nom, informations, imagePaths, sonPaths, videoPaths, proprietaire, ItemType.MAP, isDisponible);
		this.lieux = lieux;
	}

	public List<Lieu> getLieux() {
		return lieux;
	}
	
}

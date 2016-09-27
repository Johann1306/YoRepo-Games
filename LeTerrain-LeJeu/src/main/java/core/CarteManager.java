package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.carte.Carte;
import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;

public class CarteManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Carte> cartes;
	private List<Carte> cartesDisponible;
	private List<Carte> cartesIndisponible;
	
	public void initialise(LieuManager lieuManager) {
		
		// Chargement des cartes
		cartes = new ArrayList<Carte>();
		cartesDisponible = new ArrayList<Carte>();
		cartesIndisponible = new ArrayList<Carte>();
		
		List<String> imagePaths1 = new ArrayList<String>();
		String imagePath1 = "image/carte/montfermeil.png";
		imagePaths1.add(imagePath1);

		List<String> sonPaths1 = new ArrayList<String>();
		String sonPath1 = "src/main/resources/son/23-ending.mp3";
		sonPaths1.add(sonPath1);

		List<String> videoPaths1 = new ArrayList<String>();
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		videoPaths1.add(videoPath1);
		
		List<Lieu> lieux = lieuManager.getLieux();
		Carte montfermeil = new Carte(1, "Franceville", "info", imagePaths1, sonPaths1, videoPaths1, PersoPrenom.GROUPE, true, lieux);
		
		cartes.add(montfermeil);
		
		cartesDisponible.addAll(cartes);
	}
	
	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public List<Carte> getCartesDisponible() {
		return cartesDisponible;
	}

	public void setCartesDisponible(List<Carte> cartesDisponible) {
		this.cartesDisponible = cartesDisponible;
	}

	public List<Carte> getCartesIndisponible() {
		return cartesIndisponible;
	}

	public void setCartesIndisponible(List<Carte> cartesIndisponible) {
		this.cartesIndisponible = cartesIndisponible;
	}
}

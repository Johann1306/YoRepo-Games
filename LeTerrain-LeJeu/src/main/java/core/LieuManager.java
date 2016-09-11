package core;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;

public class LieuManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Lieu> lieux;
	private List<Lieu> lieuxDisponible;
	private List<Lieu> lieuxIndisponible;
	private static int id = 0;
	
	public void initialise() {
		
		// Chargement de tous les lieux
		
		lieux = new ArrayList<Lieu>();
		lieuxDisponible = new ArrayList<Lieu>();
		lieuxIndisponible = new ArrayList<Lieu>();
		
		String itemIconPath = "src/main/resources/image/defaut/defautLieu.png";
		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add(itemIconPath);
		
		String sonIconPath = "src/main/resources/image/son/05.zelda-kakariko-village.mp3";
		List<String> sonPaths = new ArrayList<String>();
		sonPaths.add(sonIconPath);
		
//		ImageIcon backgroundYo = new ImageIcon("src/main/resources/image/lieu/MaisonYo.png");
//		ImageIcon backgroundNico = new ImageIcon("src/main/resources/image/lieu/MaisonNicoEtTom.png");
//		ImageIcon backgroundTom = new ImageIcon("src/main/resources/image/lieu/MaisonNicoEtTom.png");
//		ImageIcon backgroundPip = new ImageIcon("src/main/resources/image/lieu/MaisonPip.png");
//		ImageIcon backgroundYa = new ImageIcon("src/main/resources/image/lieu/MaisonYa.png");
//		ImageIcon backgroundAli = new ImageIcon("src/main/resources/image/lieu/MaisonYo.png");
//		ImageIcon backgroundGuy = new ImageIcon("src/main/resources/image/lieu/MaisonYo.png");
//		ImageIcon backgroundJo = new ImageIcon("src/main/resources/image/lieu/MaisonYo.png");
//		ImageIcon backgroundEcole = new ImageIcon("src/main/resources/image/lieu/Ecole.png");
		
		Lieu chezYo = new Lieu(incrementeId(), "Chez Yo", "La maison de Johann", imagePaths , sonPaths, null, PersoPrenom.JOHANN, new Point(200, 200), "src/main/resources/image/lieu/MaisonYo.png", null, false);
		Lieu chezNico = new Lieu(incrementeId(), "Chez Nico", "La maison de Nicolas", imagePaths , sonPaths, null, PersoPrenom.NICOLAS, new Point(200, 200), "src/main/resources/image/lieu/MaisonNicoEtTom.png", null, false);
		Lieu chezTom = new Lieu(incrementeId(), "Chez Tom", "La maison de Thomas", imagePaths , sonPaths, null, PersoPrenom.THOMAS, new Point(200, 200), "src/main/resources/image/lieu/MaisonNicoEtTom.png", null, false);
		Lieu chezPip = new Lieu(incrementeId(), "Chez Pip", "La maison de Pierre", imagePaths , sonPaths, null, PersoPrenom.PIERRE, new Point(200, 200), "src/main/resources/image/lieu/MaisonPip.png", null, false);
		Lieu chezYa = new Lieu(incrementeId(), "Chez Ya", "La maison de Yannick", imagePaths , sonPaths, null, PersoPrenom.YANNICK, new Point(200, 200), "src/main/resources/image/lieu/MaisonYa.png", null, false);
		Lieu chezAli = new Lieu(incrementeId(), "Chez Ali", "La maison de Ali", imagePaths , sonPaths, null, PersoPrenom.ALI, new Point(200, 200), "src/main/resources/image/lieu/MaisonYo.png", null, false);
		Lieu chezGuy = new Lieu(incrementeId(), "Chez Guy", "La maison de Guillaume", imagePaths , sonPaths, null, PersoPrenom.GUILLAUME, new Point(200, 200), "src/main/resources/image/lieu/MaisonYo.png", null, false);
		Lieu chezJo = new Lieu(incrementeId(), "Chez Russ", "La maison de Jonathan", imagePaths , sonPaths, null, PersoPrenom.JONATHAN, new Point(200, 200), "src/main/resources/image/lieu/MaisonYo.png", null, false);
		Lieu ecole = new Lieu(incrementeId(), "A l'école", "L'école élémentaire Jules Fery", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(200, 200), "src/main/resources/image/lieu/Ecole.png", null, false);
			
		lieux.add(chezYo);
		lieux.add(chezNico);
		lieux.add(chezTom);
		lieux.add(chezPip);
		lieux.add(chezYa);
		lieux.add(chezAli);
		lieux.add(chezGuy);
		lieux.add(chezJo);
		lieux.add(ecole);
		
		// On suppose que tous les lieux sont indisponibles au depart
		lieuxIndisponible.addAll(lieux);
	}
	
	private int incrementeId() {
		id = id +1;
		return id;
	}

	public List<Lieu> getLieuxDisponible() {
		refreshLieux();
		return lieuxDisponible;
	}

	public void setLieuxDisponible(List<Lieu> lieuxDisponible) {
		this.lieuxDisponible = lieuxDisponible;
	}

	public List<Lieu> getLieuxIndisponible() {
		refreshLieux();
		return lieuxIndisponible;
	}

	public void setLieuxIndisponible(List<Lieu> lieuxIndisponible) {
		this.lieuxIndisponible = lieuxIndisponible;
	}

	public Lieu getDomicileByNom(PersoPrenom prenom) {
		for (Lieu lieu : lieux) {
			if (lieu.getProprietaire().equals(prenom)) {
				return lieu;
			}
		}		
		return null;
	}
	
	public void refreshLieux() {
		List<Lieu> temp = new ArrayList<>(lieuxIndisponible);
		for (Lieu lieu : temp) {
			if (lieu.isDisponible()) {
				lieuxDisponible.add(lieu);
				lieuxIndisponible.remove(lieu);
			}
		}
	}

}

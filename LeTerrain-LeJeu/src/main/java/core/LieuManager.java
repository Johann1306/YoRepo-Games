package core;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;
import modele.item.poi.Poi;

public class LieuManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Lieu> lieux;
	private List<Lieu> lieuxDisponible;
	private List<Lieu> lieuxIndisponible;
	private int id = 0;
	
	public void initialise(PoiManager poiManager) {
		
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
		
		// TODO 
		List<Poi> pois = poiManager.getPois();
		List<Poi> pois1 = new ArrayList<Poi>();
		List<Poi> pois2 = new ArrayList<Poi>();
		List<Poi> pois3 = new ArrayList<Poi>();
		List<Poi> pois4 = new ArrayList<Poi>();
		Poi poi1 = poiManager.getPoisByNom("poi1");
		Poi poi2 = poiManager.getPoisByNom("poi2");
		Poi poi3 = poiManager.getPoisByNom("poi3");
		Poi poi4 = poiManager.getPoisByNom("poi4");
		pois1.add(poi1);
		pois2.add(poi2);
		pois3.add(poi3);
		pois4.add(poi4);
		
		Lieu chezYo = new Lieu(incrementeId(), "Chez johann", "La maison de Johann", imagePaths , sonPaths, null, PersoPrenom.JOHANN, new Point(200, 200), "src/main/resources/image/lieu/MaisonYo.png", pois1, true);
		Lieu chezNico = new Lieu(incrementeId(), "Chez nicolas", "La maison de Nicolas", imagePaths , sonPaths, null, PersoPrenom.NICOLAS, new Point(220, 200), "src/main/resources/image/lieu/MaisonNicoEtTom.png", pois2, true);
		Lieu chezTom = new Lieu(incrementeId(), "Chez thomas", "La maison de Thomas", imagePaths , sonPaths, null, PersoPrenom.THOMAS, new Point(200, 220), "src/main/resources/image/lieu/MaisonNicoEtTom.png", pois3, true);
		Lieu chezPip = new Lieu(incrementeId(), "Chez pierre", "La maison de Pierre", imagePaths , sonPaths, null, PersoPrenom.PIERRE, new Point(200, 240), "src/main/resources/image/lieu/MaisonPip.png", pois4, true);
		Lieu chezYa = new Lieu(incrementeId(), "Chez yannick", "La maison de Yannick", imagePaths , sonPaths, null, PersoPrenom.YANNICK, new Point(200, 260), "src/main/resources/image/lieu/MaisonYa.png", pois, true);
		Lieu chezAli = new Lieu(incrementeId(), "Chez ali", "La maison de Ali", imagePaths , sonPaths, null, PersoPrenom.ALI, new Point(-260, -200), "src/main/resources/image/lieu/MaisonYo.png", pois, true);
		Lieu chezGuy = new Lieu(incrementeId(), "Chez guillaume", "La maison de Guillaume", imagePaths , sonPaths, null, PersoPrenom.GUILLAUME, new Point(-240, 200), "src/main/resources/image/lieu/MaisonYo.png", pois, true);
		Lieu chezJo = new Lieu(incrementeId(), "Chez jonathan", "La maison de Jonathan", imagePaths , sonPaths, null, PersoPrenom.JONATHAN, new Point(200, -280), "src/main/resources/image/lieu/MaisonYo.png", pois, true);
		Lieu ecole = new Lieu(incrementeId(), "A l'école", "L'école élémentaire Jules Fery", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(0, 0), "src/main/resources/image/lieu/Ecole.png", new ArrayList<Poi>(), true);
			
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

	public List<Lieu> getLieux() {
		return lieux;
	}
	
	public List<Lieu> getLieuxDisponible() {
		refreshLieux();
		return lieuxDisponible;
	}

	public List<Lieu> getLieuxIndisponible() {
		refreshLieux();
		return lieuxIndisponible;
	}

	public Lieu getDomicileByNom(PersoPrenom prenom) {
		for (Lieu lieu : lieux) {
			if (lieu.getProprietaire().equals(prenom)) {
				return lieu;
			}
		}		
		return null;
	}
	
	public Lieu getLieuByNom(String nomLieu) {
		for (Lieu lieu : lieux) {
			if (lieu.getNom().equals(nomLieu)) {
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

package core;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import modele.item.lieu.Lieu;
import modele.item.personnage.PersoPrenom;
import modele.item.personnage.PersonnagePrincipal;
import modele.item.poi.Poi;
import modele.location.Location;

public class LieuManager implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Lieu> lieux;
	private List<Lieu> lieuxDisponible;
	private List<Lieu> lieuxIndisponible;
	private int id = 0;
	
	public void initialise(PoiManager poiManager, PersonnageManager personnageManager) {
		
		// Chargement de tous les lieux
		
		lieux = new ArrayList<Lieu>();
		lieuxDisponible = new ArrayList<Lieu>();
		lieuxIndisponible = new ArrayList<Lieu>();
		
		String itemIconPath = "image/defaut/defautLieu.png";
		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add(itemIconPath);
		
		String sonIconPath = "image/son/05.zelda-kakariko-village.mp3";
		List<String> sonPaths = new ArrayList<String>();
		sonPaths.add(sonIconPath);
		
		// TODO 
		List<Poi> pois = poiManager.getPois();
		List<Poi> pois1 = new ArrayList<Poi>();
		List<Poi> pois2 = new ArrayList<Poi>();
		List<Poi> pois3 = new ArrayList<Poi>();
		List<Poi> pois4 = new ArrayList<Poi>();
		List<Poi> pois5 = new ArrayList<Poi>();
		List<Poi> pois6 = new ArrayList<Poi>();
		List<Poi> pois7 = new ArrayList<Poi>();
		List<Poi> pois8 = new ArrayList<Poi>();
		Poi poiEcole1 = poiManager.getPoisById(1);
		Poi poiEcole2 = poiManager.getPoisById(2);
		Poi poiEcole3 = poiManager.getPoisById(3);
		Poi poiEcole4 = poiManager.getPoisById(4);
		Poi poiEcole5 = poiManager.getPoisById(5);

		Poi poiTerrain1 = poiManager.getPoisById(100);
		Poi poiTerrain2 = poiManager.getPoisById(101);

		Poi poiChezYo1 = poiManager.getPoisById(201);

		List<Poi> poisEcole = new ArrayList<Poi>();
		List<Poi> poisTerrain = new ArrayList<Poi>();
		List<Poi> poisChezYo = new ArrayList<Poi>();
		
		poisEcole.add(poiEcole1);
		poisEcole.add(poiEcole2);
		poisEcole.add(poiEcole3);
		poisEcole.add(poiEcole4);
		poisEcole.add(poiEcole5);
		poisTerrain.add(poiTerrain1);		
		poisTerrain.add(poiTerrain2);		
		poisChezYo.add(poiChezYo1);
		
		// (X,Y) en partant du haut-gauche
		// Pour une Map (2000 x 1000)
		// X (min= 0, max= 1800)
		// Y (min= 56, max= 980)
		Lieu chezYo = new Lieu(1, "Chez johann", "La maison de Johann", imagePaths , sonPaths, null, PersoPrenom.Johann, new Point(600, 56), "image/lieu/MaisonYo.png", poisChezYo, false);
		Lieu chezPip = new Lieu(2, "Chez pierre", "La maison de Pierre", imagePaths , sonPaths, null, PersoPrenom.Pierre, new Point(200, 400), "image/lieu/MaisonPip.png", pois2, false);
		Lieu chezNico = new Lieu(3, "Chez nicolas", "La maison de Nicolas", imagePaths , sonPaths, null, PersoPrenom.Nicolas, new Point(0, 56), "image/lieu/MaisonNicoEtTom.png", pois3, false);
		Lieu chezYa = new Lieu(4, "Chez yannick", "La maison de Yannick", imagePaths , sonPaths, null, PersoPrenom.Yannick, new Point(500, 300), "image/lieu/MaisonYa.png", pois4, false);
		Lieu chezTom = new Lieu(5, "Chez thomas", "La maison de Thomas", imagePaths , sonPaths, null, PersoPrenom.Thomas, new Point(200, 300), "image/lieu/MaisonNicoEtTom.png", pois5, false);
		Lieu chezAli = new Lieu(6, "Chez ali", "La maison de Ali", imagePaths , sonPaths, null, PersoPrenom.Ali, new Point(100, 500), "image/lieu/MaisonYo.png", pois6, false);
		Lieu chezGuy = new Lieu(7, "Chez guillaume", "La maison de Guillaume", imagePaths , sonPaths, null, PersoPrenom.Guillaume, new Point(500, 980), "image/lieu/MaisonYo.png", pois7, false);
		Lieu chezJo = new Lieu(8, "Chez jonathan", "La maison de Jonathan", imagePaths , sonPaths, null, PersoPrenom.Jonathan, new Point(1800, 950), "image/lieu/MaisonYo.png", pois8, false);
		Lieu ecole = new Lieu(9, "A l'école", "L'école élémentaire Jules Fery", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(500, 500), "image/lieu/Ecole.png", poisEcole, false);
		Lieu terrain = new Lieu(10, "Le terrain", "Le site aux moults péripéties", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(800, 800), "image/lieu/Terrain.png", poisTerrain, false);
				
		lieux.add(chezYo);
		lieux.add(chezNico);
		lieux.add(chezTom);
		lieux.add(chezPip);
		lieux.add(chezYa);
		lieux.add(chezAli);
		lieux.add(chezGuy);
		lieux.add(chezJo);
		lieux.add(ecole);
		lieux.add(terrain);
		
		// On initialise le lieu de depart de chaque personnage
		List<PersonnagePrincipal> groupe = personnageManager.getLeGroupe().getPersos();
		for (PersonnagePrincipal personnage : groupe) {
			String prenom = personnage.getPrenom();
			if (prenom.equals(PersoPrenom.Johann.name())) {
				personnage.setDomicile(chezYo);
				personnage.setLocation(new Location(chezYo, chezYo.getPosition()));
			} else if (prenom.equals(PersoPrenom.Nicolas.name())) {
				personnage.setDomicile(chezNico);
				personnage.setLocation(new Location(chezNico, chezNico.getPosition()));
			} else if (prenom.equals(PersoPrenom.Pierre.name())) {
				personnage.setDomicile(chezPip);
				personnage.setLocation(new Location(chezPip, chezPip.getPosition()));
			} else if (prenom.equals(PersoPrenom.Yannick.name())) {
				personnage.setDomicile(chezYa);
				personnage.setLocation(new Location(chezYa, chezYa.getPosition()));
			} else if (prenom.equals(PersoPrenom.Thomas.name())) {
				personnage.setDomicile(chezTom);
				personnage.setLocation(new Location(chezTom, chezTom.getPosition()));
			} else if (prenom.equals(PersoPrenom.Ali.name())) {
				personnage.setDomicile(chezAli);
				personnage.setLocation(new Location(chezAli, chezAli.getPosition()));
			} else if (prenom.equals(PersoPrenom.Guillaume.name())) {
				personnage.setDomicile(chezGuy);
				personnage.setLocation(new Location(chezGuy, chezGuy.getPosition()));
			} else if (prenom.equals(PersoPrenom.Jonathan.name())) {
				personnage.setDomicile(chezJo);
				personnage.setLocation(new Location(chezJo, chezJo.getPosition()));
			}  
		}
		
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
	
	public Lieu getLieuById(int idLieu) {
		for (Lieu lieu : lieux) {
			if (lieu.getId() == idLieu) {
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

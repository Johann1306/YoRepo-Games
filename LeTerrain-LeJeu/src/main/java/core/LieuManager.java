package core;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	public void initialise(PoiManager poiManager, PersonnageManager personnageManager) {
		
		// Chargement de tous les lieux
		
		lieux = new ArrayList<Lieu>();
		lieuxDisponible = new ArrayList<Lieu>();
		lieuxIndisponible = new ArrayList<Lieu>();
		
		String itemIconPath = "image/defaut/defautLieu.png";
		List<String> imagePaths = new ArrayList<String>();
		imagePaths.add(itemIconPath);
		
		String sonIconPath = "son/05.zelda-kakariko-village.mp3";
		List<String> sonPaths = new ArrayList<String>();
		sonPaths.add(sonIconPath);
		
		// TODO faire tous les pois
		Poi poiEcoleClasse = poiManager.getPoisById(1);
		Poi poiEcoleCour = poiManager.getPoisById(2);
		Poi poiEcolePreau = poiManager.getPoisById(3);
		Poi poiEcoleCantine = poiManager.getPoisById(4);
		Poi poiEcoleSalleLecture = poiManager.getPoisById(5);

		Poi poiTerrainCabane = poiManager.getPoisById(100);
		Poi poiTerrainTerrain = poiManager.getPoisById(101);

		Poi poiChezYo_portail = poiManager.getPoisById(200);
		Poi poiChezYo_salon = poiManager.getPoisById(201);
		Poi poiChezYo_garage = poiManager.getPoisById(202);
		Poi poiChezYo_chambre = poiManager.getPoisById(203);
		Poi poiChezYo_jardin = poiManager.getPoisById(204);
		Poi poiChezYo_salleDeBain = poiManager.getPoisById(205);

		Poi poiChezRuss_salon = poiManager.getPoisById(1000);
		Poi poiChezRuss_portail = poiManager.getPoisById(1001);
		Poi poiChezRuss_jardin = poiManager.getPoisById(1002);
		Poi poiChezRuss_salleDeBain = poiManager.getPoisById(1003);
		
		Poi poiChezGuy_portail = poiManager.getPoisById(1100);
		Poi poiChezGuy_salon = poiManager.getPoisById(1101);
		
		Poi poiChezAli_portail = poiManager.getPoisById(1200);
		Poi poiChezAli_salon = poiManager.getPoisById(1201);
		Poi poiChezAli_chambre = poiManager.getPoisById(1202);
		
		Poi poiChezYa_portail = poiManager.getPoisById(1300);
		Poi poiChezYa_salon = poiManager.getPoisById(1301);
		Poi poiChezYa_jardin = poiManager.getPoisById(1302);
		Poi poiChezYa_chambre = poiManager.getPoisById(1303);
		
		Poi poiChezTom_portail = poiManager.getPoisById(1400);
		Poi poiChezTom_salon = poiManager.getPoisById(1401);
		Poi poiChezTom_jardin = poiManager.getPoisById(1402);

		Poi poiChezPip_portail = poiManager.getPoisById(1500);
		Poi poiChezPip_salon = poiManager.getPoisById(1501);
		Poi poiChezPip_jardin = poiManager.getPoisById(1502);
		Poi poiChezPip_chambre = poiManager.getPoisById(1503);
		
		Poi poiChezNico_portail = poiManager.getPoisById(1600);
		Poi poiChezNico_salon = poiManager.getPoisById(1601);
		Poi poiChezNico_jardin = poiManager.getPoisById(1602);
		Poi poiChezNico_chambre = poiManager.getPoisById(1603);
		
		Poi poiAchatMiranda = poiManager.getPoisById(2001);
//		Poi poiVenteMiranda = poiManager.getPoisById(2002);
		Poi poiAchatTonelle = poiManager.getPoisById(2003);
//		Poi poiVenteTonelle = poiManager.getPoisById(2004);
		Poi poiAchatDahlias = poiManager.getPoisById(2005);
//		Poi poiVenteDahlias = poiManager.getPoisById(2006);
		Poi poiAchatBosquets = poiManager.getPoisById(2007);
//		Poi poiVenteBosquets = poiManager.getPoisById(2008);

		
		List<Poi> poisEcole = new ArrayList<Poi>();
		List<Poi> poisTerrain = new ArrayList<Poi>();
		List<Poi> poisChezYo = new ArrayList<Poi>();
		List<Poi> poisChezRuss = new ArrayList<Poi>();
		List<Poi> poisChezNico = new ArrayList<Poi>();
		List<Poi> poisChezPip = new ArrayList<Poi>();
		List<Poi> poisChezYa = new ArrayList<Poi>();
		List<Poi> poisChezAli = new ArrayList<Poi>();
		List<Poi> poisChezTom = new ArrayList<Poi>();
		List<Poi> poisChezGuy = new ArrayList<Poi>();
		List<Poi> poisMiranda = new ArrayList<Poi>();
		List<Poi> poisTonelle = new ArrayList<Poi>();
		List<Poi> poisDahlias = new ArrayList<Poi>();
		List<Poi> poisBosquets = new ArrayList<Poi>();
		
		poisEcole.add(poiEcoleClasse);
		poisEcole.add(poiEcoleCour);
		poisEcole.add(poiEcolePreau);
		poisEcole.add(poiEcoleCantine);
		poisEcole.add(poiEcoleSalleLecture);
		poisTerrain.add(poiTerrainCabane);		
		poisTerrain.add(poiTerrainTerrain);		
		poisChezYo.add(poiChezYo_portail);
		poisChezYo.add(poiChezYo_salon);
		poisChezYo.add(poiChezYo_garage);
		poisChezYo.add(poiChezYo_chambre);
		poisChezYo.add(poiChezYo_jardin);
		poisChezYo.add(poiChezYo_salleDeBain);
		poisChezRuss.add(poiChezRuss_portail);
		poisChezRuss.add(poiChezRuss_salon);
		poisChezRuss.add(poiChezRuss_jardin);
		poisChezRuss.add(poiChezRuss_salleDeBain);
		poisChezGuy.add(poiChezGuy_portail);
		poisChezGuy.add(poiChezGuy_salon);
		poisChezAli.add(poiChezAli_portail);
		poisChezAli.add(poiChezAli_salon);
		poisChezAli.add(poiChezAli_chambre);
		poisChezYa.add(poiChezYa_portail);
		poisChezYa.add(poiChezYa_salon);
		poisChezYa.add(poiChezYa_jardin);
		poisChezYa.add(poiChezYa_chambre);
		poisChezTom.add(poiChezTom_portail);
		poisChezTom.add(poiChezTom_salon);
		poisChezTom.add(poiChezTom_jardin);
		poisChezPip.add(poiChezPip_portail);
		poisChezPip.add(poiChezPip_salon);
		poisChezPip.add(poiChezPip_jardin);
		poisChezPip.add(poiChezPip_chambre);
		poisChezNico.add(poiChezNico_portail);
		poisChezNico.add(poiChezNico_salon);
		poisChezNico.add(poiChezNico_jardin);
		poisChezNico.add(poiChezNico_chambre);
		poisMiranda.add(poiAchatMiranda);
//		poisMiranda.add(poiVenteMiranda);
		poisTonelle.add(poiAchatTonelle);
//		poisTonelle.add(poiVenteTonelle);
		poisDahlias.add(poiAchatDahlias);
//		poisDahlias.add(poiVenteDahlias);
		poisBosquets.add(poiAchatBosquets);
//		poisBosquets.add(poiVenteBosquets);
		
		// (X,Y) en partant du haut-gauche
		// Pour une Map (2000 x 1000)
		// X (min= 0, max= 1800)
		// Y (min= 56, max= 980)
		// TODO attention au bord droit si plusieurs persos sur le lieu (max 8)
		Lieu chezYo = new Lieu(1, "Chez johann", "La maison de Johann", imagePaths , sonPaths, null, PersoPrenom.Johann, new Point(1700, 310), "image/lieu/MaisonYo.png", poisChezYo, false);
		Lieu chezPip = new Lieu(2, "Chez pierre", "La maison de Pierre", imagePaths , sonPaths, null, PersoPrenom.Pierre, new Point(700, 340), "image/lieu/MaisonPip.png", poisChezPip, false);
		Lieu chezNico = new Lieu(3, "Chez nicolas", "La maison de Nicolas", imagePaths , sonPaths, null, PersoPrenom.Nicolas, new Point(450, 800), "image/lieu/MaisonNicoEtTom.png", poisChezNico, false);
		Lieu chezYa = new Lieu(4, "Chez yannick", "La maison de Yannick", imagePaths , sonPaths, null, PersoPrenom.Yannick, new Point(600, 450), "image/lieu/MaisonYa.png", poisChezYa, false);
		Lieu chezTom = new Lieu(5, "Chez thomas", "La maison de Thomas", imagePaths , sonPaths, null, PersoPrenom.Thomas, new Point(615, 840), "image/lieu/MaisonNicoEtTom.png", poisChezTom, false);
		Lieu chezAli = new Lieu(6, "Chez ali", "La maison d'Ali", imagePaths , sonPaths, null, PersoPrenom.Ali, new Point(1300, 800), "image/lieu/MaisonAli.png", poisChezAli, false);
		Lieu chezGuy = new Lieu(7, "Chez guillaume", "La maison de Guillaume", imagePaths , sonPaths, null, PersoPrenom.Guillaume, new Point(1700, 225), "image/lieu/MaisonGuy.png", poisChezGuy, false);
		Lieu chezJo = new Lieu(8, "Chez jonathan", "La maison de Jonathan", imagePaths , sonPaths, null, PersoPrenom.Jonathan, new Point(100, 330), "image/lieu/MaisonRuss.png", poisChezRuss, false);
		Lieu ecole = new Lieu(9, "L'ecole", "L'ecole elementaire Jules Ferry", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(850, 470), "image/lieu/Ecole.png", poisEcole, false);
		Lieu terrain = new Lieu(10, "Le terrain", "Le site aux moults peripeties", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(1450, 270), "image/lieu/Terrain.png", poisTerrain, false);
		Lieu miranda = new Lieu(11, "La Miranda", "Boutique de bonbon", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(850, 590), "image/lieu/Miranda.png", poisMiranda, false);
		Lieu tonelle = new Lieu(12, "La Tonnelle", "Boutique de bonbon", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(780, 800), "image/lieu/Tonnelle.png", poisTonelle, false);
		Lieu dahlias = new Lieu(13, "Les Dahlias", "Boutique de bonbon", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(220, 410), "image/lieu/Dahlias.png", poisDahlias, false);
		Lieu bosquets = new Lieu(14, "Les Bosquets", "Boutique de bonbon", imagePaths , sonPaths, null, PersoPrenom.GROUPE, new Point(1200, 56), "image/lieu/Bosquets.png", poisBosquets, false);
				
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
		lieux.add(miranda);
		lieux.add(tonelle);
		lieux.add(dahlias);
		lieux.add(bosquets);
		
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

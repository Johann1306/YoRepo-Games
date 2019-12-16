package modele.item.personnage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import core.ImageManager;
import core.MusiqueManager;
import core.configuration.Constante;
import front.FenetrePrincipal;
import front.FrameShopAdulte;
import front.FrameShopEnfant;
import front.MainFrame;
import modele.item.Item;
import modele.item.ItemType;

public class Groupe implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<PersonnagePrincipal> leGroupe;
	private Map<Item, Integer> sac;
	private int bourse;

	public Groupe() {
		this.leGroupe = new ArrayList<PersonnagePrincipal>();
		this.sac = new HashMap<>();
		this.bourse = 0;
	}
	
	public List<PersonnagePrincipal> getPersos() {
		return leGroupe;
	}

	public List<Personnage> getPersosVivants() {
		List<Personnage> persosDejaPresentes = new ArrayList<Personnage>();
		for (PersonnagePrincipal personnagePrincipal : leGroupe) {
			if (personnagePrincipal.isDejaPresente() && !personnagePrincipal.isMort()) {
				persosDejaPresentes.add(personnagePrincipal);
			}
		}
		return persosDejaPresentes;
	}
	
	public List<PersonnagePrincipal> getPersosPrincipauxVivants() {
		List<PersonnagePrincipal> persosDejaPresentes = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnagePrincipal : leGroupe) {
			if (personnagePrincipal.isDejaPresente() && !personnagePrincipal.isMort()) {
				persosDejaPresentes.add(personnagePrincipal);
			}
		}
		return persosDejaPresentes;
	}
	

	public List<PersonnagePrincipal> getPersosDejaPresentes() {
		List<PersonnagePrincipal> persosDejaPresentes = new ArrayList<PersonnagePrincipal>();
		for (PersonnagePrincipal personnagePrincipal : leGroupe) {
			if (personnagePrincipal.isDejaPresente()) {
				persosDejaPresentes.add(personnagePrincipal);
			}
		}
		return persosDejaPresentes;
	}

	public PersonnagePrincipal getPersoByNom(PersoPrenom prenom) {
		for (PersonnagePrincipal perso : leGroupe)
			if (prenom.name().equals(perso.getPrenom())) {
				return perso;
			}
		return null;
	}
	
	public PersonnagePrincipal getPersoByNom(String nom) {
		for (PersonnagePrincipal perso : leGroupe)
			if (nom.equals(perso.getPrenom())) {
				return perso;
			}
		return null;
	}
	
	public void ajoutePerso(PersonnagePrincipal perso) {
		leGroupe.add(perso);
	}

	public PersonnagePrincipal supprimePerso(PersonnagePrincipal perso) {
		leGroupe.remove(perso);
		return perso;
	}

	public Map<Item, Integer> getSac() {
		return sac;
	}

	public void setSac(Map<Item, Integer> sac) {
		this.sac = sac;
	}
	
	public int getBourse() {
		return bourse;
	}

	public void setBourse(int bourse) {
		this.bourse = bourse;
	}

	public void ajouteItem(Item item) {
		
		MusiqueManager.playSon("sonParDefaut/cape.mp3");
		
		Integer valeur = sac.get(item);
		// Si le sac ne contient pas encore cet objet
		if (valeur == null) {
			sac.put(item, 1);
		} else {
			// Sinon on incremente
			sac.put(item, valeur + 1);
		}
	}
	
	public void enleveItem(Item item) {
		// Si c est un objet de groupe on le retire du sac de groupe
		PersoPrenom proprietaire = item.getProprietaire();
		if (proprietaire.name().equals(PersoPrenom.GROUPE.name())) {
			Integer valeur = sac.get(item);
			// Si le sac contient plusieurs fois cet objet
			if (valeur > 1) {
				// On decremente
				sac.put(item, valeur-1);
			} else {
				// Sinon on le retire
				sac.remove(item);
			}
			
		// Si c est l objet d un perso on le retire du sac du perso
		} else {
			Map<Item, Integer> sacPerso = getPersoByNom(proprietaire).getSac();
			Integer valeur = sacPerso.get(item);
			// Si le sac contient plusieurs fois cet objet
			if (valeur > 1) {
				// On decremente
				sacPerso.put(item, valeur-1);
			} else {
				// Sinon on le retire
				sacPerso.remove(item);
			}
		}
	}
	
	public void ajouteArgent(int somme, boolean frameShopEnfant, boolean frameShopAdulte) {
		if (somme > 0) {
			bourse = bourse + somme;
			
			// TODO son de bruit de caisse enregistreuse ou de jackpot
			MusiqueManager.playSon("sonParDefaut/caisseEnregistreuse.mp3");
			
			// Affichage popup info gain
			ImageIcon image = FenetrePrincipal.getImageIcon("image/argent/franc.png");
			// Si il n y a pas d image, on retourne l icone par defaut d un evenement
			if (image == null || image.getIconWidth() == -1) {
				image = FenetrePrincipal.getImageIcon("image/defaut/defautEvenement.png");
			}
			ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.ARGENT_IMAGE_DIMENSION_100_100);
			JLabel messageLabel = new JLabel("La groupe a gagne : " + somme + " Francs");
			messageLabel.setFont(Constante.MARIO_FONT_MENU_3);
			
			if (frameShopEnfant) {
				JOptionPane.showMessageDialog(FrameShopEnfant.getFrameShop(),
						messageLabel, "Argent gagné", 0, resizeImage);
				
			} else if (frameShopAdulte) {
				JOptionPane.showMessageDialog(FrameShopAdulte.getFrameShop(),
						messageLabel, "Argent gagné", 0, resizeImage);
			
			} else {
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(),
						messageLabel, "Argent gagné", 0, resizeImage);
			}
			
		} else {
//			System.out.println("La somme a ajouter dans la bourse est inferieur ou egal à O : Somme = " + somme);
		}
	}
	
	public int depenseArgent(int somme) {
		if (somme > 0) {
			if (somme <= bourse) {
				bourse = bourse - somme;
				return 1;
			} else {
				return -1;
			}
		} else {
//			System.out.println("La somme a retirer de la bourse est inferieur ou egal à O : Somme = " + somme);
		}
		return 0;
	}
	
	public void enleveArgent(int somme) {
		if (somme > 0) {
			bourse = bourse - somme;
			if (bourse < 0) {
				bourse = 0;
			}
		} else {
//			System.out.println("La somme a retirer de la bourse est inferieur ou egal à O : Somme = " + somme);
		}
	}

	public Map<? extends Item, ? extends Integer> getDrogues() {
		Map<Item,Integer> map = new HashMap<>();
		for (Item item : sac.keySet()) {
			if (item.getType().name().equals(ItemType.DROGUE.name())) {
				map.put(item, sac.get(item));
			}
		}
		return map;
	}

}

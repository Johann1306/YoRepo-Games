package core;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import core.configuration.Constante;
import front.FenetrePrincipal;
import front.MainFrame;
import front.MenuPrincipal;
import front.PanelPersonnage;
import modele.evenement.Evenement;
import modele.evenement.EvenementTheme;
import modele.item.Item;

public class EvenementManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Evenement> evenements;
	private List<Evenement> evenementsDisponibles;
	private List<Evenement> evenementsIndisponibles;

	public void initialise(ItemManager itemManager) {
		
		evenements = new ArrayList<Evenement>();
		evenementsDisponibles = new LinkedList<Evenement>();
		evenementsIndisponibles = new ArrayList<Evenement>();

		// Chargement des evenements

		String titre1 = "testEvent1";
		String informations1 = "infosEvent1troooooooooooooooooooooooooooooooooooooooooooplong";
		String path1 = "image/defaut/defautEvenement.png";
		String sonPath1 = "sonParDefaut/314-SecretOfMana-got-an-item.mp3";
		String sonPathNull = null;
		String videoPath1 = "video/Trololo.mp4";
		String videoPathNull = null;
		EvenementTheme type1 = EvenementTheme.ANNIVERSAIRE;
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 10, 0, 0);

		List<Item> itemsDebloques1 = new ArrayList<Item>();
		Item item1 = itemManager.getItemByNom("item1");
		Item item2 = itemManager.getItemByNom("item2");
		itemsDebloques1.add(item1);
		itemsDebloques1.add(item2);
//		ItemManager.addItem() // ???

	
		String titre2 = "testEvent2";
		String informations2 = "infosEvent2";
		String path2 = "image/defaut/defautEvenement.png";
		String sonPath2 = "";
		EvenementTheme type2 = EvenementTheme.SORTIE_SERIE;
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 12, 0, 0);
		List<Item> itemsDebloques2 = new ArrayList<Item>();
		Item item3 = itemManager.getItemByNom("item3");
		Item item6 = itemManager.getItemByNom("item6");
		Item item7 = itemManager.getItemByNom("item7");
		Item item8 = itemManager.getItemByNom("item8");
		Item item9 = itemManager.getItemByNom("item9");
		Item item10 = itemManager.getItemByNom("item10");
		Item item11 = itemManager.getItemByNom("item11");
		Item item12 = itemManager.getItemByNom("item12");
		Item item13 = itemManager.getItemByNom("item13");
		Item item14 = itemManager.getItemByNom("item14");
		Item item15 = itemManager.getItemByNom("item15");
		itemsDebloques2.add(item3);
		itemsDebloques2.add(item6);
		itemsDebloques2.add(item7);
		itemsDebloques2.add(item8);
		itemsDebloques2.add(item9);
		itemsDebloques2.add(item10);
		itemsDebloques2.add(item11);
		itemsDebloques2.add(item12);
		itemsDebloques2.add(item13);
		itemsDebloques2.add(item14);
		itemsDebloques2.add(item15);

		String titre3 = "testEvent3";
		String informations3 = "infosEvent3";
		String path3 = "image/defaut/defautEvenement.png";
		String sonPath3 = "";
		EvenementTheme type3 = EvenementTheme.SORTIE_SERIE;
		Date date3 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 14, 0, 0);
		List<Item> itemsDebloques3 = new ArrayList<Item>();

		String titre4 = "testEvent4";
		String informations4 = "infosEvent4";
		String path4 = "image/defaut/defautEvenement.png";
		String sonPath4 = "";
		EvenementTheme type4 = EvenementTheme.SORTIE_SERIE;
		Date date4 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 16, 0, 0);
		List<Item> itemsDebloques4 = new ArrayList<Item>();
		Item item4 = itemManager.getItemByNom("item4");
		Item item5 = itemManager.getItemByNom("item5");
		itemsDebloques4.add(item4);
		itemsDebloques4.add(item5);

		
		////////////
		
		List<Item> itemsDebloquesFilm1 = new ArrayList<Item>();
		itemsDebloquesFilm1.add(itemManager.getItemById(600));
		
		
		// Evenements datés
		
		// Films/Series/Emissions/DessinsAnimes/
//		Evenement film1 = new Evenement("Die Hard 3", "", "image/film/diehard3.jpg", "son/film/diehard3.mp3", videoPathNull, EvenementTheme.SORTIE_FILM, DateManager.genereUneDate(1995, Calendar.MAY, 15, 14, 0, 0), itemsDebloquesFilm1);
		Evenement film1 = new Evenement("Die Hard 3", "", "image/film/diehard3.jpg", "son/film/diehard3.mp3", videoPathNull, EvenementTheme.SORTIE_FILM, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 3, 14, 0, 0), itemsDebloquesFilm1);
		Evenement emission1 = new Evenement("La Trilogie du Samedi", "", "image/emission/trilogieSamedi.jpg", sonPathNull, videoPathNull, EvenementTheme.SORTIE_EMISSION, DateManager.genereUneDate(1997, Calendar.DECEMBER, 6, 21, 0, 0), null);

		// Objets
		Evenement sortieRequins = new Evenement("Nike Air Max Plus TN", "", "image/actionCombat/nikeRequin.jpg", sonPathNull, videoPathNull, EvenementTheme.SORTIE_OBJET, DateManager.genereUneDate(1998, Calendar.JANUARY, 15, 9, 0, 0), null);
		
		// Evenements importants
		Evenement septembre911 = new Evenement("Attaques du World Trade Center", "", "image/evenement/911.jpg", sonPathNull, videoPathNull, EvenementTheme.HISTOIRE, DateManager.genereUneDate(2001, Calendar.SEPTEMBER, 11, 9, 0, 0), null);
		
		Evenement test1 = new Evenement(titre1, informations1, path1, sonPath1, videoPathNull, type1, date1, itemsDebloques1);
		Evenement test2 = new Evenement(titre2, informations2, path2, sonPath1, videoPathNull, type2, date2, itemsDebloques2);
		Evenement test3 = new Evenement(titre3, informations3, path3, sonPath1, videoPathNull, type3, date3, null);
		Evenement test4 = new Evenement(titre4, informations4, path4, sonPath1, videoPathNull, type4, date4, itemsDebloques4);
		
		// Ajout a la liste
		evenements.add(film1);
		evenements.add(emission1);
		evenements.add(sortieRequins);
		evenements.add(septembre911);
		
		evenements.add(test1);
		evenements.add(test2);
		evenements.add(test3);
		evenements.add(test4);

		// Tous les evenements sont indisponibles au depart
		evenementsIndisponibles.addAll(evenements);

	}

	public List<Evenement> getEvenements() {
		return evenements;
	}

	public List<Evenement> getEvenementsDisponibles() {
		refreshEvenementsAPresenter();
		return evenementsDisponibles;
	}

	public List<Evenement> getEvenementsIndisponibles() {
		refreshEvenementsAPresenter();
		return evenementsIndisponibles;
	}

	private void refreshEvenementsAPresenter() {
		List<Evenement> indispoTemp = new ArrayList<Evenement>(evenementsIndisponibles);
		for (Evenement evenement : indispoTemp) {
			if (evenement.estDisponibleAPresenter()) {
				// Refresh
				evenementsDisponibles.add(evenement);
				evenementsIndisponibles.remove(evenement);
				evenement.setDejaPresente(true);

				// Lancer le son ou la musique associe a l evenement
				if (evenement.getSonPath() != null) {
					MusiqueManager.playSonEvenement(evenement.getSonPath());
				}
				
				// Lancer la video associe a l evenement
				if (evenement.getVideoPath() != null) {
					VideoManager.play(evenement.getVideoPath());
				}
				
				// Afficher JDialog pour l evenement
				int type = getTypeEvenement(evenement);
				ImageIcon image = FenetrePrincipal.getImageIcon(evenement.getImagePath());
				// Si il n y a pas d image, on retourne l icone par defaut d un evenement
				if (image.getIconWidth() == -1) {
					image = FenetrePrincipal.getImageIcon("image/defaut/defautEvenement.png");
				}
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), evenement.getInformations(), evenement.getTitre(), type, image);
				
				// Debloquer les items a debloquer 
				List<Item> itemsDebloques = evenement.getItemsDebloques();
				if (itemsDebloques != null) {
					for (Item item : itemsDebloques) {
						if (item != null) {
						
							// Lancer le son ou la musique associe a l item
							MusiqueManager.playSonItem("sonParDefaut/09-Zelda-small-item-catch.mp3");
								
							// TODO get(0)
							// Lancer la video associe a l item
							if (item.getVideoPaths() != null) {
								VideoManager.play(item.getVideoPaths().get(0));
							}
							
							// Afficher JDialog pour l item
							ImageIcon itemImage = FenetrePrincipal.getImageIcon(item.getImagePath().get(0));
							if (itemImage.getIconWidth() == -1) {
								itemImage = FenetrePrincipal.getImageIcon("image/defaut/defautItem.png");
							}
							ImageIcon resizeImage = ImageManager.resizeImage(itemImage, Constante.PERSO_IMAGE_DIMENSION_180_180);
							JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), item.getInformations(), item.getNom(), type, resizeImage);
							item.setDisponible(true);
						}
					}
				}
			} 
		}
		// Si un evenement a debloque un perso
		MainFrame.getPanelPersonnage().refreshArriveePersonnage();
	}
	
	public Evenement getNextEvenement() {
		Evenement nextEvenement = null;
		List<Evenement> evenementsIndisponibles = getEvenementsIndisponibles();
		long minDiff = 10000000000000000L;
		for (Evenement evenement : evenementsIndisponibles) {
			long diff = MenuPrincipal.getMainFrame().getCoreManager().getDateManager().compare(evenement.getDate());
			if (diff < minDiff ) {
				minDiff = diff;
				nextEvenement = evenement;
			}
		}
		return nextEvenement;
	}

	private int getTypeEvenement(Evenement evenement) {
		int type = JOptionPane.PLAIN_MESSAGE;
		if (evenement.getTheme().equals(EvenementTheme.SORTIE_SERIE)) {
			type = JOptionPane.ERROR_MESSAGE;
		}
		return type;
	}
}

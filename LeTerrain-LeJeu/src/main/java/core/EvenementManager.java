package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import core.audio.Sound;
import core.video.LecteurMP4;
import front.MainFrame;
import modele.evenement.Evenement;
import modele.evenement.EvenementTheme;
import modele.item.Item;
import modele.item.ItemType;

public class EvenementManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private static List<Evenement> evenements;
	private static List<Evenement> evenementsDisponibles;
	private static List<Evenement> evenementsIndisponibles;
	private static Sound applicationEvenement = null;
	private static Sound applicationItem = null;
	private static LecteurMP4 lecteur = null;


	public void initialise() {
		
		// Initialisation du lecteur MP4
		lecteur = new LecteurMP4();
		lecteur.init();

		evenements = new ArrayList<>();
		evenementsDisponibles = new LinkedList<>();
		evenementsIndisponibles = new ArrayList<>();

		// Chargement des evenements

		String titre1 = "testEvent1";
		String informations1 = "infosEvent1troooooooooooooooooooooooooooooooooooooooooooplong";
		String path1 = "";
		String sonPath1 = "src/main/resources/sonParDefaut/314-SecretOfMana-got-an-item.mp3";
		String videoPath1 = "src/main/resources/video/Trololo.mp4";
		EvenementTheme type1 = EvenementTheme.ANNIVERSAIRE;
		Date date1 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 10, 0, 0);

		List<Item> itemsDebloques1 = new ArrayList<>();
		Item item1 = ItemManager.getItemByNom("item1");
		Item item2 = ItemManager.getItemByNom("item2");
		itemsDebloques1.add(item1);
		itemsDebloques1.add(item2);
//		ItemManager.addItem() // ???

		Evenement test1 = new Evenement(titre1, informations1, path1, sonPath1, videoPath1, type1, date1, itemsDebloques1);

		String titre2 = "testEvent2";
		String informations2 = "infosEvent2";
		String path2 = "src";
		String sonPath2 = "";
		EvenementTheme type2 = EvenementTheme.SORTIE_SERIE;
		Date date2 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 12, 0, 0);
		List<Item> itemsDebloques2 = new ArrayList<>();
		Item item3 = ItemManager.getItemByNom("item3");
		Item item6 = ItemManager.getItemByNom("item6");
		Item item7 = ItemManager.getItemByNom("item7");
		Item item8 = ItemManager.getItemByNom("item8");
		Item item9 = ItemManager.getItemByNom("item9");
		Item item10 = ItemManager.getItemByNom("item10");
		Item item11 = ItemManager.getItemByNom("item11");
		Item item12 = ItemManager.getItemByNom("item12");
		Item item13 = ItemManager.getItemByNom("item13");
		Item item14 = ItemManager.getItemByNom("item14");
		Item item15 = ItemManager.getItemByNom("item15");
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


		Evenement test2 = new Evenement(titre2, informations2, path2, sonPath1, videoPath1, type2, date2, itemsDebloques2);

		String titre3 = "testEvent3";
		String informations3 = "infosEvent3";
		String path3 = "src";
		String sonPath3 = "";
		EvenementTheme type3 = EvenementTheme.SORTIE_SERIE;
		Date date3 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 14, 0, 0);
		List<Item> itemsDebloques3 = new ArrayList<>();

		Evenement test3 = new Evenement(titre3, informations3, path3, sonPath1, videoPath1, type3, date3, itemsDebloques3);
		
		String titre4 = "testEvent4";
		String informations4 = "infosEvent4";
		String path4 = "src";
		String sonPath4 = "";
		EvenementTheme type4 = EvenementTheme.SORTIE_SERIE;
		Date date4 = DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 3, 16, 0, 0);
		List<Item> itemsDebloques4 = new ArrayList<>();
		Item item4 = ItemManager.getItemByNom("item4");
		Item item5 = ItemManager.getItemByNom("item5");
		itemsDebloques4.add(item4);
		itemsDebloques4.add(item5);

		Evenement test4 = new Evenement(titre4, informations4, path4, sonPath1, videoPath1, type4, date4, itemsDebloques4);
		
		// Ajout a la liste
		evenements.add(test1);
		evenements.add(test2);
		evenements.add(test3);
		evenements.add(test4);

		triEvenements();

	}

	public static List<Evenement> getEvenements() {
		return evenements;
	}

	public static List<Evenement> getEvenementsDisponibles() {
		refreshEvenements();
		return evenementsDisponibles;
	}

	public static List<Evenement> getEvenementsIndisponibles() {
		refreshEvenements();
		return evenementsIndisponibles;
	}

	private static void triEvenements() {
		for (Evenement evenement : evenements) {
			if (evenement.estDisponible()) {
				evenementsDisponibles.add(evenement);
			} else {
				evenementsIndisponibles.add(evenement);
			}
		}
	}

	private static void refreshEvenements() {
		List<Evenement> indispoTemp = new ArrayList<>(evenementsIndisponibles);
		for (Evenement evenement : indispoTemp) {
			if (evenement.estDisponible()) {
				// Refresh
				evenementsDisponibles.add(evenement);
				evenementsIndisponibles.remove(evenement);

				// Lancer le son ou la musique associé a l'evenement
				try {
					if (applicationEvenement != null && applicationEvenement.isPlaying()) {
						applicationEvenement.stop();
					}
					applicationEvenement = new Sound(evenement.getSonPath());
					Thread t = new Thread(new Runnable() {

						@Override
						public void run() {
							try {
								applicationEvenement.play();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					if (!t.isAlive()) {
						t.start();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// Lancer la video associé a l'evenement
				lecteur.play(evenement.getVideoPath());
				
				// Afficher JDialog pour l'evenement
				int type = getTypeEvenement(evenement);
				ImageIcon image = new ImageIcon(evenement.getImagePath());
				// Si il n'y a pas d'image, on retourne l'icone par defaut d'un evenement
				if (image.getIconWidth() == -1) {
					image = new ImageIcon("src/main/resources/image/defaut/defautEvenement.png");
				}
				JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), evenement.getInformations(), evenement.getTitre(), type, image);
				
				// Debloquer les items a debloquer 
				List<Item> itemsDebloques = evenement.getItemsDebloques();
				for (Item item : itemsDebloques) {
					
					// Lancer le son ou la musique associé a l'item
					try {
						if (applicationItem != null && applicationItem.isPlaying()) {
							applicationItem.stop();
						}
						// TODO : get(0)
						applicationItem = new Sound(item.getSonPath().get(0));
						Thread t = new Thread(new Runnable() {

							@Override
							public void run() {
								try {
									applicationItem.play();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						if (!t.isAlive()) {
							t.start();
						}
						
						// Lancer la video associé a l'evenement
						lecteur.play(item.getVideoPaths().get(0));
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					// Afficher JDialog pour l'evenement
					ImageIcon itemImage = new ImageIcon(item.getImagePath().get(0));
					if (itemImage.getIconWidth() == -1) {
						itemImage = new ImageIcon("src/main/resources/image/defaut/defautItem.png");
					}
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), item.getInformations(), item.getNom(), type, itemImage);
					item.setDisponible(true);
				}
			}
		}
	}
	
	public static Evenement getNextEvenement() {
		Evenement nextEvenement = null;
		List<Evenement> evenementsIndisponibles = getEvenementsIndisponibles();
		long minDiff = 1000000000;
		for (Evenement evenement : evenementsIndisponibles) {
			long diff = EvenementManager.compare(evenement);
			if (diff < minDiff ) {
				minDiff = diff;
				nextEvenement = evenement;
			}
		}
		return nextEvenement;
	}

	private static long compare(Evenement evenement) {
		long dateCourante = DateManager.getDateCourante().getTime();
		long date = evenement.getDate().getTime();
		return date-dateCourante;
	}

	private static int getTypeEvenement(Evenement evenement) {
		int type = JOptionPane.PLAIN_MESSAGE;
		if (evenement.getTheme().equals(EvenementTheme.SORTIE_SERIE)) {
			type = JOptionPane.ERROR_MESSAGE;
		}
		return type;
	}
}

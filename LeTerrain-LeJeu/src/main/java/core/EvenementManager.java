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
	private boolean evenementsActives = true;

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
		String imagePathNull = null;
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
		itemsDebloques2.add(item3);
		itemsDebloques2.add(item6);

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

		// TODO ajouter images et videos
		// Dessins Animes 90
		Evenement da1 = new Evenement("Nicky Larson", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.OCTOBER, 1, 10, 0, 0), null);
		Evenement da2 = new Evenement("Beetlejuice", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.OCTOBER, 15, 10, 0, 0), null);
		Evenement da3 = new Evenement("Tifou", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.NOVEMBER, 1, 10, 0, 0), null);
		Evenement da4 = new Evenement("Tic et Tac - Les Rangers du Risque", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.NOVEMBER, 15, 10, 0, 0), null);
		Evenement da5 = new Evenement("Manu", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.DECEMBER, 1, 10, 0, 0), null);
		Evenement da6 = new Evenement("Max et Compagnie", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.DECEMBER, 15, 10, 0, 0), null);
		Evenement da7 = new Evenement("Dragon Ball Z", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.DECEMBER, 24, 10, 0, 0), null);
		Evenement da8 = new Evenement("Les Tiny Toons", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.JANUARY, 26, 10, 0, 0), null);
		Evenement da9 = new Evenement("Doug", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da10 = new Evenement("Capitaine Planete", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da11 = new Evenement("Les jumeaux du bout du monde", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da12 = new Evenement("Samouraï Pizza Cats", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.MAY, 1, 10, 0, 0), null);
		Evenement da13 = new Evenement("Les Moomins", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.JUNE, 1, 10, 0, 0), null);
		Evenement da14 = new Evenement("Super Baloo", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da15 = new Evenement("Super Mario Bros", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.AUGUST, 1, 10, 0, 0), null);
		Evenement da16 = new Evenement("Draculito mon Saigneur", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da17 = new Evenement("Myster Mask", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da18 = new Evenement("Widget", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da19 = new Evenement("Les Aventures de Carlos", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da20 = new Evenement("Ranma 1/2", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.JUNE, 1, 10, 0, 0), null);
		Evenement da21 = new Evenement("Les Pierrafeu en culottes courtes", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da22 = new Evenement("Les Aventures de Tintin", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.MAY, 5, 10, 0, 0), null);
		Evenement da23 = new Evenement("Les Razmoket", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.OCTOBER, 17, 10, 0, 0), null);
		Evenement da24 = new Evenement("L'Ecole des Champions", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.NOVEMBER, 25, 10, 0, 0), null);
		Evenement da25 = new Evenement("La Famille Addams", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da26 = new Evenement("Sonic", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da27 = new Evenement("La Bande à Dingo", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da28 = new Evenement("Sailor Moon", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.MAY, 1, 10, 0, 0), null);
		Evenement da29 = new Evenement("Les Histoires du père Castor", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.APRIL, 22, 10, 0, 0), null);
		Evenement da30 = new Evenement("Il était une fois... les Découvreurs", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da31 = new Evenement("Les Pastagums", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da32 = new Evenement("Les Animaniacs", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da33 = new Evenement("Zoo Cup", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.MAY, 1, 10, 0, 0), null);
		Evenement da34 = new Evenement("Mighty Max", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.JUNE, 1, 10, 0, 0), null);
		Evenement da35 = new Evenement("Fly", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da36 = new Evenement("Albert le 5ème Mousquetaire", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.AUGUST, 1, 10, 0, 0), null);
		Evenement da37 = new Evenement("Power Rangers", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.APRIL, 13, 10, 0, 0), null);
		Evenement da38 = new Evenement("Iznogoud", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1995, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da39 = new Evenement("Gargoyles", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1995, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da40 = new Evenement("Beavis et Butt-Head", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1995, Calendar.JANUARY, 14, 10, 0, 0), null);
		Evenement da41 = new Evenement("Minus et Cortex", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1996, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da42 = new Evenement("Le Bus Magique", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1996, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da43 = new Evenement("The Mask", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 1, 10, 0, 0), null);
		Evenement da44 = new Evenement("Il était une fois... les Explorateurs", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1997, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da45 = new Evenement("Drôles de Monstres", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 1, 10, 0, 0), null);
		Evenement da46 = new Evenement("South Park", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1998, Calendar.JULY, 17, 10, 0, 0), null);
		Evenement da47 = new Evenement("Batman", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.SEPTEMBER, 5, 10, 0, 0), null);
		Evenement da48 = new Evenement("Il était une fois... Les Amériques", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.OCTOBER, 28, 10, 0, 0), null);
		Evenement da49 = new Evenement("Il était une fois... notre Terre", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(2008, Calendar.JANUARY, 1, 10, 0, 0), null);
	
		// Dessins Animes 80 (10 ans)
		Evenement da101 = new Evenement("Il était une fois... l'Homme", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1990, Calendar.OCTOBER, 2, 10, 0, 0), null);
		Evenement da102 = new Evenement("Albator", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1990, Calendar.DECEMBER, 7, 10, 0, 0), null);
		Evenement da103 = new Evenement("Cocoshaker", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da104 = new Evenement("Quick et Flupke", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da105 = new Evenement("Capitaine Flam", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.JANUARY, 7, 10, 0, 0), null);
		Evenement da106 = new Evenement("Ulysse 31", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.OCTOBER, 3, 10, 0, 0), null);
		Evenement da107 = new Evenement("Bouba", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.DECEMBER, 21, 10, 0, 0), null);
		Evenement da108 = new Evenement("Il était une fois... l'Espace", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da109 = new Evenement("Belle et Sebastien", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.APRIL, 2, 10, 0, 0), null);
		Evenement da110 = new Evenement("Rémi sans famille", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.FEBRUARY, 17, 10, 0, 0), null);
		Evenement da111 = new Evenement("Boule et Bill", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.MARCH, 4, 10, 0, 0), null);
		Evenement da112 = new Evenement("Tom Sawyer", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.DECEMBER, 13, 10, 0, 0), null);
		Evenement da113 = new Evenement("Les Schtroumpfs", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.DECEMBER, 27, 10, 0, 0), null);
		Evenement da114 = new Evenement("Musclor et Les Maîtres de l'Univers", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da115 = new Evenement("Les Mystérieuses Cités d'or", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.SEPTEMBER, 28, 10, 0, 0), null);
		Evenement da116 = new Evenement("Téléchat", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.OCTOBER, 3, 10, 0, 0), null);
		Evenement da117 = new Evenement("Inspecteur Gadget", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.OCTOBER, 24, 10, 0, 0), null);
		Evenement da118 = new Evenement("Gigi", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.APRIL, 11, 10, 0, 0), null);
		Evenement da119 = new Evenement("Johan & Pirlouit", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.OCTOBER, 10, 10, 0, 0), null);
		Evenement da120 = new Evenement("Les Minipouss", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.NOVEMBER, 2, 10, 0, 0), null);
		Evenement da121 = new Evenement("Sherlock Holmes", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.NOVEMBER, 4, 10, 0, 0), null);
		Evenement da122 = new Evenement("Décode pas Bunny", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da123 = new Evenement("Bibifoc", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da124 = new Evenement("Les Triples", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da125 = new Evenement("Les Aventures de Winnie l'Ourson", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.JANUARY, 26, 10, 0, 0), null);
		Evenement da126 = new Evenement("Cobra", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.FEBRUARY, 20, 10, 0, 0), null);
		Evenement da127 = new Evenement("Pole Position", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.MARCH, 27, 10, 0, 0), null);
		Evenement da128 = new Evenement("Bioman", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.JULY, 2, 10, 0, 0), null);
		Evenement da129 = new Evenement("Blondine", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 9, 10, 0, 0), null);
		Evenement da130 = new Evenement("Jayce et les Conquérants de la Lumiere", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
		Evenement da131 = new Evenement("Les Mondes Engloutis", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 17, 10, 0, 0), null);
		Evenement da132 = new Evenement("Alice au pays des Merveilles", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 22, 10, 0, 0), null);
		Evenement da133 = new Evenement("Clementine", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.OCTOBER, 2, 10, 0, 0), null);
		Evenement da134 = new Evenement("Les Bisounours", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.OCTOBER, 14, 10, 0, 0), null);
		Evenement da135 = new Evenement("Les Entrechats", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.OCTOBER, 15, 10, 0, 0), null);
		Evenement da136 = new Evenement("Dragon Ball", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 16, 10, 0, 0), null);
		Evenement da137 = new Evenement("Cat's Eyes", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da138 = new Evenement("Pingu", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JULY, 2, 10, 0, 0), null);
		Evenement da139 = new Evenement("Boumbo", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.APRIL, 2, 10, 0, 0), null);
		Evenement da140 = new Evenement("Mimi Cracra", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.MAY, 2, 10, 0, 0), null);
		Evenement da141 = new Evenement("Les Gummies", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JUNE, 2, 10, 0, 0), null);
		Evenement da142 = new Evenement("Astro le Petit Robot", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JANUARY, 4, 10, 0, 0), null);
		Evenement da143 = new Evenement("Davy Crockett", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JANUARY, 5, 10, 0, 0), null);
		Evenement da144 = new Evenement("Alvin et les Chipmunks", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da145 = new Evenement("MASK", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.APRIL, 14, 10, 0, 0), null);
		Evenement da146 = new Evenement("Les Popples", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 8, 10, 0, 0), null);
		Evenement da147 = new Evenement("Les Snorkies", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
		Evenement da148 = new Evenement("Cosmocats", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 12, 10, 0, 0), null);
		Evenement da149 = new Evenement("Jem et les Hologrammes", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 14, 10, 0, 0), null);
		Evenement da150 = new Evenement("Moi Renart", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 20, 10, 0, 0), null);
		Evenement da151 = new Evenement("Les Muppets Babies", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.OCTOBER, 26, 10, 0, 0), null);
		Evenement da152 = new Evenement("Denis la Malice", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.NOVEMBER, 5, 10, 0, 0), null);
		Evenement da153 = new Evenement("Le Croc-Note Show", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da154 = new Evenement("Le Piaf", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da155 = new Evenement("Les Luxioles", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da156 = new Evenement("SOS Fantômes", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.APRIL, 2, 10, 0, 0), null);
		Evenement da157 = new Evenement("L'Anglais avec Victor", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MAY, 2, 10, 0, 0), null);
		Evenement da158 = new Evenement("Il était une fois... la Vie", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 15, 10, 0, 0), null);
		Evenement da159 = new Evenement("Mon Petit Poney", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 7, 10, 0, 0), null);
		Evenement da160 = new Evenement("Les Ewoks", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 8, 10, 0, 0), null);
		Evenement da161 = new Evenement("Princesse Sarah", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MARCH, 15, 10, 0, 0), null);
		Evenement da162 = new Evenement("Les Petits Malins", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MAY, 3, 10, 0, 0), null);
		Evenement da163 = new Evenement("Jeanne et Serge", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.AUGUST, 31, 10, 0, 0), null);
		Evenement da164 = new Evenement("Rahan", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.NOVEMBER, 29, 10, 0, 0), null);
		Evenement da165 = new Evenement("Les Tortues Ninja", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da166 = new Evenement("Club BCBG", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da167 = new Evenement("La Bande à Picsou", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da168 = new Evenement("Lucile, Amour et Rock'n Roll", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.JANUARY, 15, 10, 0, 0), null);
		Evenement da169 = new Evenement("Diplodo", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 14, 10, 0, 0), null);
		Evenement da170 = new Evenement("Alf", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 18, 10, 0, 0), null);
		Evenement da171 = new Evenement("Les Chevaliers du Zodiaque", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.APRIL, 6, 10, 0, 0), null);
		Evenement da172 = new Evenement("La Sagesse des Gnomes", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.APRIL, 7, 10, 0, 0), null);
		Evenement da173 = new Evenement("Georgie", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.AUGUST, 29, 10, 0, 0), null);
		Evenement da174 = new Evenement("Lamu", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.AUGUST, 30, 10, 0, 0), null);
		Evenement da175 = new Evenement("Ken le Survivant", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.AUGUST, 31, 10, 0, 0), null);
		Evenement da176 = new Evenement("Docteur Slump", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 4, 10, 0, 0), null);
		Evenement da177 = new Evenement("Olive et Tom", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 6, 10, 0, 0), null);
		Evenement da178 = new Evenement("Galaxy Express 999", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 11, 10, 0, 0), null);
		Evenement da179 = new Evenement("Petit Ours Brun", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 12, 10, 0, 0), null);
		Evenement da180 = new Evenement("Pif et Hercule", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.OCTOBER, 9, 10, 0, 0), null);
		Evenement da181 = new Evenement("Denver", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.MARCH, 20, 10, 0, 0), null);
		Evenement da182 = new Evenement("La Panthere Rose", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.FEBRUARY, 11, 10, 0, 0), null);
		Evenement da183 = new Evenement("Dino-Riders", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.APRIL, 26, 10, 0, 0), null);
		Evenement da184 = new Evenement("But pour Rudy", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
		Evenement da185 = new Evenement("Gwendoline", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 11, 10, 0, 0), null);
		Evenement da186 = new Evenement("Sous le Signe des Mousquetaires", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 12, 10, 0, 0), null);
		Evenement da187 = new Evenement("Le College Fou, Fou, Fou", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.NOVEMBER, 8, 10, 0, 0), null);
		Evenement da188 = new Evenement("Babar", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.DECEMBER, 11, 10, 0, 0), null);
		Evenement da189 = new Evenement("Les Simpson", "", imagePathNull, sonPathNull, videoPathNull, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.DECEMBER, 17, 10, 0, 0), null);
		
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

//		evenements.add(da1);
//		evenements.add(da2);
//		evenements.add(da3);
//		evenements.add(da4);
//		evenements.add(da5);
//		evenements.add(da6);
//		evenements.add(da7);
//		evenements.add(da8);
//		evenements.add(da9);
//		evenements.add(da10);
//		evenements.add(da11);
//		evenements.add(da12);
//		evenements.add(da13);
//		evenements.add(da14);
//		evenements.add(da15);
//		evenements.add(da16);
//		evenements.add(da17);
//		evenements.add(da18);
//		evenements.add(da19);
//		evenements.add(da20);
//		evenements.add(da21);
//		evenements.add(da22);
//		evenements.add(da23);
//		evenements.add(da24);
//		evenements.add(da25);
//		evenements.add(da26);
//		evenements.add(da27);
//		evenements.add(da28);
//		evenements.add(da29);
//		evenements.add(da30);
//		evenements.add(da31);
//		evenements.add(da32);
//		evenements.add(da33);
//		evenements.add(da34);
//		evenements.add(da35);
//		evenements.add(da36);
//		evenements.add(da37);
//		evenements.add(da38);
//		evenements.add(da39);
//		evenements.add(da40);
//		evenements.add(da41);
//		evenements.add(da42);
//		evenements.add(da43);
//		evenements.add(da44);
//		evenements.add(da45);
//		evenements.add(da46);
//		evenements.add(da47);
//		evenements.add(da48);
//		evenements.add(da49);

//		evenements.add(da101);
//		evenements.add(da102);
//		evenements.add(da103);
//		evenements.add(da104);
//		evenements.add(da105);
//		evenements.add(da106);
//		evenements.add(da107);
//		evenements.add(da108);
//		evenements.add(da109);
//		evenements.add(da110);
//		evenements.add(da111);
//		evenements.add(da112);
//		evenements.add(da113);
//		evenements.add(da114);
//		evenements.add(da115);
//		evenements.add(da116);
//		evenements.add(da117);
//		evenements.add(da118);
//		evenements.add(da119);
//		evenements.add(da120);
//		evenements.add(da121);
//		evenements.add(da122);
//		evenements.add(da123);
//		evenements.add(da124);
//		evenements.add(da125);
//		evenements.add(da126);
//		evenements.add(da127);
//		evenements.add(da128);
//		evenements.add(da129);
//		evenements.add(da130);
//		evenements.add(da131);
//		evenements.add(da132);
//		evenements.add(da133);
//		evenements.add(da134);
//		evenements.add(da135);
//		evenements.add(da136);
//		evenements.add(da137);
//		evenements.add(da138);
//		evenements.add(da139);
//		evenements.add(da140);
//		evenements.add(da141);
//		evenements.add(da142);
//		evenements.add(da143);
//		evenements.add(da144);
//		evenements.add(da145);
//		evenements.add(da146);
//		evenements.add(da147);
//		evenements.add(da148);
//		evenements.add(da149);
//		evenements.add(da150);
//		evenements.add(da151);
//		evenements.add(da152);
//		evenements.add(da153);
//		evenements.add(da154);
//		evenements.add(da155);
//		evenements.add(da156);
//		evenements.add(da157);
//		evenements.add(da158);
//		evenements.add(da159);
//		evenements.add(da160);
//		evenements.add(da161);
//		evenements.add(da162);
//		evenements.add(da163);
//		evenements.add(da164);
//		evenements.add(da165);
//		evenements.add(da166);
//		evenements.add(da167);
//		evenements.add(da168);
//		evenements.add(da169);
//		evenements.add(da170);
//		evenements.add(da171);
//		evenements.add(da172);
//		evenements.add(da173);
//		evenements.add(da174);
//		evenements.add(da175);
//		evenements.add(da176);
//		evenements.add(da177);
//		evenements.add(da178);
//		evenements.add(da179);
//		evenements.add(da180);
//		evenements.add(da181);
//		evenements.add(da182);
//		evenements.add(da183);
//		evenements.add(da184);
//		evenements.add(da185);
//		evenements.add(da186);
//		evenements.add(da187);
//		evenements.add(da188);
//		evenements.add(da189);
		
//		evenements.add(test1);
//		evenements.add(test2);
//		evenements.add(test3);
//		evenements.add(test4);

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
				int type = getTypeEvenement(evenement);

				if (evenementsActives) {
					// Lancer le son ou la musique associe a l evenement
					if (evenement.getSonPath() != null) {
						MusiqueManager.playSonEvenement(evenement.getSonPath());
					}
					
					// Lancer la video associe a l evenement
					if (evenement.getVideoPath() != null) {
						VideoManager.play(evenement.getVideoPath());
					}
					
					// Afficher JDialog pour l evenement
					ImageIcon image = FenetrePrincipal.getImageIcon(evenement.getImagePath());
					// Si il n y a pas d image, on retourne l icone par defaut d un evenement
					if (image == null || image.getIconWidth() == -1) {
						image = FenetrePrincipal.getImageIcon("image/defaut/defautEvenement.png");
					}
					ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.PERSO_IMAGE_DIMENSION_180_180);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), evenement.getInformations(), evenement.getTitre(), type, resizeImage);
				}
				
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

	public boolean isEvenementsActives() {
		return evenementsActives;
	}

	public void setEvenementsActives(boolean evenementsActives) {
		this.evenementsActives = evenementsActives;
	}
}

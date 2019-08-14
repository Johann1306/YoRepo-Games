package core;

import java.io.Serializable;
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

		String sonPathNull = null;
		String videoPathNull = null;
		String imagePathNull = null;

		String titre1 = "testEvent1";
		String informations1 = "infosEvent1troooooooooooooooooooooooooooooooooooooooooooplong";
		String path1 = "image/defaut/defautEvenement.png";
		String sonPath1 = "sonParDefaut/314-SecretOfMana-got-an-item.mp3";
		
		String videoPath1 = "video/Trololo.mp4";
		
		// Vidéo generique de chaque Dessins Animes
		String videoPathda1 = "video/dessinAnime/NICKY LARSON.mp4";
		String videoPathda2 = "video/dessinAnime/Beetlejuice.mp4";
		String videoPathda3 = "video/dessinAnime/Tifou.mp4";
		String videoPathda4 = "video/dessinAnime/Tic et Tac.mp4";
		String videoPathda5 = "video/dessinAnime/Manu.mp4";
		String videoPathda6 = "video/dessinAnime/Max et Compagnie.mp4";
		String videoPathda7 = "video/dessinAnime/Dragon ball Z.mp4";
		String videoPathda8 = "video/dessinAnime/Les Tiny Toons.mp4";
		String videoPathda9 = "video/dessinAnime/Doug.mp4";
		String videoPathda10 = "video/dessinAnime/Captain Planet.mp4";
		String videoPathda11 = "video/dessinAnime/Les Jumeaux du bout du monde.mp4";
		String videoPathda12 = "video/dessinAnime/Samouraï Pizza Cats.mp4";
		String videoPathda13 = "video/dessinAnime/Les Moomins.mp4";
		String videoPathda14 = "video/dessinAnime/Super Baloo.mp4";
		String videoPathda15 = "video/dessinAnime/Super Mario Bros.mp4";
		String videoPathda16 = "video/dessinAnime/Draculito, Mon Saigneur.mp4";
		String videoPathda17 = "video/dessinAnime/Myster Mask.mp4";
		String videoPathda18 = "video/dessinAnime/Widget.mp4";
		String videoPathda19 = "video/dessinAnime/Les aventures de Carlos.mp4";
		String videoPathda20 = "video/dessinAnime/Ranma 1-2.mp4";
		String videoPathda21 = "video/dessinAnime/La Famille Pierrafeu.mp4";
		String videoPathda22 = "video/dessinAnime/Les aventures de Tintin.mp4";
		String videoPathda23 = "video/dessinAnime/Les Razmoket.mp4";
		String videoPathda24 = "video/dessinAnime/L'école des Champions.mp4";
		String videoPathda25 = "video/dessinAnime/La Famille Adams.mp4";
		String videoPathda26 = "video/dessinAnime/Les aventures de Sonic.mp4";
		String videoPathda27 = "video/dessinAnime/La bande a Dingo.mp4";
		String videoPathda28 = "video/dessinAnime/Sailor Moon.mp4";
		String videoPathda29 = "video/dessinAnime/Père Castor.mp4";
		String videoPathda30 = "video/dessinAnime/Il était une fois... Les Découvreurs.mp4";
		String videoPathda31 = "video/dessinAnime/Les Pastagums.mp4";
		String videoPathda32 = "video/dessinAnime/Les Animaniacs.mp4";
		String videoPathda33 = "video/dessinAnime/Zoo Cup.mp4";
		String videoPathda34 = "video/dessinAnime/Mighty Max.mp4";
		String videoPathda35 = "video/dessinAnime/Fly.mp4";
		String videoPathda36 = "video/dessinAnime/Albert le cinquième mousquetaire.mp4";
//		String videoPathda37 = "video/dessinAnime/NICKY LARSON.mp4";
		String videoPathda38 = "video/dessinAnime/Iznogoud.mp4";
		String videoPathda39 = "video/dessinAnime/Les gargoyles.mp4";
		String videoPathda40 = "video/dessinAnime/Beavis and Butt-Head.mp4";
		String videoPathda41 = "video/dessinAnime/Minus et Cortex.mp4";
		String videoPathda42 = "video/dessinAnime/Le bus magique.mp4";
		String videoPathda43 = "video/dessinAnime/The Mask.mp4";
		String videoPathda44 = "video/dessinAnime/Il était une fois... Les Explorateurs.mp4";
		String videoPathda45 = "video/dessinAnime/Droles de monstres.mp4";
		String videoPathda46 = "video/dessinAnime/South Park.mp4";
		String videoPathda47 = "video/dessinAnime/Batman.mp4";
		String videoPathda48 = "video/dessinAnime/Il était une fois... les amériques.mp4";
		String videoPathda49 = "video/dessinAnime/Il était une fois... Notre Terre.mp4";
		String videoPathda50 = "video/dessinAnime/Le retour du roi Leo.mp4";
		
		String videoPathda101 = "video/dessinAnime/Il était une fois... l'Homme.mp4";
		String videoPathda102 = "video/dessinAnime/Albator.mp4";
		String videoPathda103 = "video/dessinAnime/Cocoshaker.mp4";
		String videoPathda104 = "video/dessinAnime/Quick et Flupke.mp4";
		String videoPathda105 = "video/dessinAnime/Capitaine Flam.mp4";
		String videoPathda106 = "video/dessinAnime/Ulysse 31.mp4";
		String videoPathda107 = "video/dessinAnime/Bouba.mp4";
		String videoPathda108 = "video/dessinAnime/Il était une fois... L'Espace.mp4";
		String videoPathda109 = "video/dessinAnime/Belle et Sébastien.mp4";
		String videoPathda110 = "video/dessinAnime/Rémi sans famille.mp4";
		String videoPathda111 = "video/dessinAnime/Boule et Bill.mp4";
		String videoPathda112 = "video/dessinAnime/Tom Sawyer.mp4";
		String videoPathda113 = "video/dessinAnime/Les Schtroumpfs.mp4";
		String videoPathda114 = "video/dessinAnime/Musclor.mp4";
		String videoPathda115 = "video/dessinAnime/Les mystérieuses cités d'or.mp4";
		String videoPathda116 = "video/dessinAnime/Téléchat.mp4";
		String videoPathda117 = "video/dessinAnime/Inspecteur Gadget.mp4";
		String videoPathda118 = "video/dessinAnime/Gigi.mp4";
		String videoPathda119 = "video/dessinAnime/Johan et Pirlouit.mp4";
		String videoPathda120 = "video/dessinAnime/Les minipouss.mp4";
		String videoPathda121 = "video/dessinAnime/Sherlock Holmes.mp4";
		String videoPathda122 = "video/dessinAnime/Décode pas Bunny.mp4";
		String videoPathda123 = "video/dessinAnime/Bibifoc.mp4";
		String videoPathda124 = "video/dessinAnime/Les triplés.mp4";
		String videoPathda125 = "video/dessinAnime/Winnie.mp4";
		String videoPathda126 = "video/dessinAnime/Cobra.mp4";
		String videoPathda127 = "video/dessinAnime/Pole Position.mp4";
		String videoPathda128 = "video/dessinAnime/Bioman.mp4";
//		String videoPathda129 = "video/dessinAnime/XXXXXXXX.mp4";
		String videoPathda130 = "video/dessinAnime/Jayce.mp4";
		String videoPathda131 = "video/dessinAnime/Les mondes Engloutis.mp4";
		String videoPathda132 = "video/dessinAnime/Alice aux pays des merveilles.mp4";
		String videoPathda133 = "video/dessinAnime/Clementine.mp4";
		String videoPathda134 = "video/dessinAnime/Les Bisounours.mp4";
		String videoPathda135 = "video/dessinAnime/Les Entrechats.mp4";
		String videoPathda136 = "video/dessinAnime/Dragon Ball.mp4";
		String videoPathda137 = "video/dessinAnime/Cat's Eyes.mp4";
		String videoPathda138 = "video/dessinAnime/Pingu.mp4";
		String videoPathda139 = "video/dessinAnime/Boumbo.mp4";
		String videoPathda140 = "video/dessinAnime/Mimi Cracra.mp4";
		String videoPathda141 = "video/dessinAnime/Les Gummies.mp4";
		String videoPathda142 = "video/dessinAnime/Astro le petit robot.mp4";
		String videoPathda143 = "video/dessinAnime/Davy Crockett.mp4";
		String videoPathda144 = "video/dessinAnime/Alvin et les Chipmunks.mp4";
		String videoPathda145 = "video/dessinAnime/Mask.mp4";
		String videoPathda146 = "video/dessinAnime/Les Popples.mp4";
		String videoPathda147 = "video/dessinAnime/Les Snorky.mp4";
		String videoPathda148 = "video/dessinAnime/Cosmocats.mp4";
		String videoPathda149 = "video/dessinAnime/Jem et les Hologrammes.mp4";
		String videoPathda150 = "video/dessinAnime/Moi Renart.mp4";
		String videoPathda151 = "video/dessinAnime/Muppet Babies.mp4";
		String videoPathda152 = "video/dessinAnime/Denis la malice.mp4";
		String videoPathda153 = "video/dessinAnime/Croque-Note Show.mp4";
		String videoPathda154 = "video/dessinAnime/Le Piaf.mp4";
		String videoPathda155 = "video/dessinAnime/Les Luxioles.mp4";
		String videoPathda156 = "video/dessinAnime/SOS Fantomes.mp4";
		String videoPathda157 = "video/dessinAnime/L'espagnol avec Victor.mp4";
		String videoPathda158 = "video/dessinAnime/Il était une fois... La Vie.mp4";
		String videoPathda159 = "video/dessinAnime/Mon Petit Poney.mp4";
		String videoPathda160 = "video/dessinAnime/lesEwoks.mp4";
		String videoPathda161 = "video/dessinAnime/Princesse Sarah.mp4";
		String videoPathda162 = "video/dessinAnime/Les petits malins.mp4";
		String videoPathda163 = "video/dessinAnime/Jeanne et Serge.mp4";
		String videoPathda164 = "video/dessinAnime/Rahan.mp4";
		String videoPathda165 = "video/dessinAnime/Tortues Ninja.mp4";
		String videoPathda166 = "video/dessinAnime/ClubBCBG.mp4";
		String videoPathda167 = "video/dessinAnime/La bande à Picsou.mp4";
		String videoPathda168 = "video/dessinAnime/Lucile Amour et Rock'n Roll.mp4";
		String videoPathda169 = "video/dessinAnime/Diplodo.mp4";
//		String videoPathda170 = "video/dessinAnime/XXXXXXXX.mp4";
		String videoPathda171 = "video/dessinAnime/Les Chevaliers du Zodiaque.mp4";
		String videoPathda172 = "video/dessinAnime/David le gnome.mp4";
		String videoPathda173 = "video/dessinAnime/Georgie.mp4";
		String videoPathda174 = "video/dessinAnime/Lamu.mp4";
		String videoPathda175 = "video/dessinAnime/Ken.mp4";
		String videoPathda176 = "video/dessinAnime/Dr Slump.mp4";
		String videoPathda177 = "video/dessinAnime/Olive et Tom.mp4";
		String videoPathda178 = "video/dessinAnime/Galaxy Express 999.mp4";
		String videoPathda179 = "video/dessinAnime/Petit ours brun.mp4";
		String videoPathda180 = "video/dessinAnime/Pif et Hercule.mp4";
		String videoPathda181 = "video/dessinAnime/Denver.mp4";
		String videoPathda182 = "video/dessinAnime/La Panthère Rose.mp4";
		String videoPathda183 = "video/dessinAnime/Dino Riders.mp4";
		String videoPathda184 = "video/dessinAnime/But pour Rudy.mp4";
//		String videoPathda185 = "video/dessinAnime/XXXXXXXX.mp4";
//		String videoPathda186 = "video/dessinAnime/XXXXXXXX.mp4";
		String videoPathda187 = "video/dessinAnime/Un collège fou fou fou.mp4";
		String videoPathda188 = "video/dessinAnime/Babar.mp4";
		String videoPathda189 = "video/dessinAnime/Les Simpson.mp4";	

		// Images vignette de chaque Dessins Animes
		String imagePathda1 = "image/dessinAnime/nicky-larson.jpg";
		String imagePathda2 = "image/dessinAnime/beetlejuice.jpg";
		String imagePathda3 = "image/dessinAnime/tifou.jpg";
		String imagePathda4 = "image/dessinAnime/tic-et-tac.jpg";
		String imagePathda5 = "image/dessinAnime/manu.jpg";
		String imagePathda6 = "image/dessinAnime/maxEtCompagnie.jpeg";
		String imagePathda7 = "image/dessinAnime/Dragon-Ball-Z.jpg";
		String imagePathda8 = "image/dessinAnime/tinytoons.png";
		String imagePathda9 = "image/dessinAnime/doug.jpg";
		String imagePathda10 = "image/dessinAnime/captainPlanet.jpg";
		String imagePathda11 = "image/dessinAnime/LesJumeaux.png";
		String imagePathda12 = "image/dessinAnime/samouraiPizzaCats.png";
		String imagePathda13 = "image/dessinAnime/moomins.jpg";
		String imagePathda14 = "image/dessinAnime/superBaloo.jpg";
		String imagePathda15 = "image/dessinAnime/superMario.png";
		String imagePathda16 = "image/dessinAnime/draculito.png";
		String imagePathda17 = "image/dessinAnime/mysterMask.png";
		String imagePathda18 = "image/dessinAnime/widget.png";
		String imagePathda19 = "image/dessinAnime/carlos.jpg";
		String imagePathda20 = "image/dessinAnime/Ranma.png";
		String imagePathda21 = "image/dessinAnime/pierrafeu.png";
		String imagePathda22 = "image/dessinAnime/tintin.png";
		String imagePathda23 = "image/dessinAnime/razmoket.png";
		String imagePathda24 = "image/dessinAnime/ecoleDesChampions.png";
		String imagePathda25 = "image/dessinAnime/familleAdams.jpg";
		String imagePathda26 = "image/dessinAnime/sonic.jpg";
		String imagePathda27 = "image/dessinAnime/dingo.png";
		String imagePathda28 = "image/dessinAnime/sailorMoon.jpg";
		String imagePathda29 = "image/dessinAnime/pereCastor.jpg";
		String imagePathda30 = "image/dessinAnime/ieufLesDecouvreurs.jpg";
		String imagePathda31 = "image/dessinAnime/pastagums.png";
		String imagePathda32 = "image/dessinAnime/animaniacs.jpg";
		String imagePathda33 = "image/dessinAnime/zooCup.jpg";
		String imagePathda34 = "image/dessinAnime/mightyMax.jpg";
		String imagePathda35 = "image/dessinAnime/fly.png";
		String imagePathda36 = "image/dessinAnime/albert.jpg";
//		String imagePathda37 = "image/dessinAnime/nicky-larson.jpg";
		String imagePathda38 = "image/dessinAnime/iznogoud.png";
		String imagePathda39 = "image/dessinAnime/gargoyles.png";
		String imagePathda40 = "image/dessinAnime/beavisAndButthead.jpg";
		String imagePathda41 = "image/dessinAnime/minusEtCortex.png";
		String imagePathda42 = "image/dessinAnime/busMagique.png";
		String imagePathda43 = "image/dessinAnime/theMask.png";
		String imagePathda44 = "image/dessinAnime/ieufLesExplorateurs.jpg";
		String imagePathda45 = "image/dessinAnime/drolesDeMonstres.png";
		String imagePathda46 = "image/dessinAnime/southPark.png";
		String imagePathda47 = "image/dessinAnime/batman.png";
		String imagePathda48 = "image/dessinAnime/ieufLesAmeriques.jpg";
		String imagePathda49 = "image/dessinAnime/ieufNotreTerre.jpg";
		String imagePathda50 = "image/dessinAnime/leo.png";
		
		String imagePathda101 = "image/dessinAnime/ieufLhomme.jpg";
		String imagePathda102 = "image/dessinAnime/albator.jpg";
		String imagePathda103 = "image/dessinAnime/cocoshaker.jpg";
		String imagePathda104 = "image/dessinAnime/quickEtFlupke.png";
		String imagePathda105 = "image/dessinAnime/capitaineFlam.jpg";
		String imagePathda106 = "image/dessinAnime/ulysse31.jpg";
		String imagePathda107 = "image/dessinAnime/bouba.png";
		String imagePathda108 = "image/dessinAnime/ieufLespace.jpg";
		String imagePathda109 = "image/dessinAnime/belleEtSebastien.png";
		String imagePathda110 = "image/dessinAnime/remi.png";
		String imagePathda111 = "image/dessinAnime/bouleEtBill.png";
		String imagePathda112 = "image/dessinAnime/tomSawyer.png";
		String imagePathda113 = "image/dessinAnime/lesSchtroumpfs.png";
		String imagePathda114 = "image/dessinAnime/musclor.png";
		String imagePathda115 = "image/dessinAnime/lesMysterieusesCitesDor.png";
		String imagePathda116 = "image/dessinAnime/telechat.png";
		String imagePathda117 = "image/dessinAnime/inspecteurGadget.png";
		String imagePathda118 = "image/dessinAnime/gigi.png";
		String imagePathda119 = "image/dessinAnime/johanEtPirlouit.png";
		String imagePathda120 = "image/dessinAnime/lesMinipouss.png";
		String imagePathda121 = "image/dessinAnime/sherlockHolmes.png";
		String imagePathda122 = "image/dessinAnime/decodePasBunny.png";
		String imagePathda123 = "image/dessinAnime/bibifoc.png";
		String imagePathda124 = "image/dessinAnime/lesTriples.png";
		String imagePathda125 = "image/dessinAnime/winnie.png";
		String imagePathda126 = "image/dessinAnime/cobra.png";
		String imagePathda127 = "image/dessinAnime/polePosition.png";
		String imagePathda128 = "image/dessinAnime/bioman.png";
//		String imagePathda129 = "image/dessinAnime/XXXXXXXXXXX.png";
		String imagePathda130 = "image/dessinAnime/jayce.png";
		String imagePathda131 = "image/dessinAnime/LesMondesEngloutis.png";
		String imagePathda132 = "image/dessinAnime/alice.png";
		String imagePathda133 = "image/dessinAnime/clementine.png";
		String imagePathda134 = "image/dessinAnime/bisounours.png";
		String imagePathda135 = "image/dessinAnime/lesEntrechats.png";
		String imagePathda136 = "image/dessinAnime/dragonball.png";
		String imagePathda137 = "image/dessinAnime/catsEyes.png";
		String imagePathda138 = "image/dessinAnime/pingu.png";
		String imagePathda139 = "image/dessinAnime/boumbo.png";
		String imagePathda140 = "image/dessinAnime/mimiCracra.png";
		String imagePathda141 = "image/dessinAnime/lesGummies.png";
		String imagePathda142 = "image/dessinAnime/astro.png";
		String imagePathda143 = "image/dessinAnime/davyCrockett.png";
		String imagePathda144 = "image/dessinAnime/alvin.png";
		String imagePathda145 = "image/dessinAnime/mask.png";
		String imagePathda146 = "image/dessinAnime/lesPopples.png";
		String imagePathda147 = "image/dessinAnime/lesSnorky.png";
		String imagePathda148 = "image/dessinAnime/cosmocats.png";
		String imagePathda149 = "image/dessinAnime/jem.png";
		String imagePathda150 = "image/dessinAnime/moiRenart.png";
		String imagePathda151 = "image/dessinAnime/muppetsBabies.png";
		String imagePathda152 = "image/dessinAnime/denisLaMalice.png";
		String imagePathda153 = "image/dessinAnime/crocNoteShow.png";
		String imagePathda154 = "image/dessinAnime/lePiaf.png";
		String imagePathda155 = "image/dessinAnime/lesLuxioles.png";
		String imagePathda156 = "image/dessinAnime/ghostbusters.png";
		String imagePathda157 = "image/dessinAnime/victor.png";
		String imagePathda158 = "image/dessinAnime/ieufLaVie.jpg";
		String imagePathda159 = "image/dessinAnime/monPetitPoney.png";
		String imagePathda160 = "image/dessinAnime/lesEwoks.png";
		String imagePathda161 = "image/dessinAnime/princesseSarah.png";
		String imagePathda162 = "image/dessinAnime/lesPetitsMalins.png";
		String imagePathda163 = "image/dessinAnime/jeanneEtSerge.png";
		String imagePathda164 = "image/dessinAnime/rahan.png";
		String imagePathda165 = "image/dessinAnime/tortuesNinja.png";
		String imagePathda166 = "image/dessinAnime/clubBCBG.png";
		String imagePathda167 = "image/dessinAnime/laBandeAPicsou.png";
		String imagePathda168 = "image/dessinAnime/lucile.png";
		String imagePathda169 = "image/dessinAnime/diplodo.png";
//		String imagePathda170 = "image/dessinAnime/XXXXXXXXXXX.png";
		String imagePathda171 = "image/dessinAnime/lesChevaliersDuZodiaque.png";
		String imagePathda172 = "image/dessinAnime/laSagesseDesGnomes.png";
		String imagePathda173 = "image/dessinAnime/georgie.png";
		String imagePathda174 = "image/dessinAnime/lamu.png";
		String imagePathda175 = "image/dessinAnime/ken.png";
		String imagePathda176 = "image/dessinAnime/drSlump.png";
		String imagePathda177 = "image/dessinAnime/oliveEtTom.png";
		String imagePathda178 = "image/dessinAnime/galaxyExpress999.png";
		String imagePathda179 = "image/dessinAnime/petitOursBrun.png";
		String imagePathda180 = "image/dessinAnime/pifEtHercule.png";
		String imagePathda181 = "image/dessinAnime/denver.png";
		String imagePathda182 = "image/dessinAnime/panthereRose.png";
		String imagePathda183 = "image/dessinAnime/dinoRiders.png";
		String imagePathda184 = "image/dessinAnime/rudy.png";
//		String imagePathda185 = "image/dessinAnime/XXXXXXXXXXX.png";
//		String imagePathda186 = "image/dessinAnime/XXXXXXXXXXX.png";
		String imagePathda187 = "image/dessinAnime/collegeFou.png";
		String imagePathda188 = "image/dessinAnime/babar.png";
		String imagePathda189 = "image/dessinAnime/lesSimpson.png";
			
		
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
		Evenement da1 = new Evenement("Nicky Larson", "", imagePathda1, sonPathNull, videoPathda1, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.OCTOBER, 1, 10, 0, 0), null);
		Evenement da2 = new Evenement("Beetlejuice", "", imagePathda2, sonPathNull, videoPathda2, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.OCTOBER, 15, 10, 0, 0), null);
		Evenement da3 = new Evenement("Tifou", "", imagePathda3, sonPathNull, videoPathda3, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.NOVEMBER, 1, 10, 0, 0), null);
		Evenement da4 = new Evenement("Tic et Tac - Les Rangers du Risque", "Les rongeurs du risque", imagePathda4, sonPathNull, videoPathda4, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.NOVEMBER, 15, 10, 0, 0), null);
		Evenement da5 = new Evenement("Manu", "", imagePathda5, sonPathNull, videoPathda5, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.DECEMBER, 1, 10, 0, 0), null);
		Evenement da6 = new Evenement("Max et Compagnie", "", imagePathda6, sonPathNull, videoPathda6, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.DECEMBER, 15, 10, 0, 0), null);
		Evenement da7 = new Evenement("Dragon Ball Z", "", imagePathda7, sonPathNull, videoPathda7, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.DECEMBER, 24, 10, 0, 0), null);
		Evenement da8 = new Evenement("Les Aventures des Tiny Toons", "", imagePathda8, sonPathNull, videoPathda8, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.JANUARY, 26, 10, 0, 0), null);
		Evenement da9 = new Evenement("Doug", "", imagePathda9, sonPathNull, videoPathda9, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da10 = new Evenement("Captain Planet", "Quand l'ecologie était encore fun", imagePathda10, sonPathNull, videoPathda10, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da11 = new Evenement("Les jumeaux du bout du monde", "", imagePathda11, sonPathNull, videoPathda11, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da12 = new Evenement("Samouraï Pizza Cats", "", imagePathda12, sonPathNull, videoPathda12, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.MAY, 1, 10, 0, 0), null);
		Evenement da13 = new Evenement("Les Moomins", "", imagePathda13, sonPathNull, videoPathda13, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.JUNE, 1, 10, 0, 0), null);
		Evenement da14 = new Evenement("Super Baloo", "", imagePathda14, sonPathNull, videoPathda14, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da15 = new Evenement("Super Mario Bros", "Générique de fin : première prise ... Coupez! Elle est bonne!", imagePathda15, sonPathNull, videoPathda15, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.AUGUST, 1, 10, 0, 0), null);
		Evenement da16 = new Evenement("Draculito mon Saigneur", "", imagePathda16, sonPathNull, videoPathda16, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da17 = new Evenement("Myster Mask", "", imagePathda17, sonPathNull, videoPathda17, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da18 = new Evenement("Widget", "", imagePathda18, sonPathNull, videoPathda18, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da19 = new Evenement("Les Aventures de Carlos", "", imagePathda19, sonPathNull, videoPathda19, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da20 = new Evenement("Ranma 1/2", "", imagePathda20, sonPathNull, videoPathda20, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.JUNE, 1, 10, 0, 0), null);
		Evenement da21 = new Evenement("Les Pierrafeu en culottes courtes", "", imagePathda21, sonPathNull, videoPathda21, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da22 = new Evenement("Les Aventures de Tintin", "", imagePathda22, sonPathNull, videoPathda22, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.MAY, 5, 10, 0, 0), null);
		Evenement da23 = new Evenement("Les Razmoket", "", imagePathda23, sonPathNull, videoPathda23, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.OCTOBER, 17, 10, 0, 0), null);
		Evenement da24 = new Evenement("L'Ecole des Champions", "", imagePathda24, sonPathNull, videoPathda24, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.NOVEMBER, 25, 10, 0, 0), null);
		Evenement da25 = new Evenement("La Famille Addams", "", imagePathda25, sonPathNull, videoPathda25, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da26 = new Evenement("Les Aventures de Sonic", "", imagePathda26, sonPathNull, videoPathda26, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da27 = new Evenement("La Bande à Dingo", "", imagePathda27, sonPathNull, videoPathda27, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da28 = new Evenement("Sailor Moon", "", imagePathda28, sonPathNull, videoPathda28, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.MAY, 1, 10, 0, 0), null);
		Evenement da29 = new Evenement("Les Histoires du père Castor", "", imagePathda29, sonPathNull, videoPathda29, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1993, Calendar.APRIL, 22, 10, 0, 0), null);
		Evenement da30 = new Evenement("Il était une fois... les Découvreurs", "", imagePathda30, sonPathNull, videoPathda30, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da31 = new Evenement("Les Pastagums", "", imagePathda31, sonPathNull, videoPathda31, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.FEBRUARY, 1, 10, 0, 0), null);
		Evenement da32 = new Evenement("Les Animaniacs", "", imagePathda32, sonPathNull, videoPathda32, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.MARCH, 1, 10, 0, 0), null);
		Evenement da33 = new Evenement("Zoo Cup", "", imagePathda33, sonPathNull, videoPathda33, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.MAY, 1, 10, 0, 0), null);
		Evenement da34 = new Evenement("Mighty Max", "", imagePathda34, sonPathNull, videoPathda34, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.JUNE, 1, 10, 0, 0), null);
		Evenement da35 = new Evenement("Fly", "", imagePathda35, sonPathNull, videoPathda35, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da36 = new Evenement("Albert le 5ème Mousquetaire", "", imagePathda36, sonPathNull, videoPathda36, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.AUGUST, 1, 10, 0, 0), null);
//		Evenement da37 = new Evenement("Power Rangers", "", imagePathda37, sonPathNull, videoPathda37, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1994, Calendar.APRIL, 13, 10, 0, 0), null);
		Evenement da38 = new Evenement("Iznogoud", "", imagePathda38, sonPathNull, videoPathda38, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1995, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da39 = new Evenement("Gargoyles", "", imagePathda39, sonPathNull, videoPathda39, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1995, Calendar.JULY, 1, 10, 0, 0), null);
		Evenement da40 = new Evenement("Beavis et Butt-Head", "", imagePathda40, sonPathNull, videoPathda40, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1995, Calendar.JANUARY, 14, 10, 0, 0), null);
		Evenement da41 = new Evenement("Minus et Cortex", "", imagePathda41, sonPathNull, videoPathda41, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1996, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da42 = new Evenement("Le Bus Magique", "", imagePathda42, sonPathNull, videoPathda42, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1996, Calendar.APRIL, 1, 10, 0, 0), null);
		Evenement da43 = new Evenement("The Mask", "", imagePathda43, sonPathNull, videoPathda43, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 1, 10, 0, 0), null);
		Evenement da44 = new Evenement("Il était une fois... les Explorateurs", "", imagePathda44, sonPathNull, videoPathda44, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1997, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da45 = new Evenement("Drôles de Monstres", "", imagePathda45, sonPathNull, videoPathda45, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1997, Calendar.SEPTEMBER, 1, 10, 0, 0), null);
		Evenement da46 = new Evenement("South Park", "", imagePathda46, sonPathNull, videoPathda46, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1998, Calendar.JULY, 17, 10, 0, 0), null);
		Evenement da47 = new Evenement("Batman", "", imagePathda47, sonPathNull, videoPathda47, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1992, Calendar.SEPTEMBER, 5, 10, 0, 0), null);
		Evenement da48 = new Evenement("Il était une fois... Les Amériques", "", imagePathda48, sonPathNull, videoPathda48, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1991, Calendar.OCTOBER, 28, 10, 0, 0), null);
		Evenement da49 = new Evenement("Il était une fois... notre Terre", "", imagePathda49, sonPathNull, videoPathda49, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(2008, Calendar.JANUARY, 1, 10, 0, 0), null);
		Evenement da50 = new Evenement("Le retour de Léo", "La version originale pompée par Disney", imagePathda50, sonPathNull, videoPathda50, EvenementTheme.SORTIE_DESSIN_ANIME, DateManager.genereUneDate(1990, Calendar.SEPTEMBER, 17, 10, 0, 0), null);
	
		// Dessins Animes 80 (10 ans)
		// TODO Goldorak? Barbapapa? Creamy?
		Evenement da101 = new Evenement("Il était une fois... l'Homme", "Le générique avec la fin la plus traumatisante de l'Histoire", imagePathda101, sonPathNull, videoPathda101, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1990, Calendar.OCTOBER, 2, 10, 0, 0), null);
		Evenement da102 = new Evenement("Albator", "", imagePathda102, sonPathNull, videoPathda102, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1990, Calendar.DECEMBER, 7, 10, 0, 0), null);
		Evenement da103 = new Evenement("Cocoshaker", "", imagePathda103, sonPathNull, videoPathda103, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da104 = new Evenement("Quick et Flupke", "", imagePathda104, sonPathNull, videoPathda104, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da105 = new Evenement("Capitaine Flam", "", imagePathda105, sonPathNull, videoPathda105, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.JANUARY, 7, 10, 0, 0), null);
		Evenement da106 = new Evenement("Ulysse 31", "", imagePathda106, sonPathNull, videoPathda106, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.OCTOBER, 3, 10, 0, 0), null);
		Evenement da107 = new Evenement("Bouba", "", imagePathda107, sonPathNull, videoPathda107, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1991, Calendar.DECEMBER, 21, 10, 0, 0), null);
		Evenement da108 = new Evenement("Il était une fois... l'Espace", "", imagePathda108, sonPathNull, videoPathda108, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da109 = new Evenement("Belle et Sebastien", "", imagePathda109, sonPathNull, videoPathda109, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.APRIL, 2, 10, 0, 0), null);
		Evenement da110 = new Evenement("Rémi sans famille", "", imagePathda110, sonPathNull, videoPathda110, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.FEBRUARY, 17, 10, 0, 0), null);
		Evenement da111 = new Evenement("Boule et Bill", "", imagePathda111, sonPathNull, videoPathda111, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.MARCH, 4, 10, 0, 0), null);
		Evenement da112 = new Evenement("Tom Sawyer", "", imagePathda112, sonPathNull, videoPathda112, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.DECEMBER, 13, 10, 0, 0), null);
		Evenement da113 = new Evenement("Les Schtroumpfs", "", imagePathda113, sonPathNull, videoPathda113, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1992, Calendar.DECEMBER, 27, 10, 0, 0), null);
		Evenement da114 = new Evenement("Musclor et Les Maîtres de l'Univers", "", imagePathda114, sonPathNull, videoPathda114, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da115 = new Evenement("Les Mystérieuses Cités d'or", "", imagePathda115, sonPathNull, videoPathda115, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.SEPTEMBER, 28, 10, 0, 0), null);
		Evenement da116 = new Evenement("Téléchat", "", imagePathda116, sonPathNull, videoPathda116, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.OCTOBER, 3, 10, 0, 0), null);
		Evenement da117 = new Evenement("Inspecteur Gadget", "", imagePathda117, sonPathNull, videoPathda117, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1993, Calendar.OCTOBER, 24, 10, 0, 0), null);
		Evenement da118 = new Evenement("Gigi", "", imagePathda118, sonPathNull, videoPathda118, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.APRIL, 11, 10, 0, 0), null);
		Evenement da119 = new Evenement("Johan & Pirlouit", "", imagePathda119, sonPathNull, videoPathda119, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.OCTOBER, 10, 10, 0, 0), null);
		Evenement da120 = new Evenement("Les Minipouss", "Le générique ou tu comprends pas les paroles", imagePathda120, sonPathNull, videoPathda120, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.NOVEMBER, 2, 10, 0, 0), null);
		Evenement da121 = new Evenement("Sherlock Holmes", "", imagePathda121, sonPathNull, videoPathda121, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1994, Calendar.NOVEMBER, 4, 10, 0, 0), null);
		Evenement da122 = new Evenement("Décode pas Bunny", "", imagePathda122, sonPathNull, videoPathda122, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da123 = new Evenement("Bibifoc", "Il ne passera pas la canicule de 2003", imagePathda123, sonPathNull, videoPathda123, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da124 = new Evenement("Les Triples", "", imagePathda124, sonPathNull, videoPathda124, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da125 = new Evenement("Les Aventures de Winnie l'Ourson", "", imagePathda125, sonPathNull, videoPathda125, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.JANUARY, 26, 10, 0, 0), null);
		Evenement da126 = new Evenement("Cobra", "", imagePathda126, sonPathNull, videoPathda126, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.FEBRUARY, 20, 10, 0, 0), null);
		Evenement da127 = new Evenement("Pole Position", "", imagePathda127, sonPathNull, videoPathda127, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.MARCH, 27, 10, 0, 0), null);
		Evenement da128 = new Evenement("Bioman", "", imagePathda128, sonPathNull, videoPathda128, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.JULY, 2, 10, 0, 0), null);
//		Evenement da129 = new Evenement("Blondine", "", imagePathda129, sonPathNull, videoPathda129, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 9, 10, 0, 0), null);
		Evenement da130 = new Evenement("Jayce et les Conquérants de la Lumiere", "", imagePathda130, sonPathNull, videoPathda130, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
		Evenement da131 = new Evenement("Les Mondes Engloutis", "", imagePathda131, sonPathNull, videoPathda131, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 17, 10, 0, 0), null);
		Evenement da132 = new Evenement("Alice au pays des Merveilles", "", imagePathda132, sonPathNull, videoPathda132, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.SEPTEMBER, 22, 10, 0, 0), null);
		Evenement da133 = new Evenement("Clementine", "", imagePathda133, sonPathNull, videoPathda133, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.OCTOBER, 2, 10, 0, 0), null);
		Evenement da134 = new Evenement("Les Bisounours", "La naissance de pedobear", imagePathda134, sonPathNull, videoPathda134, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.OCTOBER, 14, 10, 0, 0), null);
		Evenement da135 = new Evenement("Les Entrechats", "", imagePathda135, sonPathNull, videoPathda135, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1995, Calendar.OCTOBER, 15, 10, 0, 0), null);
		Evenement da136 = new Evenement("Dragon Ball", "", imagePathda136, sonPathNull, videoPathda136, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 16, 10, 0, 0), null);
		Evenement da137 = new Evenement("Cat's Eyes", "", imagePathda137, sonPathNull, videoPathda137, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da138 = new Evenement("Pingu", "", imagePathda138, sonPathNull, videoPathda138, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JULY, 2, 10, 0, 0), null);
		Evenement da139 = new Evenement("Boumbo", "La voiture qui sauve les fleurs", imagePathda139, sonPathNull, videoPathda139, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.APRIL, 2, 10, 0, 0), null);
		Evenement da140 = new Evenement("Mimi Cracra", "La p'tite dégeulasse", imagePathda140, sonPathNull, videoPathda140, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.MAY, 2, 10, 0, 0), null);
		Evenement da141 = new Evenement("Les Gummies", "", imagePathda141, sonPathNull, videoPathda141, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JUNE, 2, 10, 0, 0), null);
		Evenement da142 = new Evenement("Astro le Petit Robot", "", imagePathda142, sonPathNull, videoPathda142, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JANUARY, 4, 10, 0, 0), null);
		Evenement da143 = new Evenement("Davy Crockett", "", imagePathda143, sonPathNull, videoPathda143, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.JANUARY, 5, 10, 0, 0), null);
		Evenement da144 = new Evenement("Alvin et les Chipmunks", "", imagePathda144, sonPathNull, videoPathda144, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da145 = new Evenement("MASK", "", imagePathda145, sonPathNull, videoPathda145, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.APRIL, 14, 10, 0, 0), null);
		Evenement da146 = new Evenement("Les Popples", "", imagePathda146, sonPathNull, videoPathda146, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 8, 10, 0, 0), null);
		Evenement da147 = new Evenement("Les Snorkies", "", imagePathda147, sonPathNull, videoPathda147, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
		Evenement da148 = new Evenement("Cosmocats", "", imagePathda148, sonPathNull, videoPathda148, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 12, 10, 0, 0), null);
		Evenement da149 = new Evenement("Jem et les Hologrammes", "", imagePathda149, sonPathNull, videoPathda149, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
		Evenement da150 = new Evenement("Moi Renart", "", imagePathda150, sonPathNull, videoPathda150, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.SEPTEMBER, 20, 10, 0, 0), null);
		Evenement da151 = new Evenement("Les Muppets Babies", "", imagePathda151, sonPathNull, videoPathda151, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.OCTOBER, 26, 10, 0, 0), null);
		Evenement da152 = new Evenement("Denis la Malice", "", imagePathda152, sonPathNull, videoPathda152, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1996, Calendar.NOVEMBER, 5, 10, 0, 0), null);
		Evenement da153 = new Evenement("Le Croc-Note Show", "", imagePathda153, sonPathNull, videoPathda153, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da154 = new Evenement("Le Piaf", "", imagePathda154, sonPathNull, videoPathda154, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da155 = new Evenement("Les Luxioles", "", imagePathda155, sonPathNull, videoPathda155, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da156 = new Evenement("SOS Fantômes", "", imagePathda156, sonPathNull, videoPathda156, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.APRIL, 2, 10, 0, 0), null);
		Evenement da157 = new Evenement("L'Anglais avec Victor", "", imagePathda157, sonPathNull, videoPathda157, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MAY, 2, 10, 0, 0), null);
		Evenement da158 = new Evenement("Il était une fois... la Vie", "", imagePathda158, sonPathNull, videoPathda158, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 15, 10, 0, 0), null);
		Evenement da159 = new Evenement("Mon Petit Poney", "", imagePathda159, sonPathNull, videoPathda159, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 7, 10, 0, 0), null);
		Evenement da160 = new Evenement("Les Ewoks", "", imagePathda160, sonPathNull, videoPathda160, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.JANUARY, 8, 10, 0, 0), null);
		Evenement da161 = new Evenement("Princesse Sarah", "", imagePathda161, sonPathNull, videoPathda161, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MARCH, 15, 10, 0, 0), null);
		Evenement da162 = new Evenement("Les Petits Malins", "", imagePathda162, sonPathNull, videoPathda162, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.MAY, 3, 10, 0, 0), null);
		Evenement da163 = new Evenement("Jeanne et Serge", "", imagePathda163, sonPathNull, videoPathda163, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.AUGUST, 31, 10, 0, 0), null);
		Evenement da164 = new Evenement("Rahan", "", imagePathda164, sonPathNull, videoPathda164, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1997, Calendar.NOVEMBER, 29, 10, 0, 0), null);
		Evenement da165 = new Evenement("Les Tortues Ninja", "", imagePathda165, sonPathNull, videoPathda165, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.FEBRUARY, 2, 10, 0, 0), null);
		Evenement da166 = new Evenement("Club BCBG", "", imagePathda166, sonPathNull, videoPathda166, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 2, 10, 0, 0), null);
		Evenement da167 = new Evenement("La Bande à Picsou", "Deviendra un groupe WhatsApp", imagePathda167, sonPathNull, videoPathda167, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.JANUARY, 2, 10, 0, 0), null);
		Evenement da168 = new Evenement("Lucile, Amour et Rock'n Roll", "", imagePathda168, sonPathNull, videoPathda168, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.JANUARY, 15, 10, 0, 0), null);
		Evenement da169 = new Evenement("Diplodo", "", imagePathda169, sonPathNull, videoPathda169, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 14, 10, 0, 0), null);
//		Evenement da170 = new Evenement("Alf", "", imagePathda170, sonPathNull, videoPathda170, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.MARCH, 18, 10, 0, 0), null);
		Evenement da171 = new Evenement("Les Chevaliers du Zodiaque", "", imagePathda171, sonPathNull, videoPathda171, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.APRIL, 6, 10, 0, 0), null);
		Evenement da172 = new Evenement("La Sagesse des Gnomes", "Les juifs controllent le monde", imagePathda172, sonPathNull, videoPathda172, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.APRIL, 7, 10, 0, 0), null);
		Evenement da173 = new Evenement("Georgie", "", imagePathda173, sonPathNull, videoPathda173, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.AUGUST, 29, 10, 0, 0), null);
		Evenement da174 = new Evenement("Lamu", "", imagePathda174, sonPathNull, videoPathda174, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.AUGUST, 30, 10, 0, 0), null);
		Evenement da175 = new Evenement("Ken le Survivant", "", imagePathda175, sonPathNull, videoPathda175, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.AUGUST, 31, 10, 0, 0), null);
		Evenement da176 = new Evenement("Docteur Slump", "", imagePathda176, sonPathNull, videoPathda176, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 4, 10, 0, 0), null);
		Evenement da177 = new Evenement("Olive et Tom", "", imagePathda177, sonPathNull, videoPathda177, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 6, 10, 0, 0), null);
		Evenement da178 = new Evenement("Galaxy Express 999", "", imagePathda178, sonPathNull, videoPathda178, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 11, 10, 0, 0), null);
		Evenement da179 = new Evenement("Petit Ours Brun", "Petit galopin", imagePathda179, sonPathNull, videoPathda179, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1998, Calendar.SEPTEMBER, 12, 10, 0, 0), null);
		Evenement da180 = new Evenement("Pif et Hercule", "", imagePathda180, sonPathNull, videoPathda180, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.OCTOBER, 9, 10, 0, 0), null);
		Evenement da181 = new Evenement("Denver", "Une paire de lunette et personne n'y voit rien", imagePathda181, sonPathNull, videoPathda181, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.MARCH, 20, 10, 0, 0), null);
		Evenement da182 = new Evenement("La Panthere Rose", "", imagePathda182, sonPathNull, videoPathda182, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.FEBRUARY, 11, 10, 0, 0), null);
		Evenement da183 = new Evenement("Dino-Riders", "", imagePathda183, sonPathNull, videoPathda183, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.APRIL, 26, 10, 0, 0), null);
		Evenement da184 = new Evenement("But pour Rudy", "", imagePathda184, sonPathNull, videoPathda184, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 10, 10, 0, 0), null);
//		Evenement da185 = new Evenement("Gwendoline", "", imagePathda185, sonPathNull, videoPathda185, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 11, 10, 0, 0), null);
//		Evenement da186 = new Evenement("Sous le Signe des Mousquetaires", "", imagePathda186, sonPathNull, videoPathda186, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.SEPTEMBER, 12, 10, 0, 0), null);
		Evenement da187 = new Evenement("Le College Fou, Fou, Fou", "", imagePathda187, sonPathNull, videoPathda187, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.NOVEMBER, 8, 10, 0, 0), null);
		Evenement da188 = new Evenement("Babar", "", imagePathda188, sonPathNull, videoPathda188, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.DECEMBER, 11, 10, 0, 0), null);
		Evenement da189 = new Evenement("Les Simpson", "Le model americain moyen", imagePathda189, sonPathNull, videoPathda189, EvenementTheme.SORTIE_DESSIN_ANIME_10ANS, DateManager.genereUneDate(1999, Calendar.DECEMBER, 17, 10, 0, 0), null);
		
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

		evenements.add(da1);
		evenements.add(da2);
		evenements.add(da3);
		evenements.add(da4);
		evenements.add(da5);
		evenements.add(da6);
		evenements.add(da7);
		evenements.add(da8);
		evenements.add(da9);
		evenements.add(da10);
		evenements.add(da11);
		evenements.add(da12);
		evenements.add(da13);
		evenements.add(da14);
		evenements.add(da15);
		evenements.add(da16);
		evenements.add(da17);
		evenements.add(da18);
		evenements.add(da19);
		evenements.add(da20);
		evenements.add(da21);
		evenements.add(da22);
		evenements.add(da23);
		evenements.add(da24);
		evenements.add(da25);
		evenements.add(da26);
		evenements.add(da27);
		evenements.add(da28);
		evenements.add(da29);
		evenements.add(da30);
		evenements.add(da31);
		evenements.add(da32);
		evenements.add(da33);
		evenements.add(da34);
		evenements.add(da35);
		evenements.add(da36);
//		evenements.add(da37);
		evenements.add(da38);
		evenements.add(da39);
		evenements.add(da40);
		evenements.add(da41);
		evenements.add(da42);
		evenements.add(da43);
		evenements.add(da44);
		evenements.add(da45);
		evenements.add(da46);
		evenements.add(da47);
		evenements.add(da48);
		evenements.add(da49);
		evenements.add(da50);

		evenements.add(da101);
		evenements.add(da102);
		evenements.add(da103);
		evenements.add(da104);
		evenements.add(da105);
		evenements.add(da106);
		evenements.add(da107);
		evenements.add(da108);
		evenements.add(da109);
		evenements.add(da110);
		evenements.add(da111);
		evenements.add(da112);
		evenements.add(da113);
		evenements.add(da114);
		evenements.add(da115);
		evenements.add(da116);
		evenements.add(da117);
		evenements.add(da118);
		evenements.add(da119);
		evenements.add(da120);
		evenements.add(da121);
		evenements.add(da122);
		evenements.add(da123);
		evenements.add(da124);
		evenements.add(da125);
		evenements.add(da126);
		evenements.add(da127);
		evenements.add(da128);
//		evenements.add(da129);
		evenements.add(da130);
		evenements.add(da131);
		evenements.add(da132);
		evenements.add(da133);
		evenements.add(da134);
		evenements.add(da135);
		evenements.add(da136);
		evenements.add(da137);
		evenements.add(da138);
		evenements.add(da139);
		evenements.add(da140);
		evenements.add(da141);
		evenements.add(da142);
		evenements.add(da143);
		evenements.add(da144);
		evenements.add(da145);
		evenements.add(da146);
		evenements.add(da147);
		evenements.add(da148);
		evenements.add(da149);
		evenements.add(da150);
		evenements.add(da151);
		evenements.add(da152);
		evenements.add(da153);
		evenements.add(da154);
		evenements.add(da155);
		evenements.add(da156);
		evenements.add(da157);
		evenements.add(da158);
		evenements.add(da159);
		evenements.add(da160);
		evenements.add(da161);
		evenements.add(da162);
		evenements.add(da163);
		evenements.add(da164);
		evenements.add(da165);
		evenements.add(da166);
		evenements.add(da167);
		evenements.add(da168);
		evenements.add(da169);
//		evenements.add(da170);
		evenements.add(da171);
		evenements.add(da172);
		evenements.add(da173);
		evenements.add(da174);
		evenements.add(da175);
		evenements.add(da176);
		evenements.add(da177);
		evenements.add(da178);
		evenements.add(da179);
		evenements.add(da180);
		evenements.add(da181);
		evenements.add(da182);
		evenements.add(da183);
		evenements.add(da184);
//		evenements.add(da185);
//		evenements.add(da186);
		evenements.add(da187);
		evenements.add(da188);
		evenements.add(da189);
		
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
					String titre = evenement.getTitre();
					
					// 1ere diffusion en france
					if (evenement.getTheme().name().equals(EvenementTheme.SORTIE_DESSIN_ANIME.name())) {
						titre = titre + " - 1ère diffusion en France";
					}
					
					// Pour les 10 ans
					if (evenement.getTheme().name().equals(EvenementTheme.SORTIE_DESSIN_ANIME_10ANS.name())) {
						titre = titre + " - (10 ans)";
					}
					ImageIcon resizeImage = ImageManager.resizeImage(image, Constante.EVENEMENT_IMAGE_DIMENSION_300_300);
					JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), evenement.getInformations(), titre, type, resizeImage);
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
							ImageIcon resizeImage = ImageManager.resizeImage(itemImage, Constante.EVENEMENT_IMAGE_DIMENSION_300_300);
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

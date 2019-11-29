package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.mission.enums.Difficulte;
import modele.quizz.Enigme;
import modele.quizz.Reponse;
import modele.quizz.TypeEnigme;

public class QuizzManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Enigme> enigmesInconnus;
	private List<Enigme> enigmesConnus;
	private List<Enigme> enigmesResolus;

	public void initialise() {

		enigmesInconnus = new ArrayList<Enigme>();
		enigmesConnus = new ArrayList<Enigme>();
		enigmesResolus = new ArrayList<Enigme>();
		
		// Chargement de toutes les enigmes
		
		// Image / Video
		
		String imagePath1 = "image/enigme/ali.png";
		String videoPath1 = "video/Trololo.mp4";
		String question1 = "En mathématique quel est le résultat de l'opération : X = (2 + 2 x 2) ?";
		Reponse reponse11 = new Reponse("2", false);
		Reponse reponse12 = new Reponse("4", false);
		Reponse reponse13 = new Reponse("6", true);
		Reponse reponse14 = new Reponse("8", false);
		List<Reponse> reponsesPossibles1 = new ArrayList<Reponse>();
		reponsesPossibles1.add(reponse11);
		reponsesPossibles1.add(reponse12);
		reponsesPossibles1.add(reponse13);
		reponsesPossibles1.add(reponse14);
		String infoReponse1 = "La multiplication est prioritaire par rapport à l'addition";
		
		String imagePath2 = "image/enigme/ali.png";
		String videoPath2 = "video/Trololo.mp4";
		String question2 = "Quel est le nom de famille de Nicolas ---------------- ------------------- -------------- --------------- ------------ ------- -------- ---------?";
		Reponse reponse21 = new Reponse("Bercot", false);
		Reponse reponse22 = new Reponse("Darmouni", false);
		Reponse reponse23 = new Reponse("Lopez", true);
		Reponse reponse24 = new Reponse("Sermain------------------------------- ---------- --------------- ---------------------- ------------------ ------------ ----------", false);
		List<Reponse> reponsesPossibles2 = new ArrayList<Reponse>();
		reponsesPossibles2.add(reponse21);
		reponsesPossibles2.add(reponse22);
		reponsesPossibles2.add(reponse23);
		reponsesPossibles2.add(reponse24);
		String infoReponse2 = "Comme 50% des espagnols--------- --------- ----------------------- ---------------- --------------- ------------------- ------------- -------------";

		String imagePath3 = "image/enigme/ali.png";
		String videoPath3 = "video/Trololo.mp4";
		String question3 = "Quel est le plus vieil homme connu à avoir découvert l'Amerique en premier ?";
		Reponse reponse31 = new Reponse("Gerard Depardieu", false);
		Reponse reponse32 = new Reponse("Amerigo Vespuci", true);
		Reponse reponse33 = new Reponse("Christophe Colomb", false);
		Reponse reponse34 = new Reponse("Magellan", false);
		List<Reponse> reponsesPossibles3 = new ArrayList<Reponse>();
		reponsesPossibles3.add(reponse31);
		reponsesPossibles3.add(reponse32);
		reponsesPossibles3.add(reponse33);
		reponsesPossibles3.add(reponse34);
		String infoReponse3 = "D'ou le nom Amerique";
		
		// Questions Burger Quizz
		
		// MATH
		// Laquelle de ces affirmations est vraie? Une soustraction peut donner un nombre positif, Une racine carré peut être négative, Deux droites parallèles peuvent se croiser, Un nombre peut être divisé par 0 (En effet : 7-2 = 5)   
		// Combien de fois peut on plier une feuille de papier au maximum? 7?
		
		// Une annee lumiere est une unité de distance? de temps? de vitesse? d'energie? (L'Union astronomique internationale la définit comme la distance parcourue par un photon (ou plus simplement la lumière) dans le vide, en une année julienne (soit 365,25 jours)
		
		// Idees recus / legendes urbaines
		// - Pourquoi le ciel est bleu a cause ? ( de l'Atmosphere, (du Reflet des oceans, du Reflet de l'espace, des nuages)) (Le bleu du ciel est le résultat de la diffusion de la lumière solaire par l'atmosphère. )
		// - Quel est la couleur du soleil? (Blanc aryen, (Jaune poussin, Orange grenadine, Rouge regles) ) (C'est la diffusion des rayons du soleil dans l'atmosphere qui donne la couleur jaune)
		// - La celebre Joconde de Leonard De Vinci est peinte avec : de la peinture a l'huile sur un panneau de bois? (avec de la peinture acrylique sur une toile en soie? avec de la peinture a l'eau sur une toile en chanvre? avec du sperme sur une toile en peau de couille?)
		// - Le pere noel est habillé en rouge a cause de : - de la culture populaire? (de Coca-Cola? de l'Eglise? des Femen) ( Il a d’abord été dessiné par Thomas Nast en 1863, à l'origine en monochrome, puis dans un habit de fourrure de couleur brune. Plusieurs colorations anonymes de ses dessins, vertes, rouges ou bleues, ont commencé à émerger, jusqu’à ce que le rouge devienne majoritaire. Lorsque Coca-Cola commença à l’utiliser dans les années 1930, son image était déjà courante dans les médias et la culture populaire.)
		
		// Faits extraordinaires
		// - Taille du soleil et de la lune vu de la terre
		// - Pourcentage de la masse de la Terre dans le systeme solaire par rapport au soleil (+95%)
		// - Calendrier de l'existence de l'homme a l'echelle de l'univers (31 dec 23h59) un battement de cil a l'echelle cosmique
		// - Vitesse max de la lumiere
		// - Nombre de bacteries dans le corps / dans une cuillere a café de terre
		// - En 2015 Nombre de musulmans (1,8 Milliard) / nombre d'arabes dans le monde (422 millions d'Arabes) (soit 23.44%)
		// - ADN : Similarités avec des especes proches mais differentes (crevette?)
		// - Cleopatre a vecu a une epoque plus proche du telephone que de la construction des pyramides.
		// - Cleopatre etait d'origine : grecque? egyptienne? romaine? gauloise? (Elle appartient à la dynastie d'origine macédonienne des Lagides qui est typiquement grecque et se réclame comme telle)
		// - Le Stégosaure a vécu entre 156 et 140 millions d’années avant notre ère alors que le T-Rex aurait vécu il y a environ 65 à 70 millions d'années. Ce qui rapproche plus le T-Rex de notre ère que de celle du Stégosaure. 
		// - Il y a 1,6 Million de Fourmi pour chaque etre humain
		// - Lorsqu'il saute, Mario casse les blocs avec la main? (tete, pied, moustache)
		// - Pourquoi les ouragans portent ils des noms de personnes ? A cause des politiciens? a cause des religieux? a cause des scientifiques? a cause des femmes? (Les cyclones et les ouragans portent le nom de personnes en raison de Clément Wragge, un météorologue qui utilisait les noms de politiciens qu'il n'aimait pas pour leur signifier qu'ils étaient destructeurs et qu'ils erraient sans but.)
		// - Quel animal a la morsure la plus puissante : crocodile (requin? morse? cachalot?)
		
		// Qu'est-ce que c'est ???
		// Sable au microscope : Pierres precieuses, etre vivants, des mini-bonbons?
		// Carte de jeu nintendo : Créé en 1889 par Fusajiro Yamauchi, Nintendo vendait des cartes à jouer jusqu'en 1970, les hanafuda. C'est ensuite que la société a diversifié ses activités en produisant des jouets et des bornes d’arcade.
		
		// Faim / Soif / Sante / Richesses
		// En 2016, quel pourcentage de la population mondiale détient la moitié des richesses de la planete? : 50%, 60%, 10%, 1% (18,5 millions de foyers detiennent 47% de la richesse en revenus, dépôts bancaires ou titres boursiers. Les 62 personnes les plus riches detiennent plus que les 3,5 milliards les plus pauvres(62/3 500 000 000))
		
		// Politique
		// Quelle personnalité est presente sur la pochette de l'album des Beatlles ()? Aleister Crowley
		
		// Ecologie
		
		// Energies
		
		// Guerres
		// Nombre d'années des etats unis en paix (7/200)
		// Nombre de pays ou les etats unis sont implanté militairement =74/324 (France 10, Royaume Unis 7) (source : https://reseauinternational.net/tous-les-pays-ou-les-etats-unis-ont-une-presence-militaire/)
		
		//Culture générale
		// Les dinosaures ont-ils tous disparus? Oui, tués par un météorite il y a 65 millions d'années - Oui, ... Non,... Non,...
		// Qu'appelle-t-on aujourd'hui une année? la terre fait un tour de soleil? le soleil fait 365,25 tours de Terre? La lune fait 12 tours de Terre? le soleil fait un tour de terre?
		
		// Decouvertes
		// Tesla
		// Homme
		//
		
		enigmesInconnus.add(new Enigme(imagePath1, videoPath1, question1, reponsesPossibles1, infoReponse1, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath2, videoPath2, question2, reponsesPossibles2, infoReponse2, TypeEnigme.PERSO));
		enigmesInconnus.add(new Enigme(imagePath3, videoPath3, question3, reponsesPossibles3, infoReponse3, TypeEnigme.DECOUVERTE));
		
		// TODO Ajouter au moins 60 enigmes
		
	}

	public Enigme getRandomEnigmeDisponible(Difficulte difficulty) {
		
		Enigme enigme = null;
		
		// TODO gestion difficulte
		
		// Gestion rotation enigmes deja poses / deja resolus
		testFinEnigmes(); 
		
		enigme = enigmesInconnus.get(RandomManager.random(0, enigmesInconnus.size()-1));
		
		// Refresh Liste enigmes poses
		enigmesConnus.add(enigme);
		enigmesInconnus.remove(enigme);
		
		return enigme;
	}

	private void testFinEnigmes() {
		// Si toutes les enigmes ont ete poses au moins une fois
		if (enigmesInconnus.isEmpty()) {
			System.out.println("Toutes les enigmes on ete poses au moins une fois");
			// Si il reste des enigmes non resolus 
			if (!enigmesConnus.isEmpty()) {
				// On repose les enigmes non resolus
				System.out.println("On repose les enigmes non resolus");
				enigmesInconnus.addAll(enigmesConnus);
				enigmesConnus.removeAll(enigmesInconnus);
			// Si toutes les enigmes ont ete resolus au moins une fois
			} else {
				// TODO Achievement TOUTE LES ENIGMES RESOLUS => recompenses
				System.out.println("Achievement TOUTE LES ENIGMES RESOLUS");
				// On repose toutes les enigmes
				enigmesInconnus.addAll(enigmesResolus);
				enigmesResolus.removeAll(enigmesInconnus);
			}
		}
	}

	public void refreshEnigme(Enigme enigme, boolean win) {
		// Refresh Liste enigmes resolus
		if (win) {
			enigmesConnus.remove(enigme);
			enigmesResolus.add(enigme);
			testFinEnigmes(); 
		} 
	}

}

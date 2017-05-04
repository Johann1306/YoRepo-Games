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
		String question1 = "Combien fait : (2 + 2 x 2) ?";
		Reponse reponse11 = new Reponse("2", false);
		Reponse reponse12 = new Reponse("4", false);
		Reponse reponse13 = new Reponse("6", true);
		Reponse reponse14 = new Reponse("8", false);
		List<Reponse> reponsesPossibles1 = new ArrayList<Reponse>();
		reponsesPossibles1.add(reponse11);
		reponsesPossibles1.add(reponse12);
		reponsesPossibles1.add(reponse13);
		reponsesPossibles1.add(reponse14);
		String infoReponse1 = "La multiplication l'emporte sur l'addition";
		
		String imagePath2 = "image/enigme/ali.png";
		String videoPath2 = "video/Trololo.mp4";
		String question2 = "Quel est le nom de famille de Nicolas ---------------------------------------?";
		Reponse reponse21 = new Reponse("Bercot", false);
		Reponse reponse22 = new Reponse("Darmouni", false);
		Reponse reponse23 = new Reponse("Lopez", true);
		Reponse reponse24 = new Reponse("Sermain", false);
		List<Reponse> reponsesPossibles2 = new ArrayList<Reponse>();
		reponsesPossibles2.add(reponse21);
		reponsesPossibles2.add(reponse22);
		reponsesPossibles2.add(reponse23);
		reponsesPossibles2.add(reponse24);
		String infoReponse2 = "Comme 50% des espagnols";

		String imagePath3 = "image/enigme/ali.png";
		String videoPath3 = "video/Trololo.mp4";
		String question3 = "Qui a découvert l'Amerique en premier ?";
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
		
		// MATH
		// Laquelle de ces affirmations est vraie? Une soustraction peut donner un nombre positif, Une racine carré peut être négative, Deux droites parallèles peuvent se croiser, Un nombre peut être divisé par 0 (En effet : 7-2 = 5)   
		
		// Faim / Soif / Sante / Richesses
		// En 2016, quel pourcentage de la population mondiale détient la moitié des richesses de la planete? : 50%, 60%, 10%, 1% (18,5 millions de foyers detiennent 47% de la richesse en revenus, dépôts bancaires ou titres boursiers. Les 62 personnes les plus riches detiennent plus que les 3,5 milliards les plus pauvres(62/3 500 000 000))
		
		// Politique
		// Quelle personnalité est presente sur la pochette de l'albulm des Beatlles ()? Aleister Crowley
		
		// Ecologie
		
		// Energies
		
		// Guerres
		// Nombre d'années des etats unis en paix (7/200)
		// Nombre de pays ou les etats unis sont implanté militairement =~150
		
		
		
		// Decouvertes
		// Tesla
		// Homme
		//
		
		enigmesInconnus.add(new Enigme(imagePath1, videoPath1, question1, reponsesPossibles1, infoReponse1, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath2, videoPath2, question2, reponsesPossibles2, infoReponse2, TypeEnigme.PERSO));
		enigmesInconnus.add(new Enigme(imagePath3, videoPath3, question3, reponsesPossibles3, infoReponse3, TypeEnigme.DECOUVERTE));
		
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

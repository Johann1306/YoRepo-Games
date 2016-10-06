package core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modele.item.mission.enums.MissionDifficulty;
import modele.quizz.Enigme;
import modele.quizz.Reponse;
import modele.quizz.TypeEnigme;

public class QuizzManager implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Enigme> enigmesInconnus;
	private List<Enigme> enigmesConnus;
	private List<Enigme> enigmesResolus;
	private int id = 0;

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
		String question3 = "Qui a decouvert l'Amerique ?";
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
		
		enigmesInconnus.add(new Enigme(imagePath1, videoPath1, question1, reponsesPossibles1, infoReponse1, TypeEnigme.ECOLE));
		enigmesInconnus.add(new Enigme(imagePath2, videoPath2, question2, reponsesPossibles2, infoReponse2, TypeEnigme.PERSO));
		enigmesInconnus.add(new Enigme(imagePath3, videoPath3, question3, reponsesPossibles3, infoReponse3, TypeEnigme.DECOUVERTE));
		
	}

	public Enigme getRandomEnigmeDisponible(MissionDifficulty difficulty) {
		
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
				// TODO Achievement TOUTE LES ENIGMES RESOLUS
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

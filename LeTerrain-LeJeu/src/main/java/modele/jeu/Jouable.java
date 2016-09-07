package modele.jeu;

import modele.item.mission.Mission;
import modele.item.personnage.Groupe;

public interface Jouable {

	boolean start(Groupe groupe, Mission mission);
	
}

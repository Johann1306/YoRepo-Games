package modele.jeu;

import modele.item.mission.Mission;
import modele.item.personnage.Groupe;

public interface Jouable {

	void start(Groupe groupe, Mission mission);
	
}

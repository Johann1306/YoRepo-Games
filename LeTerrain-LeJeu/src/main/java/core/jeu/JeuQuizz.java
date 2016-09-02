package core.jeu;

import core.NomJeu;
import modele.item.mission.Mission;
import modele.jeu.Jeu;

public class JeuQuizz extends Jeu {

	public JeuQuizz(NomJeu nomJeu) {
		super(nomJeu);
	}

	@Override
	public boolean start(Mission mission) {
		
		return true;
	}
	
}

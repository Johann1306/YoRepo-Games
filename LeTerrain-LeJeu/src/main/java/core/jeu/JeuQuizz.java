package core.jeu;

import java.io.Serializable;

import core.NomJeu;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.jeu.Jeu;

public class JeuQuizz extends Jeu implements Serializable {

	private static final long serialVersionUID = 1L;

	public JeuQuizz(NomJeu nomJeu) {
		super(nomJeu);
	}

	@Override
	public boolean start(Groupe groupe, Mission mission) {
		
		return true;
	}
	
}

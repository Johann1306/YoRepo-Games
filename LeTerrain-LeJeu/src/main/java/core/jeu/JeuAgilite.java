package core.jeu;

import java.io.Serializable;

import core.NomJeu;
import modele.item.mission.Mission;
import modele.jeu.Jeu;

public class JeuAgilite extends Jeu implements Serializable {

	private static final long serialVersionUID = 1L;

	public JeuAgilite(NomJeu nomJeu) {
		super(nomJeu);
	}
	
	@Override
	public boolean start(Mission mission) {
		
		
		return true;
	}
}

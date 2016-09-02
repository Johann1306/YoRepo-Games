package modele.jeu;

import core.NomJeu;
import modele.item.mission.Mission;

public class Jeu implements Jouable {
	
	private NomJeu nomJeu;

	public Jeu(NomJeu nomJeu) {
		this.nomJeu = nomJeu;
	}

	public NomJeu getNomJeu() {
		return nomJeu;
	}

	public boolean start(Mission mission) {
		return true;
	}

}

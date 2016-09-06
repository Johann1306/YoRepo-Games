package modele.jeu;

import java.io.Serializable;

import core.NomJeu;
import modele.item.mission.Mission;

public class Jeu implements Jouable, Serializable {
	
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

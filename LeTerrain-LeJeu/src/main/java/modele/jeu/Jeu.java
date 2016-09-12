package modele.jeu;

import java.io.Serializable;

import core.NomJeu;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;

public class Jeu implements Jouable, Serializable {
	
	private NomJeu nomJeu;

	public Jeu(NomJeu nomJeu) {
		this.nomJeu = nomJeu;
	}

	public NomJeu getNomJeu() {
		return nomJeu;
	}

	public void start(Groupe groupe, Mission mission) {
		
	}

}

package core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import core.jeu.JeuAgilite;
import core.jeu.JeuCombat;
import core.jeu.JeuQuizz;
import core.jeu.JeuRandom;
import front.MenuPrincipal;
import modele.item.mission.Mission;
import modele.item.personnage.Groupe;
import modele.jeu.Jeu;

public class JeuManager implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Map<NomJeu,Jeu> jeux;  
	
	public void initialise() {
	
		// Chargement de tous les jeux
		jeux = new HashMap<NomJeu, Jeu>();
		
		Jeu jeuRandom = new JeuRandom(NomJeu.JEU_RANDOM);
		Jeu jeuQuizz = new JeuQuizz(NomJeu.JEU_QUIZZ);
		Jeu jeuAgilite = new JeuAgilite(NomJeu.JEU_AGILITE);
		Jeu jeuCombat = new JeuCombat(NomJeu.JEU_COMBAT);
		// JEU_BILLE

		jeux.put(NomJeu.JEU_RANDOM, jeuRandom);
		jeux.put(NomJeu.JEU_QUIZZ, jeuQuizz);
		jeux.put(NomJeu.JEU_AGILITE, jeuAgilite);
		jeux.put(NomJeu.JEU_COMBAT, jeuCombat);
	}
	
	public Jeu getJeu(NomJeu nomJeu) {
		return jeux.get(nomJeu);
	}

	public static boolean lanceJeu(Jeu jeu, Mission mission) {
		Groupe leGroupe = MenuPrincipal.getMainFrame().getCoreManager().getPersonnageManager().getLeGroupe();
		return jeu.start(leGroupe, mission);
	}

}

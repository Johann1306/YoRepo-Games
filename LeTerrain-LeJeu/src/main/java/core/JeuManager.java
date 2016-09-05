package core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import core.jeu.JeuAgilite;
import core.jeu.JeuQuizz;
import core.jeu.JeuRandom;
import front.MainFrame;
import modele.item.mission.Mission;
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
		// JEU_BILLE

		jeux.put(NomJeu.JEU_RANDOM, jeuRandom);
		jeux.put(NomJeu.JEU_QUIZZ, jeuQuizz);
		jeux.put(NomJeu.JEU_AGILITE, jeuAgilite);
	}
	
	public Jeu getJeu(NomJeu nomJeu) {
		return jeux.get(nomJeu);
	}

	public static boolean lanceJeu(Jeu jeu, Mission mission) {
		boolean win = jeu.start(mission);
		if (win) {
			JOptionPane.showMessageDialog(MainFrame.getPanelCentre().getParent(), mission.getInformations() + "/nMission réussie!" + mission.getProprietaire().name(), mission.getNom(), 0, new ImageIcon(mission.getImagePaths().get(0)));
		} else {
			
		}
		return win;
	}

}
